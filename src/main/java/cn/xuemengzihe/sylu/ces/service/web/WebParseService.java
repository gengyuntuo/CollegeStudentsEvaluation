package cn.xuemengzihe.sylu.ces.service.web;

import java.util.List;
import java.util.Map;

/**
 * <h1>解析教学网上的成绩</h1>
 * <p>
 * 注意：联网操作是耗时操作
 * </p>
 * 
 * @author 李春
 * @time 2017年5月1日 下午7:53:40
 */
public interface WebParseService {
	/**
	 * 学生查询学年成绩
	 * 
	 * @param studentSno
	 *            学生学号
	 * @param password
	 *            学生教学网密码
	 * @param grade
	 *            学期（例如：2013-2014）
	 * @return 成绩
	 */
	public List<Map<String, String>> loadScoreSheet(String studentSno,
			String password, String grade);

	/**
	 * 获的学生的学分绩点
	 * 
	 * @param studentSno
	 *            学生学号
	 * @param password
	 *            学生教学网密码
	 * @param grade
	 *            学期（例如：2013-2014）
	 * @return
	 */
	public Double obtainXFJD(String studentSno, String password, String grade);
}
