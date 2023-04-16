public class MomDaughterClient
{
	public static void main (String [] args)
	{
		Mother mom1 = new Mother();
		Mother mom2 = new Mother(45);
		Mother daughter1 = new Daughter(17);
//		Daughter daughter2 = new Daughter();
		Daughter daughter3 = new Daughter(15);
		System.out.println("\n\n" + mom1);
		System.out.println(mom2);
		System.out.println(daughter1);
//		System.out.println(daughter2);
		System.out.println(daughter3);
		System.out.println("\n\n");
	}
}

class Mother
{
	private int number;
	
	public Mother ( )
	{
		number = 40;
	}
	
	public Mother (int n)
	{
		number = n;
	}
	
	public int getNumber ( )
	{
		return number;
	}
	
	public String toString ( )
	{
		return "Mother : " + number;
	}
}

class Daughter extends Mother
{
	public Daughter(int num)
	{
		super(num);
	}
	
	public String toString ( )
	{
		return "Daughter: " + getNumber();
	}
}