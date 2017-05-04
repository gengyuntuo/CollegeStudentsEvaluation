package cn.xuemengzihe.sylu.ces.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xuemengzihe.sylu.ces.pojo.com.Persion;
import cn.xuemengzihe.sylu.ces.pojo.com.Student;
import cn.xuemengzihe.sylu.ces.pojo.com.Teacher;
import cn.xuemengzihe.sylu.ces.service.web.StudentService;
import cn.xuemengzihe.sylu.ces.service.web.TeacherService;

/**
 * <h1>显示主页，及页面导航栏、菜单栏、页脚</h1>
 * <p>
 * 显示主页，及页面导航栏、菜单栏、页脚
 * </p>
 * 
 * @author 李春
 * @创建时间 2017年1月21日 上午10:11:47
 * 
 */
@Controller
public class IndexController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;

	/**
	 * 主页
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model) {
		Persion persion = (Persion) request.getSession().getAttribute("user");
		if (persion instanceof Student) {
			// 学生首页
			return "/index/studentIndex";
		} else if ("T".equals(persion.getUserType())) {
			// 教师首页
			return "/index/teacherIndex";
		} else {
			// 管理员首页
			return "/index/adminIndex";
		}
	}

	/**
	 * 获取个人信息
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/persionInfo")
	public String persionInfo(HttpServletRequest request, Model model) {
		Persion persion = (Persion) request.getSession().getAttribute("user");
		if (persion instanceof Student) {
			return "/other/studentInfo";
		} else {
			return "/other/teacherInfo";
		}
	}

	/**
	 * 跟新个人信息
	 * 
	 * @param request
	 * @param model
	 * @param student
	 *            学生
	 * @param teacher
	 *            教师
	 * @return
	 */
	@RequestMapping("/updatePersionInfo")
	public String updatePersionInfo(HttpServletRequest request, Model model,
			Student student, Teacher teacher) {
		Persion persion = (Persion) request.getSession().getAttribute("user");
		if (persion instanceof Student) {
			// TODO 学生参数校验
			student.setId(persion.getId()); // ID
			student.setPortrait(persion.getPortrait()); // 禁止修改头像
			student.setRole(persion.getRole()); // 禁止学生自行修改身份
			studentService.updateStudent(student);
		} else {
			// TODO 教师参数校验
			teacher.setId(persion.getId());
			teacher.setPortrait(persion.getPortrait()); // 禁止修改头像
			teacher.setUserType(persion.getUserType()); // 禁止教师自行修改身份
			teacherService.updateTeacher(teacher);
		}
		return "redirect:/persionInfo.do";
	}
}
