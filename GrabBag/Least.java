// Delete package declaration!!
package GrabBag;

/**
 * Least.java
 * 
 * A program to find the least positive
 * number that is evenly divisible by
 * all of the numbers from 1 to 25.
 * 
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 8/30/21
 *
 */

public class Least {
	public Least() {
		// default constructor
	}
		
	public static void main(String[] args) {
		// Initialize Least object and
		// call	findLeastDivisible method.
		Least least = new Least();
		least.findLeastDivisible();
	}
		
	public void findLeastDivisible() {
		// declare long variable product
		long product = 1;
		
		// A for loop to go through the numbers
		// 25 to 1 in decreasing order and if
		// the product variable isn't divisible
		// by the loop number then product is set
		// to k times itself.
		for (long k = 25; k >= 1; k--) {
			if (product % k != 0)
				product *= k;
		}
		
		System.out.println("Least Multiple: " + product);
	}
}