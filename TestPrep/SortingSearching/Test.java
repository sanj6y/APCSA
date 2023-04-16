import java.util.*;

public class Test
{
	public static void bubbleSort(ArrayList<Integer> list)
	{
		for (int outer = 0; outer < list.size()-1; outer++)
		{
			for (int inner = 0; inner < list.size()-outer-1; inner++)
			{
				if (list.get(inner) > list.get(inner+1))
				{
					int temp = list.get(inner+1);
					list.set(inner+1, list.get(inner));
					list.set(inner, temp);
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

			int temp = list.get(max);
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

	public static void selectionSort(ArrayList<Integer> list)
	{
		int max, temp;
		for (int outer = list.size(); outer > 1; outer--)
		{
			max = 0;
			for (int inner = 1; inner < outer; inner++)
			{
				if (list,get(inner) > list.get(max))
				{
					max = inner;
				}
			}

			int temp = list.get(max);
			list.set(max, list.get(outer-1));
			list.set(outer-1, temp);
		}
	}

	public static void binarySearch(ArrayList<Integer> list, Integer x)
	{
		int high = list.size() - 1;
		int low = 0;
		int mid;

		while (low <= high)
		{
			mid = (low + high) / 2;

			if (list.get(mid).compareTo(x) == 0)
				return mid;
			else if (list.get(mid).compareTO(x) < 0)
				low = mid + 1;
			else
				high = mid - 1;
		}
	}

	public static void binarySearch(ArrayList<Integer> list, int x)
	{
		int high = list.size() - 1;
		int low = 0;
		int mid;

		while (low <= high)
		{
			mid = (low + high) / 2;

			if (list.get(mid) < (x))
				low = mid + 1;
			else if (list.get(mid) > x)
				high = mid - 1;
			else
				return mid;
		}

		return -1; // not found
	}
}