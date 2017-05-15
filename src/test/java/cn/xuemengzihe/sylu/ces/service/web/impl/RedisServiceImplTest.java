package cn.xuemengzihe.sylu.ces.service.web.impl;

import org.junit.Test;

import cn.xuemengzihe.sylu.ces.service.web.RedisService;

public class RedisServiceImplTest {
	private RedisService redisService = new RedisServiceImpl();

	@Test
	public void testPutValueStringString() {
		// redisService.putValue("key", "value");
		redisService.deleteValue("key");
	}

	@Test
	public void testPutValueStringStringInt() {
		redisService.putValue("key", "value", 10);
	}

	@Test
	public void testGetValue() {
		System.out.println(redisService.getValue("key"));
	}

}
