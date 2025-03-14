package edu.collin.cosc2436.bking.supermarketsmartshelf;

/**
 * This class represents a Customer that can request an item from a shelf.
 */
public class Customer {
	/**
	 * This method takes two arguments: the shelf (as an interface reference) and a
	 * name for the desired item. It then takes the item from the shelf. If that
	 * item is not found on the shelf, an OutOfStockException is thrown.
	 * 
	 * @param shelf    The smart shelf as an IShelfCustomer reference.
	 * @param itemName The name of the item the customer wants.
	 */

	// The parameter represents the smart shelf but is passed as an object that
	// implements the IShelfCustomer interface
	public void getItem(IShelfCustomer shelf, String itemName) {
		System.out.println("----------Customer getting " + itemName);
		try {
			RetailItem item = shelf.findAndTake(itemName);
			System.out.println("----------Got " + item.getName());
		} catch (OutOfStockException e) {
			System.out.println(e);
		}
	}
}
