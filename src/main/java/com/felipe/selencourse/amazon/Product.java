package com.felipe.selencourse.amazon;
/**
 * Random class 
 * @author Niemand
 *
 */
public class Product {

	private String name;
	private double price;
	private String skuID;

	public void purchase(int quantity) {
		System.out.println("You have purchased " + quantity + " weas.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSkuID() {
		return skuID;
	}

	public void setSkuID(String skuID) {
		this.skuID = skuID;
	}

}
