package com.angular.angulartest.util.redis;

import java.util.Map;

public interface JedisClient {
	String get(String key);
	String set(String key, String value);
	String hget(String hkey, String key);
	long hset(String hkey, String key, String value);
	long del(String key);
	long hdel(String hkey, String key);
	long expire(String key, int second);
	boolean exists(String key);
	Map<String, String> hgetAll(String hkey);
	boolean hexists(String hkey, String key);
}
