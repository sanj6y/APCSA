/**
 * TwoPounds.java
 * 
 * A program to find the number of ways £2 can be made using
 * any number of coins. In England the currency is made up 
 * of pound, £, and pence, p, and there are eight coins in
 * general circulation: 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p)
 * and £2 (200p).
 * 
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 10/11/21
 */

public class TwoPounds
{
	public static void main(String[] args)
	{
		TwoPounds tp = new TwoPounds();
		tp.run();
	}
	
	/**
	 * Calls the calculateWays method and prints result
	 * to the terminal.
	 */
	public void run()
	{
		int numWays = calculateWays();
		System.out.println("\n\n\n£2 can be made using any number of coins in " + numWays + " different ways.\n\n\n");
	}
	
	/**
	 * Calculates the number of ways with a for loop for each type of coin.
	 * Checks if the total value of a certain combination adds up to 200
	 * pence, or 2 pounds, and if so, the count is incremented. To optimize
	 * this, if statements are inserted to check if the value is currently
	 * greater than 200 and prevent going through all the other loops if
	 * the value is already greater than 200. Finally, the number of possible
	 * ways to make 2 pounds from any number of coins, stored in the count
	 * variable, is returned.
	 * 
	 */
	public int calculateWays()
	{
		int count = 0;
		for (int p200 = 0; p200 <= 1; p200++)
		{
			for (int p100 = 0; p100 <= 2; p100++)
			{
				if (p200*200 + p100*100 <= 200)
					for (int p50 = 0; p50 <= 4; p50++)
					{
						if (p200*200 + p100*100 + p50*50 <= 200)
							for (int p20 = 0; p20 <= 10; p20++)
							{
								if (p200*200 + p100*100 + p50*50 + p20*20 <= 200)
									for (int p10 = 0; p10 <= 20; p10++)
									{
										if (p200*200 + p100*100 + p50*50 + p20*20 + p10*10 <= 200)
											for (int p5 = 0; p5 <= 40; p5++)
											{
												if (p200*200 + p100*100 + p50*50 + p20*20 + p10*10 + p5*5 <= 200)
													for (int p2 = 0; p2 <= 100; p2++)
													{
														if (p200*200 + p100*100 + p50*50 + p20*20 + p10*10 + p5*5 + p2*2 <= 200)
															for (int p1 = 0; p1 <= 200; p1++)
															{
																if((200*p200)+(100*p100)+(50*p50)+(20*p20)+(10*p10)+(5*p5)+(2*p2)+p1 == 200)
																	count++;
															}
													}
											}
									}
							}
					}
			}
		}

		return count;
	}

	
}