package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xuemengzihe.sylu.ces.dao.com.InstituteDAO;
import cn.xuemengzihe.sylu.ces.pojo.com.Institute;
import cn.xuemengzihe.sylu.ces.service.web.InstituteService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <h1>Institute Service实现</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月7日 下午2:27:56
 */
@Service
public class InstituteServiceImpl implements InstituteService {
	@Autowired
	private InstituteDAO instituteDAO;

	@Override
	public Integer insertInstitute(Institute institute) {
		Date date = new Date(); // 创建时间、更新时间
		institute.setcTime(date);
		institute.setuTime(date);
		institute.setIsValid("Y");
		return instituteDAO.insertInstitute(institute);
	}

	@Override
	public Integer deleteInstituteById(Integer id) {
		return instituteDAO.deleteInstituteById(id);
	}

	@Override
	public Integer updateInstitute(Institute institute) {
		// 更新修改时间
		institute.setuTime(new Date());
		return instituteDAO.updateInstitute(institute);
	}

	@Override
	public Institute findInstituteById(Integer id) {
		return instituteDAO.findInstituteById(id);
	}

	@Override
	public PageInfo<Institute> findInstitutesOfPage(PageInfo<Institute> pageInfo) {
		// 分页查询 每一页的记录数为15条
		int pageNum = 1;
		if (pageInfo != null) {
			pageNum = pageInfo.getPageNum(); // 获取页码
			PageHelper.startPage(pageNum, 15);
		}
		List<Institute> list = instituteDAO.findInstitutesOfAll();
		pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<Map<String, String>> findInstitutesOfPageWithMapSet(
			PageInfo<Map<String, String>> pageInfo, String condition) {
		// 分页查询
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		List<Map<String, String>> list = instituteDAO
				.findInstitutesOfAllWithMapSet(condition);
		pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
