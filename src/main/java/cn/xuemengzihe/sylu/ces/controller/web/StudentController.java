package cn.xuemengzihe.sylu.ces.controller.web;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.xuemengzihe.sylu.ces.pojo.com.Clazz;
import cn.xuemengzihe.sylu.ces.pojo.com.Persion;
import cn.xuemengzihe.sylu.ces.pojo.com.Student;
import cn.xuemengzihe.sylu.ces.pojo.com.Teacher;
import cn.xuemengzihe.sylu.ces.pojo.web.ImportStudentByExcelResult;
import cn.xuemengzihe.sylu.ces.service.web.ClassService;
import cn.xuemengzihe.sylu.ces.service.web.ExcelService;
import cn.xuemengzihe.sylu.ces.service.web.StudentService;
import cn.xuemengzihe.sylu.ces.util.FileUtil;
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
	@Autowired
	private ClassService classService;
	@Autowired
	private ExcelService excelService;

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
	 * 
	 * @param request
	 * @param item
	 * @return
	 */
	@RequestMapping(value = "studentDetail")
	public String studentDetail(HttpServletRequest request, Model model,
			@RequestParam(required = true) Integer item) {
		Persion persion = (Persion) request.getSession().getAttribute("user");
		Student student = studentService.findStudentById(item);
		if (persion instanceof Teacher) {
			// 教师查看
			int teacherIdOfThisStudent = classService.findClazzById(
					student.getClassId()).getTeacherId();
			if (persion.getId() != teacherIdOfThisStudent) {
				throw new RuntimeException("您无法访问非您本人的学生");
			}
		} else if (persion instanceof Student && persion.getRole() != null) {
			// 班委查看
			Student me = (Student) persion;
			if (me.getClassId() != student.getClassId()) {
				throw new RuntimeException("您无法访问非同班同学");
			}
		}

		model.addAttribute("student", student);

		return "/student/studentDetail";
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

	/**
	 * <h1>修改学生信息</h1> <br/>
	 * 角色：学生本人、班委、教师<br/>
	 * 
	 * @param request
	 * @param student
	 * @return
	 */
	@RequestMapping(value = "studentUpdate", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String studentUpdate(HttpServletRequest request, Student student) {
		boolean tag = true; // 标记是否为自己修改自己的信息（true自己修改）
		Persion persion = (Persion) request.getSession().getAttribute("user");

		// TODO 数据完整性校验

		Student oldStudent = null; // 被修改人
		// 判断是谁在修改，并根据不同的修改人做出相应的操作
		if (student.getId() != null) {
			tag = false;
			// 非本人修改
			oldStudent = studentService.findStudentById(student.getId());
			if (persion instanceof Teacher && oldStudent != null) {
				// 老师修改
				int teacherIdOfThisStudent = classService.findClazzById(
						oldStudent.getClassId()).getTeacherId();
				if (persion.getId() != teacherIdOfThisStudent) {
					throw new RuntimeException("您无法访问非您本人的学生");
				}
			} else if (persion instanceof Student && oldStudent != null
					&& persion.getRole() != null) {
				// 班委修改
				if (((Student) persion).getClassId() != oldStudent.getClassId()) {
					throw new RuntimeException("您无法访问非同班同学");
				}
			}
		} else {
			// 本人修改
			oldStudent = studentService.findStudentById(persion.getId());
		}

		if (oldStudent == null) {
			throw new RuntimeException("您修改的学生不存在");
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
		// oldStudent.setRole(student.getRole());
		// oldStudent.setUserType(student.getUserType());

		// 学生特有的属性
		oldStudent.setBankCard(student.getBankCard());
		// oldStudent.setClassId(student.getClassId());
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

		// 老师可以修改的信息
		if (persion instanceof Teacher) {
			// 修改职务
			if (student.getRole() != null && !student.getRole().isEmpty())
				oldStudent.setRole(student.getRole());
			else
				oldStudent.setRole(null);
		}

		if (studentService.updateStudent(oldStudent) != 1) {
			throw new RuntimeException("修改失败！");
		}
		if (tag) {
			// 自己修改
			request.getSession().setAttribute("user", oldStudent);
			return "redirect:/studentInfo.do";
		} else {
			// 非本人修改
			return "redirect:/studentDetail.do?item=" + oldStudent.getId();
		}
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
	 * 使用Excel文件导入数据
	 * 
	 * @param request
	 * @param excel
	 *            excel 文件
	 * @param 班级ID
	 * 
	 * @return
	 */
	@RequestMapping(value = "/importStudent", produces = "application/json; charset=utf-8")
	public String importStudent(HttpServletRequest request, Model model,
			Integer classId, @RequestParam(required = true) MultipartFile excel) {
		Teacher teacher = (Teacher) request.getSession().getAttribute("user");
		Clazz clazz = classService.findClazzById(classId);
		String projPath = request.getSession().getServletContext()
				.getRealPath("/");
		String fileName = excel.getOriginalFilename();
		String subPath = FileUtil.DIRECTROY_TEMP_FILE + UUID.randomUUID()
				+ ".xls";
		String path = projPath + subPath;
		try {
			if (clazz == null || clazz.getTeacherId() != teacher.getId()) {
				throw new RuntimeException("班级不存在");
			}
			if (!".xls".equals(FileUtil.getFileExtension(fileName))) {
				throw new RuntimeException("文件的扩展名不是 .xls");
			}
			FileUtil.mkdirsForFile(path); // 创建路径
			excel.transferTo(new File(path)); // 保存文件
			model.addAttribute("result", "success");
			model.addAttribute("tip", "解析完毕");
			ImportStudentByExcelResult result = excelService
					.importStudentInfomationFromExcelFile(classId, new File(
							path));
			model.addAttribute("imResult", result); // 封装导入结果
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("result", "error");
			model.addAttribute("tip", e.getMessage());
		} finally {
		}
		return "/other/importStudentResult";
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
			HttpServletRequest request,
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

		// 如果是学生访问该方法（班委）
		Persion persion = (Persion) request.getSession().getAttribute("user");
		if (persion instanceof Student) {
			conditions.put("classId", ((Student) persion).getClassId()
					.toString());
		}

		// 分页查询记录
		pageInfo = studentService.findStudentsOfPageWithMapSet(pageInfo,
				conditions);
		// 将数据分装的模型中
		// 返回页面
		return JSONUtil.parsePageInfoToJSON(pageInfo);
	}
}
