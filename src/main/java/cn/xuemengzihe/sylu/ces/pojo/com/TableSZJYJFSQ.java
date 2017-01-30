package cn.xuemengzihe.sylu.ces.pojo.com;

import java.util.Date;

/**
 * 素质教育加分申请表
 * 
 * @author 李春
 * @time 2016年10月23日time上午10:30:24
 */
public class TableSZJYJFSQ {

	private Integer id;
	private Integer suZhi; // 该记录所依赖的素质加分测评表
	private String name; // 比赛或者职务名称
	private String type; // 类型
	private String time; // 时间
	private String level; // 等级
	private String evidence; // 证据
	private String filePath; // 证明文件的上传文件
	private Double score; // 成绩
	private String isValid; // 是否有效
	private Date cTime;
	private Date uTime;

	public TableSZJYJFSQ() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSuZhi() {
		return suZhi;
	}

	public void setSuZhi(Integer suZhi) {
		this.suZhi = suZhi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getEvidence() {
		return evidence;
	}

	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
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

	@Override
	public String toString() {
		return "TableSZJYJFSQ [id=" + id + ", suZhi=" + suZhi + ", name="
				+ name + ", type=" + type + ", time=" + time + ", level="
				+ level + ", evidence=" + evidence + ", filePath=" + filePath
				+ ", score=" + score + ", isValid=" + isValid + ", cTime="
				+ cTime + ", uTime=" + uTime + "]";
	}

}
