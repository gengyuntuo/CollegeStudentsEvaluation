package cn.xuemengzihe.sylu.ces.dao.com;

import java.util.List;

import cn.xuemengzihe.sylu.ces.pojo.com.TableSuZhiXueFenRiChangXingWeiBuFenPingFen;

/**
 * 素质教育加分评分表
 * 
 * @author 李春
 * @time 2016年10月23日time上午11:24:15
 */
public interface TableSuZhiXueFenRiChangXingWeiBuFenPingFenDAO {
	/**
	 * 创建素质教育加分评分表
	 * 
	 * @param table
	 * @throws Exception
	 */
	public void addToTable(TableSuZhiXueFenRiChangXingWeiBuFenPingFen record)
			throws Exception;

	/**
	 * 根据ID删除记录
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteByID(Integer id) throws Exception;

	/**
	 * 学生更新数据表的内容
	 * 
	 * @param record
	 * @throws Exception
	 */
	public void updateTableByStudent(
			TableSuZhiXueFenRiChangXingWeiBuFenPingFen record) throws Exception;

	/**
	 * 老师更新数据表的内容
	 * 
	 * @param record
	 * @throws Exception
	 */
	public void updateTableByTeacher(
			TableSuZhiXueFenRiChangXingWeiBuFenPingFen record) throws Exception;

	/**
	 * 根据记录ID查询单条记录
	 * 
	 * @param sno
	 * @return
	 * @throws Exception
	 */
	public TableSuZhiXueFenRiChangXingWeiBuFenPingFen findByID(Integer id)
			throws Exception;

	/**
	 * 根据综合表的ID查询多条表记录
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<TableSuZhiXueFenRiChangXingWeiBuFenPingFen> findByZongHeTable(
			Integer id) throws Exception;

	/**
	 * 查询所有的表
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<TableSuZhiXueFenRiChangXingWeiBuFenPingFen> findAll()
			throws Exception;
}
