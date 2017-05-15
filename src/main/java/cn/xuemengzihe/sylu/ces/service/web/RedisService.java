package cn.xuemengzihe.sylu.ces.service.web;

/**
 * <h1></h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年5月14日 上午11:10:11
 */
public interface RedisService {
	/**
	 * 保存key-value
	 * 
	 * @param key
	 * @param value
	 */
	public void putValue(String key, String value);

	/**
	 * 保存key-value
	 * 
	 * @param key
	 * @param value
	 * @param expire
	 *            过期时间
	 */
	public void putValue(String key, String value, int expire);

	/**
	 * 取值
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key);

	/**
	 * 删除
	 * 
	 * @param key
	 */
	public void deleteValue(String key);
}
