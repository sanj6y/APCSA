import java.util.*;

public class SearchReview
{
	public static void main(String[] args)
	{
		SearchReview run = new SearchReview();
		run.lookForIt();
	}

	public void lookForIt ( )
	{
		System.out.println("\n\n\n");
        int SIZE = Prompt.getInt("Choose the number of elements to be created in your array", 5, 50);
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i = 0; i < SIZE; i++)
		{
            a.add((int)(Math.random() * SIZE * 4) + 1);
		}
		
		Collections.sort(a);
		System.out.println("\n\n\n");
		printArrayList(a);

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

    public static int binarySearch(ArrayList<Integer> list, Integer x)
    {
    	int low = 0;
    	int high = list.size() - 1;
    	int mid;

    	while (low <= high)
    	{
    		mid = (low + high) / 2;

    		if (list.get(mid) == x)
    			return mid;
    		else if (list.get(mid) < x)
    			low = mid + 1;
    		else
    			high = mid - 1;
    	}

    	return -1;
    }

    public static void printArrayList (ArrayList<Integer> arr)
	{
		int counter = 0;
		for(int i = 0; i < arr.size(); i++)
		{
			if(counter % 15 == 0)
			{
				System.out.println();
			}
			System.out.printf("%-6d",arr.get(i));
			counter++;
		}
		System.out.println();
	}
}