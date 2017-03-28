package cn.xuemengzihe.sylu.ces.pojo.web;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>通过Excel导入学生信息的导入结果</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月28日 下午3:31:38
 */
public class ImportStudentByExcelResult {
	private int sheetNumber; // 工作表数量
	private int totalRows; // 总记录数
	private int successRows; // 成功插入的记录数
	private int failedRows; // 插入失败的记录数
	private List<String> causes; // 失败的原因

	public int getSheetNumber() {
		return sheetNumber;
	}

	public void setSheetNumber(int sheetNumber) {
		this.sheetNumber = sheetNumber;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getSuccessRows() {
		return successRows;
	}

	public void setSuccessRows(int successRows) {
		this.successRows = successRows;
	}

	public int getFailedRows() {
		return failedRows;
	}

	public void setFailedRows(int failedRows) {
		this.failedRows = failedRows;
	}

	public List<String> getCauses() {
		return causes;
	}

	public void setCauses(String cause) {
		if (this.causes == null) {
			this.causes = new ArrayList<>();
		}
		this.causes.add(cause);
	}

	@Override
	public String toString() {
		return "ImportStudentByExcelResult [sheetNumber=" + sheetNumber
				+ ", totalRows=" + totalRows + ", successRows=" + successRows
				+ ", failedRows=" + failedRows + "]";
	}

}
