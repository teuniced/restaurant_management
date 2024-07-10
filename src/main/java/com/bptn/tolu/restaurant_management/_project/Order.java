package com.bptn.tolu.restaurant_management._project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {

	private Customer customer;
	private String orderDetails;
	private double price;
	private LocalDateTime timestamp;


	//		public Order(Customer customer, String orderDetails, double price) {
	//		this (customer, orderDetails, price, LocalDateTime.now());
	//	}

	public Order(Customer customer, String orderDetails, double price, LocalDateTime timestamp) {
		this.customer = customer;
		this.orderDetails = orderDetails;
		this.price = price;
		this.timestamp = timestamp;
		//this.ordertime = LocalDateTime.now()
	}


	public Customer getCustomerName() {
		return customer;
	}

	public String getOrderDetails() {
		return orderDetails;
	}

	public double getPrice() {
		return price;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return timestamp.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + customer.getName() + customer.getPhoneNumber()
		+ orderDetails + String.format("%.2f", price) ;	

	}
}
