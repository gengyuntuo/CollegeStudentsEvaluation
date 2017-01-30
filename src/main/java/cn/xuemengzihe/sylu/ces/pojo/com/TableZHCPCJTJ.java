package cn.xuemengzihe.sylu.ces.pojo.com;

import java.util.Date;

/**
 * 综合测评成绩统计表
 * 
 * @author 李春
 * @time 2016年10月23日time上午10:47:04
 */
public class TableZHCPCJTJ {
	private Integer id;
	private String sno; // 学生的学号
	/**
	 * @see Term
	 */
	private Integer termId; // 该评测表属于的学期
	/**
	 * @see TableSZXFRCXWBFPF
	 */
	private Integer riChangXingWeiId; // 素质学分日常行为部分评分表
	/**
	 * @see TableSZJYJFPF
	 */
	private Integer suZhiHuoDongId; // 素质教育加分评分表
	private Double pingJunXueFenJiDian; // 平均学分绩点

	private Integer isValid;
	private Date cTime;
	private Date uTime;

	private Student student;
	private TableSZXFRCXWBFPF tableSZXFXWBF;
	private TableSZJYJFPF tableSZJYJF;

	public TableZHCPCJTJ() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public Integer getTermId() {
		return termId;
	}

	public void setTermId(Integer termId) {
		this.termId = termId;
	}

	public Integer getRiChangXingWeiId() {
		return riChangXingWeiId;
	}

	public void setRiChangXingWeiId(Integer riChangXingWeiId) {
		this.riChangXingWeiId = riChangXingWeiId;
	}

	public Integer getSuZhiHuoDongId() {
		return suZhiHuoDongId;
	}

	public void setSuZhiHuoDongId(Integer suZhiHuoDongId) {
		this.suZhiHuoDongId = suZhiHuoDongId;
	}

	public Double getPingJunXueFenJiDian() {
		return pingJunXueFenJiDian;
	}

	public void setPingJunXueFenJiDian(Double pingJunXueFenJiDian) {
		this.pingJunXueFenJiDian = pingJunXueFenJiDian;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	public Date getcTime() {
		return cTime;
	}

	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}

	public Date getuTime() {
		return uTime;
	}

	public void setuTime(Date uTime) {
		this.uTime = uTime;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public TableSZXFRCXWBFPF getTableSZXFXWBF() {
		return tableSZXFXWBF;
	}

	public void setTableSZXFXWBF(TableSZXFRCXWBFPF tableSZXFXWBF) {
		this.tableSZXFXWBF = tableSZXFXWBF;
	}

	public TableSZJYJFPF getTableSZJYJF() {
		return tableSZJYJF;
	}

	public void setTableSZJYJF(TableSZJYJFPF tableSZJYJF) {
		this.tableSZJYJF = tableSZJYJF;
	}

	@Override
	public String toString() {
		return "TableZHCPCJTJ [id=" + id + ", sno=" + sno + ", termId="
				+ termId + ", riChangXingWeiId=" + riChangXingWeiId
				+ ", suZhiHuoDongId=" + suZhiHuoDongId
				+ ", pingJunXueFenJiDian=" + pingJunXueFenJiDian + ", isValid="
				+ isValid + ", cTime=" + cTime + ", uTime=" + uTime
				+ ", student=" + student + ", tableSZXFXWBF=" + tableSZXFXWBF
				+ ", tableSZJYJF=" + tableSZJYJF + "]";
	}

}
