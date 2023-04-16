/**
 * DancingPanda.java
 * 
 * An abstract DancingPanda.  Contains the basic move methods for a 
 * DancingPanda.  This class is to be extended, so that the methods 
 * can be used.  Each DancingPanda has a position (x and y), a direction
 * (a Point), and a Color.  There are 2 constructors (3 args and 4 args).
 * A DancingPanda can spinRight, spinLeft, moveForward (and backward),
 * moveSide (left or right), and be drawn.  The abstract method step will
 * need to be defined by subclasses of the DancingPanda.
 *
 * @author Scott DeRuiter and Sanjay Chandrasekar
 * @version 1.0
 * @since 11/15/2021
 */

import java.awt.Color;

public abstract class DancingPanda
{
	private Point direction;
	private int x;
	private int y;
	private Color color;

	/**
	 * Creates a new DancingPanda at the given location with the given color. DancingPanda defaults to facing SOUTH.
	 * @param x the DancingPanda's x location
	 * @param y the DancingPanda's y location
	 * @param color the DancingPanda's color
	 */
	public DancingPanda(int x, int y, Color color)
	{
		this.x = x;
		this.y = y;
		this.direction = PandaConstants.SOUTH;
		this.color = color;
	}

	/**
	 * Creates a new DancingPanda at the given location, with the given color, facing in the given direction.
	 * @param x the DancingPanda's x location
	 * @param y the DancingPanda's y location
	 * @param color the DancingPanda's color
	 * @param direction the DancingPanda's direction
	 */
	public DancingPanda(int x, int y, Color color, Point p)
	{
		this.x = x;
		this.y = y;
		this.direction = p;
		this.color = color;
	}

	/**
	 * An abstract method (that must be overridden in a subclass) that causes the DancingPanda to perform a single dance step.
	 * The details of what that step is should be defined by the concrete child class.
	 */
	public abstract void step();

	/**
	 * A method that spins the DancingPanda 90 degrees to the right (clockwise) 
	 * @return whether or not the DancingPanda successfully turned.
	 */
	public boolean spinRight()
	{
		if(this.direction == PandaConstants.NORTH)
		{
			this.direction = PandaConstants.EAST;
		}
		else if(this.direction == PandaConstants.EAST)
		{
			this.direction = PandaConstants.SOUTH;
		}
		else if(this.direction == PandaConstants.SOUTH)
		{
			this.direction = PandaConstants.WEST;
		}
		else if(this.direction == PandaConstants.WEST)
		{
			this.direction = PandaConstants.NORTH;
		}

		return true;
	}

	/**
	 * A method that spins the DancingPanda 90 degrees to the left (counter-clockwise) 
	 * @return whether or not the DancingPanda successfully turned.
	 */
	public boolean spinLeft()
	{
		if(this.direction == PandaConstants.NORTH)
		{
			this.direction = PandaConstants.WEST;
		}
		else if(this.direction == PandaConstants.EAST)
		{
			this.direction = PandaConstants.NORTH;
		}
		else if(this.direction == PandaConstants.SOUTH)
		{
			this.direction = PandaConstants.EAST;
		}
		else if(this.direction == PandaConstants.WEST)
		{
			this.direction = PandaConstants.SOUTH;
		}

		return true;
	}

	/**
	 * Moves the DancingPanda along the line it is facing. Note that the DancingPanda can move backwards.
	 * The DancingPanda will only move if it stays within the bounds of the dance floor.
	 * @param dist the number of pixels the DancingPanda should move. A negative number causes the DancingPanda to step backwards.
	 * @return whether or not the DancingPanda successfully moved.
	 */
	public boolean moveForward(int dist)
	{
		int newX = x + dist * this.direction.getX();
		int newY = y + dist * this.direction.getY();
		
		if(newX >= 0 && newX <= PandaConstants.SCREEN_WIDTH && newY >= 0 && newY <= PandaConstants.SCREEN_HEIGHT)
		{
			x = newX;
			y = newY;
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Moves the DancingPanda sideways relative to its facing direction.  A positive parameter means it moves to the right, 
	 * a negative parameter means it moves to the left.
	 * The DancingPanda will only move if it stays within the bounds of the dance floor.
	 * @param dist the number of pixels the DancingPanda should move. A negative number causes the DancingPanda to move right, a negative to move left.
	 * @return whether or not the DancingPanda successfully moved.
	 */
	public boolean moveSide(int dist)
	{
		int newX = x + dist * this.direction.getY();
		int newY = y - dist * this.direction.getX();
		
		if(newX >= 0 && newX <= PandaConstants.SCREEN_WIDTH && newY >= 0 && newY <= PandaConstants.SCREEN_HEIGHT)
		{
			x = newX;
			y = newY;
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Draws the DancingPanda, with correct position, orientation (direction), and color.
	 */
	public void draw ( )
	{
		StdDraw.setPenColor(color); 
		StdDraw.filledCircle(x, y, 32);
		if(this.direction == PandaConstants.NORTH)
		{
			StdDraw.picture(x, y, "dancingpanda.png", 180);
		}
		else if(this.direction == PandaConstants.WEST)
		{
			StdDraw.picture(x, y, "dancingpanda.png", 270);
		}
		else if(this.direction == PandaConstants.SOUTH)
		{
			StdDraw.picture(x, y, "dancingpanda.png", 0);
		}
		else if(this.direction == PandaConstants.EAST)
		{
			StdDraw.picture(x, y, "dancingpanda.png", 90);
		}
	}
	
	/**
	 * Getter for x
	 */
	public int getX()
	{
		return x;
	}
	 
	/**
	 * Getter for y
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * Getter for direction
	 */
	public Point getDirection()
	{
		return direction;
	}

	/**
	 * Setter for direction
	 */
	public void setDirection(Point dir)
	{
		direction = dir;
	}

	/**
	 * Getter for color
	 */
	public Color getColor()
	{
		return color;
	}

	/**
	 * Setter for x
	 */
	public void setX(int newX)
	{
		x = newX;
	}

	/**
	 * Setter for y
	 */
	public void setY(int newY)
	{
		y = newY;
	}
	
	/**
	 * Returns a new point with location
	 * of the DancingPanda using the x
	 * and y coordinates.
	 */
	public Point getLocation()
	{
		return new Point(getX(), getY());
	}
	
}
