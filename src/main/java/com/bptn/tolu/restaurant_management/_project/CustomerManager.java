package com.bptn.tolu.restaurant_management._project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CustomerManager {

	//ANSI color codes for console output
	String reset = "\u001B[0m";
	String red_text = "\u001B[31m"; 
	String green_text = "\u001B[32m";

	private Map<String, Customer> customers;
	private String CXFilePath = "cxlist.txt";


	public CustomerManager() {
		customers = new HashMap<>(); //Was an array list before but distinct cx features were needed for cx management
		loadCustomersFromFile();
	}



	public void manageCustomers(Scanner scanner) {
		int userchoice;
		do {
			System.out.println(green_text + "..........Customer Management..........");
			System.out.println("1) Add a New Customer");
			System.out.println("2) View All Customers");
			System.out.println("3) Return to Main Menu");
			System.out.println(green_text + "4) Enter your Choice: " + reset + "\n");

			userchoice = scanner.nextInt();
			scanner.nextLine();

			switch (userchoice) {
			case 1:
				System.out.println("Add a New Customer");
				addNewCustomer(scanner);
				break;

			case 2:
				System.out.println("View All Customers");
				viewAllCustomers();
				break;

			case 3:
				System.out.println("Returning to Main Menu");
				break;	

			default:
				System.out.println(red_text + "Kindly select a valid choice!" + reset);		
			}
		} while (userchoice != 3);
	}	


	//Creating a new customer here using the Customer instance mapping cx to phone number
	public Customer addNewCustomer(Scanner scanner) {
		System.out.print("Enter customer name: ");
		String name = scanner.nextLine();
		System.out.print("Enter customer phone number: ");
		String phoneNumber = scanner.nextLine();
		Customer newCustomer = new Customer(name, phoneNumber);
		customers.put(phoneNumber, newCustomer);
		saveCustomerToFile(newCustomer);
		System.out.println("Customer has been added successfully!!");
		return newCustomer;
	}

	
	//Also using this method to search for customers when an order is created
	public Customer getCustomerFromCustomers(String phoneNumber) {
		return customers.get(phoneNumber);
	}


	//Iterating over the customer instances
	public void viewAllCustomers() {
		if (customers.isEmpty()) {
			System.out.print("There are no customers in the system yet! ");
			return;
		}
		System.out.println(".....All Customers.....");
		for (Customer customer : customers.values()) {
			System.out.println(customer);
		}
	}

	//Customer instances are serialized/deserialized for file storage in the methods below
	private void loadCustomersFromFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader(CXFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("\\|");
				if (parts.length == 2) {
					Customer customer = new Customer(parts[0].trim(), parts[1].trim());
					customers.put(customer.getPhoneNumber() , customer);
				}
			}
		} catch (IOException e) {
			System.out.println("We encountered an error while loading customers from file: " + e.getMessage());
		}
	}

	private void saveCustomerToFile(Customer customer) {
		try (PrintWriter out = new PrintWriter(new FileWriter(CXFilePath, true))) {
			out.println(customer.getName() + ": "+ customer.getPhoneNumber());
		} catch (IOException e) {
			System.out.println("We encountered an error while saving customer to file: " + e.getMessage());
		}
	}


}




//Notes & References
// Methods:
//  - manageCustomers: User interface for customer management (add, view, exit)
//  - addNewCustomer: Creates new Customer instance, adds to Map, saves to file
//  - getCustomerFromCustomers: Retrieves customer by phone number (used in order creation)
//- viewAllCustomers: Displays all customers, uses Map.isEmpty() and values() methods
//- loadCustomersFromFile: Reads customer data from file, creates Customer instances
//- saveCustomerToFile: Writes new customer data to file.
//Error Handling: Try-catch blocks for file operations
//SRP principle
//Encapsulation oop concept
//References: Coding rooms, stackoverflow, Digital ocean, Java documentation on HashMap, Map interfaces, and Scanner class







