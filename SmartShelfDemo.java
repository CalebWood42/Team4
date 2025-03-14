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

		// An employee places items on the shelf.
		employee.placeItems(shelf, cerealItems);

		// Customer tries to get some items.
		customer.getItem(shelf, "Apple Jacks");
		customer.getItem(shelf, "Cinnamon Toast Crunch");
		customer.getItem(shelf, "Cinnamon Toast Crunch");

		// Print what is on the shelf now.
		System.out.println(shelf);

		// Employee adds items, one at a time, to the smart shelf.
		employee.addItem(shelf, new RetailItem("Cinnamon Toast Crunch"));
		employee.addItem(shelf, new RetailItem("Lucky Charms"));

		// Print what is on the shelf now.
		System.out.println(shelf);

	}
}
