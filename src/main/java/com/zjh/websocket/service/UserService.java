package com.zjh.websocket.service;

import com.zjh.websocket.pojo.User;
import com.zjh.websocket.util.JsonResult;

import java.util.List;

public interface UserService {
    boolean addUser(User user);//添加用户

    boolean deleteUser(int uid);//删除用户

    boolean updateUser(User user);//更新用户信息

    User selectUserById(int uid);//根据id查找用户

    User selectUserByPhone(String phonenumber);//根据手机号查找用户

    List<User> selectAll();//查找全部用户


}