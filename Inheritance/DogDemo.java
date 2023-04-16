public class DogDemo   
{
	public static void main ( String [] args )   
	{
		Dog fido = new UnderDog();
		System.out.println("\n\n\n");
		fido.act();
		System.out.println("\n\n\n");
	}
}

class Dog   
{
	public void act()   
	{
		System.out.print("run ");
		eat();
	}

	public void eat()   
	{
		System.out.print("eat ");
	}
}

class UnderDog extends Dog   
{
	public void act()   
	{
		super.act();
		System.out.print("sleep ");
	}

	public void eat()   
	{
		super.eat();
		System.out.print("bark ");
	}
}