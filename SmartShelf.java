package edu.collin.cosc2436.bking.supermarketsmartshelf;

import java.util.ArrayList;
import java.util.Random;

/**
 * The SmartShelf class implements both the customer and employee interfaces. It
 * maintains a sorted list of RetailItem objects.
 */

public class SmartShelf implements IShelfCustomer, IShelfEmployee {

	// Immutable field for the name of the kind of items on the shelf.
	private final String itemType;

	// Mutable list of sorted items.
	private ArrayList<RetailItem> items;

	/**
	 * Constructs a SmartShelf for the specified item type.
	 * 
	 * @param itemType The kind of items on this shelf.
	 */
	public SmartShelf(String itemType) {
		this.itemType = itemType;
		this.items = new ArrayList<>();
	}

	/**
	 * An implementation of the IShelfEmployee placeItems() method. It calls a
	 * private static helper method that implements the QuickSort algorithm to sort
	 * the items.
	 * 
	 * @param unsortedItems An ArrayList of RetailItem objects to be placed on the
	 *                      shelf.
	 */
	@Override
	public void placeItems(ArrayList<RetailItem> unsortedItems) {
		// Copy unsorted items to the shelf's list.
		this.items = new ArrayList<>(unsortedItems);
		// Sort the items using QuickSort algorithm.
		quickSort(this.items, 0, this.items.size() - 1);
	}

	/**
	 * Adds a single item to the shelf, while keeping the list sorted (Well, it is
	 * supposed to. We are not sure exactly how to fix this, as it currently just
	 * adds the cereal to the end of the ArrayList). It uses a modified binary
	 * search to determine the correct insertion point.
	 * 
	 * @param item The RetailItem to add.
	 */
	@Override
	public void addItem(RetailItem item) {
		int index = findInsertionIndex(this.items, item);
		//if (index == -1) {
		//	this.items.add(item);
		//} else {
			this.items.add(index, item);
		//}
	}

	/**
	 * An implementation of the IShelfCustomer findAndTake() method. It finds an
	 * item with the provided name, removes it from the list, and returns it to the
	 * customer. In order to find the item it calls the same modified binary search
	 * helper method. If the item is not found an OutOfStockException is thrown.
	 * 
	 * @param name The name of the desired item.
	 * @return The RetailItem removed from the shelf.
	 * @throws OutOfStockException If no item with the given name is found on the
	 *                             shelf.
	 */
	@Override
	public RetailItem findAndTake(String name) throws OutOfStockException {
		RetailItem temp = new RetailItem(name);
		int index = findInsertionIndex(this.items, temp);
		if (items.get(index).equals(temp)) {
			return this.items.remove(index);
		} else
			throw new OutOfStockException(name + " is out of stock");
	}

	/**
	 * An overridden toString() method that uses a StringBuilder to build a list of
	 * all items on the shelf.
	 * 
	 * @return A list of items, each on a new line.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (RetailItem item : items) {
			sb.append(item.toString()).append("\n");
		}
		return sb.toString();
	}

	/**
	 * This method implements the QuickSort algorithm to sort the items.
	 * 
	 * @param list  The list of RetailItem objects.
	 * @param start The lower bound index.
	 * @param end   The upper bound index.
	 */
	private static void quickSort(ArrayList<RetailItem> list, int start, int end) {
		if (start >= end) {
			return;
		}
		int pos = partition(list, start, end);
		quickSort(list, start, pos - 1);
		quickSort(list, pos + 1, end);
	}

	/**
	 * This method implements a partitioning algorithm.
	 * 
	 * @param list  The list of RetailItem objects.
	 * @param start The lower bound index.
	 * @param end   The upper bound index.
	 * @return pos The insertion position.
	 */
	private static int partition(ArrayList<RetailItem> list, int start, int end) {
		int idx = new Random().nextInt(start, end);
		swap(list, idx, end);

		RetailItem pivot = list.get(end);

		int pos = start;

		for (int i = start; i < end; ++i) {
			if (list.get(i).compareTo(pivot) <= 0) {
				swap(list, pos++, i);
			}
		}
		swap(list, pos, end);
		return pos;
	}

	/**
	 * Helper method to swap two elements in the list.
	 * 
	 * @param list The list of RetailItem
	 * @param i    The index of the first element
	 * @param j    The index of the second element
	 */
	private static void swap(ArrayList<RetailItem> list, int i, int j) {
		RetailItem temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	/**
	 * Modified binary search that instead of looking for a match looks for the
	 * insertion position.
	 * 
	 * @param list   The ArrayList to search
	 * @param target The RetailItem object to search for
	 * @return A position of the RetailItem object if found and -1 otherwise
	 */
	private static int findInsertionIndex(ArrayList<RetailItem> list, RetailItem target) {
		int ret = -1;
		int lo = 0;
		int hi = list.size() - 1;

		if (target.compareTo(list.get(lo)) >= 0 && target.compareTo(list.get(hi)) <= 0) {

			while (lo <= hi) {
				int mid = lo + (hi - lo) / 2;
				if (target.compareTo(list.get(mid)) == 0) {
					ret = mid;
					break;
				}

				if (target.compareTo(list.get(mid)) > 0) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
				// If the item is never found.
				ret = mid;
			}
		}
		return ret;
	}
}
