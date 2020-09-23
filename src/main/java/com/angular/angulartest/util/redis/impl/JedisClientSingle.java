package com.angular.angulartest.util.redis.impl;

import com.angular.angulartest.util.redis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

@Component
public class JedisClientSingle implements JedisClient {
	
	@Autowired
	private JedisPool jedisPool; 

	@Override
	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.get(key);
		jedis.close();
		return string;
	}

	/**
	 * redis 设置键值内容
	 * 
	 */
	@Override
	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.set(key, value);
		jedis.close();
		return string;
	}

	@Override
	public String hget(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.hget(hkey, key);
		jedis.close();
		return string;
	}
	@Override
	public boolean hexists(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		Boolean bo = jedis.hexists(hkey, key);
		jedis.close();
		return bo;
	}
	@Override
	public Map<String, String> hgetAll(String hkey) {
		Jedis jedis = jedisPool.getResource();
		Map<String, String> map = jedis.hgetAll(hkey);
		jedis.close();
		return map;
	}

	@Override
	public long hset(String hkey, String key, String value) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hset(hkey, key, value);
		jedis.close();
		return result;
	}
	
	/**
	 * token键值删除操作。
	 * 
	 * 
	 */
	@Override
	public long del(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.del(key);
		jedis.close();
		return result;
	}

	@Override
	public long hdel(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hdel(hkey, key);
		jedis.close();
		return result;
	}
	
	
	/**
	 * 更新键值生效时间
	 * 每次访问服务都需要更新访问时间  
	 */
	@Override
	public long expire(String key, int second) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.expire(key, second);
		jedis.close();
		return result;
	}
	@Override
	public boolean exists(String key){
		Jedis jedis = jedisPool.getResource();
		boolean flag = jedis.exists(key);
		jedis.close();
		return flag;
	}
}
