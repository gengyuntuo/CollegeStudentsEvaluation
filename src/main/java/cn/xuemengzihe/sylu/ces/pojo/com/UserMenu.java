package cn.xuemengzihe.sylu.ces.pojo.com;

import java.util.Date;

public class UserMenu {
	private Integer id; // ID
	private String url; // 菜单请求路径
	private String title; // 菜单选项名称
	private String desc; // 菜单功能描述
	private String image; // 菜单展示图标
	private Integer roleId; // 菜单拥有者ID
	private Integer fatherMenuId; // 父菜单ID
	private Character level; // 菜单使用权限等级

	private Date startDate; // 菜单启用日期
	private Date stopDate; // 菜单停用日期

	public UserMenu() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImage() {
		return image;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getFatherMenuId() {
		return fatherMenuId;
	}

	public void setFatherMenuId(Integer fatherMenuId) {
		this.fatherMenuId = fatherMenuId;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Character getLevel() {
		return level;
	}

	public void setLevel(Character level) {
		this.level = level;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStopDate() {
		return stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	@Override
	public String toString() {
		return "UserMenu [id=" + id + ", url=" + url + ", title=" + title
				+ ", desc=" + desc + ", image=" + image + ", roleId=" + roleId
				+ ", fatherMenuId=" + fatherMenuId + ", level=" + level
				+ ", startDate=" + startDate + ", stopDate=" + stopDate + "]";
	}

}
