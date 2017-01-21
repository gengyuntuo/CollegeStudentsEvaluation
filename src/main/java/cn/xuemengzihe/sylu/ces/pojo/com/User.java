package cn.xuemengzihe.sylu.ces.pojo.com;

import java.util.Date;

/**
 * <h1>用户的基本信息</h1>
 * <p>
 * 改POJO是用户所具有的属性，用户类型包括学生、老师
 * </p>
 * 
 * @author 李春
 * @创建时间 2016年12月25日 下午3:34:49
 *
 */
public class User {
	private Integer id; // 用户ID
	private String uname; // 用户名
	private String unick; // 用户昵称
	private String uicon; // 用户头像
	private String password; // 密码

	private Character deleted; // 当前用户是否有效
	private String role; // 用户的角色
	private Date ctime; // 创建时间
	private Date utime; // 修改时间
	private Date lastLoginTime; // 上次登录时间
}
