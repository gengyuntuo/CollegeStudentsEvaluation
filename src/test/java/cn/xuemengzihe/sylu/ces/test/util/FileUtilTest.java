package cn.xuemengzihe.sylu.ces.test.util;

import org.junit.Test;

import cn.xuemengzihe.sylu.ces.util.FileUtil;

public class FileUtilTest {

	@Test
	public void testGetFileExtension() {
		System.out.println("file.txt ==> "
				+ FileUtil.getFileExtension("file.txt"));
		System.out.println("fil.e.txt ==> "
				+ FileUtil.getFileExtension("fil.e.txt"));
		System.out.println("file ==> " + FileUtil.getFileExtension("file"));
		System.out.println("file. ==> " + FileUtil.getFileExtension("file."));
		System.out.println("file.t ==> " + FileUtil.getFileExtension("file.t"));
		System.out.println("file.txtt ==> "
				+ FileUtil.getFileExtension("file.txtt"));
		System.out.println("file.txttx ==> "
				+ FileUtil.getFileExtension("file.txttx"));
	}

	@Test
	public void testGetContentType() {

	}

	@Test
	public void testZipFiles() {
		FileUtil.zipFiles(
				"C:\\Users\\Lenovo\\Desktop\\bat.zip",
				new String[] {
						"C:\\Users\\Lenovo\\Desktop\\Java多线程编程核心技术_完整版 PDF电子书下载 带书签目录.pdf",
						"C:\\Users\\Lenovo\\Desktop\\HBase权威指南.pdf",
						"C:\\Users\\Lenovo\\Desktop\\bootstrap-table-develop.zip",
						"C:\\Users\\Lenovo\\Desktop\\金融事业部_金融大数据部-李春_018058_工作内容日报汇总.xlsx",
						"", "" });
	}
}
