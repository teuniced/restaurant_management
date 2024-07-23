package com.bptn.tolu.restaurant_management._project;

//importing  scanner util
import java.util.Scanner;

public class ManagementMain {


	//Instance variables with references to other class objects
	private Scanner scanner;
	private Menu menu;
	private CustomerManager customerManager;
	private OrderManager orderManager;
	private RecipeBook recipeBook;
	private  Authentication auth;

	//ANSI color codes for console output
	String reset = "\u001B[0m";
	String red_text = "\u001B[31m";
	String green_text = "\u001B[32m";
	String yellow_text = "\u001B[33m";


	//Constructor initializes the entire program and its components
	public ManagementMain() {
	  this.scanner = new Scanner(System.in);
		this.menu = new Menu();
		this.customerManager = new CustomerManager();
		this.orderManager = new OrderManager(customerManager);
		this.recipeBook = new RecipeBook();
		this.auth = new Authentication();

	}

	// Main run() method
	public void run() {
		System.out.println(green_text + "Restaurant Management System!" + reset);

		int userchoice = 0 ;
		do{
			if (auth.getCurrentUser() == null) {
				if (!auth.login(scanner)) {
					continue;
				}
			}
			displayMainMenu();
			userchoice = getUserChoice();
			manageUserChoice(userchoice);
		} while (userchoice != 6 );
		scanner.close();
	}

	private void displayMainMenu() {
		System.out.println(green_text + "..........Main Menu..........");
		System.out.println("1) Manage Menu");
		System.out.println("2) Process Orders");
		System.out.println("3) Manage Customers");
		System.out.println("4) Manage Recipe Book");
		System.out.println("5) View All Data");
		System.out.println(red_text + "6) logout" + reset);

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
			orderManager.manageOrders(scanner);
			break;

		case 3:
			System.out.println("Search Customers");
			customerManager.manageCustomers(scanner);
			break;

		case 4:
			if (auth.getCurrentUser().hasRecipeAccess()){
				recipeBook.viewRecipes(auth.getCurrentUser());
			} else {
				System.out.println("I'm sorry but you are not authorized to view the recipes");
			}
			break;

		case 5:
			System.out.println("View All Data");
			viewAllData();
			break;

		case 6:
			auth.logout();
			break;
		default:
			System.out.println(red_text + "Kindly select a valid choice! \n " + reset);

		}
	}


	private void viewAllData() {
		System.out.println(".........ALL RESTAURANT DATA..........");
		customerManager.viewAllCustomers();
		orderManager.viewAllOrders();

	}



	public static void main(String[] args) {
		try {
	        ManagementMain app = new ManagementMain();
	        app.run();
	    } catch (Exception e) {
	        System.err.println("An error occurred: " + e.getMessage());
	    }
	}

}





//Notes & References
//Purpose: Central control for the restaurant management system
//Its components:
//- Scanner for user input
//- Instances of Menu, CustomerManager, OrderManager, RecipeBook, Authentication
//ANSI color codes for console formatting
//Methods:
//- Constructor: Initializes all system components
//- run(): Main loop for program execution
//- displayMainMenu(): Shows main menu options
//- getUserChoice(): Handles user input for menu selection
//- manageUserChoice(): Directs program flow based on user selection
//- viewAllData(): Displays all customer and order data
//- main(): Entry point, creates and runs ManagementMain instance
//OOP Concepts-Encapsulation, SRP


















