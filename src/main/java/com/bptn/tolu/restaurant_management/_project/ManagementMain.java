package com.bptn.tolu.restaurant_management._project;

//importing  scanner util
import  java.util.Scanner;


public class ManagementMain {

	private Scanner scanner;
	int userchoice;

	//scanner input for user
	public ManagementMain() {
		scanner = new Scanner(System.in);
	}

	//Main run() method
	public void run() {
		System.out.println("Welcome!");

		do {
			displayMainMenu();
			userchoice = getUserChoice();
			manageUserChoice(userchoice);
		} while (userchoice != 7);
			
		scanner.close();
		
	}
		
		private void displayMainMenu() {
			System.out.println("..........Main Menu..........");
			System.out.println("1) Manage Menu");
			System.out.println("2) Process Orders");
			System.out.println("3) Manage Customers");
			System.out.println("4) Manage Inventory");
			System.out.println("5) Manage Billing");
			System.out.println("6) Manage Recipe Book");
			System.out.println("7) Exit");
		}
	
		private int getUserChoice() {
			System.out.print("Enter your choice: ");
			while (!scanner.hasNextInt()) {
				System.out.println("Kindly select a valid choice!");
				scanner.next();
			}
			return scanner.nextInt();
		}
	
		private void manageUserChoice(int userchoice) {
			switch(userchoice) {
			case 1:
				System.out.println("Search Menu");
				//my logic
				break;
							
			case 2:
				System.out.println("Search Orders");
				//my logic
				break;
				
				
			case 3:
				System.out.println("Search Customers");
				//my logic
				break;
				
			case 4:
				System.out.println("Search Inventory");
				//my logic
				break;
				
			case 5:
				System.out.println("Processing Billing");
				//my logic
				break;
				
			case 6:
				System.out.println("Search for Recipes");
				//my logic
				break;
				
			case 7:
				System.out.println("Exiting, Comeback again!");
				//my logic
				break;
			default:
				System.out.println("Kindly select a valid choice!");
			
			}
		}

	public static void main(String[] args) {
		ManagementMain app = new ManagementMain();
		app.run();
	}
}
