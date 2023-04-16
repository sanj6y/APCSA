public class FractionTester2
{
    public static void main(String [] args)
    {
		FractionTester2 run = new FractionTester2();
		run.testers();

    }
	
	public void testers ( )
	{
        System.out.println("\n\n\n");
        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction(7);
        Fraction f3 = new Fraction(12, -20);
        Fraction f4 = new Fraction(f3);
        Fraction f5 = new Fraction(1, 2);
        Fraction f6 = new Fraction(-4, 7);
        Fraction f7 = new Fraction(2, 3);
		Fraction f8 = new Fraction(9,7);
        Fraction f9 = new Fraction(-11, 17);
        Fraction f10 = new Fraction(11, 17);

		compareThem(f1,f2);
		compareThem(f3,f4);
		compareThem(f4,f5);
		compareThem(f5,f4);
		compareThem(f3,f6);
		compareThem(f6,f3);
		compareThem(f5,f8);
		compareThem(f9,f3);
		compareThem(f7,f10);
		compareThem(f9,f10);
		
        System.out.println("\n");
		
		roundIt(f2);
		roundIt(f6);
		roundIt(f9);
		roundIt(f10);
		f10 = new Fraction(8, 5);
		roundIt(f10);
		f10 = new Fraction(-8, 5);
		roundIt(f10);
		f10 = new Fraction(3, 2);
		roundIt(f10);
		f10 = new Fraction(3, -2);
		roundIt(f10);
		f10 = new Fraction(5, 3);
		roundIt(f10);
		f10 = new Fraction(-5, 3);
		roundIt(f10);
		
        System.out.println("\n");
		
		computePowers(f3, 5);
		computePowers(f7, 4);
		computePowers(f9, 3);
		
        System.out.println("\n\n\n");
	}
	
	public void compareThem(Fraction frac1, Fraction frac2)
	{
		if(frac1.compareTo(frac2) < 0)
		{
			System.out.println(frac1 + " is less than " + frac2);
		}
		else if(frac1.compareTo(frac2) > 0)
		{
			System.out.println(frac1 + " is greater than " + frac2);
		}
		else
		{
			System.out.println(frac1 + " is equal to " + frac2);
		}
	}
	
	public void roundIt(Fraction frac)
	{
		System.out.println(frac + " rounded is: " + frac.round());
	}
	
	public void computePowers(Fraction f, int exp)
	{
		for(int i = 0; i <= exp; i++)
		{
			System.out.println(f + " ^ " + i + " = " + f.pow(i));
		}
	}
}
