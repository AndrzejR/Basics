package projecteuler;

/**
 * 
 * @author Andrzej Ruszczewski
 * 
 */
public class Problem4 {

	/**
	 * A palindromic number reads the same both ways. The largest palindrome
	 * made from the product of two 2-digit numbers is 9009 = 91 99.
	 * 
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 * 
	 * To begin with, the most primitive algorithm.
	 */
	public static void main(String[] args) {

		int max = 0;

		for (int i = 100; i < 1000; i++) {
			for (int j = 100; j < 1000; j++) {
				if (isPalindrome(i * j) && i * j > max)
					max = i * j;
			}
		}
		
		System.out.println(max);

	}

	protected static boolean isPalindrome(int number) {

		String numString = Integer.toString(number);

		for (int i = 0; i < numString.length() / 2; i++) {
			if (!(numString.charAt(i) == numString.charAt(numString.length()
					- 1 - i)))
				return false;
		}

		return true;
	}

}
