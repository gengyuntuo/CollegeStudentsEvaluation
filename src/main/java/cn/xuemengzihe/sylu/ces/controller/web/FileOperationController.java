package cn.xuemengzihe.sylu.ces.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <h1>文件操作相关的Controller</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年4月8日 下午2:00:35
 */
@Controller
public class FileOperationController {
	/**
	 * 文件上传
	 * 
	 * @return
	 */
	@RequestMapping("/uploadFile")
	public String uploadFile() {
		return null;
	}

	/**
	 * 文件下载
	 * 
	 * @param request
	 * @param response
	 * @param fileName
	 *            下载的文件名称
	 */
	@RequestMapping("/downloadFile")
	public void downloadFile(HttpServletRequest request,
			HttpServletResponse response, String fileName) {
		response.setContentType("");
	}
}
