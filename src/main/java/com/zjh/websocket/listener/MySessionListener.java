package com.zjh.websocket.listener;

import com.zjh.websocket.pojo.User;
import com.zjh.websocket.service.UserService;
import com.zjh.websocket.util.MySessionContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Component
public class MySessionListener implements HttpSessionListener {

    @Resource
    private UserService userService;


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session正在創建");
        MySessionContext.AddSession(se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session注銷中");
        User user = (User) se.getSession().getAttribute("user");
        System.out.println(user);
        user.setStatus(0);
        userService.updateUser(user);
        MySessionContext.DelSession(se.getSession());
    }
}
