package com.bptn.tolu.restaurant_management._project;

//Import static methods from JUnit5 for assertions
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
//Importing Java nio for file operations
import java.nio.file.Files;
import java.nio.file.Path;

//Import Scanner for simulating user input, user provides input before test is asserted
import java.util.Scanner;

public class RestaurantManagementSystemTest {

	// Declaring instance variables of class types
	private ManagementMain app;
	private Menu menu;
	private CustomerManager customerManager;
	private OrderManager orderManager;
	private RecipeBook recipeBook;
	private Authentication auth;

	// The setup method to be run before each test
	@BeforeEach
	void setUp() {
		app = new ManagementMain();
		menu = new Menu();
		customerManager = new CustomerManager();
		orderManager = new OrderManager(customerManager);
		recipeBook = new RecipeBook();
		auth = new Authentication();
	}

	// Test case to ensure menu management doesn't throw exceptions
	@Test
	void testMenuManagement() {
		assertDoesNotThrow(() -> menu.manageMenu(new Scanner(System.in)));
	}

	// Test case to check if the authentication process doesn't throw exceptions
	@Test
	void testAuthentication() {
		assertDoesNotThrow(() -> auth.login(new Scanner("staff\nstaff01\n")));
	}

	// Test case to check if the recipe file exists and is not empty
	@Test
	void testRecipeFileNotEmpty() throws IOException {
		// Defining the path to the recipe file
		Path path = Path.of("recipes.txt");
		assertTrue(Files.exists(path), "Recipe file does not exist");
		assertDoesNotThrow(() -> assertTrue(Files.size(path) > 0, "Recipe file is empty"));
	}
}


