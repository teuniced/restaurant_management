package com.bptn.tolu.restaurant_management._project;

//importing  scanner util

import java.util.Scanner;

public class ManagementMain {

	private Scanner scanner;
	private Menu menu;
	// tutorials point ANSI color
	String reset = "\u001B[0m";
	String red_text = "\u001B[31m"; 
    String green_text = "\u001B[32m";
    String yellow_text = "\u001B[33m";
	String blue_bg = "\u001B[44m";
	String cyan_bg = "\u001B[46m";
	String black_bg = " \u001B[40m";
	String red_bg = "\u001B[41m";
	String white_bg = "\u001B[47m";
	String green_bg = "\u001B[42m";
	String yellow_bg = "\u001B[43m";
	String magenta_bg = "\u001B[45m";

	// scanner input for user
	public ManagementMain() {
		scanner = new Scanner(System.in);
		menu = new Menu();
	}

	// Main run() method
	public void run() {
		System.out.println(green_text + "Welcome!" + reset);
		int userchoice;

		do {
			displayMainMenu();
			userchoice = getUserChoice();
			manageUserChoice(userchoice);
		} while (userchoice != 7);

		scanner.next();
		scanner.close();
	}

	private void displayMainMenu() {
		System.out.println(green_text + "..........Main Menu..........");
		System.out.println("1) Manage Menu");
		System.out.println("2) Process Orders");
		System.out.println("3) Manage Customers");
		System.out.println("4) Manage Inventory");
		System.out.println("5) Manage Billing");
		System.out.println("6) Manage Recipe Book");
		System.out.println(green_text + "7) Exit" + reset);
	}

	private int getUserChoice() {
		System.out.print("Enter your choice: \n");
		while (!scanner.hasNextInt()) {
			System.out.println(red_text + "Kindly select a valid choice! \n" + reset);
			scanner.next();
		}
		return scanner.nextInt();
	}

	private void manageUserChoice(int userchoice) {
		switch (userchoice) {
		case 1:
			System.out.println("Search Menu");
			menu.manageMenu(scanner);
			break;

		case 2:
			System.out.println("Search Orders");
			// my logic
			break;

		case 3:
			System.out.println("Search Customers");
			// my logic
			break;

		case 4:
			System.out.println("Search Inventory");
			// my logic
			break;

		case 5:
			System.out.println("Processing Billing");
			// my logic
			break;

		case 6:
			System.out.println("Search for Recipes");
			// my logic
			break;

		case 7:
			System.out.println("Exiting, Comeback again!");
			// my logic
			break;
		default:
			System.out.println(red_text + "Kindly select a valid choice! \n " + reset);

		}
	}
	
	
	public static void main(String[] args) {
		ManagementMain app = new ManagementMain();
		app.run();
	}
}
