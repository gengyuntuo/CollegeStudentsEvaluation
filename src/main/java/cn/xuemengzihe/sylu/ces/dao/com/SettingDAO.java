package cn.xuemengzihe.sylu.ces.dao.com;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.xuemengzihe.sylu.ces.pojo.com.Setting;

/**
 * <h1>Setting DAO</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年1月29日time下午3:23:13
 */
@Repository
public interface SettingDAO {
	/**
	 * 添加Setting
	 * 
	 * @param setting
	 * @return
	 */
	public Integer insertSetting(Setting setting);

	/**
	 * 根据ID删除
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteSettingById(Integer id);

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
	 * 多条件查询<br/>
	 * Setting {@code 
	 * SELECT *
		FROM setting
		WHERE 1=1
		<if test="type != '' and type != null"> AND type = # type} </if> <if
	 * test="owner_type != '' and owner_type != null"> AND owner_type =
	 * #{owner_type} </if> <if test="owner_id != '' and owner_id != null"> AND
	 * owner_id = #{owner_id} <if test="group != '' and group != null"> AND
	 * group = #{group} </if> </if> <if
	 * test="setting != '' and setting != null"> AND group = #{group} </if>
	 * </select> }
	 * 
	 * @param conditions
	 *            多个查询条件，封装在Map集合中
	 * @return
	 */
	public List<Setting> findSettings(Map<String, String> conditions);
}
