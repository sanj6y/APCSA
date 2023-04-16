class Halloween 
{
	public static void spook() 
	{	System.out.println("Halloween spooky");	}
	public void outfit()
	{	System.out.println("Halloween outfit");	}
}

class Ghost extends Halloween 
{
	public static void spook()
	{	System.out.println("Ghost spooky");		}
	public void outfit()
	{	System.out.println("Ghost outfit");		}
}

public class Casper extends Ghost
{
	public static void spook()
	{	System.out.println("Casper friendly");	}
	public void outfit()
	{	System.out.println("Casper outfit");	}
	
	public static void main(String[] args)
	{
		Halloween spook1 = new Casper();
		spook1.spook();
		spook1.outfit();
		
		Halloween spook2 = new Ghost();
		spook2.spook();
		spook2.outfit();
		
		Ghost spook3 = new Ghost();
		spook3.spook();
		spook3.outfit();
		
		Casper spook4 = new Casper();
		spook4.spook();
		spook4.outfit();
	}
}
