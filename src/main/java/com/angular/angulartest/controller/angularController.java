package com.angular.angulartest.controller;

import com.alibaba.fastjson.JSONObject;
import com.angular.angulartest.dao.entity.User;
import com.angular.angulartest.dao.service.impl.UserServiceImpl;
import com.angular.angulartest.util.IpUtils;
import com.angular.angulartest.util.MD5;
import com.angular.angulartest.util.redis.JedisClient;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.SocketException;


@RestController
@RequestMapping("/angular")
public class angularController {

    @Autowired
    private IpUtils ipUtils;
    @Autowired
    private JedisClient jedisClient;
    @Value("${REDIS_USER_SESSION_KEY}")
    private String REDIS_USER_SESSION_KEY;

    @Autowired
    private UserServiceImpl userServiceImpl;

    //系统级日志
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(angularController.class);

    @GetMapping("test")
    public String AnlinkTest(HttpServletRequest request){
        logger.info("------------------测试调用成功-------------");
        System.out.println(ipUtils.getClientIpAddress(request));
        System.out.println("hello angularTest!");
        return "hello angularTest!";
    }

    @PostMapping(value = "/login")
    public JSONObject Anlogin(@RequestBody JSONObject jsonObject,HttpServletRequest request){
        logger.info("-----------------------------angular登录------------------------");
        JSONObject json = new JSONObject();
        if(jsonObject.get("username")!=null){
            QueryWrapper<User> UserQueryWrapper = new QueryWrapper();
            UserQueryWrapper.eq("USERNAME",jsonObject.getString("username"));
            User userone = userServiceImpl.getOne(UserQueryWrapper);
            if(userone!=null){
                if(jsonObject.getString("password").equals(userone.getPassword())){
                    String ipv4 = "";
                    try {
                        ipv4 = ipUtils.getInnetIp();
                    } catch (SocketException e) {
                        json.put("login","false");
                        return json;
                    }
                    HttpSession session = request.getSession();
                    String sessionid = session.getId();
                    jsonObject.put("sessionid",MD5.ecode(sessionid));//sessionid
                    jedisClient.set(REDIS_USER_SESSION_KEY+":"+ipv4,jsonObject.toJSONString());
                    json.put("login","true");
                    logger.info("-----------------------------angular登录成功------------------------");
                    return json;
                }else{
                    logger.info("-----------------------------angular登录失败------------------------");
                    json.put("login","false");
                    return json;
                }
            }else{
                logger.info("-----------------------------angular登录失败------------------------");
                json.put("login","false");
                return json;
            }
        }else{
            logger.info("-----------------------------angular登录失败------------------------");
            json.put("login","false");
            return json;
        }
    }

    @PostMapping("verlogin")
    public JSONObject AnTest(HttpServletRequest request){
        logger.info("-----------------------------angular验证登录------------------------");
        JSONObject json = new JSONObject();
        String ipv4 = "";
        try {
            ipv4 = ipUtils.getInnetIp();
        } catch (SocketException e) {
            json.put("login","false");
            return json;
        }
        HttpSession session = request.getSession();
        String sessionid = session.getId();
        //System.out.println(sessionid);
        String verlogin_flag = jedisClient.get(REDIS_USER_SESSION_KEY+":"+ipv4);
        if(verlogin_flag!=null){
            json.put("login","true");
            logger.info("-----------------------------angular登录成功------------------------");
        }else{
            json.put("login","false");
            logger.info("-----------------------------angular登录失败------------------------");
        }
        return json;
    }

    @GetMapping("websocket")
    public JSONObject webst(@RequestParam("userId") String userId){
        JSONObject json = new JSONObject();
        System.out.println("userId");
        json.put("message",3);
        json.put("user",userId);
        return json;
    }
}
