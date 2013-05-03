package ads;

/**
 * 
 * Some implementations of different sorting algorithms.
 * 
 * @author Andrzej Ruszczewski
 * 
 */
public class Sorting {

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
		int[] anArrayToSort = { 8, 15, -1, 22, 1, 5, 19, -17, 20, 3, 9, 0, -4 };

		bubbleSort(anArrayToSort);
		for (int n : anArrayToSort) {
			System.out.print(n + " ");
		}

	}

}
