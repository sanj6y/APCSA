class GreatGrandma
{
	public static void staticMethod ( )
	{
		System.out.println("Great Granny Here.");
	}
}

class Grandma extends GreatGrandma
{
/*
	public static void staticMethod ( )
	{
		System.out.println("Granny Here.");
	}
*/
}

class Mama extends Grandma
{
	public static void staticMethod ( )
	{
		System.out.println("Mama Here.");
	}
	public void instanceMethod ( )
	{
		System.out.println("Mama.");
	}
}

public class Child extends Mama
{
	public static void staticMethod ( )
	{
		System.out.println("Child Here.");
	}
/*
	public void instanceMethod ( )
	{
		System.out.println("Child.");
	}
*/
	
	public static void main(String [] args)
	{
		Grandma hilda = new Child();
		hilda.staticMethod();
		((Child)hilda).instanceMethod();
	}
}