package com.angular.angulartest;

import org.java_websocket.client.WebSocketClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
@MapperScan("com.angular.angulartest.dao.mapper")
public class AngulartestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AngulartestApplication.class, args);
    }

}
