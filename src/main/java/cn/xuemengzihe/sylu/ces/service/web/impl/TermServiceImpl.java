package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xuemengzihe.sylu.ces.dao.com.TermClassDAO;
import cn.xuemengzihe.sylu.ces.dao.com.TermDAO;
import cn.xuemengzihe.sylu.ces.pojo.com.Clazz;
import cn.xuemengzihe.sylu.ces.pojo.com.Term;
import cn.xuemengzihe.sylu.ces.pojo.com.TermClass;
import cn.xuemengzihe.sylu.ces.service.web.ClassService;
import cn.xuemengzihe.sylu.ces.service.web.TermService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <h1>Term Service</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * 
 * @time 2017年4月3日 下午2:47:47
 */
@Service
public class TermServiceImpl implements TermService {

	private final Logger logger = LoggerFactory
			.getLogger(TermServiceImpl.class);

	@Autowired
	private TermDAO termDAO;
	@Autowired
	private ClassService classService;
	@Autowired
	private TermClassDAO termClassDAO;

	@Override
	@Transactional
	public String createScoreStaticTerm(String name, Integer teacherId,
			String classes[], Date startDate, Date stopDate) {
		// 创建学期
		String result = "";
		Clazz clazz = null;
		Term termObj = new Term();
		termObj.setName(name);
		termObj.setTeacherId(teacherId);
		termObj.setDesc(name);
		termObj.setStartDate(startDate);
		termObj.setStopDate(stopDate);
		termObj.setIsValid("Y");
		termObj.setcTime(new Date());
		termObj.setuTime(new Date());

		// 创建学期
		termObj.setName(name);
		termObj.setDesc(name);
		termDAO.insert(termObj);
		for (String var : classes) {
			// 查询班级是否存在并添加
			if (var != null && "".equals(var.trim()))
				continue;
			clazz = classService.findClazzById(Integer.parseInt(var));
			if (clazz == null) {
				throw new RuntimeException("Class not found");
			}
			termClassDAO.insert(new TermClass(null, termObj.getId(), clazz
					.getId()));
		}

		// TODO 创建综合测评表
		// TODO 创建日常行为评分表
		// TODO 创建素质教育加分评分表

		return result;
	}

	@Override
	public boolean deleteScoreStaticTerm(Integer id) {
		if (termDAO.delete(id) == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateScoreStaticTerm(Term term) {
		if (termDAO.update(term) == 1)
			return true;
		else
			return false;
	}

	@Override
	public Term getTermById(Integer id) {
		return termDAO.findById(id);
	}

	@Override
	public PageInfo<Map<String, String>> getTermWithPageSize(
			PageInfo<Map<String, String>> pageInfo, String search,
			String teacherId) {
		Map<String, String> conditions = new HashMap<>();
		conditions.put("teacherId", teacherId);
		conditions.put("search", search);
		// 分页查询
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		List<Map<String, String>> list = termDAO.findTermsWithMap(conditions);
		pageInfo = new PageInfo<>(list);
		logger.debug(pageInfo.toString());
		return pageInfo;
	}

}
