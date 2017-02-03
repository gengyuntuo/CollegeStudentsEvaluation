package cn.xuemengzihe.sylu.ces.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/instituteInfo")
	public String instituteInfo(Model model) {
		return "/institute/instituteInfo";
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/instituteList")
	public String instituteList(Model model) {
		return "/institute/instituteList";
	}
}
