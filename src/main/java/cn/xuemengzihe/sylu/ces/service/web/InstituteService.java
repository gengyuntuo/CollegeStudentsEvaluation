package cn.xuemengzihe.sylu.ces.service.web;

import java.util.Map;

import cn.xuemengzihe.sylu.ces.pojo.com.Institute;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Institute Service</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月7日 下午2:21:55
 */
public interface InstituteService {
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
	 * 分页查询学院[返回结果为List&lt;{@link Institute}&gt; 集合]
	 * 
	 * @return
	 */
	public PageInfo<Institute> findInstitutesOfPage(PageInfo<Institute> pageInfo);

	/**
	 * 分页查询学院[返回结果为List&lt;Map&lt;String,String&gt;&gt; 集合]
	 * 
	 * @param condition
	 *            搜素查询条件
	 * @return
	 */
	public PageInfo<Map<String, String>> findInstitutesOfPageWithMapSet(
			PageInfo<Map<String, String>> pageInfo, String condition);
}
