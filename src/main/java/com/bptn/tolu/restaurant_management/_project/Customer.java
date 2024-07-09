package com.bptn.tolu.restaurant_management._project;

public class Customer {
	
	
	//still need to store all this information in a txt file
	private String name;
	private String phoneNumber;
	
	
	public Customer(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}


	public String getName() {
		return name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	@Override
	public String toString() {
		return "Customer [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

	
}
