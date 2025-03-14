package edu.collin.cosc2436.bking.supermarketsmartshelf;

/**
 * This class provides a descriptive message indicating what item is out of stock.
 */
public class OutOfStockException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an OutOfStockException with a descriptive message.
	 * 
	 * @param message The descriptive message indicating which item is out of stock
	 */
	public OutOfStockException(String message) {
		super(message);
	}
}
