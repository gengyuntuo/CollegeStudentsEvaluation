package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xuemengzihe.sylu.ces.dao.com.SettingDAO;
import cn.xuemengzihe.sylu.ces.pojo.com.Setting;
import cn.xuemengzihe.sylu.ces.service.web.SettingService;

/**
 * <h1>Setting Service 实现</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年1月29日time下午3:34:36
 */
@Service
@Transactional
public class SettingServiceImpl implements SettingService {

	@Autowired
	private SettingDAO settingDAO;

	@Override
	public Integer insertSetting(Setting setting) {
		return settingDAO.insertSetting(setting);
	}

	@Override
	public Integer deleteSettingById(Integer id) {
		return settingDAO.deleteSettingById(id);
	}

	@Override
	public Integer updateSetting(Setting setting) {
		return settingDAO.updateSetting(setting);
	}

	@Override
	public Setting findSetttingById(Integer id) {
		return settingDAO.findSetttingById(id);
	}

	@Override
	public List<Setting> findSettings(Map<String, String> conditions) {
		return settingDAO.findSettings(conditions);
	}
}
