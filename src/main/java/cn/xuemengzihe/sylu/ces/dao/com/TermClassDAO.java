package cn.xuemengzihe.sylu.ces.dao.com;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.xuemengzihe.sylu.ces.pojo.com.TermClass;

/**
 * <h1>测评包含的班级</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年4月3日 下午2:10:07
 */
@Repository
public interface TermClassDAO {
	/**
	 * 添加
	 * 
	 * @param term
	 * @return
	 */
	public int insert(TermClass term);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int delete(Integer id);

	/**
	 * 删除
	 * 
	 * @param id
	 *            term id
	 * @return
	 */
	public int deleteByTermId(Integer id);

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	public TermClass findById(Integer id);

	/**
	 * 根据TermClass ID查询
	 * 
	 * @param id
	 *            term id
	 * @return
	 */
	public List<TermClass> findByTermId(Integer id);

}
