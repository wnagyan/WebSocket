package com.zjh.websocket.util;

public enum ResponseType {
    SUCCESS(0,"成功"),
    FAIL(1,"失败"),
    USER_NOTFOUND(00,"用户不存在"),
    USER_WRONG(01,"用户名或密码错误"),
    APPLY_EXIST(31,"您已经添加该好友，请勿重复添加！");

    String msg;
    Integer code;

    private ResponseType(Integer code,String msg){
        this.msg = msg;
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

}
