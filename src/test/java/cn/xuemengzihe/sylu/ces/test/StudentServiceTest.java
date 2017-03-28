package cn.xuemengzihe.sylu.ces.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xuemengzihe.sylu.ces.service.web.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
// 基于Junit4的Spring测试框架
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mvc.xml" })
public class StudentServiceTest {
	@Autowired
	private StudentService studentService;

	@Test
	public void testInsertStudentMapOfStringString() {
		Map<String, String> data = new HashMap<>();
		data.put("nick", "伟伟");
		data.put("name", "李春");
		data.put("gender", "男");
		data.put("sno", "1303050422");
		data.put("classId", "1");
		studentService.insertStudent(data);
	}

}
