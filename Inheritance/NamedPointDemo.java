public class NamedPointDemo   
{
	public static void main (String [] args)   
	{
		System.out.println ( "\n\n\nHEY!\n\n\n" );
		Point hunters = new Point(2,3);
		NamedPoint fred = new NamedPoint(2,3,"FRED");
	}
}

class Point   
{
	private int myX; 	// coordinates
	private int myY;

	public Point ( )   
	{
		myX = 0;
		myY = 0;
	}

	public Point (int a, int b)   
	{
		myX = a;
		myY = b;
	}

	// ... other methods not shown
}

class NamedPoint extends Point   
{
	private String myName;

	public NamedPoint ( )   
	{
		myName = "";
	}

	public NamedPoint (int d1, int d2, String name)   
	{
		myX = d1;		//  How could we change these two lines so that it will compile?
		myY = d2;
		myName = name;
	}
	
	// ... other methods not shown
}



























