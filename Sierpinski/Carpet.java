import java.awt.Color;

public class Carpet
{
	public static void main(String[] args)
	{
		int n = 4;
		if (args.length > 0)
		{
			n = Integer.parseInt(args[0]);
		}
		setUpAndDrawBackGround();	
		double sideLength = 1.0 / 3.0;
		double xCenter = 0.5;
		double yCenter = 0.5;
		sierpinski(n, sideLength, xCenter, yCenter);

	}
	
	public static void setUpAndDrawBackGround()
	{
		StdDraw.setCanvasSize(800, 800); // 1000, 1000
		StdDraw.setPenColor(Color.BLACK);
		
		StdDraw.filledSquare(0.5, 0.5, (1.0/3.0)/2.0);
	}
	
	public static void sierpinski(int n, double length, double xc, double yc)
	{
		if (n == 0)
		{
			return;
		}
		drawSquare(length, xc, yc);
		sierpinski(n-1, length / 3, xc - length, yc + length);
		sierpinski(n-1, length / 3, xc, yc + length);
		sierpinski(n-1, length / 3, xc + length, yc + length);
		sierpinski(n-1, length / 3, xc - length, yc);
		sierpinski(n-1, length / 3, xc + length, yc);
		sierpinski(n-1, length / 3, xc - length, yc - length);
		sierpinski(n-1, length / 3, xc, yc - length);
		sierpinski(n-1, length / 3, xc + length, yc - length);
	}
	
	public static void drawSquare(double length, double xc, double yc)
	{
		StdDraw.setPenColor(new Color(50 + (int) (Math.random() * 150), (int)(Math.random()*100), 0).brighter());
		StdDraw.filledSquare(xc, yc, length/2);
	}
}