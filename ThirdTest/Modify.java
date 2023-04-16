public class Modify
{
	public static void main (String [] args)
	{
		Modify run = new Modify();
		run.modifyThings();
	}
	
	public void modifyThings ( )
	{
		String [] elect = {"Vote", "GOP", "Donkey"};
		modifyArray(elect);
		System.out.println(elect[0] + "  " + elect[1] + "  " + elect[2]);
		modArrayAgain(elect);
		System.out.println(elect[0] + "  " + elect[1] + "  " + elect[2]);
		modArrayAnotherTime(elect);
		System.out.println(elect[0] + "  " + elect[1] + "  " + elect[2]);
	}
	
	public void modifyArray(String [] a)
	{
		String temp = "Politics";
		a[0] = a[1];
		a[1] = a[2];
		a[2] = temp;
		System.out.println(a[0] + "  " + a[1] + "  " + a[2]);
	}
	
	public void modArrayAgain(String [] arr)
	{
		String [] array = {"House", "Senate", "Campaign"};
		arr = array;
		System.out.println(arr[0] + "  " + arr[1] + "  " + arr[2]);
	}
	
	public void modArrayAnotherTime(String [] array)
	{
		array[0].toUpperCase();
		array[1] = array[1].substring(2,6);
		array[2] = array[2].substring(3);
		System.out.println(array[0] + "  " + array[1] + "  " + array[2]);
	}
}