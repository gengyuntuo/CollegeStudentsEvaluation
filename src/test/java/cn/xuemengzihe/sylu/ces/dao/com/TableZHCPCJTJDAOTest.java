package cn.xuemengzihe.sylu.ces.dao.com;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:conf_spring/applicationContext.xml",
		"classpath:conf_spring/spring-mvc.xml" })
public class TableZHCPCJTJDAOTest {
	@Autowired
	private TableZHCPCJTJDAO tableZHCPCJTJDAO;

	@Test
	public void testInsertRecord() {
	}

	@Test
	public void testUpdateRecord() {
	}

	@Test
	public void testDeleteRecord() {
	}

	@Test
	public void testGetRecordById() {
	}

	@Test
	public void testGetRecordDetailWithTermIdSno() {
		Map<String, Object> ids = new HashedMap<>();
		ids.put("termId", 21);
		ids.put("sno", "1303050421");
		System.out.println(tableZHCPCJTJDAO.getRecordDetailWithTermIdSno(ids));
	}

	@Test
	public void testGetRecordWithMap() {
	}

}
