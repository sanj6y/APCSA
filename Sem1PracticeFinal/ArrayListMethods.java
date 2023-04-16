import java.util.*;

public class ArrayListMethods
{
	/**
	 * precondition: n > 0
	 * postcondition: Returns an ArrayList object with n Integer values. Each Integer object is created
	 * 				  with a random int in the range from 25 to 100, inclusive.
	 */
	public static ArrayList<Integer> createList(int n)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
		{
			result.add((int)(Math.random() * 76 + 25));
		}

		return result;
	}

	/**
	 * precondition: list is a non-empty ArrayList with Integer objects.
	 * postcondition: Returns the mean of the int values stored in the ArrayList of Integer.
	 */
	public static double getMean(ArrayList<Integer> list)
	{
		double sum = 0;
		for (int i = 0; i < list.size(); i++)
		{
			sum += list.get(i);
		}

		return sum / list.size();
	}

	/**
	 * precondition: list is a non-empty ArrayList with Integer objects. These Integer values are in random order.
	 * postcondition: Returns the median value of list.
	 */
	public static double getMedian(ArrayList<Integer> list)
	{
		Collections.sort(list);
		int middle = list.size() / 2;
		double median = 0.0;
		if (list.size() % 2 == 0)
		{
			median = (double)((list.get(middle) + list.get(middle - 1))) / 2;
		}
		else
		{
			median = list.get(middle);
		}

		return median;
	}

	public static void main(String[] args)
	{
		System.out.println(createList(5));
		System.out.println(getMean((new ArrayList<Integer>(Arrays.asList(10, 18, 17)))));
		System.out.println(getMean((new ArrayList<Integer>(Arrays.asList(10, 15)))));

		System.out.println(getMedian((new ArrayList<Integer>(Arrays.asList(10, 13, 17, 18, 21)))));
		System.out.println(getMedian((new ArrayList<Integer>(Arrays.asList(54, 60, 64, 68, 74, 81, 94)))));
		System.out.println(getMedian((new ArrayList<Integer>(Arrays.asList(10, 11, 13, 16, 19, 21)))));
		System.out.println(getMedian((new ArrayList<Integer>(Arrays.asList(50, 60, 70, 80)))));
	}
}