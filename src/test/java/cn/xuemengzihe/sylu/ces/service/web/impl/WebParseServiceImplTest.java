package cn.xuemengzihe.sylu.ces.service.web.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xuemengzihe.sylu.ces.service.web.WebParseService;
import cn.xuemengzihe.sylu.ces.test.util.ShowUtil;

@RunWith(SpringJUnit4ClassRunner.class)
// 基于Junit4的Spring测试框架
@ContextConfiguration(locations = {
		"classpath:conf_spring/applicationContext.xml",
		"classpath:conf_spring/spring-mvc.xml" })
public class WebParseServiceImplTest {
	@Autowired
	private WebParseService webParseService;

	@Test
	public void testLoadScoreSheet() {
		ShowUtil.showList(webParseService.loadScoreSheet("1303050422",
				"140222199501057517", "2013-2014"));
	}

	@Test
	public void testobtainXFJD() {
		System.out.println(webParseService.obtainXFJD("1303050422",
				"140222199501057517", "2015-2016"));
//		System.out.println(webParseService.obtainXFJD("1303050425",
//				"210211199501023535", "2015-2016"));
	}

}
