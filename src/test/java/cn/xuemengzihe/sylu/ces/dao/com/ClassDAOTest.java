package cn.xuemengzihe.sylu.ces.dao.com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// 基于Junit4的Spring测试框架
@ContextConfiguration(locations = {
		"classpath:conf_spring/applicationContext.xml",
		"classpath:conf_spring/spring-mvc.xml" })
public class ClassDAOTest {
	@Autowired
	private ClassDAO classDAO;

	@Test
	public void testFindClazzById() {
		System.out.println(classDAO.findClazzById(1));
		System.out.println(classDAO.findClazzById(1).getStudents().size());
	}

}
