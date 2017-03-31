package cn.xuemengzihe.sylu.ces.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

/**
 * <h1>日期转换器</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月31日 下午3:14:16
 */
public class DateConverter implements Converter<String, Date> {
	private final Logger logger = LoggerFactory.getLogger(DateConverter.class);

	@Override
	public Date convert(String source) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(source);
		} catch (ParseException e) {
			logger.error("Converter: converte a date string failed! the string is "
					+ source);
			e.printStackTrace();
		}
		return date;
	}

}
