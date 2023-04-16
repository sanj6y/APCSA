public class ElectionUponUs
{
	public static void main(String [] args)
	{
		ElectionUponUs run = new ElectionUponUs();
		run.campaign();
	}
	
	public void campaign ( )
	{
		String [] choices = {"Biden", "Trump", "President"};
		changeThem(choices);
		System.out.println(choices [0] + "  " + choices[1] + "  " + choices[2]);
		mixThemUp(choices);
		System.out.println(choices [0] + "  " + choices[1] + "  " + choices[2]);
		modifyThem(choices);
		System.out.println(choices [0] + "  " + choices[1] + "  " + choices[2]);
	}
	
	public void changeThem(String [] arr)
	{
		String [] array = {"Pence", "Harris", "VP"};
		arr = array;
		System.out.println(arr[0] + "  " + arr[1] + "  " + arr[2]);
	}
	
	public void mixThemUp(String [] a)
	{
		String temp = "Voting";
		a[2] = a[1];
		a[1] = a[0];
		a[0] = temp;
		System.out.println(a[0] + "  " + a[1] + "  " + a[2]);
	}
	
	public void modifyThem(String [] array)
	{
		array[0].toUpperCase();
		array[1] = array[1].substring(2,4);
		array[2] = array[2].substring(2);
		System.out.println(array[0] + "  " + array[1] + "  " + array[2]);
	}
}