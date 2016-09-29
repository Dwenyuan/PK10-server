package com.pk10.bean;

import java.util.Date;

public class UserBet implements Cloneable {
	private Integer id;
	private Integer idnum; // 开奖期数
	private BetType type;// ` VARCHAR(45) NULL COMMENT '玩法，主要分 ‘单双’ ‘数字’ ‘大小’'
	private Double betmoney;// '下注金额',
	private Integer mulit;// '下注倍数',
	private Double odds; // 此次下注赔率 此处根据玩法自动添加
	private String betnum;// '下注号码, 也可以是 \'single\' \'double\' \'big\' \'small\'
	private Date createdAt;// ` DATETIME NULL,
	private Integer userid;// ` VARCHAR(255) NOT NULL,
	private Integer state; // 0:未兑奖 1:已兑奖
	private Integer balance;// 当前下注完之后的余额
	private TokenConfig tokenConfig;

	@Override
	public String toString() {
		return "UserBet [id=" + id + ", idnum=" + idnum + ", type=" + type + ", betmoney=" + betmoney + ", mulit="
				+ mulit + ", odds=" + odds + ", betnum=" + betnum + ", createdAt=" + createdAt + ", userid=" + userid
				+ ", state=" + state + ", balance=" + balance + ", tokenConfig=" + tokenConfig + "]";
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdnum() {
		return idnum;
	}

	public void setIdnum(Integer idnum) {
		this.idnum = idnum;
	}

	public BetType getType() {
		return type;
	}

	public void setType(BetType type) {
		this.type = type;
	}

	public Double getBetmoney() {
		return betmoney;
	}

	public void setBetmoney(Double betmoney) {
		this.betmoney = betmoney;
	}

	public Integer getMulit() {
		return mulit;
	}

	public void setMulit(Integer mulit) {
		this.mulit = mulit;
	}

	public String getBetnum() {
		return betnum;
	}

	public void setBetnum(String betnum) {
		this.betnum = betnum;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getUserid() {
		return userid;
	}

	public TokenConfig getTokenConfig() {
		return tokenConfig;
	}

	public void setTokenConfig(TokenConfig tokenConfig) {
		this.tokenConfig = tokenConfig;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Double getOdds() {
		return this.odds;
	}

	public void setOdds() {
		switch (this.type) {
		case NUMBER:
			this.odds = tokenConfig.getNumberOdd();
			break;
		case SINGLE_OR_DOUBLE:
			this.odds = tokenConfig.getSingleOdd();
			break;
		case BIG_OR_SMALL:
			this.odds = tokenConfig.getBigOdd();
			break;
		default:
			break;
		}
	}

	public UserBet() {
		super();
	}

	public UserBet(Integer id, Integer idnum, BetType type, Double betmoney, Integer mulit, String betnum,
			Date createdAt, Integer userid, TokenConfig tokenConfig) {
		super();
		this.id = id;
		this.idnum = idnum;
		this.type = type;
		this.betmoney = betmoney;
		this.mulit = mulit;
		this.betnum = betnum;
		this.createdAt = createdAt;
		this.userid = userid;
		this.tokenConfig = tokenConfig;
		this.setOdds();
	}

	public UserBet(Integer idnum, BetType type, Double betmoney, Integer mulit, String betnum, Date createdAt,
			Integer userid, TokenConfig tokenConfig) {
		super();
		this.idnum = idnum;
		this.type = type;
		this.betmoney = betmoney;
		this.mulit = mulit;
		this.betnum = betnum;
		this.createdAt = createdAt;
		this.userid = userid;
		this.tokenConfig = tokenConfig;
	}

	@Override
	public UserBet clone() throws CloneNotSupportedException {
		return (UserBet) super.clone();
	}
}
