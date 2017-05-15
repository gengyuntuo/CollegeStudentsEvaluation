package cn.xuemengzihe.sylu.ces.service.web.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import cn.xuemengzihe.sylu.ces.service.web.RedisService;
import cn.xuemengzihe.sylu.ces.util.RedisConnectionFactory;

/**
 * <h1></h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年5月14日 上午11:10:58
 */
@Service
public class RedisServiceImpl implements RedisService {
	private final Logger logger = LoggerFactory
			.getLogger(RedisConnectionFactory.class);
	RedisConnectionFactory redisFactory;

	public RedisServiceImpl() {
		this.redisFactory = new RedisConnectionFactory();
	}

	@Override
	public void putValue(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = this.redisFactory.getRedisConnection();
			jedis.set(key, value);
		} catch (Exception e) {
			logger.error("Redis 写入值发生异常");
			e.printStackTrace();
		} finally {
			jedis.close();
		}
	}

	@Override
	public void putValue(String key, String value, int expire) {
		Jedis jedis = null;
		try {
			jedis = this.redisFactory.getRedisConnection();
			jedis.set(key, value);
			jedis.expire(key, expire);
		} catch (Exception e) {
			logger.error("Redis 写入值发生异常");
			e.printStackTrace();
		} finally {
			jedis.close();
		}
	}

	@Override
	public String getValue(String key) {
		Jedis jedis = null;
		String result = null;
		try {
			jedis = this.redisFactory.getRedisConnection();
			result = jedis.get(key);
		} catch (Exception e) {
			logger.error("Redis 读值发生异常");
			e.printStackTrace();
		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public void deleteValue(String key) {
		Jedis jedis = null;
		try {
			jedis = this.redisFactory.getRedisConnection();
			jedis.del(key);
		} catch (Exception e) {
			logger.error("Redis 写入值发生异常");
			e.printStackTrace();
		} finally {
			jedis.close();
		}
	}

}
