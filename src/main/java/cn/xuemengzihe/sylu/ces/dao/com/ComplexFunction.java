package cn.xuemengzihe.sylu.ces.dao.com;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * <h1>包含了一些复杂的或者是关联的查询及数据操作语句</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年4月17日 上午11:08:27
 */
@Repository
public interface ComplexFunction {

	/**
	 * 在创建学期统计时，根据老师的ID获取当前老师所管理的班级
	 * 
	 * @param id
	 *            教师的ID
	 * @return
	 */
	public List<Map<String, String>> getClassesOfTeacherSelect(Integer id);

	/**
	 * 在发送消息的时候选择收件人列表
	 * 
	 * @param conditions
	 *            查询条件（search、chassId）
	 * @return
	 */
	public List<Map<String, String>> getReceiver(Map<String, String> conditions);

	/**
	 * 创建综合测评统计表（同时会创建素质教育评分表和素质教育日常行为部分评分表）
	 * 
	 * @param params
	 *            （termId 测评学期ID，stuId 学生ID）
	 * @return 综合测评表ID
	 */
	public Integer createZHCPTJ(Map<String, String> params);
}
