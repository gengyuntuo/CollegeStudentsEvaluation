package cn.xuemengzihe.sylu.ces.pojo.com;

import java.util.Date;

/**
 * <h1>学期</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年1月30日 下午10:00:08
 */
public class Term {
	private Integer id; // ID
	private String name; // 学期名称
	private String desc; // 学期说明
	private Date startDate; // 学期开始日期
	private Date stopDate; // 学期结束日期

	private Character isValid; // 有效？
	private Date cTime;
	private Date uTime;

	public Term() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Character getIsValid() {
		return isValid;
	}

	public void setIsValid(Character isValid) {
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
		return "Term [id=" + id + ", name=" + name + ", startDate=" + startDate
				+ ", stopDate=" + stopDate + ", isValid=" + isValid
				+ ", cTime=" + cTime + ", uTime=" + uTime + "]";
	}

}
