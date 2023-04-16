public class IntSorts
{
	private int [] a;
	private final int size;
	
	public IntSorts ( )
	{
		size = 11;
		a = new int[size];
		fillArray();
	}
	
	public static void main (String [] args)
	{
		IntSorts run = new IntSorts();
		run.showSorts();
	}
	
	public void showSorts ( )
	{
		System.out.println("\n\n\n\nArray before BUBBLE sort:\n");
		printArray();
		System.out.println("\nHere is the BUBBLE sort:\n");
		bubbleSort(a);
		System.out.println("\nArray after BUBBLE sort:\n");
		printArray();
		
		fillArray();
		System.out.println("\n\n\n\nArray before SELECTION sort:\n");
		printArray();
		System.out.println("\nHere is the SELECTION sort:\n");
		selectionSort(a);
		System.out.println("\nArray after SELECTION sort:\n");
		printArray();
		
		fillArray();
		System.out.println("\n\n\n\nArray before INSERTION sort:\n");
		printArray();
		System.out.println("\nHere is the INSERTION sort:\n");
		insertionSort(a);
		System.out.println("\nArray after INSERTION sort:\n");
		printArray();
		
		fillArray();
		System.out.println("\n\n\n\nArray before MERGE sort:\n");
		printArray();
		System.out.println("\nHere is the MERGE sort:\n");
		mergeSort(a,0,a.length-1);
		System.out.println("\nArray after MERGE sort:\n");
		printArray();
		System.out.println("\n\n\n");
	}
	
	public void fillArray ( )
	{
		for(int i = 0; i < a.length; i++)
		{
			a[i] = (int)(1 + Math.random()*100);
		}
	}
	
	public void printArray ()
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.printf("%-6d",a[i]);
		}
		System.out.println();
	}
	
	public static void printArray (int [] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.printf("%-6d",arr[i]);
		}
		System.out.println();
	}
	
	public static void printArray (int [] arr, int from, int to)
	{
		for(int i = 0; i < arr.length; i++)
		{
			if(i >= from && i <= to)
			{
				System.out.printf("%-6d",arr[i]);
			}
			else
			{
				System.out.print("      ");
			}
		}
		System.out.println();
	}

	public static void bubbleSort (int [] array)
	{
		for (int outer = 0; outer < array.length - 1; outer++)
		{
			for (int inner = 0; inner < array.length-outer-1; inner++)
			{
				if (array[inner] > array[inner + 1])
				{
					//swap array[inner] & array[inner+1]
					int temp = array[inner];
					array[inner] = array[inner + 1];
					array[inner + 1] = temp;
				}
			}
			//the next line is not part of the sort
			printArray(array);
		}
	}

	public static void selectionSort (int [] array)
	{
		int max, temp;

		for (int outer = array.length; outer > 1; outer--)
		{
			max = 0;
			for (int inner = 1; inner < outer; inner++)
			{
				if (array[inner] > array[max])
				{
					max = inner; // a new largest item is found
				}
			}
			
			//swap array[outer-1] & array[max]
			temp = array[outer-1];
			array[outer-1] = array[max];
			array[max] = temp;
			//the next line is not part of the sort
			printArray(array);
		}
	}

	public static void insertionSort (int [] array)
	{
		for (int outer = 1; outer < array.length; outer++)
		{
			int position = outer;
			int key = array[position];

			// Shift larger values to the right
			while (position > 0 && array[position - 1] > key)
			{
				array[position] = array[position - 1];
				position--;
			}
			array[position] = key;
			//the next line is not part of the sort
			printArray(array);
		}
	}
	
	public static int mergeSort (int [] a, int from, int to)
	{
		if (to - from < 2)
		{
			if (to > from && a[to] < a[from])
			{
				int atemp = a[to];
				a[to] = a[from];
				a[from] = atemp;
			}
		}
		else
		{
			int middle = (from + to) / 2;
			mergeSort(a, from, middle);
			mergeSort(a, middle + 1, to);
			merge(a, from, middle, to);
		}
		return 1;
	}

	public static int merge (int [] a, int from, int middle, int to)
	{
		int i = from, j = middle + 1, k = from;
		int [] temp = new int [a.length];

		printArray(a,from,to);
		while (i <= middle && j <= to)
		{
			if (a[i] < a[j])
			{
				temp[k] = a[i];
				i++;
			}
			else
			{
				temp[k] = a[j];
				j++;
			}
			k++;
		}
		while (i <= middle)
		{
			temp[k] = a[i];
			i++;
			k++;
		}
		while (j <= to)
		{
			temp[k] = a[j];
			j++;
			k++;
		}
		for (k = from; k <= to; k++)
			a[k] = temp[k];
		printArray(a,from,to);
		return 1;
	}
}