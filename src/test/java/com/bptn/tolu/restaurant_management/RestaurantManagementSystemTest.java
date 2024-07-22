package com.bptn.tolu.restaurant_management;

//Import static methods from JUnit5 for assertions
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
//Import Scanner for simulating user input, user provides input before test is asserted
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bptn.tolu.restaurant_management._project.Authentication;
import com.bptn.tolu.restaurant_management._project.CustomerManager;
import com.bptn.tolu.restaurant_management._project.ManagementMain;
import com.bptn.tolu.restaurant_management._project.Menu;
import com.bptn.tolu.restaurant_management._project.OrderManager;
import com.bptn.tolu.restaurant_management._project.RecipeBook;

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
}


