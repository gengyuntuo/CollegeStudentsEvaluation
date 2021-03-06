package cn.xuemengzihe.sylu.ces.test;

import java.io.File;

import org.junit.Test;

import cn.xuemengzihe.sylu.ces.util.Base64Util;

public class Base64UtilTest {

	@Test
	public void testEncode() {
		System.out
				.println(Base64Util
						.encode("WEB-INF\\file\\upload\\8d8818c8e1\\7d0665438e\\9553703335334a111833256.zip"));
		System.out
		.println(Base64Util
				.encode("WEB-INF\\file\\upload\\8d8818c8e1\\7d0665438e\\9553703335334a111833256.pdf"));
		System.out
				.println(Base64Util
						.encode("WEB-INF\\file\\upload\\8d8818c8e1\\7d0665438e\\9553703335334a111833256.zip"));
		System.out
				.println(Base64Util
						.encode("WEB-INF\\file\\upload\\8d8818c8e1\\7d0665438e\\11.jpg"));
		System.out.println(Base64Util.encode("WEB-INF\\..\\WEB-INF\\web.xml"));
		System.out.println(new File("asdb/abd/abb/../db.file")
				.getAbsolutePath());
	}

	@Test
	public void testDecode() {
		System.out
				.println(Base64Util
						.decode("V0VCLUlORlxmaWxlXHVwbG9hZFw4ZDg4MThjOGUxXDdkMDY2NTQzOGVcOTU1MzcwMzMzNTMzNGExMTE4MzMyNTYucGRm"));
		System.out
				.println("V0VCLUlORlxmaWxlXHVwbG9hZFw4ZDg4MThjOGUxXDdkMDY2NTQzOGVcOTU1MzcwMzMzNTMzNGExMTE4MzMyNTYucGRm"
						.length());
	}

}
