package cn.xuemengzihe.sylu.ces.controller.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xuemengzihe.sylu.ces.pojo.com.Major;
import cn.xuemengzihe.sylu.ces.service.web.MajorService;
import cn.xuemengzihe.sylu.ces.util.JSONUtil;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Major Controller</h1>
 * <p>
 * 专业
 * </p>
 * 
 * @author 李春
 * @time 2017年1月30日 下午3:08:34
 */
@Controller
public class MajorController {
	@Autowired
	private MajorService majorService;

	@RequestMapping("/majorInfo")
	public String majorInfo(Model model) {
		return "/major/majorInfo";
	}

	/**
	 * 添加专业操作
	 * 
	 * @param major
	 * @return 返回添加的提示信息
	 */
	@ResponseBody
	@RequestMapping(value = "majorAdd", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String majorAdd(Major major) {
		// 服务器校验
		int result = majorService.insertMajor(major);
		if (result == 1) {
			return "{}"; // 返回空，表示成功
		}
		return "{\"tip\":\"添加失败！\"}"; // 返回tip，包含错误信息
	}

	@ResponseBody
	@RequestMapping(value = "majorUpdate", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String majorUpdate(Major major) {
		// TODO 数据完整性校验
		Major oldMajor = majorService.findMajorById(major.getId());
		if (oldMajor == null) {
			return "{\"tip\":\"您要修改的记录不存在！\"}";
		}
		// 赋值
		oldMajor.setmNumb(major.getmNumb());
		oldMajor.setmName(major.getmName());
		oldMajor.setDesc(major.getDesc());

		// 更新
		int result = majorService.updateMajor(oldMajor);
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
	@RequestMapping(value = "majorDelete", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String instituteDelete(Integer id) {
		Major oldMajor = majorService.findMajorById(id);
		if (oldMajor == null || "N".equals(oldMajor.getIsValid())) {
			return "{\"tip\":\"您要删除的记录不存在或者已经删除！\"}";
		}
		oldMajor.setIsValid("N");
		; // 设置删除标记
		majorService.updateMajor(oldMajor); // 删除
		return "{}";
	}

	/**
	 * 查询所有当前的所有学院，其内容将使用{@link #majorData(String, Integer, Integer) }
	 * 方式获取（JSON格式）
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/majorList")
	public String majorList(Model model) {
		return "/major/majorList";
	}

	/**
	 * 专业列表，以分页形式返回JSON数据
	 * 
	 * @param search
	 *            查询条件
	 * @param offset
	 *            偏移量
	 * @param limit
	 *            页大小
	 * @return JSON
	 */
	@ResponseBody
	// produces 参数的目的是解决中文乱码问题
	@RequestMapping(value = "/majorData", produces = "application/json; charset=utf-8")
	public String majorData(
			String search,
			@RequestParam(value = "offset", required = true, defaultValue = "0") Integer offset,
			@RequestParam(value = "limit", required = true, defaultValue = "10") Integer limit) {
		PageInfo<Map<String, String>> pageInfo = new PageInfo<>();
		pageInfo.setPageSize(limit);
		pageInfo.setPageNum(offset / limit + 1);
		if (search != null) // 防止SQL注入攻击
			search = search.trim().replace("'", "");
		// 分页查询记录
		pageInfo = majorService.findMajorsOfPageWithMapSet(pageInfo, search);
		// 将数据分装的模型中
		// 返回页面
		return JSONUtil.parsePageInfoToJSON(pageInfo);
	}
}
