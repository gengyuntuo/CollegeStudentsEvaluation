package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xuemengzihe.sylu.ces.pojo.com.Clazz;
import cn.xuemengzihe.sylu.ces.pojo.com.Setting;
import cn.xuemengzihe.sylu.ces.pojo.web.ImportStudentByExcelResult;
import cn.xuemengzihe.sylu.ces.service.web.ClassService;
import cn.xuemengzihe.sylu.ces.service.web.ExcelService;
import cn.xuemengzihe.sylu.ces.service.web.SettingService;
import cn.xuemengzihe.sylu.ces.service.web.StudentService;
import cn.xuemengzihe.util.excel.ParseExcelFile;

/**
 * <h1>Excel Service 实现</h1>
 * <p>
 * </p>
 * 
 * @see ExcelService
 * @author 李春
 * @time 2017年3月28日 上午9:11:36
 */
@Service
public class ExcelServiceImpl implements ExcelService {
	private Logger logger = LoggerFactory.getLogger(ExcelServiceImpl.class);

	@Autowired
	private SettingService settingService;
	@Autowired
	private ClassService classService;
	@Autowired
	private StudentService studentService;

	@Override
	public ImportStudentByExcelResult importStudentInfomationFromExcelFile(
			File file) {
		ImportStudentByExcelResult info = new ImportStudentByExcelResult(); // 保存此次插入数据的信息
		ParseExcelFile parser = null;// 创建解析对象
		int sheetCount = 0;// 获取工作表数量
		List<Setting> excelColsToDBColsSettings = null; // Excel文件中列与数据库表中列对应关系的设置集合
		List<String> excelCols = null; // Excel 文件中的列
		try {
			parser = new ParseExcelFile(file);
			sheetCount = parser.getSheetNumber();
			info.setSheetNumber(sheetCount); // 添加工作表信息到Info对象中

			// 从数据库中查询对应的Excel文件工作表中的列和数据库表中列的对应关系
			Map<String, String> conditions = new HashMap<String, String>();
			conditions.put("type", "import-excel");
			conditions.put("owner_type", "CC");
			conditions.put("group", "excel");
			excelColsToDBColsSettings = settingService.findSettings(conditions);

			// 遍历所有的工作表
			for (int i = 0; i < sheetCount; i++) {
				List<Map<String, String>> sheetData = null; // Excel
															// 工作表中的所有数据行的数据
				List<Map<String, String>> databaseData = null; // 将要插入数据库中的数据

				excelCols = parser.getColumnNames(i); // 获取工作表的列名称

				String title = parser.getSheetTitle(i); // 获取工作表中标题
				String classId = title.length() >= 8 ? title.substring(0, 8)
						: null; // 获取8位的班级编号
				Clazz clazz = classService.findClazzByClassId(classId);
				if (clazz == null) {
					logger.error("Can't find the class by given class id of the sheet title");
					logger.error("Sheet index:" + (i + 1) + ", sheet title:"
							+ title);
					logger.error("Cause by: error format of title or a error class id!");
					info.setCauses("第" + (i + 1) + "张工作表" + "获取的工作表标题为" + title
							+ "，该标题格式不合法或者是该班级还没有创建！");
					continue; // 该工作表无法继续解析，进入下一张工作表的解析
				}
				classId = clazz.getId() + "";

				// 校验Excel列中是否缺少某些必须的字段;(这里的必需的含义
				// 是Excel表中必需包括的列，并不是数据库中NOTNULL字段
				Map<String, String> excelToDBMap = new HashMap<>(); // 构建一个Excel表格列到数据库列的映射集合
				for (Setting set : excelColsToDBColsSettings) {
					if (excelCols.contains(set.getSetting())) {// 判断Excel表中是否有该列
						excelToDBMap.put(set.getSetting(), set.getValue());
					} else {
						// 若列不存在，则判断该列是否为必需，若为必需则抛出异常，否则忽略
						if ("N".equals(set.getIsNull())) {
							throw new RuntimeException("Excel中缺少必需的列[工作表序号:"
									+ (i + 1) + ",缺少列:" + set.getSetting()
									+ "]");
						}
					}
				}

				// 获取Excel工作表中的所有数据行的数据
				sheetData = parser.getSheetContent(i);

				// 使用Excel和数据库之间的映射关系构建新的数据集合，这一个过程的
				// 结果是，List<Map<Excel列名, 值>> --> List<Map<数据库列名, 值>>
				databaseData = new ArrayList<>(); // 创建集合
				Map<String, String> rowData = null; // 保存一行的数据
				for (Map<String, String> recored : sheetData) {
					rowData = new HashMap<>();
					for (String key : recored.keySet()) {
						rowData.put(excelToDBMap.get(key), recored.get(key));
					}

					// 这里为所有的学生添加班级，班级字段从工作表的标题中获取
					// 班级字段在数据库表中为必须字段
					rowData.put("classId", classId);

					databaseData.add(rowData);
				}

				// 上面的代码获取了某一张工作表中的所有数据，
				// 接下来将所有的数据保存到数据库中
				for (Map<String, String> data : databaseData) {
					try {
						studentService.insertStudent(data); // 每次插入一条数据，这里没有使用批处理
						info.setSuccessRows(info.getSuccessRows() + 1); // 记录成功个数
					} catch (Exception e) {
						logger.info("insert the data failed!"); // 添加失败
						logger.info("data content:" + data); // 添加失败的列内容
						info.setFailedRows(info.getFailedRows() + 1); // 记录失败个数
					} finally {
						info.setTotalRows(info.getTotalRows() + 1); // 记录总数
					}
				}
			}
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
			info.setCauses(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("a error occur when open a excel file to parse!");
			info.setCauses("您上传的文件格式异常，无法解析！");
			e.printStackTrace();
		} finally {
			// 关闭
			try {
				if (parser != null) {
					parser.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return info; // 返回此次插入数据的信息
	}
}
