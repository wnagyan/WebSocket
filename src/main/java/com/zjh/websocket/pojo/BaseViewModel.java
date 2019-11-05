package com.zjh.websocket.pojo;

import java.util.List;

public class BaseViewModel {
    private User mine;

    private List<FriendGroup> friend;

    public User getMine() {
        return mine;
    }

    public void setMine(User mine) {
        this.mine = mine;
    }

    public List<FriendGroup> getFriend() {
        return friend;
    }

    public void setFriend(List<FriendGroup> friend) {
        this.friend = friend;
    }
}
