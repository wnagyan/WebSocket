package com.zjh.websocket;

import com.zjh.websocket.controller.UserController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@MapperScan("com.zjh.websocket.dao.UserDao")
@SpringBootApplication
public class WebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);
    }

    /*@Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return container -> {
            container.setSessionTimeout(10);*//*单位为S*//*
        };
    }*/


}
