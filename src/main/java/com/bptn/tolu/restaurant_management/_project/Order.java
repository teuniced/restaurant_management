package com.bptn.tolu.restaurant_management._project;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private Customer customer;
	private List<String> items;
	
	
	public 	Order(Customer customer) {
		this.customer = customer;
		this.items = new ArrayList<>();
	}

	public void addItem(String item) {
		items.add(item);
	}
	
	public Customer getCustomer() {
		return customer;
	}

	@Override
	public String toString() {
		return "Order [customer=" + customer + ", items=" + items + "]";
	}
	
	
	
}
