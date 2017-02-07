package cn.xuemengzihe.sylu.ces.service.web;

import cn.xuemengzihe.sylu.ces.pojo.com.Teacher;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Teacher Service</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月7日 下午2:21:55
 */
public interface TeacherService {
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
	 * 分页查询老师
	 * 
	 * @return
	 */
	public PageInfo<Teacher> findTeachersOfPage(PageInfo<Teacher> pageInfo);
}