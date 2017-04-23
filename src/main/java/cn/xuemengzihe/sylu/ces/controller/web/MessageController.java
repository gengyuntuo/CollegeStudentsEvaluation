package cn.xuemengzihe.sylu.ces.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getReceiver")
	public String getReceiver(HttpServletRequest request) {
		return null;
	}
}
