package edu.collin.cosc2436.bking.supermarketsmartshelf;

import java.util.ArrayList;
import java.util.Random;

/**
 * The SmartShelf class implements both the customer and employee interfaces. It
 * maintains a sorted list of RetailItem objects.
 */

public class SmartShelf implements IShelfCustomer, IShelfEmployee {

	// Immutable field for the type of items on the shelf (e.g., "cereal").
	private final String itemType;

	// Mutable list that will hold the sorted RetailItem objects.
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
	 * Employee method: Places a batch of unsorted items onto the shelf. This method
	 * copies the items into the shelf's list and then sorts them using QuickSort.
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
	 * Employee method: Adds a single item to the shelf, keeping the list sorted. It
	 * uses a modified binary search to determine the correct insertion point.
	 * 
	 * @param item The RetailItem to add.
	 */
	@Override
	public void addItem(RetailItem item) {
		int index = findInsertionIndex(this.items, item);
		this.items.add(index, item);
	}

	/**
	 * Customer method: Finds and removes an item by its name. It uses a modified
	 * binary search to locate an item with the given name.
	 * 
	 * @param name The name of the desired item.
	 * @return The RetailItem removed from the shelf.
	 * @throws OutOfStockException If no item with the given name is found on the
	 *                             shelf.
	 */
	@Override
	public RetailItem findAndTake(String name) throws OutOfStockException {
		RetailItem temp = new RetailItem(name);
		// Use the same modified binary search helper method.
		int index = findInsertionIndex(this.items, temp);
		// Check if the index is within bounds and the item at that index has the same
		// name
		if (index < this.items.size() && this.items.get(index).getName().equals(name)) {
			return this.items.remove(index);
		}
		throw new OutOfStockException(name + " is out of stock");
	}

	/**
	 * This method returns a string representation of all items on the shelf.
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
	 * This method implements the QuickSort algorithm on an ArrayList of RetailItem.
	 * 
	 * @param list The list of RetailItem objects.
	 * @param lo   The lower bound index.
	 * @param hi   The upper bound index.
	 */
	private static void quickSort(ArrayList<RetailItem> list, int lo, int hi) {
		if (lo < hi) {
			// Partition the list and get the pivot index.
			int p = partition(list, lo, hi);
			// Recursively sort the left and right sublists.
			quickSort(list, lo, p - 1);
			quickSort(list, p + 1, hi);
		}
	}

	/**
	 * This method implements a partitioning algorithm by picking a random pivot and
	 * scanning from left to right.
	 * 
	 * @param list The list of RetailItem objects.
	 * @param lo   The lower bound index.
	 * @param hi   The upper bound index.
	 * @return The final position of the pivot.
	 */
	private static int partition(ArrayList<RetailItem> list, int lo, int hi) {
		// Pick a random pivot index between the lo and hi, swap with lo.
		Random rand = new Random();
		int pivotIndex = lo + rand.nextInt(hi - lo + 1);
		swap(list, lo, pivotIndex);
		RetailItem pivot = list.get(lo);

		int left = lo + 1;
		int right = hi;

		// Scan until left and right cross
		while (left <= right) {
			// Move left while items[left] is <= pivot
			while (left <= right && list.get(left).compareTo(pivot) <= 0) {
				left++;
			}
			// Move right while items[right] is >= pivot
			while (right >= left && list.get(right).compareTo(pivot) > 0) {
				right--;
			}
			// Swap elements that stopped the scan
			if (left < right) {
				swap(list, left, right);
				left++;
				right--;
			}
		}
		// Swap pivot with the rightmost entry of the left sublist
		swap(list, lo, right);
		// Return the final position of the pivot
		return right;
	}

	/**
	 * Helper method to swap two elements in the list.
	 * 
	 * @param list The list of RetailItem
	 * @param pos1 The index of the first element
	 * @param pos2 The index of the second element
	 */
	private static void swap(ArrayList<RetailItem> list, int pos1, int pos2) {
		RetailItem temp = list.get(pos1);
		list.set(pos1, list.get(pos2));
		list.set(pos2, temp);
	}

	/**
	 * Modified binary search to find the correct insertion index for a new item.
	 * Even if there are duplicates of certain items, it determines the correct
	 * position so that the sorted order is maintained.
	 * 
	 * @param list The sorted list of RetailItem
	 * @param item The RetailItem to insert
	 * @return The insertion index
	 */
	private static int findInsertionIndex(ArrayList<RetailItem> list, RetailItem item) {
		int lo = 0;
		int hi = list.size() - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (list.get(mid).compareTo(item) < 0) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		// After the loop, lo is the correct insertion point.
		return lo;
	}

}