package cn.xuemengzihe.sylu.ces.task;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.xuemengzihe.sylu.ces.service.web.MailService;
import cn.xuemengzihe.sylu.ces.util.FileUtil;

/**
 * <h1>定时任务</h1>
 * <p>
 * <h2>Cron表达式的详细用法</h2>
 * 字段 允许值 允许的特殊字符 <br/>
 * 秒 0-59 , - * / <br/>
 * 分 0-59 , - * / <br/>
 * 小时 0-23 , - * / <br/>
 * 日期 1-31 , - * ? / L W C <br/>
 * 月份 1-12 或者 JAN-DEC , - * / <br/>
 * 星期 1-7 或者 SUN-SAT , - * ? / L C # <br/>
 * 年（可选） 留空, 1970-2099 , - * /<br/>
 * <br/>
 * 例子：<br/>
 * 0/5 * * * * ? ： 每5秒执行一次<br/>
 * 
 * 
 * “*”字符被用来指定所有的值。如："*"在分钟的字段域里表示“每分钟”。 <br/>
 * “?”字符只在日期域和星期域中使用。它被用来指定“非明确的值”。当你需要通过在这两个域中的一个来指定一些东西的时候，它是有用的。看下面的例子你就会明白。
 * <br/>
 * 月份中的日期和星期中的日期这两个元素时互斥的一起应该通过设置一个问号来表明不想设置那个字段。<br/>
 * 
 * “-”字符被用来指定一个范围。如：“10-12”在小时域意味着“10点、11点、12点”。<br/>
 * 
 * “,”字符被用来指定另外的值。如：“MON,WED,FRI”在星期域里表示”星期一、星期三、星期五”。<br/>
 * 
 * “/”字符用于指定增量。如：“0/15”在秒域意思是每分钟的0，15，30和45秒。“5/15”在分钟域表示每小时的5，20，35和50。符号“*”在“/
 * ”前面（如：*
 * /10）等价于0在“/”前面（如：0/10）。记住一条本质：表达式的每个数值域都是一个有最大值和最小值的集合，如：秒域和分钟域的集合是0-59
 * ，日期域是1-
 * 31，月份域是1-12。字符“/”可以帮助你在每个字符域中取相应的数值。如：“7/6”在月份域的时候只有当7月的时候才会触发，并不是表示每个6月。<br/>
 * 
 * L是‘last’的省略写法可以表示day-of-month和day-of-week域，但在两个字段中的意思不同，例如day-of-
 * month域中表示一个月的最后一天
 * 。如果在day-of-week域表示‘7’或者‘SAT’，如果在day-of-week域中前面加上数字，它表示一个月的最后几天
 * ，例如‘6L’就表示一个月的最后一个星期五。<br/>
 * 
 * 字符“W”只允许日期域出现。这个字符用于指定日期的最近工作日。例如：如果你在日期域中写
 * “15W”，表示：这个月15号最近的工作日。所以，如果15号是周六，
 * 则任务会在14号触发。如果15好是周日，则任务会在周一也就是16号触发。如果是在日期域填写
 * “1W”即使1号是周六，那么任务也只会在下周一，也就是3号触发，“
 * W”字符指定的最近工作日是不能够跨月份的。字符“W”只能配合一个单独的数值使用，不能够是一个数字段，如：1-15W是错误的。<br/>
 * 
 * “L”和“W”可以在日期域中联合使用，LW表示这个月最后一周的工作日。<br/>
 * 
 * 字符“#”只允许在星期域中出现。这个字符用于指定本月的某某天。例如：“6#3”表示本月第三周的星期五（6表示星期五，3表示第三周）。“2#1”
 * 表示本月第一周的星期一。“4#5”表示第五周的星期三。<br/>
 * 
 * 字符“C”允许在日期域和星期域出现。这个字符依靠一个指定的“日历”。也就是说这个表达式的值依赖于相关的“日历”的计算结果，如果没有“日历”关联，
 * 则等价于所有包含的“日历”。如：日期域是“5C”表示关联“日历”中第一天，或者这个月开始的第一天的后5天。星期域是“1C”表示关联“日历”中第一天，
 * 或者星期的第一天的后1天，也就是周日的后一天（周一）。<br/>
 * 
 * <h2>表达式举例</h2>
 * "0 0 12 * * ?" 每天中午12点触发<br/>
 * "0 15 10 ? * *" 每天上午10:15触发<br/>
 * "0 15 10 * * ?" 每天上午10:15触发<br/>
 * "0 15 10 * * ? *" 每天上午10:15触发<br/>
 * "0 15 10 * * ? 2005" 2005年的每天上午10:15触发<br/>
 * "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发<br/>
 * "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发<br/>
 * "0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发<br/>
 * "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发<br/>
 * "0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发<br/>
 * "0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发<br/>
 * "0 15 10 15 * ?" 每月15日上午10:15触发<br/>
 * "0 15 10 L * ?" 每月最后一日的上午10:15触发<br/>
 * "0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发 <br/>
 * "0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发<br/>
 * "0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发<br/>
 * </p>
 * 
 * @author 李春
 * @time 2017年5月4日 下午2:52:30
 */
@Component
public class TimeTaskPoweredByQuartz {
	private final Logger logger = LoggerFactory
			.getLogger(TimeTaskPoweredByQuartz.class);

	private String rootPath;
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private MailService mailService;

	public TimeTaskPoweredByQuartz() {
		logger.info("定时任务创建成功");
	}

	private void initRootPath() {
		try {
			this.rootPath = applicationContext.getResource("WEB-INF/web.xml")
					.getFile().getAbsolutePath();
			this.rootPath = this.rootPath.substring(0,
					this.rootPath.lastIndexOf("WEB-INF"));
			this.rootPath += FileUtil.DIRECTROY_TEMP_FILE;
			logger.info("项目的临时目录路径：" + this.rootPath);
		} catch (IOException e) {
			logger.info("获取项目临时目录路径失败！");
		}
	}

	/**
	 * 清除过期文件<br/>
	 * 执行时间：每天凌晨一点执行
	 */
	@Scheduled(cron = "0 0 1 * * ?")
	public void clearExpiredFiles() {
		// 获取rootPath
		if (this.rootPath == null) {
			initRootPath();
			// 如果获取失败，则等待下次获取
			if (this.rootPath == null) {
				return;
			}
		}

		// 删除过时文件 , 仅仅删除创建时间大于1分钟的文件
		long time = 0;
		int deleteFiles = 0;
		int totalFiles = 0;
		File tempDir = new File(this.rootPath);
		// logger.info(this.rootPath);
		try {
			for (File file : tempDir.listFiles()) {
				totalFiles++;
				// logger.info(new Date().getTime() - file.lastModified() + "");
				time = (new Date().getTime() - file.lastModified()) / 1000 / 60; // 获取修改时间/分钟
				if (file.exists() && file.isFile() && time > 1) {
					deleteFiles++;
					file.delete();
				}
			}
		} catch (Exception e) {
			logger.info("文件删除时出现异常");
			e.printStackTrace();
		}

		// 通知系统管理员
		mailService.sendPlainMail("系统运行通知", "系统成功执行了删除临时文件的任务，总文件数："
				+ totalFiles + "（个），删除文件数：" + deleteFiles + "（个）",
				"gengyuntuo@163.com");
	}
}
