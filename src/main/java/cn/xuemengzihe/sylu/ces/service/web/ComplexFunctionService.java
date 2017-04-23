package cn.xuemengzihe.sylu.ces.service.web;

import java.util.Map;

import com.github.pagehelper.PageInfo;

/**
 * <h1></h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年4月23日 上午11:56:43
 */
public interface ComplexFunctionService {
	/**
	 * 分页获取收件人列表
	 * 
	 * @param pageInfo
	 * @param search
	 *            搜索条件
	 * @param classId
	 *            班级ID（学生只能搜索本班级的同学）
	 * @return
	 */
	public PageInfo<Map<String, String>> getReceiver(
			PageInfo<Map<String, String>> pageInfo, String search,
			String classId);

	/**
	 * 创建综合测评统计表（同时会创建素质教育评分表和素质教育日常行为部分评分表）
	 * 
	 * @param termId
	 *            termId 测评学期ID
	 * @param stuId
	 *            学生ID
	 * @return 综合测评表ID
	 */
	public Integer createZHCPTJ(String termId, String stuId);
}
