package com.shop.bran.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import aj.org.objectweb.asm.Type;

@Entity
@Table(name="Cam")
public class Cam {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "ten")
	private String ten;
	@Column(name= " loai")
	private CamType loai;
	@Column(name = "soluong")
	private Integer soluong;
	@Column(name = "trongluong")
	private Integer trongluong;
	@Column(name = "hansudung")
	private Date hansudung;
	@Column(name = "anh")
	private String anh;
	@Column(name= "gia")
	private BigDecimal gia;
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
	public CamType getLoai() {
		return loai;
	}
	public void setLoai(CamType loai) {
		this.loai = loai;
	}
	public Integer getSoluong() {
		return soluong;
	}
	public void setSoluong(Integer soluong) {
		this.soluong = soluong;
	}
	public Integer getTrongluong() {
		return trongluong;
	}
	public void setTrongluong(Integer trongluong) {
		this.trongluong = trongluong;
	}
	public Date getHansudung() {
		return hansudung;
	}
	public void setHansudung(Date hansudung) {
		this.hansudung = hansudung;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public BigDecimal getGia() {
		return gia;
	}
	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}
	@Override
	public String toString() {
		return "Cam [id=" + id + ", ten=" + ten + ", loai=" + loai + ", soluong=" + soluong + ", trongluong="
				+ trongluong + ", hansudung=" + hansudung + ", anh=" + anh + ", gia=" + gia + "]";
	}
}