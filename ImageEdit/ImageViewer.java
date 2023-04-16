import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;

public class ImageViewer 
{ 
	private int currentX;
	private int currentY;
	private int maxY;

	public ImageViewer ( )
	{ 
		currentX = maxY = 0;
		currentY = 900;
	}

	public static void main(String [] args)
	{
		ImageViewer run = new ImageViewer();
		run.setUpCanvas();
		run.drawImages();
    } 

	public void setUpCanvas ( )
	{
		StdDraw.setCanvasSize(1800, 900);
		StdDraw.setXscale(0, 1800);
		StdDraw.setYscale(0, 900);
		StdDraw.clear(StdDraw.GRAY);
        StdDraw.setPenRadius(0);
		
		StdDraw.enableDoubleBuffering();
	}
	
	public void drawImages ( )
	{
		openFileAndDraw("result1.ppm");
		openFileAndDraw("result2.ppm");
		openFileAndDraw("result3.ppm");
		openFileAndDraw("result4.ppm");
		openFileAndDraw("result5.ppm");
		openFileAndDraw("result6.ppm");
		openFileAndDraw("result7.ppm");
		openFileAndDraw("result8.ppm");
		StdDraw.show();
	}
	
	public void openFileAndDraw(String infilename)
	{
		int r = 0, g = 0, b = 0;
		Scanner infile = OpenFile.openToRead(infilename);
		infile.next();					// pick up the "P3" magic number.
		int column = infile.nextInt();		// pick up the number of columns.
		int row = infile.nextInt();			// pick up the number of rows.
		if(currentX + column > 1800)
		{
			currentY -= maxY;
			currentX = maxY = 0;
		}
		int maxval = infile.nextInt();		// pick up the maximum integer value.
		Pixel [][] tempArray = new Pixel [row][column];
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < column; j++)
			{
				r = infile.nextInt();
				g = infile.nextInt();
				b = infile.nextInt();
				StdDraw.setPenColor(new Color(r, g, b));
				StdDraw.point(currentX + j, currentY - 1 - i);
			}
		}
		if(row > maxY)
		{
			maxY = row;
		}
		currentX += column;
		infile.close();
	}
} 