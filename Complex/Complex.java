/**
 * Complex.java
 * 
 * A class to provide a data type for complex
 * numbers, with simplemethods like for addition,
 * subtraction, multiplication, and division.
 *
 * @author Scott DeRuiter and Sanjay Chandrasekar
 * @version 1.0
 * @since 10/25/2021
 */

 public class Complex
 {
	/**  The complex number's real component.          */
	private double real;
	
	/**  The complex number's imaginary component.     */
	private double imaginary;
	
	/** 
	 *  Creates a Complex object.  This is the no-args constructor.
	 *  The default values are 0 and 0, so that the default complex 
	 *  number is 0 + 0i.
	 */
	public Complex ( )
	{
		real = 0;
		imaginary = 0;
	}
	
	/** 
	 *  Creates a Complex object.  This is a one-arg constructor.
	 *  The value in the parameter list is used to build the real (r) part, 
	 *  and the imaginary part is set to 0.
	 *  @param r          The real portion of the complex number.
	 */
	public Complex(double r)
	{
		real = r;
		imaginary = 0;
	}
	
	/** 
	 *  Creates a Complex object.  The values in the parameter list are
	 *  used to build the real (r) and imaginary (i) parts.
	 *  @param r          The real portion of the complex number.
	 *  @param i          The imaginary portion of the complex number.
	 */
	public Complex(double r, double i)
	{
		real = r;
		imaginary = i;
	}
	
	/** 
	 *  A copy constructor, creating a Complex object.  The value in the
	 *  parameter list is to be copied.
	 *  @param other      The complex number to be copied.
	 */
	public Complex(Complex other)
	{
		real = other.real;
		imaginary = other.imaginary;
	}
	
	public static void main(String [] args)
	{
		System.out.println("\n\n\n");
		Complex num1 = new Complex();
		Complex num2 = new Complex(4);
		Complex num3 = new Complex(3,4);
		Complex num4 = new Complex(1,-2);
		Complex num5 = new Complex(num3);
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		System.out.println("num3 = " + num3);
		System.out.println("num4 = " + num4);
		System.out.println("num5 = " + num5);
		num5.set(2.4,3.5);
		System.out.println("num5 = " + num5);
		System.out.println("(" + num3 + ")" + " + " + "(" + num4 + ") = " + num3.add(num4));
		System.out.println("(" + num3 + ")" + " - " + "(" + num4 + ") = " + num3.subtract(num4));
		System.out.println("(" + num3 + ")" + " * " + "(" + num4 + ") = " + num3.multiply(num4));
		System.out.println("(" + num3 + ")" + " / " + "(" + num4 + ") = " + num3.divide(num4));
		
		Complex num6 = new Complex(-7);
		Complex num7 = new Complex(-5,11);
		Complex num8 = new Complex(4,-7);
		Complex num9 = new Complex(num7);
		System.out.println("\n\nnum6 = " + num6);
		System.out.println("num7 = " + num7);
		System.out.println("num8 = " + num8);
		System.out.println("num9 = " + num9);
		num9.set(-3.4,6.7);
		System.out.println("num9 = " + num9);
		System.out.println("(" + num6 + ")" + " + " + "(" + num7 + ") = " + num6.add(num7));
		System.out.println("(" + num7 + ")" + " - " + "(" + num8 + ") = " + num7.subtract(num8));
		System.out.println("(" + num7 + ")" + " * " + "(" + num8 + ") = " + num7.multiply(num8));
		System.out.println("(" + num7 + ")" + " / " + "(" + num8 + ") = " + num7.divide(num8));
		System.out.println("\n\n\n");
	}
	
	/**
	 *  Finds the sum of the complex number and other.
	 *  @param other        The other complex number, to be added.
	 *  @return             The sum of the two complex numbers.
	 */
	public Complex add(Complex other)
	{
		Complex sum = new Complex(real + other.real, imaginary + other.imaginary);
		return sum;
	}
	
	/**
	 *  Finds the difference of the complex number and other.
	 *  @param other        The other complex number, to be subtracted.
	 *  @return             The difference of the two complex numbers.
	 */
	public Complex subtract(Complex other)
	{
		Complex difference = new Complex(real - other.real, imaginary - other.imaginary);
		return difference;
	}
	
	/**
	 *  Finds the product of the complex number and other.
	 *  @param other        The other complex number, to be multiplied.
	 *  @return             The product of the two complex numbers.
	 */
	public Complex multiply(Complex other)
	{
		Complex product = new Complex();
		double realPart = real * other.real - imaginary * other.imaginary;
		double imaginaryPart = real * other.imaginary + imaginary * other.real;
		product.set(realPart, imaginaryPart);

		return product;
	}
	
	/**
	 *  Finds the quotient of the complex number and other.
	 *  @param other        The other complex number, the divisor.
	 *  @return             The quotient of the two complex numbers.
	 */
	public Complex divide(Complex other)
	{
		Complex quotient = new Complex();
		double realNum = real * other.real + imaginary * other.imaginary;
		double imaginaryNum = imaginary * other.real - real * other.imaginary;
		double denom = Math.pow(other.real, 2) + Math.pow(other.imaginary, 2);

		quotient.set(realNum/denom, imaginaryNum/denom);

		return quotient;
	}

	/**
	 *  Returns a String representation of the complex number.
	 *  @return         The complex number as a String.
	 */
	public String toString ( )
	{
		return String.format("%5.2f + %5.2fi",real,imaginary);
	}
	
	/**
	 *  Returns the real part of the complex number.
	 *  @return         The real part of the complex number.
	 */
	public double getReal ( )
	{
		return real;
	}
	
	/**
	 *  Returns the imaginary part of the complex number.
	 *  @return         The imaginary part of the complex number.
	 */
	public double getImaginary ( )
	{
		return imaginary;
	}
	
	/**
	 *  Sets the complex number to the number passed in the parameter.
	 *  @param r         The real part of the complex number to be assigned.
	 *  @param i         The imaginary part of the complex number to be assigned.
	 */
	public void set(double r, double i)
	{
		real = r;
		imaginary = i;
	}
 }