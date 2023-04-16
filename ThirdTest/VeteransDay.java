class Autumn 
{
	public static void cooler() 
	{
		System.out.println("enjoy");
	}
	public void darker() 
	{
		System.out.println("relax");
	}
}
class November extends Autumn 
{
	public static void cooler() 
	{
		System.out.println("Monday free");
	}
	public void darker() 
	{
		System.out.println("long weekend");
	}
}
public class VeteransDay extends November 
{
	public void darker() 
	{
		System.out.println("three days");
	}

	public static void main(String[] args) 
	{
		Autumn leaves = new November();
		leaves.cooler();
		leaves.darker();

		Autumn mist = new VeteransDay();
		mist.cooler();
		mist.darker();
		
		VeteransDay thanksgiving = new VeteransDay();
		thanksgiving.cooler();
		thanksgiving.darker();

		November eat = thanksgiving;
		eat.cooler();
		eat.darker();
	}
}
