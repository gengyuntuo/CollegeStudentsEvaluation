package cn.xuemengzihe.sylu.ces.service.web;

import java.util.List;

import cn.xuemengzihe.sylu.ces.pojo.com.TableSZXFRCXWBFPF;

/**
 * 
 * @author 李春
 * @time 2016年10月22日time下午6:47:34
 */
public interface TableSZXFRCXWBFPFService {
	/**
	 * 
	 * @param table
	 * @throws Exception
	 */
	public void addToTable(TableSZXFRCXWBFPF record);

	/**
	 * 根据ID删除记录
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteByID(Integer id);

	/**
	 * 学生更新数据表的内容
	 * 
	 * @param record
	 * @throws Exception
	 */
	public void updateTableByStudent(TableSZXFRCXWBFPF record);

	/**
	 * 老师更新数据表的内容
	 * 
	 * @param record
	 * @throws Exception
	 */
	public void updateTableByTeacher(TableSZXFRCXWBFPF record);

	/**
	 * 根据记录ID查询单条记录
	 * 
	 * @param sno
	 * @return
	 * @throws Exception
	 */
	public TableSZXFRCXWBFPF findByID(Integer id);

	/**
	 * 根据综合表的ID查询多条表记录
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<TableSZXFRCXWBFPF> findByZongHeTable(Integer id)
			throws Exception;

	/**
	 * 查询所有的表
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<TableSZXFRCXWBFPF> findAll();

}
