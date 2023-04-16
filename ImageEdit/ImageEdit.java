/**
 * ImageEdit.java
 * 
 * Provides various methods to manipulate
 * images, pixel by pixel, from .ppm files.
 *
 * @author Scott DeRuiter and Sanjay Chandrasekar
 * @version 1.0
 * @since 2/14/2022
 */

import java.util.Scanner;
import java.io.PrintWriter;


public class ImageEdit
{
	/**  The name of the file to be read from, and the name of the file to be created.           */
	private String infilename, outfilename;
	
	/**  The number of columns, number of rows, and the maximum value for the PPM image.         */
	private int column, row, maxval;

	/** 
	 *  Creates an ImageEdit object.  This is the no-args constructor.
	 */
	public ImageEdit ()
	{
		infilename = new String("chloeKim.ppm");
		outfilename = new String("out.ppm");
		column = 400;
		row = 200;
		maxval = 255;
	}

	/** 
	 *  Creates an ImageEdit object.  This is the one-arg constructor.
	 */
	public ImageEdit (String i)
	{
		infilename = new String(i);
		outfilename = new String("out.ppm");
		column = 400;
		row = 200;
		maxval = 255;
	}

	/** 
	 *  Creates an ImageEdit object.  This is the two-args constructor.
	 */
	public ImageEdit (String i, String o)
	{
		infilename = new String(i);
		outfilename = new String(o);
		column = 400;
		row = 200;
		maxval = 255;
	}

	/**
	 *  Creates an instance of ImageEdit using a constructor
	 * 	according to the command-line arguments.
	 */
	public static void main (String [] args)
	{
		ImageEdit image = new ImageEdit();
		image.createImageFile();

		if (args.length == 1)
		{
			image = new ImageEdit(args[0]);
		}
		if (args.length == 2)
		{
			image = new ImageEdit(args[0],args[1]);
		}
		image.manipulate();
	}
	
	/**
	 *  Calls methods to manipulate image according
	 * 	to user input.
	 */
		
	public void manipulate ( )
	{
		
		Pixel [][] imageArray = openFileAndRead();
		greetingAndMenuList();
		String input = new String("");
		input = getInput("Do you want to (1)Flip the image along a central vertical axis? (y/n)   : ");
		if(input.equals("y"))
		{
			imageArray = flipAlongCentralVerticalAxis(imageArray);
		}
		input = getInput("Do you want to (2)Flip the image along a central horizontal axis? (y/n) : ");
		if(input.equals("y"))
		{
			imageArray = flipAlongCentralHorizontalAxis(imageArray);
		}
		input = getInput("Do you want to (3)Convert the image to grayscale? (y/n)                 : ");
		if(input.equals("y"))
		{
			imageArray = goToGrayScale(imageArray);
		}
		input = getInput("Do you want to (4)Convert the image to negative? (y/n)                  : ");
		if(input.equals("y"))
		{
			imageArray = goToNegative(imageArray);
		}
		input = getInput("Do you want to (5)Convert image to extreme contrast? (y/n)              : ");
		if(input.equals("y"))
		{
			imageArray = extremeContrast(imageArray);
		}
		input = getInput("Do you want to (6)Rotate Image 90 Degrees Clockwise? (y/n)              : ");
		if(input.equals("y"))
		{
			imageArray = rotate90Clockwise(imageArray);
		}
		input = getInput("Do you want to (7)Pixelate Image in 20 x 20 Blocks (y/n)                : ");
		if(input.equals("y"))
		{
			imageArray = pixelate(imageArray);
		}
		saveToOutputFile(imageArray);
	}
	
	/**
	 *  Opens .ppm file and reads info from the file, such as number of rows
	 * 	and columns in the image, and returns array of Pixels that make up
	 * 	the image.
	 */
	public Pixel [][] openFileAndRead( )
	{
		// Use OpenFile to open the infilename for reading
		// pick up the "P3" magic number.
		// pick up the number of columns.
		// pick up the number of rows.
		// pick up the maximum integer value.
		// Use a nested loop to pick up the rgb values.
		Scanner sc = OpenFile.openToRead(infilename);
		sc.next();
		column = sc.nextInt();
		row = sc.nextInt();
		maxval = sc.nextInt();
		Pixel [][] tempArray = new Pixel [row][column];
		for (int i = 0; i < tempArray.length; i++)
		{
			for (int j = 0; j < tempArray[i].length; j++)
			{
				tempArray[i][j] = new Pixel(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
		}
		return tempArray;
	}
	
	/**
	 *  Prints a greeting and a list of options
	 * 	to manipulate the image.
	 */
	public void greetingAndMenuList ( )
	{
		System.out.println("\n\n\n");
		System.out.println("WELCOME TO THE PPM IMAGE EDITOR");
		System.out.println("\n\n      Consider the menu of choices below.");
		System.out.println("      (1)Flip Image Along a Central Vertical Axis");
		System.out.println("      (2)Flip Image Along a Central Horizontal Axis");
		System.out.println("      (3)Convert Image to Grayscale");
		System.out.println("      (4)Convert Image to Negative");
		System.out.println("      (5)Convert to Extreme Contrast");
		System.out.println("      (6)Rotate Image 90 Degrees Clockwise");
		System.out.println("      (7)Pixelate Image in 20 x 20 Blocks\n\n");
	}
	
	/**
	 *  Gets user input, either a "y" or an "n",
	 * 	for each option to manipulate the image.
	 */
	public String getInput (String prompt)
	{
		String temp = new String("");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("");
		do
		{
			System.out.print("" + prompt);
			temp = keyboard.nextLine();
		}
		while(!temp.equals("n") && !temp.equals("y"));
		System.out.println("");
		return temp;
	}
	
	/**
	 *  Flips image along central vertical axis.
	 */
	public Pixel [][] flipAlongCentralVerticalAxis(Pixel [][] array)
	{
		Pixel [][] imagearrayResult = new Pixel [array.length][array[0].length];
		
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				imagearrayResult[i][j] = array[i][array[i].length - j - 1];
			}
		}
		
		return imagearrayResult;
	}
	
	/**
	 *  Flips image along central horizontal axis.
	 */
	public Pixel [][] flipAlongCentralHorizontalAxis(Pixel [][] array)
	{
		Pixel [][] imagearrayResult = new Pixel [array.length][array[0].length];
		
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				imagearrayResult[i][j] = array[array.length - 1 - i][j];
			}
		}
		
		return imagearrayResult;
	}
	
	/**
	 *  Converts image to grayscale by finding average of R, G, and B values
	 * 	of each Pixel and setting R, G, and B equal to that average.
	 */
	public Pixel [][] goToGrayScale(Pixel [][] array)
	{
		Pixel [][] imagearrayResult = new Pixel [array.length][array[0].length];
		
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				int avg = (array[i][j].getRed() + array[i][j].getGreen() + array[i][j].getBlue())/3;
				imagearrayResult[i][j] = new Pixel(avg, avg, avg);
			}
		}

		return imagearrayResult;
	}
	
	/**
	 *  Converts image to the negative, by subtracting maxval
	 * 	(typically 255) from R, G, and B of each Pixel and
	 * 	setting that difference equal to new R, G, or B.
	 */
	public Pixel [][] goToNegative(Pixel [][] array)
	{
		Pixel [][] imagearrayResult = new Pixel [array.length][array[0].length];
		
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				imagearrayResult[i][j] = new Pixel(maxval - array[i][j].getRed(), maxval - array[i][j].getGreen(), maxval - array[i][j].getBlue());
			}
		}

		return imagearrayResult;
	}
	
	/**
	 *  Converts image to extreme contrast.
	 */
	public Pixel [][] extremeContrast(Pixel [][] array)
	{
		Pixel [][] imagearrayResult = new Pixel [array.length][array[0].length];
		
		int red = 0, green = 0, blue = 0;
		
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				if (array[i][j].getRed() > maxval/2)
					red = maxval;
				if (array[i][j].getGreen() > maxval/2)
					green = maxval;
				if (array[i][j].getBlue() > maxval/2)
					blue = maxval;
				
				imagearrayResult[i][j] = new Pixel(red, green, blue);
				
				red = 0;
				green = 0;
				blue = 0;
			}
		}
		
		return imagearrayResult;
	}
	
	/**
	 *  Rotates image 90 degrees clockwise.
	 */
	public Pixel [][] rotate90Clockwise(Pixel [][] array)
	{
		Pixel [][] imagearrayResult = new Pixel [array[0].length][array.length];

		for (int i = 0; i < array[0].length; i++)
		{
			for (int j = 0; j < array.length; j++)
			{
				imagearrayResult[i][j] = array[array.length - j - 1][i];
			}
		}
		return imagearrayResult;
	}
	
	/**
	 *  Does a pixelation on 20 x 20 blocks in the image.
	 */
	public Pixel [][] pixelate(Pixel [][] array)
	{
		Pixel [][] imagearrayResult = new Pixel [array.length][array[0].length];
		
		for (int i = 0; i < array.length; i+=20)
		{
			for (int j = 0; j < array[i].length; j+=20)
			{
				int redSum = 0, greenSum = 0, blueSum = 0, pixelCount = 0;
				for (int k = i; k < i + 20 && k < array.length; k++)
				{
					for (int l = j; l < j + 20 && l < array[i].length; l++)
					{
						redSum += array[k][l].getRed();
						greenSum += array[k][l].getGreen();
						blueSum += array[k][l].getBlue();
						pixelCount++;
					}
				}
				
				for (int k = i; k < i + 20 && k < array.length; k++)
				{
					for (int l = j; l < j + 20 && l < array[i].length; l++)
					{
						imagearrayResult[k][l] = new Pixel(redSum / pixelCount, greenSum / pixelCount, blueSum / pixelCount);
					}
				}
			}
		}		
		
		return imagearrayResult;
	}
	
	/**
	 * 	Combines 2 images with "greenscreen technology".
	 */
	public Pixel[][] greenScreen(Pixel[][] greenPic, Pixel[][] array)
	{
		Pixel [][] imagearrayResult = new Pixel [array.length][array[0].length];
		
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				if (greenPic[i][j].getGreen() > greenPic[i][j].getRed() + greenPic[i][j].getBlue())
				{
					imagearrayResult[i][j] = array[i][j];
				}
				else
				{
					imagearrayResult[i][j] = greenPic[i][j];
				}
			}
		}
		 
		return imagearrayResult;
	}

	/**
	 * 	Horizontally shifts the image to the right, by a certain
	 * 	percentage (passed in as an int (0 to 100)). Wraps around
	 * 	to the left.
	 */
	public Pixel[][] shiftRight(Pixel[][] array, int percent)
	{
		Pixel[][] imagearrayResult = new Pixel[array.length][array[0].length];
		int shift = array[0].length * percent / 100;
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				int columnPos = j - shift;
				if (columnPos < 0)
					columnPos = array[i].length - Math.abs(columnPos);
				imagearrayResult[i][j] = array[i][columnPos];
			}
		}

		return imagearrayResult;
	}

	/**
	 *	Zooms in on lower right of original image (1/4 of
	 * 	the image).
	 */
	public Pixel[][] zoomLowerRight(Pixel[][] array)
	{
		Pixel[][] imagearrayResult = new Pixel[array.length][array[0].length];
		int r = array.length / 2;
		int c = array[0].length / 2;

		for (int i = 0; i < array.length; i += 2)
		{
			for (int j = 0; j < array[i].length; j += 2)
			{
				imagearrayResult[i][j] = array[r][c];
				if (i + 1 < array.length)
					imagearrayResult[i + 1][j] = array[r][c];
				if (j + 1 < array[i].length)
					imagearrayResult[i][j + 1] = array[r][c];
				if (i + 1 < array.length && j + 1 < array[i].length)
					imagearrayResult[i + 1][j + 1] = array[r][c];
				if (c < array[i].length - 1)
					c++;
				else
				{
					r++;
					c = array[i].length / 2;
				}
			}
		}

		return imagearrayResult;
	}

	/**
	 *	A method to tile and mirror an image. Reduces image
	 * 	to 25% of the original size, then mirrors result in
	 * 	other 3 quadrants.
	 */
	public Pixel[][] tileAndMirror(Pixel[][] array)
	{
		Pixel[][] imagearrayResult = new Pixel[array.length][array[0].length];

		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				if (i >= array.length / 2 && j >= array[i].length / 2)
					imagearrayResult[i][j] = array[array.length - 1 - (i * 2) % array.length][array[i].length - 1 - (j * 2) % array[i].length];
				else if (i >= array.length / 2)
					imagearrayResult[i][j] = array[array.length - 1 - (i * 2) % array.length][(j * 2) % array[i].length];
				else if (j >= array[i].length / 2)
					imagearrayResult[i][j] = array[(i * 2) % array.length][array[i].length - 1 - (j * 2) % array[i].length];
				else
					imagearrayResult[i][j] = array[(i * 2) % array.length][(j * 2) % array[i].length];
			}
		}

		return imagearrayResult;
	}

	/**
	 *	Zooms in on a rectangular portion of the image. Zoom depends on
	 * 	4 int parameters (passed in to the method).
	 */
	public Pixel[][] zoomPatch(Pixel[][] array, int horizStart, int horizEnd,
		int vertStart, int vertEnd)
	{
		Pixel[][] imagearrayResult = new Pixel[array.length][array[0].length];
		int r = array.length * vertStart / 100;
		int c = array[0].length * horizStart / 100;
		int columnStop = array[0].length * horizEnd / 100;
		if ((horizEnd - horizStart) % 2 == 1)
			columnStop++;

		double vertScale = array.length / ((vertEnd - vertStart) * array.length / 100.0);
		double horizScale = array[0].length / ((horizEnd - horizStart) * array[0].length / 100.0);

		for (double i = 0; i < array.length; i += vertScale)
		{
			for (double j = 0; j < array[(int) i].length; j += horizScale)
			{
				for (int k = (int) i; k < array.length && k < i + vertScale; k++)
				{
					for (int l = (int) j; l < array[0].length && l < j + horizScale; l++)
					{
						imagearrayResult[k][l] = array[r][c];
					}
				}

				if (c < columnStop - 1)
					c++;
				else
				{
					r++;
					c = array[0].length * horizStart / 100;
				}
			}
		}

		return imagearrayResult;
	}
	
	/**
	 *  Saves the 2D Pixel array to a ppm file.
	 *  @param array        The 2D array to be saved to the file.
	 */
	public void saveToOutputFile(Pixel [][] array)
	{
		int count = 0;
		PrintWriter outfile = null;
		try
		{
			outfile = OpenFile.openToWrite(outfilename);
			outfile.write("P3\n");
			outfile.write(array[0].length + "   " + array.length + "\n");
			outfile.write(maxval + "\n");
			for(int i = 0; i < array.length; i++)
			{
				count = 0;
				for(int j = 0; j < array[i].length; j++)
				{
					outfile.write(array[i][j].toString());
					count++;
					if (count % 14 == 0)
					{
						outfile.write("\n");
					}

				}
				outfile.write("\n\n");
			}
			outfile.close();
			System.out.println("\n\n\nYour edited image has been saved to: " + outfilename);
			System.out.println("THANK YOU FOR USING THE PPM IMAGE EDITOR" + "\n\n\n");
		}
		catch(Exception e)
		{
			System.out.println("\n\nSorry, but the file could not be created.\n\n\n");
			System.exit(1);
		}
	}
	
	/**
	 *  Creates output file and writes image to file in .ppm format.
	 */
	public void createImageFile ( )
	{
		PrintWriter outfile = null;
		try
		{
			outfile = OpenFile.openToWrite(outfilename);
			outfile.write("P3\n");
			outfile.write(column + "   " + row + "\n");
			outfile.write(maxval + "\n");
			for (int i = 0; i < row; i++)
			{
				for (int j = 0; j < column; j++)
				{
					if (j % 5 == 0)
					{
						outfile.write("\n");
					}
					
					outfile.write(Math.abs(i + j) + " ");
					outfile.write(Math.abs(255 - i) + " ");
					outfile.write(Math.abs(255 - j) + " ");
				}
			}
			outfile.close();
		}
		catch(Exception e)
		{
			System.out.println("\n\nSorry, but the file could not be created.\n\n\n");
			System.exit(1);
		}
	}

}