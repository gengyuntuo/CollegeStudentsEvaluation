package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.List;

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
		return instituteDAO.insertInstitute(institute);
	}

	@Override
	public Integer deleteInstituteById(Integer id) {
		return instituteDAO.deleteInstituteById(id);
	}

	@Override
	public Integer updateInstitute(Institute institute) {
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
		if (pageInfo != null)
			pageNum = pageInfo.getPageNum(); // 获取页码
		PageHelper.startPage(pageNum, 15);
		List<Institute> list = instituteDAO.findInstitutesOfAll();
		pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
