/**
 * SideToSidePanda.java
 * 
 * A subclass of DancingPanda, with the step method written
 * to make the SideToSidePanda move left/right for one step,
 * and back (to where it started) for the next, alternating like that.
 * 
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 11/15/21
 */

import java.awt.Color;

public class SideToSidePanda extends DancingPanda
{
	private boolean left;
	
	/**
	 * Creates a new SideToSidePanda at the given location with the given color,
	 * using the superclass DancingPanda's constructor. Also sets the field
	 * variable left to true to make the Panda move left first, then
	 * back, then alternate.
	 * @param x the SideToSidePanda's x location
	 * @param y the SideToSidePanda's y location
	 * @param c the SideToSidePanda's color
	 */
	public SideToSidePanda(int x, int y, Color c)
	{
		super(x, y, c);
		left = true;
	}
	
	/**
	 * Creates a new SideToSidePanda at the given location, with the given color, 
	 * facing in the given direction, using the superclass DancingPanda's constructor.
	 * Also sets the field variable left to true to make the Panda move left
	 * first, then back, then alternate.
	 * @param x the SideToSidePanda's x location
	 * @param y the SideToSidePanda's y location
	 * @param c the SideToSidePanda's color
	 * @param p the SideToSidePanda's direction
	 */
	public SideToSidePanda(int x, int y, Color c, Point p)
	{
		super(x, y, c, p);
		left = true;
	}
	
	/**
	 * An overridden method that causes the SideToSidePanda to perform a single dance step
	 * (move forward or back).
	 */
	public void step()
	{
		if (left)
			moveSide(64);
		else
			moveSide(-64);
		
		left = !left;
	}
}
