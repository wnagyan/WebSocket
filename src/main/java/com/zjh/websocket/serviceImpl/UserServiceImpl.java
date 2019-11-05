package com.zjh.websocket.serviceImpl;


import com.zjh.websocket.dao.FriendGroupDao;
import com.zjh.websocket.dao.UserDao;
import com.zjh.websocket.pojo.BaseViewModel;
import com.zjh.websocket.pojo.FriendGroup;
import com.zjh.websocket.pojo.User;
import com.zjh.websocket.service.UserService;
import com.zjh.websocket.util.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean deleteUser(int uid) {
        return userDao.deleteUser(uid);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User selectUserById(int uid) {
        return userDao.selectUserById(uid);
    }

    @Override
    public User selectUserByPhone(String phonenumber) {
        return userDao.selectUserByPhone(phonenumber);
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }




}
