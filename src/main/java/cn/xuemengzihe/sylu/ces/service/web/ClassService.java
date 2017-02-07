package cn.xuemengzihe.sylu.ces.service.web;

import cn.xuemengzihe.sylu.ces.pojo.com.Clazz;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Clazz Service</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月7日 下午2:21:55
 */
public interface ClassService {
	/**
	 * 新建班级
	 * 
	 * @param clazz
	 * @return
	 */
	public Integer insertClazz(Clazz clazz);

	/**
	 * 删除班级
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteClazzById(Integer id);

	/**
	 * 修改班级
	 * 
	 * @param clazz
	 * @return
	 */
	public Integer updateClazz(Clazz clazz);

	/**
	 * 查找班级，根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	public Clazz findClazzById(Integer id);

	/**
	 * 分页查询班级
	 * 
	 * @return
	 */
	public PageInfo<Clazz> findClazzsOfPage(PageInfo<Clazz> pageInfo);
}
