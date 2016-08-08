package com.pk10.bean;

/**
 * token 票据相关
 * @author Administrator
 *
 */
public class TokenConfig {
	String tokenUrl;
	String appID;
	String appsecret;
	Integer lotteryTime;//开奖时间间隔 单位 分钟
	public Integer getLotteryTime() {
		return lotteryTime;
	}
	public void setLotteryTime(Integer lotteryTime) {
		this.lotteryTime = lotteryTime;
	}
	public String getTokenUrl() {
		return tokenUrl;
	}
	public void setTokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}
	public String getAppID() {
		return appID;
	}
	public void setAppID(String appID) {
		this.appID = appID;
	}
	public String getAppsecret() {
		return appsecret;
	}
	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	@Override
	public String toString() {
		return "TokenConfig [tokenUrl=" + tokenUrl + ", appID=" + appID + ", appsecret=" + appsecret + "]";
	}
	public TokenConfig() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TokenConfig(String tokenUrl, String appID, String appsecret) {
		super();
		this.tokenUrl = tokenUrl;
		this.appID = appID;
		this.appsecret = appsecret;
	}
	
}
