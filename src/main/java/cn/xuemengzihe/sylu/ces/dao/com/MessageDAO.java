package cn.xuemengzihe.sylu.ces.dao.com;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.xuemengzihe.sylu.ces.pojo.com.Message;

/**
 * <h1>Message DAO</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年1月30日 下午2:09:45
 */
@Repository
public interface MessageDAO {
	/**
	 * 增
	 * 
	 * @param message
	 * @return
	 */
	public Integer insertMessage(Message message);

	/**
	 * 删
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteMessage(Integer id);

	/**
	 * 标记消息为已读
	 * 
	 * @param id
	 * @return
	 */
	public Integer tickReadedTagForAMessage(Integer id);

	/**
	 * 标记消息为已读 <br/>
	 * <b>参数说明：</b><br/>
	 * <code>userId</code> 用户ID<br/>
	 * <code>type</code> 消息类型（TTS、TTT、STT、STS)<br/>
	 * 
	 * @param conditions
	 * @return
	 */
	public Integer tickReadedTagForAllMessage(Map<String, String> conditions);

	/**
	 * 改
	 * 
	 * @param message
	 * @return
	 */
	public Integer updateMessage(Message message);

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	public Message getMessageById(Integer id);

	/**
	 * <h1>根据需求查询某位用户的消息</h1><br/>
	 * <b>参数说明：</b><br/>
	 * <code>recMode</code> 指定查询类型，其值为Y（仅查询接收的消息）recMode 和sendMode至少有一个不为空<br/>
	 * <code>sendMode</code> 指定查询类型，其值为Y（仅查询发送的消息）recMode 和sendMode至少有一个不为空 <br/>
	 * <code>tableName</code> 指定查询的视图名称，不可以为空，取值（teach:查询用户为教师 stu:查询用户为学生）<br/>
	 * <code>userId</code> 指定当前查询用户的ID，不可以为空<br/>
	 * <code>state</code> 指定查询消息的类型，可以为空，缺省时为查询所有类型消息，其取值N-未读消息,R-已读消息
	 * 
	 * @param conditions
	 * @return
	 */
	public List<Map<String, String>> getMessageWithMap(
			Map<String, String> conditions);
}
