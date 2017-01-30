package cn.xuemengzihe.sylu.ces.pojo.com;

/**
 * 素质教育加分申请表
 * 
 * @author 李春
 * @time 2016年10月23日time上午10:30:24
 */
public class TableSuZhiJiaoYuJiaFenShenQing {

	private Integer id;
	private Integer suzhi; // 该记录所依赖的素质加分测评表
	private String name; // 比赛或者职务名称
	private String type; // 类型
	private String time; // 时间
	private String level; // 等级
	private String evidence; // 证据
	private String filePath; // 证明文件的上传文件
	private Double score; // 成绩
	private String isvalid; // 是否有效

	public TableSuZhiJiaoYuJiaFenShenQing() {
	}

	public TableSuZhiJiaoYuJiaFenShenQing(Integer id, Integer suzhi,
			String name, String type, String time, String level,
			String evidence, String filePath, Double score, String isvalid) {
		this.id = id;
		this.setSuzhi(suzhi);
		this.name = name;
		this.type = type;
		this.time = time;
		this.level = level;
		this.evidence = evidence;
		this.filePath = filePath;
		this.score = score;
		this.isvalid = isvalid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSuzhi() {
		return suzhi;
	}

	public void setSuzhi(Integer suzhi) {
		this.suzhi = suzhi;
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

	public String getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}

	@Override
	public String toString() {
		return "TableSuZhiJiaoYuJiaFenShenQing [id=" + id + ", name=" + name
				+ ", type=" + type + ", time=" + time + ", level=" + level
				+ ", evidence=" + evidence + ", filePath=" + filePath
				+ ", score=" + score + ", isvalid=" + isvalid + "]";
	}

}
