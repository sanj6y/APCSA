import java.util.Scanner;
import java.awt.Font;
import java.awt.Color;

public class InsertAtNearest
{
	private int HEIGHT, WIDTH, BORDER;
	private String file;
	private BestPath path;
	
	public InsertAtNearest(String fileName)
	{
		file = new String(fileName);
		path = new BestPath();
	}
	public static void main(String[] args) 
	{
		// get dimensions, set up canvas and drawing
		String f = new String("p1000.txt");
		if(args.length > 0)
		{
			f = args[0];
		}
		InsertAtNearest run = new InsertAtNearest(f);
		run.getFileInputAndCreateLinkedList();
		run.showFinalPathAndInfo();
	}
	
	public void getFileInputAndCreateLinkedList ( )
	{
		Scanner inFile = OpenFile.openToRead(file);
		WIDTH = inFile.nextInt();
		HEIGHT = inFile.nextInt();
		BORDER = 20;
		StdDraw.setCanvasSize(WIDTH, HEIGHT + BORDER);
		StdDraw.setXscale(0, WIDTH);
		StdDraw.setYscale(-BORDER, HEIGHT);
		Font font = new Font("Arial", Font.BOLD, 18);
		StdDraw.setFont(font);

		// turn on double buffering
		StdDraw.enableDoubleBuffering();
		System.out.println("\n\n");

		// run smallest insertion heuristic
		while(inFile.hasNext())
		{
			double x = inFile.nextDouble();
			double y = inFile.nextDouble();
			System.out.println(x + "   " + y);
			Point p = new Point(x, y);
			path.insertPointAtNearestNeighbor(p);
			StdDraw.clear();
			path.draw();
			StdDraw.setPenColor(new Color(0,0,0));
			StdDraw.textLeft(20, 0, "length = " + path.length());
			StdDraw.show();
			StdDraw.pause(30);
		}
	}
	
	public void showFinalPathAndInfo ( )
	{
		// draw to standard draw 
		path.draw();
		StdDraw.show();
        
		// print tour to standard output
		System.out.println("\n\n\nPATH IN ORDER OF POINTS VISITED: \n\n" + path);
		System.out.printf("Path length = %.4f\n", path.length());
		System.out.printf("Number of points = %d\n", path.size());
		System.out.println("\n\n\n");
	}
}
