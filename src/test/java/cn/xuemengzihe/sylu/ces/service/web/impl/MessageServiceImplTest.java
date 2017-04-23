package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xuemengzihe.sylu.ces.service.web.MessageService;
import cn.xuemengzihe.sylu.ces.test.util.ShowUtil;

import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
// 基于Junit4的Spring测试框架
@ContextConfiguration(locations = {
		"classpath:conf_spring/applicationContext.xml",
		"classpath:conf_spring/spring-mvc.xml" })
public class MessageServiceImplTest {

	@Autowired
	private MessageService msgService;

	// @Test
	public void testInsertMessage() {
	}

	// @Test
	public void testDeleteMessageById() {
	}

	// @Test
	public void testDeleteMessageByUserId() {
	}

	// @Test
	public void testUpdateMessage() {
	}

	// @Test
	public void testTickReadedTagForAMessage() {
	}

	// @Test
	public void testTickReadedTagForAllMessage() {
	}

	// @Test
	public void testFindMessageWithMap() {
		PageInfo<Map<String, String>> pageInfo = new PageInfo<>();
		pageInfo.setPageNum(1);
		pageInfo.setPageSize(10);
		pageInfo = msgService.findMessageWithMap(pageInfo,
				MessageService.MODE_MSG_RECEIVE,
				MessageService.USERTYPE_STUDENT, 1, null);
		ShowUtil.showList(pageInfo.getList());
	}
}
