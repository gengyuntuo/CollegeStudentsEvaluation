package cn.xuemengzihe.sylu.ces.pojo.com;

/**
 * <h1>数据表信息</h1>
 * <p>
 * 该 POJO映射数据库中表信息（使用SQL语句：desc 表名称）
 * </p>
 * 
 * @author 李春
 * @time 2017年1月31日 上午11:49:10
 */
public class TableInfo {
	private String filed; // 字段名称
	private String type; // 字段类型
	private String isNull; // 是否非空
	private String key; // 是否为主键
	private String defaultContent; // 默认值
	private String extra; // 其他

	public TableInfo() {
		super();
	}

	public String getFiled() {
		return filed;
	}

	public void setFiled(String filed) {
		this.filed = filed;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsNull() {
		return isNull;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDefaultContent() {
		return defaultContent;
	}

	public void setDefaultContent(String defaultContent) {
		this.defaultContent = defaultContent;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "TableInfo [filed=" + filed + ", type=" + type + ", isNull="
				+ isNull + ", key=" + key + ", defaultContent="
				+ defaultContent + ", extra=" + extra + "]";
	}

}
