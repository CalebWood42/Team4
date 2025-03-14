package edu.collin.cosc2436.bking.supermarketsmartshelf;

import java.util.ArrayList;

/**
 * Interface for employee interactions with the smart shelf.
 */
public interface IShelfEmployee <T extends RetailItem>{
	/**
	 * This method puts an unsorted ArrayList of items on the shelf.
	 * 
	 * @param items An ArrayList of RetailItem objects to be placed on the shelf.
	 */
	void placeItems(ArrayList<T> items);

	/**
	 * This method adds a single item to the shelf while maintaining sorted order.
	 * 
	 * @param item The RetailItem to add.
	 */
	void addItem(T item);

}
