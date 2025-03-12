package edu.collin.cosc2436.bking.supermarketsmartshelf;

/**
 * This class represents a Customer that can request an item from a shelf.
 */
public class Customer {
	/**
	 * This method takes the shelf interface and an item name, then requests the
	 * item from the shelf. If that item is not found on the shelf, an
	 * OutOfStockException is thrown.
	 * 
	 * @param shelf    The smart shelf as an IShelfCustomer reference.
	 * @param itemName The name of the item the customer wants.
	 * @return The RetailItem that the customer got from the shelf.
	 * @throws OutOfStockException If the item is not found on the shelf.
	 */
	public RetailItem getItem(IShelfCustomer shelf, String itemName) throws OutOfStockException {
		return shelf.findAndTake(itemName);
	}
}
