package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xuemengzihe.sylu.ces.dao.com.ClassDAO;
import cn.xuemengzihe.sylu.ces.pojo.com.Clazz;
import cn.xuemengzihe.sylu.ces.service.web.ClassService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <h1>Clazz Service实现</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月7日 下午2:27:56
 */
@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	private ClassDAO clazzDAO;

	@Override
	public Integer insertClazz(Clazz clazz) {
		return clazzDAO.insertClazz(clazz);
	}

	@Override
	public Integer deleteClazzById(Integer id) {
		return clazzDAO.deleteClazzById(id);
	}

	@Override
	public Integer updateClazz(Clazz clazz) {
		return clazzDAO.updateClazz(clazz);
	}

	@Override
	public Clazz findClazzById(Integer id) {
		return clazzDAO.findClazzById(id);
	}

	@Override
	public PageInfo<Clazz> findClazzsOfPage(PageInfo<Clazz> pageInfo) {
		// 分页查询 每一页的记录数为15条
		int pageNum = 1;
		if (pageInfo != null)
			pageNum = pageInfo.getPageNum(); // 获取页码
		PageHelper.startPage(pageNum, 15);
		List<Clazz> list = clazzDAO.findClazzsOfAll();
		pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
