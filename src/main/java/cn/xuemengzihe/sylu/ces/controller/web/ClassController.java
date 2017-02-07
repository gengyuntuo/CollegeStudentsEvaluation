package cn.xuemengzihe.sylu.ces.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xuemengzihe.sylu.ces.pojo.com.Clazz;
import cn.xuemengzihe.sylu.ces.service.web.ClassService;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Class Controller</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月5日 上午11:13:06
 */
@Controller
public class ClassController {
	@Autowired
	private ClassService classService;

	@RequestMapping("/classInfo")
	public String majorInfo(Model model) {
		PageInfo<Clazz> pageInfo = classService.findClazzsOfPage(null);
		model.addAttribute("pageInfo", pageInfo);
		return "/class/classInfo";
	}

	@RequestMapping("/classList")
	public String majorList(Model model) {
		PageInfo<Clazz> pageInfo = classService.findClazzsOfPage(null);
		model.addAttribute("pageInfo", pageInfo);
		return "/class/classList";
	}
}
