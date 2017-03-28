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
}
