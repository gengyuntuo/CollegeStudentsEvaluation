package cn.xuemengzihe.sylu.ces.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xuemengzihe.sylu.ces.service.web.MailService;

/**
 * <h1>测试邮件发送</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月29日 上午11:37:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MailServiceTest {
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private MailService mailService;

	@Test
	public void testSendMail2() {
		mailService.sendPlainMail("测试", "这是一份测试邮件！", "gengyuntuo@163.com");
		mailService.sendPlainMail("测试", "这是一份测试邮件！", "gengyuntuo@163.com");
		mailService.sendPlainMail("测试", "这是一份测试邮件！", "gengyuntuo@163.com");
		mailService.sendPlainMail("测试", "这是一份测试邮件！", "gengyuntuo@163.com");
		mailService.sendPlainMail("测试", "这是一份测试邮件！", "gengyuntuo@163.com");
		mailService.sendPlainMail("测试", "这是一份测试邮件！", "gengyuntuo@163.com");
		mailService.sendPlainMail("测试", "这是一份测试邮件！", "gengyuntuo@163.com");
		mailService.sendPlainMail("测试", "这是一份测试邮件！", "gengyuntuo@163.com");
		mailService.sendPlainMail("测试", "这是一份测试邮件！", "gengyuntuo@163.com");
		mailService.sendPlainMail("测试", "这是一份测试邮件！", "gengyuntuo@163.com");
		mailService.sendPlainMail("测试", "这是一份测试邮件！", "gengyuntuo@163.com");
		mailService.sendPlainMail("测试", "这是一份测试邮件！", "gengyuntuo@163.com");
		mailService.sendPlainMail("测试", "这是一份测试邮件！", "gengyuntuo@163.com");
	}

	@Test
	public void testSendMail3() {
		List<String> list = new ArrayList<>();
		// for (int i = 0; i < 10; i++) {
		// list.add("gengyuntuo@163.com");
		// }
		list.add("gengyuntuo@163.com");
		list.add("tiandaotianxia@163.com");
		list.add("lichun@bonc.com.cn");
		mailService.sendPlainMail("测试", "这是一份测试邮件！", list);
	}

	@Test
	public void testSendMail4() throws InterruptedException {
		new Thread(new Runnable() {

			@Override
			public void run() {
				boolean result = false;
				result = mailService.sendPlainMail("测试", "这是第一封测试邮件！",
						"gengyuntuo@163.com");
				System.out.println("第一封测试邮件" + result);
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				boolean result = false;
				result = mailService.sendPlainMail("测试", "这是第二封测试邮件！",
						"gengyuntuo@163.com");
				System.out.println("第二封测试邮件" + result);
			}
		}).start();
		Thread.sleep(100000);
	}

	@Test
	public void testSendMIMEMail() {
		List<File> files = new ArrayList<File>();
		files.add(new File("13030504.xls"));
		mailService.sendMIMEMail("测试邮件", "带有附件的测试邮件", files,
				"gengyuntuo@163.com");
	}
}
