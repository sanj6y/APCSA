class Thanksgiving 
{
	public static void stuffing() 
	{
		System.out.println("yams");
	}
	public void greeting() 
	{
		System.out.println("Tasty");
	}
}
class Dinner extends Thanksgiving 
{
	public static void stuffing() 
	{
		System.out.println("mashed potatoes");
	}
	public void greeting() 
	{
		System.out.println("Autumn");
	}
}
public class Turkey extends Dinner 
{
	public void greeting() 
	{
		System.out.println("Thursday");
	}

	public static void main(String[] args) 
	{
		Thanksgiving eats = new Dinner();
		eats.stuffing();
		eats.greeting();

		Thanksgiving table = new Turkey();
		table.stuffing();
		table.greeting();
		
		Turkey yum = new Turkey();
		yum.stuffing();
		yum.greeting();

		Dinner eat = yum;
		eat.stuffing();
		eat.greeting();
	}
}
