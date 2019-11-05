package com.zjh.websocket.service;

import com.zjh.websocket.pojo.FriendGroup;

import java.util.List;

public interface FriendGroupService {
    List<FriendGroup> selectAllFriendGroup(int uid);//查看该用户所有的好友列表

    boolean addFriendGroup(FriendGroup friendGroup);//

    boolean deleteFriendGroup(FriendGroup friendGroup);//

    boolean updateFriendGroup(FriendGroup friendGroup);//
}
