package cn.xuemengzihe.sylu.ces.test;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xuemengzihe.sylu.ces.pojo.com.Institute;
import cn.xuemengzihe.sylu.ces.service.web.InstituteService;
import cn.xuemengzihe.sylu.ces.test.util.ShowUtil;

import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
// 基于Junit4的Spring测试框架
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mvc.xml" })
// 启动Spring容器
public class InstituteServiceTest {
	@Autowired
	private InstituteService instiuteService;

	@Test
	public void testInsertInstitute() {
		Institute ins = new Institute();
		ins.setcTime( new Date());
		ins.setDesc("电气工程及其自动化3");
		ins.setId(3);
		ins.setiName("电气工程及其自动化3");
		ins.setiNumb("123132");
		ins.setIsValid("N");
		ins.setuTime(new Date());
		
		instiuteService.insertInstitute(ins);
		System.out.println(ins);
	}

	@Test
	public void testDeleteInstituteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateInstitute() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindInstituteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindInstitutesOfPage() {
		PageInfo<Institute> pageInfo = instiuteService
				.findInstitutesOfPage(null);
		ShowUtil.showList(pageInfo.getList());
		System.out.println(pageInfo);
	}

}
