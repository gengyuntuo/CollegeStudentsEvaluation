package cn.xuemengzihe.sylu.ces.controller.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.xuemengzihe.sylu.ces.exception.FileNotFoundException;
import cn.xuemengzihe.sylu.ces.util.Base64Util;
import cn.xuemengzihe.sylu.ces.util.FileUtil;

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
	 * 文件上传（仅供测试使用）
	 * 
	 * @param request
	 * @param file
	 * @return
	 */
	@Deprecated()
	@ResponseBody()
	// @RequestMapping("/uploadFile")
	public String uploadFile(HttpServletRequest request, MultipartFile file) {
		// 获取项目中储存文件的文件夹的绝对路径
		String fileLocation = request.getSession().getServletContext()
				.getRealPath("/");
		System.out.println(fileLocation);

		try {
			String filePathAndName = fileLocation
					+ FileUtil.DIRECTORY_UPLOAD_FILE
					+ FileUtil.getUploadFilePathAndName(file
							.getOriginalFilename());
			FileUtil.mkdirsForFile(filePathAndName);
			file.transferTo(new File(filePathAndName));
		} catch (IOException e) {
			e.printStackTrace();
			return "文件上传失败！";
		}
		return "文件上传成功！";
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
			HttpServletResponse response,
			@RequestParam(required = true, defaultValue = "") String fileName) {
		// 获取项目所在的绝对路径
		String fileLocation = request.getSession().getServletContext()
				.getRealPath("/");

		// 获取文件相对项目存在的位置的路径及文件名
		fileName = Base64Util.decode(fileName); // 将参数解码

		FileInputStream fileIn = null;
		File file = new File(fileLocation + fileName);
		try {
			// 判断文件存在，且文件可以被用户访问
			if (!file.exists()
					|| !FileUtil.verifyFile(fileLocation,
							file.getAbsolutePath())) {
				throw new FileNotFoundException();
			}
			response.setContentType(FileUtil.getContentType(FileUtil
					.getFileExtension(fileName)));
			fileIn = new FileInputStream(file);
			BufferedInputStream bufferIn = new BufferedInputStream(fileIn);
			byte[] buffer = new byte[1024 * 100];
			int pointer = 0;
			while ((pointer = bufferIn.read(buffer)) != -1) {
				response.getOutputStream().write(buffer, 0, pointer);
			}
			bufferIn.close();
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.sendError(404);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if (fileIn != null)
					fileIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
