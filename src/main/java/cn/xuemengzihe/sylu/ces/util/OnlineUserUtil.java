package cn.xuemengzihe.sylu.ces.util;

import java.util.ArrayList;
import java.util.List;

import cn.xuemengzihe.sylu.ces.pojo.com.Student;
import cn.xuemengzihe.sylu.ces.pojo.com.Teacher;

/**
 * <h1>工具类： 在线用户</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月6日 下午2:44:16
 */
public class OnlineUserUtil {
	/**
	 * 在线学生
	 */
	private static List<Student> studentList;
	/**
	 * 在线教师
	 */
	private static List<Teacher> teacherList;

	static {
		studentList = new ArrayList<>();
		teacherList = new ArrayList<>();
	}

	// 私有化构造器
	private OnlineUserUtil() {
		super();
	}

	public static List<Student> getStudentList() {
		return studentList;
	}

	public static void setStudentList(List<Student> studentList) {
		OnlineUserUtil.studentList = studentList;
	}

	public static List<Teacher> getTeacherList() {
		return teacherList;
	}

	public static void setTeacherList(List<Teacher> teacherList) {
		OnlineUserUtil.teacherList = teacherList;
	}

}
