package com.bptn.tolu.restaurant_management._project;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerManager {

	//ANSI color codes for console output
	String reset = "\u001B[0m";
	String red_text = "\u001B[31m";
	String green_text = "\u001B[32m";

	private Map<String, Customer> customers;
	private Path CXFilePath ;


	public CustomerManager() {
		customers = new HashMap<>(); //Was an array list before but distinct cx features were needed for cx management
		this.CXFilePath = Paths.get("cxorders.txt");
		loadCustomersFromFile(CXFilePath);
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
		saveCustomerToFile(newCustomer, CXFilePath);
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
	private void loadCustomersFromFile(Path path) {
		 try {
		    	if(!Files.exists(CXFilePath)) {
		    		Files.createFile(CXFilePath);
		    		return;
		    	}
		 try (Scanner scanner = new Scanner(new File(path.toUri()))) {
				while (scanner.hasNextLine()) {
					//String data = scanner.nextLine();
					//System.out.println("Current Customers available in file are: " + data);
				}

		} catch (Exception e) {
			System.out.println("We encountered an error while loading orders from file: " + e.getMessage());
		}
	} catch(IOException e) {
		System.out.println("We encountered an error while loading customers from file: " + e.getMessage());
	}
}



	private void saveCustomerToFile(Customer customer, Path path) {
	    try {
	    	if(!Files.exists(path)) {
	    		Files.createFile(path);
	    	}
	    	String customerString = customer.getName() + "|" + customer.getPhoneNumber();
				FileWriter writer = new FileWriter(new File(path.toUri()), true);
				writer.write(customerString);
				writer.close();
				System.out.println("Customer has been successfuly saved to file.");
	    } catch (Exception e) {
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







