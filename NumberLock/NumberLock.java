/**
 * NumberLock.java
 *
 * A program, using the Dice and Prompt classes,
 * to simulate a game called NumberLock. The goal
 * of this game is to guess the master key, which
 * is an array with 4 digits. The master key is
 * set randomly and the user is prompted to guess
 * what the master key is. The user will then be
 * told how many exact matches (correct number and
 * correct position) there are and how many partial
 * matches there are (correct number but incorrect
 * position), and will be prompted to guess again.
 * Upon guessing correctly, an exit message will
 * be displayed, with how many guesses it took the
 * user to guess the master key. When the program is
 * run, a command line argument 'show' can be added
 * to display the master key during the game.
 *
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 9/23/2021
 */

public class NumberLock
{
	/**  The int array containing the random "master" key. These are to be filled with random numbers from 1 to 9.  */
	private int [] master;
	
	/**  The int array used to store the user's guesses.  */
	private int [] guess;
	
	/**  If this boolean is set to true, then the master key should be shown for every turn.  Otherwise the master is not shown until the end. */
	private boolean show;

	
	public NumberLock ( )
	{
		master = new int[4];
		guess = new int[4];
		show = false;
	}
	
	/**
	 *  Sets up and runs NumberLock.
	 *  @param	args     An array of String arguments (the first element,
	 *                   at index 0, could be used.  If the user enters
	 *                   "show" then the MASTER KEY should be printed
	 *                   before every user turn).
	 */
	public static void main(String [] args)
	{		
		NumberLock run = new NumberLock();
		if(args.length > 0)
		{
			run.setShow(args[0]);
		}
		run.instructions();
		run.play();
	}
	
	public void setShow(String str)
	{
		if(str.equalsIgnoreCase("show"))
		{
			show = true;
		}
	}	
	
	public void instructions ( )
	{
		System.out.println("\n\n\n");
		System.out.println("    _   __                __              __               __  ");
		System.out.println("   / | / /_  ______ ___  / /_  ___  _____/ /   ____  _____/ /__   ");
		System.out.println("  /  |/ / / / / __ `__ \\/ __ \\/ _ \\/ ___/ /   / __ \\/ ___/ //_/  ");
		System.out.println(" / /|  / /_/ / / / / / / /_/ /  __/ /  / /___/ /_/ / /__/ ,<    ");
		System.out.println("/_/ |_/\\__,_/_/ /_/ /_/_.___/\\___/_/  /_____/\\____/\\___/_/|_|  \n");
		System.out.println("Welcome to the game of NUMBERLOCK (TM).  In this game, an array of 4 ints (the master)");
		System.out.println("is filled with random numbers from 1 to 9.  The goal of the game is to guess these random");
		System.out.println("numbers, in order.  The user is prompted to enter a 4-digit number, and the input is");
		System.out.println("checked to make sure it is within the range from 1000 to 9999, and contains no 0's.  Then,");
		System.out.println("the user is informed of the number of exact digit matches, and the number of partial digit");
		System.out.println("matches.  For these matches, exact + partial may not exceed 4, because a match may be exact");
		System.out.println("or it may be partial, but it cannot be both.  The user continues to make guesses until four");
		System.out.println("exact matches are made.  Once the puzzle is solved, the game ends, with an exit message,");
		System.out.println("informing the user of how many guesses it took to find the pattern. See the sample run");
		System.out.println("outputs for detailed formatting information.");
		System.out.println("\n  THE MASTER KEY HAS BEEN CHOSEN.  LET THE GAME BEGIN . . .\n\n\n");
	}
	
	/**
	 * A method that calls the methods necessary
	 * to play the game. We first fill the master
	 * array with random values, and we initialize
	 * a count variable to track the number of
	 * guesses the user takes to find the master key.
	 * While the number of exact matches is not four,
	 * we keep getting the user's guess and increment
	 * the count variable each time. We then call the
	 * exitMessage method with the amount of guesses
	 * taken to print the exit message and end the program.
	 */
	public void play ( )
	{
		//  This method should have a loop, and it should call the methods necessary to
		//  play the game.  This method should not be too long.
		
		int count = 0;
		fillOutMaster();
		
		do
		{
			getGuess();
			count++;
		} while(checkGuess() == false);

		exitMessage(count);
	}
	
	/**
	 * A method to print out values of
	 * an array. Goes through each
	 * value of the array and prints
	 * each one on the same line.
	 * 
	 * @param	array	the array to print the values of
	 */
	public void printArray(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i]);
		}
		
		System.out.println();
	}
	
	/**
	 * A method to check if a number
	 * is in the array guess. Goes
	 * through guess array and if num
	 * matches any value in guess
	 * then the method returns true.
	 * 
	 * @param	num		the number to check
	 * 					if it's in the guess
	 * 					array
	 * @return	boolean	whether or not the number
	 * 					is in the guess array
	 */
	public boolean inGuessArray(int num)
	{
		for (int i = 0; i < guess.length; i++)
		{
			if (guess[i] == num && guess[i] != master[i])
			{
				guess[i] = 0;
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * A method to get a random value
	 * for the master array. Uses Dice
	 * class to get a random number from
	 * 1 to 9 and assigns the value from
	 * each roll to one of the values in
	 * the master array.
	 */
	public void fillOutMaster()
	{
		for (int i = 0; i < 4; i++)
		{
			Dice die1 = new Dice(9);
			die1.roll();
			master[i] = die1.getValue();
		}
	}
	
	/**
	 * A method to get the user's guess for the
	 * number using the Prompt class. If show
	 * is set to true then the master key will
	 * also be displayed. The guess array is set
	 * to the number taken in as the user input.
	 */
	public void getGuess()
	{
		do
		{
			if (show)
			{
				System.out.print("Here is the master key: ");
				printArray(master);
			}
			
			String ask = "Please enter an integer value, with no zero digits";
			int input = Prompt.getInt(ask, 1000, 9999);
			System.out.println();
			for (int i = guess.length - 1; i >= 0; i--)
			{
				guess[i] = input % 10;
				input /= 10;
			}
		} while (inGuessArray(0));
		
		System.out.print("Your Guess: ");
		printArray(guess);
		
		
	}
	
	/**
	 * A method to check if the guess is correct
	 * and print the number of exact and partial
	 * matches between the guess and the master
	 * key. We run through the values in the guess
	 * array and if one is equal to the the value
	 * in master at the same index then we increment
	 * the exact match count. We also set that value
	 * of guess equal to 0 to prevent the partial
	 * match from also incrementing for the same
	 * value. We also check if the value in master
	 * at the current index is in the guess array, and
	 * if it is, then we increment the partial match
	 * count. We then call a method to print out the
	 * amount of exact and partial matches. We return
	 * true if the number of exact matches is 4 (the
	 * guess is correct) and false otherwise.
	 * 
	 * @return	boolean	whether or not the guess is
	 * 					correct (exact matches = 4)
	 */
	public boolean checkGuess()
	{
		int exact = 0;
		int partial = 0;
		
		for (int i = 0; i < 4; i++)
		{
			if (guess[i] == master[i])
			{
				exact++;
				guess[i] = 0; // to avoid each partial match from repeating
			}
			else if (inGuessArray(master[i]))
			{
				partial++;
			}
		}
		
		printResults(exact, partial);

		if (exact == 4)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}

	/**
	 * Takes in amount of exact matches
	 * and partial matches and prints
	 * them out.
	 * 
	 * @param	exact	the number of exact matches
	 * @param	partial	the number of partial matches
	 */
	public void printResults(int exact, int partial)
	{
		System.out.println("Exact Matches: " + exact);
		System.out.println("Partial Matches: " + partial + "\n");
	}
	
	/**
	 * A method to print the exit message. Takes
	 * in an integer value which is the amount
	 * of guess taken for the user to find the
	 * master key correctly.
	 * 
	 * @param	count	the number of guesses the
	 * 					user took to find the
	 * 					master key
	 */
	public void exitMessage(int count)
	{
		System.out.println("Congratulations! You found the master key!");
		System.out.println("\n    +-------------+");
		System.out.println("    |   " + master[0] + " " + master[1] + " " + master[2] + " " + master[3] + "   |");
		System.out.println("    +-------------+\n");
		System.out.println("It took you " + count + " guesses to find it.");
		System.out.println("Goodbye for now, and please play again...\n\n\n");
				
	}
}