/**
 * ForwardAndBackPanda.java
 * 
 * A subclass of DancingPanda, with the step method written
 * to make the ForwardAndBackPanda move forward for one step,
 * and back for the next, alternating like that.
 * 
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 11/15/21
 */

import java.awt.Color;

public class ForwardAndBackPanda extends DancingPanda
{
	private boolean forward;
	
	/**
	 * Creates a new ForwardAndBackPanda at the given location with the given color,
	 * using the superclass DancingPanda's constructor. Also sets the field
	 * variable forward to true to make the Panda move forward first, then
	 * back, then alternate.
	 * @param x the ForwardAndBackPanda's x location
	 * @param y the ForwardAndBackPanda's y location
	 * @param c the ForwardAndBackPanda's color
	 */
	public ForwardAndBackPanda(int x, int y, Color c)
	{
		super(x, y, c);
		forward = true;
	}
	
	/**
	 * Creates a new ForwardAndBackPanda at the given location, with the given color, 
	 * facing in the given direction, using the superclass DancingPanda's constructor.
	 * Also sets the field variable forward to true to make the Panda move forward
	 * first, then back, then alternate.
	 * @param x the ForwardAndBackPanda's x location
	 * @param y the ForwardAndBackPanda's y location
	 * @param c the ForwardAndBackPanda's color
	 * @param p the ForwardAndBackPanda's direction
	 */
	public ForwardAndBackPanda(int x, int y, Color c, Point p)
	{
		super(x, y, c, p);
		forward = true;
	}
	
	/**
	 * An overridden method that causes the ForwardAndBackPanda to perform a single dance step
	 * (move forward or back).
	 */
	public void step()
	{
		if (forward)
			moveForward(64);
		else
			moveForward(-64);
		
		forward = !forward;
	}
}
