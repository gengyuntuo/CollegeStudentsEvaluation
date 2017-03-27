package cn.xuemengzihe.sylu.ces.dao.com;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.xuemengzihe.sylu.ces.pojo.com.Major;

/**
 * <h1>Major DAO</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月7日 下午5:04:20
 */
@Repository
public interface MajorDAO {
	/**
	 * 添加专业
	 * 
	 * @param major
	 * @return
	 */
	public Integer insertMajor(Major major);

	/**
	 * 根据ID删除专业
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteMajorById(Integer id);

	/**
	 * 更新专业
	 * 
	 * @param major
	 * @return
	 */
	public Integer updateMajor(Major major);

	/**
	 * 根据ID查询专业
	 * 
	 * @param id
	 * @return
	 */
	public Major findMajorById(Integer id);

	/**
	 * 查询专业所有内容
	 * 
	 * @return
	 */
	public List<Major> findMajorsOfAll();

	/**
	 * 查询专业所有的内容,返回Map结果集集合
	 * 
	 * @param condition
	 *            查询条件
	 * @return
	 */
	public List<Map<String, String>> findMajorsOfAllWithMapSet(String condition);
}
