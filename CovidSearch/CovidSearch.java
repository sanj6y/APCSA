/**
 *  CovidSearch.java
 *  
 *  A program to use and display information
 * 	about data taken for COVID-19 cases from
 * 	the CDC website throughout the United
 * 	States's various states and territories.
 * 	Reads in data from a .txt file and shows
 * 	various options for user to choose from,
 * 	including displaying data from a single
 * 	state, all COVID data in alphabetical order
 * 	by state, COVID data sorted by new cases,
 * 	and COVID data by date and state.
 * 
 *  @author Scott DeRuiter and Sanjay Chandrasekar
 *  @version 1.0
 *  @since 1/10/2022
 */
 
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class CovidSearch
{
	/**    The ArrayList of the States   */
	private ArrayList<State> states;
	
	/**
	 *  Constructor for the CovidSearch object
	 *  Loads the information from the specified file.
	 *
	 * @param  fName  name of file to opened (contains Covid by-state data)
	 */
	public CovidSearch(String fName)
	{
		states = new ArrayList<State>();
		loadFile(fName);
	}

	/**
	 *  Constructor for the CovidSearch object
	 *  Loads the information from the file "covidCases.txt".
	 */
	public CovidSearch ( )
	{
		this("covidCases.txt");
	}

	/**
	 *  Runs the program
	 */
	public static void main(String [] args)
	{
		CovidSearch run = new CovidSearch("covidCases.txt");
		run.menu();
	}

	/**
	 *  Provides the user with a menu of 4 choices (plus exit).  Prompt
	 *  the user to make a choice, and act on this choice.  Loops until
	 *  the user decides to exit.
	 */
	public void menu ( )
	{
		char choice;
		do
		{
			choice = getUserInput();
			switch(choice)
			{
				case '1':
					mergeSortName(states,0,states.size()-1);
					displayStatesJustOne();
					break;
				case '2':
					insertionSortDateThenState(states);
					displayStates(114);
					break;
				case '3':
					selectionSortNewCases(states);
					displayStates(500);
					break;
				case '4':
					mergeSortName(states,0,states.size()-1);
					searchForData(states);
					break;
			}
		}while(choice >= '1' && choice <= '4');
		goodBye();
	}

	/**
	 *  Prompts the user to enter a char, from the list of '1', '2',
	 *  '3', '4', or '5'.  Keeps asking until one of these is chosen.
	 */
	public char getUserInput ( )
	{
		char choice = '1';
		System.out.println("\n\n1: Display Covid data sorted by date for a single state");
		System.out.println("2: Display Covid data sorted by states (alphabetical) for the last 2 days");
		System.out.println("3: Display Covid data sorted by newCases (least to greatest)");
		System.out.println("4: Search for Covid data by date and state");
		System.out.println("5: Exit");
	
		do
		{
			choice = Prompt.getChar("\nPlease Enter 1 through 5, indicating your choice from the menu above");
		}
		while(choice < '1' || choice > '5');
		return choice;
	}

	/**
	 *  Opens the text file, and creates the State data, saving the information
	 *  into the ArrayList states.  A typical line from covidCases.txt looks like this:
	 *  10/27/2021,GA,1631348,1261729,369619,2011,544,28850,24602,4248,113,20,10/28/2021 02:08:30 PM,Agree,Agree
	 *  This method will pull out the State name (a 2-letter code), the date (a String in the form MM/DD/YYYY), 
	 *  the total number of Covid cases (an int), and the number of new Covid cases (an int).
	 *  Use these values to create a State object, and added to the ArrayList of states.
	 *  @param  inFileName  name of file to opened (contains State data)
	 */
	private void loadFile(String inFileName)
	{
		try
		{
			Scanner inFile = new Scanner(new File(inFileName));
			inFile.nextLine();
			while(inFile.hasNext())
			{
				String temp = inFile.nextLine();
				//  You'll need to parse the input you find in covidCases.txt,
				//  pulling out the 4 pieces of data.
				//  Hint:  Use substring and indexOf (looking for the commas)
				int firstComma = temp.indexOf(',');
				int secondComma = temp.indexOf(',', firstComma + 1);
				int thirdComma = temp.indexOf(',', secondComma + 1);
				int fourthComma = temp.indexOf(',', thirdComma + 1);
				int fifthComma = temp.indexOf(',', fourthComma + 1);
				int sixthComma = temp.indexOf(',', fifthComma + 1);
				String date = temp.substring(0, firstComma);
				String name = temp.substring(firstComma + 1, secondComma);
				int totalCases = Integer.parseInt(temp.substring(secondComma + 1, thirdComma));
				int newCases = Integer.parseInt(temp.substring(fifthComma + 1, sixthComma));
				
				if (name.length() == 2)
					states.add(new State(date, name, totalCases, newCases));
				
			}
		}
		catch(IOException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 *  Displays the state chosen by the user, using an ASCII art frame, and the toString method from the
	 *  State class.
	 */
	public void displayStatesJustOne ( )
	{
		String name = "";
		do
		{
			name = Prompt.getString("\n\nEnter the 2-letter code for the state you would like to view");
			name = name.toUpperCase();
		}
		while(name.length() != 2);
		int counter = 0;
		System.out.println("\n\n\n+----------------------------+");
		System.out.println("| List of State Covid Data   |");
		System.out.println("+---------------------------------------------+");
		System.out.println("|                                             |");
		System.out.println("|     State  Date             Total      New  |");
		for (int i = 0; i < states.size(); i++)
		{
			if(states.get(i).getName().equals(name))
			{
				if (counter % 5 == 0)
				{
					System.out.println("|                                             |");
				}
				System.out.print("|");
				System.out.printf("%5d  ",(counter+1));
				System.out.println(states.get(i) + "  |");
				counter++;
			}
		}
		System.out.println("|                                             |");
		System.out.println("+---------------------------------------------+");
	}

	/**
	 *  Displays the last "number" of elements in the states ArrayList, using an ASCII art frame, 
	 *  and the toString method from the State class.
	 */
	public void displayStates(int number)
	{
		int counter = 0;
		System.out.println("\n\n\n+----------------------------+");
		System.out.println("| List of State Covid Data   |");
		System.out.println("+---------------------------------------------+");
		System.out.println("|                                             |");
		System.out.println("|     State  Date             Total      New  |");
		for (int i = states.size() - number; i < states.size(); i++)
		{
			if (counter % 5 == 0)
			{
				System.out.println("|                                             |");
			}
			System.out.print("|");
			System.out.printf("%5d  ",(counter+1));
			System.out.println(states.get(i) + "  |");
			counter++;
		}
		System.out.println("|                                             |");
		System.out.println("+---------------------------------------------+");
	}

	/**
	 *  A merge sort implementation, sorting the states by State 2-letter code name (primary), and
	 *  date (secondary).
	 */
	public void mergeSortName(ArrayList<State> list, int first, int last)
	{
		if (last - first < 2)
		{
			if (last > first && list.get(last).compareTo(list.get(first)) < 0)
			{
				State listtemp = list.get(last);
				list.set(last, list.get(first));
				list.set(first, listtemp);
				
			}
		}
		
		else
		{
			int middle = (first + last) / 2;
			mergeSortName(list, first, middle);
			mergeSortName(list, middle + 1, last);
			merge(list, first, middle, last);
		}
	}

	/**
	 *  A helper method for the mergeSortName method, merging two "halves" into
	 *  an ordered "whole".
	 */
	private void merge(ArrayList<State> list, int first, int mid, int last)
	{		
		int i = first, j = mid + 1, k = first;
		ArrayList<State> temp = new ArrayList<State>(list);

		while (i <= mid && j <= last)
		{
			if (list.get(i).compareTo(list.get(j)) < 0)
			{
				temp.set(k, list.get(i));
				i++;
			}
			else
			{
				temp.set(k, list.get(j));
				j++;
			}
			k++;
		}
		while (i <= mid)
		{
			temp.set(k, list.get(i));
			i++;
			k++;
		}
		while (j <= last)
		{
			temp.set(k, list.get(j));
			j++;
			k++;
		}		

		for (k = first; k <= last; k++)
		{
			list.set(k, temp.get(k));
		}
	}

	/**
	 *  Swaps the elements in the ArrayList at i and j.
	 */
	private void swap(ArrayList<State> list, int i, int j)
	{
		State temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp); 
	}

	/**
	 *  An insertion sort implementation, sorting the states by date, then by name (2-letter code) secondarily.
	 */
	public void insertionSortDateThenState(ArrayList<State> list)
	{
		for (int outer = 1; outer < list.size(); outer++)
		{
			int position = outer;
			State key = list.get(position);
			
			while (position > 0 && list.get(position - 1).compareToDateThenState(key) > 0)
			{
				list.set(position, list.get(position - 1));
				position--;
				
			}
			list.set(position, key);
		}
	}

	/**
	 *  A selection sort implementation, sorting the states by number of new Covid cases (least to greatest).
	 */
	public void selectionSortNewCases(ArrayList<State> list)
	{
		int max;
		State temp = null;

		for (int outer = list.size(); outer > 1; outer--)
		{
			max = 0;
			for (int inner = 1; inner < outer; inner++)
			{
				if (list.get(inner).compareToNewCases(list.get(max)) > 0)
				{
					max = inner;
					
				}
			}
			temp = list.get(outer - 1);			
			list.set(outer - 1, list.get(max));
			list.set(max, temp);	
		}
	}

	/**
	 *  Searches for a particular State name (2-letter code) and date, exiting when the user enters "-1".
	 */
	public void searchForData(ArrayList<State> list)
	{
		String name = "";
		do
		{
			name = "";
			int day, month, year;
			
			System.out.println("\n\n----------------------------------------------------------------\n");
			
			while (name.length() != 2)
			{
				name = Prompt.getString("\nEnter the 2-letter code for the state you would like to view (-1 to exit)");
			}
			
			if (!name.equals("-1"))
			{			
				month = Prompt.getInt("Enter the month for the date", 1, 12);
				day = Prompt.getInt("Enter the day for the date", 1, 31);
				year = Prompt.getInt("Enter the year for the date", 2020, 2022);
				
				State search = new State(""+month+"/"+day+"/"+year, name.toUpperCase(), 0, 0);
				int ind = binarySearch(list, search);
				System.out.println("\nThe State is:");
				if (ind != -1)
					System.out.println(list.get(ind));
					
				else
					System.out.println("This entry does not exist.");
			}
		} while (!name.equals("-1"));
	}

	/**
	 *  A helper method for the searchForData method, making use of a binary search to find the desired
	 *  State instance.  Also counts and displays the number of steps taken to find the instance.
	 */
	public int binarySearch (ArrayList<State> list, State state)
    {
		int low = 0, high = list.size() - 1;
		int steps = 0;
		while (low <= high)
		{
			int mid = (low + high) / 2;
			steps++;
			if (list.get(mid).compareTo(state) == 0)
			{
				System.out.println("\nThe binary search took " + steps + " steps to find this State.");
				return mid;
			}
			if (list.get(mid).compareTo(state) < 0)
				low = mid + 1;
			else
				high = mid - 1;
		}
		
		System.out.println("\nThe binary search took " + steps + " steps, but was not able to find this State.");
		
		return -1;
    }

	/**
	 *  An exit message.
	 */
	public void goodBye ( )
	{
		System.out.println("\n\nThanks for reviewing the State Search results!\n\n\n");
	}
}
