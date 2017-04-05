package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xuemengzihe.sylu.ces.dao.com.TermDAO;
import cn.xuemengzihe.sylu.ces.pojo.com.Clazz;
import cn.xuemengzihe.sylu.ces.pojo.com.Term;
import cn.xuemengzihe.sylu.ces.service.web.ClassService;
import cn.xuemengzihe.sylu.ces.service.web.TermService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <h1></h1>
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

	@Override
	public String createScoreStaticTerm(String term, String[] classes,
			Date startDate, Date stopDate) {
		String result = "";
		Clazz clazz = null;
		Term termObj = new Term();
		termObj.setcTime(new Date());
		termObj.setIsValid("Y");
		termObj.setStartDate(startDate);
		termObj.setStopDate(stopDate);
		termObj.setuTime(new Date());
		termObj.setuTime(new Date());

		for (String var : classes) {
			// 1. 查询班级是否存在
			clazz = classService.findClazzByClassId(var);
			if (clazz == null) {
				result += var + "班级不存在,添加失败！\n";
				continue;
			}
			// 2. 创建学期
			try {
				termObj.setName(term);
				termObj.setDesc(term + " " + var);
				termObj.setClassId(clazz.getId());
				termDAO.insert(termObj);
				result += var + "班级创建成功！\n";
			} catch (Exception e) {
				logger.info("Insert Term into databases failed!");
				result += var + "班级创建失败！可能该记录已经存在！\n";
				e.printStackTrace();
				continue;
			}
		}
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
			PageInfo<Map<String, String>> pageInfo, String condition) {
		// 分页查询
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		List<Map<String, String>> list = termDAO.findAll(condition);
		pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
