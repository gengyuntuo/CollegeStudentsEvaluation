package cn.xuemengzihe.sylu.ces.controller.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xuemengzihe.sylu.ces.dao.com.ComplexFunction;
import cn.xuemengzihe.sylu.ces.dao.com.TermClassDAO;
import cn.xuemengzihe.sylu.ces.pojo.com.Persion;
import cn.xuemengzihe.sylu.ces.pojo.com.Student;
import cn.xuemengzihe.sylu.ces.pojo.com.TableSZJYJFPF;
import cn.xuemengzihe.sylu.ces.pojo.com.TableSZJYJFSQ;
import cn.xuemengzihe.sylu.ces.pojo.com.TableSZXFRCXWBFPF;
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
public class ScoreStatisticUpdateDataController {
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
	 * 班长或者教师在列表界面修改综合测评成绩统计表<br/>
	 * <b>注意：</b>仅仅可以修改平均学分绩点
	 * 
	 * @param request
	 * @param record
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateTableZHCPCJTJ", produces = "application/json; charset=utf-8")
	public String updateTableZHCPCJTJ(HttpServletRequest request,
			TableZHCPCJTJ record) {
		try {
			Persion persion = (Persion) request.getSession().getAttribute(
					"user");
			double xfjd = record.getPingJunXueFenJiDian();
			record = tableZHCPCJTJServcie.getRecordById(record.getId());
			if (record == null) {
				throw new RuntimeException("您修改的综合测评表不存在");
			}
			Term term = termService.getTermById(record.getTermId());
			if (term == null) {
				throw new RuntimeException("您修改的综合测评表缺少测评主体，该主体可能已经被删除");
			}
			if (new Date().getTime() > term.getStopDate().getTime()) {
				throw new RuntimeException("该测评活动已经结束");
			}
			if (persion instanceof Teacher) {
				if (term.getTeacherId() != persion.getId()) {
					throw new RuntimeException("您无法修改非自己创建的测评表");
				}
				record.setIsValid("Y");
			} else {
				if (persion.getRole() == null) {
					throw new RuntimeException("您不是班委，没有修改权限");
				}
				// 判断与被修改人是否是同一个班级
				if (((Student) persion).getClassId() != studentServcice
						.findStudentBySno(record.getSno()).getClassId())
					throw new RuntimeException("无权操作非班级的测评数据");
				// 修改状态
				record.setIsValid("T");
			}
			record.setPingJunXueFenJiDian(xfjd);
			tableZHCPCJTJServcie.updateRecord(record);
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\",\"tip\":\"" + e.getMessage() + "\"}";
		}
		return "{\"result\":\"success\",\"tip\":\"修改成功！\"}";
	}

	/**
	 * 班长或者教师在列表界面修改素质学分日常行为部分评分表<br/>
	 * 
	 * @param request
	 * @param record
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateTableSZXFRCXWBFPF", produces = "application/json; charset=utf-8")
	public String updateTableSZXFRCXWBFPF(HttpServletRequest request,
			TableSZXFRCXWBFPF record) {
		try {
			Persion persion = (Persion) request.getSession().getAttribute(
					"user");
			TableSZXFRCXWBFPF oldRecord = tableSZXFRCXWBFPFService
					.getRecordById(record.getId());
			if (oldRecord == null) {
				throw new RuntimeException("您修改的日常行为部分评分表不存在");
			}
			TableZHCPCJTJ zhRecord = tableZHCPCJTJServcie
					.getRecordById(oldRecord.getZongHeId());
			Term term = termService.getTermById(zhRecord.getTermId());
			if (term == null) {
				throw new RuntimeException("您修改的日常行为部分评分表缺少测评主体，该主体可能已经被删除");
			}
			if (new Date().getTime() > term.getStopDate().getTime()) {
				throw new RuntimeException("该测评活动已经结束");
			}
			if (persion instanceof Teacher) {
				if (term.getTeacherId() != persion.getId()) {
					throw new RuntimeException("您无法修改非自己创建的测评表");
				}
				// 老师可以修改的属性
				oldRecord.setAiHuGongWu(record.getAiHuGongWu());
				oldRecord.setCanJiaHuoDong(record.getCanJiaHuoDong());
				oldRecord.setChengXinLiShen(record.getChengXinLiShen());
				oldRecord.setGongYuJianCha(record.getGongYuJianCha());
				oldRecord.setSheHuiGongDe(record.getSheHuiGongDe());
				oldRecord.setTiYuDuanLian(record.getTiYuDuanLian());
				oldRecord.setTingKeJiLu(record.getTingKeJiLu());
				oldRecord.setWenMingJiaoWang(record.getWenMingJiaoWang());
				oldRecord.setXueXiaoGuiDing(record.getXueXiaoGuiDing());
				oldRecord.setIsValid("Y");
			} else {
				if (persion.getRole() == null) {
					throw new RuntimeException("您不是班委，没有修改权限");
				}
				// 判断与被修改人是否是同一个班级
				if (((Student) persion).getClassId() != studentServcice
						.findStudentBySno(zhRecord.getSno()).getClassId())
					throw new RuntimeException("无权操作非班级的测评数据");
				// 班委可以修改的属性
				oldRecord.setAiHuGongWu(record.getAiHuGongWu());
				oldRecord.setCanJiaHuoDong(record.getCanJiaHuoDong());
				oldRecord.setChengXinLiShen(record.getChengXinLiShen());
				oldRecord.setSheHuiGongDe(record.getSheHuiGongDe());
				oldRecord.setTiYuDuanLian(record.getTiYuDuanLian());
				oldRecord.setWenMingJiaoWang(record.getWenMingJiaoWang());
				oldRecord.setXueXiaoGuiDing(record.getXueXiaoGuiDing());
				// if ("Y".equals(oldRecord.getIsValid()))
				oldRecord.setIsValid("T"); // 修改这个状态
				// zhRecord.setIsValid("T");
				// tableZHCPCJTJServcie.updateRecord(zhRecord); // 标记审核状态
			}
			tableSZXFRCXWBFPFService.updateRecord(oldRecord);
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\",\"tip\":\"" + e.getMessage() + "\"}";
		}
		return "{\"result\":\"success\",\"tip\":\"修改成功！\"}";
	}

	/**
	 * 更新和设置记录的状态 (M ： 班委待审核，T ：教师待审核，Y：审核通过，N ： 未通过审核）
	 * 
	 * @param request
	 * @param model
	 * @param tableType
	 *            表名
	 * @param state
	 *            审核结果
	 * @param item
	 *            ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateTableState", produces = "application/json; charset=utf-8")
	public String updateTableState(HttpServletRequest request, Model model,
			@RequestParam(required = true) String tableType,
			@RequestParam(required = true) boolean state,
			@RequestParam(required = true) Integer termId,
			@RequestParam(required = true) Integer item) {
		Persion persion = (Persion) request.getSession().getAttribute("user");
		boolean isTeacher = true;
		String result = null;
		Term term = null;
		try {
			term = termService.getTermById(termId);
			if (term == null) {
				throw new RuntimeException("termId参数无效");
			}
			if (term.getStopDate().getTime() - new Date().getTime() < 0) {
				throw new RuntimeException("已经到达截止日期，无法修改");
			}
			if (persion instanceof Teacher) {
				isTeacher = true;
			} else {
				isTeacher = false;
			}
			switch (tableType) {
			case "szjfsq": // 素质加分申请
				result = updateSZJFSQTableState(term, persion, isTeacher, item,
						state);
				break;
			case "szjf": // 素质加分
				// 无需操作
				break;
			case "rcxw": // 日常行为
				result = updateRCXWTableState(term, persion, isTeacher, item,
						state);
				break;
			case "zhcp": // 综合测评
				result = updateZHCPTableState(term, persion, isTeacher, item,
						state);
				break;
			default:
				throw new RuntimeException("表名参数不正确");
			}
		} catch (Exception e) {
			return "{\"result\":\"error\",\"tip\":\"" + e.getMessage() + "\"}";
		}
		return "{\"result\":\"success\",\"tip\":\"" + result + "\"}";
	}

	/**
	 * 修改综合成绩测评表记录的状态
	 * 
	 * @param term
	 * @param persion
	 * @param isTeacher
	 * @param item
	 * @param state
	 * @return
	 */
	private String updateZHCPTableState(Term term, Persion persion,
			boolean isTeacher, Integer item, boolean state) {
		String result = null;
		TableZHCPCJTJ tableZHCPCJTJ = null;
		tableZHCPCJTJ = tableZHCPCJTJServcie.getRecordById(item);
		if (tableZHCPCJTJ == null)
			throw new RuntimeException("item参数不正确");
		// 如果教师已经审核，无需修改
		if ("Y".equals(tableZHCPCJTJ.getIsValid()))
			return "Y";
		if (isTeacher) {
			if (term.getId() != tableZHCPCJTJ.getTermId())
				throw new RuntimeException("item或termId参数不正确");
			if (term.getTeacherId() != persion.getId())
				throw new RuntimeException("无法操作非自己的数据");
			result = "Y";
		} else {
			if (persion.getRole() == null)
				throw new RuntimeException("您不是班委，无权修改");
			if (((Student) persion).getClassId() != studentServcice
					.findStudentBySno(tableZHCPCJTJ.getSno()).getClassId())
				throw new RuntimeException("无权操作非班级的测评数据");
			result = "T";
		}
		tableZHCPCJTJ.setIsValid(result);
		tableZHCPCJTJServcie.updateRecord(tableZHCPCJTJ);
		return result;
	}

	/**
	 * 修改日常行为评分表记录的状态
	 * 
	 * @param term
	 * @param persion
	 * @param isTeacher
	 * @param item
	 * @param state
	 * @return
	 */
	private String updateRCXWTableState(Term term, Persion persion,
			boolean isTeacher, Integer item, boolean state) {
		String result = null;
		TableSZXFRCXWBFPF tableSZXFRCXWBFPF = null;
		TableZHCPCJTJ tableZHCPCJTJ = null;
		tableSZXFRCXWBFPF = tableSZXFRCXWBFPFService.getRecordById(item);
		if (tableSZXFRCXWBFPF == null)
			throw new RuntimeException("item参数不正确");
		// 如果教师已经审核，无需修改
		if ("Y".equals(tableSZXFRCXWBFPF.getIsValid()))
			return "Y";
		tableZHCPCJTJ = tableZHCPCJTJServcie.getRecordById(tableSZXFRCXWBFPF
				.getZongHeId());
		if (tableZHCPCJTJ == null)
			throw new RuntimeException("该评分表对应的综合测评表不存在");
		if (term.getId() != tableZHCPCJTJ.getTermId())
			throw new RuntimeException("item参数不正确");
		if (isTeacher) {
			if (term.getTeacherId() != persion.getId())
				throw new RuntimeException("无法操作非自己的数据");
			result = "Y";
		} else {
			if (((Student) persion).getClassId() != studentServcice
					.findStudentBySno(tableZHCPCJTJ.getSno()).getClassId())
				throw new RuntimeException("无权操作非班级的测评数据");
			if (persion.getRole() == null)
				throw new RuntimeException("您不是班委，无权修改");
			result = "T";
		}
		tableSZXFRCXWBFPF.setIsValid(result);
		tableSZXFRCXWBFPFService.updateRecord(tableSZXFRCXWBFPF);
		return result;
	}

	/**
	 * 修改素质加分申请表记录的状态<br/>
	 * (M ： 班委待审核，T ：教师待审核，Y：审核通过，N ： 未通过审核）
	 * 
	 * @param term
	 * @param persion
	 * @param isTeacher
	 * @param state
	 * @return
	 */
	private String updateSZJFSQTableState(Term term, Persion persion,
			boolean isTeacher, Integer item, boolean state) {
		TableSZJYJFSQ tableSZJYJFSQ = null;
		TableSZJYJFPF tableSZJYJFPF = null;
		TableZHCPCJTJ tableZHCPCJTJ = null;
		String result = null;

		tableSZJYJFSQ = tableSZJYJFSQServcie.getRecordById(item);
		if (tableSZJYJFSQ == null)
			throw new RuntimeException("item参数不正确");
		tableSZJYJFPF = tableSZJYJFPFService.getRecordById(tableSZJYJFSQ
				.getSuZhiId());
		if (tableSZJYJFPF == null)
			throw new RuntimeException("该记录找不到对应的素质加分评分表");
		tableZHCPCJTJ = tableZHCPCJTJServcie.getRecordById(tableSZJYJFPF
				.getZongHeId());
		if (tableZHCPCJTJ == null)
			throw new RuntimeException("该记录找不到对应的综合成绩评分表");
		if (term.getId() != tableZHCPCJTJ.getTermId())
			throw new RuntimeException("该记录与指定的termId参数不符");

		if (isTeacher) {
			if (term.getTeacherId() != persion.getId())
				throw new RuntimeException("无权操作非本人的测评数据");
			if (state) {
				tableSZJYJFSQ.setIsValid("Y");
				result = "Y";
			} else {
				tableSZJYJFSQ.setIsValid("N");
				result = "N";
			}
		} else {
			if (((Student) persion).getClassId() != studentServcice
					.findStudentBySno(tableZHCPCJTJ.getSno()).getClassId())
				throw new RuntimeException("无权操作非班级的测评数据");
			if (persion.getRole() == null)
				throw new RuntimeException("您不是班委，无权修改");
			if ("Y".equals(tableSZJYJFSQ.getIsValid()))
				throw new RuntimeException("已经通过老师审核，无法修改");
			if (state) {
				tableSZJYJFSQ.setIsValid("T");
				result = "T";
			} else {
				tableSZJYJFSQ.setIsValid("N");
				result = "N";
			}
			// 由于班委的改动，所以需要对综合测评表的状态进行修改
		}
		tableSZJYJFSQServcie.updateRecord(tableSZJYJFSQ);
		compexFunction.updateSZJFCPTable(tableSZJYJFSQ.getSuZhiId()); // 更新素质测评评分表成绩
		return result;
	}
}
