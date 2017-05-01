package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xuemengzihe.sylu.ces.pojo.com.Setting;
import cn.xuemengzihe.sylu.ces.service.web.SettingService;
import cn.xuemengzihe.sylu.ces.service.web.WebParseService;
import cn.xuemengzihe.util.webparse.WPClient;
import cn.xuemengzihe.util.webparse.conf.ConfigName;

/**
 * <h1>解析教学网上的成绩</h1>
 * <p>
 * 注意：联网操作时耗时操作
 * </p>
 * 
 * @author 李春
 * @time 2017年5月1日 下午7:55:17
 */
@Service
public class WebParseServiceImpl implements WebParseService {

	private final Logger logger = LoggerFactory
			.getLogger(WebParseServiceImpl.class);

	@Autowired
	private SettingService settingService;

	@Override
	public List<Map<String, String>> loadScoreSheet(String studentSno,
			String password, String grade) {
		WPClient client = null;
		List<Map<String, String>> result = null;
		try {
			client = new WPClient(studentSno, password);
			result = client.queryScore(grade, "", ConfigName.BTN_学年成绩);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Double obtainXFJD(String studentSno, String password, String grade) {
		// 获取学年成绩
		List<Map<String, String>> scoreList = this.loadScoreSheet(studentSno,
				password, grade);

		// 从数据库中查询对应的所有的课程性质,然后获取计算学分绩点的课程
		List<String> validClassType = getValidStaticClass();

		scoreList = this.getValidScoreList(scoreList, validClassType); // 有效的成绩列表

		// 计算学分绩点
		Double score = 0.;
		Double totalScore = 0.;
		Double totalScoreMultiJiDian = 0.;
		boolean flag = true; // 评优资格
		for (Map<String, String> var : scoreList) {
			if (flag && !"失去评优资格".equals(var.get("备注")))
				flag = false;
			score = Double.parseDouble(var.get("学分"));
			totalScore += score;
			totalScoreMultiJiDian += Double.parseDouble(var.get("绩点")) * score;
			logger.debug("参加学分绩点计算的科目：" + var.get("课程名称"));
		}
		return totalScoreMultiJiDian / totalScore;
	}

	/**
	 * 获取计算学分绩点的课程性质
	 * 
	 * @return
	 */
	private List<String> getValidStaticClass() {
		Map<String, String> conditions = new HashMap<String, String>();
		conditions.put("type", "score-static");
		conditions.put("owner_type", "CC");
		conditions.put("group", "score");
		List<Setting> settings = settingService.findSettings(conditions);
		// 获取计算学分的课程性质
		List<String> validClassType = new ArrayList<>(); // 有效的课程类别
		for (Setting set : settings) {
			if ("valid".equals(set.getValue())) {
				validClassType.add(set.getSetting());
			}
		}
		return validClassType;
	}

	/**
	 * 获取有效的课程性质<br/>
	 * <ul>
	 * <li>1. 如果计算绩点的学科中有挂科，则失去评优资格</li>
	 * <li>2. 如果未挂科，且当前学期重修该学科，则取最高分</li>
	 * <li>3. 二考通过的绩点为1，且失去评优资格</li>
	 * <li>3. 非本学期的重修课程不会影响本学期评优</li>
	 * </ul>
	 * 
	 * @param scoreList
	 * @return
	 */
	private List<Map<String, String>> getValidScoreList(
			List<Map<String, String>> scoreList, List<String> validClassType) {
		Map<String, Map<String, String>> reStudyMap = new HashMap<>(); // 重修
		Map<String, Map<String, String>> validScoreMap = new HashMap<>(); // 非重修

		// 判断课程是否计算绩点，计算绩点的课程还要判断是否为重修
		for (Map<String, String> classScore : scoreList) {
			// 判断当前课程的课程性质是否计算绩点
			if (validClassType.contains(classScore.get("课程性质"))) {
				// 如果计算绩点，则判断当前课程是否属于重修，放入对应的列中
				if ("重修".equals(classScore.get("重修标记").trim())) {
					reStudyMap.put(classScore.get("课程代码"), classScore);
				} else {
					// 非重修，判断绩点是否大于1，大于1说明未挂科，如果未挂科还要判断是否有二考成绩，
					// 如果有二考成绩，在备注中添加说明
					if (Double.parseDouble(classScore.get("绩点")) < 1
							|| classScore.get("补考成绩").trim().length() > 0) {
						classScore.put("备注", "失去评优资格");
					}
					validScoreMap.put(classScore.get("课程代码"), classScore);
				}
			}
		}

		// 检查重修列表，如果重修列表中包含本学期的课程，则选择最高分作为记录，
		// 如果重修课第一次为挂科，则在key:备注中添加value:失去评优资格
		for (String key : reStudyMap.keySet()) {
			if (validScoreMap.containsKey(key)) {
				// 判断重修后的绩点和原来课程的绩点大小，选择最大绩点
				if (Double.parseDouble(validScoreMap.get(key).get("绩点")) < Double
						.parseDouble(reStudyMap.get(key).get("绩点"))) {
					validScoreMap.get(key).put("绩点",
							reStudyMap.get(key).get("绩点"));
				}
			}
		}

		// 将结果转回List集合
		scoreList.clear();
		for (String key : validScoreMap.keySet()) {
			scoreList.add(validScoreMap.get(key));
		}
		return scoreList;
	}
}
