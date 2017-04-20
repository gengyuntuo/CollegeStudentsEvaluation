package cn.xuemengzihe.sylu.ces.service.web;

import java.util.Date;
import java.util.Map;

import cn.xuemengzihe.sylu.ces.pojo.com.Term;

import com.github.pagehelper.PageInfo;

/**
 * <h1>学期 service</h1>
 * <p>
 * 学期
 * </p>
 * 
 * @author 李春
 * @time 2017年4月3日 下午2:36:33
 */
public interface TermService {
	/**
	 * 创建成绩统计学期
	 * 
	 * @param name
	 *            学期
	 * @param teacherId
	 *            教师Id
	 * @param classes
	 *            班级（所有班级的ID，用,号隔开）
	 * @param startDate
	 *            开始日期
	 * @param stopDate
	 *            结束日期
	 * @return 创建的结果（字符串形式）
	 */
	public String createScoreStaticTerm(String name, Integer teacherId,
			String classes[], Date startDate, Date stopDate);

	/**
	 * 删除学期
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteScoreStaticTerm(Integer id);

	/**
	 * 更新数据
	 * 
	 * @param term
	 * @return
	 */
	public boolean updateScoreStaticTerm(Term term);

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	public Term getTermById(Integer id);

	/**
	 * 分页查询
	 * 
	 * @param pageInfo
	 *            分页信息
	 * @param search
	 *            过滤条件
	 * @param teacherId
	 *            教师ID
	 * @return
	 */
	public PageInfo<Map<String, String>> getTermWithPageSize(
			PageInfo<Map<String, String>> pageInfo, String search,
			String teacherId);
}
