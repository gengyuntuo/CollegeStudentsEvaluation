package cn.xuemengzihe.sylu.ces.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xuemengzihe.sylu.ces.pojo.com.Teacher;
import cn.xuemengzihe.sylu.ces.service.web.TeacherService;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Teacher Controller</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月5日 上午11:11:37
 */
@Controller
public class TeacherController {
	@Autowired
	private TeacherService teacherService;

	@RequestMapping("/teacherInfo")
	public String teacherInfo(Model model) {
		PageInfo<Teacher> pageInfo = teacherService.findTeachersOfPage(null);
		model.addAttribute("pageInfo", pageInfo);
		return "/teacher/teacherInfo";
	}

	@RequestMapping("/teacherList")
	public String teacherList(Model model) {
		PageInfo<Teacher> pageInfo = teacherService.findTeachersOfPage(null);
		model.addAttribute("pageInfo", pageInfo);
		return "/teacher/teacherList";
	}
}
