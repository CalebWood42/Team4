package edu.collin.cosc2436.bking.supermarketsmartshelf;

/**
 * Interface for customer interactions with the smart shelf.
 */
public interface IShelfCustomer {
	/**
	 * This method searches for an item by its name, removes it, and returns a
	 * reference to an item with this name. If the item cannot be found an
	 * OutOfStockException is thrown.
	 * 
	 * @param name The name of the item the customer wants.
	 * @return The RetailItem if found.
	 * @throws OutOfStockException if the item is not available on the shelf.
	 */
	RetailItem findAndTake(String name) throws OutOfStockException;
}
