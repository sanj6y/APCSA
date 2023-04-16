interface InterfaceA
{
	void method1 ( );
}

abstract class AbstractClass implements InterfaceA
{
/*
	public void method1 ( )
	{
	}
*/
	public abstract void method2();
}

public class AbstractTester extends AbstractClass
{
	public void method1 ( )
	{
	}

	public void method2 ( )
	{
	}
	
	public static void main(String [] args)
	{
		AbstractTester test = new AbstractTester();
		test.method1();
		test.method2();
	}
}