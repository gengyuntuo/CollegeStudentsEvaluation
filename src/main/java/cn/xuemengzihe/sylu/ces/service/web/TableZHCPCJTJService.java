package cn.xuemengzihe.sylu.ces.service.web;

import java.util.Map;

import cn.xuemengzihe.sylu.ces.pojo.com.TableZHCPCJTJ;

import com.github.pagehelper.PageInfo;

/**
 * <h1>综合成绩统计表</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月28日 下午6:35:19
 */
public interface TableZHCPCJTJService {
	/**
	 * 插入记录
	 * 
	 * @param record
	 *            记录
	 * @return 添加的行数
	 */
	public Integer insertRecord(TableZHCPCJTJ record);

	/**
	 * 更新记录
	 * 
	 * @param record
	 *            记录
	 * @return 更新的记录数
	 */
	public Integer updateRecord(TableZHCPCJTJ record);

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
	public TableZHCPCJTJ getRecordById(Integer id);

	/**
	 * 使用测评ID和学号(或学生ID)确定某一个学生与测评相关的所有表
	 * 
	 * @param termId
	 *            测评ID（必须）
	 * @param sno
	 *            学号（sno、sutId不能全为空）
	 * @param stuId
	 *            学生ID（sno、sutId不能全为空）
	 * @return
	 */
	public TableZHCPCJTJ getRecordDetailWithTermIdSno(Integer termId,
			String sno, Integer stuId);

	/**
	 * 分页查询记录
	 * 
	 * @param pageInfo
	 *            页面信息
	 * @param termId
	 *            学期ID(非空）
	 * @param classId
	 *            班级ID
	 * @param sno
	 *            学号
	 * @param order
	 *            排序
	 * @return 结果集
	 */
	public PageInfo<Map<String, String>> getRecordWithMap(
			PageInfo<Map<String, String>> pageInfo, String termId,
			String classId, String sno, String order);

}
