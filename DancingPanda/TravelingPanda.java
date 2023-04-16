/**
 * TravelingPanda.java
 * 
 * A subclass of DancingPanda to move forward
 * to one end of the screen, then back all
 * the way, with one FollowingPanda following
 * the TravelingPanda.
 * 
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 11/18/2021
 */

import java.awt.Color;
import java.awt.Font;

public class TravelingPanda extends DancingPanda implements Leader
{
	private FollowingPanda follow;
	private boolean forward;

	/**
	 * Creates a new TravelingPanda at the given location with the given color,
	 * using the superclass DancingPanda's constructor.
	 * @param x 	the TravelingPanda's x location
	 * @param y 	the TravelingPanda's y location
	 * @param c 	the TravelingPanda's color
	 */
	public TravelingPanda(int x, int y, Color c)
	{
		super(x, y, c);
	}
	
	/**
	 * Creates a new TravelingPanda at the given location, with the given color, 
	 * facing in the given direction, using the superclass DancingPanda's constructor.
	 * @param x		the TravelingPanda's x location
	 * @param y		the TravelingPanda's y location
	 * @param c 	the TravelingPanda's color
	 * @param p		the TravelingPanda's direction
	 */
	public TravelingPanda(int x, int y, Color c, Point p)
	{
		super(x, y, c, p);
	}
	
	/**
	 * Adds a follower (FollowingPanda) to the TravelingPanda.
	 */
	public void addFollower(DancingPanda panda)
	{
		follow = (FollowingPanda) panda;
		normalize();
	}
	
	/**
	 * Removes the FollowingPanda that is following the TravelingPanda
	 * by setting it as null.
	 */
	public void removeFollower(DancingPanda panda)
	{
		follow = null;
	}

	/**
	 * Sets the follower's direction so that the leader and follower are
	 * facing towards each other. Also puts a gap between the follower
	 * and leader so they don't overlap.
	 */
	public void normalize()
	{
		if (this.getDirection().getX() == 0 && this.getDirection().getY() == -1)
		{
			follow.setDirection(PandaConstants.NORTH);
			follow.setY(this.getY() - 80);
		}
		else if (this.getDirection().getX() == 0 && this.getDirection().getY() == 1)
		{
			follow.setDirection(PandaConstants.SOUTH);
			follow.setY(this.getY() + 80);
		}
		else if (this.getDirection().getX() == 1 && this.getDirection().getY() == 0)
		{
			follow.setDirection(PandaConstants.WEST);
			follow.setX(this.getX() + 80);
		}
		else
		{
			follow.setDirection(PandaConstants.EAST);
			follow.setX(this.getX() - 80);
		}
	}

	/**
	 * Method to make Leader and Follower take a step.
	 */
	public void step()
	{
		if (forward)
		{
			if (follow.moveForward(-64) == false)
			{
				moveForward(-64);
				follow.moveForward(64);
				forward = false;
			}
			else
			{
				moveForward(64);
			}
		}
		else
		{
			if (moveForward(-64) == false)
			{
				follow.moveForward(-64);
				moveForward(64);
				forward = true;
			}
			else
			{
				follow.moveForward(64);
			}
		}
	}

	/**
	 * Overridden method from DancingPanda superclass, does same thing
	 * as DancingPanda's draw method except it also draws a big blue
	 * "L" (for Leader) on the TravelingPanda.
	 */
	public void draw ()
    {
        super.draw();
        Font font = new Font("Arial", Font.BOLD, 60);
        StdDraw.setFont(font);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.text(getX(), getY(), "L");
    }
}
