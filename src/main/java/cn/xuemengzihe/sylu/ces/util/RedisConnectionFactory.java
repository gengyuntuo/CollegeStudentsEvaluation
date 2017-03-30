package cn.xuemengzihe.sylu.ces.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * <h1>Redis 连接池</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月30日 上午10:35:13
 */
public class RedisConnectionFactory {
	private final static Logger logger = LoggerFactory
			.getLogger(RedisConnectionFactory.class);
	/**
	 * Redis连接池
	 */
	private volatile static JedisPool pool = null;

	/**
	 * 初始化Redis数据库连接池
	 */
	private synchronized static void initPool() {
		if (pool != null) { // 判断是否已经创建
			return;
		}

		Properties props = new Properties(); // redis 配置信息
		InputStream in = null;
		try {
			// 加载配置文件
			in = RedisConnectionFactory.class.getClassLoader()
					.getResourceAsStream("redis.properties");
			props.load(in);

			String host = props.getProperty("redis.host", "127.0.0.1");
			int port = Integer
					.parseInt(props.getProperty("redis.port", "6379"));
			int maxTotal = Integer.parseInt(props.getProperty(
					"redis.max.active", "100"));
			int maxIdle = Integer.parseInt(props.getProperty("redis.max.idle",
					"10"));
			int maxWait = Integer.parseInt(props.getProperty("redis.max.wait",
					"3000"));
			boolean testOnBorrow = Boolean.parseBoolean(props.getProperty(
					"redis.test.on.borrow", "true"));

			// 配置连接池
			JedisPoolConfig config = new JedisPoolConfig(); // redis 配置
			config.setMaxTotal(maxTotal);
			config.setMaxIdle(maxIdle);
			config.setMaxWaitMillis(maxWait);
			config.setTestOnBorrow(testOnBorrow);

			// 创建Pool
			pool = new JedisPool(config, host, port);
		} catch (IOException e) {
			logger.info("Redis error: load the redis.properties file error!");
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private RedisConnectionFactory() {
	}

	/**
	 * 获取连接，归还连接请使用{@link Jedis}对象中的{@link Jedis#close()}方法（这不会真的关闭连接，而是归还给连接池）
	 * 
	 * @return Jedis连接
	 * 
	 */
	public static Jedis getRedisConnection() {
		if (pool != null)
			return pool.getResource();
		else {
			initPool();
			return pool.getResource();
		}
	}
}
