package edu.collin.cosc2436.bking.supermarketsmartshelf;

/**
 * Interface for customer interactions with the smart shelf.
 */
public interface IShelfCustomer <T extends RetailItem>{
	/**
	 * This method takes the name of an item and returns a reference to an item with
	 * this name. If the item cannot be found an OutOfStockException is thrown.
	 * 
	 * @param name The name of an item.
	 * @return A reference to an item with this name, if found.
	 * @throws OutOfStockException If the item cannot be found.
	 */
	T findAndTake(String name) throws OutOfStockException;
}
