package cn.xuemengzihe.sylu.ces.test;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xuemengzihe.sylu.ces.pojo.com.Menu;
import cn.xuemengzihe.sylu.ces.service.web.MenuService;

@RunWith(SpringJUnit4ClassRunner.class)
// 基于Junit4的Spring测试框架
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mvc.xml" })
// 启动Spring容器
public class MenuServiceTest {
	@Autowired
	private MenuService menuService;

	@Test
	public void testInsertMenu() {
		// Menu menu = new Menu();
		// menu.setId(5);
		// menu.setOrder(5);
		// menu.setUrl("#");
		// menu.setTitle("专业管理");
		// menu.setDesc("专业管理");
		// menu.setImage("ec-pencil2");
		// menu.setIsValid(true);
		// menu.setLevel("T");
		Menu menu = new Menu();
		menu.setId(6);
		menu.setOrder(6);
		menu.setUrl("majorInfo.do");
		menu.setTitle("信息概览");
		menu.setDesc("信息概览");
		menu.setImage("ec-pencil2");
		menu.setFatherMenuId(5);
		menu.setIsValid(true);
		menu.setLevel("T");
		menuService.insertMenu(menu);
	}

	@Test
	public void testDeleteMenuById() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateMenu() {
		Menu menu = menuService.findMenuById(6);
		menu.setUrl("majorInfo.do");
		menuService.updateMenu(menu);
	}

	@Test
	public void testFindMenuById() {
		System.out.println(menuService.findMenuById(1));
	}

	@Test
	public void testFindPersionMenu() {
		System.out.println(menuService.findPersionMenu("T"));
	}

}
