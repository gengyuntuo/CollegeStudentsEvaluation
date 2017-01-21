package cn.xuemengzihe.sylu.ces.pojo.com;

import java.util.Date;
import java.util.List;

/**
 * <h1>专业</h1>
 * <p>
 * 专业
 * </p>
 * 
 * @author 李春
 * @time 2017年1月21日time下午9:48:57
 */
public class Major {
	private Integer id;
	private String mName; // 专业名称
	private String mNumb; // 专业代码
	private Integer instituteId; // 学院ID

	private Character isValid; // 有效？
	private Date cTime;
	private Date uTime;

	private Institute institute; // 学院
	private List<Clazz> clazzs;// 班级集合

	public Major() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmNumb() {
		return mNumb;
	}

	public void setmNumb(String mNumb) {
		this.mNumb = mNumb;
	}

	public Integer getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(Integer instituteId) {
		this.instituteId = instituteId;
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

	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}

	public List<Clazz> getClazzs() {
		return clazzs;
	}

	public void setClazzs(List<Clazz> clazzs) {
		this.clazzs = clazzs;
	}

	@Override
	public String toString() {
		return "Major [id=" + id + ", mName=" + mName + ", mNumb=" + mNumb
				+ ", instituteId=" + instituteId + ", isValid=" + isValid
				+ ", cTime=" + cTime + ", uTime=" + uTime + ", institute="
				+ institute + ", clazzs=" + clazzs + "]";
	}

}
