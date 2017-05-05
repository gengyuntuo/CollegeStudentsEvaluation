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
	private Double pingJunXueFenJiDian; // 平均学分绩点

	private String isValid;
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

	public Double getPingJunXueFenJiDian() {
		return pingJunXueFenJiDian;
	}

	public void setPingJunXueFenJiDian(Double pingJunXueFenJiDian) {
		this.pingJunXueFenJiDian = pingJunXueFenJiDian;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
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

	/**
	 * 获取日常行为得分
	 * 
	 * @return
	 */
	public Double getRCXWScore() {
		if (tableSZXFXWBF != null) {
			return tableSZXFXWBF.getScore();
		} else {
			return 0.;
		}
	}

	/**
	 * 获取素质活动得分
	 * 
	 * @return
	 */
	public Double getSZHDScore() {
		if (tableSZJYJF != null) {
			return tableSZJYJF.getScore();
		} else {
			return 0.;
		}
	}

	/**
	 * 获取素质学分合计
	 * 
	 * @return
	 */
	public Double getSZXFTotalScore() {
		if (tableSZXFXWBF != null && tableSZJYJF != null) {
			return tableSZXFXWBF.getScore() + tableSZJYJF.getScore();
		} else {
			return 0.;
		}
	}

	/**
	 * 素质学分绩点
	 * 
	 * @return
	 */
	public Double getSZXFScorePoint() {
		if (tableSZXFXWBF != null && tableSZJYJF != null) {
			Double score = (tableSZXFXWBF.getScore() + tableSZJYJF.getScore() - 50) / 10;
			return score < 0 ? 0 : score;
		} else {
			return 0.;
		}
	}

	/**
	 * 综合测评成绩
	 * 
	 * @return
	 */
	public Double getScore() {
		Double score = pingJunXueFenJiDian * 0.8 + this.getSZXFScorePoint()
				* 0.2;
		return score < 0 ? 0 : score;
	}

	@Override
	public String toString() {
		return "TableZHCPCJTJ [id=" + id + ", sno=" + sno + ", termId="
				+ termId + ", pingJunXueFenJiDian=" + pingJunXueFenJiDian
				+ ", isValid=" + isValid + ", cTime=" + cTime + ", uTime="
				+ uTime + ", student=" + student + ", tableSZXFXWBF="
				+ tableSZXFXWBF + ", tableSZJYJF=" + tableSZJYJF + "]";
	}

}
