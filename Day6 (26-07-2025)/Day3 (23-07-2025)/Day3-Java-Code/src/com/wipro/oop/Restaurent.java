package com.wipro.oop;

public class Restaurent {
	

	String OrderId;
	double Price;
	int noOfItems;
	
	public Restaurent(){
		
	}
	
	public Restaurent(String orderId, double price, int noOfItems) {
		super();
		OrderId = orderId;
		Price = price;
		this.noOfItems = noOfItems;
	}

	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String orderId) {
		OrderId = orderId;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	@Override
	public String toString() {
		return "Restaurent [OrderId=" + OrderId + ", Price=" + Price + ", noOfItems=" + noOfItems + "]";
	}

}
