import java.awt.Color;

public class Snowflake
{
	private double size, color, increment, x, y, angle;
	private static int width, height, count;
	public static final double DIFFERENCE = 150;
	public static final double SECONDDIFF = 175;

	public static void main(String[] args)
	{
		int n = 5;
		if (args.length > 0)
			n = Integer.parseInt(args[0]);

		width = 650;
		height = (int) (2 * width / Math.sqrt(3));
		

		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
		
		StdDraw.clear(Color.BLACK);

		new Snowflake(n, (width - (count * DIFFERENCE)) / Math.pow(3.0, n));
		new Snowflake(n, (width - (count * SECONDDIFF)) / Math.pow(3.0, n));
		new Snowflake(n, (width - (count * DIFFERENCE)) / Math.pow(3.0, n));
		new Snowflake(n, (width - (count * DIFFERENCE)) / Math.pow(3.0, n));
		new Snowflake(n, (width - (count * DIFFERENCE)) / Math.pow(3.0, n));
	}

	public Snowflake(int n, double s)
	{
		size = s;

		if (count == 1)
		{
			x = count * SECONDDIFF / 2;
			y = (size * Math.pow(3.0, n) * Math.sqrt(3) / 2) + (count * 87.5 * 2 / Math.sqrt(3));
		}
		else
		{
			x = count * DIFFERENCE / 2;
			y = (size * Math.pow(3.0, n) * Math.sqrt(3) / 2) + (count * 75 * 2 / Math.sqrt(3));
		}

		angle = 0.0;

		// to get rainbow color effect
		color = 0.0;
		increment = Math.pow(4.0, -n) / 3.0;

		snowflake(n);
		turnLeft(-120);
		snowflake(n);
		turnLeft(-120);
		snowflake(n);

		count++;

	}

	public void snowflake(int n)
	{

		if (n == 0)
		{
			StdDraw.setPenColor(Color.getHSBColor((float) color, (float) 1.0, (float) 1.0));
			color += increment;

			double oldX = x;
            double oldY = y;
            x += size * Math.cos(Math.toRadians(angle));
            y += size * Math.sin(Math.toRadians(angle));

            StdDraw.line(oldX, oldY, x, y);

            StdDraw.show();
		}

		else
		{
			snowflake(n - 1);
			turnLeft(60);
			snowflake(n - 1);
			turnLeft(-120);
			snowflake(n - 1);
			turnLeft(60);
			snowflake(n - 1);
		}
	}

	public void turnLeft(int delta)
	{
		angle += delta;
	}
}