package com.pk10.bean;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 用户信息 由于用户信息全部从微信服务器获取，所以我们只保存 openid , nickname,用以后台管理 还有金币
 *
 * @author Administrator
 *
 */
public class UserInfo {
    Integer id;
    String openid;
    String nickname;
    String headimgurl;// 用户头像路径，不保存到数据库中
    Double money = 0D;
    Date createdAt;
    String username;
    String password;
    String tel;
    Integer isagent;  // 用户等级 0-普通用户 1-二级代理商 2-一级代理商 3-超级管理员
    Double rebate; // 返点
    Integer owner;// 本用户属于哪个代理商
    String detail;// 备注

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public Integer getIsagent() {
        return isagent;
    }

    public void setIsagent(Integer isagent) {
        this.isagent = isagent;
    }

    public Double getRebate() {
        return rebate;
    }

    public void setRebate(Double rebate) {
        this.rebate = rebate;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public UserInfo(String openid, String nickname, Double money, Date createdAt) {
        super();
        this.openid = openid;
        this.nickname = nickname;
        this.money = money;
        this.createdAt = createdAt;
    }

    public UserInfo(String openid, String nickname, String headimgurl, Double money, Date createdAt) {
        super();
        this.openid = openid;
        this.nickname = nickname;
        this.headimgurl = headimgurl;
        this.money = money;
        this.createdAt = createdAt;
    }

    public UserInfo(Integer id) {
        super();
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserInfo [id=" + id + ", openid=" + openid + ", nickname=" + nickname + ", headimgurl=" + headimgurl
                + ", money=" + money + ", createdAt=" + createdAt + ", username=" + username + ", password=" + password
                + ", tel=" + tel + ", isagent=" + isagent + ", rebate=" + rebate + ", owner=" + owner + "]";
    }

    public UserInfo() {
        super();
    }

    public UserInfo(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public UserInfo(String username, String password, String tel) {
        super();
        this.username = username;
        this.password = password;
        this.tel = tel;
    }

}