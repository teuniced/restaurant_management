package com.bptn.tolu.restaurant_management._project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class OrderManager {

	//ANSI color codes for console output
	String reset = "\u001B[0m";
	String red_text = "\u001B[31m";
	String green_text = "\u001B[32m";


	private Menu menu;
	private CustomerManager customerManager;
	private List<Order> orders;
	private Path ordersFilePath;


	//Constructor to initialize all fields
	public OrderManager(CustomerManager customerManager) {
		this.orders = new ArrayList<>();
		this.customerManager = customerManager;
		this.ordersFilePath = Paths.get("cxorders.txt");
		loadOrdersFromFile(ordersFilePath);
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
				return;
			default:
				System.out.println(red_text + "Kindly select a valid choice!" + reset);
			}
		} while (userchoice != 3);
	}

	
	//Custom Exception  
	public class  NegativeValueException extends Exception{
		public NegativeValueException (String errorMessage) {
			super(errorMessage);
		}
	}
	
	
	
	// Method for starting a new order
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

		double price = 0;
		boolean validprice = false;
		while (!validprice) {
			try {
				System.out.print("Enter order price: $");
				price = Double.parseDouble(scanner.nextLine());
				if (price < 0) {
					throw new NegativeValueException("Price is not valid, enter a number greater than Zero!");
				}
				validprice = true;
			} catch (NumberFormatException e) {
				System.out.println(red_text + "Kindly enter a valid number! \n" + e.getMessage() + reset);
			} catch (NegativeValueException e) {
				System.out.println(red_text + "Kindly enter a valid number! \n" + e.getMessage() + reset);
			}
		}

		Order order = new Order(customer, orderDetails, price, LocalDateTime.now());
		orders.add(order);
		saveOrderToFile(order, ordersFilePath);

		System.out.println("Order added successfully!");
	}


	//Method for saving a new order
	private void saveOrderToFile(Order order, Path path) {

	    try {
	    	if(!Files.exists(path)) {
	    		Files.createFile(path);
	    	}
	    	String orderFormat = "%s|%s|%s|%.2f|%s%n";
	    	 String orderString = String.format(orderFormat,
	    			 order.getCustomerName().getName(),
	    			 order.getCustomerName().getPhoneNumber(),
	    			 order.getOrderDetails(),
	    			 order.getPrice(),
	    			 order.getTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
				FileWriter writer = new FileWriter(new File(path.toUri()), true);
				writer.write(orderString);
				writer.close();
				System.out.println("Order has been successfuly saved to file.");
	    } catch (Exception e) {
	        System.out.println("Error saving order to file: " + e.getMessage());
	    }
	}





	//Method for loading the orders from the file
	private void loadOrdersFromFile(Path path) {
		 try {
		    	if(!Files.exists(ordersFilePath)) {
		    		Files.createFile(ordersFilePath);
		    		return;
		    	}

		 try (Scanner scanner = new Scanner(new File(path.toUri()))) {
				while (scanner.hasNextLine()) {
//					String data = scanner.nextLine();
//					System.out.println("Orders available in file: " + data);
				}

		} catch (Exception e) {
			System.out.println("We encountered an error while loading orders from file: " + e.getMessage());
		}
	} catch(IOException e) {
		System.out.println("We encountered an error while creating/loading the file: " + e.getMessage());
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



