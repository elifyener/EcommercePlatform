package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {
 
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name="id")
 protected int id;
 
 @Column(name="name")
 protected String name;
 
 @Column(name="surname")
 protected String surname;
 
 @Column(name="email")
 protected String email;
 
 @Column(name="password")
 protected String password;
 
 public User() {
 }
 
 public User(String name, String surname, String email, String password) {
  super();
  this.name = name;
  this.surname = surname;
  this.email = email;
  this.password = password;
 }

 public User(int id, String name, String surname, String email, String password) {
  super();
  this.id = id;
  this.name = name;
  this.surname = surname;
  this.email = email;
  this.password = password;
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
 public String getPassword() {
  return password;
 }
 public void setPassword(String password) {
  this.password = password;
 }
}