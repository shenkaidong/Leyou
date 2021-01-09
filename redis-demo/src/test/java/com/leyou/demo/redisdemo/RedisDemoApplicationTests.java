package com.leyou.demo.redisdemo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class RedisDemoApplicationTests {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Test
	void contextLoads() {
		redisTemplate.opsForValue().set("test","hello world");

		String test = redisTemplate.opsForValue().get("test");
		System.out.println("test= "+ test);

		BoundHashOperations<String,Object,Object> ops = redisTemplate.boundHashOps("user:123");

		ops.put("name","Rose");
		ops.put("age","21");

		System.out.println(ops.get("name"));
		System.out.println(ops.get("age"));

		Map<Object, Object> entries = ops.entries();
		System.out.println("entries = "+ entries);
	}

}
