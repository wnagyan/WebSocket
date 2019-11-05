package com.zjh.websocket.pojo;

public class Friend {
    private int id;//自增id，做主键
    private int uid;//用户id
    private int fid;//好友id
    private int typeid;//分组id，默认所有用户都只有一个分组，“好友列表”
    private String notename;//好友备注

    public String getNotename() {
        return notename;
    }

    public void setNotename(String notename) {
        this.notename = notename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }
}
