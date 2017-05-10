package cn.xuemengzihe.sylu.ces.controller.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xuemengzihe.sylu.ces.dao.com.ComplexFunction;
import cn.xuemengzihe.sylu.ces.dao.com.TermClassDAO;
import cn.xuemengzihe.sylu.ces.pojo.com.Persion;
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
			} else {
				if (persion.getRole() == null) {
					throw new RuntimeException("您不是班委，没有修改权限");
				}
				// 判断与被修改人是否是同一个班级，如果是同一个班级，则肯定能通过该方法查询到自己的一条记录
				if (null == tableZHCPCJTJServcie.getRecordDetailWithTermIdSno(
						term.getId(), null, persion.getId())) {
					throw new RuntimeException("您没有权限修改其他班级的数据");
				}
				// 修改状态
				record.setIsValid("T");
			}
			record.setPingJunXueFenJiDian(xfjd);
			tableZHCPCJTJServcie.updateRecord(record);
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\",\"tip\":\"" + e.getMessage()
					+ "，修改失败！\"}";
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
			} else {
				if (persion.getRole() == null) {
					throw new RuntimeException("您不是班委，没有修改权限");
				}
				// 判断与被修改人是否是同一个班级，如果是同一个班级，则肯定能通过该方法查询到自己的一条记录
				if (null == tableZHCPCJTJServcie.getRecordDetailWithTermIdSno(
						term.getId(), null, persion.getId())) {
					throw new RuntimeException("您没有权限修改其他班级的数据");
				}
				// 班委可以修改的属性
				oldRecord.setAiHuGongWu(record.getAiHuGongWu());
				oldRecord.setCanJiaHuoDong(record.getCanJiaHuoDong());
				oldRecord.setChengXinLiShen(record.getChengXinLiShen());
				oldRecord.setSheHuiGongDe(record.getSheHuiGongDe());
				oldRecord.setTiYuDuanLian(record.getTiYuDuanLian());
				oldRecord.setWenMingJiaoWang(record.getWenMingJiaoWang());
				oldRecord.setXueXiaoGuiDing(record.getXueXiaoGuiDing());
				if ("Y".equals(oldRecord.getIsValid()))
					oldRecord.setIsValid("T"); // 修改这个状态
				zhRecord.setIsValid("T");
				tableZHCPCJTJServcie.updateRecord(zhRecord); // 标记审核状态
			}
			tableSZXFRCXWBFPFService.updateRecord(oldRecord);
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\",\"tip\":\"" + e.getMessage()
					+ "，修改失败！\"}";
		}
		return "{\"result\":\"success\",\"tip\":\"修改成功！\"}";
	}

}
