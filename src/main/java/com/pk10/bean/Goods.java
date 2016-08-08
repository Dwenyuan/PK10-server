package com.pk10.bean;

/**
 * 商品类
 * @author Administrator
 *
 */
public class Goods {
	Integer id;
	String goodname; //商品名称
	Double price; //价格
	String goodsimg; //图片
	Integer goodsnum; //剩余数量
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getGoodsimg() {
		return goodsimg;
	}
	public void setGoodsimg(String goodsimg) {
		this.goodsimg = goodsimg;
	}
	public Integer getGoodsnum() {
		return goodsnum;
	}
	public void setGoodsnum(Integer goodsnum) {
		this.goodsnum = goodsnum;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", goodname=" + goodname + ", price=" + price + ", goodsimg=" + goodsimg
				+ ", goodsnum=" + goodsnum + "]";
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods(Integer id, String goodname, Double price, String goodsimg, Integer goodsnum) {
		super();
		this.id = id;
		this.goodname = goodname;
		this.price = price;
		this.goodsimg = goodsimg;
		this.goodsnum = goodsnum;
	}
	public Goods(String goodname, Double price, String goodsimg, Integer goodsnum) {
		super();
		this.goodname = goodname;
		this.price = price;
		this.goodsimg = goodsimg;
		this.goodsnum = goodsnum;
	}
		
}
