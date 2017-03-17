package cn.xuemengzihe.sylu.ces.pojo.com;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>页面上的菜单</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月16日 下午2:57:12
 */
public class Menu {
	private Integer id; // ID
	private Integer order; // 菜单显示的顺序
	private String url; // 菜单请求路径
	private String title; // 菜单选项名称
	private String desc; // 菜单功能描述
	private String image; // 菜单展示图标
	private Integer fatherMenuId; // 父菜单ID
	private String level; // 菜单使用权限等级
	private Boolean isValid; // 菜单是否有效

	// 子菜单（二级菜单）
	private List<Menu> menus;

	public Menu() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public List<Menu> getMenus() {
		// System.out.println("调用了GetMenus方法");
		if (this.menus == null)
			this.menus = new ArrayList<>();
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", order=" + order + ", url=" + url
				+ ", title=" + title + ", desc=" + desc + ", image=" + image
				+ ", fatherMenuId=" + fatherMenuId + ", level=" + level
				+ ", isValid=" + isValid + ", menus=" + menus + "]";
	}

}
