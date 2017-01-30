package cn.xuemengzihe.sylu.ces.service.web;

import java.util.List;

import cn.xuemengzihe.sylu.ces.pojo.com.TableZongHeCePingChengJiTongJi;

/**
 * 
 * @author 李春
 * @time 2016年10月22日time下午6:47:34
 */
public interface TableZongHeCePingChengJiTongJiService {

	/**
	 * 创建综合成绩统计表记录
	 * 
	 * @param table
	 *            这里必须具有两个参数（学生的SNO和统计的学期）
	 * @throws Exception
	 */
	public void addTable(TableZongHeCePingChengJiTongJi table) throws Exception;

	/**
	 * 更新成绩评定表中的数据记录
	 * 
	 * @param table
	 *            更新表中记录的内容，这里必须的字段有（ID、日常行为得分、素质活动得分、素质学分绩点、平均学分绩点）
	 * @throws Exception
	 */
	public void updateAlterTableData(TableZongHeCePingChengJiTongJi table)
			throws Exception;

	/**
	 * 数据表被默认创建的时候是无效的记录，需要将该字段设置为有效才可以
	 * 
	 * @param table
	 *            更新表中记录的内容，这里必须的字段有（ID、是否有效）
	 * @throws Exception
	 */
	public void updateSetTableValid(TableZongHeCePingChengJiTongJi record)
			throws Exception;

	/**
	 * 根据记录的ID删除表中数据
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteTable(Integer id) throws Exception;

	/**
	 * 根据ID查询某一条记录
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public TableZongHeCePingChengJiTongJi findTableByID(Integer id)
			throws Exception;

	/**
	 * 根据学生学号查询多条记录
	 * 
	 * @param sno
	 * @return
	 * @throws Exception
	 */
	public List<TableZongHeCePingChengJiTongJi> findTableBySNO(String sno)
			throws Exception;

	/**
	 * 根据学号和学期查询单条记录 (学号和学期是必须具有的参数)
	 * 
	 * @return
	 * @throws Exception
	 */
	public TableZongHeCePingChengJiTongJi findTableBySNOAndXUEQI(
			TableZongHeCePingChengJiTongJi record) throws Exception;

	/**
	 * 根据班级和学期查询多条记录 班级信息保存在record对象中SNO字段中
	 * 
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public List<TableZongHeCePingChengJiTongJi> findTableByClassIDAndXUEQI(
			TableZongHeCePingChengJiTongJi record) throws Exception;

	/**
	 * 根据学期查询所有人
	 * 
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public List<TableZongHeCePingChengJiTongJi> findTableByXUEQI(
			TableZongHeCePingChengJiTongJi record) throws Exception;

	/**
	 * 根据班级号和学期来查询某一个班级的所有学生的详细信息，包括其相关的表记录， 这里需要班级号字段，该字段存储在综合测评成绩统计表中的学号字段中
	 * 
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public List<TableZongHeCePingChengJiTongJi> findTableByClassIDAndXUEQIDESC(
			TableZongHeCePingChengJiTongJi record) throws Exception;

}
