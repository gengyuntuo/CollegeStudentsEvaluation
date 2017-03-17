package cn.xuemengzihe.sylu.ces.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.xuemengzihe.sylu.ces.pojo.com.Persion;
import cn.xuemengzihe.sylu.ces.service.web.MenuService;

/**
 * <h1>权限拦截器</h1>
 * <p>
 * 防止用户越权，保障账户操作安全<br/>
 * --1. 防止非当前用户非法的访问 --2. 为当前用户分配菜单选项，JSON请求除外 注意：这里对ajax请求可能也会执行，所以请合理配置和使用该拦截器
 * </p>
 * 
 * @author 李春
 * @time 2017年1月30日 下午2:51:21
 */
public class AuthorityInterceptor implements HandlerInterceptor {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private MenuService menuService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		Persion persion = (Persion) session.getAttribute("user");
		// 如果Perison对象非空，则查询用户菜单
		if (persion != null) {
			request.setAttribute("menu",
					menuService.getMenu(persion.getUserType()));
			logger.debug("this user get the menu!");
		}
		// TODO 该类的功能并没有完成，JSON请求的判断和 用户安全访问
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
