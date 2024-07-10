package com.bptn.tolu.restaurant_management._project;

public class User {

	private String username;
	private String password; //thought about using id
	private boolean recipeAccess;
	
	
	public User(String username, String password, boolean recipeAccess) {
		this.username = username;
		this.password = password;
		this.recipeAccess = recipeAccess;
	}


	public String getUsername() {
		return username; //everyone gets username "staff"
	}


	public boolean checkPassword(String userPassword) {
		return password.contains(userPassword);
	}

	
	public boolean hasRecipeAccess() {
		return recipeAccess;
	}


}
