package cn.xuemengzihe.sylu.ces.test;

import java.io.File;
import java.text.DecimalFormat;

import org.junit.Test;

public class JavaTest {
	// @Test
	public void test() {
		File file = new File("C:\\Users\\Lenovo\\Desktop\\file.docx");
		File file2 = new File("13030504.xls");
		System.out.println(file.getName());
		System.out.println(file2.getName());
	}

	@Test
	public void test2() {
		System.out.println("123.==>" + new DecimalFormat(".").format(123.));
	}
}
