package edu.collin.cosc2436.bking.supermarketsmartshelf;

import java.util.ArrayList;

/**
 * This class represents an Employee that can place multiple items at once or
 * add one item at a time to the smart shelf.
 */
public class Employee {
	
	/**
	 * This method places a list of unsorted items on the shelf.
	 * 
	 * @param shelf The smart shelf as an IShelfEmployee reference.
	 * @param items An unsorted ArrayList of RetailItem objects.
	 */
	public void placeItems(IShelfEmployee shelf, ArrayList<RetailItem> items) {
		System.out.println("----------Employee placing on the shelf:");
		
		// Print each item in the unsorted list.
		for (RetailItem item : items) {
			System.out.println(item);
		}
		
		// Employee places the items on the shelf.
		shelf.placeItems(items);
		
		// Tweet what the employee just did.
		System.out.println("\n----------Placed on the shelf:");
		
		// Display the current items on the shelf.
		System.out.println(shelf);
	}

	/**
	 * This method places a single item on the shelf while maintaining the sorted
	 * order.(Unfortunately, it does not maintain the sorted order).
	 * 
	 * @param shelf The smart shelf as an IShelfEmployee reference.
	 * @param item  The single RetailItem to add to the shelf.
	 */
	public void addItem(IShelfEmployee shelf, RetailItem item) {
		System.out.println("----------Employee adding " + item);
		shelf.addItem(item);
	}
}
