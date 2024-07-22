package com.bptn.tolu.restaurant_management._project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RecipeBook {
	private List<String> recipes;
	private static final Path recipe_file = Paths.get(System.getProperty("user.dir"), "recipes.txt");

	public RecipeBook() {
		recipes = new ArrayList<>();
		loadRecipes();
	}

	// Load recipes method for retrieving the file
	private void loadRecipes() {
		try {
			if (!Files.exists(recipe_file)) {
				System.out.println("We encountered an error while loading recipes from file. ");
			} else {
				recipes = Files.readAllLines(recipe_file);
				System.out.println("Current recipes available in the system are: " + recipes);
			}
		} catch (IOException e) {
			System.out.println("We encountered an error while loading recipes from file: " + e.getMessage());
		}
	}

	// View recipes method (successful for staff with access control)
	public void viewRecipes(User user) {
		if (user.hasRecipeAccess()) {
			System.out.println("Please find the restaurant's recipes below:");
			for (int i = 0; i < recipes.size(); i++) {
				System.out.println((i + 1) + ". " + recipes.get(i));
			}

		} else {
			System.out.println("I'm sorry but you are not authorized to view the recipes");
		}
	}

}




















//Notes & References
//Class: RecipeBook - manages recipes for the restaurant
//Fields: List<String> recipes, static final String for recipe file path
//Constructor: Initializes ArrayList for recipes, calls loadRecipes()
//Methods:
//- loadRecipes: Private method to read recipes from file
//- viewRecipes: Public method to display recipes (with access control)
//File I/O: Uses BufferedReader util for reading recipe data
//Calling loadRecipes() method in the constructor because
// 1. Ensures recipes are loaded immediately when a RecipeBook object is created
// 2. Guarantees the recipes list is populated and ready to use.
// 3. Centralizes initialization, reducing the chance of using an unpopulated list.
//Error Handling: Try-catch block for file reading operations
//Access Control: Checks user authorization before displaying recipes
//Data Structure: ArrayList used for storing recipes
//OOP Concepts: Encapsulation (private fields, methods)
//SOLID: Single Responsibility Principle (manages recipes only)