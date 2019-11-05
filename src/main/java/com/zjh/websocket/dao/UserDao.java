package com.zjh.websocket.dao;

import com.zjh.websocket.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    boolean addUser(User user);//添加用户

    boolean deleteUser(int uid);//删除用户

    boolean updateUser(User user);//更新用户信息

    User selectUserById(int uid);//根据id查找用户

    User selectUserByPhone(String phone);//根据手机号查找用户

    List<User> selectAll();//查找全部用户


}