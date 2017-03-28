package cn.xuemengzihe.sylu.ces.service.web;

import java.util.Map;

import cn.xuemengzihe.sylu.ces.pojo.com.TableSZJYJFSQ;

import com.github.pagehelper.PageInfo;

/**
 * <h1>素质教育加分申请表</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月28日 下午6:03:57
 */
public interface TableSZJYJFSQService {
	/**
	 * 插入记录
	 * 
	 * @param record
	 *            记录
	 * @return 添加的行数
	 */
	public Integer insertRecord(TableSZJYJFSQ record);

	/**
	 * 更新记录
	 * 
	 * @param record
	 *            记录
	 * @return 更新的记录数
	 */
	public Integer updateRecord(TableSZJYJFSQ record);

	/**
	 * 删除记录
	 * 
	 * @param id
	 *            记录ID
	 * @return 删除的记录数
	 */
	public Integer deleteRecord(Integer id);

	/**
	 * 根据ID获取记录
	 * 
	 * @param id
	 *            记录ID
	 * @return 记录
	 */
	public TableSZJYJFSQ getRecordById(Integer id);

	/**
	 * 分页查询记录，支持条件查询
	 * 
	 * @param pageInfo
	 *            页面信息
	 * @param conditions
	 *            查询条件
	 * @return 结果集
	 */
	public PageInfo<Map<String, String>> getRecordWithMap(
			PageInfo<Map<String, String>> pageInfo, String conditions);
}
