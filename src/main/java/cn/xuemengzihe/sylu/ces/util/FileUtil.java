package cn.xuemengzihe.sylu.ces.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * <h1>文件工具类</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年4月8日 下午2:09:49
 */
public class FileUtil {

	public static final String CONTENT_TYPE_DOC = "application/msword";
	public static final String CONTENT_TYPE_JPEG = "image/jpeg";
	public static final String CONTENT_TYPE_JPG = "image/jpeg";
	public static final String CONTENT_TYPE_PDF = "application/pdf";
	public static final String CONTENT_TYPE_XLS = "application/-excel";
	public static final String CONTENT_TYPE_ZIP = "";

	/**
	 * 获取文件扩展名，如果扩展名合法则返回扩展名（例如：.xls, .jpg, .zip)，非法则返回null
	 * 
	 * @param fileName
	 *            文件名
	 * @return 扩展名
	 */
	public static String getFileExtension(String fileName) {
		String extName = null;
		if (fileName != null && fileName.contains(".")) {
			extName = fileName.substring(fileName.lastIndexOf("."));
			// 获取的扩展名的长度为[2,4]，否则为非法
			if (extName.length() < 2 || extName.length() > 5)
				extName = null;
		}
		return extName;
	}

	/**
	 * 根据扩展名或者Content Type名称
	 * 
	 * @param extName
	 *            扩展名
	 * @return Content Type
	 */
	public static String getContentType(String extName) {
		String contentType = null;
		switch (extName) {
		case ".doc":
			contentType = FileUtil.CONTENT_TYPE_DOC;
			break;
		case ".jpg":
			contentType = FileUtil.CONTENT_TYPE_JPG;
			break;
		case ".pdf":
			contentType = FileUtil.CONTENT_TYPE_PDF;
			break;
		case ".xls":
			contentType = FileUtil.CONTENT_TYPE_XLS;
			break;
		case ".zip":
			contentType = FileUtil.CONTENT_TYPE_ZIP;
			break;
		}
		return contentType;
	}

	/**
	 * 压缩文件
	 * 
	 * @param zipFileName
	 *            压缩文件名称（必须为绝对路径，可以不包含扩展名）
	 * @param fileNames
	 *            要压缩的文件(必须为绝对路径）
	 * @return 压缩后文件的绝对路径
	 */
	public static String zipFiles(String zipFileName, String[] fileNames) {
		// 如果文件名中不包含扩展名，则添加扩展名
		if (!".zip".equals(getFileExtension(zipFileName)))
			zipFileName += ".zip";
		ZipOutputStream zipOut = null;
		ZipEntry entry = null;
		File file = null;
		int pointer = 0;
		byte[] buffer = new byte[1024 * 100];
		FileInputStream fileInput = null;
		BufferedInputStream bufferedInputStream = null;
		// 不可以使用BufferedOutputStream ,用了会导致多个文件压缩成一个文件
		// BufferedOutputStream bufferedOutputStream = null;
		try {
			zipOut = new ZipOutputStream(new FileOutputStream(zipFileName));
			// bufferedOutputStream = new BufferedOutputStream(zipOut);
			for (String fileName : fileNames) {
				file = new File(fileName);
				if (file != null && file.exists() && file.isFile()) {
					entry = new ZipEntry(file.getName());
					zipOut.putNextEntry(entry);
					fileInput = new FileInputStream(file);
					bufferedInputStream = new BufferedInputStream(fileInput);
					while ((pointer = bufferedInputStream.read(buffer)) != -1) {
						// bufferedOutputStream.write(buffer, 0, pointer);
						zipOut.write(buffer, 0, pointer);
					}
					bufferedInputStream.close();
					fileInput.close();
				} else {
					continue;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (zipOut != null) {
					// bufferedOutputStream.close();
					zipOut.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return zipFileName;
	}
}
