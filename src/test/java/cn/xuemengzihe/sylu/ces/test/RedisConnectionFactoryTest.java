package cn.xuemengzihe.sylu.ces.test;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import cn.xuemengzihe.sylu.ces.util.RedisConnectionFactory;

public class RedisConnectionFactoryTest {
	private volatile int i = 0;

	@Test
	public void testGetRedisConnection() throws InterruptedException {
		for (i = 0; i < 100; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					Jedis conn = RedisConnectionFactory.getRedisConnection();
					System.out.println("获取Connection");
					conn.set("key" + i, "value" + i);
					System.out.println("######:key" + i + " --> value" + i);
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					conn.close();
					System.out.println("归还Connection");
				}
			}).start();
		}
		Thread.sleep(1000 * 3 * 100 + 3000);
	}
}
