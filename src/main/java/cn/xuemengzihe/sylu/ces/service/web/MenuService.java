package cn.xuemengzihe.sylu.ces.service.web;

import cn.xuemengzihe.sylu.ces.pojo.com.Menu;

public interface MenuService {
	/**
	 * 添加Menu
	 * 
	 * @param menu
	 * @return
	 */
	public Integer insertMenu(Menu menu);

	/**
	 * 删除 Menu
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteMenuById(Integer id);

	/**
	 * 更新 Menu
	 * 
	 * @param menu
	 * @return
	 */
	public Integer updateMenu(Menu menu);

	/**
	 * 根据ID查询Menu
	 * 
	 * @param id
	 * @return
	 */
	public Menu findMenuById(Integer id);

}
