package cn.xuemengzihe.sylu.ces.pojo.com;

import java.util.Date;

/**
 * <h1>消息</h1>
 * <p>
 * 消息
 * </p>
 * 
 * @author 李春
 * @time 2017年1月24日time下午10:11:35
 */
public class Message {
	private Integer id; // ID
	private String type; // 消息发送类型，老师给学生，学生给老师、老师给老师等
	private String isRead; // 是否阅读消息
	private Integer senderId; // 发送者ID
	private Integer receiverId; // 接受者ID
	private String title; // 标题
	private String content; // 消息内容
	private String state; // 消息状态（已读、未读）
	private String with_mail; // 是否同时发送邮件通知

	private String isValid; // 该消息是否有效
	private Date cTime;
	private Date uTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public Integer getSenderId() {
		return senderId;
	}

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

	public Integer getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getWith_mail() {
		return with_mail;
	}

	public void setWith_mail(String with_mail) {
		this.with_mail = with_mail;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public Date getcTime() {
		return cTime;
	}

	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}

	public Date getuTime() {
		return uTime;
	}

	public void setuTime(Date uTime) {
		this.uTime = uTime;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", type=" + type + ", isRead=" + isRead
				+ ", senderId=" + senderId + ", receiverId=" + receiverId
				+ ", title=" + title + ", content=" + content + ", state="
				+ state + ", with_mail=" + with_mail + ", isValid=" + isValid
				+ ", cTime=" + cTime + ", uTime=" + uTime + "]";
	}

}
