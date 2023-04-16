import java.awt.Color;

public class Tree
{
	public static void main(String[] args)
	{
		int n = 5;
		if (args.length > 0)
		{
			n = Integer.parseInt(args[0]);
		}

		double x = 0.5;
		double y = 0;
		double angle = Math.PI / 2;
		double length = 0.3;

		StdDraw.setCanvasSize(800, 800);

		StdDraw.enableDoubleBuffering();

		if (n <= 7)
			StdDraw.setPenRadius(0.005);
		
		tree(n, x, y, angle, length);

	}

	public static void tree(int n, double x, double y, double angle, double length)
	{
		if (n == 0)
			return;

		double bendAngle = Math.toRadians(15);
		double branchAngle = Math.toRadians(37);
		double branchRatio = 0.65;

		double xc = x + Math.cos(angle) * length;
		double yc = y + Math.sin(angle) * length;
		StdDraw.setPenColor(new Color(50 + (int) (Math.random() * 150), (int) (Math.random() * 100), 0).brighter());
		StdDraw.line(x, y, xc, yc);

		tree(n - 1, xc, yc, angle + bendAngle - branchAngle, length * branchRatio);
		tree(n - 1, xc, yc, angle + bendAngle + branchAngle, length * branchRatio);
		tree(n - 1, xc, yc, angle + bendAngle, length * (1 - branchRatio));

		StdDraw.show();

	}
}