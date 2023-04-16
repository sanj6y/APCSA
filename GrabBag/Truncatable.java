/**
 * Truncatable.java
 * 
 * A program to find the sum of the only 11 truncatable primes.
 * Truncatable primes are numbers that remain prime as you remove
 * digits from both the left to right and right to left.
 * 
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 10/11/21
 */

public class Truncatable
{
	public static void main(String[] args)
	{
		Truncatable tr = new Truncatable();
		tr.run();
	}

	/**
	 * Checks if a number is a truncatable prime using
	 * the isTruncatablePrime method, and if it is, then
	 * the number is added to the sum. The sum of all the
	 * 11 truncatable primes is then printed to the terminal.
	 */
	public void run()
	{
		int sum = 0;
		int count = 0;
		for (int i = 10; count < 11; i++)
		{
			if (isTruncatablePrime(i))
			{
				sum += i;
				count++;
			}
		}

		System.out.println("\n\n\nThe sum of the 11 truncatable primes is " + sum + ".\n\n\n");
	}

	/**
	 * Checks if a number is prime by seeing if it evenly divides
	 * any number up to the its square root.
	 */
	public boolean isPrime(int num)
	{
		if (num < 2)
			return false;

		for (int i = 2; i <= (int) Math.sqrt(num); i++)
		{
			if (num % i == 0)
				return false;
		}

		return true;
	}

	/**
	 * Checks if a number is prime from left to right and right
	 * to left using the isPrime method. Digits are removed to
	 * check for the next number using loops.
	 */
	public boolean isTruncatablePrime(int num)
	{
		// testing if left-truncatable
		for (int i = 10; i <= num; i *= 10)
		{
			if(!isPrime(num % i))
				return false;
		}

		// testing if right-truncatablle
		for ( ; num != 0; num /= 10)
		{
			if(!isPrime(num))
				return false;
		}

		return true;
	}
}