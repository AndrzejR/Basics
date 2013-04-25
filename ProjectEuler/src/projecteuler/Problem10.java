package projecteuler;

/**
 * 
 * @author Andrzej Ruszczewski
 * 
 *         The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 *         Find the sum of all the primes below two million.
 * 
 */
public class Problem10 {

	public static void main(String[] args) {
		long sum = 2;
		for (int i = 3; i < 2000000; i += 2) {
			if (isPrime(i)) {
				sum += i;
			}
		}
		System.out.println("The sum is: " + sum);

	}

	private static boolean isPrime(int a) {
		for (int i = 2; i <= Math.sqrt(a); i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

}
