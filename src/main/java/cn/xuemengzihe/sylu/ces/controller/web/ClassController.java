package cn.xuemengzihe.sylu.ces.controller.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xuemengzihe.sylu.ces.pojo.com.Clazz;
import cn.xuemengzihe.sylu.ces.service.web.ClassService;
import cn.xuemengzihe.sylu.ces.util.JSONUtil;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Class Controller</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月5日 上午11:13:06
 */
@Controller
public class ClassController {
	@Autowired
	private ClassService classService;

	@RequestMapping("/classInfo")
	public String majorInfo(Model model) {
		PageInfo<Clazz> pageInfo = classService.findClazzsOfPage(null);
		model.addAttribute("pageInfo", pageInfo);
		return "/class/classInfo";
	}

	/**
	 * 添加班级操作
	 * 
	 * @param class
	 * @return 返回添加的提示信息
	 */
	@ResponseBody
	@RequestMapping(value = "classAdd", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String classAdd(Clazz clazz) {
		// 服务器校验
		int result = classService.insertClazz(clazz);
		if (result == 1) {
			return "{}"; // 返回空，表示成功
		}
		return "{\"tip\":\"添加失败！\"}"; // 返回tip，包含错误信息
	}

	@ResponseBody
	@RequestMapping(value = "classUpdate", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String classUpdate(Clazz clazz) {
		// TODO 数据完整性校验
		Clazz oldClazz = classService.findClazzById(clazz.getId());
		if (oldClazz == null) {
			return "{\"tip\":\"您要修改的记录不存在！\"}";
		}
		// 赋值
		oldClazz.setClassId(clazz.getClassId());
		oldClazz.setMajor(clazz.getMajor());
		oldClazz.setStartYear(clazz.getStartYear());
		oldClazz.setStudyYear(clazz.getStudyYear());
		oldClazz.setTeacherId(clazz.getTeacherId());

		// 更新
		int result = classService.updateClazz(oldClazz);
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
	@RequestMapping(value = "classDelete", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String classDelete(Integer id) {
		Clazz oldClazz = classService.findClazzById(id);
		if (oldClazz == null || "N".equals(oldClazz.getIsValid())) {
			return "{\"tip\":\"您要删除的记录不存在或者已经删除！\"}";
		}
		oldClazz.setIsValid("N"); // 设置删除标记
		classService.updateClazz(oldClazz); // 删除
		return "{}";
	}

	/**
	 * 查询所有当前的所有班级，其内容将使用{@link #classData(String, Integer, Integer) }
	 * 方式获取（JSON格式）
	 * 
	 * @return
	 */
	@RequestMapping("/classList")
	public String classList() {
		// 分页查询记录
		// PageInfo<Clazz> list =
		// classService.findClazzsOfPage(null);
		// 将数据分装的模型中
		// model.addAttribute("list", list);
		// 返回页面
		return "/class/classList";
	}

	/**
	 * 班级列表，以分页形式返回JSON数据
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
	@RequestMapping(value = "/classData", produces = "application/json; charset=utf-8")
	public String classData(
			String search,
			@RequestParam(value = "offset", required = true, defaultValue = "0") Integer offset,
			@RequestParam(value = "limit", required = true, defaultValue = "10") Integer limit) {
		PageInfo<Map<String, String>> pageInfo = new PageInfo<>();
		pageInfo.setPageSize(limit);
		pageInfo.setPageNum(offset / limit + 1);
		if (search != null) // 防止SQL注入攻击
			search = search.trim().replace("'", "");
		// 分页查询记录
		pageInfo = classService.findClazzsOfPageWithMapSet(pageInfo, search);
		// 将数据分装的模型中
		// 返回页面
		return JSONUtil.parsePageInfoToJSON(pageInfo);
	}
}
