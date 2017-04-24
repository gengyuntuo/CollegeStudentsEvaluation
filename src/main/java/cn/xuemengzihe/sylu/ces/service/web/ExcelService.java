package cn.xuemengzihe.sylu.ces.service.web;

import java.io.File;

import cn.xuemengzihe.sylu.ces.pojo.web.ImportStudentByExcelResult;
import cn.xuemengzihe.sylu.ces.service.web.impl.ExcelServiceImpl;

/**
 * <h1>Excel Service</h1>
 * <p>
 * </p>
 * 
 * @see ExcelServiceImpl
 * @author 李春
 * @time 2017年3月28日 上午9:10:33
 */
public interface ExcelService {
	/**
	 * 从Excel文件中导入学生信息到数据库中
	 * 
	 * @param file
	 *            Excel文件
	 * @result 返回Excel导入学生信息的结果
	 */
	public ImportStudentByExcelResult importStudentInfomationFromExcelFile(
			File file);

	/**
	 * 导出综合测评成绩统计表
	 * 
	 * @param termId
	 *            测评ID
	 * @param classId
	 *            班级ID
	 * @param sno
	 *            学号
	 * @param order
	 *            排序方式
	 * @param showSignColumn
	 *            显示签字列
	 * @return Excel 文件路径
	 */
	public String exportExcelFileOfZHCPCJTJ(String termId, String classId,
			String order, boolean showSignColumn);

	/**
	 * 导出素质教育加分评分表
	 * 
	 * @param termId
	 *            测评ID
	 * @param classId
	 *            班级ID
	 * @param sno
	 *            学号
	 * @param order
	 *            排序方式
	 * @param showSignColumn
	 *            显示签字列
	 * @return Excel 文件路径
	 */
	public String exportExcelFileOfSZJYJFPF(String termId, String classId,
			String order, boolean showSignColumn);

	/**
	 * 
	 * @return
	 */
	public String exportExcelFileOfSZJYJFSQ();

	/**
	 * 导出素质学分日常行为部分评分表
	 * 
	 * @param termId
	 *            测评ID
	 * @param classId
	 *            班级ID
	 * @param sno
	 *            学号
	 * @param order
	 *            排序方式
	 * @param showSignColumn
	 *            显示签字列
	 * @return Excel 文件路径
	 */
	public String exportExcelFileOfSZXFRCXWBFPF(String termId, String classId,
			String order, boolean showSignColumn);
}
