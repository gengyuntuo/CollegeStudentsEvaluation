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
import cn.xuemengzihe.sylu.ces.pojo.com.Student;
import cn.xuemengzihe.sylu.ces.pojo.com.Teacher;
import cn.xuemengzihe.sylu.ces.service.web.MenuService;

/**
 * <h1>权限拦截器</h1>
 * <p>
 * 防止用户越权，保障账户操作安全<br/>
 * --1. 防止非当前用户非法的访问<br/>
 * --2. 为当前用户分配菜单选项，JSON请求除外<br/>
 * <b>注意：</b>这里对ajax请求可能也会执行，所以请合理配置和使用该拦截器
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
		// 从Session中获取用户对象
		HttpSession session = request.getSession();
		Persion persion = (Persion) session.getAttribute("user");

		if (persion == null) { // 如果Perison对象为空，则出现重大异常，抛出异常
			logger.error("Anthority Intercepter: Persion Object is Null!");
			throw new Exception("权限验证拦截器：Persion 对象为空！");
		}
		// System.out.println("###################################");
		// System.out.println("request.getContextPath()" +
		// request.getContextPath());
		// System.out.println("request.getPathInfo()" + request.getPathInfo());
		// System.out.println("request.getRequestURL()" +
		// request.getRequestURL());
		// System.out.println("request.getServletPath()" +
		// request.getServletPath());
		// System.out.println("request.getRequestURI()" +
		// request.getRequestURI());
		// System.out.println("###################################");
		// TODO 用户访问页面的权限验证

		// 目前采用的方式是将读取的菜单保存到Service方法中，避免重复从数据库中读取
		// 如果遇到菜单更新必须重启Tomcat才可以重新加载菜单
		// 【解决方案】：
		// --> 1.使用Redis的TTL机制来解决
		// --> 2.使用AOP，如果有菜单更新操作，就刷新Service中的缓存数据
		if (persion instanceof Teacher) {
			request.setAttribute("menu",
					menuService.getMenu(persion.getUserType()));
		} else if (persion instanceof Student) {
			// 如果Role属性非空，则为班委，否则为学生
			request.setAttribute("menu",
					menuService.getMenu(persion.getRole() != null ? "M" : "S"));
		}
		logger.debug("this user get the menu!");
		// TODO 该类的功能并没有完成，JSON请求的判断和用户安全访问
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
