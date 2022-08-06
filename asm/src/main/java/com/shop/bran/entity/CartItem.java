package com.shop.bran.entity;

import java.math.BigDecimal;

public class CartItem {
	private Cam cam;
	private Integer id;
	private String ten;
	private Integer quantity;
	private BigDecimal gia;
	private String anh;
	public Cam getCam() {
		return cam;
	}
	public void setCam(Cam cam) {
		this.cam = cam;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public BigDecimal getGia() {
		return gia;
	}
	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public CartItem() {
		super();
	}
}
