package cn.xuemengzihe.sylu.ces.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.xuemengzihe.sylu.ces.controller.web.LoginController;
import cn.xuemengzihe.sylu.ces.pojo.com.Persion;
import cn.xuemengzihe.sylu.ces.service.web.RedisService;
import cn.xuemengzihe.sylu.ces.service.web.StudentService;
import cn.xuemengzihe.sylu.ces.service.web.TeacherService;
import cn.xuemengzihe.sylu.ces.util.Base64Util;

/**
 * <h1>登录拦截器</h1>
 * <p>
 * 检查用户的登录状态，未登录的情况下重定向到登录页面
 * </p>
 * 
 * @author 李春
 * @time 2017年1月30日 下午2:51:21
 */
public class LoginInterceptor implements HandlerInterceptor {
	private final Logger logger = LoggerFactory
			.getLogger(LoginInterceptor.class);

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private RedisService redisService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(true);
		Persion user = (Persion) session.getAttribute("user");
		// 检查Session中是否存在Perison对象，如果存在Persion对象则证明用户已经登录
		if (user == null) {
			// Session中不存在Persion对象，进一步
			// 检查Cookie，查询浏览器是否设置过保存登录状态
			// 如果有保存过登录记录，则根据记录恢复原有的登录状态
			// 获取Cookie中的登录信息（登录信息的Key：loginInfo，value:UUID+登录时间，
			// 程序从Redis库中将登录信息依据value检索出来）
			String cookieLogin = null;
			if (request.getCookies() != null)
				for (Cookie cookie : request.getCookies()) {
					if (LoginController.REMEMBERROLE_TAG.equals(//
							cookie.getName())) {
						cookieLogin = cookie.getValue();
						break;
					}
				}

			// 如果Cookie中存在保存的登录信息，则验证Cookie
			if (cookieLogin != null && !cookieLogin.trim().isEmpty()) {
				/**
				 * 1. 从Redis中获取登录信息 2. 登录信息内容为（用户ID,用户角色）， 3. 解析得到用户ID和用户角色
				 */
				Integer userId = null;
				String userRole = null;
				String loginInfo = null;

				try {
					loginInfo = redisService.getValue(cookieLogin);
				} catch (Exception e) {
					logger.warn("连接Redis服务器失败，使用不安全的明文保存记住登录状态！");
					loginInfo = cookieLogin;
				}
				try {
					if (loginInfo == null) {
						// 登录信息过期或者是登录Cookie是伪造的
						throw new RuntimeException("登录信息过期或者是登录Cookie是伪造的");
					}
					userId = Integer.parseInt(loginInfo.split(",")[0]);
					userRole = loginInfo.split(",")[1];
					switch (userRole) {
					case LoginController.ROLE_ADMIN:
						user = teacherService.findTeacherById(userId);
						break;
					case LoginController.ROLE_TEACHER:
						user = teacherService.findTeacherById(userId);
						break;
					case LoginController.ROLE_STUDENT:
						user = studentService.findStudentById(userId);
						break;
					}
				} catch (Exception e) {
					// Cookie 解析中发生异常
					user = null;
				}
			}

			// 经过上述操作后，再次判断登录是否成功
			if (user != null) {
				session.setAttribute("user", user);
				logger.info("Login success by cookie!");
				return true;
			} else {
				// 登录失败，跳转到登录页面
				String requestUrl = request.getRequestURI(); // 保存请求的页面，登录成功后自动跳转到该页面
				response.sendRedirect(request.getContextPath()
						+ "/login.do?reqURL=" + Base64Util.encode(requestUrl));
				logger.info("Login failed because of error cookie!");
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// Do Nothing
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// Do Nothing
	}

}
