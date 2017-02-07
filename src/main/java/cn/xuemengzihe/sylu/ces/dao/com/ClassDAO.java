package cn.xuemengzihe.sylu.ces.dao.com;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.xuemengzihe.sylu.ces.pojo.com.Clazz;

/**
 * <h1>Clazz DAO</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月7日 下午1:15:11
 */
@Repository
public interface ClassDAO {
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
	 * 查询所有班级
	 * 
	 * @return
	 */
	public List<Clazz> findClazzsOfAll();
}
