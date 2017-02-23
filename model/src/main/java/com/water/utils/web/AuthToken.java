package com.water.utils.web;

/**
 * Created by zhangmiaojie on 2017/2/22.
 */
public class AuthToken {
    public String access_token; //用户授权的唯一票据
    public String expires_in; //access_token的生命周期，单位是秒数。
    public String remind_in; //access_token的生命周期(该参数即将废弃)
    public String uid;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getRemind_in() {
        return remind_in;
    }

    public void setRemind_in(String remind_in) {
        this.remind_in = remind_in;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
