package cn.xuemengzihe.sylu.ces.dao.com;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.xuemengzihe.sylu.ces.pojo.com.Institute;

/**
 * <h1>Institute DAO</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月7日 下午1:15:11
 */
@Repository
public interface InstituteDAO {
	/**
	 * 新建学院
	 * 
	 * @param institute
	 * @return
	 */
	public Integer insertInstitute(Institute institute);

	/**
	 * 删除学院
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteInstituteById(Integer id);

	/**
	 * 修改学院
	 * 
	 * @param institute
	 * @return
	 */
	public Integer updateInstitute(Institute institute);

	/**
	 * 查找学院，根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	public Institute findInstituteById(Integer id);

	/**
	 * 查询所有学院
	 * 
	 * @return
	 */
	public List<Institute> findInstitutesOfAll();
}
