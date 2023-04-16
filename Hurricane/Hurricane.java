/**
 * Hurricane.java
 * Creates a map of the United States (lower 48),
 * using a text file that contains information
 * for US cities.  The name of the text file is
 * cities.txt, and each line of this file has:
 * zip,state,city,latitude,longitude
 * OpenFile is used to open the text file, and
 * each line is read, with latitude and longitude
 * information parsed from the line.  These
 * values are then plotted on canvas.  The class
 * StdDraw is used to create the canvas.  After the
 * map of the US is created, information from another
 * text file (like f.txt) is used to animate
 * the progress of a hurricane.  An animation is
 * created, and a path is displayed, as the 
 * hurricane tracks its path on the canvas.
 *
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 9/16/2021
 */

import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;

public class Hurricane 
{ 
	/** The name of the text file, containing data about the hurricane.   */
	private String fileName;
	/** The pause duration, in milliseconds, between views of the storm.  */
	private int pause;

	/** Creates a Hurricane object.
	 *  @param file   The name of the text file to be used.
	 *  @param p      The pause time, in milliseconds.
	 */
	public Hurricane(String file, int p)
	{
		fileName = new String(file);
		pause = p;
	}

	/**
	 *  The main method, to create the map of the US, then
	 *  track the hurricane.
	 */
	public static void main(String[] args)
	{
		int p = 200;
		String file = new String("f.txt");

		if (args.length > 1)
		{
			try
			{
				p = Integer.parseInt(args[1]);
			}
			catch (NumberFormatException error)
			{
				System.err.println("Sorry, but the second argument should be an integer. " + 
					"Please try again.\n\n\n");
				System.exit(1);
			}
		}

		if (args.length > 0)
		{
			file = args[0];
		}

		Hurricane run = new Hurricane(file,p);
		run.setUpCanvas();
		run.loadUSA();
		run.showIt();
		run.legend();
		run.animateStorm();
    } 
	
	/** 
	 *  Sets up the canvas, using methods from StdDraw.  This includes
	 *  setting up the canvas size, the horizontal scale (Xscale), and
	 *  the vertical scale (Yscale).  We will enable double buffering,
	 *  in anticipation of running an animation.  Also, the pen radius
	 *  should be relatively small, and the dots should be dark gray.
	 */
	public void setUpCanvas ( )
	{
		StdDraw.setCanvasSize(1100, 500);
		StdDraw.setXscale(125.0, 15.0);       //  Related to the longitude
		StdDraw.setYscale(10.0, 50.0);        //  Related to the latitude
		
		StdDraw.enableDoubleBuffering();

		StdDraw.setPenRadius(0.0075);
		StdDraw.setPenColor(StdDraw.DARK_GRAY); 
	}
	
	/** 
	 *  Opens the file (cities.txt), and reads in the data one line
	 *  at a time.  The data in cities.txt is of the form:
	 *  zip,state,city,latitude,longitude
	 *  The code here makes use of String methods, along with
	 *  Double.parseDouble, to split up the String, and pull out the
	 *  latitude and longitude.  These values are then used to plot
	 *  points on the canvas, using StdDraw.point(horizontal,vertical).
	 */
	public void loadUSA ( )
	{
		Scanner infile = OpenFile.openToRead("cities.txt");
		StdDraw.setPenColor(Color.BLACK);

		while(infile.hasNext())
		{
			String line = infile.nextLine();
			int lastComma = line.lastIndexOf(',');
			int startOfCoordinates = line.substring(0, lastComma).lastIndexOf(',');
			String coordinates = line.substring(startOfCoordinates + 1);
			String xCoord = coordinates.substring(coordinates.indexOf(',') + 1).trim();
			String yCoord = coordinates.substring(0, coordinates.indexOf(',')).trim();
			double longitudeNum = Double.parseDouble(yCoord);
			double latitudeNum = Double.parseDouble(xCoord);
						
			StdDraw.filledCircle(latitudeNum, longitudeNum, 0.15);

		}
		infile.close();
	}
	
	/** 
	 *  Prints the image to the screen (image is saved offscreen before
	 *  the reveal here).
	 */
	public void showIt ( )
	{
		StdDraw.show();
	}
	
	/** 
	 *  Creates a legend, in the lower left-hand corner of the screen.
	 *  This legend describes the different stages (or levels) of
	 *  a storm, from Disturbance to Hurricane 5.
	 */
	public void legend ( )
	{
		StdDraw.setPenRadius(0.04);
		StdDraw.setPenColor(new Color(0,0,0));
		StdDraw.filledRectangle(112.7,19.6,15.8,9.2);
		StdDraw.setPenColor(new Color(255,255,255));
		StdDraw.filledRectangle(112.7,19.6,15.6,9);
		StdDraw.setPenColor(new Color(255,60,60));
		StdDraw.picture(122.6,27.3,"hurricane.png",135);
		StdDraw.point(122.6,27.3);
		StdDraw.setPenColor(new Color(255,150,20)); 
		StdDraw.picture(122.6,25.1,"hurricane.png",135);
		StdDraw.point(122.6,25.1);
		StdDraw.setPenColor(new Color(255,210,40)); 
		StdDraw.picture(122.6,22.9,"hurricane.png",135);
		StdDraw.point(122.6,22.9);
		StdDraw.setPenColor(new Color(255,235,75)); 
		StdDraw.picture(122.6,20.7,"hurricane.png",135);
		StdDraw.point(122.6,20.7);
		StdDraw.setPenColor(new Color(255,255,180)); 
		StdDraw.picture(122.6,18.5,"hurricane.png",135);
		StdDraw.point(122.6,18.5);
		StdDraw.setPenColor(new Color(0,250,240)); 
		StdDraw.picture(122.6,16.3,"hurricane.png",135);
		StdDraw.point(122.6,16.3);
		StdDraw.setPenColor(new Color(95,185,255)); 
		StdDraw.picture(122.6,14.1,"hurricane.png",135);
		StdDraw.point(122.6,14.1);
		StdDraw.setPenColor(new Color(80,200,255)); 
		StdDraw.picture(122.6,11.9,"hurricane.png",135);
		StdDraw.point(122.6,11.9);
		StdDraw.setPenColor(new Color(0,0,0));
		Font font = new Font("Arial", Font.BOLD, 13);
		StdDraw.setFont(font);
		StdDraw.textLeft(121,27.3,"Hurricane 5, Winds > 155");
		StdDraw.textLeft(121,25.1,"Hurricane 4, 130 < Winds < 155");
		StdDraw.textLeft(121,22.9,"Hurricane 3, 110 < Winds < 130");
		StdDraw.textLeft(121,20.7,"Hurricane 2, 95 < Winds < 110");
		StdDraw.textLeft(121,18.5,"Hurricane 1, 75 < Winds < 95");
		StdDraw.textLeft(121,16.3,"Storm, 35 < Winds < 75");
		StdDraw.textLeft(121,14.1,"Depression, 15 < Winds < 35");
		StdDraw.textLeft(121,11.9,"Disturbance, 0 < Winds < 15");
	}
	
	/** 
	 * Animates the storm. Opens a certain file (chosen with the args) using OpenFile.
	 * Gets each line and the date, time, latitude, longitude, and wind speed (as a
	 * string) of each line. Remove the "mph" from the wind speed to get and parses
	 * it as an integer. It then writes the text with the date and time for every
	 * point on the hurricane. After every point it draws a white rectangle so it
	 * doesn't overlap the text. It then finds which range the wind speed number is
	 * in and sets the pen color (to draw the circle for that corresponding point)
	 * to the color corresponding to that range of wind speed (specified in the legend).
	 * Lastly, it parses the latitude and longitude (which are strings) into doubles,
	 * then draws a picture, which consists of a circle at the specific latitude and
	 * longitude, with the background of the "hurricane.png" image file. We then
	 * use the StdDraw show() method to actually put the picture on the frame. The
	 * final thing is pausing for a certain amount of milliseconds before drawing
	 * the next point.
	 */
	public void animateStorm ( )
	{
		Scanner sc = OpenFile.openToRead(fileName);
		StdDraw.setPenRadius(0.04);
		while(sc.hasNext())
		{
			String line = sc.nextLine();
			String date = parseOut(0, line);
			String time = parseOut(1, line);
			String latitude = parseOut(2, line);
			String longitude = parseOut(3, line);
			String rawWindSpeed = parseOut(4, line);
			
			int indexOfMPH = rawWindSpeed.indexOf("mph");
			String windSpeed = rawWindSpeed.substring(0, indexOfMPH).trim();
			int windSpeedNum = Integer.parseInt(windSpeed);
			
			StdDraw.setPenColor(new Color(255, 255, 255));
			StdDraw.filledRectangle(39, 47, 23, 3);
			StdDraw.setPenColor(new Color(0, 0, 0));
			Font font = new Font("Arial", Font.BOLD, 35);
			StdDraw.setFont(font);
			StdDraw.textLeft(59, 47, date + " " + time);
			
			if (windSpeedNum > 0 && windSpeedNum <= 15)
				StdDraw.setPenColor(new Color(80,200,255)); 
			else if (windSpeedNum > 15 && windSpeedNum <= 35)
				StdDraw.setPenColor(new Color(95,185,255)); 
			else if (windSpeedNum > 35 && windSpeedNum <= 75)
				StdDraw.setPenColor(new Color(0,250,240)); 
			else if (windSpeedNum > 75 && windSpeedNum <= 95)
				StdDraw.setPenColor(new Color(255,255,180));
			else if (windSpeedNum > 95 && windSpeedNum <= 110)
				StdDraw.setPenColor(new Color(255,235,75));
			else if (windSpeedNum > 110 && windSpeedNum <= 130)
				StdDraw.setPenColor(new Color(255,210,40));
			else if (windSpeedNum > 130 && windSpeedNum <= 155)
				StdDraw.setPenColor(new Color(255,150,20));
			else
				StdDraw.setPenColor(new Color(255,60,60));

			double latitudeNum = Double.parseDouble(latitude);
			double longitudeNum = Double.parseDouble(longitude);
			
			StdDraw.picture(longitudeNum, latitudeNum, "hurricane.png", 360 * Math.random());
			StdDraw.point(longitudeNum, latitudeNum); 
			
			StdDraw.show();
			StdDraw.pause(pause);
		}
		/*
		double horizontal, vertical;
		for(int i = 0; i < 100; i++)
		{
			StdDraw.setPenColor(new Color(255,60,60)); 
			horizontal = 20 + 80 * Math.random();
			vertical = 15 + 25 * Math.random();
			StdDraw.picture(horizontal,vertical,"hurricane.png",360 * Math.random());
			StdDraw.point(horizontal,vertical);
			StdDraw.setPenColor(new Color(255,255,255));
			StdDraw.filledRectangle(39,47,23,3);
			StdDraw.setPenColor(new Color(0,0,0));
			Font font = new Font("Arial", Font.BOLD, 40);
			StdDraw.setFont(font);
			if(Math.random() > 0.5)
			{
				StdDraw.textLeft(59,47,"WARNING!");
			}
			else
			{
				StdDraw.textLeft(59,47,"TAKE SHELTER!");
			}
		*/
		}
	
	/**
	 * Takes in the whole line and an integer corresponding to a part of
	 * the line and returns the part of the line the integer corresponds
	 * to. Increments a count variable and checks if count is equal to
	 * the passed integer; if it is, then returns a specific part of the
	 * line. That part is determined by the current index value, which is
	 * set to run through the part of the line between every two commas,
	 * for every value of count.
	 * 
	 * @param passedInt	The integer corresponding to which part of the line
	 * 					is needed.
	 * @param line		The full line as a string.
	 * @return			A substring of the line, containing just the part
	 * 					of the line specified with passedInt.
	 */
	public String parseOut(int passedInt, String line)
	{
		int count = 0;
		int index = line.indexOf(',');
		
		while(index != -1)
		{
			if (passedInt == count)
			{
				String part = line.substring(0, index).trim();
				return part;
			}
			
			count++;
			line = line.substring(index + 1);
			index = line.indexOf(',');
		}
		
		return "**";
	}
}