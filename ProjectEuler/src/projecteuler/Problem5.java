package projecteuler;

/**
 * 
 * @author Andrzej Ruszczewski
 * 
 */
public class Problem5 {

	/**
	 * 2520 is the smallest number that can be divided by each of the numbers
	 * from 1 to 10 without any remainder.
	 * 
	 * What is the smallest positive number that is evenly divisible by all of
	 * the numbers from 1 to 20?
	 * 
	 * A rather unelegant brute force solution...
	 */
	public static void main(String[] args) {
		
		int number = -1;
		
		for (int i = 20; i<Integer.MAX_VALUE; i++){
			if (i%20==0 && i%19==0 && i%18==0 && i%17==0 && i%16==0 && i%14==0 && i%13==0 && i%11==0) {
				number = i;
				break;
			}
		}
		
		System.out.println(number);

	}

}
