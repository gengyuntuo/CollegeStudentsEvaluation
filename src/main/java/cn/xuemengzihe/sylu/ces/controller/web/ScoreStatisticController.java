package cn.xuemengzihe.sylu.ces.controller.web;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.multipart.MultipartFile;

import cn.xuemengzihe.sylu.ces.dao.com.ComplexFunction;
import cn.xuemengzihe.sylu.ces.dao.com.TermClassDAO;
import cn.xuemengzihe.sylu.ces.exception.InvalidParameterException;
import cn.xuemengzihe.sylu.ces.exception.MissingParameterException;
import cn.xuemengzihe.sylu.ces.pojo.com.Persion;
import cn.xuemengzihe.sylu.ces.pojo.com.Student;
import cn.xuemengzihe.sylu.ces.pojo.com.TableSZJYJFSQ;
import cn.xuemengzihe.sylu.ces.pojo.com.TableZHCPCJTJ;
import cn.xuemengzihe.sylu.ces.pojo.com.Teacher;
import cn.xuemengzihe.sylu.ces.pojo.com.Term;
import cn.xuemengzihe.sylu.ces.service.web.ClassService;
import cn.xuemengzihe.sylu.ces.service.web.ExcelService;
import cn.xuemengzihe.sylu.ces.service.web.StudentService;
import cn.xuemengzihe.sylu.ces.service.web.TableSZJYJFPFService;
import cn.xuemengzihe.sylu.ces.service.web.TableSZJYJFSQService;
import cn.xuemengzihe.sylu.ces.service.web.TableSZXFRCXWBFPFService;
import cn.xuemengzihe.sylu.ces.service.web.TableZHCPCJTJService;
import cn.xuemengzihe.sylu.ces.service.web.TermService;
import cn.xuemengzihe.sylu.ces.service.web.WebParseService;
import cn.xuemengzihe.sylu.ces.util.Base64Util;
import cn.xuemengzihe.sylu.ces.util.FileUtil;
import cn.xuemengzihe.sylu.ces.util.JSONUtil;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Score Statistic Controller</h1>
 * <p>
 * 成绩统计相关<br/>
 * <b>注意：</b>并非所有与成绩相关的方法都在该类中，部分班长特有的在操作在{@link MonitorController}中
 * </p>
 * 
 * @author 李春
 * @time 2017年1月30日 下午3:08:34
 */
@Controller
public class ScoreStatisticController {
	@Autowired
	private TermService termService;
	@Autowired
	private ClassService classService;
	@Autowired
	private StudentService studentServcice;
	@Autowired
	private TableSZJYJFSQService tableSZJYJFSQServcie;
	@Autowired
	private TableSZJYJFPFService tableSZJYJFPFService;
	@Autowired
	private TableZHCPCJTJService tableZHCPCJTJServcie;
	@Autowired
	private TableSZXFRCXWBFPFService tableSZXFRCXWBFPFService;
	@Autowired
	private WebParseService webParseService;
	@Autowired
	private ComplexFunction compexFunction;
	@Autowired
	private TermClassDAO termClassDAO;
	@Autowired
	private ExcelService excelService;

	/**
	 * 成绩信息
	 * 
	 * @return
	 */
	@RequestMapping("scoreInfo")
	public String scoreInfo() {
		return "/score/scoreInfo";
	}

	/**
	 * 成绩统计（学生和教师）
	 * 
	 * @return
	 */
	@RequestMapping("scoreStatic")
	public String scoreStatic() {
		return "/score/scoreStatic";
	}

	/**
	 * 测评列表
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("scoreList")
	public String scoreList(HttpServletRequest request, Model model) {
		// 获取创建学期时的列表
		List<String> terms = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		terms.add(year + "-" + (year + 1));
		for (int i = 0; i < 5; i++) {
			terms.add(--year + "-" + (year + 1));
		}
		model.addAttribute("terms", terms);

		// 获取创建学期时该教师管理的班级
		Teacher teacher = (Teacher) request.getSession().getAttribute("user");
		List<Map<String, String>> classes = compexFunction
				.getClassesOfTeacherSelect(teacher.getId());
		model.addAttribute("classes", classes);

		return "/score/scoreList";
	}

	/**
	 * 创建成绩统计
	 * 
	 * @param request
	 * @param name
	 *            学期名称
	 * @param classes
	 *            班级ID（逗号分隔）
	 * @param startDate
	 *            统计开始日期
	 * @param stopDate
	 *            统计截止日期
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "createScoreStatic", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String createScoreStatic(
			HttpServletRequest request,
			String name,
			@RequestParam(value = "classes[]", required = true) String classes[],
			Date startDate, Date stopDate) {
		// TODO 服务器端参数校验

		// 获取当前的老师
		Teacher teacher = (Teacher) request.getSession().getAttribute("user");
		try {
			termService.createScoreStaticTerm(name, teacher.getId(), classes,
					startDate, stopDate);
			return "{}";
		} catch (Exception e) {
			return "{\"tip\":\"添加失败！\"}"; // 返回tip，包含错误信息
		}
	}

	/**
	 * 成绩测评列表，以分页形式返回JSON数据
	 * 
	 * @param request
	 *            request
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
	@RequestMapping(value = "/scoreStaticData", produces = "application/json; charset=utf-8")
	public String scoreStaticData(
			HttpServletRequest request,
			String search,
			@RequestParam(value = "offset", required = true, defaultValue = "0") Integer offset,
			@RequestParam(value = "limit", required = true, defaultValue = "10") Integer limit) {
		PageInfo<Map<String, String>> pageInfo = new PageInfo<>();
		pageInfo.setPageSize(limit);
		pageInfo.setPageNum(offset / limit + 1);
		if (search != null) // 防止SQL注入攻击
			search = search.trim().replace("'", "");

		// 判断当前 用户是否为教师，如果是教师，则只查询教师的相关内容
		String teacherId = null;
		String classId = null;
		Persion persion = (Persion) request.getSession().getAttribute("user");
		if (persion instanceof Teacher
				&& "T".equals(((Teacher) persion).getRole())) {
			teacherId = persion.getId() + "";
		} else if (persion instanceof Student) {
			classId = ((Student) persion).getClassId().toString();
		}

		// 分页查询记录
		pageInfo = termService.getTermWithPageSize(pageInfo, search, classId,
				teacherId);
		// 将数据分装的模型中
		// 返回页面
		return JSONUtil.parsePageInfoToJSON(pageInfo);
	}

	/**
	 * 查看某个班级某一学期测评的详细信息
	 * 
	 * @param request
	 * @param model
	 * @param item
	 * @return
	 */
	@RequestMapping("/scoreStaticDetail")
	public String scoreStaticDetail(HttpServletRequest request, Model model,
			Integer item) {
		// 变量定义
		Term term = null; // 测评班级的学期信息
		Teacher teacher = null; // 访问当前页面的教师

		teacher = (Teacher) request.getSession().getAttribute("user");

		// 判断item参数是否为空
		if (item == null)
			throw new MissingParameterException();
		// 判断item参数是否可以对应term，且输入当前老师
		term = termService.getTermById(item);
		if (term == null || teacher.getId() != term.getTeacherId()) {
			throw new InvalidParameterException();
		}
		model.addAttribute("term", term); // 添加到模型中

		return "/score/scoreStaticDetail";
	}

	/**
	 * 学生：显示学生测评的页面
	 * 
	 * @param request
	 * @param model
	 * @param item
	 *            测评的ID
	 * @return
	 */
	@RequestMapping("studentScoreStaticDetail")
	public String studentScoreStaticDetail(HttpServletRequest request,
			Model model, Integer item) {
		// 变量定义
		Student student = (Student) request.getSession().getAttribute("user");
		Term term = null; // 测评班级的学期信息
		TableZHCPCJTJ zhRecord = null; // 综合测评表（详细）

		// 参数合法性校验
		if (item == null)
			throw new MissingParameterException();
		// 参数有效性校验
		term = termService.getTermById(item);
		if (term == null) {
			throw new InvalidParameterException();
		}

		// 查询综合测评表
		zhRecord = tableZHCPCJTJServcie.getRecordDetailWithTermIdSno(item,
				null, student.getId());
		// 如果当前学生不存在统计表，则创建
		if (zhRecord == null) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("termId", item + "");
			params.put("stuId", student.getId() + "");
			compexFunction.createZHCPTJ(params);
			// 再次查询综合测评表
			zhRecord = tableZHCPCJTJServcie.getRecordDetailWithTermIdSno(item,
					null, student.getId());
			if (zhRecord == null) {
				throw new RuntimeException("综合测评表创建失败！");
			}
		}

		// 绑定参数
		model.addAttribute("term", term);
		model.addAttribute("zhRecord", zhRecord);

		return "/score/studentScoreStaticDetail";
	}

	/**
	 * 班委：测评工作
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("monitorScoreStaticWork")
	public String monitorScoreStaticWork(HttpServletRequest request,
			Model model, Integer item) {
		Term term = null; // 测评班级的学期信息

		// 参数合法性校验
		if (item == null)
			throw new MissingParameterException();

		// 参数有效性校验
		term = termService.getTermById(item);
		if (term == null) {
			throw new InvalidParameterException();
		}

		// TODO 业务
		model.addAttribute("term", term);

		return "/score/monitorScoreStaticWork";
	}

	/**
	 * 老师：测评工作
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("teacherScoreStaticWork")
	public String teacherScoreStaticWork(HttpServletRequest request,
			Model model, Integer item) {
		Term term = null; // 测评班级的学期信息

		// 参数合法性校验
		if (item == null)
			throw new MissingParameterException();

		// 参数有效性校验
		term = termService.getTermById(item);
		if (term == null) {
			throw new InvalidParameterException();
		}

		// TODO 业务
		model.addAttribute("term", term);
		return "/score/teacherScoreStaticWork";
	}

	/**
	 * 学生：创建素质加分申请表
	 * 
	 * @return
	 */
	@RequestMapping("createSZJYJFSQ")
	public String createSZJYJFSQ(HttpServletRequest request, Model model,
			Integer item, TableSZJYJFSQ record, MultipartFile file) {
		// TODO 表单参数合法性校验

		Student student = (Student) request.getSession().getAttribute("user");
		Term term = termService.getTermById(item);
		TableZHCPCJTJ zhRecord = tableZHCPCJTJServcie
				.getRecordDetailWithTermIdSno(item, student.getSno(), null);

		try {
			// 参数检查
			if (term == null) { // 学期参数异常
				throw new RuntimeException("学期参数异常,未找到对应的测评信息");
			}
			if (zhRecord == null) {
				throw new RuntimeException("学期参数异常,未找到对应的测评数据");
			}
			if (new Date().getTime() - term.getStopDate().getTime() > 0) {
				throw new RuntimeException("超过截止日期，不能提交！");
			}

			// 保存文件
			try {
				// 获取项目中储存文件的文件夹的绝对路径
				String fileLocation = request.getSession().getServletContext()
						.getRealPath("/");
				String filePathAndName = FileUtil.DIRECTORY_UPLOAD_FILE
						+ FileUtil.getUploadFilePathAndName(file
								.getOriginalFilename());
				FileUtil.mkdirsForFile(fileLocation + filePathAndName);
				file.transferTo(new File(fileLocation + filePathAndName));
				record.setFilePath(Base64Util.encode(filePathAndName)); // Base64编码后存入数据库
			} catch (IOException e) {
				throw new Exception("写入测评数据失败！");
			}

			// 设置素质教育加分表
			record.setSuZhiId(zhRecord.getTableSZJYJF().getId());

			// 插入数据
			if (1 != tableSZJYJFSQServcie.insertRecord(record)) {
				throw new Exception("插入数据失败！");
			}
			model.addAttribute("result", "true");
			model.addAttribute("tip", "创建成功！");
		} catch (Exception e) {
			model.addAttribute("result", "false");
			model.addAttribute("tip", e.getMessage());
			e.printStackTrace();
		}
		return "/other/result";
	}

	/**
	 * 学生,班委,教师：显示学生个人的素质教育加分申请表
	 * 
	 * @param request
	 * @param termId
	 *            学期
	 * @param offset
	 *            页面记录偏移量
	 * @param limit
	 *            每页的数量
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/listSZJYJFSQ", produces = "application/json; charset=utf-8")
	public String listSZJYJFSQ(
			HttpServletRequest request,
			String termId,
			@RequestParam(value = "offset", required = true, defaultValue = "0") Integer offset,
			@RequestParam(value = "limit", required = true, defaultValue = "10") Integer limit) {
		Student student = (Student) request.getSession().getAttribute("user");
		PageInfo<Map<String, String>> pageInfo = new PageInfo<>();
		pageInfo.setPageSize(limit);
		pageInfo.setPageNum(offset / limit + 1);
		// 分页查询记录
		pageInfo = tableSZJYJFSQServcie.getRecordWithMap(pageInfo, termId,
				student.getSno());
		// 将数据封装的模型中
		// 返回页面
		return JSONUtil.parsePageInfoToJSON(pageInfo);
	}

	/**
	 * 显示表格：综合测评表的数据
	 * 
	 * @param request
	 * @param termId
	 *            测评ID
	 * @param classId
	 *            班级ID
	 * @param order
	 *            排序
	 * @param offset
	 *            偏移量
	 * @param limit
	 *            每页数量
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/listZHCPCJTJ", produces = "application/json; charset=utf-8")
	public String listZHCPCJTJ(
			HttpServletRequest request,
			String termId,
			String classId,
			String order,
			@RequestParam(value = "offset", required = true, defaultValue = "0") Integer offset,
			@RequestParam(value = "limit", required = true, defaultValue = "10") Integer limit) {
		PageInfo<Map<String, String>> pageInfo = new PageInfo<>();
		pageInfo.setPageSize(limit);
		pageInfo.setPageNum(offset / limit + 1);
		// 分页查询记录
		pageInfo = tableZHCPCJTJServcie.getRecordWithMap(pageInfo, termId,
				classId, null, order);
		return JSONUtil.parsePageInfoToJSON(pageInfo);
	}

	/**
	 * 显示表格：素质学分日常行为部分评分
	 * 
	 * @param termId
	 *            测评ID
	 * @param classId
	 *            班级ID
	 * @param order
	 *            排序
	 * @param offset
	 *            偏移量
	 * @param limit
	 *            每页数量
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/listSZXFRCXWBFPF", produces = "application/json; charset=utf-8")
	public String listSZXFRCXWBFPF(
			HttpServletRequest request,
			String termId,
			String classId,
			String order,
			@RequestParam(value = "offset", required = true, defaultValue = "0") Integer offset,
			@RequestParam(value = "limit", required = true, defaultValue = "10") Integer limit) {
		PageInfo<Map<String, String>> pageInfo = new PageInfo<>();
		pageInfo.setPageSize(limit);
		pageInfo.setPageNum(offset / limit + 1);
		// 分页查询记录
		pageInfo = tableSZXFRCXWBFPFService.getRecordWithMap(pageInfo, termId,
				classId, null, order);
		return JSONUtil.parsePageInfoToJSON(pageInfo);
	}

	/**
	 * 显示表格：素质教育加分
	 * 
	 * @param termId
	 *            测评ID
	 * @param classId
	 *            班级ID
	 * @param order
	 *            排序
	 * @param offset
	 *            偏移量
	 * @param limit
	 *            每页数量
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/listSZJYJFPF", produces = "application/json; charset=utf-8")
	public String listSZJYJFPF(
			HttpServletRequest request,
			String termId,
			String classId,
			String order,
			@RequestParam(value = "offset", required = true, defaultValue = "0") Integer offset,
			@RequestParam(value = "limit", required = true, defaultValue = "10") Integer limit) {
		PageInfo<Map<String, String>> pageInfo = new PageInfo<>();
		pageInfo.setPageSize(limit);
		pageInfo.setPageNum(offset / limit + 1);
		// 分页查询记录
		pageInfo = tableSZJYJFPFService.getRecordWithMap(pageInfo, termId,
				classId, null, order);
		return JSONUtil.parsePageInfoToJSON(pageInfo);
	}

	/**
	 * 根据ID删除
	 * 
	 * @param request
	 * @param type
	 *            删除的种类
	 * @param id
	 *            被删除的ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteById", produces = "application/json; charset=utf-8")
	public String deleteById(HttpServletRequest request, String type, Integer id) {
		Persion persion = (Persion) request.getSession().getAttribute("user");
		// TODO 执行删除前需要查询被删除的记录是否存在，
		// 同时需要判断当前用户是否可以删除该条记录
		persion.getId();
		try {
			tag: {
				// 所有用户都可以执行的
				switch (type.toUpperCase()) {
				case "SZJYJFSQ":
					tableSZJYJFSQServcie.deleteRecord(id);
					break;
				}
				// 判断用户的类型
				if (persion instanceof Teacher) {
					// 教师执行的
					switch (type.toUpperCase()) {
					case "TERM":
						Term oldTerm = termService.getTermById(id);
						if (oldTerm == null || "N".equals(oldTerm.getIsValid())) {
							throw new Exception();
						}
						termService.deleteScoreStaticTerm(id);
						termClassDAO.deleteByTermId(id);
						// TODO 删除相关的测评表
						break tag;
					}
				} else if (persion instanceof Student) {
					// 学生执行的
					switch (type.toUpperCase()) {
					}
				}
				// 如果上面的情况都没有执行，这里就抛异常
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"tip\":\"删除失败！\"}";
		}
		return "{\"good\":\"删除成功！\"}";
	}

	/**
	 * 学生：更新个人平均学分绩点
	 * 
	 * @param request
	 * @param model
	 * @param item
	 *            测评ID
	 * @param password
	 *            教学网密码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateAVGScorePoint", produces = "application/json; charset=utf-8")
	public String updateAVGScorePoint(HttpServletRequest request, Model model,
			@RequestParam(required = true) Integer item,
			@RequestParam(required = true) String password) {
		Double score = 0.; // 成绩
		Student student = (Student) request.getSession().getAttribute("user");
		Term term = termService.getTermById(item);
		TableZHCPCJTJ zhRecord = tableZHCPCJTJServcie
				.getRecordDetailWithTermIdSno(item, null, student.getId());
		try {
			if (zhRecord == null) {
				throw new RuntimeException("未找到对应的测评记录！");
			}
			if (new Date().getTime() - term.getStopDate().getTime() > 0) {
				throw new RuntimeException("无法更新，已经超过测评截止日期");
			}

			score = webParseService.obtainXFJD(student.getSno(), password,
					term.getName());

			// 保存成绩
			if (zhRecord.getPingJunXueFenJiDian() != score) {
				zhRecord.setPingJunXueFenJiDian(score);
				tableZHCPCJTJServcie.updateRecord(zhRecord);
			}
		} catch (Exception e) {
			return "{\"result\":\"error\",\"tip\":\"" + e.getMessage() + "\"}";
		}
		return "{\"result\":\"success\",\"score\":\""
				+ new DecimalFormat("#.0000").format(score) + "\"}";
	}

	/**
	 * 
	 * @param request
	 * @param model
	 * @param tableType
	 *            表的类型
	 * @param termId
	 *            测评Id
	 * @param classId
	 *            班级
	 * @param order
	 *            排序方式
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/downloadScoreSheet", produces = "application/json; charset=utf-8")
	public String downloadScoreSheet(HttpServletRequest request, Model model,
			@RequestParam(required = true) String tableType,
			@RequestParam(required = true) String termId, String classId,
			String order) {

		// 参数定义
		String path = null;
		String rootPath = request.getSession().getServletContext()
				.getRealPath("/");
		String subPath = FileUtil.DIRECTROY_TEMP_FILE + "file.xls";
		path = rootPath + subPath;
		try {
			switch (tableType) {
			case "zhcp":
				excelService.exportExcelFileOfZHCPCJTJ(termId, classId, order,
						false, path);
				break;
			case "szjf":
				excelService.exportExcelFileOfSZJYJFPF(termId, classId, order,
						false, path);
				break;
			case "rcxw":
				excelService.exportExcelFileOfSZXFRCXWBFPF(termId, classId,
						order, false, path);
				break;
			default:
				throw new RuntimeException("您指定的成绩表类型不正确");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\",\"tip\":\"" + e.getMessage() + "\"}";
		}
		return "{\"result\":\"success\",\"url\":\"" + "\"}";
	}
}
