package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xuemengzihe.sylu.ces.dao.com.MessageDAO;
import cn.xuemengzihe.sylu.ces.exception.InvalidParameterException;
import cn.xuemengzihe.sylu.ces.pojo.com.Message;
import cn.xuemengzihe.sylu.ces.service.web.MessageService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <h1>MessageServiceImpl</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月29日 下午6:45:08
 */
@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDAO msgDao;

	@Override
	public boolean insertMessage(Message msg) {
		if (msgDao.insertMessage(msg) == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteMessageById(Integer id) {
		if (msgDao.deleteMessage(id) == 1)
			return true;
		else
			return false;
	}

	@Override
	public Integer deleteMessageByUserId(byte mode, String userType,
			Integer userId) {
		int count = 0; // 删除的记录数
		Map<String, String> conditions = new HashMap<>();
		// 模式设置
		switch (mode) {
		case MODE_MSG_SEND:
			conditions.put("sendMode", "Y");
			break;
		case MODE_MSG_RECEIVE:
			conditions.put("recMode", "Y");
			break;
		case MODE_MSG_SEND_AND_RECEIVE:
			conditions.put("sendMode", "Y");
			conditions.put("recMode", "Y");
			break;
		default:
			throw new InvalidParameterException();
		}
		// 用户类型设置
		switch (userType) {
		case USERTYPE_TEACHER:
			conditions.put("tableName", USERTYPE_TEACHER);
			break;
		case USERTYPE_STUDENT:
			conditions.put("tableName", USERTYPE_STUDENT);
			break;
		default:
			throw new InvalidParameterException();
		}
		// 设置用户ID
		conditions.put("userId", userId + "");
		List<Map<String, String>> list = msgDao.getMessageWithMap(conditions);
		for (Map<String, String> var : list) {
			msgDao.deleteMessage(Integer.parseInt(var.get("id")));
			count++;
		}
		return count;
	}

	@Override
	public boolean updateMessage(Message msg) {
		if (msgDao.updateMessage(msg) == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean tickReadedTagForAMessage(Integer id) {
		return (1 == msgDao.tickReadedTagForAMessage(id)) ? true : false;
	}

	@Override
	public Integer tickReadedTagForAllMessage(String userType, Integer userId) {
		Map<String, String> conditions = new HashMap<>();
		// 用户类型设置
		switch (userType) {
		case USERTYPE_TEACHER:
			conditions.put("type", "'TTT','STT'");
			break;
		case USERTYPE_STUDENT:
			conditions.put("type", "'TTS','STS'");
			break;
		default:
			throw new InvalidParameterException();
		}
		// 设置用户ID
		conditions.put("receiverId", userId + "");
		return msgDao.tickReadedTagForAllMessage(conditions);
	}

	@Override
	public PageInfo<Map<String, String>> findMessageWithMap(
			PageInfo<Map<String, String>> pageInfo, byte mode, String userType,
			Integer userId, String state) {
		Map<String, String> conditions = new HashMap<>();
		// 模式设置
		switch (mode) {
		case MODE_MSG_SEND:
			conditions.put("sendMode", "Y");
			break;
		case MODE_MSG_RECEIVE:
			conditions.put("recMode", "Y");
			break;
		case MODE_MSG_SEND_AND_RECEIVE:
			conditions.put("sendMode", "Y");
			conditions.put("recMode", "Y");
			break;
		default:
			throw new InvalidParameterException();
		}

		// 用户类型设置
		switch (userType) {
		case USERTYPE_TEACHER:
			conditions.put("tableName", USERTYPE_TEACHER);
			break;
		case USERTYPE_STUDENT:
			conditions.put("tableName", USERTYPE_STUDENT);
			break;
		default:
			throw new InvalidParameterException();
		}

		// 设置用户ID
		conditions.put("userId", userId + "");

		// 设置消息状态
		if ("N".equals(state))
			conditions.put("state", state);
		// 分页查询
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		List<Map<String, String>> list = msgDao.getMessageWithMap(conditions);
		pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
