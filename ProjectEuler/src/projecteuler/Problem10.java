package projecteuler;

import java.util.*;

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

	static int[] primes;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		long sum = 2;
		primes = new int[150000];
		primes[0] = 2;
		primes[1] = 3;
		int k = 2;
		for (int a = 3; a < 2000000; a += 2) {
			if (isPrime(a)) {
				sum += a;
				primes[k++] = a;
			}
		}
		System.out.println("The sum is: " + sum);
		long endTime = System.currentTimeMillis();
		System.out.println("time taken: " + (endTime - startTime) + "ms");
	}

	private static boolean isPrime(int a) {
		for (int i = 0; i < primes.length; i++) {
			if (primes[i] > Math.sqrt(a)) {
				return true;
			}
			if (a % primes[i] == 0) {
				return false;
			}
		}
		return true;
	}

}
