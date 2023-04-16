
/**
 *  Arranger.java
 *  A sampling of methods that manipulate ArrayLists. These include:
 *  (1) A swap method that swaps two Strings in an ArrayList.
 *  (2) An inOrder method that returns true if a String ArrayList is
 *  in non-decreasing order, false otherwise.
 *  (3) A reverse method that takes an Integer ArrayList and creates
 *  a new ArrayList in reverse order, then returns this ArrayList.  The
 *  original ArrayList remains unchanged.
 *  (4) A removeLeast method that finds and removes the least
 *  Double in an ArrayList, using the compareTo method in Double.
 *  (5) A removeDuplicates method that removes duplicate Strings
 *  in an ArrayList passed as an argument.  
 *  (6) A rotateRight method that rotates all elements of an ArrayList
 *  of Integer n spots to the right, with "overflow" elements being
 *  wrapped around to the start of the ArrayList.
 *  A main method is provided to test each of these methods.
 *  @author Sanjay Chandrasekar
 *  @version 1.0
 *  @since 11/23/2021
 */
 
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.LinkedHashSet;
 
public class Arranger
{
	/**    The ArrayList of String to be used in tasks (1), (2), and (5) above   */
	private ArrayList<String> elements;
	
	/**    The ArrayList of Integer to be used in task (3) above   */
	private ArrayList<Integer> numbers;
	
	/**    The ArrayList of Double to be used in task (4) above   */
	private ArrayList<Double> values;
	
	/**    Creates an Arranger object, initializing the 3 ArrayLists with some
	 *     values.
     */
	public Arranger ( )
	{
		elements = new ArrayList<String>(Arrays.asList("Taylor", "Kent", "Vindman", "Williams", "Cooper", "Hale", "Hill", "Holmes"));
		numbers = new ArrayList<Integer>(Arrays.asList(54, 32, 16, 91, 78, 56, 37, 83, 66, 45));
		values = new ArrayList<Double>(Arrays.asList(8.6, 9.0, 4.4, 5.8, 2.3, 1.9, 6.8, 6.2));
	}
	
	public static void main(String [] args)
	{
		Arranger orchestrate = new Arranger();
		orchestrate.run();
	}
	
	/**
	 *  Runs all of the tasks, fully testing them.
	 */
	public void run ( )
	{
		System.out.println("\n\n\n");
		tasksOneAndTwo();
		taskThree();
		taskFour();
		taskFive();
		taskSix();
		System.out.println("\n\n\n");
	}
	
	/**
	 *  Runs tasks (1) and (2), swapping elements of a String ArrayList,
	 *  printing the ArrayList and checking to see if the ArrayList is in order.
	 */
	public void tasksOneAndTwo ( )
	{
		System.out.println("\n\nTASKS (1) AND (2)\n");
		printStringArrayList(elements);
		checkOrder(elements);
		System.out.println();
		System.out.println("Swapping elements at indices 3 and 7:");
		swap(elements,3,7);
		printStringArrayList(elements);
		checkOrder(elements);
		System.out.println();
		System.out.println("Swapping elements at indices 2 and 6:");
		swap(elements,2,6);
		printStringArrayList(elements);
		checkOrder(elements);
		System.out.println();
		System.out.println("Swapping elements at indices 0 and 4:");
		swap(elements,0,4);
		printStringArrayList(elements);
		checkOrder(elements);
		System.out.println();
		System.out.println("Swapping elements at indices 4 and 5:");
		swap(elements,4,5);
		printStringArrayList(elements);
		checkOrder(elements);
		System.out.println();
		System.out.println("Swapping elements at indices 1 and 4:");
		swap(elements,1,4);
		printStringArrayList(elements);
		checkOrder(elements);
		System.out.println();
	}
	
	/**
	 *  Runs task (3), reversing an ArrayList of Integer, printing out both the
	 *  original ArrayList of Integer and the reversed ArrayList of Integer.
	 */
	public void taskThree ( )
	{
		System.out.println("\n\nTASK (3)\n");
		ArrayList<Integer> reversed = reverseArray(numbers);
		System.out.println("The original ArrayList:");
		printIntegerArrayList(numbers);
		System.out.println();
		System.out.println("The reversed ArrayList:");
		printIntegerArrayList(reversed);
		System.out.println();
	}
	
	/**
	 *  Runs task (4), removing the least value in an ArrayList of Double.
	 */
	public void taskFour ( )
	{
		System.out.println("\n\nTASK (4)\n");
		System.out.println("The original ArrayList:");
		printDoubleArrayList(values);
		System.out.println();
		System.out.println("The ArrayList with the least value removed:");
		removeLeast(values);
		printDoubleArrayList(values);
		System.out.println();
		System.out.println("The ArrayList with the least value removed:");
		removeLeast(values);
		printDoubleArrayList(values);
		System.out.println();
		System.out.println("The ArrayList with the least value removed:");
		removeLeast(values);
		printDoubleArrayList(values);
		System.out.println();
		System.out.println("The ArrayList with the least value removed:");
		removeLeast(values);
		printDoubleArrayList(values);
		System.out.println();
	}
	
	/**
	 *  Runs task (5), removing duplicate Strings from an ArrayList of String.
	 */
	public void taskFive ( )
	{
		System.out.println("\n\nTASK (5)\n");
		elements.add(1,"Sondland");
		elements.add(4,"Sondland");
		elements.add(7,"Sondland");
		elements.add(3,"Volker");
		elements.add(4,"Volker");
		System.out.println("The original ArrayList:");
		printStringArrayList(elements);
		System.out.println();
		System.out.println("The ArrayList with duplicates removed:");
		removeDuplicates(elements);
		printStringArrayList(elements);
		System.out.println();
	}
	
	/**
	 *  Runs task (6), rotating an ArrayList of Integer, printing out both the
	 *  original ArrayList of Integer and the rotated ArrayList of Integer.
	 */
	public void taskSix ( )
	{
		System.out.println("\n\nTASK (6)\n");
		System.out.println("The original ArrayList:");
		printIntegerArrayList(numbers);
		System.out.println();
		System.out.println("The rotated right ArrayList:");
		rotateRight(numbers);
		printIntegerArrayList(numbers);
		System.out.println();
		System.out.println("The rotated left ArrayList:");
		rotateLeft(numbers);
		printIntegerArrayList(numbers);
		System.out.println();
		System.out.println("The rotated (3 spots) ArrayList:");
		rotateRight(numbers,3);
		printIntegerArrayList(numbers);
		System.out.println();
		System.out.println("The rotated (1 spot) ArrayList:");
		rotateRight(numbers,1);
		printIntegerArrayList(numbers);
		System.out.println();
		System.out.println("The rotated (5 spots) ArrayList:");
		rotateRight(numbers,5);
		printIntegerArrayList(numbers);
		System.out.println();
		System.out.println("The rotated (-5 spots) ArrayList:");
		rotateRight(numbers,-5);
		printIntegerArrayList(numbers);
		System.out.println();
	}
	
	/** 
	 *  Checks to see if the Strings in the ArrayList are in lexicographic order,
	 *  printing a message for either case.
	 *  @param arr        The ArrayList of String to be checked for order
	 */
	public void checkOrder(ArrayList<String> arr)
	{
		if(inOrder(arr))
		{
			System.out.println("The ArrayList is IN ORDER");
		}
		else
		{
			System.out.println("The ArrayList is NOT in order");
		}
	}
	
	/** 
	 *  Checks to see if the Strings in the ArrayList are in lexicographic order,
	 *  returning true if they are in order, false otherwise.
	 *  @param arr        The ArrayList of String to be checked for order
	 *  @return           true for an ordered ArrayList, false otherwise
	 */
	public boolean inOrder(ArrayList<String> arr)
	{
		for (int i = 1; i < arr.size(); i++)
		{
			if (arr.get(i).compareTo(arr.get(i-1)) < 1)
			{
				return false;
			}
		}

		return true;
		//  TO BE COMPLETED BY YOU.
	}
	
	/** 
	 *  Prints the ArrayList of String.
	 *  @param arr        The ArrayList of String to be printed
	 */
	public void printStringArrayList(ArrayList<String> arr)
	{
		for(int i = 0; i < arr.size(); i++)
		{
			System.out.printf("%-10d", i);
		}
		System.out.println();
		for(String s : arr)
		{
			System.out.printf("%-10s", s);
		}
		System.out.println();
	}
	
	/** 
	 *  Swaps the ArrayList of String elements, as indicated by the index
	 *  values that are passed in as arguments.
	 *  @param arr        The ArrayList of String to be modified (two elements swapped)
	 *  @param i          The first index of the String element to be swapped
	 *  @param j          The second index of the String element to be swapped
	 */
	public void swap(ArrayList<String> arr, int i, int j)
	{
		Collections.swap(arr, i, j);
		//  TO BE COMPLETED BY YOU.
	}
	
	/** 
	 *  Creates an ArrayList of Integer.  This ArrayList of Integer is the
	 *  reverse of the ArrayList of Integer passed as an argument.  The
	 *  reversed ArrayList of Integer is returned.
	 *  @param arr        The ArrayList of Integer to be reversed
	 *  @return           The reversed ArrayList of Integer
	 */
	public ArrayList<Integer> reverseArray(ArrayList<Integer> arr)
	{
		ArrayList<Integer> result = new ArrayList<Integer>(arr);
		Collections.reverse(result);
		return result;
		//  TO BE COMPLETED BY YOU.
	}
	
	/** 
	 *  Prints the ArrayList of Integer.
	 *  @param arr        The ArrayList of Integer to be printed
	 */
	public void printIntegerArrayList(ArrayList<Integer> arr)
	{
		for(int i = 0; i < arr.size(); i++)
		{
			System.out.printf("%-5d", i);
		}
		System.out.println();
		for(Integer num : arr)
		{
			System.out.printf("%-5d", num.intValue());
		}
		System.out.println();
	}
	
	/** 
	 *  Removes the least value from the ArrayList of Double.
	 *  @param arr        The ArrayList of Double to be changed (least value removed)
	 */
	public void removeLeast(ArrayList<Double> arr)
	{
		arr.remove(arr.indexOf(Collections.min(arr)));
		//  TO BE COMPLETED BY YOU.
	}
	
	/** 
	 *  Prints the ArrayList of Double.
	 *  @param arr        The ArrayList of Double to be printed
	 */
	public void printDoubleArrayList(ArrayList<Double> arr)
	{
		for(int i = 0; i < arr.size(); i++)
		{
			System.out.printf("%-8d", i);
		}
		System.out.println();
		for(Double num : arr)
		{
			System.out.printf("%-8.2f", num.doubleValue());
		}
		System.out.println();
	}
	
	/** 
	 *  Removes duplicates from an ArrayList of String
	 *  @param arr        The ArrayList of String to be changed (duplicates removed)
	 */
	public void removeDuplicates(ArrayList<String> arr)
	{
		/**
		Object[] array = arr.toArray();
		for (Object str : array)
		{
			if (arr.indexOf(str) != arr.lastIndexOf(str))
			{
				arr.remove(arr.lastIndexOf(str));
			}
		}
		*/
		for (int i = 0; i < arr.size(); i++)
		{
			for (int j = i+1; j < arr.size(); j++)
			{
				if (arr.get(j).equals(arr.get(i)))
				{
					arr.remove(j);
				}
			}
		}
		//  TO BE COMPLETED BY YOU.
	}
	
	/** 
	 *  Rotates an ArrayList of Integer 1 step to the right, with the last element
	 *  wrapped around to the first spot in the ArrayList of Integer.
	 *  @param arr        The ArrayList of Integer to be changed (shifted one to the right)
	 */
	public void rotateRight(ArrayList<Integer> a)
	{
		a.add(0, a.remove(a.size() - 1));
		//  TO BE COMPLETED BY YOU.
	}
	
	/** 
	 *  Rotates an ArrayList of Integer 1 step to the left, with the first element
	 *  wrapped around to the last spot in the ArrayList of Integer.
	 *  @param arr        The ArrayList of Integer to be changed (shifted one to the left)
	 */
	public void rotateLeft(ArrayList<Integer> a)
	{
		a.add(a.remove(0));
		//  TO BE COMPLETED BY YOU.
	}

	/** 
	 *  Rotates an ArrayList of Integer n steps to the right, with the last elements
	 *  wrapped around to the beginning of the ArrayList of Integer.
	 *  @param arr        The ArrayList of Integer to be changed (shifted n steps to the right)
	 *  @param n          The number of steps that the ArrayList is shifted to the right
	 */
	public void rotateRight(ArrayList<Integer> a, int n)
	{
		if (n > 0)
		{
			for (int i = 0; i < n; i++)
			{
				rotateRight(a);
			}
		}
		else
		{
			for (int i = -n; i > 0; i--)
			{
				rotateLeft(a);
			}
		}

		//  TO BE COMPLETED BY YOU.
	}
}
 
/*

C:\ArrayList> java Arranger






TASKS (1) AND (2)

0         1         2         3         4         5         6         7
Taylor    Kent      Vindman   Williams  Cooper    Hale      Hill      Holmes
The ArrayList is NOT in order

Swapping elements at indices 3 and 7:
0         1         2         3         4         5         6         7
Taylor    Kent      Vindman   Holmes    Cooper    Hale      Hill      Williams
The ArrayList is NOT in order

Swapping elements at indices 2 and 6:
0         1         2         3         4         5         6         7
Taylor    Kent      Hill      Holmes    Cooper    Hale      Vindman   Williams
The ArrayList is NOT in order

Swapping elements at indices 0 and 4:
0         1         2         3         4         5         6         7
Cooper    Kent      Hill      Holmes    Taylor    Hale      Vindman   Williams
The ArrayList is NOT in order

Swapping elements at indices 4 and 5:
0         1         2         3         4         5         6         7
Cooper    Kent      Hill      Holmes    Hale      Taylor    Vindman   Williams
The ArrayList is NOT in order

Swapping elements at indices 1 and 4:
0         1         2         3         4         5         6         7
Cooper    Hale      Hill      Holmes    Kent      Taylor    Vindman   Williams
The ArrayList is IN ORDER



TASK (3)

The original ArrayList:
0    1    2    3    4    5    6    7    8    9
54   32   16   91   78   56   37   83   66   45

The reversed ArrayList:
0    1    2    3    4    5    6    7    8    9
45   66   83   37   56   78   91   16   32   54



TASK (4)

The original ArrayList:
0       1       2       3       4       5       6       7
8.60    9.00    4.40    5.80    2.30    1.90    6.80    6.20

The ArrayList with the least value removed:
0       1       2       3       4       5       6
8.60    9.00    4.40    5.80    2.30    6.80    6.20

The ArrayList with the least value removed:
0       1       2       3       4       5
8.60    9.00    4.40    5.80    6.80    6.20

The ArrayList with the least value removed:
0       1       2       3       4
8.60    9.00    5.80    6.80    6.20

The ArrayList with the least value removed:
0       1       2       3
8.60    9.00    6.80    6.20



TASK (5)

The original ArrayList:
0         1         2         3         4         5         6         7         8         9         10        11        12
Cooper    Sondland  Hale      Volker    Volker    Hill      Sondland  Holmes    Kent      Sondland  Taylor    Vindman   Williams

The ArrayList with duplicates removed:
0         1         2         3         4         5         6         7         8         9
Cooper    Sondland  Hale      Volker    Hill      Holmes    Kent      Taylor    Vindman   Williams



TASK (6)

The original ArrayList:
0    1    2    3    4    5    6    7    8    9
54   32   16   91   78   56   37   83   66   45

The rotated right ArrayList:
0    1    2    3    4    5    6    7    8    9
45   54   32   16   91   78   56   37   83   66

The rotated left ArrayList:
0    1    2    3    4    5    6    7    8    9
54   32   16   91   78   56   37   83   66   45

The rotated (3 spots) ArrayList:
0    1    2    3    4    5    6    7    8    9
83   66   45   54   32   16   91   78   56   37

The rotated (1 spot) ArrayList:
0    1    2    3    4    5    6    7    8    9
37   83   66   45   54   32   16   91   78   56

The rotated (5 spots) ArrayList:
0    1    2    3    4    5    6    7    8    9
32   16   91   78   56   37   83   66   45   54

The rotated (-5 spots) ArrayList:
0    1    2    3    4    5    6    7    8    9
37   83   66   45   54   32   16   91   78   56





C:\ArrayList> 

*/