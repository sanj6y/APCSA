/**
 * TwirlingPanda.java
 * 
 * An subclass of DancingPanda, with the step method written
 * to make the TwirlingPanda spin right for every step.
 *
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 11/15/2021
 */
 
import java.awt.Color;

public class TwirlingPanda extends DancingPanda
{
	
	/**
	 * Creates a new TwirlingPanda at the given location with the given color,
	 * using the superclass DancingPanda's constructor.
	 * @param x 	the TwirlingPanda's x location
	 * @param y 	the TwirlingPanda's y location
	 * @param c 	the TwirlingPanda's color
	 */
	public TwirlingPanda(int x, int y, Color c)
	{
		super(x, y, c);
	}
	
	/**
	 * Creates a new TwirlingPanda at the given location, with the given color, 
	 * facing in the given direction, using the superclass DancingPanda's constructor.
	 * @param x		the TwirlingPanda's x location
	 * @param y		the TwirlingPanda's y location
	 * @param c 	the TwirlingPanda's color
	 * @param p		the TwirlingPanda's direction
	 */
	public TwirlingPanda(int x, int y, Color c, Point p)
	{
		super(x, y, c, p);
	}
	
	/**
	 * An overridden method that causes the TwirlingPanda to perform a single dance step (spin right).
	 */
	public void step()
	{
		spinRight();
	}
}
