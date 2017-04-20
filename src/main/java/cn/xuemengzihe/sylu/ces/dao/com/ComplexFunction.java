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
}
