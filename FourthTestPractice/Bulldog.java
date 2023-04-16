public class Bulldog extends Dog
{
	public static final double WEIGHT = 55.0;
	private String food;
	
	public static void main(String [] args)
	{
		Dog fido = new Bulldog("Fido", 1);
		System.out.printf("%n%nName:   %s",fido.getName());
		System.out.printf("%nWeight: %4.2f",fido.getWeight());
		System.out.printf("%nFood:   %s",fido.getFood());
		Dog rex = new Bulldog("Rex", 5);
		System.out.printf("%n%nName:   %s",rex.getName());
		System.out.printf("%nWeight: %4.2f",rex.getWeight());
		System.out.printf("%nFood:   %s",rex.getFood());
		Dog king = new Bulldog("King", 12);
		System.out.printf("%n%nName:   %s",king.getName());
		System.out.printf("%nWeight: %4.2f",king.getWeight());
		System.out.printf("%nFood:   %s%n%n",king.getFood());
	}
	
	public Bulldog(String n, int a)
	{
		super(n,a);
		if(getAge() < 10)
		{
			food = new String("natural grain-free");
		}
		else
		{
			food = new String("adult dry food");
		}
	}
	
	public double getWeight ( )
	{
		if(getAge() < 2)
		{
			return 0.6 * WEIGHT;
		}
		else if(getAge() > 8)
		{
			return 1.1 * WEIGHT;
		}
		return WEIGHT;
	}
	
	public String getFood ( )
	{
		return food;
	}
}

abstract class Dog
{
	private String name;
	private double age;
	
	public Dog(String n, double a)
	{
		name = n;
		age = a;
	}
	
	public String getName ( )
	{
		return name;
	}
	
	public double getAge ( )
	{
		return age;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setAge(double a)
	{
		age = a;
	}
	
	public abstract double getWeight();
	public abstract String getFood();
}