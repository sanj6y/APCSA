public class ChangingSeasons
{
	public static void main (String [] args)
	{
		ChangingSeasons run = new ChangingSeasons();
		run.morphThem();
	}
	
	public void morphThem ( )
	{
		String leaf = new String("Clover");
		modString(leaf);
		System.out.println(leaf);
		char [] letters = {'A','B'};
		printArray(letters);
		modArrayFirst(letters);
		printArray(letters);
		modArraySecond(letters);
		printArray(letters);
	}
	
	public void modString(String le)
	{
		le.toUpperCase();
		le = le.substring(0,6);
		System.out.println(le);
	}
	
	public void printArray(char [] a)
	{
		System.out.println(a[a.length-2] + "  " + a[a.length-1]);
	}
	
	public void modArrayFirst(char [] a)
	{
		char [] arr1 = a;
		char [] arr2 = {'X','Y'};
		a = arr2;
		printArray(a);
	}
	
	public void modArraySecond(char [] a)
	{
		a = new char[3];
		a[0] = 'G';
		a[1] = 'H';
		a[2] = 'I';
		printArray(a);
	}
}