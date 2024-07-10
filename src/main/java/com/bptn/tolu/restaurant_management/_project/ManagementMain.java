package com.bptn.tolu.restaurant_management._project;

//importing  scanner util
import java.util.Scanner;

public class ManagementMain {

	private Scanner scanner;
	private Menu menu;
	private CustomerManager customerManager;
	private OrderManager orderManager;
	private RecipeBook recipeBook;
	private  Authentication auth;

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
		customerManager = new CustomerManager();
		orderManager = new OrderManager(customerManager);
		recipeBook = new RecipeBook();
		auth = new Authentication();

	}

	// Main run() method
	public void run() {
		System.out.println(green_text + "Restaurant Manageement System!" + reset);

		int userchoice = 0 ;
		do {
			if (auth.getCurrentUser() == null) {
				if (!auth.login(scanner)) {
					continue;
				}
			}
			displayMainMenu();
			userchoice = getUserChoice();
			manageUserChoice(userchoice);
		} while (userchoice != 6  || userchoice != 7 );

		scanner.next();
		scanner.close();
	}

	private void displayMainMenu() {
		System.out.println(green_text + "..........Main Menu..........");
		System.out.println("1) Manage Menu");
		System.out.println("2) Process Orders");
		System.out.println("3) Manage Customers");
		System.out.println("4) Manage Recipe Book");
		System.out.println("5) View All Data");
		System.out.println("6) logout");
		System.out.println(green_text + "7) Exit" + reset);
	}

	private int getUserChoice() {
		System.out.print("Enter your choice: \n");
		while (!scanner.hasNextInt()) {
			System.out.println(red_text + "Kindly select a valid choice! \n" + reset);
			scanner.next();
		}
		return scanner.nextInt();
		//int userchoice = scanner.nextInt();
		//		scanner.nextLine();
		//		return userchoice;
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
			System.out.println("Sign in then search for Recipes!");
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
			System.out.println("Ready to logout?");
			auth.logout();
			break;

		case 7:
			System.out.println("Exiting, Comeback again!");
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
		ManagementMain app = new ManagementMain();
		app.run();
	}
}
