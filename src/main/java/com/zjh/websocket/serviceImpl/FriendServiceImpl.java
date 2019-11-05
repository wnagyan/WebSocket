package com.zjh.websocket.serviceImpl;

import com.zjh.websocket.dao.FriendDao;
import com.zjh.websocket.pojo.Friend;
import com.zjh.websocket.pojo.User;
import com.zjh.websocket.service.FriendService;
import com.zjh.websocket.util.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {

    @Resource
    private FriendDao friendDao;


    @Override
    public List<Friend> selectAllFriend(int uid) {
        return friendDao.selectAllFriend(uid);
    }

    @Override
    public List<Friend> selectAllFriendByFgId(int fgid) {
        return friendDao.selectAllFriendByFgId(fgid);
    }

    @Override
    public boolean addFriend(Friend friend) {
        return friendDao.addFriend(friend);
    }

    @Override
    public boolean deleteFriend(Friend friend) {
        return friendDao.deleteFriend(friend);
    }

    @Override
    public boolean addNoteName(Friend friend) {
        return friendDao.addNoteName(friend);
    }

    @Override
    public JsonResult getBaseList() {



        return null;
    }
}
