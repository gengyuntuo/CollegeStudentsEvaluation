package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.HashMap;
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
		Teacher teach = teacherDAO.findTeacherById(teacher.getId());
		teach.setAddress(teacher.getAddress());
		teach.setAlipay(teacher.getAlipay());
		teach.setBirthday(teacher.getBirthday());
		teach.setEmail(teacher.getEmail());
		teach.setGender(teacher.getGender());
		teach.setIdCard(teacher.getIdCard());
		teach.setMotto(teacher.getMotto());
		teach.setName(teacher.getName());
		teach.setNation(teacher.getNation());
		teach.setNick(teacher.getNick());
		teach.setPhone(teacher.getPhone());
		teach.setPortrait(teacher.getPortrait()); // 头像的修改要特别注意
		teach.setQqNumb(teacher.getQqNumb());
		teach.setResident(teacher.getResident());
		teach.setRole(teacher.getUserType()); // 个人不可以修改
		teach.setWeChat(teacher.getWeChat());

		if (teacher.getPassword() != null) {
			teacherDAO.updateTeacherPassword(teacher);
		}

		return teacherDAO.updateTeacher(teacher);

	}

	@Override
	public Teacher findTeacherById(Integer id) {
		return teacherDAO.findTeacherById(id);
	}

	@Override
	public Teacher loginVerify(String userName, String password) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userName", userName);
		params.put("password", password);
		return teacherDAO.findTeacherByUserNameAndPassword(params);
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
