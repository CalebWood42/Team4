package edu.collin.cosc2436.bking.supermarketsmartshelf;

/**
 * This class represents a retail item with a name.
 */
public class RetailItem {

	private final String name;

	/**
	 * Constructor to create a RetailItem with a specified name.
	 * 
	 * @param name The name of the retail item.
	 */
	public RetailItem(String name) {
		// Assigns the provided name to the instance field
		this.name = name;
	}

	/**
	 * Getter that retrieves the name of the retail item.
	 * 
	 * @return The name of the item.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method compares two RetailItem objects.
	 * 
	 * @param other The RetailItem to compare with.
	 * @return Negative one if this name comes before the other name, zero if they
	 *         are equal, or positive one if this name comes after the other name.
	 */
	public int compareTo(RetailItem other) {
		return this.name.compareTo(other.name);
	}

	/**
	 * This method returns a string representation of the RetailItem item.
	 * 
	 * @return The name of the retail item.
	 */
	@Override
	public String toString() {
		return name;
	}
}
