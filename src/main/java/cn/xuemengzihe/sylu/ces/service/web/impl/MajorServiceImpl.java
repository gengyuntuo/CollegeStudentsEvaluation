package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xuemengzihe.sylu.ces.dao.com.MajorDAO;
import cn.xuemengzihe.sylu.ces.pojo.com.Major;
import cn.xuemengzihe.sylu.ces.service.web.MajorService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <h1>Major Service实现</h1>
 * <p>
 * 专业
 * </p>
 * 
 * @author 李春
 * @time 2017年2月7日 下午2:27:56
 */
@Service
public class MajorServiceImpl implements MajorService {
	@Autowired
	private MajorDAO majorDAO;

	@Override
	public Integer insertMajor(Major major) {
		Date date = new Date();
		major.setcTime(date);
		major.setuTime(date);
		major.setIsValid("Y");
		major.setInstituteId(1);
		return majorDAO.insertMajor(major);
	}

	@Override
	public Integer deleteMajorById(Integer id) {
		return majorDAO.deleteMajorById(id);
	}

	@Override
	public Integer updateMajor(Major major) {
		return majorDAO.updateMajor(major);
	}

	@Override
	public Major findMajorById(Integer id) {
		return majorDAO.findMajorById(id);
	}

	@Override
	public PageInfo<Major> findMajorsOfPage(PageInfo<Major> pageInfo) {
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		List<Major> list = majorDAO.findMajorsOfAll();
		pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<Map<String, String>> findMajorsOfPageWithMapSet(
			PageInfo<Map<String, String>> pageInfo, String condition) {
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		List<Map<String, String>> list = majorDAO
				.findMajorsOfAllWithMapSet(condition);
		pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
