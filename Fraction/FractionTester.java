public class FractionTester
{
    public static void main(String [] args)
    {
        System.out.println("\n\n");
        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction(7);
        Fraction f3 = new Fraction(12, -20);
        Fraction f4 = new Fraction(f3);
		
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        System.out.println("f3 = " + f3);
        System.out.println("f4 = " + f4);
        System.out.println();
	
        Fraction f5 = new Fraction(1, 2);
        Fraction f6 = new Fraction(4, 7);
        Fraction sum = f5.add(f6);
        System.out.println(f5 + " + " + f6 + " = " + sum);
        Fraction difference = f5.subtract(f6);
        System.out.println(f5 + " - " + f6 + " = " + difference);
        Fraction product = f5.multiply(f6);
        System.out.println(f5 + " * " + f6 + " = " + product);
        Fraction quotient = f5.divide(f6);
        System.out.println(f5 + " / " + f6 + " = " + quotient);
        System.out.println("\n\n");
    }
}