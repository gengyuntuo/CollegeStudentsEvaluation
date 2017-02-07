package cn.xuemengzihe.sylu.ces.pojo.com;

import java.util.Date;
import java.util.List;

/**
 * <h1>学院</h1>
 * <p>
 * 学院
 * </p>
 * 
 * @author 李春
 * @time 2017年1月21日time下午9:47:29
 */
public class Institute {
	private Integer id;
	private String iNumb; // 学院编号
	private String iName; // 学院名称
	private String desc; // 学院说明

	private Character isValid; // 有效？
	private Date cTime; // 创建时间
	private Date uTime; // 更新时间

	private List<Major> majors; // 专业

	public Institute() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getiNumb() {
		return iNumb;
	}

	public void setiNumb(String iNumb) {
		this.iNumb = iNumb;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

	@Override
	public String toString() {
		return "Institute [id=" + id + ", iNumb=" + iNumb + ", iName=" + iName
				+ ", desc=" + desc + ", isValid=" + isValid + ", cTime="
				+ cTime + ", uTime=" + uTime + ", majors=" + majors + "]";
	}

}
