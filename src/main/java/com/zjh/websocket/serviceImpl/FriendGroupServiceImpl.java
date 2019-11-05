package com.zjh.websocket.serviceImpl;

import com.zjh.websocket.dao.FriendGroupDao;
import com.zjh.websocket.pojo.FriendGroup;
import com.zjh.websocket.service.FriendGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FriendGroupServiceImpl implements FriendGroupService {

    @Resource
    private FriendGroupDao friendGroupDao;

    @Override
    public List<FriendGroup> selectAllFriendGroup(int uid) {
        return friendGroupDao.selectAllFriendGroup(uid);
    }

    @Override
    public boolean addFriendGroup(FriendGroup friendGroup) {
        return friendGroupDao.addFriendGroup(friendGroup);
    }

    @Override
    public boolean deleteFriendGroup(FriendGroup friendGroup) {
        return friendGroupDao.deleteFriendGroup(friendGroup);
    }

    @Override
    public boolean updateFriendGroup(FriendGroup friendGroup) {
        return friendGroupDao.updateFriendGroup(friendGroup);
    }
}
