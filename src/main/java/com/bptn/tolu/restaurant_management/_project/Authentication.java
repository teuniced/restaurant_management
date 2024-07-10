package com.bptn.tolu.restaurant_management._project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Authentication {

	private Map<String, User> users;
	
	private User currentuser;
	
	
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
		if (user != null && user.checkPassword(password)) {
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
