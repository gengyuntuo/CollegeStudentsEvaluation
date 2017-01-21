package cn.xuemengzihe.sylu.ces.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

	/**
	 * 首页
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "/index";
	}

	@RequestMapping("/index.do")
	public String index2() {
		return "/index";
	}
}
