package cn.xuemengzihe.sylu.ces.dao.com;

import org.springframework.stereotype.Repository;

import cn.xuemengzihe.sylu.ces.pojo.com.Menu;

/**
 * <h1>Menu DAO</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年1月30日time上午10:49:18
 */
@Repository
public interface MenuDAO {
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
