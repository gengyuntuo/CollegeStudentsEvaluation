package cn.xuemengzihe.sylu.ces.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xuemengzihe.sylu.ces.pojo.com.Persion;
import cn.xuemengzihe.sylu.ces.pojo.com.Student;
import cn.xuemengzihe.sylu.ces.pojo.com.Teacher;
import cn.xuemengzihe.sylu.ces.service.web.ComplexFunctionService;
import cn.xuemengzihe.sylu.ces.service.web.MessageService;
import cn.xuemengzihe.sylu.ces.util.JSONUtil;

import com.github.pagehelper.PageInfo;

/**
 * <h1>Message Controller</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年1月30日 下午3:08:34
 */
@Controller
public class MessageController {
	@Autowired
	private MessageService msgService;
	@Autowired
	private ComplexFunctionService complexFunctionService;

	@RequestMapping("/inbox")
	public String inbox() {
		return "/message/inbox";
	}

	@RequestMapping("/outbox")
	public String outbox() {
		return "/message/outbox";
	}

	@RequestMapping("/writeMessage")
	public String writeMessage() {
		return "/message/writeMessage";
	}

	/**
	 * 获取收件人列表
	 * 
	 * @param request
	 * @param search
	 *            搜索条件
	 * @param page
	 *            页码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getReceiver", produces = "application/json; charset=utf-8")
	public String getReceiver(HttpServletRequest request,
			@RequestParam(required = true) String search,
			@RequestParam(required = true, defaultValue = "1") Integer page) {
		Persion persion = (Persion) request.getSession().getAttribute("user");
		PageInfo<Map<String, String>> pageInfo = new PageInfo<>();
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(10); // 每次返回10条数据
		if (persion instanceof Teacher) { // 教师
			pageInfo = complexFunctionService.getReceiver(pageInfo, search,
					null);
		} else { // 学生
			pageInfo = complexFunctionService.getReceiver(pageInfo, search,
					((Student) persion).getClazzId().toString());
		}
		return JSONUtil.parsePageInfoToJSONWithPageNumber(pageInfo);
	}

	@ResponseBody
	@RequestMapping(value = "/getNewMessage", produces = "application/json; charset=utf-8")
	public String getNewMessage(HttpServletRequest request) {
		Persion persion = (Persion) request.getSession().getAttribute("user");
		PageInfo<Map<String, String>> pageInfo = new PageInfo<>();
		pageInfo.setPageSize(5); // 查询5条消息
		pageInfo = msgService.findMessageWithMap(pageInfo,
				MessageService.MODE_MSG_RECEIVE,
				persion instanceof Teacher ? MessageService.USERTYPE_TEACHER
						: MessageService.USERTYPE_STUDENT, persion.getId(),
				MessageService.STATE_UNREADED);
		return JSONUtil.parsePageInfoToJSONUseForMessageDetect(pageInfo);
	}
}
