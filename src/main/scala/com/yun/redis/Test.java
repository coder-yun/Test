package com.yun.redis;

import redis.clients.jedis.Jedis;

public class Test {
	private static Jedis jedis;
	public static void main(String[] args) {
		jedis = new Jedis("192.168.134.130",6379);
		jedis.set("age","5");
		System.out.println(jedis.get("age"));
		
	}
}
