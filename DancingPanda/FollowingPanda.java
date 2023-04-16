/**
 * FollowingPanda.java
 * 
 * An subclass of DancingPanda, written to follow a
 * Leader's steps.
 * 
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 11/18/2021
 */
 
import java.awt.Color;
import java.awt.Font;
 
public class FollowingPanda extends DancingPanda
{
	
	/**
	 * Creates a new FollowingPanda at the given location with the given color,
	 * using the superclass DancingPanda's constructor.
	 * @param l			the Leader that this FollowingPanda will get
	 * 					its position and direction from and will follow
	 * @param c			the FollowingPanda's color
	 */
	public FollowingPanda(Leader l, Color c)
	{
		super(l.getLocation().getX(), l.getLocation().getY(), c, l.getLocation());
		l.addFollower(this);
	}
	
	/**
	 * Creates a new FollowingPanda at the given location, with the given color, 
	 * facing in the given direction, using the superclass DancingPanda's constructor.
	 * @param l		the Leader that this FollowingPanda will follow
	 * @param x		the FollowingPanda's x location
	 * @param y		the FollowingPanda's y location
	 * @param c 	the FollowingPanda's color
	 * @param p		the FollowingPanda's direction
	 */
	public FollowingPanda(Leader l, int x, int y, Color c, Point p)
	{
		super(x, y, c, p);
		l.addFollower(this);
	}
	
	/**
	 * An overridden method that causes the FollowingPanda to perform a single dance step
	 * (does nothing here because the FollowingPanda will follow the Leader's steps).
	 */
	public void step()
	{
	}

	/**
	 * Overridden method from DancingPanda superclass, does same thing
	 * as DancingPanda's draw method except it also draws a big blue
	 * "F" (for Follower) on the FollowingPanda.
	 */
	public void draw ()
    {
        super.draw();
        Font font = new Font("Arial", Font.BOLD, 60);
        StdDraw.setFont(font);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.text(getX(), getY(), "F");
    }
}
