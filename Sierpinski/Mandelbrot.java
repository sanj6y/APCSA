import java.awt.Color;
import java.awt.image.*;
import java.awt.Graphics2D;

public class Mandelbrot extends javax.swing.JPanel {

    // return number of iterations to check if c = a + ib is in Mandelbrot set
    public static int mand(Complex z0, int max) {
        Complex z = z0;
        for (int t = 0; t < max; t++)
        {
            if (z.abs() > 2.0) return t;
            z = z.times(z).plus(z0);
        }
        return max;
    }

    public static void main(String[] args)
    {
        double xc = Double.parseDouble(args[0]);
        double yc = Double.parseDouble(args[1]);
        double size = Double.parseDouble(args[2]);

        int n = 512;   // create n-by-n image
        int max = 255;   // maximum number of iterations

        BufferedImage image = new BufferedImage(n, n, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                double x0 = xc - size/2 + size*i/n;
                double y0 = yc - size/2 + size*j/n;
                Complex z0 = new Complex(x0, y0);
                int gray = max - mand(z0, max);
                Color color = new Color(gray, gray, gray);
                int rgb = color.getRGB();
                image.setRGB(i, n-1-j, rgb);
            }
        }

        Graphics2D g = image.createGraphics();
        g.drawImage(image, 0, 0, null);
        super.paint(g);
    }
}
