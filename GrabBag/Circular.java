/**
 * Circular.java
 * 
 * A program to find the number of circular
 * primes less than 50,000. A circular prime
 * is a prime number which remains prime upon
 * rotating it all ways (ex. for 197, 197,
 * 971, and 719 are all prime, so 197 is a
 * circular prime).
 * 
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 10/11/21
 */

public class Circular
{
	public static void main(String[] args)
	{
		Circular c = new Circular();
		c.run();
	}

	/**
	 * Calls the rotate method for all numbers
	 * from 2 (the first prime number) to 50000
	 * to check if each one is a circular prime.
	 * If one number is a circular prime, the
	 * count of circular primes is incremented.
	 * Lastly, the number of circular primes is
	 * printed to the terminal.
	 */
	public void run()
	{
		int count = 0;
		for (int i = 2; i < 50000; i++)
		{
			if (rotate(i))
				count++;
		}
		System.out.println("\n\n\nThe number of circular primes less than 50,000 is " + count + ".\n\n\n");
	}
	
	/**
	 * Checks if a number is prime by seeing if it evenly divides
	 * any number up to the its square root.
	 */
	public boolean isPrime(int num)
	{
		for (int i = 2; i <= (int) Math.sqrt(num); i++)
		{
			if (num % i == 0)
				return false;
		}
		return true;
	}

	/**
	 * Checks if a number is a circular prime. Saves the
	 * original number as a string str, and in every iteration
	 * of the while loop, the first character in str is made
	 * the last character, effectively rotating the number
	 * once. If this rotation isn't prime, then false is
	 * returned because we now know the original number isn't
	 * a circular prime. If it is, then the loop goes to the
	 * next iteration. If all rotations turn out to be prime,
	 * then we know the number is a circular prime and then
	 * return true. 
	 */
	public boolean rotate (int num)
	{
		int parsedInt = 0;
		String str = num + "";
		String result = "";

		while (num != parsedInt)
		{
			result = str.substring(1, str.length()) + str.substring(0, 1);
			parsedInt = Integer.parseInt(result);
			if (!isPrime(parsedInt))
				return false;
			str = result;
		}

		return true;
	}
}