package com.bptn.tolu.restaurant_management._project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {

	private Customer customer;
	private String orderDetails;
	private double price;
	private LocalDateTime timestamp;


	public Order(Customer customer, String orderDetails, double price, LocalDateTime timestamp) {
		this.customer = customer;
		this.orderDetails = orderDetails;
		this.price = price;
		this.timestamp = timestamp;
		//this.ordertime = LocalDateTime.now()
	}

	// Getter methods
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


	 //The String representation of the Order object
	@Override
	public String toString() {
		return timestamp.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + customer.getName() + customer.getPhoneNumber()
		+ orderDetails + String.format("%.2f", price) ;

	}
}

//OrderManager Class:
//Purpose: Manages collection of orders and order operations
//Fields: menu, customerManager, orders list, file path for orders
//Key methods:
//- manageOrders: User interface for order management
//- enterANewOrder: Creates and saves new orders
//- saveOrderToFile, loadOrdersFromFile: File I/O operations
//- viewAllOrders: Displays all orders
//OOP: Encapsulation
//SOLID: Single Responsibility (focuses on order management)
//- Use of Java 8+ features (LocalDateTime, functional interfaces)
//- Error handling for file operations