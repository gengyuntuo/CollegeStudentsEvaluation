package cn.xuemengzihe.sylu.ces.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xuemengzihe.sylu.ces.service.web.TermService;

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
	 * @return
	 */
	@RequestMapping("createScoreStatic")
	public String createScoreStatic(String term, String[] classes) {
		return "";
	}

}
