package com.pk10.bean;

/**
 * token 票据相关
 * 
 * @author Administrator
 *
 */
public class TokenConfig {
	String tokenUrl;
	String appID;
	String appsecret;
	Double numberOdd;// 选择数字的赔率
	Double singleOdd;// 选择单双的赔率
	Double bigOdd;// 选择大小的赔率
	
	Double money;//初始化用户时 赠送金币的数量
	Integer lotteryTime;// 开奖时间间隔 单位 分钟

	public TokenConfig(String tokenUrl, String appID, String appsecret, Double numberOdd, Double singleOdd, Double bigOdd, Double money, Integer lotteryTime) {
		super();
		this.tokenUrl = tokenUrl;
		this.appID = appID;
		this.appsecret = appsecret;
		this.numberOdd = numberOdd;
		this.singleOdd = singleOdd;
		this.bigOdd = bigOdd;
		this.money = money;
		this.lotteryTime = lotteryTime;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

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

	public Double getNumberOdd() {
		return numberOdd;
	}

	public void setNumberOdd(Double numberOdd) {
		this.numberOdd = numberOdd;
	}

	public Double getSingleOdd() {
		return singleOdd;
	}

	public void setSingleOdd(Double singleOdd) {
		this.singleOdd = singleOdd;
	}

	public Double getBigOdd() {
		return bigOdd;
	}

	public void setBigOdd(Double bigOdd) {
		this.bigOdd = bigOdd;
	}

	@Override
	public String toString() {
		return "TokenConfig [tokenUrl=" + tokenUrl + ", appID=" + appID + ", appsecret=" + appsecret + "]";
	}

	public TokenConfig() {
		super();
	}

	public TokenConfig(String tokenUrl, String appID, String appsecret) {
		super();
		this.tokenUrl = tokenUrl;
		this.appID = appID;
		this.appsecret = appsecret;
	}

}
