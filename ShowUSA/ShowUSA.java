/**
 *  ShowUSA.java
 *  
 *  A program, using the JFrame
 *  class, to draw a map of the
 *  USA using small gray dots
 *  for the many cities in the
 *  USA, and then overlapping
 *  on the cities that happen to
 *  also be capital cities with
 *  larger red dots.
 *
 *  @author Scott DeRuiter and Sanjay Chandrasekar
 *  @version 1.0
 *  @since 9/7/2021
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;

public class ShowUSA extends JFrame 
{
	/**
	 *  Creates a ShowUSA object, adding a JPanel
	 *  to the JFrame.
	 */
	public ShowUSA ( ) 
	{
		super("United States of America");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GetAndDrawCities cities = new GetAndDrawCities();
		getContentPane().add(cities);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new ShowUSA();
	}
}

/**
 *  A class to make the actual JPanel
 *  that shows the USA map with the
 *  gray dots for cities and red dots
 *  for capitals. Simply calls all the
 *  methods written below the addCities
 *  and addCapitals method written
 *  below after creating the canvas/frame.
 */
class GetAndDrawCities extends JPanel 
{
	private static final int PREF_W = 1000;
	private static final int PREF_H = 600;
	
	public GetAndDrawCities()
	{
		setBackground(Color.white);
	}

	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(PREF_W, PREF_H);
	}
	
	@Override
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		addCities(g);
		addCapitals(g);
	}
	
	/**
	 *  Here, you should open up the cities text file, and translate the
	 *  numbers you find to coordinate values to be plotted.  The
	 *  dots should be gray and of diameter 4.
	 */
	public void addCities(Graphics g)
	{
		int diameter = 4;
		g.setColor(Color.GRAY);
		//g.fillOval(400-diameter/2,200-diameter/2,diameter,diameter);
		
		// fix file name
		Scanner infile = OpenFile.openToRead("/Users/sanjaychandrasekar/Code/APCSA/ShowUSA/cities.txt");
		while(infile.hasNext())
		{
			String line = infile.nextLine();
			int lastComma = line.lastIndexOf(',');
			int startOfCoordinates = line.substring(0, lastComma).lastIndexOf(',');
			String coordinates = line.substring(startOfCoordinates + 1);
			String latitudeStr = coordinates.substring(coordinates.indexOf(',') + 1).trim();
			String longitudeStr = coordinates.substring(0, coordinates.indexOf(',')).trim();
			double latitudeDouble = Double.parseDouble(latitudeStr);
			double longitudeDouble = Double.parseDouble(longitudeStr);
			
			latitudeDouble *= 17;
			longitudeDouble *= 21;
			
			int latitudeInt = (int) latitudeDouble;
			int longitudeInt = (int) longitudeDouble;

			g.fillOval(2130 - latitudeInt, 1080 - longitudeInt, diameter, diameter);
		}
		infile.close();
	}
	
	/**
	 *  Open up the capitals text file, and, for each city you find in
	 *  this file, compare to the cities in cities.txt.  If you find a
	 *  match, print a red dot with diameter 12.
	 */
	public void addCapitals(Graphics g)
	{
		int diameter = 12;
		g.setColor(Color.RED);
		
		// fix file name
		Scanner infile = OpenFile.openToRead("/Users/sanjaychandrasekar/Code/APCSA/ShowUSA/cities.txt");
		while(infile.hasNext())
		{
			String line = infile.nextLine();
			int firstComma = line.indexOf(',');
			int secondComma = line.indexOf(',', firstComma+1);
			int thirdComma = line.indexOf(',', secondComma+1);
			
			String state = line.substring(firstComma+1, secondComma);
			String city = line.substring(secondComma+1, thirdComma);
			
			int lastComma = line.lastIndexOf(',');
			int startOfCoordinates = line.substring(0, lastComma).lastIndexOf(',');
			
			String coordinates = line.substring(startOfCoordinates + 1);
			String latitudeStr = coordinates.substring(coordinates.indexOf(',') + 1).trim();
			String longitudeStr = coordinates.substring(0, coordinates.indexOf(',')).trim();
			
			double latitudeDouble = Double.parseDouble(latitudeStr);
			double longitudeDouble = Double.parseDouble(longitudeStr);
			
			latitudeDouble *= 17;
			longitudeDouble *= 21;
			
			int latitudeInt = (int) latitudeDouble;
			int longitudeInt = (int) longitudeDouble;

			if(checkForCapital(city, state))
				g.fillOval(2130 - latitudeInt, 1080 - longitudeInt, diameter, diameter);
			
		}
	}
	
    /**
     *  Opens up the capitals text file, and for each city and state
     *  pair you find in this file, compare to the pair in the
     *  method arguments. If you find a match, return true.
     */
	public boolean checkForCapital(String city, String state)
	{
		// Fix file name
		Scanner infile = OpenFile.openToRead("/Users/sanjaychandrasekar/Code/APCSA/ShowUSA/capitals.txt");
		while(infile.hasNext())
		{
			String line = infile.nextLine();
			int comma = line.indexOf(',');
			
			String cityInFile = line.substring(0, comma).trim();
			String stateInFile = line.substring(comma+1).trim();
			
			if (city.equals(cityInFile) && state.equals(stateInFile))
			{
				return true;
			}
			
		}
		return false;
	}
}
