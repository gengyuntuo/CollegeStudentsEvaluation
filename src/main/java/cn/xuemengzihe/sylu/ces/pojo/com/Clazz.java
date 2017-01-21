package cn.xuemengzihe.sylu.ces.pojo.com;

import java.util.Date;
import java.util.List;

/**
 * <h1>班级</h1>
 * <p>
 * 班级
 * </p>
 * 
 * @author 李春
 * @time 2017年1月21日time下午9:40:25
 */
public class Clazz {
	private Integer id;
	private String classId; // 班级号
	private Integer major; // 专业
	private Integer teacherId; // 负责老师ID
	private Integer studyYear; // 学制
	private Date startYear; // 入学年份
	private Date stopYear; // 毕业年份

	private Character isValid; // 有效？
	private Date cTime;
	private Date uTime;

	private Teacher teacher; // 老师
	private List<Student> students; // 班级学生

	public Clazz() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public Integer getMajor() {
		return major;
	}

	public void setMajor(Integer major) {
		this.major = major;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getStudyYear() {
		return studyYear;
	}

	public void setStudyYear(Integer studyYear) {
		this.studyYear = studyYear;
	}

	public Date getStartYear() {
		return startYear;
	}

	public void setStartYear(Date startYear) {
		this.startYear = startYear;
	}

	public Date getStopYear() {
		return stopYear;
	}

	public void setStopYear(Date stopYear) {
		this.stopYear = stopYear;
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Clazz [id=" + id + ", classId=" + classId + ", major=" + major
				+ ", teacherId=" + teacherId + ", studyYear=" + studyYear
				+ ", startYear=" + startYear + ", stopYear=" + stopYear
				+ ", isValid=" + isValid + ", cTime=" + cTime + ", uTime="
				+ uTime + ", teacher=" + teacher + ", students=" + students
				+ "]";
	}

}
