/**
 *  OutOfSorts.java
 *
 *  Tests the 3 quadratic sorting algorithms, including
 *  Bubble Sort, Selection Sort, and Insertion Sort.  Also
 *  makes use of the Merge Sort.  The user is prompted to
 *  choose a number of random integers (from 5 to 10,000),
 *  and then is prompted to choose a maximum value for the
 *  numbers to be generated (again from 5 to 10,000).  The
 *  user then chooses one of the four sorts cited above.
 *  The particular sort is run, with every step in the 
 *  sort counted.  The sorted list is then printed, along
 *  with the number of steps taken to accomplish the
 *  sorting.
 *
 *  @author Scott DeRuiter and Sanjay Chandrasekar
 *  @version 1.0
 *  @since 1/3/2022
 */

import java.util.Scanner;
import java.util.ArrayList;

public class OutOfSorts
{
	private ArrayList <Integer> intlist;
	
	public OutOfSorts ( )
	{
		intlist = new ArrayList <Integer> ();
	}

	public static void main (String [] args)
	{
		OutOfSorts sortit = new OutOfSorts();
		sortit.run();
	}
	
	public void run ( )
	{
		char choice = '1';
		welcome();
		do
		{
			int size = getSize();
			int max = getMax();
			createList(size, max, intlist);
			printList(intlist);
			choice = chooseFromMenu("ArrayList of Integer", intlist);
			doSort(choice);
			choice = repeatOrEnd(choice);
		} while (choice == 'c' || choice == 'C');
		goodBye();
	}

	//  A welcome message.
	public void welcome ( )
	{
		System.out.println("\n\n\n\n\t\t\tAre you feeling OUT OF SORTS?\n\n");
		System.out.println("Welcome to the SORTING PROGRAM, a program that will take an Integer ArrayList");
		System.out.println("that is initially unordered, and then order the array using one of 3 quadratic");
		System.out.println("sorting algorithms, or an n log n sort.  These include a Bubble Sort, a Selection");
		System.out.println("Sort, an Insertion Sort, and a Merge Sort.  HAPPY SORTING!\n\n");
	}

	//  Gets the size of the array, from 5 to 10000.
	public int getSize ( )
	{
		System.out.println("\n\n");
		int value = Prompt.getInt("Please enter the number of random integers you would like to generate",5,10000);
		return value;
	}

	//  Gets the max value of the random values to be generated, from 1 to max.  The max should be from 5 to 10000.
	public int getMax ( )
	{
		System.out.println("\n\n");
		int value = Prompt.getInt("Please enter the maximum value that you would like to possibly generate",5,10000);
		return value;
	}

	//  Generates an ArrayList of Integer values, with a size of s, and values from 1 to m.
	public void createList (int s, int m, ArrayList <Integer> a)
	{
		a.clear();
		for(int i = 0; i < s; i++)
		{
			a.add((int)(Math.random() * m) + 1);
		}
	}

	//  Prints the ArrayList of Integer, printing a new line after every 15 values.
	public void printList (ArrayList <Integer> a)
	{
		System.out.println("\n\n");
		for(int i = 0; i < a.size(); i++)
		{
			if(i % 15 == 0)
			{
				System.out.println();
			}
			System.out.printf("%6d",a.get(i).intValue());
		}
		System.out.println("\n\n");
	}

	//  Calls menuOfSorts, getSortType, one of the sorts, then printList and printSteps.
	public char chooseFromMenu (String arraytype, ArrayList <Integer> list)
	{
		menuOfSorts(arraytype);
		return getSortType();
	}

	//  Prints the list of sort options.
	public void menuOfSorts (String title)
	{
		System.out.println("\n\n1. " + title + " Bubble Sort");
		System.out.println("2. " + title + " Selection Sort");
		System.out.println("3. " + title + " Insertion Sort");
		System.out.println("4. " + title + " Merge Sort\n");
	}

	//  Prompts the user to enter a character value from '1' to '4', indicating the sort
	//  to be run.
	public char getSortType ( )
	{
		char value = '0';
		do
		{
			value = Prompt.getChar("Please enter a number choice (1-4) from the list above: ");
		}
		while(value < '1' || value > '4');
		return value;
	}
	
	public void doSort(char choice)
	{
		int steps = 0;
		switch(choice)
		{
			case '1':
				steps = Sorts.bubbleSort(intlist);		break;
			case '2':
				steps = Sorts.selectionSort(intlist);	break;
			case '3':
				steps = Sorts.insertionSort(intlist);	break;
			case '4':
				steps = Sorts.mergeSort(intlist,0,intlist.size()-1);	break;
		}
		printList(intlist);
		printSteps(steps);
	}

	//  Prints the number of steps taken by the sort.
	public void printSteps (int s)
	{
		System.out.printf("%nThe number of steps taken in this sort: %,d%n%n",s);
	}

	//  Prompts the user to enter a 'c' or 'C' to continue, any other character to exit.
	public char repeatOrEnd (char c)
	{
		char value = Prompt.getChar("Enter the letter 'c' to continue with another sort, or 'q' to quit: ");
		return value;
	}

	//  A goodbye message.
	public void goodBye ( )
	{
		System.out.println("\n\n\n\t\tThanks for working with the SORTING PROGRAM.");
		System.out.println("Hopefully, you were able to put your affairs in order(!).  Please run the program again");
		System.out.println("if you're interested in seeing sorting algorithms at work.\n\n\n\n");
	}
}