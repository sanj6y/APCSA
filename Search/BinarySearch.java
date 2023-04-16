public class BinarySearch
{
    public static final int NOT_FOUND = -1;
    
    // Test program
    public static void main(String [] args)
    {
		BinarySearch run = new BinarySearch();
		run.lookForIt();
    }
	
	public void lookForIt ( )
	{
		System.out.println("\n\n\n");
        int SIZE = Prompt.getInt("Choose the number of elements to be created in your array", 5, 50);
        Integer [] a = new Integer[SIZE];
        for(int i = 0; i < SIZE; i++)
		{
            a[i] = (int)(Math.random() * SIZE * 4) + 1;
		}
		
		insertionSort(a);
		System.out.println("\n\n\n");
		printArray(a);

		System.out.println("\n\n\n");
		int valueToLookFor = -1;
		while(valueToLookFor != 0)
		{
			valueToLookFor = Prompt.getInt("Enter a value to be searched, or 0 to exit", 0, SIZE * 4);
			if(valueToLookFor != 0)
			{
				System.out.println("\nFound the value " + valueToLookFor + " at index " + 
						binarySearch(a, valueToLookFor) + "\n");
			}
		}
		System.out.println("\nGoodbye!\n\n\n");
	}
	
    /**
     * Performs the standard binary search
     * using two comparisons per level.
     * @return index where item is found, or NOT_FOUND.
     */
    public static int binarySearch(Integer [] a, Integer x)
    {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while(low <= high)
        {
            mid = (low + high) / 2;

            if(a[mid].compareTo(x) < 0)
			{
                low = mid + 1;
			}
            else if(a[mid].compareTo(x) > 0)
			{
                high = mid - 1;
			}
            else
			{
                return mid;
			}
        }

        return NOT_FOUND;     // NOT_FOUND = -1
    }
	
	
	public static void insertionSort (Integer [] array)
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
		}
	}
	
	public static void printArray (Integer [] arr)
	{
		int counter = 0;
		for(int i = 0; i < arr.length; i++)
		{
			if(counter % 15 == 0)
			{
				System.out.println();
			}
			System.out.printf("%-6d",arr[i]);
			counter++;
		}
		System.out.println();
	}
}