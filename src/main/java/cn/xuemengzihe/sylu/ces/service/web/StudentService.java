package cn.xuemengzihe.sylu.ces.service.web;

import java.util.Map;

import cn.xuemengzihe.sylu.ces.pojo.com.Student;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Student Service</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月7日 下午2:21:55
 */
public interface StudentService {
	/**
	 * 新建学生
	 * 
	 * @param student
	 * @return
	 */
	public Integer insertStudent(Student student);

	/**
	 * 删除学生
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteStudentById(Integer id);

	/**
	 * 修改学生
	 * 
	 * @param student
	 * @return
	 */
	public Integer updateStudent(Student student);

	/**
	 * 查找学生，根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	public Student findStudentById(Integer id);

	/**
	 * 分页查询学生
	 * 
	 * @return
	 */
	public PageInfo<Student> findStudentsOfPage(PageInfo<Student> pageInfo);

	/**
	 * 分页查询学生，支持条件查询
	 * 
	 * @param pageInfo
	 * @param condition
	 *            查询条件
	 * @return
	 */
	public PageInfo<Map<String, String>> findStudentsOfPageWithMapSet(
			PageInfo<Map<String, String>> pageInfo, String condition);
}
