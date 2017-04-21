package cn.xuemengzihe.sylu.ces.pojo.com;

import java.util.Date;
import java.util.List;

/**
 * <h1>学期</h1>
 * <p>
 * 成绩统计学期，每个班级每个学期对应一条记录
 * </p>
 * 
 * @author 李春
 * @time 2017年1月30日 下午10:00:08
 */
public class Term {
	private Integer id; // ID
	private String name; // 学期名称
	private Integer teacherId; // 教师的ID
	private String desc; // 学期说明
	private Date startDate; // 成绩统计开始日期
	private Date stopDate; // 成绩统计结束日期

	private String isValid; // 有效？
	private Date cTime;
	private Date uTime;

	// 集合
	private List<TermClass> classes;
	private List<Clazz> clazzes;

	public Term() {
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

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStopDate() {
		return stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
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

	public List<TermClass> getClasses() {
		return classes;
	}

	public void setClasses(List<TermClass> classes) {
		this.classes = classes;
	}

	public List<Clazz> getClazzes() {
		return clazzes;
	}

	public void setClazzes(List<Clazz> clazzes) {
		this.clazzes = clazzes;
	}

	@Override
	public String toString() {
		return "Term [id=" + id + ", name=" + name + ", teacherId=" + teacherId
				+ ", desc=" + desc + ", startDate=" + startDate + ", stopDate="
				+ stopDate + ", isValid=" + isValid + ", cTime=" + cTime
				+ ", uTime=" + uTime + ", classes=" + classes + ", clazzes="
				+ clazzes + "]";
	}

}
