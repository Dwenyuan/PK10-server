package com.pk10.bean;

/**
 * @author Administrator
 *
 */
public class OrdersHasGoods {
	Integer orderId;
	Integer goodsId;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	@Override
	public String toString() {
		return "OrdersHasGoods [orderId=" + orderId + ", goodsId=" + goodsId + "]";
	}
	public OrdersHasGoods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrdersHasGoods(Integer orderId, Integer goodsId) {
		super();
		this.orderId = orderId;
		this.goodsId = goodsId;
	}
}
