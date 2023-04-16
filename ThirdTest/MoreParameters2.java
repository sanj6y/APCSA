public class MoreParameters2
{
	public static void main (String [] args)
	{
		MoreParameters2 run = new MoreParameters2();
		run.changeArray();
	}
	
	public void changeArray ( )
	{
		int [] array = {8, 33, 52};
		printArray(array);
		changeArrayOne(array);
		printArray(array);
		changeArrayTwo(array);
		printArray(array);
	}
	
	public void printArray (int [] arr)
	{
		System.out.println(arr[0] + "  " + arr[1] + "  " + arr[2]);
	}
	
	public void changeArrayOne (int [] arr)
	{
		arr[1] = arr[2];
		arr[2] = arr[0];
		arr[0] = arr[1];
		printArray(arr);
	}
	
	public void changeArrayTwo (int [] arr)
	{
		arr = new int[3];
		arr[0] = 9;
		arr[1] = 13;
		arr[2] = 17;
		printArray(arr);
	}
}