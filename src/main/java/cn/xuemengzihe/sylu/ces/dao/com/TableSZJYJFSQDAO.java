package cn.xuemengzihe.sylu.ces.dao.com;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.xuemengzihe.sylu.ces.pojo.com.TableSZJYJFSQ;

/**
 * <h1>素质教育加分申请表</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月28日 下午6:30:14
 */
@Repository
public interface TableSZJYJFSQDAO {
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
	 * 获取某同学某个测评学期所有的记录，返回Map集合
	 * 
	 * @param conditions
	 *            查询条件(term.id 和 student.sno)(key:id,key:sno)
	 * @return 记录
	 */
	public List<Map<String, String>> getRecordWithMap(
			Map<String, String> conditions);
	/**
	 * 获取某次测评的所有的记录，返回Map集合
	 * 
	 * @param conditions
	 *            查询条件(term.id 和 student.sno)(key:id,key:sno)
	 * @return 记录
	 */
	public List<Map<String, String>> getTermRecordWithMap(
			Map<String, String> conditions);
}
