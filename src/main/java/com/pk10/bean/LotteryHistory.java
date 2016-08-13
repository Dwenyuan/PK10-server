package com.pk10.bean;

import java.util.Date;

public class LotteryHistory {
	private Integer id;
	private Date createdAt;
	private String lotterynums;

	public String getLotterynums() {
		return lotterynums;
	}

	public void setLotterynums(String lotterynums) {
		this.lotterynums = lotterynums;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "LotteryHistory [id=" + id + ", createdAt=" + createdAt + ", lotterynums=" + lotterynums + "]";
	}

	public LotteryHistory() {
		super();
	}

	public LotteryHistory(Integer id, Date createdAt, String lotterynums) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.lotterynums = lotterynums;
	}
}
