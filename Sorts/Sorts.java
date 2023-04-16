/**
 *  Sorts.java
 *
 *  Implementation for the 3 quadratic sorting algorithms,
 *  including Bubble Sort, Selection Sort, and Insertion Sort.
 *  Also implements the Merge Sort. The methods return the
 *  number of steps taken for each sorting algorithm.
 *
 *  @author Scott DeRuiter and Sanjay Chandrasekar
 *  @version 1.0
 *  @since 1/3/2022
 */
import java.util.ArrayList;

public class Sorts
{
	/**
	 * Static method that takes in an ArrayList and sorts it
	 * using a Bubble Sort algorithm, returning the number of
	 * steps taken.
	 */
	public static int bubbleSort (ArrayList <Integer> list)
	{
		int steps = 0;
		steps++;	// when int outer = 0;
		
		for (int outer = 0; outer < list.size() - 1; outer++)
		{
			steps++;	//	when outer < list.size() - 1; is true
			steps++;	//	when outer++; is called
			steps++;	//	when int inner = 0;
			for (int inner = 0; inner < list.size()-outer-1; inner++)
			{
				steps++;	//	when inner < list.size()-outer-1; is true
				steps++;	//	when inner++; is called
				steps++;	//	when list.get(inner) > list.get(inner + 1) is called
				if (list.get(inner) > list.get(inner + 1))
				{
					steps += 3;	//	when the 3 statements below are called
					int temp = list.get(inner);
					list.set(inner, list.get(inner + 1));
					list.set(inner + 1, temp);
					
				}
			}
			steps++; // when inner < list.size()-outer-1; is false
		}
		steps++;	// when outer < list.size() - 1; is false
		return steps;
	}
	
	/**
	 * Static method that takes in an ArrayList and sorts it
	 * using a Selection Sort algorithm, returning the number of
	 * steps taken.
	 */
	public static int selectionSort (ArrayList <Integer> list)
	{
		int steps = 0;
		steps++;	//	when int outer = list.size();
		steps += 2;	//	when max and temp are declared
		int max, temp;

		for (int outer = list.size(); outer > 1; outer--)
		{
			steps++;	//	when outer > 1; is true
			steps++;	//	when outer--; is called
			steps++;	//	when int inner = 1;
			steps++;	//	when max = 0; is called
			max = 0;
			for (int inner = 1; inner < outer; inner++)
			{
				steps++;	//	when inner < outer; is true
				steps++;	//	when inner++; is called
				steps++;	//	when list.get(inner) > list.get(max) is called
				if (list.get(inner) > list.get(max))
				{
					steps++;	//	when max = inner; is called
					max = inner;
					
				}
			}
			steps++;	//	when inner < outer; is false
			
			steps += 3;	// when the 3 statements below are called
			temp = list.get(outer - 1);			
			list.set(outer - 1, list.get(max));
			list.set(max, temp);
			
		}
		steps++;	//	when outer > 1; is false
		return steps;
	}
	
	/**
	 * Static method that takes in an ArrayList and sorts it
	 * using an Insertion Sort algorithm, returning the number of
	 * steps taken.
	 */
	public static int insertionSort (ArrayList <Integer> list)
	{
		int steps = 0;
		steps++;	//	when int outer = 1;
		
		for (int outer = 1; outer < list.size(); outer++)
		{
			steps++;	//	when outer < list.size(); is true
			steps++;	//	when outer++; is called
			steps += 2;	//	when the 2 statements below are called
			int position = outer;
			int key = list.get(position);
			
			while (position > 0 && list.get(position - 1) > key)
			{
				steps += 2;	//	when position > 0 && list.get(position - 1) > key is true
				steps += 2;	//	when the 2 statements below are called
				list.set(position, list.get(position - 1));
				position--;
				
			}
			steps += 2;	//	when position > 0 && list.get(position - 1) > key is false
			steps++;	//	when the statement below is called
			list.set(position, key);
		}
		steps++;	//	when outer < list.size(); is false
		
		return steps;
	}
	
	/**
	 * Static method that takes in an ArrayList and sorts it
	 * recursively using a Merge Sort algorithm, returning the
	 * number of steps taken.
	 */
	public static int mergeSort (ArrayList<Integer> a, int from, int to)
	{
		int steps = 0;
		
		steps++;	//	when to - from < 2 is called
		if (to - from < 2)
		{
			steps += 2;	//	when to > from && a.get(to) < a.get(from) is called
			if (to > from && a.get(to) < a.get(from))
			{
				steps += 3;	//	when the 3 statements below are called
				int atemp = a.get(to);
				a.set(to, a.get(from));
				a.set(from, atemp);
				
			}
		}
		
		else
		{
			steps +=  4;	//	when the 4 statements below are called
			int middle = (from + to) / 2;
			steps += mergeSort(a, from, middle);
			steps += mergeSort(a, middle + 1, to);
			steps += merge(a, from, middle, to);
		}
		
		return steps;
	}
	
	/**
	 * Static method that merges two halves of an ArrayList together,
	 * used in the process of the Merge Sort algorithm. Returns the
	 * number of steps taken.
	 */
	public static int merge (ArrayList<Integer> a, int from, int middle, int to)
	{
		int steps = 0;
		
		steps += 4;	//	when i, j, k, and temp are declared
		int i = from, j = middle + 1, k = from;
		ArrayList<Integer> temp = new ArrayList<Integer>();

		for (int idx = 0; idx < a.size(); idx++)
		{
			temp.add(0);
		}

		while (i <= middle && j <= to)
		{
			steps += 2;	//	when i <= middle && j <= to is true
			steps++;	//	when a.get(i) < a.get(j) is called
			if (a.get(i) < a.get(j))
			{
				steps += 2;	//	when the 2 statements below are called
				temp.set(k, a.get(i));
				i++;
			}
			else
			{
				steps += 2;	//	when the 2 statements below are called
				temp.set(k, a.get(j));
				j++;
			}
			steps++;	//	when k++; is called
			k++;
		}
		steps += 2;	//	when i <= middle && j <= to is false
		while (i <= middle)
		{
			steps++;	//	when i <= middle is true
			steps += 3;	//	when the 3 statements below are called
			temp.set(k, a.get(i));
			i++;
			k++;
		}
		steps++;	//	when i <= middle is false
		while (j <= to)
		{
			steps++;	//	when j <= to is true
			steps += 3;	//	when the 3 statements below are called
			temp.set(k, a.get(j));
			j++;
			k++;
		}
		steps++;	//	when j <= to is false
		
		steps++;	//	when k = from
		for (k = from; k <= to; k++)
		{
			steps++;	//	when k <= to is true
			steps++;	//	when k++; is called
			steps++;	//	when the statement below is called
			a.set(k, temp.get(k));
		}
		steps++;	//	when k <= to is false
		
		return steps;
	}
}