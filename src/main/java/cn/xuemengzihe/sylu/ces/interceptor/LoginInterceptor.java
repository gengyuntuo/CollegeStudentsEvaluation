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
import cn.xuemengzihe.sylu.ces.service.web.StudentService;
import cn.xuemengzihe.sylu.ces.service.web.TeacherService;

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

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(true);
		Persion user = (Persion) session.getAttribute("user");
		if (user == null) {
			// 未登录用户
			// 检查Cookie，查询浏览器之间是否设置过保存登录状态
			String cookieId = null;
			String cookieRole = null;
			if (request != null)
				for (Cookie cookie : request.getCookies()) {
					if (cookieId == null
							&& LoginController.REMEMBERID_TAG_NAME
									.equals(cookie.getName())) {
						cookieId = cookie.getValue();
						continue;
					}
					if (cookieRole == null
							&& LoginController.REMEMBERROLE_TAG_NAME
									.equals(cookie.getName())) {
						cookieRole = cookie.getValue();
						continue;
					}
				}

			if (cookieId != null
					&& cookieRole != null // 如果Cookie中存在保存的登录信息，则验证Cookie
					&& !cookieId.trim().isEmpty()
					&& !cookieRole.trim().isEmpty()) {
				try {
					switch (Integer.parseInt(cookieRole)) {
					case LoginController.ROLE_ADMIN:
						user = teacherService.findTeacherById(Integer
								.parseInt(cookieId));
						break;
					case LoginController.ROLE_TEACHER:
						user = teacherService.findTeacherById((Integer
								.parseInt(cookieId)));
						break;
					case LoginController.ROLE_STUDENT:
						user = studentService.findStudentById((Integer
								.parseInt(cookieId)));
						break;
					}
				} catch (Exception e) {
					// Cookie 解析中发生异常
					user = null;
				}
			}

			if (user != null) {
				session.setAttribute("user", user);
				logger.info("Login success by cookie!");
				return true;
			} else {
				response.sendRedirect(request.getContextPath() + "/login.do");
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
