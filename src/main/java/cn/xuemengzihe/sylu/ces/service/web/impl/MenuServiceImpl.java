package cn.xuemengzihe.sylu.ces.service.web.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xuemengzihe.sylu.ces.dao.com.MenuDAO;
import cn.xuemengzihe.sylu.ces.pojo.com.Menu;
import cn.xuemengzihe.sylu.ces.service.web.MenuService;

/**
 * <h1>Menu Service</h1>
 * <p>
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteMenuById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu findMenuById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
