package cn.xuemengzihe.sylu.ces.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * <h1>Session 监听器</h1>
 * <p>
 * Session状态监听，记录在线用户
 * </p>
 * 
 * @author 李春
 * @time 2017年1月27日 上午10:03:25
 */
public class LoginListener implements HttpSessionAttributeListener,
		HttpSessionListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		String attrName = se.getName();
		if ("user".equals(attrName)) {
			HttpSession session = se.getSession();
			session.getAttribute("user");
		}

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// 无操作
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// 无操作
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
	}
}
