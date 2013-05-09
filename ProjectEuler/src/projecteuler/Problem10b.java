package projecteuler;

/**
 * Sieve of Eratosthenes implementation of the looking for primes problem.
 * 
 * @author Andrzej Ruszczewski
 *
 */
public class Problem10b {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		int[] primes = new int[2000001];
		for (int i = 2; i < primes.length; i++) {
			primes[i] = i;
		}

		for (int j = 2; j <= Math.sqrt(2000000); j++) {
			if (primes[j] == 0)
				continue;
			for (int k = j; k * j < primes.length; k++) {
				primes[k * j] = 0;
			}
		}
		long sum = 0;
		for (int i = 0; i < primes.length; i++) {
			sum += primes[i];
		}
		long end = System.currentTimeMillis();
		System.out.println("The sum is: " + sum);
		System.out.println("Time taken: " + (end - start) + "ms");

	}

}
