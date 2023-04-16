// Delete package declaration!!
package GrabBag;

/**
 * SumOfMultiples.java
 * 
 * A program to find the sum of all the
 * multiples of 3 or 5 below 6000.
 * 
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 8/30/21
 *
 */

public class SumOfMultiples {
	public SumOfMultiples() {
		//default constructor
	}
	
	public static void main(String[] args) {
		// Initialize SumOfMultiples object
		// and call findSum method.
		SumOfMultiples test = new SumOfMultiples();
		test.findSum();
	}
	
	public void findSum() {
		//declare an integer variable sum
		int sum = 0;
		// A for loop to go through integers from
		// 0 to 6000. If the number is divisible
		// by 3 or 5, then the number is added to sum.
		for (int i = 0; i < 6000; i++) {
			if (i%3==0 || i%5==0)
				sum += i;
		}
		
		System.out.println("Sum: " + sum);
	}
}