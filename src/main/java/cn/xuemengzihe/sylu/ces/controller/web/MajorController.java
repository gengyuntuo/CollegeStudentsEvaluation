package cn.xuemengzihe.sylu.ces.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xuemengzihe.sylu.ces.pojo.com.Major;
import cn.xuemengzihe.sylu.ces.service.web.MajorService;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Major Controller</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年1月30日 下午3:08:34
 */
@Controller
public class MajorController {
	@Autowired
	private MajorService majorService;

	@RequestMapping("/majorInfo")
	public String majorInfo(Model model) {
		PageInfo<Major> pageInfo = majorService.findMajorsOfPage(null);
		model.addAttribute("pageInfo", pageInfo);
		return "/major/majorInfo";
	}

	@RequestMapping("/majorList")
	public String majorList(Model model) {
		PageInfo<Major> pageInfo = majorService.findMajorsOfPage(null);
		model.addAttribute("pageInfo", pageInfo);
		return "/major/majorList";
	}
}
