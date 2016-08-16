package com.pk10.bean;

import java.util.Date;

/**
 * 用户信息 由于用户信息全部从微信服务器获取，所以我们只保存 openid , nickname,用以后台管理
 * 还有金币
 * @author Administrator
 *
 */
public class UserInfo {
	String openid;
	String nickname;
	String headimgurl;//用户头像路径，不保存到数据库中
	Double money = 0D;
	Date createdAt;

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public Date getCreatedAt() {
		return createdAt;
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

	public UserInfo(String openid) {
		super();
		this.openid = openid;
	}

	@Override
	public String toString() {
		return "UserInfo [openid=" + openid + ", nickname=" + nickname + ", money=" + money + ", createdAt=" + createdAt
				+ "]";
	}

	public UserInfo() {
		super();
	}

}
