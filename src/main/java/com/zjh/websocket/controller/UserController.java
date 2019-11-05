package com.zjh.websocket.controller;

import com.zjh.websocket.pojo.BaseViewModel;
import com.zjh.websocket.pojo.Friend;
import com.zjh.websocket.pojo.FriendGroup;
import com.zjh.websocket.pojo.User;
import com.zjh.websocket.service.EmailService;
import com.zjh.websocket.service.FriendGroupService;
import com.zjh.websocket.service.FriendService;
import com.zjh.websocket.service.UserService;
import com.zjh.websocket.util.JsonResult;
import com.zjh.websocket.util.ResponseType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/***
 * 1、退出登录
 * 2、修改密码
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private FriendGroupService friendGroupService;

    @Resource
    private FriendService friendService;

    /***
     * 点击退出时进入此方法
     * 1、从session中取出用户
     * 2、将用户的state设置为0，意味者用户不在线
     * 3、将session中的用户移除，然后跳转到registered界面
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout")
    public String exit(HttpServletRequest request, HttpSession httpSession){
        User user = (User) request.getSession().getAttribute("user");
        //System.out.println(user);
        user.setStatus(0);
        userService.updateUser(user);
        httpSession.removeAttribute("user");
        System.out.println("你已经退出了！");
        return "redirect:registered";
    }


    @RequestMapping(value = "/usercenter")
    public String lookuser(HttpServletRequest httpServletRequest, Model model){
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        model.addAttribute(user);
        return "usercenter";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateuser(User user, HttpServletRequest httpServletRequest){
        User people = (User) httpServletRequest.getSession().getAttribute("user");
        people.setBirthday(user.getBirthday());
        people.setUsername(user.getUsername());
        people.setAge(user.getAge());
        people.setSex(user.getSex());
        people.setSign(user.getSign());
        userService.updateUser(people);
        System.out.println("保存成功！");
        return "redirect:index";
    }

    @ResponseBody
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public JsonResult getBaseData(HttpServletRequest request){
        User people = (User) request.getSession().getAttribute("user");
        BaseViewModel baseViewModel = new BaseViewModel();
        User mine = userService.selectUserById(people.getId());
        /*mine.setUsername("小盘子");
        mine.setSign("SpringBoot学习中");
        mine.setAvatar("https://vignette.wikia.nocookie.net/dragonball/images/d/da/Kid-Goku-psd61058.png/revision/latest?cb=20120213205410");
        mine.setId(uid);*/

        baseViewModel.setMine(mine);
        //好友列表信息
        ArrayList<FriendGroup> friendsGroups1 = new ArrayList<FriendGroup>();
        List<FriendGroup> friendGroups = friendGroupService.selectAllFriendGroup(people.getId());
        //好友列表1
        for(FriendGroup friendGroup : friendGroups){
            List<Friend> friends = friendService.selectAllFriendByFgId(friendGroup.getId());
            List<User> users = new LinkedList<User>();
            for(Friend friend : friends){
                User user = userService.selectUserById(friend.getFid());
                users.add(user);
            }
            friendGroup.setList(users);
            friendsGroups1.add(friendGroup);
        }
        baseViewModel.setFriend(friendsGroups1);
        /*//群分组信息
        ArrayList<BigGroupViewModel> groups  = new ArrayList<BigGroupViewModel>();

        BigGroupViewModel bigGroup1 = new BigGroupViewModel();
        bigGroup1.setId(1000001L);
        bigGroup1.setGroupname("SpringBoot爱好者群");
        bigGroup1.setAvatar("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTp9Q8BuXHj30KbOHPY7qlnR10oI4cCpplRcBFThQFzZ4bx3mBz");
        groups.add(bigGroup1);

        baseData.setGroup(groups);*/

        return JsonResult.success(baseViewModel);
    }
}
