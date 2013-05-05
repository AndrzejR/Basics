package ads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Some implementations of different sorting algorithms.
 * 
 * @author Andrzej Ruszczewski
 * 
 */
public class Sorting<T extends Comparable<T>> {

	/**
	 * Quicksort not in place. Fast, but this simpler version needs extra
	 * memory.
	 * 
	 * @param list
	 * @return
	 */
	public List<T> quickSort(List<T> list) {

		if (list.size() < 1) {
			return list;
		}

		T pivot = list.get(0);

		List<T> less = new LinkedList<T>();
		List<T> equal = new LinkedList<T>();
		List<T> greater = new LinkedList<T>();

		for (T x : list) {
			if (x.compareTo(pivot) > 0)
				greater.add(x);
			else if (x.compareTo(pivot) < 0)
				less.add(x);
			else
				equal.add(x);
		}

		less = quickSort(less);
		greater = quickSort(greater);

		less.addAll(equal);
		less.addAll(greater);

		return less;
	}

	/**
	 * Selection sort. In place, O(n^2).
	 * 
	 * @param aList
	 *            The list to sort.
	 */
	public void selectionSort(List<T> aList) {
		int i, j, indexMin;
		for (i = 0; i < aList.size(); i++) {
			indexMin = i;
			for (j = i; j < aList.size(); j++) {
				if (aList.get(j).compareTo(aList.get(indexMin)) < 0) {
					indexMin = j;
				}
			}
			if (indexMin != i) {
				T temp = aList.get(i);
				aList.set(i, aList.get(indexMin));
				aList.set(indexMin, temp);
			}

		}
	}

	/**
	 * A simple, but inefficient (O(n^2)) sort.
	 * 
	 * @param arrayToSort
	 */
	public static void bubbleSort(int[] arrayToSort) {
		for (int i = 0; i < arrayToSort.length; i++) {
			for (int j = 0; j < arrayToSort.length; j++) {
				if (arrayToSort[i] < arrayToSort[j]) {
					int temp = arrayToSort[i];
					arrayToSort[i] = arrayToSort[j];
					arrayToSort[j] = temp;
				}
			}
		}
	}

	/**
	 * Testing method
	 */
	public static void main(String[] args) {

		int[] anArrayToSort = { 8, 15, -1, 22, 1, 5, 19, -17, 20, 3, 9, 0, -4,
				22, 3, 77, 22, -13 };
		List<Integer> aList = new ArrayList<Integer>();
		for (int i = 0; i < anArrayToSort.length; i++) {
			aList.add(anArrayToSort[i]);
		}
		Sorting<Integer> s = new Sorting<Integer>();

		//aList = s.quickSort(aList);
		s.selectionSort(aList);

		for (int n : aList) {
			System.out.print(n + " ");
		}

	}

}
