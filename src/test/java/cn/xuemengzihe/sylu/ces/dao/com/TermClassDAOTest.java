package cn.xuemengzihe.sylu.ces.dao.com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xuemengzihe.sylu.ces.pojo.com.TermClass;

@RunWith(SpringJUnit4ClassRunner.class)
// 基于Junit4的Spring测试框架
@ContextConfiguration(locations = {
		"classpath:conf_spring/applicationContext.xml",
		"classpath:conf_spring/spring-mvc.xml" })
public class TermClassDAOTest {
	@Autowired
	private TermClassDAO termClassDAO;

	// @Test
	public void testInsert() {
		TermClass termClass = new TermClass();
		termClass.setClassId(1);
		termClass.setTermId(2);
		termClassDAO.insert(termClass);
		termClass.setClassId(2);
		termClassDAO.insert(termClass);
		termClass.setClassId(3);
		termClassDAO.insert(termClass);
	}

	// @Test
	public void testDelete() {
		termClassDAO.delete(3);
	}

	@Test
	public void testDeleteByTermId() {
		termClassDAO.deleteByTermId(2);
	}

	@Test
	public void testFindById() {
		System.out.println(termClassDAO.findById(1));
	}

	@Test
	public void testFindByTermId() {
		System.out.println(termClassDAO.findByTermId(1));
	}

}
