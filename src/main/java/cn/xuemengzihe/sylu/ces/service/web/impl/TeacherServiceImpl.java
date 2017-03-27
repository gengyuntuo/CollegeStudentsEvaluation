package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xuemengzihe.sylu.ces.dao.com.TeacherDAO;
import cn.xuemengzihe.sylu.ces.pojo.com.Teacher;
import cn.xuemengzihe.sylu.ces.service.web.TeacherService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <h1>Teacher Service实现</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月7日 下午2:27:56
 */
@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherDAO teacherDAO;

	@Override
	public Integer insertTeacher(Teacher teacher) {
		return teacherDAO.insertTeacher(teacher);
	}

	@Override
	public Integer deleteTeacherById(Integer id) {
		return teacherDAO.deleteTeacherById(id);
	}

	@Override
	public Integer updateTeacher(Teacher teacher) {
		return teacherDAO.updateTeacher(teacher);
	}

	@Override
	public Teacher findTeacherById(Integer id) {
		return teacherDAO.findTeacherById(id);
	}

	@Override
	public PageInfo<Teacher> findTeachersOfPage(PageInfo<Teacher> pageInfo) {
		// 分页查询 每一页的记录数为15条
		int pageNum = 1;
		if (pageInfo != null)
			pageNum = pageInfo.getPageNum(); // 获取页码
		PageHelper.startPage(pageNum, 15);
		List<Teacher> list = teacherDAO.findTeachersOfAll();
		pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<Map<String, String>> findTeachersOfPageWithMapSet(
			PageInfo<Map<String, String>> pageInfo, String condition) {
		// 分页查询
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		List<Map<String, String>> list = teacherDAO
				.findInstitutesOfAllWithMapSet(condition);
		pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
