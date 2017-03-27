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
	private String type; // 设置类型
	private String Ownerype; // 设置类型
	private Integer ownerId; // 拥有者
	private String group; // 设置名称
	private String setting; // 设置名称
	private String value; // 设置值
	private String defaultValue; // 默认值
	private Character isNull; // 判断该字段是否可以为空

	public Setting() {
		super();
	}

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

	public String getOwnerype() {
		return Ownerype;
	}

	public void setOwnerype(String ownerype) {
		Ownerype = ownerype;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
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

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public Character getIsNull() {
		return isNull;
	}

	public void setIsNull(Character isNull) {
		this.isNull = isNull;
	}

	@Override
	public String toString() {
		return "Setting [id=" + id + ", type=" + type + ", Ownerype="
				+ Ownerype + ", ownerId=" + ownerId + ", group=" + group
				+ ", setting=" + setting + ", value=" + value
				+ ", defaultValue=" + defaultValue + ", isNull=" + isNull + "]";
	}

}
