package cn.xuemengzihe.sylu.ces.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xuemengzihe.sylu.ces.exception.InvalidParameterException;
import cn.xuemengzihe.sylu.ces.pojo.com.Message;
import cn.xuemengzihe.sylu.ces.pojo.com.Persion;
import cn.xuemengzihe.sylu.ces.pojo.com.Student;
import cn.xuemengzihe.sylu.ces.pojo.com.Teacher;
import cn.xuemengzihe.sylu.ces.service.web.ComplexFunctionService;
import cn.xuemengzihe.sylu.ces.service.web.MailService;
import cn.xuemengzihe.sylu.ces.service.web.MessageService;
import cn.xuemengzihe.sylu.ces.service.web.StudentService;
import cn.xuemengzihe.sylu.ces.service.web.TeacherService;
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
	private MailService mailService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;
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
	 * 发送消息
	 * 
	 * @param request
	 * @param msg
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/sendMessage", produces = "application/json; charset=utf-8")
	public String sendMessage(HttpServletRequest request, Model model,
			Message msg) {
		// TODO Message对象中的参数校验

		// 验证接收者的参数是否正确
		Persion recPersion = null; // 接收者
		if ("T".equals(msg.getType())) {
			recPersion = teacherService.findTeacherById(msg.getReceiverId());
		} else if ("S".equals(msg.getType())) {
			recPersion = studentService.findStudentById(msg.getReceiverId());
		}
		if (recPersion == null) {
			model.addAttribute("tip", "接收者ID不正确！");
			throw new InvalidParameterException();
		}

		Persion persion = (Persion) request.getSession().getAttribute("user");
		msg.setType(persion instanceof Teacher ? "TT" + msg.getType() : "ST"
				+ msg.getType()); // 设置消息的接收发送类型
		msg.setSenderId(persion.getId()); // 设置发送者ID

		if (msgService.insertMessage(msg)) {
			// 发送邮件通知接收者
			final String emailAddress = recPersion.getEmail();
			final String name = persion.getName();
			if ("Y".equals(msg.getWithMail())) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						mailService.sendPlainMail("测评系统通知", "您收到" + name
								+ "的消息，请登录网站查看", emailAddress);
					}
				}).start();
			}
			// 发送成功
			return "{\"result\":\"success\",\"tip\":\"发送成功！\"}";
		} else {
			// 发送失败
			return "{\"result\":\"error\",\"tip\":\"发送失败！\"}";
		}
	}

	/**
	 * 收到的信息
	 * 
	 * @param request
	 * @param offset
	 * @param limit
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/inboxData", produces = "application/json; charset=utf-8")
	public String inboxData(
			HttpServletRequest request,
			@RequestParam(value = "offset", required = true, defaultValue = "0") Integer offset,
			@RequestParam(value = "limit", required = true, defaultValue = "10") Integer limit) {
		PageInfo<Map<String, String>> pageInfo = new PageInfo<>();
		Persion persion = (Persion) request.getSession().getAttribute("user");
		pageInfo.setPageSize(limit);
		pageInfo.setPageNum(offset / limit + 1);
		// 分页查询记录
		pageInfo = msgService.findMessageWithMap(pageInfo,
				MessageService.MODE_MSG_RECEIVE,
				persion instanceof Teacher ? MessageService.USERTYPE_TEACHER
						: MessageService.USERTYPE_STUDENT, persion.getId(), "");
		return JSONUtil.parsePageInfoToJSON(pageInfo);
	}

	/**
	 * 发出的消息
	 * 
	 * @param request
	 * @param offset
	 * @param limit
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/outboxData", produces = "application/json; charset=utf-8")
	public String outboxData(
			HttpServletRequest request,
			@RequestParam(value = "offset", required = true, defaultValue = "0") Integer offset,
			@RequestParam(value = "limit", required = true, defaultValue = "10") Integer limit) {
		PageInfo<Map<String, String>> pageInfo = new PageInfo<>();
		Persion persion = (Persion) request.getSession().getAttribute("user");
		pageInfo.setPageSize(limit);
		pageInfo.setPageNum(offset / limit + 1);
		// 分页查询记录
		pageInfo = msgService.findMessageWithMap(pageInfo,
				MessageService.MODE_MSG_SEND,
				persion instanceof Teacher ? MessageService.USERTYPE_TEACHER
						: MessageService.USERTYPE_STUDENT, persion.getId(),
				MessageService.STATE_UNREADED);
		return JSONUtil.parsePageInfoToJSON(pageInfo);
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
					((Student) persion).getClassId().toString());
		}
		return JSONUtil.parsePageInfoToJSONWithPageNumber(pageInfo);
	}

	/**
	 * 获取未读消息
	 * 
	 * @param request
	 * @return
	 */
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

	/**
	 * 查阅消息内容
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/readMessage")
	public String readMessage(HttpServletRequest request, Model model,
			@RequestParam(required = true, value = "item") Integer id) {
		Persion persion = (Persion) request.getSession().getAttribute("user");
		Message msg = msgService.findMessageById(id);
		try {
			if (msg == null) {
				throw new InvalidParameterException();
			}
			// 判断当前请求的用户是学生还是老师
			if (persion instanceof Teacher) {
				// 1.老师
				// 判断是发送的消息还是接收的消息
				if ("TTT".equals(msg.getType()) || "STT".equals(msg.getType())) {
					// 接收的消息
					if (msg.getReceiverId() != persion.getId()) {
						throw new InvalidParameterException();
					}
					tickMessage(msg, id);
				} else if ("TTT".equals(msg.getType())
						|| "TTS".equals(msg.getType())) {
					// 发送的消息
					if (msg.getSenderId() != persion.getId()) {
						throw new InvalidParameterException();
					}
				}
			} else {
				// 2.学生
				// 判断是发送的消息还是接收的消息
				if ("TTS".equals(msg.getType()) || "STS".equals(msg.getType())) {
					// 接收的消息
					if (msg.getReceiverId() != persion.getId()) {
						throw new InvalidParameterException();
					}
					tickMessage(msg, id);
				} else if ("STT".equals(msg.getType())
						|| "STS".equals(msg.getType())) {
					// 发送的消息
					if (msg.getSenderId() != persion.getId()) {
						throw new InvalidParameterException();
					}
				}
			}
			model.addAttribute("msg", msg); // 添加消息到模型中
		} catch (InvalidParameterException e) {
			model.addAttribute("tip", "该消息不存在！");
		}
		return "/message/readMessage";
	}

	/**
	 * 将消息标记为阅读
	 * 
	 * @param msg
	 * @param id
	 */
	private void tickMessage(Message msg, Integer id) {
		if ("N".equals(msg.getState())) {
			msgService.tickReadedTagForAMessage(id);
		}
	}
}
