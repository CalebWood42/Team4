package edu.collin.cosc2436.bking.supermarketsmartshelf;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This demo class tests the functionality of the SmartShelf, Employee, and
 * Customer classes.
 * 
 * @author Brendan King, Tayanna Moore, Caleb Woodman
 */
public class SmartShelfDemo {

	public static void main(String[] args) {

		// Create an unsorted ArrayList of RetailItem objects by reading cereal names
		// from the resource file.
		ArrayList<RetailItem> cerealItems = new ArrayList<>();
		Scanner scanner = new Scanner(SmartShelfDemo.class.getResourceAsStream("/cereal.txt"));
		while (scanner.hasNext()) {
			cerealItems.add(new RetailItem(scanner.nextLine()));
		}
		scanner.close();

		// Instantiate a SmartShelf, Employee, and Customer
		SmartShelf shelf = new SmartShelf("Cereal");
		Employee employee = new Employee();
		Customer customer = new Customer();

		System.out.println("––––––––––Employee placing on the shelf:");

		// Print each item in the unsorted list.
		for (RetailItem item : cerealItems) {
			System.out.println(item.getName());
		}

		// Employee places the items on the shelf.
		shelf.placeItems(cerealItems);

		System.out.println("\n––––––––––Placed on the shelf:");

		System.out.println(shelf);

		// Customer tries to get some items.
		System.out.println("----------Customer getting Apple Jacks");
		try {
			RetailItem item = customer.getItem(shelf, "Apple Jacks");
			System.out.println("----------Got " + item.getName());
		} catch (OutOfStockException e) {
			System.out.println(e);
		}

		System.out.println("----------Customer getting Cinnamon Toast Crunch");
		try {
			RetailItem item = customer.getItem(shelf, "Cinnamon Toast Crunch");
			System.out.println("----------Got " + item.getName());
		} catch (OutOfStockException e) {
			System.out.println(e);
		}

		System.out.println("----------Customer getting Cinnamon Toast Crunch");
		try {
			RetailItem item = customer.getItem(shelf, "Cinnamon Toast Crunch");
			System.out.println("----------Got " + item.getName());
		} catch (OutOfStockException e) {
			System.out.println(e);
		}

		// Print what is on the shelf now.
		System.out.println(shelf);

		// Employee adds single items to the smart shelf.
		System.out.println("----------Employee adding Cinnamon Toast Crunch");
		employee.addItem(shelf, new RetailItem("Cinnamon Toast Crunch"));

		System.out.println("----------Employee adding Lucky Charms");
		employee.addItem(shelf, new RetailItem("Lucky Charms"));
		System.out.println(shelf);

	}
}
