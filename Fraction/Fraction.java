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
 * @since 11/17/2021
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
     * Calculates and returns an int, representing the rounded
     * value of the Fraction.
     * @return			The fraction rounded to the nearest integer.
     */
    public int round()
    {
		double decVal = ((double)num / denom);
		
		return (int) Math.round(decVal);
	}
	
	/**
	 * Calculates and returns 1 if the Fraction is greater than
	 * Fraction other, -1 if the Fraction is less than Fraction
	 * other, and 0 if the Fraction is equal to Fraction other.
	 * @param other		The other Fraction to compare
	 * @return			An integer corresponding to whether the Fraction
	 * 					is greater, less, or equal to the other Fraction.
	 */
	public int compareTo(Fraction other)
	{
		Fraction res = this.subtract(other);
		res.reduce();
		
		if (res.num > 0)
			return 1;
		else if (res.num < 0)
			return -1;
		else
			return 0;
	}
	
	/**
	 * Calculates and returns an instance of Fraction to the power
	 * passed in as an argument.
	 * @param exp		The exponent to raise the Fraction to.
	 * @return			The Fraction to the power of exp.
	 */
	public Fraction pow(int exp)
	{
		Fraction res = new Fraction(1);
		
		for (int i = 0; i < exp; i++)
		{
			res = res.multiply(this);
		}
		
		return res;
	}
}





