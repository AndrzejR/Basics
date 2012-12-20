package projecteuler;

/**
 * 
 * @author Andrzej Ruszczewski
 * 
 */
public class Problem9 {

	/**
	 * A Pythagorean triplet is a set of three natural numbers, a b c, for
	 * which,
	 * 
	 * a^2 + b^2 = c^2
	 * 
	 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
	 * 
	 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	 * Find the product abc.
	 * 
	 * First try - a brute force O(n^2) solution.
	 */
	public static void main(String[] args) {

		int a = 1, b = 1, c = 1;
	
		for (a = 1; a < 334; a++) {
			for (b = a + 1; b < (1000 - a) / 2; b++) {
				c = 1000 - b - a;
				if (a * a + b * b == c * c)					
					break;				
			}
			if (a * a + b * b == c * c)
				break;
		}

		if (a * a + b * b == c * c && a + b + c == 1000) {
			System.out.println(a + " " + b + " " + c);
			System.out.println("Product = " + a * b * c);
		} else
			System.out.println("something is wrong");

	}
}
