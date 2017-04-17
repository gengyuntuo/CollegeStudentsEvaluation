package cn.xuemengzihe.sylu.ces.dao.com;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.xuemengzihe.sylu.ces.pojo.com.TableZHCPCJTJ;

/**
 * <h1>综合测评成绩统计表</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月28日 下午6:30:28
 */
@Repository
public interface TableZHCPCJTJDAO {
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
	 * 获取所有的记录，返回Map集合，支持条件查询
	 * 
	 * @param conditions
	 *            查询条件
	 * @return 记录
	 */
	public List<Map<String, String>> getRecordWithMap(
			Map<String, String> conditions);
}
