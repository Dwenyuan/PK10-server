package com.pk10.bean;

import java.util.Date;

/**
 * 左上角 通知
 * @author Administrator
 *
 */
public class Notice {
	Integer id;
	String title;
	String content;
	Date createdAt;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", content=" + content + ", createdAt=" + createdAt + "]";
	}
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notice(String title, String content, Date createdAt) {
		super();
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
	}
	public Notice(Integer id, String title, String content, Date createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
	}
	
}
