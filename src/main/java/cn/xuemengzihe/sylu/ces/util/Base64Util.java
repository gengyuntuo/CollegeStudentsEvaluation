package cn.xuemengzihe.sylu.ces.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

/**
 * <h1></h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年4月8日 下午6:48:04
 */
public class Base64Util {
	/**
	 * 
	 * @param source
	 * @return
	 */
	public static String encode(String source) {
		String result = null;
		try {
			result = Base64.encodeBase64String(source.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 
	 * @param source
	 * @return
	 */
	public static String decode(String source) {
		String result = null;
		try {
			result = new String(Base64.decodeBase64(source), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
