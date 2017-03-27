package cn.xuemengzihe.sylu.ces.controller.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	 * 学院信息概览
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
	 * 添加学院操作
	 * 
	 * @param institute
	 * @return 返回添加的提示信息
	 */
	@ResponseBody
	@RequestMapping(value = "instituteAdd", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String instituteAdd(Institute institute) {
		// 服务器校验
		int result = instituteService.insertInstitute(institute);
		if (result == 1) {
			return "{}"; // 返回空，表示成功
		}
		return "{\"tip\":\"添加失败！\"}"; // 返回tip，包含错误信息
	}

	@ResponseBody
	@RequestMapping(value = "instituteUpdate", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String instituteUpdate(Institute institute) {
		// TODO 数据完整性校验
		Institute oldInstitute = instituteService.findInstituteById(institute
				.getId());
		if (oldInstitute == null) {
			return "{\"tip\":\"您要修改的记录不存在！\"}";
		}
		// 赋值
		oldInstitute.setiNumb(institute.getiNumb());
		oldInstitute.setiName(institute.getiName());
		oldInstitute.setDesc(institute.getDesc());

		// 更新
		int result = instituteService.updateInstitute(oldInstitute);
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
	@RequestMapping(value = "instituteDelete", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String instituteDelete(Integer id) {
		Institute oldInstitute = instituteService.findInstituteById(id);
		if (oldInstitute == null || "N".equals(oldInstitute.getIsValid())) {
			return "{\"tip\":\"您要删除的记录不存在或者已经删除！\"}";
		}
		oldInstitute.setIsValid("N"); // 设置删除标记
		instituteService.updateInstitute(oldInstitute); // 删除
		return "{}";
	}

	/**
	 * 查询所有当前的所有学院，其内容将使用{@link #instituteData(String, Integer, Integer) }
	 * 方式获取（JSON格式）
	 * 
	 * @return
	 */
	@Deprecated
	@RequestMapping("/instituteList")
	public String instituteList() {
		// 分页查询记录
		// PageInfo<Institute> list =
		// instituteService.findInstitutesOfPage(null);
		// 将数据分装的模型中
		// model.addAttribute("list", list);
		// 返回页面
		return "/institute/instituteList";
	}

	/**
	 * 学院列表，以分页形式返回JSON数据
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
	@RequestMapping(value = "/instituteData", produces = "application/json; charset=utf-8")
	public String instituteData(
			String search,
			@RequestParam(value = "offset", required = true, defaultValue = "0") Integer offset,
			@RequestParam(value = "limit", required = true, defaultValue = "10") Integer limit) {
		PageInfo<Map<String, String>> pageInfo = new PageInfo<>();
		pageInfo.setPageSize(limit);
		pageInfo.setPageNum(offset / limit + 1);
		if (search != null) // 防止SQL注入攻击
			search = search.trim().replace("'", "");
		// 分页查询记录
		pageInfo = instituteService.findInstitutesOfPageWithMapSet(pageInfo,
				search);
		// 将数据分装的模型中
		// 返回页面
		return JSONUtil.parsePageInfoToJSON(pageInfo);
	}
}
