package com.pk10.bean;

import java.util.Date;

public class UserBet {
	private Integer id;
	private String idnum; // 开奖期数
	private String type;// ` VARCHAR(45) NULL COMMENT '玩法，主要分 ‘单双’ ‘数字’ ‘大小’'
	private Double betmoney;// '下注金额',
	private Integer mulit;// '下注倍数',
	private String betnum;// '下注号码, 也可以是 \'single\' \'double\' \'big\' \'small\'
	private Date createdAt;// ` DATETIME NULL,
	private String userinfoOpenid;// ` VARCHAR(255) NOT NULL,

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
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

	public void setUserinfoOpenid(String userinfoOpenid) {
		this.userinfoOpenid = userinfoOpenid;
	}

	public UserBet() {
		super();
	}

	public UserBet(Integer id, String type, Double betmoney, Integer mulit, String betnum, Date createdAt, String userinfoOpenid) {
		super();
		this.id = id;
		this.type = type;
		this.betmoney = betmoney;
		this.mulit = mulit;
		this.betnum = betnum;
		this.createdAt = createdAt;
		this.userinfoOpenid = userinfoOpenid;
	}

	public UserBet(Integer id, String idnum, String type, Double betmoney, Integer mulit, String betnum, Date createdAt, String userinfoOpenid) {
		super();
		this.id = id;
		this.idnum = idnum;
		this.type = type;
		this.betmoney = betmoney;
		this.mulit = mulit;
		this.betnum = betnum;
		this.createdAt = createdAt;
		this.userinfoOpenid = userinfoOpenid;
	}

	public UserBet(String type, Double betmoney, Integer mulit, String betnum, Date createdAt, String userinfoOpenid) {
		super();
		this.type = type;
		this.betmoney = betmoney;
		this.mulit = mulit;
		this.betnum = betnum;
		this.createdAt = createdAt;
		this.userinfoOpenid = userinfoOpenid;
	}
}
