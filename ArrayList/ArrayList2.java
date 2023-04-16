import java.util.ArrayList; 
import java.util.Iterator; 

public class ArrayList2
{
	private ArrayList <Double> numbers;

	public ArrayList2 ( )
	{
		numbers = new ArrayList <Double>();
	}

	public static void main (String [] args)
	{
		ArrayList2 example = new ArrayList2();
		
		example.assignValues();
		example.printList();
		example.printListAgain();
		example.manipulateArray();
		example.printListLastTime();
	}

	public void assignValues ( )
	{
		numbers.add(23.1);
		numbers.add(18.43);
		numbers.add(1.234);
		numbers.add(1.234);
	}

	public void printList ( )
	{	
		System.out.println("\n\n\n");
		int index = 0;
		while (index < numbers.size())
		{
			System.out.print(numbers.get(index) + "   ");
			index++;
		}
		System.out.println("\n\n\n");
	}

	public void printListAgain ( )
	{
		Iterator iter = numbers.iterator();
		while (iter.hasNext())
			System.out.print(iter.next() + "   ");
		System.out.println("\n\n\n");
	}

	public void manipulateArray ( )
	{
		numbers.remove(1);
		System.out.println(numbers);

		numbers.add(1, 45.298);
		System.out.println(numbers);

		numbers.add(1, 45.298);
		System.out.println(numbers);

		double mydouble = numbers.get(2).doubleValue();
		double mydouble2 = (double)numbers.get(2);
		double mydouble3 = numbers.get(2);
		System.out.println(mydouble + "   " + mydouble2 + "   " + mydouble3);
		System.out.println("\n\n\n");
	}

	public void printListLastTime ( )
	{
		for (Double d : numbers)
			System.out.print(d + "   ");

		System.out.println("\n\n\n");
	}
}