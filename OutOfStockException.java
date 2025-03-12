package edu.collin.cosc2436.bking.supermarketsmartshelf;

/**
 * Exception thrown when an item is not found on the shelf. OutOfStockException
 * is a subclass of Java's built-in Exception class. Extending Exception means
 * it is a checked exception, so methods that call it are required to handle it.
 */
public class OutOfStockException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an OutOfStockException with a specific message.
	 * 
	 * @param message The descriptive message indicating which item is out of stock
	 */
	public OutOfStockException(String message) {
		// Passes the error message to the super class (Exception), which stores the
		// message and makes it available via methods like getMessage().
		super(message);
	}

}
