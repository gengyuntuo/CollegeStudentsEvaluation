package cn.xuemengzihe.sylu.ces.controller.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xuemengzihe.sylu.ces.pojo.com.Student;
import cn.xuemengzihe.sylu.ces.service.web.StudentService;
import cn.xuemengzihe.sylu.ces.util.JSONUtil;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Student Controller</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月5日 上午11:12:13
 */
@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping("/studentInfo")
	public String studentInfo(Model model) {
		return "/student/studentInfo";
	}

	// 查询所有当前的所有学生，其内容将使用{@link #studentData(String, Integer, Integer) }
	// 方式获取（JSON格式）
	@RequestMapping("/studentList")
	public String studentList() {
		return "/student/studentList";
	}

	/**
	 * 添加学生操作
	 * 
	 * @param student
	 * @return 返回添加的提示信息
	 */
	@ResponseBody
	@RequestMapping(value = "studentAdd", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String studentAdd(Student student) {
		// 服务器校验
		int result = studentService.insertStudent(student);
		if (result == 1) {
			return "{}"; // 返回空，表示成功
		}
		return "{\"tip\":\"添加失败！\"}"; // 返回tip，包含错误信息
	}

	@ResponseBody
	@RequestMapping(value = "studentUpdate", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String studentUpdate(Student student) {
		// TODO 数据完整性校验
		Student oldStudent = studentService.findStudentById(student.getId());
		if (oldStudent == null) {
			return "{\"tip\":\"您要修改的记录不存在！\"}";
		}
		// 赋值
		oldStudent.setAddress(student.getAddress());
		oldStudent.setAlipay(student.getAlipay());
		oldStudent.setBirthday(student.getBirthday());
		oldStudent.setEmail(student.getEmail());
		oldStudent.setGender(student.getGender());
		oldStudent.setIdCard(student.getIdCard());
		oldStudent.setMotto(student.getMotto());
		oldStudent.setName(student.getName());
		oldStudent.setNation(student.getNation());
		oldStudent.setNick(student.getNick());
		oldStudent.setPhone(student.getPhone());
		oldStudent.setQqNumb(student.getQqNumb());
		oldStudent.setResident(student.getResident());
		oldStudent.setWeChat(student.getWeChat());
		oldStudent.setRole(student.getRole());
		oldStudent.setUserType(student.getUserType());

		// 学生特有的属性
		oldStudent.setBankCard(student.getBankCard());
		oldStudent.setClassId(student.getClassId());
		oldStudent.setFatherName(student.getFatherName());
		oldStudent.setFatherPhone(student.getFatherPhone());
		oldStudent.setDormInfo(student.getDormInfo());
		oldStudent.setDormno(student.getDormno());
		oldStudent.setHaveLoan(student.getHaveLoan());
		oldStudent.setHavePovertyCertificate(student
				.getHavePovertyCertificate());
		oldStudent.setPoliticalStatus(student.getPoliticalStatus());
		oldStudent.setMotherName(student.getMotherName());
		oldStudent.setMotherPhone(student.getMotherPhone());

		// 更新
		int result = studentService.updateStudent(oldStudent);
		if (result == 1) {
			return "{}"; // 修改成功！
		}
		return "{\"tip\":\"修改失败！\"}";
	}

	/**
	 * 删除记录
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "studentDelete", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String studentDelete(Integer id) {
		Student oldStudent = studentService.findStudentById(id);
		if (oldStudent == null || "N".equals(oldStudent.getIsValid())) {
			return "{\"tip\":\"您要删除的记录不存在或者已经删除！\"}";
		}
		oldStudent.setIsValid("N"); // 设置删除标记
		studentService.updateStudent(oldStudent); // 删除
		return "{}";
	}

	/**
	 * 学生列表，以分页形式返回JSON数据
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
	@RequestMapping(value = "/studentData", produces = "application/json; charset=utf-8")
	public String studentData(
			String classId, // 班级ID
			String termId, // 测评统计的ID
			String search, // 搜索条件
			@RequestParam(value = "offset", required = true, defaultValue = "0") Integer offset,
			@RequestParam(value = "limit", required = true, defaultValue = "10") Integer limit) {
		PageInfo<Map<String, String>> pageInfo = new PageInfo<>();
		pageInfo.setPageSize(limit);
		pageInfo.setPageNum(offset / limit + 1);
		if (search != null) // 防止SQL注入攻击
			search = search.trim().replace("'", "");

		Map<String, String> conditions = new HashMap<>();
		conditions.put("search", search);
		conditions.put("termId", termId);
		conditions.put("classId", classId);
		// 分页查询记录
		pageInfo = studentService.findStudentsOfPageWithMapSet(pageInfo,
				conditions);
		// 将数据分装的模型中
		// 返回页面
		return JSONUtil.parsePageInfoToJSON(pageInfo);
	}
}
