abstract class Phone
{
	private int IDNumber;
	
	public Phone ( )
	{
		IDNumber = getID();
	}
	
	public abstract double getPrice();
	
	@Override
	public String toString ( )
	{
		return "ID Number: " + IDNumber + "    Price: " + getPrice();
	}
	
	private static int getID ( )
	{
		return (int)(Math.random() * 1000000000);
	}
}

class PreOrder extends Phone
{
	private int daysBeforeDeadline;

	public PreOrder(int days)
	{
		super();
		daysBeforeDeadline = days;
	}

	public double getPrice()
	{
		if (daysBeforeDeadline >= 15)
		{
			return 750.0;
		}
		return 810.0;
	}
}

public class StudentPreOrder extends PreOrder
{
	public StudentPreOrder(int days)
	{
		super(days);
	}
	
	public static void main(String [] args)
	{
		PreOrder bobsPhone = new PreOrder(20);
		System.out.println("\n\n" + bobsPhone + "\n\n");
		PreOrder johnsPhone = new PreOrder(7);
		System.out.println(johnsPhone + "\n\n");
		StudentPreOrder crystalsPhone = new StudentPreOrder(3);
		System.out.println(crystalsPhone + "\n\n");
		StudentPreOrder cindysPhone = new StudentPreOrder(18);
		System.out.println(cindysPhone + "\n\n");
	}

	public double getPrice()
	{
		return 2.0 * super.getPrice() / 3.0;
	}

	@Override
	public String toString()
	{
		return super.toString() + "    (student ID required)";
	}
}