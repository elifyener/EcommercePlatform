package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="orders")
	public class AdminOrder {
	 
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id")
	 protected int id;
	 
	 @Column(name="ordernum")
	 protected int ordernum;
	 
	 @Column(name="name")
	 protected String name;
	 
	 @Column(name="surname")
	 protected String surname;
	 
	 @Column(name="email")
	 protected String email;
	 
	 @Column(name="cost")
	 protected String cost;
	 
	 public AdminOrder() {
	 }
	 
	 public AdminOrder(int ordernum, String name, String surname, String email, String cost) {
	  super();
	  this.ordernum = ordernum;
	  this.name = name;
	  this.surname = surname;
	  this.email = email;
	  this.cost = cost;
	 }

	 public AdminOrder(int id, int ordernum, String name, String surname, String email, String cost) {
	  super();
	  this.id = id;
	  this.ordernum = ordernum;
	  this.name = name;
	  this.surname = surname;
	  this.email = email;
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
	 
	 public String getSurname() {
		  return surname;
		 }
	 public void setSurname(String surname) {
	  this.surname = surname;
	 }
	 public String getEmail() {
	  return email;
	 }
	 public void setEmail(String email) {
	  this.email = email;
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
