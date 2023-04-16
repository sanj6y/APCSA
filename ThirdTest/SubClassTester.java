public class SubClassTester
{
	public static void main(String [] args)
	{
		SuperClass sup = new SuperClass();
		sup.printSomething();
		SubClass sub = new SubClass();
		sub.printSomething();
	}
}

class SuperClass
{
	public void printSomething ( )
	{
		System.out.println("\n\n\nI'm from the SUPERClass!\n\n\n");
	}
}

class SubClass extends SuperClass
{
	public void printSomething()
	{
		System.out.println("\n\n\nI'm from the SUBClass!\n\n\n");
	}
}