package com.zjh.websocket.controller;

import com.zjh.websocket.pojo.User;
import com.zjh.websocket.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @Resource
    private VerificationCode verificationCode;

    /***
     * 当用户直接访问localhost：8888/index时，进入到这个方法，
     * 1、方法内判断session中是否有用户，
     * 2、存在用户时：跳转到index界面
     * 3、不存在用户时：跳转到registered界面
     * @param request
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String login(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute(user);

        if(user == null){
            return "registered";
        }
        return "index";
    }

    /***
     * 当用户点击登录按钮时，登录表单提交，进入到此方法
     * 1、往数据库查询是否存在该用户，查询条件：phonenumber
     * 2、存在则往session中存入用户并跳转到index界面，
     * 3、不存在则跳转到registered界面，提示手机号或密码错误
     * 4、如果该user已经存在，提示用户已经登录并跳转到index界面
     * @param user
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpSession httpSession, RedirectAttributesModelMap redirectAttributesModelMap) throws IOException {
        User people = userService.selectUserByPhone(user.getPhonenumber());
        redirectAttributesModelMap.addFlashAttribute(people);
        if(people != null && people.getPassword().equals(user.getPassword()) && people.getStatus() == 0){
            people.setStatus(1);
            userService.updateUser(people);
            httpSession.setAttribute("user", people);

            redirectAttributesModelMap.addFlashAttribute("msg", "loginsuccess");
            return "redirect:index";
        }else if(people != null && people.getStatus() == 1 && people.getPassword().equals(user.getPassword())){
            httpSession.setAttribute("user", people);
            redirectAttributesModelMap.addFlashAttribute("msg", "hadlogin");
            return "redirect:index";
        }else {

            redirectAttributesModelMap.addFlashAttribute("msg", "loginfail");
            return "redirect:registered";
        }
    }

    /***
     * 当用户直接访问localhost：8888/registered时，进入此方法
     * 跳转到登入界面
     * @return
     */
    @RequestMapping(value = "/registered", method = RequestMethod.GET)
    public String registered() {
        return "registered";
    }

    /***
     * 当用户点击注册按钮时，注册表单提交，进入此方法
     * 1、往数据库查找，如果存在该用户，提示用户已经注册过，不存在就往数据库中写入
     * 2、注册成功后返回到registered界面进行登录
     * @param user
     * @return
     */

    @RequestMapping(value = "/registered", method = RequestMethod.POST)
    public Object registering(User user, RedirectAttributesModelMap redirectAttributesModelMap) {
        String string = user.getVcode();
        System.out.println(user.toString());
        if(verificationCode.getVecode() != null && !string.equals(verificationCode.getVecode())){
            redirectAttributesModelMap.addFlashAttribute("msg", "errorvcode");
            return "redirect:registered";
        }
        User people = userService.selectUserByPhone(user.getPhonenumber());
        if(people == null){
            user.setAvatar("/resource/image/1.jpg");
            userService.addUser(user);
            redirectAttributesModelMap.addFlashAttribute("msg", "registeredsuccess");
        }else {
            redirectAttributesModelMap.addFlashAttribute("msg","registeredfail");
        }
        return "redirect:registered";
    }


}
