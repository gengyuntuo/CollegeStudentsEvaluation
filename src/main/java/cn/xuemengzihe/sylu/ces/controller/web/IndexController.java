package cn.xuemengzihe.sylu.ces.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xuemengzihe.sylu.ces.pojo.com.Persion;
import cn.xuemengzihe.sylu.ces.pojo.com.Student;

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
}
