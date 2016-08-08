package com.pk10.bean;

import java.util.Date;
import java.util.List;

/**
 * 订单相关
 * 
 * @author Administrator
 *
 */
public class Orders {
	Integer id;
	String user; //用户昵称
	Double price;
	String status;//订单状态
	Date createdAt; //创建时间
	String userinfoOpenid;
	List<Goods> goods;
	public List<Goods> getGoods() {
		return goods;
	}
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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

	public Orders() {
		super();
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", user=" + user + ", price=" + price + ", status=" + status + ", createdAt="
				+ createdAt + ", goods=" + goods + ", userinfoOpenid=" + userinfoOpenid + "]";
	}
	public Orders(Integer id, String user, Double price, String status, Date createdAt, List<Goods> goods,
			String userinfoOpenid) {
		super();
		this.id = id;
		this.user = user;
		this.price = price;
		this.status = status;
		this.createdAt = createdAt;
		this.goods = goods;
		this.userinfoOpenid = userinfoOpenid;
	}
	public Orders(String user, Double price, String status, Date createdAt, List<Goods> goods, String userinfoOpenid) {
		super();
		this.user = user;
		this.price = price;
		this.status = status;
		this.createdAt = createdAt;
		this.goods = goods;
		this.userinfoOpenid = userinfoOpenid;
	}
	
}
