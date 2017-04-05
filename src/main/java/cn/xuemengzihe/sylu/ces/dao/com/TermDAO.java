package cn.xuemengzihe.sylu.ces.dao.com;

import java.util.List;
import java.util.Map;

import cn.xuemengzihe.sylu.ces.pojo.com.Term;

/**
 * <h1></h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年4月3日 下午2:10:07
 */
public interface TermDAO {
	/**
	 * 添加
	 * 
	 * @param term
	 * @return
	 */
	public int insert(Term term);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int delete(Integer id);

	/**
	 * 更新
	 * 
	 * @param term
	 * @return
	 */
	public int update(Term term);

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	public Term findById(Integer id);

	/**
	 * 查询所有
	 * 
	 * @param condition
	 *            查询条件
	 * @return
	 */
	public List<Map<String, String>> findAll(String condition);
}
