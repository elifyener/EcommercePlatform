package com.ecommerce.model;

public class Item {
	private String itemID;
	private String name;
	private String shortDescription;
	private String longDescription;
	private double cost;
	public Item(String itemID, String name, String shortDescription,
	String longDescription, double cost) {
		setItemID(itemID);
		setName(name);
		setShortDescription(shortDescription);
		setLongDescription(longDescription);
		setCost(cost);
	}
	
	public String getName() {
		return (name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItemID() {
	return(itemID);
	}
	protected void setItemID(String itemID) {
	this.itemID = itemID;
	}
	public String getShortDescription() {
	return(shortDescription);
	}
	protected void setShortDescription(String shortDescription) {
	this.shortDescription = shortDescription;
	}
	public String getLongDescription() {
	return(longDescription);
	}
	protected void setLongDescription(String longDescription) {
	this.longDescription = longDescription;
	}
	public double getCost() {
	return(cost);
	}
	protected void setCost(double cost) {
	this.cost = cost;
	}
}