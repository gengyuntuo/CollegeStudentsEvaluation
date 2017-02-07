package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.List;

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
		// 分页查询 每一页的记录数为15条
		int pageNum = 1;
		if (pageInfo != null)
			pageNum = pageInfo.getPageNum(); // 获取页码
		PageHelper.startPage(pageNum, 15);
		List<Major> list = majorDAO.findMajorsOfAll();
		pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
