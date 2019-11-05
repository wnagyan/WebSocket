package com.zjh.websocket.dao;

import com.zjh.websocket.pojo.FriendGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface FriendGroupDao {
    List<FriendGroup> selectAllFriendGroup(int uid);//查看该用户所有的好友列表

    boolean addFriendGroup(FriendGroup friendGroup);//

    boolean deleteFriendGroup(FriendGroup friendGroup);//

    boolean updateFriendGroup(FriendGroup friendGroup);//
}
