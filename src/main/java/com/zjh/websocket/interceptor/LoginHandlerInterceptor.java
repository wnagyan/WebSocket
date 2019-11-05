package com.zjh.websocket.interceptor;

import com.zjh.websocket.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        StringBuffer s = request.getRequestURL();

        /*if(s.indexOf("/index") == -1){
            System.out.println("不存在index，不拦截");
            return true;
        }*/
        if (user == null) {
            //未登录,返回登录页面
            System.out.println("拦截成功");
            response.sendRedirect("/registered");
            return false;
        }else {
            //放行
            System.out.println("不拦截");

            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
