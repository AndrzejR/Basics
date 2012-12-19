package projecteuler;

/**
 * 
 * @author Andrzej Ruszczewski
 * 
 */
public class Problem7 {

	/**
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can
	 * see that the 6th prime is 13.
	 * 
	 * What is the 10001st prime number?
	 */
	public static void main(String[] args) {

		int[] primes = new int[10001];
		primes[0] = 2; // special case for the only even prime

		int i = 1; // counter
		int p = 3; // number to test

		while (i < 10001) {
			if (isPrime(p)) {
				primes[i] = p;
				i++;
			}
			p += 2;
		}

		System.out.println(primes[10000]);

	}

	/**
	 * 
	 * @param n
	 *            an odd integer to test if it is prime
	 * @return true if n is prime, false otherwise
	 */
	private static boolean isPrime(int n) {

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0)
				return false;
		}

		return true;

	}

}
