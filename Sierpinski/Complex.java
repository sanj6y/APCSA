/**
 * Complex.java
 * 
 * A class to provide a data type for complex
 * numbers, with simplemethods like for addition,
 * subtraction, multiplication, and division.
 *
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 02/04/2022
 */

 public class Complex
 {
	private double real;
	
	private double imaginary;
	
	/* No-args constructor with default as 0 + 0i. */
	public Complex()
	{
		real = 0;
		imaginary = 0;
	}
	
	/* One-arg constructor, with arg being real (r) portion. */
	public Complex(double r)
	{
		real = r;
		imaginary = 0;
	}
	
	/* Two-arg constructor, with args being real (r) and imaginary (i) portions. */
	public Complex(double r, double i)
	{
		real = r;
		imaginary = i;
	}
	
	/* Copy constructor. */
	public Complex(Complex other)
	{
		real = other.real;
		imaginary = other.imaginary;
	}
	
	 /* Finds the sum of the complex number this and c2. */
	public Complex plus(Complex c)
	{
		Complex sum = new Complex(real + c.real, imaginary + c.imaginary);
		return sum;
	}

	public Complex times(Complex other)
	{
		Complex product = new Complex();
		double realPart = real * other.real - imaginary * other.imaginary;
		double imaginaryPart = real * other.imaginary + imaginary * other.real;
		product.real = realPart;
		product.imaginary = imaginaryPart;

		return product;
	}

	/* Returns square of complex number c. */
	public Complex square(Complex c)
	{
		return new Complex(Math.pow(c.real, 2) - Math.pow(c.imaginary, 2),
			2 * c.real * c.imaginary);
	}

	public double abs()
	{
		return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
	}
	
	/* Getter for real part of complex number. */
	public double getReal()
	{
		return real;
	}
	
	/* Getter for imaginary part of complex number. */
	public double getImaginary()
	{
		return imaginary;
	}
 }