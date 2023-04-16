// Delete package declaration!!
package GrabBag;

/**
 * ThousandSum.java
 * 
 * A program to find the product of
 * the pythagorean triple whose three
 * numbers add up to 1000.
 * 
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 8/30/21
 *
 */

public class ThousandSum {
	public ThousandSum() {
		// default constructor
	}
	
	public static void main(String[] args) {
		//Initialize a ThousandSum object and
		//call findProductOfPythTripleValues method
		ThousandSum thousandSum = new ThousandSum();
		thousandSum.findProductOfPythTripleValues();
		
	}
	
	public void findProductOfPythTripleValues() {
		//Declare all variables
		int num1 = 0; 
		int num2 = 0;
		int num3 = 0;
		int sum = 1000;
		boolean correctTriple = false;
		
		//going through each possible value for num1 until 1000/3 (max possible value)
		for (num1 = 1; num1 < sum/3; num1++) {
			// second loop: same thing, except for num2 and 500 instead of 333
			for (num2 = num1+1; num2 < sum/2; num2++) {
				//setting num3 equal to the difference between 100 and num1 and num2
				num3 = sum - num1 - num2;	
				//checking if it's a pythagorean triple. if it is,
				//set correctTriple equal to true and if correctTriple
				//is true then the method will return the product of the
				//three numbers.
				if ((num1*num1) + (num2*num2) == (num3*num3)) {
					correctTriple = true;
				}
				
				if (correctTriple) {
					System.out.println("Product of Pythagorean Triple Values: " + num1*num2*num3);
					return;
				}
			}
		}
	}
}