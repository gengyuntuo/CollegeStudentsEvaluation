package cn.xuemengzihe.sylu.ces.pojo.com;

/**
 * 综合测评成绩统计表
 * 
 * @author 李春
 * @time 2016年10月23日time上午10:47:04
 */
public class TableZongHeCePingChengJiTongJi {
	private Integer id;
	private String sno; // 学生的学号
	private Integer xueqi; // 该评测表属于的学期
	private Integer richangxingwei; // 素质学分日常行为部分评分表
									// TableSuZhiXueFenRiChangXingWeiBuFenPingFen
	private Integer suzhihuodong; // 素质教育加分评分表 TableSuZhiJiaoYuJiaFenPingFen
	private Double pingjunxuefenjidian; // 平均学分绩点
	private Integer isvalid;

	private Student student;
	private TableSuZhiXueFenRiChangXingWeiBuFenPingFen tableSZXFXWBF;
	private TableSuZhiJiaoYuJiaFenPingFen tableSZJYJF;

	public TableZongHeCePingChengJiTongJi() {
	}

	public TableZongHeCePingChengJiTongJi(Integer id, String sno,
			Integer xueqi, Integer richangxingwei, Integer suzhihuodong,
			Double pingjunxuefenjidian, Integer isvalid) {
		super();
		this.id = id;
		this.sno = sno;
		this.xueqi = xueqi;
		this.richangxingwei = richangxingwei;
		this.suzhihuodong = suzhihuodong;
		this.pingjunxuefenjidian = pingjunxuefenjidian;
		this.isvalid = isvalid;
	}

	/**
	 * 素质学分绩点
	 * 
	 * @return
	 */
	public Double getSuzhixuefenjidian() {
		double score = 0.0;
		score = tableSZXFXWBF.getTotal() + tableSZJYJF.getTotal();
		score -= 50;
		score /= 10;
		if (score < 0)
			score = 0.0;
		return score;
	}

	/**
	 * 获取最终成绩
	 * 
	 * @return
	 */
	public Double getTotal() {
		double total = 0.0;
		total = getSuzhixuefenjidian() * 0.2 + this.pingjunxuefenjidian * 0.8;
		if (total < 0)
			total = 0.0;
		return total;
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

	public Integer getXueqi() {
		return xueqi;
	}

	public void setXueqi(Integer xueqi) {
		this.xueqi = xueqi;
	}

	public Integer getRichangxingwei() {
		return richangxingwei;
	}

	public void setRichangxingwei(Integer richangxingwei) {
		this.richangxingwei = richangxingwei;
	}

	public Integer getSuzhihuodong() {
		return suzhihuodong;
	}

	public void setSuzhihuodong(Integer suzhihuodong) {
		this.suzhihuodong = suzhihuodong;
	}

	public Double getPingjunxuefenjidian() {
		return pingjunxuefenjidian;
	}

	public void setPingjunxuefenjidian(Double pingjunxuefenjidian) {
		this.pingjunxuefenjidian = pingjunxuefenjidian;
	}

	public Integer getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public TableSuZhiXueFenRiChangXingWeiBuFenPingFen getTableSZXFXWBF() {
		return tableSZXFXWBF;
	}

	public void setTableSZXFXWBF(
			TableSuZhiXueFenRiChangXingWeiBuFenPingFen tableSZXFXWBF) {
		this.tableSZXFXWBF = tableSZXFXWBF;
	}

	public TableSuZhiJiaoYuJiaFenPingFen getTableSZJYJF() {
		return tableSZJYJF;
	}

	public void setTableSZJYJF(TableSuZhiJiaoYuJiaFenPingFen tableSZJYJF) {
		this.tableSZJYJF = tableSZJYJF;
	}

	@Override
	public String toString() {
		return "TableZongHeCePingChengJiTongJi [id=" + id + ", sno=" + sno
				+ ", xueqi=" + xueqi + ", richangxingwei=" + richangxingwei
				+ ", suzhihuodong=" + suzhihuodong + ", pingjunxuefenjidian="
				+ pingjunxuefenjidian + ", isvalid=" + isvalid + ", student="
				+ student + ", tableSZXFXWBF=" + tableSZXFXWBF
				+ ", tableSZJYJF=" + tableSZJYJF + "]";
	}

}
