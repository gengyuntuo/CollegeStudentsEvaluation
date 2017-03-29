package cn.xuemengzihe.sylu.ces.service.web;

import java.io.File;
import java.util.List;

import cn.xuemengzihe.sylu.ces.service.web.impl.MailServiceImpl;

/**
 * <h1>Mail 服务</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月29日 上午9:30:46
 * @see MailServiceImpl
 */
public interface MailService {

	/**
	 * 发送普通文本邮件给单个联系人
	 * 
	 * @param subject
	 *            邮件主题
	 * @param content
	 *            邮件内容
	 * @param to
	 *            收件人
	 * @return 发送结果（true 成功）
	 */
	public boolean sendPlainMail(String subject, String content, String to);

	/**
	 * 群发普通文本邮件邮件<br/>
	 * 群发邮件中，为了保证可靠性，每10个人发送一个邮件
	 * 
	 * @param subject
	 *            邮件主题
	 * @param content
	 *            邮件内容
	 * @param to
	 *            收件人列表
	 * @return 发送结果（ture 成功）
	 */
	public boolean sendPlainMail(String subject, String content, List<String> to);

	/**
	 * 发送带有附件的邮件
	 * 
	 * @param subject
	 *            邮件主题
	 * @param content
	 *            邮件内容
	 * @param files
	 *            附件列表
	 * @param to
	 *            收件人
	 * @return
	 */
	public boolean sendMIMEMail(String subject, String content,
			List<File> files, String to);

	/**
	 * 群发带有附件的邮件
	 * 
	 * @param subject
	 *            邮件主题
	 * @param content
	 *            邮件内容
	 * @param files
	 *            附件列表
	 * @param to
	 *            收件人列表
	 * @return 发送结果（true 发送成功）
	 */
	public boolean sendMIMEMail(String subject, String content,
			List<File> files, List<String> to);
}
