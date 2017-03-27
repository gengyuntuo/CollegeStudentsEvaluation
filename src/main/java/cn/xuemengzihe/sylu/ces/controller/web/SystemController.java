package cn.xuemengzihe.sylu.ces.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <h1>System Controller</h1>
 * <p>
 * 系统设置
 * </p>
 * 
 * @author 李春
 * @time 2017年2月5日 上午11:11:57
 */
@Controller
public class SystemController {

	/**
	 * 打开系统设置界面
	 * 
	 * @return
	 */
	@RequestMapping("systemSetting")
	public String systemSetting() {
		return "/settting/setting";
	}

}
