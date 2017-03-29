package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import cn.xuemengzihe.sylu.ces.service.web.MailService;

/**
 * <h1>Mail Service的实现</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月29日 上午9:58:51
 */
@Service
public class MailServiceImpl implements MailService {
	private final Logger logger = LoggerFactory
			.getLogger(MailServiceImpl.class);
	@Autowired
	private JavaMailSender sender;

	@Override
	public boolean sendPlainMail(String subject, String content, String to) {
		SimpleMailMessage msg = new SimpleMailMessage(); // 创建简单邮件对象
		msg.setFrom(((JavaMailSenderImpl) sender).getUsername()); // 设置邮件发送者
		msg.setSubject(subject); // 设置邮件主题
		msg.setText(content); // 设置邮件内容
		msg.setTo(to); // 设置收件人
		try {
			sender.send(msg); // 发送邮件
		} catch (MailParseException e) {
			logger.info("Mail sended failed because of mail parse exception！");
			e.printStackTrace();
			return false;
		} catch (MailAuthenticationException e) {
			logger.info("Mail sended failed because of mail authority exception！");
			e.printStackTrace();
			return false;
		} catch (MailSendException e) {
			logger.info("Mail sended failed because of mail send exception！");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean sendPlainMail(String subject, String content,
			List<String> toList) {
		SimpleMailMessage[] msgArray = null; // 一次发送邮件的集合
		String[] toArray = null; // 一次发送邮件收件人的集合

		// 确定待发送邮件集合的大小
		int msgArraySize = toList.size() % 10 != 0 ? toList.size() / 10 + 1
				: toList.size() / 10;
		msgArray = new SimpleMailMessage[msgArraySize]; // 创建待发送邮件集合
		// 为集合中的每一封邮件赋值
		for (int k = 0; k < msgArraySize; k++) {
			msgArray[k] = new SimpleMailMessage(); // 创建邮件
			msgArray[k].setSubject(subject); // 设置邮件主题
			msgArray[k].setText(content); // 设置邮件内容
			msgArray[k].setFrom(((JavaMailSenderImpl) sender).getUsername()); // 设置邮件发送者
			toArray = new String[k + 1 < msgArraySize ? 10 : toList.size() % 10]; // 创建邮件接收人
			// （默认每封邮件10个接收人，如果不够人数则按照实际人数创建）
			for (int i = 10 * k; (i < 10 * k + 10) && (i < toList.size()); i++) {
				toArray[i % 10] = toList.get(i);
			}
			msgArray[k].setTo(toArray); // 设定收件人
		}
		try {
			sender.send(msgArray); // 发送邮件
		} catch (MailParseException e) {
			logger.info("Mail sended failed because of mail parse exception！");
			e.printStackTrace();
			return false;
		} catch (MailAuthenticationException e) {
			logger.info("Mail sended failed because of mail authority exception！");
			e.printStackTrace();
			return false;
		} catch (MailSendException e) {
			logger.info("Mail sended failed because of mail send exception！");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean sendMIMEMail(String subject, String content,
			List<File> files, String to) {
		MimeMessage msg = sender.createMimeMessage(); // 创建邮件
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8"); // 创建Helper
			helper.setSubject(subject); // 设置邮件主题
			helper.setText(content); // 设置邮件内容
			helper.setFrom(((JavaMailSenderImpl) sender).getUsername()); // 设置发件人
			for (File file : files) {
				if (file.exists() && file.isFile()) // 判断文件是否存在和正常
					helper.addAttachment(file.getName(), file); // 添加附件
			}
			helper.setTo(to); // 设置收件人
			sender.send(msg); // 发送邮件
		} catch (MailParseException e) {
			logger.info("Mail sended failed because of mail parse exception！");
			e.printStackTrace();
			return false;
		} catch (MailAuthenticationException e) {
			logger.info("Mail sended failed because of mail authority exception！");
			e.printStackTrace();
			return false;
		} catch (MailSendException e) {
			logger.info("Mail sended failed because of mail send exception！");
			e.printStackTrace();
			return false;
		} catch (MessagingException e) {
			logger.info("Mail sended failed because of message exception！");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean sendMIMEMail(String subject, String content,
			List<File> files, List<String> toList) {
		MimeMessage[] msgArray = null; // 一次发送邮件的集合
		String[] toArray = null; // 一次发送邮件收件人的集合
		MimeMessageHelper helper = null; // 邮件内容helper

		// 确定待发送邮件集合的大小
		int msgArraySize = toList.size() % 10 != 0 ? toList.size() / 10 + 1
				: toList.size() / 10;
		msgArray = new MimeMessage[msgArraySize]; // 创建待发送邮件集合

		try {
			// 为集合中的每一封邮件赋值
			for (int k = 0; k < msgArraySize; k++) {
				msgArray[k] = sender.createMimeMessage(); // 创建邮件
				helper = new MimeMessageHelper(msgArray[k], true, "UTF-8");
				helper.setSubject(subject); // 设置邮件主题
				helper.setText(content); // 设置邮件内容
				helper.setFrom(((JavaMailSenderImpl) sender).getUsername()); // 设置邮件发送者
				for (File file : files) {
					if (file.exists() && file.isFile()) // 判断文件是否存在和正常
						helper.addAttachment(file.getName(), file); // 添加附件
				}

				toArray = new String[k + 1 < msgArraySize ? 10
						: toList.size() % 10]; // 创建邮件接收人
				// （默认每封邮件10个接收人，如果不够人数则按照实际人数创建）
				for (int i = 10 * k; (i < 10 * k + 10) && (i < toList.size()); i++) {
					toArray[i % 10] = toList.get(i);
				}
				helper.setTo(toArray); // 设定收件人
			}
			sender.send(msgArray); // 发送邮件
		} catch (MailParseException e) {
			logger.info("Mail sended failed because of mail parse exception！");
			e.printStackTrace();
			return false;
		} catch (MailAuthenticationException e) {
			logger.info("Mail sended failed because of mail authority exception！");
			e.printStackTrace();
			return false;
		} catch (MailSendException e) {
			logger.info("Mail sended failed because of mail send exception！");
			e.printStackTrace();
			return false;
		} catch (MessagingException e) {
			logger.info("Mail sended failed because of message exception！");
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
