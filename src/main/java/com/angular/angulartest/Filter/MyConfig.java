package com.angular.angulartest.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MyConfig extends WebMvcConfigurationSupport {

    @Bean
    public MappingFilter getSessionInterceptor() {
        return new MappingFilter();
    }

    protected void addInterceptors(InterceptorRegistry registry) {
        //注册自己的拦截器,并设置拦截路径，拦截多个可以全一个list集合
        registry.addInterceptor(getSessionInterceptor()).addPathPatterns("/**");
    }
}
