package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xuemengzihe.sylu.ces.dao.com.StudentDAO;
import cn.xuemengzihe.sylu.ces.pojo.com.Student;
import cn.xuemengzihe.sylu.ces.service.web.StudentService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <h1>Student Service实现</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月7日 下午2:27:56
 */
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public Integer insertStudent(Student student) {
		return studentDAO.insertStudent(student);
	}

	@Override
	public Integer insertStudent(Map<String, String> student) {
		return studentDAO.insertStudentUseMap(student);
	}

	@Override
	public Integer deleteStudentById(Integer id) {
		return studentDAO.deleteStudentById(id);
	}

	@Override
	public Integer updateStudent(Student student) {
		return studentDAO.updateStudent(student);
	}

	@Override
	public Student findStudentById(Integer id) {
		return studentDAO.findStudentById(id);
	}

	@Override
	public Student loginVerify(String userName, String password) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userName", userName);
		params.put("password", password);
		return studentDAO.findStudentByUserNameAndPassword(params);
	}

	@Override
	public PageInfo<Student> findStudentsOfPage(PageInfo<Student> pageInfo) {
		// 分页查询 每一页的记录数为15条
		int pageNum = 1;
		if (pageInfo != null)
			pageNum = pageInfo.getPageNum(); // 获取页码
		PageHelper.startPage(pageNum, 15);
		List<Student> list = studentDAO.findStudentsOfAll();
		pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<Map<String, String>> findStudentsOfPageWithMapSet(
			PageInfo<Map<String, String>> pageInfo,
			Map<String, String> conditions) {
		// 分页查询
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		List<Map<String, String>> list = studentDAO
				.findInstitutesOfAllWithMapSet(conditions);
		pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
