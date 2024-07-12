package com.bptn.tolu.restaurant_management._project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Authentication {

	private Map<String, User> users;
	
	private User currentuser;
	
	//This constructor initializes this Map field with a specific implementation (HashMap).
	public Authentication() {
		users = new HashMap<>();
		
		users.put("headchef", new User("headchef", "North01", true));
		users.put("souschef", new User("souschef", "South02", true));
		users.put("staff", new User("staff", "staff01", false));
		
	}
	
	public boolean login(Scanner scanner) {
		System.out.print("Please enter your username:");
		String username = scanner.nextLine();
		System.out.print("Please enter your password: " );
		String password = scanner.nextLine();

		User user = users.get(username);
		if (user != null && user.checkPassword(password)) { //checks if the login was successful
			currentuser = user;
			System.out.println("Welcome,  " + username + "!" );
			return true;
			
		}else {
			System.out.println("We're sorry but that's not a valid username or password. Please try again.");
			return false;
		}	
	}
	
	public User getCurrentUser() {
		return currentuser;
	}
	
	
	public void logout() {
		currentuser = null;
		System.out.println("Logged out successfully! Come back again!");
	}
		
}

// Notes & References
// Imports Java utils: HashMap, Map, Scanner
// Instance variables: users (Map for storing User objects, , currentuser (tracks logged-in user)
// I made the variables a class field so I can use other implementations of the map interface in the event that I have more methods in the class)
// No main method - class designed to be used by other parts of the program
// Encapsulation demonstrated through private fields and public methods
// User management: Stores predefined users with different privileges, 	I hardcoded the password but usually not a good practice.
// Login method: Handles user authentication, updates currentuser
// Error handling for invalid login attempts
// Solid principles SRP: This class focuses solely on authentication functionality
// References: Coding rooms, Java documentation on HashMap, Map interfaces, and Scanner class
