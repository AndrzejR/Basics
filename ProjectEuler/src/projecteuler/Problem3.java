/**
 * 
 */
package projecteuler;

import java.util.ArrayList;

/**
 * @author Andrzej Ruszczewski
 * 
 */
public class Problem3 {

	/**
	 * The prime factors of 13195 are 5, 7, 13 and 29.
	 * 
	 * What is the largest prime factor of the number 600851475143 ?
	 * 
	 */
	public static void main(String[] args) {

		long number = 600851475143l;

		// The number is not even so we can start with 3 and increase by 2.
		int i = 3;

		// An overkill, but why guess how many of those factors there can be...
		// Could be just a simple variable if I was interested in just the
		// largest one.
		ArrayList<Long> factors = new ArrayList<Long>();

		while (number > 1) {
			if (number % i == 0) {
				number = number / i;
				factors.add((long) i);
			} else {
				i += 2;
			}
		}

		for (Long l : factors) {
			System.out.println(l);
		}

	}

}
