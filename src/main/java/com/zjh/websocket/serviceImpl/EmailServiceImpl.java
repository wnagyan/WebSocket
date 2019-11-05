package com.zjh.websocket.serviceImpl;

import com.zjh.websocket.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

    private String from = "1286184112@qq.com";

    @Override
    public void setEMail(String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailSender.setHost("smtp.qq.com");
        mailSender.setProtocol("smtp");
        mailSender.setUsername("1286184112@qq.com");
        mailSender.setPassword("gcqibcgxrfqlidfg");
        mailSender.setPort(587);
        mailSender.setDefaultEncoding("UTF-8");

        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        System.out.println(mailSender==null);
        System.out.println(from);
        mailSender.send(mailMessage);
    }
}
