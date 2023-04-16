// Delete package declaration!!
package GrabBag;

/**
 * Ninety.java
 * 
 * A program to find the difference
 * between the sum of the squares of
 * the first ninety natural numbers
 * and the square of the sum.
 * 
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 8/30/21
 *
 */

public class Ninety {
	public Ninety() {
		// default constructor
	}
	
	public static void main(String[] args) {
		// Initialize Ninety object and call
		// findDifferenceOfSums method.
		Ninety ninety = new Ninety();
		ninety.findDifferenceOfSums();
	}
	
	public void findDifferenceOfSums() {
		// Delcare all variables
		int sumOfFirst = 0;
		int sumOfSecond = 0;
		int difference = 0;
		
		// A for loop to run through all
		// numbers from 1 to 90 inclusive.
		// Each number squared is added to
		// sumOfFirst and each number itself
		// is added to sumOfSecond.
		for (int i = 1; i <= 90; i++) {
			sumOfFirst += (i*i);
			sumOfSecond += i;
		}
		
		// sumOfSecond is set equal to its square and
		// we find the difference between sumOfSecond
		// and sumOfFirst, or the difference between
		// the square of the sum of the first ninety
		// natural numbers and the sum of the squares.
		sumOfSecond *= sumOfSecond;
		difference = sumOfSecond - sumOfFirst;
		
		System.out.println("Difference: " + difference);
	}
}