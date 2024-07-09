package com.bptn.tolu.restaurant_management._project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManager {
	
	// tutorials point ANSI color
	String reset = "\u001B[0m";
	String red_text = "\u001B[31m"; 
    String green_text = "\u001B[32m";
	private List<Customer> customers;
	
	public CustomerManager() {
		customers = new ArrayList<>();
	}
	
	public void manageCustomers(Scanner scanner) {
		int userchoice;
		do {
			System.out.println(green_text + "..........Customer Management..........");
			System.out.println("1) Add a New Customer");
			System.out.println("2) View All Customers");
			System.out.println("3) Return to Main Menu");
			System.out.println("4) Enter your choice");
			System.out.println(green_text + "5) Enter your Choice: " + reset + "\n");
			
			userchoice = scanner.nextInt();
			scanner.nextLine();
			
			switch (userchoice) {
			case 1:
				System.out.println("Add a New Customer");
				addNewCustomer(scanner);
				break;

			case 2:
				System.out.println("View All Customers");
				viewAllCustomer();
				break;

			case 3:
				System.out.println("Returning to Main Menu");
				break;	
				
			default:
				System.out.println(red_text + "Kindly select a valid choice!" + reset);		
		}
	} while (userchoice != 3);
}	
		
		private void addNewCustomer(Scanner scanner) {
			System.out.print("Enter customer name: ");
			String name = scanner.nextLine();
			System.out.print("Enter customer phone number: ");
			String phoneNumber = scanner.nextLine();
			
			Customer newCustomer = new Customer(name, phoneNumber);
			customers.add(newCustomer);
			System.out.println("Customer has been added successfully!!");
		}
		
	
		private void viewAllCustomer() {
			if (customers.isEmpty()) {
				System.out.print("There are no customers in the system yet!");
				return;
			}
			
			
			System.out.print("Enter customer name: ");
			for (int i = 0 ; i < customers.size(); i++) {
				System.out.println(i +1 + "."+ customers.get(i));
			}

		}
				
		public List<Customer>getAllCustomers(){
			return new ArrayList<>(customers);	
	}
}
