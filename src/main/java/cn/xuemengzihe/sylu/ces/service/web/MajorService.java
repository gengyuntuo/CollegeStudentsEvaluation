package cn.xuemengzihe.sylu.ces.service.web;

import java.util.Map;

import cn.xuemengzihe.sylu.ces.pojo.com.Major;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Major Service</h1>
 * <p>
 * 专业
 * </p>
 * 
 * @author 李春
 * @time 2017年2月7日 下午2:21:55
 */
public interface MajorService {
	/**
	 * 新建专业
	 * 
	 * @param major
	 * @return
	 */
	public Integer insertMajor(Major major);

	/**
	 * 删除专业
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteMajorById(Integer id);

	/**
	 * 修改专业
	 * 
	 * @param major
	 * @return
	 */
	public Integer updateMajor(Major major);

	/**
	 * 查找专业，根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	public Major findMajorById(Integer id);

	/**
	 * 分页查询专业
	 * 
	 * @return
	 */
	public PageInfo<Major> findMajorsOfPage(PageInfo<Major> pageInfo);

	/**
	 * 分页查询，返回Map集合
	 * 
	 * @param pageInfo
	 *            封装页码、页面记录数等参数
	 * @param condition
	 *            查询条件
	 * @return
	 */
	public PageInfo<Map<String, String>> findMajorsOfPageWithMapSet(
			PageInfo<Map<String, String>> pageInfo, String condition);
}
