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
	private Integer majorId; // 专业
	private Integer teacherId; // 负责老师ID
	private Integer studyYear; // 学制
	private Date startYear; // 入学年份

	private String isValid; // 有效？
	private Date cTime;
	private Date uTime;

	private Teacher teacher; // 老师
	private List<Student> students; // 班级学生

	public Clazz() {
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

	public Integer getMajorId() {
		return majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
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
		return "Clazz [id=" + id + ", classId=" + classId + ", majorId="
				+ majorId + ", teacherId=" + teacherId + ", studyYear="
				+ studyYear + ", startYear=" + startYear + ", isValid="
				+ isValid + ", cTime=" + cTime + ", uTime=" + uTime
				+ ", teacher=" + teacher + ", students=" + students + "]";
	}

}
