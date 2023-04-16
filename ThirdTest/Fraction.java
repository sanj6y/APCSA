/**
 * Fraction.java
 * 
 * Represents a fraction with an int numerator (num) 
 * and an int denominator (denom).  Provides methods
 * for addition, subtraction, multiplication, and
 * division of these fractions.
 *
 * @author Maria Litvin
 * @version 1.0
 * @since 10/22/2018
 */

public class Fraction
{
	/**  The numerator of the fraction.          */
    private int num;

	/**  The denominator of the fraction.        */
    private int denom;

	/** 
	 *  Creates a Fraction object.  This is the no-args
	 *  constructor.  The default values are 0 and 1, 
	 *  so that the default Fraction is 0/1.
	 */
    public Fraction()
    {
        this(0,1);
    }

	/** 
	 *  Creates a Fraction object.  This is the one-arg
	 *  constructor.  Takes a single integer as the numerator
	 *  and the denominator is set at 1, so that the 
	 *  fraction value is n/1.
	 *  @param n          The numerator of the fraction.
	 */
    public Fraction(int n)
    {
        this(n,1);
    }

	/** 
	 *  Creates a Fraction object.  This is the two-arg
	 *  constructor.  Takes the first integer as the numerator
	 *  and the second integer as the denominator, so that the 
	 *  fraction value is n/d.
	 *  @param n          The numerator of the fraction.
	 *  @param d          The denominator of the fraction.
	 */
    public Fraction(int n, int d)
    {
        if (d != 0)
        {
            num = n;
            denom = d;
            reduce();
        }
        else
        {
            throw new IllegalArgumentException(
                "Fraction construction error: denominator is 0");
        }
    }

	/** 
	 *  Creates a Fraction object.  This is the copy
	 *  constructor.  Takes another Fraction (other)
	 *  and copies its values.
	 *  @param other       The fraction to be copied.
	 */
    public Fraction(Fraction other)
    {
        this(other.num,other.denom);
    }

	/** 
	 *  The main method, to test the constructors and
	 *  methods of the Fraction class.
	 */
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
        Fraction quotient2 = f5.divide2(f6);
        System.out.println(f5 + " / " + f6 + " = " + quotient2);
        System.out.println();
	
        Fraction f7 = new Fraction(2, 3);
        System.out.printf(f7 + " = %6.3f", f7.getValue());
        System.out.println("\n\n");
		Fraction f8 = new Fraction(9,7);
		System.out.println(f8 + " -> " + f8.returnRoundedReciprocal());
		f8 = new Fraction(2,1);
		System.out.println(f8 + " -> " + f8.returnRoundedReciprocal());
		f8 = new Fraction(19,9);
		System.out.println(f8 + " -> " + f8.returnRoundedReciprocal());
		f8 = new Fraction(19,10);
		System.out.println(f8 + " -> " + f8.returnRoundedReciprocal());
		f8 = new Fraction(3,14);
		System.out.println(f8 + " -> " + f8.returnRoundedReciprocal());
		f8 = new Fraction(2,3);
		System.out.println(f8 + " -> " + f8.returnRoundedReciprocal());
		f8 = new Fraction(-3,4);
		System.out.println(f8 + " -> " + f8.returnRoundedReciprocal());
		f8 = new Fraction(-3,5);
		System.out.println(f8 + " -> " + f8.returnRoundedReciprocal());
		f8 = new Fraction(-2,3);
		System.out.println(f8 + " -> " + f8.returnRoundedReciprocal());
		f8 = new Fraction(-19,9);
		System.out.println(f8 + " -> " + f8.returnRoundedReciprocal());
		f8 = new Fraction(-19,10);
		System.out.println(f8 + " -> " + f8.returnRoundedReciprocal());
		f8 = new Fraction(-2,7);
		System.out.println(f8 + " -> " + f8.returnRoundedReciprocal());
		f8 = new Fraction(-2,6);
		System.out.println(f8 + " -> " + f8.returnRoundedReciprocal());
        System.out.println("\n\n");
    }

	/**
	 *  Calculates and returns the sum of the fraction and other.
	 *  @param other        The other fraction, to be added.
	 *  @return             The sum of the two fractions.
	 */
    public Fraction add(Fraction other)
    {
//        int newNum = num * other.denom + denom * other.num;
//        int newDenom = denom * other.denom;
//        return new Fraction(newNum, newDenom);

		Fraction result = new Fraction();
		result.num = num * other.denom + denom * other.num;
		result.denom = denom * other.denom;
		result.reduce();
		return result;
    }

	/**
	 *  Calculates and returns the sum of the fraction and the
	 *  integer m.
	 *  @param m            The integer to be added.
	 *  @return             The sum of the fraction and the integer.
	 */
    public Fraction add(int m)
    {
        return new Fraction(num + m * denom, denom);
    }

	/**
	 *  Calculates and returns the difference of the fraction and other.
	 *  @param other        The other fraction, to be subtracted.
	 *  @return             The difference of the two fractions.
	 */
    public Fraction subtract(Fraction other)
    {
        int newNum = num * other.denom - denom * other.num;
        int newDenom = denom * other.denom;
        return new Fraction(newNum, newDenom);
    }
	
	/**
	 *  Calculates and returns the product of the fraction and other.
	 *  @param other        The other fraction, to be multiplied.
	 *  @return             The product of the two fractions.
	 */
    public Fraction multiply(Fraction other)
    {
        return new Fraction(num * other.num, denom * other.denom);
    }

	/**
	 *  Calculates and returns the product of the fraction and
	 *  the integer m.
	 *  @param m            The integer to be multiplied.
	 *  @return             The product of the fraction and the integer.
	 */
    public Fraction multiply(int m)
    {
        return new Fraction(num * m, denom);
    }

	/**
	 *  Calculates and returns the quotient of the fraction and other.
	 *  @param other        The other fraction, the divisor.
	 *  @return             The quotient of the two fractions.
	 */
    public Fraction divide(Fraction other)
    {
        return new Fraction(num * other.denom, denom * other.num);
    }

	/**
	 *  Calculates and returns the value of the fraction as a
	 *  decimal (double).
	 *  @return             The double value of the fraction.
	 */
    public double getValue()
    {
        return (double)num / (double)denom;
    }

	/**
	 *  Returns the value of the fraction as a String, n/d.
	 *  @return             A String representation of the fraction, n/d.
	 */
    public String toString()
    {
        return num + "/" + denom;
    }

	/**
	 *  Reduces the fraction, if possible.  Looks for a greatest common
	 *  factor between the numerator (num) and denominator (denom).  If
	 *  this gcf is larger than 1, the fraction is reduced.
	 *  Also, if the denominator is negative, the signs of the numerator
	 *  and denominator are changed.
	 */
    private void reduce()
    {
        if (num == 0)
        {
            denom = 1;
            return;
        }
        if (denom < 0)
        {
            num = -num;
            denom = -denom;
        }
        int q = gcf(Math.abs(num), denom);
        num /= q;
        denom /= q;    
    }

	/**
	 *  Calculates and returns the greatest common factor of the 
	 *  two parameter values.
	 *  @param n            The first integer.
	 *  @param d            The second integer.
	 *  @return             The greatest common factor of the two integers.
	 */
    private int gcf(int n, int d)
    {
        if (n <= 0 || d <= 0)
        {
            throw new IllegalArgumentException(
                "gcf precondition failed: " + n + ", " + d);
        }
        if (n % d == 0)
        {
            return d;
        }
        else if (d % n == 0)
        {
            return n;
        }
        else
        {
            return gcf(n % d, d % n);
        }
    }
	
	/**
	 *  Creates and returns the reciprocal of the fraction.
	 *  @return                  The reciprocal fraction
	 */
	public Fraction reciprocal ( )
	{
		Fraction recip = new Fraction(denom, num);
		return recip;
	}

	/**
	 *  Calculates and returns the result of dividing the fraction by other, using the reciprocal method. 
	 *  @param other          The fraction that is to be used as the divisor
	 *  @return                     The fraction resulting in the Fraction being divided by other
	 */
	public Fraction divide2(Fraction other)
	{
		Fraction recip = other.reciprocal();
		return new Fraction(num * recip.num, denom * recip.denom);
	}
	
	/**
	 * Calculates and returns the rounded Fraction for the reciprocal of the given Fraction.
	 * @return        The Fraction that is a rounded version of the reciprocal of the current Fraction.
	 */
	public Fraction returnRoundedReciprocal ( )
	{
		int result = denom / num;
		int remainder = denom % Math.abs(num);
		if(2 * remainder >=  Math.abs(num))
		{
			if(num * denom >= 0)
			{
				result++;
			}
			else if(2 * remainder != Math.abs(num))
			{
				result--;
			}
		}
		return new Fraction(result, 1);
	}
}