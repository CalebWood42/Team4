package edu.collin.cosc2436.bking.supermarketsmartshelf;

/**
 * This class represents a retail item with a name.
 */
public class RetailItem {
	// Immutable field for the item's name (Once a RetailItem is created, its name
	// cannot be changed).
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
	 * Getter that retrieves the name of the retail item. This method provides
	 * read-only access to the name field.
	 * 
	 * @return The name of the item.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method compares two RetailItem objects alphabetically by name. Uses
	 * String's built-in compareTo method to compare this.name with other.name. This
	 * method allows the items to be sorted alphabetically.
	 * 
	 * @param other The RetailItem to compare with.
	 * @return A negative integer if this name comes before the other name, zero if
	 *         they are equal, or a positive integer if this name comes after.
	 */
	public int compareTo(RetailItem other) {
		return this.name.compareTo(other.name);
	}

	/**
	 * This method returns a string representation of the RetailItem item. Returns
	 * the name, so when you print a RetailItem, you see its name.
	 * 
	 * @return The name of the retail item.
	 */
	@Override
	public String toString() {
		return name;
	}

}
