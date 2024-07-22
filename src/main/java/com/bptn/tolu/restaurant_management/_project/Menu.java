package com.bptn.tolu.restaurant_management._project;

//importing the necessary utils
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {

	//ANSI color codes for console output
	String reset = "\u001B[0m";
	String red_text = "\u001B[31m";
    String green_text = "\u001B[32m";

    //Map to store the entire menu in a string and list interface
    private Map<String, List<String>> entireMenu ;


    //Constructor initializes the entireMenu variable
	public Menu() {

		//Listof is an interface and the reason this was used to make the menu fixed and not mutable
		entireMenu = new HashMap<>();
	entireMenu.put("Sunday", List.of("Caesar Salad","Strawberry Shake","Tea", "Pop",
			"Fruit Salad", "Spahetti Bolognese", "Fish & Chips", "Mashed Potatoes with Chicken & Creamy Dijon Sauce", "Water" , "Lemonade"));

	entireMenu.put("Monday", List.of("Eggs Benedict"," Vanilla MilkShake","Tea", "Pop",
			"Gingerbread Pancakes", "Crispy Chicken Sandwich", "Fish & Chips", "Rad Thai","Water", "Lemonade"));

	entireMenu.put("Tuesday", List.of("Smoked Salmon Bagel Sandwich","Shake","Tea", "Pop",
			"Cobb Salad", "Spahetti Bolognese", "BBQ Chicken Pizza ", "BBQ Side Ribs with Fries", "Water","Lemonade"));

	entireMenu.put("Wednesday", List.of("Steamed Clams","Hot Fudge Sundae","Tea", "Pop",
			"Sweet Kale Salad", "Jollof Rice", "Apple Cider Braised Beef", "Gauacamole & Chips ","Water","Lemonade"));

	entireMenu.put("Thursday", List.of("Caesar Salad","Shake","Tea", "Pop",
			"Curry Fried Rice", "Steamed Vegetables", "Fish & Chips", "Kali Flatbread", "Water","Lemonade"));

	entireMenu.put("Friday", List.of("Cinnamon Sugar Donuts","Chocolate Cake","Tea", "Pop",
			"Blueberry Pancakes", "Toasted BLT", "Burrito", "Lemon Garlic Creamy Linguini","Water","Lemonade", "Sparkling Water"));

	entireMenu.put("Saturday", List.of("Apple Pie","Oreo MilkShake","Tea", "Pop",
			"Tiramisu", "Waffles and Chicken", "Carrot Soup", "Westinghouse Burger", "Fries", "Water","Lemonade"));
}

	//Main method for user interaction and menu operations
	public void manageMenu(Scanner scanner) {
		int userchoice;

		do {
			System.out.println(green_text + "..........Menu Management..........");
			System.out.println("1) View Full Week Menu");
			System.out.println("2) View Menu For the Current Day");
			System.out.println("3) View Special Menu");
			System.out.println("4) Return to Main Menu");
			System.out.println(green_text + "5) Enter your Choice: " + reset + "\n");

			try {
				userchoice = scanner.nextInt();
				scanner.nextLine();

			switch (userchoice) {
			case 1:
				System.out.println("View Full Week Menu");
				viewFullWeekMenu();
				break;

			case 2:
				System.out.println("View Menu For the Current Day");
				viewMenuForDay(scanner);
				break;

			case 3:
				System.out.println("View Special Menu");
				filterMenuWithE();
				break;

			case 4:
				System.out.println("Returning to Main Menu");
				return;

			default:
				System.out.println(red_text + "Kindly select a valid choice!" + reset);
		}
	} catch (InputMismatchException e) {
		System.out.println(red_text + "Kindly select a valid choice!" + reset);
		scanner.nextLine();
		userchoice = 0;
		}
	}while (userchoice != 4);

}

	//Method for viewing the menu for the week
	private void viewFullWeekMenu() {
		entireMenu.forEach((day, menulist) -> System.out.println("Here's " + day + "'s Menu: " + String.join(",", menulist)+ "\n"));

	}

	//Method for viewing the menu for a day
	private void viewMenuForDay(Scanner scanner) {
		System.out.println("Enter day of the week in sentence case: ");
		String dayoftheweek = scanner.nextLine();
		List <String> dailymenu = entireMenu.get(dayoftheweek);
		if (dailymenu!= null){
			System.out.println(dayoftheweek + ": " + String.join(",", dailymenu) );
		}else {
			System.out.println("I'm sorry, that is an invalid entry");
		}
	}


	//Method for filtering the menu
	private void filterMenuWithE() {
		List<String> dayswithE = entireMenu.keySet().stream()
				.filter(dayoftheweek -> dayoftheweek.toLowerCase()
				.contains("e"))
				.collect(Collectors.toList());

		System.out.println("Special Menu for Tuesday & Wednesday");
		dayswithE.forEach(dayoftheweek -> {
			System.out.println(dayoftheweek + ": " + String.join(",", entireMenu.get(dayoftheweek)));
		});
	}

}





//Notes & References
//This code imports several java utils(Hashmap, list, map,scanner,)
//I have instance var of the ansi color code for the console output(Tutorials points)
//Instance var entireMenu use String as keys and a list as values
//There is no public static void main (String [] args) because menu is instantiated
//	and used in other parts of my program
//I have made the entire map private and its interactions demonstrating encapsulation.
//Functional programming & error handling: Menu has 3 methods (which either uses lambda exp.
//	streams, and error handling checking for null values).
//The use of flow control to provide an efficient way to manage user input,
//	making the program and user interface more organized.
//Coding rooms material on scanner, hashmaps, lambda expressions.





