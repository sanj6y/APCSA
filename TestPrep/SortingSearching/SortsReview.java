import java.util.*;

public class SortsReview
{
	
	public static void bubbleSort(ArrayList<Integer> list)
	{
		for (int outer = 0; outer < list.size(); outer++)
		{
			for (int inner = 0; inner < list.size()-outer-1; inner++)
			{
				if (list.get(inner) < list.get(inner+1))
				{
					int temp = list.get(inner);
					list.set(inner, list.get(inner+1));
					list.set(inner+1, temp);
				}
			}
		}
	}

	public static void selectionSort(ArrayList<Integer> list)
	{
		int max, temp;

		for (int outer = list.size(); outer > 1; outer--)
		{
			max = 0;
			for (int inner = 1; inner < outer; inner++)
			{
				if (list.get(inner) > list.get(max))
					max = inner;
			}

			temp = list.get(max);
			list.set(max, list.get(outer-1));
			list.set(outer-1, temp);
		}
	}

	public static void insertionSort(ArrayList<Integer> list)
	{
		for (int outer = 1; outer < list.size(); outer++)
		{
			int position = outer;
			int key = list.get(position);

			while (position > 0 && list.get(position-1) > key)
			{
				list.set(position, list.get(position-1));
				position--;
			}

			list.set(position, key);
		}
	}















}