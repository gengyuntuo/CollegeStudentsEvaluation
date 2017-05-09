package cn.xuemengzihe.sylu.ces.controller.web;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xuemengzihe.sylu.ces.dao.com.ComplexFunction;
import cn.xuemengzihe.sylu.ces.dao.com.TermClassDAO;
import cn.xuemengzihe.sylu.ces.pojo.com.Clazz;
import cn.xuemengzihe.sylu.ces.pojo.com.Persion;
import cn.xuemengzihe.sylu.ces.pojo.com.Student;
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
 * 该部分的功能：显示成绩、下载成绩<br/>
 * <b>注意：</b>并非所有与成绩相关的方法都在该类中，参考 {@link MonitorController}，
 * {@link ScoreStatisticController}， {@link ScoreStatisticListDataController}，
 * {@link ScoreStatisticUpdateDataController}
 * </p>
 * 
 * @author 李春
 * @time 2017年1月30日 下午3:08:34
 */
@Controller
public class ScoreStatisticListDataController {
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
	 * 验证访问权限
	 * 
	 * @param request
	 */
	// @ModelAttribute
	public void verifyAnthority(HttpServletRequest request) {
		Persion persion = (Persion) request.getSession().getAttribute("user");
		if (persion instanceof Teacher) {
			Teacher teacher = (Teacher) persion;
			teacher.getId();
		} else if (persion instanceof Student) {
			Student student = (Student) persion;
			if (student.getRole() == null)
				throw new RuntimeException("非班委无法访问");
			;
		}
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
	 * 下载成绩表
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
		String fileName = "";
		String rootPath = request.getSession().getServletContext()
				.getRealPath("/");
		String subPath = FileUtil.DIRECTROY_TEMP_FILE + UUID.randomUUID()
				+ ".xls";
		path = rootPath + subPath;
		// 测评学期
		Term term = termService.getTermById(Integer.parseInt(termId));
		// 测评班级
		Clazz clazz = null;
		if (classId != null && classId.length() > 0)
			clazz = classService.findClazzById(Integer.parseInt(classId));
		try {
			switch (tableType) {
			case "zhcp":
				excelService.exportExcelFileOfZHCPCJTJ(termId, classId, order,
						false, path);
				fileName += "综合测评成绩统计表";
				break;
			case "szjf":
				excelService.exportExcelFileOfSZJYJFPF(termId, classId, order,
						false, path);
				fileName += "素质学分日常行为部分评分表";
				break;
			case "rcxw":
				excelService.exportExcelFileOfSZXFRCXWBFPF(termId, classId,
						order, false, path);
				fileName += "素质教育加分评分表";
				break;
			default:
				throw new RuntimeException("您指定的成绩表类型不正确");
			}
			// 设置文件名称
			if (clazz != null) {
				fileName += clazz.getClassId() + "班";
			} else {
				fileName += term.getName() + "年度";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\",\"tip\":\"" + e.getMessage() + "\"}";
		}
		return "{\"result\":\"success\",\"url\":\"downloadFile.do?path="
				+ Base64Util.encode(subPath) + "&fileName=" + fileName + "\"}";
	}
}
