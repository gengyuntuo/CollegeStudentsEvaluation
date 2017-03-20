package cn.xuemengzihe.sylu.ces.controller.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xuemengzihe.sylu.ces.pojo.com.Institute;
import cn.xuemengzihe.sylu.ces.service.web.InstituteService;
import cn.xuemengzihe.sylu.ces.util.JSONUtil;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Institute Controller</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年1月31日 下午8:40:53
 */
@Controller
public class InstituteController {
	@Autowired
	private InstituteService instituteService;

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/instituteInfo")
	public String instituteInfo(Model model) {
		// 分页查询记录
		PageInfo<Institute> list = instituteService.findInstitutesOfPage(null);
		// 将数据分装的模型中
		model.addAttribute("list", list);
		// 返回页面
		return "/institute/instituteInfo";
	}

	/**
	 * 查询所有当前的所有学院，其内容将使用{@link #instituteData(Model) }方式获取（JSON格式）
	 * 
	 * @return
	 */
	@RequestMapping("/instituteList")
	public String instituteList(Model model) {
		// 分页查询记录
		PageInfo<Institute> list = instituteService.findInstitutesOfPage(null);
		// 将数据分装的模型中
		model.addAttribute("list", list);
		// 返回页面
		return "/institute/instituteList";
	}

	@ResponseBody
	// produces 参数的目的是解决中文乱码问题
	@RequestMapping(value = "/instituteData", produces = "application/json; charset=utf-8")
	public String instituteData() {
		// 分页查询记录
		PageInfo<Map<String, String>> list = instituteService
				.findInstitutesOfPageWithMapSet(null);
		// 将数据分装的模型中
		// 返回页面
		return JSONUtil.parseListToJSON(list.getList());
	}
}
