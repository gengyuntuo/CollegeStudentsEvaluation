package cn.xuemengzihe.sylu.ces.service.web;

import java.util.List;

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

	/**
	 * 获取个人菜单，根据不同的参数获取不同的菜单列表
	 * 
	 * @param level
	 *            菜单等级（教师T，学生S，班委M，管理员A）
	 * @return 个人菜单
	 */
	public List<Menu> findPersionMenu(String level);

}
