package com.angular.angulartest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.angular.angulartest.dao.mapper")
public class AngulartestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AngulartestApplication.class, args);
    }

}
