/**
 * A two-dimensional point, with
 * getters and setters.
 * 
 * @author Scott DeRuiter
 * @version 5/2/2022
 */
public class Point
{
	/**  The x coordinate of the point      */
    private double xPosition;
	
	/**  The y coordinate of the point      */
    private double yPosition;

    /**
     * Constructs a point object.
     * 
     * @param x        position on the X-axis
     * @param y        position on the Y-axis
     */
    public Point(double x, double y)
    {
        xPosition = x;
        yPosition = y;
    }

    /**
     * Copy constructor.
     * 
     * @param other    the point to copy
     */
    public Point(Point other)
    {
        this(other.getX(), other.getY());
    }

    /**
     * @return the x coordinate
     */
    public double getX()
    {
        return xPosition;
    }

    /**
     * @return the y coordinate
     */
    public double getY()
    {
        return yPosition;
    }

    /**
     * Set the x position of the point.
     * 
     * @param x         the new X position
     */
    public void setX(double x)
    {
        xPosition = x;
    }

    /**
     * Set the y position of the point.
     * 
     * @param y         the new y position.
     */
    public void setY(double y)
    {
        yPosition = y;
    }
	
    /**
     * Evaluate and return the distance between the point and 
	 * the point in the parameter list.
     * 
     * @param other         the other point
     * @return              the distance between the two points
     */
	public double getDist(Point other)
	{
		double xdist = xPosition - other.xPosition;
		double ydist = yPosition - other.yPosition;
		return Math.sqrt(xdist * xdist + ydist * ydist);
	}

    /**
     * @return String representation of this point as
     *         "(xPosition, yPosition)"
     */
    public String toString()
    {
		return String.format("(%.3f, %.3f)", xPosition, yPosition);
    }
}