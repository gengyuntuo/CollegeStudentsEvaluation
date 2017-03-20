package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xuemengzihe.sylu.ces.dao.com.MenuDAO;
import cn.xuemengzihe.sylu.ces.pojo.com.Menu;
import cn.xuemengzihe.sylu.ces.service.web.MenuService;

/**
 * <h1>Menu Service</h1>
 * <p>
 * Menu 业务
 * </p>
 * 
 * @author 李春
 * @time 2017年1月30日time下午1:17:23
 */
@Service
public class MenuServiceImpl implements MenuService {
	private final Logger logger = LoggerFactory
			.getLogger(MenuServiceImpl.class);
	/**
	 * 教师
	 */
	public static final String TYPE_TEACHER = "T";
	/**
	 * 学生
	 */
	public static final String TYPE_STUDENT = "S";
	/**
	 * 班委
	 */
	public static final String TYPE_MONITOR = "M";
	/**
	 * 管理员
	 */
	public static final String TYPE_ADMIN = "A";

	private Map<String, List<Menu>> menu;
	@Autowired
	private MenuDAO menuDAO;

	@Override
	@Transactional
	public Integer insertMenu(Menu menu) {
		return menuDAO.insertMenu(menu);
	}

	@Override
	@Transactional
	public Integer deleteMenuById(Integer id) {
		return menuDAO.deleteMenuById(id);
	}

	@Override
	@Transactional
	public Integer updateMenu(Menu menu) {
		return menuDAO.updateMenu(menu);
	}

	@Override
	public Menu findMenuById(Integer id) {
		return menuDAO.findMenuById(id);
	}

	@Override
	public List<Menu> findPersionMenu(String level) {
		return menuDAO.findPersionMenu(level);
	}

	@Override
	public List<Menu> getMenu(String type) {
		if (menu == null)
			menu = new HashMap<String, List<Menu>>();
		switch (type) {
		case TYPE_TEACHER:
			if (!menu.containsKey(TYPE_TEACHER))
				menu.put(TYPE_TEACHER, menuDAO.findPersionMenu(TYPE_TEACHER));
			return menu.get(TYPE_TEACHER);
		case TYPE_MONITOR:
			if (!menu.containsKey(TYPE_MONITOR))
				menu.put(TYPE_MONITOR, menuDAO.findPersionMenu(TYPE_MONITOR));
			return menu.get(TYPE_MONITOR);

		case TYPE_STUDENT:
			if (!menu.containsKey(TYPE_STUDENT))
				menu.put(TYPE_STUDENT, menuDAO.findPersionMenu(TYPE_STUDENT));
			return menu.get(TYPE_STUDENT);

		case TYPE_ADMIN:
			if (!menu.containsKey(TYPE_ADMIN))
				menu.put(TYPE_ADMIN, menuDAO.findPersionMenu(TYPE_ADMIN));
			return menu.get(TYPE_ADMIN);
		default:
			logger.info("can't find menu by type:" + type);
			break;
		}
		return null;
	}

}
