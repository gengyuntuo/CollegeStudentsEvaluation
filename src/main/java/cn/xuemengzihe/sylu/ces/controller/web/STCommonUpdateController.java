package cn.xuemengzihe.sylu.ces.controller.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.xuemengzihe.sylu.ces.pojo.com.Persion;
import cn.xuemengzihe.sylu.ces.pojo.com.Student;
import cn.xuemengzihe.sylu.ces.pojo.com.Teacher;
import cn.xuemengzihe.sylu.ces.service.web.StudentService;
import cn.xuemengzihe.sylu.ces.service.web.TeacherService;
import cn.xuemengzihe.sylu.ces.util.Base64Util;
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

	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentServcice;

	/**
	 * 上传头像
	 * 
	 * @param request
	 * @param avatar
	 * @return
	 */
	// @ResponseBody
	@RequestMapping(value = "updateAvatar", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String updateAvatar(HttpServletRequest request, Model model,
			@RequestParam(required = true) MultipartFile avatar) {
		// 获取项目中储存文件的文件夹的绝对路径
		String projPath = request.getSession().getServletContext()
				.getRealPath("/");
		String fileName = avatar.getOriginalFilename();
		String subPath = FileUtil.DIRECTROY_TEMP_FILE + UUID.randomUUID()
				+ ".jpg";
		String path = projPath + subPath;
		BufferedImage img = null;
		try {
			if (!".jpg".equals(FileUtil.getFileExtension(fileName))) {
				throw new RuntimeException("文件的扩展名不是 .jpg");
			}
			img = ImageIO.read(avatar.getInputStream());
			if (img.getHeight() != 128 || img.getWidth() != 128) {
				throw new RuntimeException("图片大小应该为128*128");
			}
			FileUtil.mkdirsForFile(path); // 创建路径
			avatar.transferTo(new File(path)); // 保存文件
			request.getSession().setAttribute("tempAvatarPath", subPath);
			model.addAttribute("result", "true");
			model.addAttribute("tip", Base64Util.encode(subPath));
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("result", "false");
			model.addAttribute("tip", e.getMessage());
		} finally {
		}
		return "/other/avatarUpdateResult";
	}

	/**
	 * 修改头像
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "confirmUpdateAvatar", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String confirmUpdateAvatar(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Persion persion = (Persion) session.getAttribute("user");
		String tempAvatarPath = (String) session.getAttribute("tempAvatarPath");
		try {
			if (tempAvatarPath == null || tempAvatarPath.length() < 1) {
				throw new RuntimeException("您还没有选择照片或者是您选择的照片还在上传中，请稍后确认");
			}

			// 从临时目录移动到头像目录中
			String projPath = request.getSession().getServletContext()
					.getRealPath("/");
			String sourcePath = projPath + tempAvatarPath; // 源路径
			String destPath = FileUtil.DIRECTROY_AVATAR_FILE // 目的路径
					+ FileUtil.getUploadFilePathAndName(tempAvatarPath);

			File sourceFile = new File(sourcePath);
			// 目标文件存在且上传时间小于10分钟，超过10分钟则为非法文件
			if (!sourceFile.exists()
					&& (new Date().getTime() - sourceFile.lastModified()) / 1000 / 600 < 1) {
				throw new RuntimeException("您上传的文件已经过期，请重新上传");
			}

			File destFile = new File(projPath + destPath);
			FileUtil.mkdirsForFile(projPath + destPath); // 创建路径
			sourceFile.renameTo(destFile); // 移动文件

			if (!destFile.exists()) {
				throw new RuntimeException("修改失败，文件移动失败");
			}

			// 更新数据库中的记录
			String oldPath = persion.getPortrait();
			persion.setPortrait(Base64Util.encode(destPath));
			if (persion instanceof Teacher) {
				teacherService.updateTeacher((Teacher) persion);
			} else {
				studentServcice.updateStudent((Student) persion);
			}

			// 删除原有的头像
			if (oldPath != null) {
				File oldFile = new File(projPath + Base64Util.decode(oldPath));
				if (oldFile.exists() && oldFile.isFile()) {
					oldFile.delete();
				}
			}

			session.removeAttribute("tempAvatarPath");
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\",\"tip\":\"" + e.getMessage() + "\"}";
		}
		return "{\"result\":\"success\",\"tip\":\"" + persion.getPortrait()
				+ "\"}";
	}

	/**
	 * 修改密码
	 * 
	 * @param request
	 * @param oldPass
	 *            旧密码
	 * @param newPass
	 *            新密码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updatePassword", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String updatePassword(HttpServletRequest request,
			@RequestParam(required = true) String oldPass,
			@RequestParam(required = true) String newPass) {
		Persion persion = (Persion) request.getSession().getAttribute("user");
		try {
			if (!persion.getPassword().equals(oldPass)) {
				throw new RuntimeException("原始密码错误");
			}
			if (newPass.length() < 6) {
				throw new RuntimeException("密码长度不足六位");
			}

			// 修改密码
			persion.setPassword(newPass);
			if (persion instanceof Teacher) {
				teacherService.updateTeacher((Teacher) persion);
			} else {
				studentServcice.updateStudent((Student) persion);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\",\"tip\":\"" + e.getMessage() + "\"}";
		}
		return "{\"result\":\"success\",\"tip\":\"" + persion.getPortrait()
				+ "\"}";
	}

}
