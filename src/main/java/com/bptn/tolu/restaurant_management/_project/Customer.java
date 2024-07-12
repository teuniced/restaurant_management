package com.bptn.tolu.restaurant_management._project;

public class Customer {
	
	
	//Storing all this information in a txt file
	private String name;
	private String phoneNumber;
	
	
	public Customer(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	// Getter methods
	public String getName() {
		return name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	 //The String representation of customer detail
	@Override
	public String toString() {
		return "Customer [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

	
}

//Notes & References
//Simple class representing a customer with name and phone number
//Private fields for encapsulation: name, phoneNumber
//Constructor initializes both fields
//Getter methods for name and phoneNumber, no setters (immutable after creation)
//Overridden toString() method for easy printing/debugging
//No file I/O implemented yet (noted in comment for future addition)
//Designed for use in larger system  CustomerManager, not used as an extension but as an instance
//References: Coding rooms java basics on class creation, encapsulation, and toString() override