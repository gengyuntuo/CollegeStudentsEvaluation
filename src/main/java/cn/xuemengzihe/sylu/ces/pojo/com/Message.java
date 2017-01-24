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
	private Character type; // 消息类型 图片、文字
	private Character sendType; // 消息发送类型，老师给学生，学生给老师、老师给老师等
	private Character isRead; // 是否阅读消息
	private Integer senderId; // 发送者ID
	private Integer receiverId; // 接受者ID
	private String message; // 消息内容

	private Character isValid; // 该消息是否有效
	private Date cTime;
	private Date uTime;

	public Message() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Character getType() {
		return type;
	}

	public void setType(Character type) {
		this.type = type;
	}

	public Character getSendType() {
		return sendType;
	}

	public void setSendType(Character sendType) {
		this.sendType = sendType;
	}

	public Character getIsRead() {
		return isRead;
	}

	public void setIsRead(Character isRead) {
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Character getIsValid() {
		return isValid;
	}

	public void setIsValid(Character isValid) {
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
		return "Message [id=" + id + ", type=" + type + ", sendType="
				+ sendType + ", isRead=" + isRead + ", senderId=" + senderId
				+ ", receiverId=" + receiverId + ", message=" + message
				+ ", isValid=" + isValid + ", cTime=" + cTime + ", uTime="
				+ uTime + "]";
	}

}
