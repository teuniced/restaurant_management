package com.bptn.tolu.restaurant_management._project;

//importing  scanner util
import  java.util.Scanner;


public class ManagementMain {
	
	private Scanner scanner;
	
		//scanner input for user
	public ManagementMain() {
		scanner = new Scanner(System.in);
	}
	
	//Main run() method
	public void run() {
		System.out.println("Welcome!");

	}
	
	
	public static void main(String[] args) {
		ManagementMain app = new ManagementMain();
		
		app.run();

	}

}
