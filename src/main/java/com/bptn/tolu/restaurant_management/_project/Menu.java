package com.bptn.tolu.restaurant_management._project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Menu {
	
	// tutorials point ANSI color
	String reset = "\u001B[0m";
	String red_text = "\u001B[31m"; 
    String green_text = "\u001B[32m";
    
    private Map<String, List<String>> weeklyMenu ;
    
    

	public Menu() {
		weeklyMenu = new HashMap<>();
	weeklyMenu.put("Sunday", List.of("Caesar Salad","Strawberry Shake","Tea", "Pop", 
			"Fruit Salad", "Spahetti Bolognese", "Fish & Chips", "Mashed Potatoes with Chicken & Creamy Dijon Sauce", "Water" , "Lemonade"));
	
	weeklyMenu.put("Monday", List.of("Eggs Benedict"," Vanilla MilkShake","Tea", "Pop", 
			"Gingerbread Pancakes", "Crispy Chicken Sandwich", "Fish & Chips", "Rad Thai","Water", "Lemonade"));
	
	weeklyMenu.put("Tuesday", List.of("Smoked Salmon Bagel Sandwich","Shake","Tea", "Pop", 
			"Cobb Salad", "Spahetti Bolognese", "BBQ Chicken Pizza ", "BBQ Side Ribs with Fries", "Water","Lemonade"));
	
	weeklyMenu.put("Wednesday", List.of("Steamed Clams","Hot Fudge Sundae","Tea", "Pop", 
			"Sweet Kale Salad", "Jollof Rice", "Apple Cider Braised Beef", "Gauacamole & Chips ","Water","Lemonade"));
	
	weeklyMenu.put("Thursday", List.of("Caesar Salad","Shake","Tea", "Pop", 
			"Curry Fried Rice", "Steamed Vegetables", "Fish & Chips", "Kali Flatbread", "Water","Lemonade"));
	
	weeklyMenu.put("Friday", List.of("Cinnamon Sugar Donuts","Chocolate Cake","Tea", "Pop", 
			"Blueberry Pancakes", "Toasted BLT", "Burrito", "Lemon Garlic Creamy Linguini","Water","Lemonade", "Sparkling Water"));
	
	weeklyMenu.put("Saturday", List.of("Apple Pie","Oreo MilkShake","Tea", "Pop", 
			"Tiramisu", "Waffles and Chicken", "Carrot Soup", "Westinghouse Burger", "Fries", "Water","Lemonade"));
}

	
	//SCANNER FOR USER INPUT
	public void manageMenu(Scanner scanner) {
		int userchoice;
		
		do {
			System.out.println(green_text + "..........Menu Management..........");
			System.out.println("1) View Full Week Menu");
			System.out.println("2) View Menu For the Current Day");
			System.out.println("3) View Special Menu");
			System.out.println("4) Return to Main Menu");
			System.out.println(green_text + "5) Enter your Choice: " + reset + "\n");
			
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
				// my logic
				break;
				
			default:
				System.out.println(red_text + "Kindly select a valid choice!" + reset);		
		}
	} while (userchoice != 4);
}	
	
	//MENU FOR THE WEEK
	private void viewFullWeekMenu() {
		weeklyMenu.forEach((day, menulist) -> System.out.println("Here's " + day + "'s Menu: " + String.join(",", menulist)+ "\n"));
		
	}
	
	//MENU FOR THE DAY check for exceptions
	private void viewMenuForDay(Scanner scanner) {
		System.out.println("Enter day of the week: ");
		String dayoftheweek = scanner.nextLine();
		List <String> dailymenu = weeklyMenu.get(dayoftheweek);
		if (dailymenu!= null){
			System.out.println(dayoftheweek + String.join(",", dailymenu) );
		}else {
			System.out.println("Invalid day entered");
		}
	}
	
	
	//SPECIAL MENU. check for exceptions
	private void filterMenuWithE() {
		List<String> dayswithE = weeklyMenu.keySet().stream()
				.filter(dayoftheweek -> dayoftheweek.toLowerCase()
				.contains("e"))
				.collect(Collectors.toList());
				
		System.out.println("Special Menu for Tuesday & Wednesday");
		dayswithE.forEach(dayoftheweek -> {
			System.out.println(dayoftheweek + String.join(",", weeklyMenu.get(dayoftheweek)));
		});
	}
}



//	public static void main(String[] args) { //i didnt need a main..find out why and how that worked
//	}