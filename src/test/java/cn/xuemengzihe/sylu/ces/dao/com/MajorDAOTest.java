package cn.xuemengzihe.sylu.ces.dao.com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:conf_spring/applicationContext.xml",
		"classpath:conf_spring/spring-mvc.xml" })
public class MajorDAOTest {
	@Autowired
	private MajorDAO majorDAO;

	@Test
	public void testInsertMajor() {
	}

	@Test
	public void testDeleteMajorById() {
	}

	@Test
	public void testUpdateMajor() {
	}

	@Test
	public void testFindMajorById() {
		System.out.println(majorDAO.findMajorById(1));
	}

	@Test
	public void testFindMajorsOfAll() {
	}

	@Test
	public void testFindMajorsOfAllWithMapSet() {
	}

}
