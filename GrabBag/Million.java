// Delete package declaration!!
package GrabBag;

/**
 * Million.java
 * 
 * A program to find the sum of all
 * the prime numbers until 1 million.
 * 
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 8/30/2021
 *
 */

public class Million {
	public Million() {
		// default constructor
	}
		
	public static void main(String[] args) {
		//Initialize Million object and call below method
		Million million = new Million();
		million.findSumOfPrimes();
	}
	
	public void findSumOfPrimes() {
		int num = 1000000;
		//Declare a boolean array for all the numbers for if they're prime or not.
	    boolean[] isPrime = new boolean[num];
	    //Set all values in the array to true, meaning all the numbers are prime.
	    for (int i = 2; i< num; i++)
	    	isPrime[i] = true;
	    //For every value of i make all the indexes of the multiples of i
	    //(greater than i) in the isPrime array false, since those won't be
	    //prime numbers. This is done with nested for loops.
	    for (int i = 2; i < (int) Math.sqrt(num) + 1; i++) { 
	        if (isPrime[i] == true) {
	            for (int j = 2; i * j < num; j++)
	            	isPrime[i * j] = false;
	        }
	    }
	    
	    //Now we know which numbers are prime, so we can just add each prime
	    //number to the long sum and return the sum.
	    long sum = 2;
	    for (int i = 3; i < num; i+=2) { 
	        if (isPrime[i] == true)
	        	sum += i;
	    }
	    
	    System.out.println("Sum of Primes: " + sum);
	}
}