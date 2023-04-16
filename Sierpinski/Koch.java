public class Koch
{
    static double x;
    static double y;
    static double angle;

    public static void main(String[] args)
    {
        x = 0;
        y = 0;
        angle = 0;

        StdDraw.setCanvasSize(800, 800);

        int n = 5;
        if (args.length > 0)
            n = Integer.parseInt(args[0]);

        double step = 1.0 / Math.pow(3.0, n);
        koch(n, step);
    }

    public static void koch(int n, double step)
    {
        if (n == 0)
        {
            double oldX = x;
            double oldY = y;
            x += step * Math.cos(Math.toRadians(angle));
            y += step * Math.sin(Math.toRadians(angle));

            StdDraw.line(oldX, oldY, x, y);

            return;
        }

        koch(n - 1, step);
        angle += 60;
        koch(n - 1, step);
        angle -= 120;
        koch(n - 1, step);
        angle += 60;
        koch(n - 1, step);

    }
}