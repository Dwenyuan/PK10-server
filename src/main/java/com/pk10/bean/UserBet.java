package com.pk10.bean;

import java.util.Date;

public class UserBet {
	private Integer id;
	private String idnum; // 开奖期数
	private BetType type;// ` VARCHAR(45) NULL COMMENT '玩法，主要分 ‘单双’ ‘数字’ ‘大小’'
	private Double betmoney;// '下注金额',
	private Integer mulit;// '下注倍数',
	private Double Odds; // 此次下注赔率 此处根据玩法自动添加
	private String betnum;// '下注号码, 也可以是 \'single\' \'double\' \'big\' \'small\'
	private Date createdAt;// ` DATETIME NULL,
	private String userinfoOpenid;// ` VARCHAR(255) NOT NULL,

	private TokenConfig tokenConfig;

	@Override
	public String toString() {
		return "UserBet [id=" + id + ", type=" + type + ", betmoney=" + betmoney + ", mulit=" + mulit + ", betnum=" + betnum + ", createdAt=" + createdAt + ", userinfoOpenid="
				+ userinfoOpenid + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdnum() {
		return idnum;
	}

	public void setIdnum(String idnum) {
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

	public String getUserinfoOpenid() {
		return userinfoOpenid;
	}

	public TokenConfig getTokenConfig() {
		return tokenConfig;
	}

	public void setTokenConfig(TokenConfig tokenConfig) {
		this.tokenConfig = tokenConfig;
	}

	public void setUserinfoOpenid(String userinfoOpenid) {
		this.userinfoOpenid = userinfoOpenid;
	}

	public Double getOdds() {
		return this.Odds;
	}

	public void setOdds() {
		switch (this.type) {
		case NUMBER:
			this.Odds = tokenConfig.getNumberOdd();
			break;
		case SINGLE_OR_DOUBLE:
			this.Odds = tokenConfig.getSingleOdd();
			break;
		case BIG_OR_SMALL:
			this.Odds = tokenConfig.getBigOdd();
			break;
		default:
			break;
		}
	}

	public UserBet() {
		super();
	}

	public UserBet(Integer id, String idnum, BetType type, Double betmoney, Integer mulit, String betnum, Date createdAt, String userinfoOpenid, TokenConfig tokenConfig) {
		super();
		this.id = id;
		this.idnum = idnum;
		this.type = type;
		this.betmoney = betmoney;
		this.mulit = mulit;
		this.betnum = betnum;
		this.createdAt = createdAt;
		this.userinfoOpenid = userinfoOpenid;
		this.tokenConfig = tokenConfig;
		this.setOdds();
	}

}