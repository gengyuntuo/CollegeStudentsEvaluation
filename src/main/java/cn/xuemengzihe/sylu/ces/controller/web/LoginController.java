package cn.xuemengzihe.sylu.ces.controller.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xuemengzihe.sylu.ces.pojo.com.Persion;
import cn.xuemengzihe.sylu.ces.service.web.StudentService;
import cn.xuemengzihe.sylu.ces.service.web.TeacherService;

/**
 * <h1>登录 Controller</h1>
 * <p>
 * 处理登录和注销操作
 * </p>
 * 
 * @author 李春
 * @time 2017年3月30日 下午2:31:15
 */
@Controller
public class LoginController {
	private final Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	/**
	 * 管理员
	 */
	public static final int ROLE_ADMIN = 1;
	/**
	 * 教师
	 */
	public static final int ROLE_TEACHER = 2;
	/**
	 * 学生
	 */
	public static final int ROLE_STUDENT = 3;

	/**
	 * Cookie名称：记住登录状态的ID（构成：用户 id）
	 */
	public static final String REMEMBERID_TAG_NAME = "rememberId";
	/**
	 * Cookie名称：记住登录状态的角色其取值（{@link #ROLE_ADMIN},{@link #ROLE_STUDENT},
	 * {@link #ROLE_TEACHER}）
	 */
	public static final String REMEMBERROLE_TAG_NAME = "rememberRole";

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private StudentService studentService;

	/**
	 * 登录
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @param userName
	 *            用户名
	 * @param password
	 *            用户密码
	 * @param remember
	 *            记住登录状态
	 * @param role
	 *            登录角色，其取值（{@link #ROLE_ADMIN},{@link #ROLE_STUDENT},
	 *            {@link #ROLE_TEACHER}）
	 * @param page
	 *            在登录前请求的页面，登录后自动跳转到该页面
	 * @return
	 */
	@RequestMapping(value = "login")
	public String login(HttpServletRequest request,
			HttpServletResponse response, String userName, String password,
			String remember, Integer role, String page) {
		if (userName == null || password == null || userName.trim().isEmpty()
				|| password.trim().isEmpty()) // 如果请求参数不完整将直接返回登录页面
			return "/login/login";
		HttpSession session = request.getSession(true);
		Persion user = null; // 登录的用户
		Cookie cookie = null; // Cookie

		// TODO 对密码进行验证前需要对密码进行加密，保证用户信息的安全

		switch (role) {
		case ROLE_ADMIN:
			user = teacherService.loginVerify(userName, password);
			break;
		case ROLE_TEACHER:
			user = teacherService.loginVerify(userName, password);
			break;
		case ROLE_STUDENT:
			user = studentService.loginVerify(userName, password);
			break;
		}

		// 登录成功
		if (user != null) {
			session.setAttribute("user", user);
			if ("true".equals(remember)) { // 用户选择了记住登录状态
				cookie = new Cookie(REMEMBERID_TAG_NAME, user.getId() + "");
				cookie.setMaxAge(3600 * 24 * 10); // 设置10天免登录
				cookie.setPath("/");
				response.addCookie(cookie);
				cookie = new Cookie(REMEMBERROLE_TAG_NAME, role + "");
				cookie.setMaxAge(3600 * 24 * 10); // 设置10天免登录
				cookie.setPath("/");
				response.addCookie(cookie);
			} else {
				cookie = new Cookie(REMEMBERID_TAG_NAME, user.getId() + "");
				cookie.setMaxAge(0); // 删除Cookie
				cookie.setPath("/");
				response.addCookie(cookie);
				cookie = new Cookie(REMEMBERROLE_TAG_NAME, role + "");
				cookie.setMaxAge(0); // 删除Cookie
				cookie.setPath("/");
				response.addCookie(cookie);
			}
			logger.info("Login success by userName and password!");
			return "redirect:/index.do";
		}
		request.setAttribute("tip", "登录失败，用户名或者密码错误！");
		logger.info("Login failed because of userName or password error!");
		return "/login/login";
	}

	/**
	 * 注销
	 * 
	 * @param request
	 *            Request
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		request.getSession(true).invalidate();
		return "redirect:/login.do";
	}
}
