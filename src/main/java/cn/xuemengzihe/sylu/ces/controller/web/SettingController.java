package cn.xuemengzihe.sylu.ces.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xuemengzihe.sylu.ces.pojo.com.Setting;
import cn.xuemengzihe.sylu.ces.service.web.SettingService;

/**
 * 
 * <h1></h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年1月29日time下午3:40:41
 */
@Controller
public class SettingController {
	@Autowired
	private SettingService settingService;

	/**
	 * 列出所有的Setting
	 * 
	 * @return
	 */
	@RequestMapping("/listSettings")
	public String listSettings(Model model) {
		List<Setting> list = settingService.findSettingsByType("excel");
		model.addAttribute("list", list);
		return "/setting/settings";
	}

	/**
	 * 添加Setting
	 * 
	 * @return
	 */
	@RequestMapping("/addSetting")
	public String addSetting(Setting setting) {
		settingService.insertSetting(setting);
		return "redirect:/listSettings.do";
	}

	/**
	 * 
	 * @param setting
	 * @return
	 */
	@RequestMapping("/updateSetting")
	public String updateSetting(Setting setting) {
		return "redirect:/listSettings.do";
	}
}
