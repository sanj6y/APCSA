/**
 * Person.java
 * 
 * A class used in VirusSimulation.java for
 * the VirusSimulation class. A Person object
 * is a circle with a specific radius, health
 * status, color (corresponding to the health
 * status), a number of days passed after being
 * infected, and lastly, the chance to be infected
 * upon collision with an infected person.
 * 
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 10/18/21
 */

import java.awt.Color;

public class Person
{
	/**
	 * field variables
	 */
	private double x;
	private double y;
	private double dx;
	private double dy;
	private double radius;
	private Color color;
	private String status;
	private int daysPassed;
	private double infectChance;
	
	/**
	 * A constructor for the Person class. NOTE: NOT USED IN
	 * VIRUSSIMULATION LAB! Simply here so Simulation class
	 * still compiles and runs.
	 */
	public Person(double r)
	{
		status = "healthy";
		radius = r;
		x = (Constants.BOARD_SCALE - Constants.RADIUS) * (2 * Math.random() - 1);
		y = (Constants.BOARD_SCALE - Constants.RADIUS) * (2 * Math.random() - 1);
		dx = Constants.RADIUS * (Math.random() - 0.5);
		dy = Constants.RADIUS * (Math.random() - 0.5);
		color = Color.WHITE;
	}

	/**
	 * A constructor for the Person class. Initializes the health
	 * status as healthy for all but one person, sets radius of
	 * each person, sets the white color (corresponding to the
	 * healthy status), and sets the chance of infection to the
	 * command line argument (or the value in Constants).
	 */
	public Person(double r, double i)
	{
		status = "healthy";
		radius = r;
		x = (Constants.BOARD_SCALE - Constants.RADIUS) * (2 * Math.random() - 1);
		y = (Constants.BOARD_SCALE - Constants.RADIUS) * (2 * Math.random() - 1);
		dx = Constants.RADIUS * (Math.random() - 0.5);
		dy = Constants.RADIUS * (Math.random() - 0.5);
		color = Color.WHITE;
		infectChance = i;
	}
	
	/**
	 * A method to change the position of a
	 * person by changing x, dx, y, and dy.
	 */
	public void changePosition()
	{
		if (Math.abs(x + dx) > Constants.BOARD_SCALE - Constants.RADIUS)
		{
			dx = -dx;
		}
		if(Math.abs(y + dy) > Constants.BOARD_SCALE - Constants.RADIUS)
		{
			dy = -dy;
		}
		
		x = x + dx;
		y = y + dy;

	}
	
	/**
	 * A method to check if two people have collided
	 * by checking if the distance between their
	 * centers is less than their radii or not.
	 */
	public boolean collision(Person other)
	{
		if((x - other.x) * (x - other.x) + (y - other.y) * (y - other.y) <= (radius + other.radius) * (radius + other.radius))
		{
			return true;
		}
		return false;
	}
	
	
	
	/**
	 *  Changes the direction and the position of the Person, based on the collision information.
	 *  The collision is elastic.
	 * 
	 * If a collision occurs, the two Persons' health status are
	 * compared. If one is healthy and the other is infected,
	 * then the healthy one has a chance of becoming infected (the
	 * chance is determined by the infectChance variable).
	 */
	
	public void collisionChange(Person other)
	{
		if (other.getHealthStatus().equals("infected") && this.getHealthStatus().equals("healthy"))
		{
			if (Math.random() <= infectChance)
			{
				setInfectedStatus();
			}
		}
		else if (this.getHealthStatus().equals("infected") && other.getHealthStatus().equals("healthy"))
		{
			if (Math.random() <= infectChance)
			{
				other.setInfectedStatus();
			}
		}
		
		double diffx = other.x - x;
		double diffy = other.y - y;
		double dist = Math.sqrt(diffx * diffx + diffy * diffy);
		
		double normalx = diffx / dist;
		double normaly = diffy / dist;
		
		double midpointx = (x + other.x) / 2.0;
		double midpointy = (y + other.y) / 2.0;

		double dVector = (dx - other.dx) * normalx + (dy - other.dy) * normaly;
			
		double changex = dVector * normalx;
		double changey = dVector * normaly;
		
		if(dx == 0 && dy == 0)
		{
			other.x = midpointx  + other.radius * normalx;
			other.y = midpointy  + other.radius * normaly;
			other.dx = other.dx + 2 * changex;
			other.dy = other.dy + 2 * changey;
		}
		else if(other.dx == 0 && other.dy == 0)
		{
			x = midpointx - radius * normalx;
			y = midpointy - radius * normaly;
			dx = dx - 2 * changex;
			dy = dy - 2 * changey;
		}
		else
		{
			x = midpointx - radius * normalx;
			y = midpointy - radius * normaly;
			other.x = midpointx  + other.radius * normalx;
			other.y = midpointy  + other.radius * normaly;
			
			dx = dx - changex;
			dy = dy - changey;
			other.dx = other.dx + changex;
			other.dy = other.dy + changey;
		}
	}
	
	/**
	 * A method to draw each person.
	 * Sets the pen color to white,
	 * red, or blue, then draws the
	 * circle.
	 */
	public void draw()
	{
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(x, y, radius);
	}
	
	/**
	 * Getter for health status.
	 */
	public String getHealthStatus()
	{
		return status;
	}
	
	/**
	 * Setter to set status as infected
	 * and change the person's color to
	 * red and set the daysPassed since
	 * infected = 0.
	 */
	public void setInfectedStatus()
	{
		status = "infected";
		color = Color.RED;
		daysPassed = 0;
	}
	
	/**
	 * Setter to set status as recovered
	 * and change the person's color to
	 * blue.
	 */
	public void setRecoveredStatus()
	{
		status = "recovered";
		color = Color.BLUE;
	}
	
	/**
	 * Method to increment the
	 * count for days passed.
	 */
	public void incrementDays()
	{
		daysPassed++;
	}
	
	/**
	 * Getter for days passed.
	 */
	public int getDaysPassed()
	{
		return daysPassed;
	}
}




            