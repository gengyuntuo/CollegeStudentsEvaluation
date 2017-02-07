package cn.xuemengzihe.sylu.ces.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xuemengzihe.sylu.ces.pojo.com.Student;
import cn.xuemengzihe.sylu.ces.service.web.StudentService;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Student Controller</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月5日 上午11:12:13
 */
@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping("/studentInfo")
	public String studentInfo(Model model) {
		PageInfo<Student> pageInfo = studentService.findStudentsOfPage(null);
		model.addAttribute("pageInfo", pageInfo);
		return "/student/studentInfo";
	}

	@RequestMapping("/studentList")
	public String studentList(Model model) {
		PageInfo<Student> pageInfo = studentService.findStudentsOfPage(null);
		model.addAttribute("pageInfo", pageInfo);
		return "/student/studentList";
	}
}
