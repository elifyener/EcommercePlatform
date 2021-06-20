package com.ecommerce.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="carts")
	public class UserOrder {
	 
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id")
	 protected int id;
	 
	 @Column(name="ordernum")
	 protected int ordernum;
	 
	 @Column(name="name")
	 protected String name;
	 
	 @Column(name="userid")
	 protected int userid;
	 
	 @Column(name="adet")
	 protected String adet;
	 
	 @Column(name="cost")
	 protected String cost;
	 
	 public UserOrder() {
	 }
	 
	 public UserOrder(int ordernum, String name, int userid, String adet, String cost) {
	  super();
	  this.ordernum = ordernum;
	  this.name = name;
	  this.userid = userid;
	  this.adet = adet;
	  this.cost = cost;
	 }

	 public UserOrder(int id, int ordernum, String name, int userid, String adet, String cost) {
	  super();
	  this.id = id;
	  this.ordernum = ordernum;
	  this.name = name;
	  this.userid = userid;
	  this.adet = adet;
	  this.cost = cost;
	 }

	 public int getId() {
	  return id;
	 }
	 public void setId(int id) {
	  this.id = id;
	 }
	 public String getName() {
	  return name;
	 }
	 public void setName(String name) {
	  this.name = name;
	 }

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getAdet() {
		return adet;
	}

	public void setAdet(String adet) {
		this.adet = adet;
	}

	public int getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
	}
