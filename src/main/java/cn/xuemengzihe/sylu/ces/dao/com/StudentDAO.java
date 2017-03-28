package cn.xuemengzihe.sylu.ces.dao.com;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.xuemengzihe.sylu.ces.pojo.com.Student;

/**
 * <h1>Student DAO</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月7日 下午1:15:11
 */
@Repository
public interface StudentDAO {
	/**
	 * 新建学生
	 * 
	 * @param student
	 * @return
	 */
	public Integer insertStudent(Student student);

	/**
	 * 使用Map集合插入学生信息
	 * 
	 * @param student
	 * @return
	 */
	public Integer insertStudentUseMap(Map<String, String> student);

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
	 * 查询所有学生
	 * 
	 * @return
	 */
	public List<Student> findStudentsOfAll();

	/**
	 * 查询所有学生的信息，返回Map结果集
	 * 
	 * @param condition
	 * @return
	 */
	public List<Map<String, String>> findInstitutesOfAllWithMapSet(
			String condition);
}
