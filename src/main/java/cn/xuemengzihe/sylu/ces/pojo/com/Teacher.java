package cn.xuemengzihe.sylu.ces.pojo.com;

import java.util.List;

/**
 * <h1>老师</h1>
 * <p>
 * 老师的POJO，继承自{@link cn.xuemengzihe.sylu.ces.Persion}
 * </p>
 * 
 * @author 李春
 * @创建时间 2016年12月25日 下午3:57:09
 * 
 */
public class Teacher extends Persion {
	private List<Clazz> clazzs;

	public Teacher() {
		super();
	}

	public List<Clazz> getClazzs() {
		return clazzs;
	}

	public void setClazzs(List<Clazz> clazzs) {
		this.clazzs = clazzs;
	}

	@Override
	public String toString() {
		return "Teacher [clazzs=" + clazzs + super.toString() + "]";
	}
}
