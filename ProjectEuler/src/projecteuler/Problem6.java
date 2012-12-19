package projecteuler;

/**
 * 
 * @author Andrzej Ruszczewski
 * 
 */
public class Problem6 {

	/**
	 * The sum of the squares of the first ten natural numbers is,
	 * 
	 * 1^2 + 2^2 + ... + 10^2 = 385
	 * 
	 * The square of the sum of the first ten natural numbers is,
	 * 
	 * (1 + 2 + ... + 10)^2 = 552 = 3025
	 * 
	 * Hence the difference between the sum of the squares of the first ten
	 * natural numbers and the square of the sum is 3025 - 385 = 2640.
	 * 
	 * Find the difference between the sum of the squares of the first one
	 * hundred natural numbers and the square of the sum.
	 * 
	 * Upgraded solution according to p.e. notes.
	 */
	public static void main(String[] args) {

		int sum1 = 0, sum2 = 0, upTo = 100;

		sum1 = (2 * upTo + 1) * (upTo + 1) * upTo / 6;

		sum2 = upTo * (upTo + 1) / 2;
		sum2 = sum2 * sum2;

		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(sum2 - sum1);
	}

}
