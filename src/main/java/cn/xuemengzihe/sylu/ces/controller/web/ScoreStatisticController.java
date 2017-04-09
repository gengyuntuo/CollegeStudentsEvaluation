package cn.xuemengzihe.sylu.ces.controller.web;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xuemengzihe.sylu.ces.exception.InvalidParameterException;
import cn.xuemengzihe.sylu.ces.exception.MissingParameterException;
import cn.xuemengzihe.sylu.ces.pojo.com.Clazz;
import cn.xuemengzihe.sylu.ces.pojo.com.Student;
import cn.xuemengzihe.sylu.ces.pojo.com.TableSZJYJFSQ;
import cn.xuemengzihe.sylu.ces.pojo.com.Term;
import cn.xuemengzihe.sylu.ces.service.web.ClassService;
import cn.xuemengzihe.sylu.ces.service.web.StudentService;
import cn.xuemengzihe.sylu.ces.service.web.TableSZJYJFSQService;
import cn.xuemengzihe.sylu.ces.service.web.TermService;
import cn.xuemengzihe.sylu.ces.util.JSONUtil;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Score Statistic Controller</h1>
 * <p>
 * 成绩统计相关
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

	@RequestMapping("scoreInfo")
	public String scoreInfo() {
		return "/score/scoreInfo";
	}

	@RequestMapping("scoreList")
	public String scoreList() {
		return "/score/scoreList";
	}

	/**
	 * 创建成绩统计
	 * 
	 * @param term
	 *            统计学期
	 * @param classes
	 *            班级
	 * @param startDat
	 *            开始日期
	 * @param stopDate
	 *            结束日期
	 * @return
	 */
	@RequestMapping(value = "createScoreStatic", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String createScoreStatic(String term, String[] classes,
			Date startDate, Date stopDate) {
		// TODO 服务器端参数校验

		if (classes != null && classes.length > 0) {
			String tip = termService.createScoreStaticTerm(term, classes,
					startDate, stopDate);
			return "{\"tip\":\"" + tip + "\"}"; // 返回tip，包含添加结果
		} else {
			return "{\"tip\":\"添加失败！\"}"; // 返回tip，包含错误信息
		}
	}

	@ResponseBody
	@RequestMapping(value = "termUpdate", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String termUpdate(Term term) {
		// TODO 数据完整性校验
		Term oldTerm = termService.getTermById(term.getId());
		if (oldTerm == null) {
			return "{\"tip\":\"您要修改的记录不存在！\"}";
		}
		// 赋值
		oldTerm.setStartDate(term.getStartDate());
		oldTerm.setStopDate(term.getStopDate());
		oldTerm.setDesc(term.getDesc());
		oldTerm.setuTime(new Date());

		// 更新
		if (termService.updateScoreStaticTerm(oldTerm)) {
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
	@RequestMapping(value = "termDelete", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String termDelete(Integer id) {
		Term oldTerm = termService.getTermById(id);
		if (oldTerm == null || "N".equals(oldTerm.getIsValid())) {
			return "{\"tip\":\"您要删除的记录不存在或者已经删除！\"}";
		}
		oldTerm.setIsValid("N"); // 设置删除标记
		oldTerm.setName(oldTerm.getName() + "delete at " + new Date()); // 由于该字段与class_id联合为UNIQUE，为避免影响添加操作，所以该字段需要修改
		termService.updateScoreStaticTerm(oldTerm); // 做假删除
		return "{}";
	}

	/**
	 * 成绩测评列表，以分页形式返回JSON数据
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
	@RequestMapping(value = "/scoreStaticData", produces = "application/json; charset=utf-8")
	public String scoreStaticData(
			String search,
			@RequestParam(value = "offset", required = true, defaultValue = "0") Integer offset,
			@RequestParam(value = "limit", required = true, defaultValue = "10") Integer limit) {
		PageInfo<Map<String, String>> pageInfo = new PageInfo<>();
		pageInfo.setPageSize(limit);
		pageInfo.setPageNum(offset / limit + 1);
		if (search != null) // 防止SQL注入攻击
			search = search.trim().replace("'", "");
		// 分页查询记录
		pageInfo = termService.getTermWithPageSize(pageInfo, search);
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
		Clazz clazz = null; // 班级

		// 参数合法性校验
		if (item == null)
			throw new MissingParameterException();

		// 参数有效性校验
		term = termService.getTermById(item);
		if (term == null) {
			throw new InvalidParameterException();
		}
		model.addAttribute("term", term); // 添加到模型中

		// TODO 业务
		clazz = classService.findClazzById(term.getClassId());
		model.addAttribute("clazz", clazz);

		return "/score/scoreStaticDetail";
	}

	/**
	 * 学生，创建素质加分申请表
	 * 
	 * @return
	 */
	@RequestMapping("createSZJYJFSQ")
	public String createSZJYJFSQ(HttpServletRequest request, Model model,
			TableSZJYJFSQ record) {
		// TODO 表单参数合法性校验

		// TODO 获取Session中Student对象，校验该身份的有效性，是否有权限添加记录
		Student student = (Student) request.getSession().getAttribute("user");

		// TODO 添加
		try {
			if (1 != tableSZJYJFSQServcie.insertRecord(record)) {
				throw new Exception();
			}
			model.addAttribute("tip", "创建成功！");
		} catch (Exception e) {
			model.addAttribute("tip", "创建失败！");
			e.printStackTrace();
		}
		return "/other/result";
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
	public String monitorScoreStaticWork(HttpServletRequest request, Model model, Integer item) {
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
	public String teacherScoreStaticWork(HttpServletRequest request, Model model, Integer item) {
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
}
