public class Rectangle implements Relatable
{
	public int width = 0;
	public int height = 0;
	public Point origin;
	
	// four constructors
	public Rectangle()
	{
		origin = new Point(0,0);
	}
	
	public Rectangle(Point p)
	{
		origin = p;
	}
	
	public Rectangle(int w, int h)
	{
		origin = new Point(0,0);
		width = w;
		height = h;
	}
	
	public static void main (String [] args)
	{
		Rectangle rect1 = new Rectangle(new Point(3,4), 8, 9);
		Rectangle rect2 = new Rectangle(new Point(-4,2), 5, 14);
		
		System.out.println("\n\n" + rect1.isLargerThan(rect2) + "\n\n");
	}
	
	public Rectangle(Point p, int w, int h)
	{
		origin = p;
		width = w;
		height = h;
	}
	
	// a method for moving the rectangle
	public void move(int x, int y)
	{
		origin.x = x;
		origin.y = y;
	}
	
	// a method for computing the area of the rectangle
	public int getArea()
	{
		return width * height;
	}
	
	// a method required to implement the Relatable interface
	public int isLargerThan(Relatable other)
	{
		Rectangle otherRect = (Rectangle)other;
		if (this.getArea() < otherRect.getArea())
			return -1;
		else if (this.getArea() > otherRect.getArea())
			return 1;
		else
			return 0;
	}
}

class Point
{
	public int x = 0;
	public int y = 0;
	
	// a constructor!
	public Point(int a, int b)
	{
		x = a;
		y = b;
	}
}

interface Relatable
{	
	// this (object calling isLargerThan) and
	// other must be instances of the same class
	// returns 1, 0, -1 if this is greater
	// than, equal to, or less than other
	public int isLargerThan(Relatable other);
}