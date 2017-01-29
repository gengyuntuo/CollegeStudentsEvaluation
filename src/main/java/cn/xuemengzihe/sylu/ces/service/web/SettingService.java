package cn.xuemengzihe.sylu.ces.service.web;

import java.util.List;

import cn.xuemengzihe.sylu.ces.pojo.com.Setting;

/**
 * <h1>Setting Service</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年1月29日time下午3:33:13
 */
public interface SettingService {
	/**
	 * 添加Setting
	 * 
	 * @param setting
	 * @return
	 */
	public Integer insertSetting(Setting setting);

	/**
	 * 批量添加Setting
	 * 
	 * @param settings
	 * @return
	 */
	public Integer insertSettings(List<Setting> settings);

	/**
	 * 根据ID删除
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteSettingById(Integer id);

	/**
	 * 根据ID批量删除
	 * 
	 * @param ids
	 * @return
	 */
	public Integer deleteSettingsByIds(List<Integer> ids);

	/**
	 * 修改Setting
	 * 
	 * @param setting
	 * @return
	 */
	public Integer updateSetting(Setting setting);

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	public Setting findSetttingById(Integer id);

	/**
	 * 根据Setting类型查询
	 * 
	 * @param type
	 * @return
	 */
	public List<Setting> findSettingsByType(String type);

	/**
	 * 根据Setting owner查询
	 * 
	 * @param id
	 * @return
	 */
	public List<Setting> findSettingsByOwnerId(Integer id);

	/**
	 * 根据Setting 的name查询
	 * 
	 * @param name
	 * @return
	 */
	public List<Setting> findSettingsBySettingName(String name);
}
