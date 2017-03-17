package cn.xuemengzihe.sylu.ces.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.xuemengzihe.sylu.ces.pojo.com.Persion;

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

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		Persion user = (Persion) session.getAttribute("user");
		// TODO 重要BUG，测试阶段，正式上线需要删除下面内容
		if (user == null) {
			user = new Persion();
			user.setUserType("T");
			session.setAttribute("user", user);
		}
		if (user == null) {
			// 未登录用户，跳转到登录页面
			request.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp")
					.forward(request, response);
			return false;
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
