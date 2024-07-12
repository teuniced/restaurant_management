package com.bptn.tolu.restaurant_management._project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;



public class OrderManager {

	//ANSI color codes for console output
	String reset = "\u001B[0m";
	String red_text = "\u001B[31m"; 
	String green_text = "\u001B[32m";


	private Menu menu;
	private CustomerManager customerManager;
	private List<Order> orders;
	private String OrdersFilePath = "cxorders.txt";


	//Constructor to initialize all fields
	public OrderManager(CustomerManager customerManager) {
		this.orders = new ArrayList<>();
		this.customerManager = customerManager;
		loadOrdersFromFile();
	}


	//Main method for user interaction and orders operations
	public void manageOrders(Scanner scanner) {
		int userchoice;

		do {
			System.out.println(green_text + "..........Order Management..........");
			System.out.println("1) Enter a new order");
			System.out.println("2) View all orders");
			System.out.println("3) Return to main menu");
			System.out.println(green_text + "Enter your Choice: " + reset + "\n");

			userchoice = scanner.nextInt();
			scanner.nextLine();

			switch (userchoice) {
			case 1:
				System.out.println("Add a New Order");
				enterANewOrder(scanner);
				break;

			case 2:
				System.out.println("View All Order");
				viewAllOrders();
				break;
			case 3:
				System.out.println("Returning to Main Menu");
				break;

			default:
				System.out.println(red_text + "Kindly select a valid choice!" + reset);		
			}
		} while (userchoice != 3);
	}	

	//Method for starting a new order
	private void enterANewOrder(Scanner scanner) {
		Customer customer;

		System.out.println("Is this for an existing customer? (y/n): ");
		if (scanner.nextLine().toLowerCase().startsWith("y")) {
			System.out.print("Enter customer number: ");
			String PhoneNumber = scanner.nextLine();
			scanner.nextLine(); // Consume newline
			customer = customerManager.getCustomerFromCustomers(PhoneNumber);
			if (customer == null) {
				System.out.println("Invalid customer number. Creating new customer.");
				customer = customerManager.addNewCustomer(scanner);
			} else {
				System.out.println("Customer found:" + customer.getName());
			}
		} else {
			customer = customerManager.addNewCustomer(scanner);
		}

		System.out.print("Enter order details: ");
		String orderDetails = scanner.nextLine();

		System.out.print("Enter order price: $");
		double price = scanner.nextDouble();
		scanner.nextLine(); // Consume newline

		Order order = new Order(customer, orderDetails, price, LocalDateTime.now());
		orders.add(order);
		saveOrderToFile(order);

		System.out.println("Order added successfully!");
	}

	
	//Method for saving a new order
	private void saveOrderToFile(Order order) {
	    String orderFormat = "%s|%s|%s|%s|%.2f%n";
	    try (PrintWriter out = new PrintWriter(new FileWriter(OrdersFilePath, true))) {
	        out.printf(orderFormat,
	            order.getTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
	            order.getCustomerName().getName(),
	            order.getCustomerName().getPhoneNumber(),
	            order.getOrderDetails(),
	            order.getPrice());
	    } catch (IOException e) {
	        System.out.println("Error saving order to file: " + e.getMessage());
	    }
	}
	
	//Method for loading the orders from the file  
	private void loadOrdersFromFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader(OrdersFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("\\|");
				if (parts.length == 5) {
					LocalDateTime timestamp = LocalDateTime.parse(parts[0].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
					Customer customer = new Customer(parts[1].trim(), parts[2].trim());
					String orderDetails = parts[3].trim();
					double price = Double.parseDouble(parts[4].trim().substring(1)); // to remove the  $ dollar '$' sign
					orders.add(new Order(customer, orderDetails, price, timestamp));
				}
			}
		} catch (IOException e) {
			System.out.println("We encountered an error while loading orders from file: " + e.getMessage());
		}
	}
	

	public void viewAllOrders() {
		if (orders.isEmpty()) {
			System.out.println("There are no orders to display.");
		} else {
			System.out.println("\n========== All Orders ==========");
			System.out.printf("%-25s %-20s %-15s %-30s %s%n", 
					"Date & Time", "Customer Name", "Phone Number", "Order Details", "Price");
			System.out.println("--------------------------------------------------------------------------------------------------------");

			for (Order order : orders) {
				System.out.printf("%-25s %-20s %-15s %-30s $%.2f%n",
						order.getTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
						order.getCustomerName().getName(),
						order.getCustomerName().getPhoneNumber(),
						order.getOrderDetails(),
						order.getPrice());
			}
			System.out.println("---------------------------------------------------------------------------------------------------------");
		}
	}
}


//Notes & References for Order and OrderManager classes
//Order Class:
//Purpose: Represents individual customer orders
//Fields: customer, orderDetails, price, timestamp
//Constructor: Initializes all fields
//Methods: Getters for all fields, toString() for formatted output
//OOP: Encapsulation
//SOLID: Single Responsibility Principle



