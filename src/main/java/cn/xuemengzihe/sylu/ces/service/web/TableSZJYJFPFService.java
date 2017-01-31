package cn.xuemengzihe.sylu.ces.service.web;

import cn.xuemengzihe.sylu.ces.pojo.com.TableSZJYJFPF;

/**
 * 
 * 
 * @author 李春
 * @time 2016年10月22日time下午4:02:28
 */
public interface TableSZJYJFPFService {
	/**
	 * 创建素质教育加分评分表
	 * 
	 * @param table
	 * @throws Exception
	 */
	public void addToTable(TableSZJYJFPF record) throws Exception;

	/**
	 * 根据ID删除记录
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteByID(Integer id) throws Exception;

	/**
	 * 更新数据表中的记录
	 * 
	 * @param record
	 * @throws Exception
	 */

	public void updateTableData(TableSZJYJFPF record) throws Exception;

	/**
	 * 根据ID查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public TableSZJYJFPF findByID(Integer id) throws Exception;

	/**
	 * 根据综合素质测评表查询多条记录
	 * 
	 * @param sno
	 * @return
	 * @throws Exception
	 */
	public TableSZJYJFPF findByZongHe(Integer id) throws Exception;

}
