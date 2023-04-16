public class ThingClient
{
	public static void main (String [] args)
	{
		System.out.println("\n\n\n");
		ThingOne th1 = new ThingOne();
		th1.methodOne();
//		th1.methodTwo();
		System.out.println();
		
		ThingTwo th2 = new ThingTwo();
		th2.methodOne();
		th2.methodTwo();
		System.out.println();
		
		ThingOne th3 = new ThingTwo();
		th3.methodOne();
//		th3.methodTwo();
		System.out.println("\n\n\n");
	}
}

class ThingOne
{
	public void methodOne ( )
	{
		System.out.println("Thing One!");
	}
}

class ThingTwo extends ThingOne
{
	public void methodTwo ( )
	{
		System.out.println("Thing Two!");
	}
}