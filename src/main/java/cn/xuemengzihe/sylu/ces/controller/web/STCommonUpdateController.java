package cn.xuemengzihe.sylu.ces.controller.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import cn.xuemengzihe.sylu.ces.util.FileUtil;

/**
 * <h1>学生和老师的共有的更新操作</h1>
 * <p>
 * 修改密码、修改头像
 * </p>
 * 
 * @author 李春
 * @time 2017年5月10日 下午6:43:28
 */
@Controller
public class STCommonUpdateController {
	/**
	 * 修改头像
	 * 
	 * @param request
	 * @param avatar
	 * @return
	 */
	// @ResponseBody
	@RequestMapping(value = "updateAvatar", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String updateAvatar(HttpServletRequest request, MultipartFile avatar) {
		// 获取项目中储存文件的文件夹的绝对路径
		String fileLocation = request.getSession().getServletContext()
				.getRealPath("/");
		try {
			String filePathAndName = fileLocation
					+ FileUtil.DIRECTROY_AVATAR_FILE
					+ FileUtil.getUploadFilePathAndName(avatar
							.getOriginalFilename());
			FileUtil.mkdirsForFile(filePathAndName);
			avatar.transferTo(new File(filePathAndName));
		} catch (IOException e) {
			e.printStackTrace();
			return "文件上传失败！";
		}
		return "<script>window.parent.callback()</script>";
	}
}
