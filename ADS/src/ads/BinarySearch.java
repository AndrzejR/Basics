package ads;

/**
 * A simple binary search.
 * 
 * @author Andrzej Ruszczewski
 * 
 */
public class BinarySearch {

	public static int binSearch(int value, int[] array, int iMin, int iMax) {
		if (iMin > iMax) {
			return -1;
		} else {
			int iMid = iMin + ((iMax - iMin) / 2);
			if (array[iMid] == value) {
				return iMid;
			} else if (value > array[iMid]) {
				return binSearch(value, array, iMid + 1, iMax);
			} else {
				return binSearch(value, array, iMin, iMid - 1);
			}

		}
	}

	/**
	 * Testing method.
	 */
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
		int[] arr2 = { 2, 5, 6, 7, 11, 45, 66, 89, 124 };
		System.out.println("true? " + binSearch(4, arr1, 0, arr1.length - 1));
		System.out.println("false? " + binSearch(4, arr2, 0, arr1.length - 1));
		System.out.println("true? " + binSearch(7, arr1, 0, arr1.length - 1));
		System.out
				.println("false? " + binSearch(123, arr2, 0, arr2.length - 1));

	}

}
