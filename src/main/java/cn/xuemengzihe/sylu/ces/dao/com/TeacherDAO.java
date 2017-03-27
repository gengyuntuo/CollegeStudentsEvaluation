package cn.xuemengzihe.sylu.ces.dao.com;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.xuemengzihe.sylu.ces.pojo.com.Teacher;

/**
 * <h1>Teacher DAO</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月7日 下午1:15:11
 */
@Repository
public interface TeacherDAO {
	/**
	 * 新建老师
	 * 
	 * @param teacher
	 * @return
	 */
	public Integer insertTeacher(Teacher teacher);

	/**
	 * 删除老师
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteTeacherById(Integer id);

	/**
	 * 修改老师
	 * 
	 * @param teacher
	 * @return
	 */
	public Integer updateTeacher(Teacher teacher);

	/**
	 * 查找老师，根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	public Teacher findTeacherById(Integer id);

	/**
	 * 查询所有老师
	 * 
	 * @return
	 */
	public List<Teacher> findTeachersOfAll();

	/**
	 * 查询所有的教师并返回Map集合，支持条件查询
	 * @param condition 查询条件
	 * @return
	 */
	public List<Map<String, String>> findInstitutesOfAllWithMapSet(
			String condition);

}
