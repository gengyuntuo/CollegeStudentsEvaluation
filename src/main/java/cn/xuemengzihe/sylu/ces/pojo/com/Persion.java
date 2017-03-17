package cn.xuemengzihe.sylu.ces.pojo.com;

import java.util.Date;

/**
 * <h1>Persion（人物对象的父类）</h1>
 * <p>
 * 项目中所有人物对象的父类，包含了基本具有的属性
 * </p>
 * 
 * @see Student
 * @see Teacher
 * @author 李春
 * @time 2017年1月21日time下午8:35:57
 */
public class Persion {
	private Integer id; // ID
	private String nick; // 昵称
	private String name; // 姓名
	private String nation; // 民族
	private String gender; // 性别
	private Date birthday; // 生日
	private String portrait; // 头像
	private String role; // 职位
	private String email; // 邮箱账户
	private String idCard; // 身份证号
	private String weChat; // 微信账号
	private String qqNumb; // QQ账号
	private String alipay; // 支付宝账号
	private String phone; // 手机号
	private String address; // 户口所在地
	private String resident; // 居住地
	private String motto; // 座右铭
	private String password; // 密码
	private String userType;// 账户类型,例如T：老师，S：学生，M：班委，A：管理员······

	private Character isValid; // 该Persion是否有效
	private Date cTime;
	private Date uTime;

	public Persion() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getResident() {
		return resident;
	}

	public void setResident(String resident) {
		this.resident = resident;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getWeChat() {
		return weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	public String getQqNumb() {
		return qqNumb;
	}

	public void setQqNumb(String qqNumb) {
		this.qqNumb = qqNumb;
	}

	public String getAlipay() {
		return alipay;
	}

	public void setAlipay(String alipay) {
		this.alipay = alipay;
	}

	public Character getIsValid() {
		return isValid;
	}

	public void setIsValid(Character isValid) {
		this.isValid = isValid;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "Persion [id=" + id + ", nick=" + nick + ", name=" + name
				+ ", nation=" + nation + ", gender=" + gender + ", birthday="
				+ birthday + ", portrait=" + portrait + ", role=" + role
				+ ", email=" + email + ", idCard=" + idCard + ", weChat="
				+ weChat + ", qqNumb=" + qqNumb + ", alipay=" + alipay
				+ ", phone=" + phone + ", address=" + address + ", resident="
				+ resident + ", motto=" + motto + ", password=" + password
				+ ", userType=" + userType + ", isValid=" + isValid
				+ ", cTime=" + cTime + ", uTime=" + uTime + "]";
	}

}
