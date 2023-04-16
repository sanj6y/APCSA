/**
 * LetterFrequency.java
 * 
 * A program that opens up a text file, then
 * counts the number of appearances of each
 * letter of the alphabet in this text file.
 * Displays letter frequencies in a bar chart.
 *
 * @author Scott DeRuiter and Sanjay Chandrasekar
 * @version 1.0
 * @since 3/21/2022
 */
 
import java.awt.Font;
import java.awt.Color;
import java.util.Scanner;
import java.io.PrintWriter;

public class LetterFrequency
{ 
	/**  Array to store the frequencies of letters A to Z              */
	private int [] letters;
	
	/** 
	 *  Creates a LetterFrequency object.  A no-args constructor.
	 */
	public LetterFrequency ( )
	{
		letters = new int[26];
	}

	/**
	 *  The main method, to run the program.  The canvas is set up, and the GUI 
	 *  is displayed (a bar chart showing the frequency of letters from the 
	 *  selected file).
	 */
	public static void main(String[] args)
	{
		String file = "m.txt";
														//  You will want to set the default text file here,
														//  and be ready for possible input at args[0]
		if (args.length > 0)
		{
			file = args[0];
		}
														
		LetterFrequency run = new LetterFrequency();
		run.setUpCanvas();
		run.openFileAndProcess(file);
//		run.createRandomBarChart();						//  Eventually, you will want to remove this method.
		run.printFrequencyBarChart();
		run.printTitleWithFileName(file);
		StdDraw.show();
	}

	/** 
	 *  Sets up the frame, using constants from the Constants class.
	 */
	public void setUpCanvas ( )
	{
		StdDraw.setCanvasSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		StdDraw.setXscale(0, Constants.SCREEN_WIDTH);
		StdDraw.setYscale(0, Constants.SCREEN_HEIGHT);
		StdDraw.clear(StdDraw.LIGHT_GRAY);
		StdDraw.enableDoubleBuffering();
	}

	/** 
	 *  Opens the indicated file, and reads in the text one line at a time.
	 *  Then, one character at a time, the line from the file is evaluated.
	 *  For each 'a' or 'A' encountered, one is added to letters[0], for each
	 *  'b' or 'B' one is added to letters[1], and so on, until for the letter 'z'
	 *  or 'Z' one is added to letters[25].  All non-letter characters are ignored.
	 *  @param file      The file to be evaluated, letter by letter.
	 */
	public void openFileAndProcess(String file)
	{
		Scanner sc = OpenFile.openToRead(file);
		
		while(sc.hasNext())
		{
			String line = sc.nextLine();
			
			for (int i = 0; i < line.length(); i++)
			{
				char c = line.charAt(i);
				if (c >= 97 && c <= 122)
				{
					letters[c - 97]++;
				}
				
				else if (c >= 65 && c <= 90)
				{
					letters[c - 65]++;
				}
			}
		}
	}

	/** 
	 *  Fills the letters array with random values.  The max is placed at the
	 *  last index of letters.  YOU MAY DELETE THIS METHOD LATER.
	 */
	public void createRandomBarChart ( )
	{
		int max = (int)(100 + Math.random() * 4901);				//  YOU ARE WELCOME TO DELETE THIS METHOD WHEN YOU ARE DONE.
		letters[letters.length - 1] = max;							//  IT SHOULD NOT BE CALLED IN YOUR FINAL PROGRAM.
		for(int i = 0; i < letters.length - 1; i++)
		{
			letters[i] = (int)(Math.random() * max);
		}
	}

	/** 
	 *  Prints the bar chart on the canvas.  Scales the array so that it
	 *  "fits nicely".  You can play with the colors and values, or leave
	 *  this method "as is".
	 */
	public void printFrequencyBarChart ( )
	{
		Font font = null;
		drawGradientBackground();
		double divider = findMax() / 580.0;
		for(int i = 0; i < letters.length; i++)
		{
			int shift = 0;
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledRectangle(36 + i * 25, 52 + letters[i] / (divider * 2), 10, letters[i] / (divider * 2));
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(36 + i * 25, 46 + letters[i] / (divider * 2), 4, letters[i] / (divider * 2));
			font = new Font("Arial", Font.BOLD, 18);
			StdDraw.setFont(font);
			if(letters[i] < 1000)
			{
				shift = -6;
			}
			if(letters[i] < 100)
			{
				shift = -12;
			}
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(39 + i * 25, 78 + shift + letters[i] / divider, "" + letters[i], 90);
			font = new Font("Arial", Font.BOLD, 22);
			StdDraw.setFont(font);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(36 + i * 25, 30, "" + (char)(i + 65));
		}
        StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(Constants.SCREEN_WIDTH / 2, 49, Constants.SCREEN_WIDTH / 2, 3);
	}
	
	/** 
	 *  Draws a "slate blue" gradient background.
	 */
	public void drawGradientBackground ( )
	{
		for(int i = 0; i < 130; i++)
		{
			StdDraw.setPenColor(new Color(205 - i, 225 - i, 255 - i));
			StdDraw.filledRectangle(Constants.SCREEN_WIDTH / 2, i * 6, Constants.SCREEN_WIDTH / 2, 3);
		}		
	}

	/** 
	 *  Prints: "LETTER FREQUENCY BAR CHART FOR " + file, at the top of the canvas.  
	 *  This method should be short.
	 *  @param file      The file to be evaluated, printed at the top of the canvas
	 */
	public void printTitleWithFileName(String file)
	{
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(350, 715, "LETTER FREQUENCY BAR CHART FOR " + file);
														//  This method should be short
	}

	/**
	 *  Returns the maximum value in the letters array.
	 *  @return             The maximum value in the letters array.
	 */
	public int findMax ( )
	{
		int max = 0;
		
		for (int i = 0; i < letters.length; i++)
		{
			if (letters[i] > max)
			{
				max = letters[i];
			}
		}
		
		return max;
	}
	
	//  You may wish to include other helper methods.
	
	
}




