class Vehicle
{
	private String name;
	public Vehicle ( )
	{
		name = new String("CAR");
	}
	
	public void setName (String n)
	{
		name = new String(n);
	}
	
	public String getName ( )
	{
		return name;
	}
	
	public static String identity ( )
	{
		return "I'm a Vehicle";
	}
}

public class Sporty extends Vehicle
{
	public Sporty ( )
	{
		super();
		setName("TURBOCHARGED " + getName());
	}
	
	public static String identity ( )
	{
		return "I'm Sporty";
	}
	
	public static void main (String [] args)
	{
		Vehicle  redCar = new Vehicle();
		Vehicle  blueCar;
		Sporty  s2000 = new Sporty();
		Sporty  rx7one;
		Sporty  rx7two;
		Sporty  rx7three;
		blueCar = s2000;
//		rx7one = (Sporty) redCar;
		rx7two = (Sporty) blueCar;
		rx7three = (Sporty) s2000;
		System.out.println("\n\n");
		System.out.println(blueCar.getName());
		System.out.println(blueCar.identity());
		System.out.println("\n\n");
//		System.out.println(rx7one.getName());
//		System.out.println(rx7one.identity());
		System.out.println(rx7two.getName());
		System.out.println(rx7two.identity());
		System.out.println(rx7three.getName());
		System.out.println(rx7three.identity());
		System.out.println("\n\n");
	}
}