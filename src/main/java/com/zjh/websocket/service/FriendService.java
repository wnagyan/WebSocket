package com.zjh.websocket.service;

import com.zjh.websocket.pojo.Friend;
import com.zjh.websocket.pojo.User;
import com.zjh.websocket.util.JsonResult;

import java.util.List;

public interface FriendService {

    List<Friend> selectAllFriend(int uid);//查看该用户所有的好友，默认分组为“好友列表”

    List<Friend> selectAllFriendByFgId(int fgid);//根据分组id查询该分组下所有的好友

    boolean addFriend(Friend friend);//根据好友fid添加好友，双向添加，A是B的好友，B也是A的好友

    boolean deleteFriend(Friend friend);//根据好友fid删除好友，双向删除

    boolean addNoteName(Friend friend);//根据好友fid添加备注

    JsonResult getBaseList();//获取符合layim的json数据结构
}
