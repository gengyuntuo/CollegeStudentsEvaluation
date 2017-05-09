package cn.xuemengzihe.sylu.ces.controller.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xuemengzihe.sylu.ces.pojo.com.Clazz;
import cn.xuemengzihe.sylu.ces.pojo.com.Major;
import cn.xuemengzihe.sylu.ces.pojo.com.Student;
import cn.xuemengzihe.sylu.ces.pojo.com.Teacher;
import cn.xuemengzihe.sylu.ces.service.web.ClassService;
import cn.xuemengzihe.sylu.ces.service.web.MajorService;
import cn.xuemengzihe.sylu.ces.service.web.StudentService;
import cn.xuemengzihe.sylu.ces.service.web.TeacherService;
import cn.xuemengzihe.sylu.ces.util.JSONUtil;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Class Controller</h1>
 * <p>
 * 班级
 * </p>
 * 
 * @author 李春
 * @time 2017年2月5日 上午11:13:06
 */
@Controller
public class ClassController {
	@Autowired
	private ClassService classService;
	@Autowired
	private MajorService majorService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;

	@RequestMapping("/classInfo")
	public String classInfo(Model model) {
		return "/class/classInfo";
	}

	/**
	 * 班委：班级详情
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/classDetail")
	public String classDetail(HttpServletRequest request, Model model) {
		// @RequestParam(required = true) Integer id) {
		Student student = (Student) request.getSession().getAttribute("user");
		Clazz clazz = classService.findClazzById(student.getClassId());
		model.addAttribute("clazz", clazz);
		return "/class/classDetail";
	}

	/**
	 * 教师班级详情
	 * 
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/teacherClassDetail")
	public String teacherClassDetail(HttpServletRequest request, Model model,
			@RequestParam(required = true) Integer id) {
		Teacher teacher = (Teacher) request.getSession().getAttribute("user");
		Clazz clazz = classService.findClazzById(id);
		if (clazz.getTeacherId() != teacher.getId()) {
			throw new RuntimeException("非法访问，该班级不属于您！");
		}
		model.addAttribute("clazz", clazz);
		return "/class/teacherClassDetail";
	}

	/**
	 * 添加班级操作
	 * 
	 * @param request
	 * @param model
	 * @param clazz
	 *            班级
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "classAdd", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String classAdd(HttpServletRequest request, Model model, Clazz clazz) {
		// TODO 服务器校验
		Teacher teacher = (Teacher) request.getSession().getAttribute("user");

		Major major = majorService.findMajorById(clazz.getMajorId());
		if (major == null) {
			throw new RuntimeException("专业不存在");
		}

		clazz.setTeacherId(teacher.getId());
		int result = classService.insertClazz(clazz);
		if (result == 1) {
			return "{\"result\":\"success\",\"tip\":\"添加成功！\"}"; // 返回空，表示成功
		}
		return "{\"result\":\"error\",\"tip\":\"添加失败！\"}"; // 返回tip，包含错误信息
	}

	/**
	 * 修改班级
	 * 
	 * @param request
	 * @param model
	 * @param clazz
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "classUpdate", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String classUpdate(HttpServletRequest request, Model model,
			Clazz clazz) {
		Teacher teacher = (Teacher) request.getSession().getAttribute("user");

		// TODO 数据完整性校验
		Clazz oldClazz = classService.findClazzById(clazz.getId());

		if (oldClazz == null) {
			return "{\"result\":\"error\",\"tip\":\"无法操作，班级不存在！\"}";
		}

		if (oldClazz.getTeacherId() != teacher.getId()) {
			return "{\"result\":\"error\",\"tip\":\"对不起，无法操作他人的班级！\"}";
		}

		// 赋值
		oldClazz.setClassId(clazz.getClassId());
		oldClazz.setMajorId(clazz.getMajorId());
		oldClazz.setStartYear(clazz.getStartYear());
		oldClazz.setStudyYear(clazz.getStudyYear());

		// 更新
		int result = classService.updateClazz(oldClazz);
		if (result == 1) {
			return "{\"result\":\"success\",\"tip\":\"添加成功！\"}"; // 返回空，表示成功
		}
		return "{\"result\":\"error\",\"tip\":\"添加失败！\"}"; // 返回tip，包含错误信息
	}

	/**
	 * 删除记录
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "classDelete", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String classDelete(HttpServletRequest request, Model model,
			Integer id) {
		Clazz oldClazz = classService.findClazzById(id);
		if (oldClazz == null || "N".equals(oldClazz.getIsValid())) {
			return "{\"result\":\"error\",\"tip\":\"您要删除的记录不存在或者已经删除！\"}";
		}
		oldClazz.setIsValid("N"); // 设置删除标记
		classService.updateClazz(oldClazz); // 删除
		return "{\"result\":\"success\",\"tip\":\"删除成功！\"}";
	}

	/**
	 * 查询所有当前的所有班级，其内容将使用{@link #classData(String, Integer, Integer) }
	 * 方式获取（JSON格式）
	 * 
	 * @return
	 */
	@RequestMapping("/classList")
	public String classList(HttpServletRequest request, Model model) {
		List<Major> majorList = majorService.findMajorsOfPage(null).getList();
		model.addAttribute("majorList", majorList);
		return "/class/classList";
	}

	/**
	 * 班级列表，以分页形式返回JSON数据
	 * 
	 * @param search
	 *            检索条件
	 * @param offset
	 *            偏移量
	 * @param limit
	 *            每页的数据量
	 * @return JSON数据
	 */
	@ResponseBody
	// produces 参数的目的是解决中文乱码问题
	@RequestMapping(value = "/classData", produces = "application/json; charset=utf-8")
	public String classData(
			HttpServletRequest request,
			String search,
			@RequestParam(value = "offset", required = true, defaultValue = "0") Integer offset,
			@RequestParam(value = "limit", required = true, defaultValue = "10") Integer limit) {
		PageInfo<Map<String, String>> pageInfo = new PageInfo<>();
		pageInfo.setPageSize(limit);
		pageInfo.setPageNum(offset / limit + 1);
		if (search != null) // 防止SQL注入攻击
			search = search.trim().replace("'", "");
		// 分页查询记录
		pageInfo = classService.findClazzsOfPageWithMapSet(pageInfo, search);
		// 将数据分装的模型中
		// 返回页面
		return JSONUtil.parsePageInfoToJSON(pageInfo);
	}
}
