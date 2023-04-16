/**
 *  State.java
 *  Represents a state from the United States,
 *  with the purpose of storing Covid data for each
 *  state.  Thus, each state should contain
 *  attributes for name, date, total cases, and
 *  new cases.  The compareTo and equals methods
 *  are included, along with toString and a variety 
 *  of accessor methods.  Also, an additional
 *  method to compare States is included.
 *  @author Scott DeRuiter and Sanjay Chandrasekar
 *  @version 1.0
 *  @since 1/10/2022
 */
public class State implements Comparable<State>
{
	/**    The name of the State                                            */
	private String name;
	
	/**    The month (an int from 1 to 12) for this data entry              */
	private int month;
	
	/**    The day of the month (an int from 1 to 31) for this data entry   */
	private int day;
	
	/**    The year for this data entry                                     */
	private int year;
	
	/**    The total number of Covid cases for this state to date           */
	private int totalCases;
	
	/**    The number of new Covid cases for this state                     */
	private int newCases;

	/**
	 *  Constructor for the State object
	 *
	 * @param  d   current date (this is a String of the form MM/DD/YYYY, a value that is parsed)
	 * @param  s   name of the State
	 * @param  tC  number of total cases
	 * @param  nC  number of new cases
	 */
	public State(String d, String s, int tC, int nC)
	{
		month = Integer.parseInt(d.substring(0, d.indexOf('/')));
		day = Integer.parseInt(d.substring(d.indexOf('/') + 1, d.lastIndexOf('/')));
		year = Integer.parseInt(d.substring(d.lastIndexOf('/') + 1));
		name = s;
		totalCases = tC;
		newCases = nC;
	}
	 
	/**
	 *  Gets the name of the State object
	 *
	 * @return    The name of the State
	 */
	public String getName()
	{
		return name;
	}
	 
	/** 
	 *  Compares the names of the States, returning a negative number if
	 *  the calling State is less than the State passed as an argument.  A
	 *  positive number is returned if the calling State is greater than
	 *  the State passed as an argument.  Secondarily, the date is used to 
	 *  compare the States.
	 *  @param other      The State to be compared
	 *  @return           a negative integer, zero, or a positive integer as this State
     *                    is less than, equal to, or greater than the State to be compared
	 */
	 public int compareTo(State other)
	 {
		if (!name.equals(other.name))
		{
			return name.compareTo(other.name);
		}
		else
		{
			if (year != other.year)
				return year - other.year;
			if (month != other.month)
				return month - other.month;
			
			return day - other.day;
		}
	 }

	/**
	 *  Compares two State objects by their dates, then secondarily by their names.
	 *
	 * @param  other        State object to compare to
	 * @return              a negative integer, zero, or a positive integer as this State
     *                    is less than, equal to, or greater than the State to be compared
     * 						by date first, then secondarily by name
	 */
	public int compareToDateThenState(State other)
	{
		if (year != other.year)
			return year - other.year;
		if (month != other.month)
			return month - other.month;
		if (day != other.day)	
			return day - other.day;
		
		return name.compareTo(other.name);
	}

	/**
	 *  Compares two State objects by their newCases, secondarily by their dates.
	 *
	 * @param  other        State object to compare to
	 * @return              positive int if newCases > other.newCases
	 *                      0 if newCases equals other.newCases
	 *                      negative int if newCases < other.newCases
	 */
	public int compareToNewCases(State other)
	{
		if (newCases != other.newCases)
			return newCases - other.newCases;
		
		if (year != other.year)
			return year - other.year;
		if (month != other.month)
			return month - other.month;
		return day - other.day;
	}

	/**
	 *  Compares the State to the specified object
	 *
	 * @param  other        Object object to compare to
	 * @return              true if equal, false otherwise
	 */
	public boolean equals(Object other)
	{
		if (this.compareTo((State) other) != 0)
			return false;
		if (newCases != ((State)other).newCases)
			return false;
		if (totalCases != ((State) other).totalCases)
			return false;
		
		return true;
	}

	/** 
	 *  Returns all of the information for this State as a String.
	 *  @return        The String representing the State
	 */
	public String toString()
	{
		String monthString = "" + month;
		String dayString = "" + day;
		if(month < 10)
		{
			monthString = "0" + month;
		}
		if(day < 10)
		{
			dayString = "0" + day;
		}
		String dateToString = "" + monthString + "/" + dayString + "/" + year;
		return String.format("%-4s %-11s %,10d %,8d",name,dateToString,totalCases,newCases);
	}
}