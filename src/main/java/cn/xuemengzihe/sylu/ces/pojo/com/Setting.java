package cn.xuemengzihe.sylu.ces.pojo.com;

/**
 * <h1>设置</h1>
 * <p>
 * 设置
 * </p>
 * 
 * @author 李春
 * @time 2017年1月24日time下午10:06:29
 */
public class Setting {
	private Integer id; // ID
	private Character role; // 角色
	private Integer ownerId; // 拥有者
	private String setting; // 设置名称
	private String value; // 设置值

	public Setting() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Character getRole() {
		return role;
	}

	public void setRole(Character role) {
		this.role = role;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getSetting() {
		return setting;
	}

	public void setSetting(String setting) {
		this.setting = setting;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Setting [id=" + id + ", role=" + role + ", ownerId=" + ownerId
				+ ", setting=" + setting + ", value=" + value + "]";
	}

}
