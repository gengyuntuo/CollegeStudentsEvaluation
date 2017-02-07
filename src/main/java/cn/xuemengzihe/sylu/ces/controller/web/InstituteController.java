package cn.xuemengzihe.sylu.ces.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xuemengzihe.sylu.ces.pojo.com.Institute;
import cn.xuemengzihe.sylu.ces.service.web.InstituteService;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Institute Controller</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年1月31日 下午8:40:53
 */
@Controller
public class InstituteController {
	@Autowired
	private InstituteService instituteService;

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/instituteInfo")
	public String instituteInfo(Model model) {
		// 分页查询记录
		PageInfo<Institute> list = instituteService.findInstitutesOfPage(null);
		// 将数据分装的模型中
		model.addAttribute("list", list);
		// 返回页面
		return "/institute/instituteInfo";
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/instituteList")
	public String instituteList(Model model) {
		// 分页查询记录
		PageInfo<Institute> list = instituteService.findInstitutesOfPage(null);
		// 将数据分装的模型中
		model.addAttribute("list", list);
		// 返回页面
		return "/institute/instituteList";
	}
}
