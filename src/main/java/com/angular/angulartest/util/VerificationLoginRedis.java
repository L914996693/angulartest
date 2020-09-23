package com.angular.angulartest.util;

import com.angular.angulartest.util.redis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PropertySource(value = "classpath:address.properties")
@CrossOrigin
@RestController
@RequestMapping("vflogin")
public class VerificationLoginRedis {

    @Autowired
    private JedisClient jedisClient;
    @Value("${REDIS_USER_SESSION_KEY}")
    private String REDIS_USER_SESSION_KEY;

    /**
     * redis-token生成规则 key-ip-md5(sessionid)    value username:password
     */
}
