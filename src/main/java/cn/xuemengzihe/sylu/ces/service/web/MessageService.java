package cn.xuemengzihe.sylu.ces.service.web;

import java.util.Map;

import cn.xuemengzihe.sylu.ces.pojo.com.Message;

import com.github.pagehelper.PageInfo;

/**
 * <h1>MessageService</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年4月23日 下午6:49:22
 */
public interface MessageService {
	/**
	 * 查询模式：查询发送的消息
	 */
	public final static byte MODE_MSG_SEND = 0x01;
	/**
	 * 查询模式：查询接收的消息
	 */
	public final static byte MODE_MSG_RECEIVE = 0x02;
	/**
	 * 查询模式：查询发送和接收的消息
	 */
	public final static byte MODE_MSG_SEND_AND_RECEIVE = 0x04;

	/**
	 * 用户类型： 教师
	 */
	public final static String USERTYPE_TEACHER = "teach";
	/**
	 * 用户类型：学生
	 */
	public final static String USERTYPE_STUDENT = "stu";
	/**
	 * 消息状态：仅查询未读消息
	 */
	public final static String STATE_UNREADED = "N";

	/**
	 * 创建消息
	 * 
	 * @param msg
	 * @return
	 */
	public boolean insertMessage(Message msg);

	/**
	 * 使用ID删除消息
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteMessageById(Integer id);

	/**
	 * 删除某一用户某一类别的消息<br/>
	 * 通过查询方式实现的抵消批量删除
	 * 
	 * @param mode
	 *            查询模式，取值{@link #MODE_MSG_SEND}、{@link #MODE_MSG_RECEIVE} 、
	 *            {@link # MODE_MSG_SEND_AND_RECEIVE}
	 * @param userType
	 *            用户类型，取值{@link #USERTYPE_TEACHER}、 {@link #USERTYPE_STUDENT}
	 * @param userId
	 *            用户ID
	 * @return
	 */
	public Integer deleteMessageByUserId(byte mode, String userType,
			Integer userId);

	/**
	 * 更新某一条消息
	 * 
	 * @param msg
	 * @return
	 */
	public boolean updateMessage(Message msg);

	/**
	 * 将某一条消息标记为已读
	 * 
	 * @param id
	 * @return
	 */
	public boolean tickReadedTagForAMessage(Integer id);

	/**
	 * 将所有的消息标记为已读
	 * 
	 * @param userType
	 * @param userId
	 * @return
	 */
	public Integer tickReadedTagForAllMessage(String userType, Integer userId);

	public Message findMessageById(Integer id);

	/**
	 * <h1>根据需求查询某位用户的消息</h1><br/>
	 * 
	 * @param pageInfo
	 *            分页信息
	 * @param mode
	 *            查询模式，取值{@link #MODE_MSG_SEND}、{@link #MODE_MSG_RECEIVE} 、
	 *            {@link # MODE_MSG_SEND_AND_RECEIVE}
	 * @param userType
	 *            用户类型，取值{@link #USERTYPE_TEACHER}、 {@link #USERTYPE_STUDENT}
	 * @param userId
	 *            用户ID
	 * @param state
	 *            所查询消息的状态，取值{@link #STATE_UNREADED}
	 * @return
	 */
	public PageInfo<Map<String, String>> findMessageWithMap(
			PageInfo<Map<String, String>> pageInfo, byte mode, String userType,
			Integer userId, String state);
}
