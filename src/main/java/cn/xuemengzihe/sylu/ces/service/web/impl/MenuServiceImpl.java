package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Autowired
	private MenuDAO menuDAO;

	@Override
	public Integer insertMenu(Menu menu) {
		return menuDAO.insertMenu(menu);
	}

	@Override
	public Integer deleteMenuById(Integer id) {
		return menuDAO.deleteMenuById(id);
	}

	@Override
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

}
