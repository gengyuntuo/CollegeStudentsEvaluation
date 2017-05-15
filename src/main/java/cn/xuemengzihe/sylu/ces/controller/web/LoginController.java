package cn.xuemengzihe.sylu.ces.controller.web;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xuemengzihe.sylu.ces.pojo.com.Persion;
import cn.xuemengzihe.sylu.ces.service.web.RedisService;
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
	public static final String ROLE_ADMIN = "1";
	/**
	 * 教师
	 */
	public static final String ROLE_TEACHER = "2";
	/**
	 * 学生
	 */
	public static final String ROLE_STUDENT = "3";

	/**
	 * Cookie名称：保存登录状态信息，该值为key，实际值保存在Redis库中<br/>
	 * Redis 库中该key对应的值为（用户ID,用户角色）<br/>
	 * 用户角色取值:（{@link #ROLE_ADMIN},{@link #ROLE_STUDENT}, {@link #ROLE_TEACHER}）
	 */
	public static final String REMEMBERROLE_TAG = "loginInfo";
	@Autowired
	private RedisService redisService;

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
			HttpServletResponse response, Model model, String userName,
			String password, String remember, String role, String reqURL) {
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
			// 管理员也在数据库中也是教师表的记录，但是管理员的user_type字段为A
			// 这里验证当前的老师是否为管理员
			if (user == null || !"A".equals(user.getUserType())) {
				user = null;
			}
			break;
		case ROLE_TEACHER:
			user = teacherService.loginVerify(userName, password);
			break;
		case ROLE_STUDENT:
			user = studentService.loginVerify(userName, password);
			break;
		}

		// 登录成功，如果要保存登录状态，则设置Cookie，否则删除Cookie（必须）
		if (user != null) {
			session.setAttribute("user", user);
			String loginInfo = user.getId() + "," + role;
			try {
				String key = session.getId()
						+ UUID.randomUUID().toString().replace("-", "");
				redisService.putValue(key, loginInfo, 3600 * 24 * 10);
				loginInfo = key;
			} catch (Exception e) {
				logger.warn("系统连接Redis数据库失败，将采用明文保存登录状态（不推荐）");
			}
			if ("true".equals(remember)) { // 用户选择了记住登录状态
				cookie = new Cookie(REMEMBERROLE_TAG, loginInfo);
				cookie.setMaxAge(3600 * 24 * 10); // 设置10天免登录
				cookie.setPath("/");
				response.addCookie(cookie);
			} else {
				cookie = new Cookie(REMEMBERROLE_TAG, role + "");
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
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		// 使Session过期
		request.getSession(true).invalidate();

		// 删除Cookie
		Cookie cookie = null;
		cookie = new Cookie(REMEMBERROLE_TAG, "");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);

		// 跳转到登录页面
		return "redirect:/login.do";
	}
}
