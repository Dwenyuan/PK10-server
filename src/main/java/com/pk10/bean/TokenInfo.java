package com.pk10.bean;

import java.util.Date;
/**
 * 由于token 有时间限期，所以缓存到数据库
 * @author Administrator
 *
 */
public class TokenInfo {
	String tokenid;
	String id = "access_token";//标志 用以更新token
	Date createdAt;
	Date updatedAt;
	public String getTokenid() {
		return tokenid;
	}
	public void setTokenid(String tokenid) {
		this.tokenid = tokenid;
	}
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
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "TokenInfo [tokenid=" + tokenid + ", id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}
	public TokenInfo() {
		super();
	}
	public TokenInfo(String tokenid, Date createdAt, Date updatedAt) {
		super();
		this.tokenid = tokenid;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

}
