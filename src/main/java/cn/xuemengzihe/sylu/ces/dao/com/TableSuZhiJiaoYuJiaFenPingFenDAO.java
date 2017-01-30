package cn.xuemengzihe.sylu.ces.dao.com;

import cn.xuemengzihe.sylu.ces.pojo.com.TableSuZhiJiaoYuJiaFenPingFen;

/**
 * 素质教育加分评分表
 * 
 * @author 李春
 * @time 2016年10月23日time上午11:24:15
 */
public interface TableSuZhiJiaoYuJiaFenPingFenDAO {
	/**
	 * 创建素质教育加分评分表
	 * 
	 * @param table
	 * @throws Exception
	 */
	public void addToTable(TableSuZhiJiaoYuJiaFenPingFen record)
			throws Exception;

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

	public void updateTableData(TableSuZhiJiaoYuJiaFenPingFen record)
			throws Exception;

	/**
	 * 根据ID查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public TableSuZhiJiaoYuJiaFenPingFen findByID(Integer id) throws Exception;

	/**
	 * 根据综合素质测评表查询多条记录
	 * 
	 * @param sno
	 * @return
	 * @throws Exception
	 */
	public TableSuZhiJiaoYuJiaFenPingFen findByZongHe(Integer id)
			throws Exception;
}
