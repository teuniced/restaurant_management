package com.bptn.tolu.restaurant_management._project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecipeBook {
	private List<String> recipes;
	private static final String recipe_file = "recipes.txt";

	public RecipeBook() {
		recipes = new ArrayList<>();
		loadRecipes();
	}

	private void loadRecipes() {

		try (BufferedReader reader = new BufferedReader(new FileReader(recipe_file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				recipes.add(line);
			}
		} catch (IOException e) {
			System.out.println("We encountered an error while loading customers from file: " + e.getMessage());
		}
	}

	public void viewRecipes(User user) {
		if (user.hasRecipeAccess()) {
			System.out.println("Please find the restuarant's recipes below:");
			for (int i = 0; i < recipes.size(); i ++) {
				System.out.println( (i + 1) + ". " + recipes.get(i));
			}

		} else {
			System.out.println("I'm sorry but you are not authorized to view the recipes");
		}
	}

}
