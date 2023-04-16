import java.util.ArrayList;
import java.util.Arrays;

public class PracticeQuizProblems
{
	public static void main(String [] args)
	{
		PracticeQuizProblems run = new PracticeQuizProblems();
		run.methods();
	}
	
	public void methods ( )
	{
		animals();
		indexPlay();
		int [] array = {5, 6, 7, 8, 9};
		array = elementMixer(array);
		printArray(array);
	}
	
	public void animals ( )
	{
		System.out.println("\n\n");
		ArrayList<String> animals = new ArrayList<String>(Arrays.asList("bear", "zebra", "bass", "cat", "koala", "baboon"));
		
		System.out.println(animals);
		for(int k = animals.size() - 1; k > 0; k--)
		{
			if(animals.get(k).substring(0,1).equals("b"))
			{
				animals.add(animals.size() - k, animals.remove(k));
			}
			System.out.println(animals);
		}
//		System.out.println(animals);
	}
	
	public void indexPlay ( )
	{
		System.out.println("\n\n");
		int [] array = {4,3,2,1,0};
	
		for (int k = array.length-1; k >= 0; k--)
		{
			array[k] = array[array[k]];
		}
	
		for (int k = 0; k < array.length; k++)
		{
			System.out.print(array[k] + "  ");
		}
	}
	
	public int [] elementMixer (int [] arr)
	{
		int [] result = new int[arr.length];
		for (int s = 0; s < arr.length - 1; s++)
		{
			result[s] = arr[arr.length - 1 - s];
			result[s + 1] = arr[s];
		}
		return result;
	}

	public void printArray(int [] arr)
	{
		System.out.println("\n\n");
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + "   ");
		}
		System.out.println("\n\n\n");
	}
}