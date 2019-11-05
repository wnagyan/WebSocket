package com.zjh.websocket.controller;


import com.zjh.websocket.pojo.User;
import com.zjh.websocket.serviceImpl.EmailServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class VerificationCode {

    private String vecode;

    public String getVecode() {
        return vecode;
    }

    public void setVecode(String vecode) {
        this.vecode = vecode;
    }

    /***
     * 用来产生并发送验证码
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sendemail", method = RequestMethod.POST)
    public Object sendmail(EmailServiceImpl emailService, HttpServletRequest request){
        String email = request.getParameter("email");
        String string = "0123456789abcdefghijklmnopqrstuvwxzy";
        String ss = "";
        for(int i = 0; i < 6; i++){
            ss += string.charAt((int)(Math.random() * 36));
        }
        emailService.setEMail(email, "验证码", ss);
        setVecode(ss);
        System.out.println(vecode);
        Map<String,String> message = new HashMap<String, String>();
        message.put("msg","success");
        return message;
    }

}
