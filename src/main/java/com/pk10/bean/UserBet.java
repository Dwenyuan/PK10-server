package com.pk10.bean;

import java.util.Date;
import java.util.List;

public class UserBet implements Cloneable {
	private Integer id;
	private Integer idnum; // 开奖期数
	private BetType type;// ` VARCHAR(45) NULL COMMENT '玩法，主要分 ‘单双’ ‘数字’ ‘大小’'
	private Integer betmoney;// '下注金额',
	private Integer mulit;// '下注倍数',
	private Double odds; // 此次下注赔率 此处根据玩法自动添加
	private String betnum;// '下注号码, 也可以是 \'single\' \'double\' \'big\' \'small\'
	private Date createdAt;// ` DATETIME NULL,
	private Integer userid;// ` VARCHAR(255) NOT NULL,
	private Integer state; // 0:未兑奖 1:已兑奖
	private String result; // 当前下注是否中奖 三种状态 未开奖 | 未中奖 | 中奖金额
	private Integer balance;// 当前下注完之后的余额
	private Integer crashbalance; //兑奖后的余额
	private TokenConfig tokenConfig;
	private List<BetInit> betInits ;

	
	@Override
	public String toString() {
		return "UserBet [id=" + id + ", idnum=" + idnum + ", type=" + type + ", betmoney=" + betmoney + ", mulit="
				+ mulit + ", odds=" + odds + ", betnum=" + betnum + ", createdAt=" + createdAt + ", userid=" + userid
				+ ", state=" + state + ", result=" + result + ", balance=" + balance + ", crashbalance=" + crashbalance
				+ ", tokenConfig=" + tokenConfig + ", betInits=" + betInits + "]";
	}

	public Integer getCrashbalance() {
		return crashbalance;
	}

	public void setCrashbalance(Integer crashbalance) {
		this.crashbalance = crashbalance;
	}

	public List<BetInit> getBetInits() {
		return betInits;
	}
	
	public void setBetInits(List<BetInit> betInits) {
		this.betInits = betInits;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setOdds(Double odds) {
		this.odds = odds;
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

	public Integer getBetmoney() {
		return betmoney;
	}

	public void setBetmoney(Integer betmoney) {
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
			for (BetInit betInit : betInits) {
				String type = betInit.getType();
				if("数字".equals(type)){					
					this.odds = betInit.getRate();
					break;
				}
			}
			break;
		case SINGLE_OR_DOUBLE:
			for (BetInit betInit : betInits) {
				String type = betInit.getType();
				if("大小单双".equals(type)){					
					this.odds = betInit.getRate();
					break;
				}
			}
			break;
		case BIG_OR_SMALL:
			for (BetInit betInit : betInits) {
				String type = betInit.getType();
				if("大小单双".equals(type)){					
					this.odds = betInit.getRate();
					break;
				}
			}
			break;
		default:
			break;
		}
	}

	public UserBet() {
		super();
	}

	public UserBet(Integer id, Integer idnum, BetType type, Integer betmoney, Integer mulit, String betnum,
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

	public UserBet(Integer idnum, BetType type, Integer betmoney, Integer mulit, String betnum, Date createdAt,
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
