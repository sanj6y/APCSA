import java.awt.Color;

public class Triangle
{
	public static void main(String[] args)
	{
		int n = 4;
		if (args.length > 0)
		{
			n = Integer.parseInt(args[0]);
		}
		setUpAndDrawBackGround();	
		double sideLength = 0.5;
		double xCenter = 0.5;
		double yCenter = 0.1 + Math.sqrt(3)/8;
		sierpinski(n, sideLength, xCenter, yCenter);

	}
	
	public static void setUpAndDrawBackGround()
	{
		StdDraw.setCanvasSize(800, 800); // 1000, 1000
		StdDraw.setPenColor(Color.BLACK);
		
		double[] x = {0, 0.5, 1.0};
		double[] y = {0.1, 0.1 + Math.sqrt(3)/2, 0.1};
		StdDraw.filledPolygon(x, y);
	}
	
	public static void sierpinski(int n, double length, double xc, double yc)
	{
		if (n == 0)
		{
			return;
		}
		drawTriangle(length, xc, yc);
		sierpinski(n-1, length / 2, xc - length / 2, yc - Math.sqrt(3) / 8 * length);
		sierpinski(n-1, length / 2, xc, yc + 3 * Math.sqrt(3) / 8 * length);
		sierpinski(n-1, length / 2, xc + length / 2, yc - Math.sqrt(3) / 8 * length);
	}
	
	public static void drawTriangle(double length, double xc, double yc)
	{
		double[] x = {xc - length / 2, xc + length / 2, xc};
		double[] y = {yc + length * Math.sqrt(3) / 4, yc + length * Math.sqrt(3) / 4, yc - length * Math.sqrt(3) / 4};
		StdDraw.setPenColor(new Color(50 + (int) (Math.random() * 150), 50 + (int) (Math.random() * 150), 50 + (int) (Math.random() * 150)));
		StdDraw.filledPolygon(x, y);
	}
			
}