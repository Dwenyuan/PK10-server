package com.pk10.bean;

import java.util.Date;

public class LotteryHistory {
	private String id;
	private Date createdAt;
	private Integer lotterynum1;
	private Integer lotterynum2;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getLotterynum1() {
		return lotterynum1;
	}
	public void setLotterynum1(Integer lotterynum1) {
		this.lotterynum1 = lotterynum1;
	}
	public Integer getLotterynum2() {
		return lotterynum2;
	}
	public void setLotterynum2(Integer lotterynum2) {
		this.lotterynum2 = lotterynum2;
	}
	@Override
	public String toString() {
		return "LotteryHistory [id=" + id + ", createdAt=" + createdAt + ", lotterynum1=" + lotterynum1
				+ ", lotterynum2=" + lotterynum2 + "]";
	}
	public LotteryHistory(String id, Date createdAt, Integer lotterynum1, Integer lotterynum2) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.lotterynum1 = lotterynum1;
		this.lotterynum2 = lotterynum2;
	}
	public LotteryHistory() {
		super();
	}
	public LotteryHistory(Date createdAt, Integer lotterynum1, Integer lotterynum2) {
		super();
		this.createdAt = createdAt;
		this.lotterynum1 = lotterynum1;
		this.lotterynum2 = lotterynum2;
	}
}
