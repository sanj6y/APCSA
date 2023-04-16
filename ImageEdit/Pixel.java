/**
 * Pixel.java
 * 
 * Represents a single pixel in an image.  Each pixel contains
 * one red int value (0 - 255), one green int value (0 - 255), and
 * one blue int value (0 - 255).  These values are stored in an
 * int array.
 *
 * @author Scott DeRuiter
 * @version 1.0
 * @since 2/13/2022
 */
public class Pixel
{
	/**  The int array used to store the red, green, and blue values          */
	private int [] rgb;

	/** 
	 *  Creates a Pixel object.  This is the no-args constructor.
	 *  The default values are all 0, so that the default rgb value 
	 *  is [0, 0, 0] (black).
	 */
	public Pixel ( )
	{
		rgb = new int [3];
		for(int i = 0; i < rgb.length; i++)
		{
			rgb[i] = 0;
		}
	}

	/** 
	 *  Creates a Pixel object.  This is the 3-args constructor.
	 *  This constructor will use the values passed in the parameter
	 *  list (each one from 0 to 255) to create the red, green, and
	 *  blue values in the array.
	 */
	public Pixel (int r, int g, int b)
	{
		rgb = new int [3];
		rgb[0] = r;
		rgb[1] = g;
		rgb[2] = b;
	}

	/**
	 *  Returns the red value (the first value in the array)
	 *  @return             The red value (first value in the array).
	 */
	public int getRed ( )
	{
		return rgb[0];
	}

	/**
	 *  Returns the green value (the second value in the array)
	 *  @return             The green value (second value in the array).
	 */
	public int getGreen ( )
	{
		return rgb[1];
	}

	/**
	 *  Returns the blue value (the third value in the array)
	 *  @return             The blue value (third value in the array).
	 */
	public int getBlue ( )
	{
		return rgb[2];
	}
	
	/**
	 *  Returns a formatted String, with the red, green, and blue values.
	 *  @return             A String with the red, green, and blue values.
	 */
	public String toString ( )
	{
		return String.format("%3d%4d%4d  ",rgb[0],rgb[1],rgb[2]);
	}
}