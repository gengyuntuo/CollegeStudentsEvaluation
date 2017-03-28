package cn.xuemengzihe.sylu.ces.test;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xuemengzihe.sylu.ces.service.web.ExcelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mvc.xml" })
public class ExcelServiceImplTest {

	@Autowired
	private ExcelService excelService;

	@Test
	public void testImportStudentInfomationFromExcelFile() {
		System.out
				.println(excelService
						.importStudentInfomationFromExcelFile(new File(
								"13030504.xls")));
	}

}
