package cn.xuemengzihe.sylu.ces.controller.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xuemengzihe.sylu.ces.pojo.com.Teacher;
import cn.xuemengzihe.sylu.ces.service.web.TeacherService;
import cn.xuemengzihe.sylu.ces.util.JSONUtil;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Teacher Controller</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年2月5日 上午11:11:37
 */
@Controller
public class TeacherController {
	@Autowired
	private TeacherService teacherService;

	/**
	 * 教师信息概览页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/teacherInfo")
	public String teacherInfo(Model model) {
		return "/teacher/teacherInfo";
	}

	/**
	 * 添加老师操作
	 * 
	 * @param teacher
	 * @return 返回添加的提示信息
	 */
	@ResponseBody
	@RequestMapping(value = "teacherAdd", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String teacherAdd(Teacher teacher) {
		// 服务器校验
		int result = teacherService.insertTeacher(teacher);
		if (result == 1) {
			return "{}"; // 返回空，表示成功
		}
		return "{\"tip\":\"添加失败！\"}"; // 返回tip，包含错误信息
	}

	@ResponseBody
	@RequestMapping(value = "teacherUpdate", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String teacherUpdate(Teacher teacher) {
		// TODO 数据完整性校验
		Teacher oldTeacher = teacherService.findTeacherById(teacher.getId());
		if (oldTeacher == null) {
			return "{\"tip\":\"您要修改的记录不存在！\"}";
		}
		// 赋值
		oldTeacher.setAddress(teacher.getAddress());
		oldTeacher.setAlipay(teacher.getAlipay());
		oldTeacher.setBirthday(teacher.getBirthday());
		oldTeacher.setClazzs(teacher.getClazzs());
		oldTeacher.setEmail(teacher.getEmail());
		oldTeacher.setGender(teacher.getGender());
		oldTeacher.setIdCard(teacher.getIdCard());
		oldTeacher.setMotto(teacher.getMotto());
		oldTeacher.setName(teacher.getName());
		oldTeacher.setNation(teacher.getNation());
		oldTeacher.setNick(teacher.getNick());
		oldTeacher.setPhone(teacher.getPhone());
		oldTeacher.setQqNumb(teacher.getQqNumb());
		oldTeacher.setResident(teacher.getResident());
		oldTeacher.setWeChat(teacher.getWeChat());
		oldTeacher.setRole(teacher.getRole());
		oldTeacher.setUserType(teacher.getUserType());

		// 更新
		int result = teacherService.updateTeacher(oldTeacher);
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
	@RequestMapping(value = "teacherDelete", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String teacherDelete(Integer id) {
		Teacher oldTeacher = teacherService.findTeacherById(id);
		if (oldTeacher == null || "N".equals(oldTeacher.getIsValid())) {
			return "{\"tip\":\"您要删除的记录不存在或者已经删除！\"}";
		}
		oldTeacher.setIsValid("N"); // 设置删除标记
		teacherService.updateTeacher(oldTeacher); // 删除
		return "{}";
	}

	/**
	 * 查询所有当前的所有老师，其内容将使用{@link #teacherData(String, Integer, Integer) }
	 * 方式获取（JSON格式）
	 * 
	 * @return
	 */
	@RequestMapping("/teacherList")
	public String teacherList() {
		// 分页查询记录
		// PageInfo<Teacher> list =
		// teacherService.findTeachersOfPage(null);
		// 将数据分装的模型中
		// model.addAttribute("list", list);
		// 返回页面
		return "/teacher/teacherList";
	}

	/**
	 * 老师列表，以分页形式返回JSON数据
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
	@RequestMapping(value = "/teacherData", produces = "application/json; charset=utf-8")
	public String teacherData(
			String search,
			@RequestParam(value = "offset", required = true, defaultValue = "0") Integer offset,
			@RequestParam(value = "limit", required = true, defaultValue = "10") Integer limit) {
		PageInfo<Map<String, String>> pageInfo = new PageInfo<>();
		pageInfo.setPageSize(limit);
		pageInfo.setPageNum(offset / limit + 1);
		if (search != null) // 防止SQL注入攻击
			search = search.trim().replace("'", "");
		// 分页查询记录
		pageInfo = teacherService
				.findTeachersOfPageWithMapSet(pageInfo, search);
		// 将数据分装的模型中
		// 返回页面
		return JSONUtil.parsePageInfoToJSON(pageInfo);
	}
}
