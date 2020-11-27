/*
package com.angular.angulartest.Filter;

import com.angular.angulartest.util.IpUtils;
import com.angular.angulartest.util.MD5;
import com.angular.angulartest.util.redis.JedisClient;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
@PropertySource(value = "classpath:address.properties")
public class MappingFilter implements HandlerInterceptor {

    @Value("${REDIS_USER_SESSION_KEY}")
    private String REDIS_USER_SESSION_KEY;
    @Autowired
    private JedisClient jedisClient;
    @Autowired
    private IpUtils ipUtils;

    private static final Logger logger = LoggerFactory.getLogger(MappingFilter.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("--------------------------YSD拦截器执行--------------------------------------------------");
        HttpSession session = request.getSession();
        String sessionid = session.getId();
        String sessionid_MD5 = MD5.ecode(sessionid);
        String str = ipUtils.getInnetIp();//获取IP
        if("".equals(jedisClient.get(REDIS_USER_SESSION_KEY+":"+str))){
            //System.out.println("null");
            return true;
        }else{
            String redis_val = jedisClient.get(REDIS_USER_SESSION_KEY+":"+str);
            if(redis_val==null){
                return true;
            }else{
                JSONObject redis_json = JSONObject.fromObject(redis_val);
                String usermd5_ssid = redis_json.getString("sessionid");
                if(usermd5_ssid.equals(sessionid_MD5)){
                    return true;
                }else{
                    return false;
                }
            }
        }

    }

    */
/**
     * md5加密
     *
     * @param str
     * @return
     *//*

    public static String getMD5(String str) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
        if (null != md && null != md.digest()) {
            return new BigInteger(1, md.digest()).toString(16);
        } else {
            return "";
        }
    }
}
*/
