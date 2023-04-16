/*************************************************************************
 *  DO NOT MODIFY THIS FILE
 *
 *  Time the two heuristics by generated random instances of size n.
 *
 *  % java -Xint BestPathTimer 1000
 *
 *
 *  Best Path length = 26338.42949015926
 *  Nearest insertion:  0.056 seconds
 *
 *  Best Path length = 15505.745750759515
 *  Smallest insertion:  0.154 seconds
 *
 *
 *  The -Xint flag turns off various compiler optimizations, which
 *  helps normalize and stabilize the timing data that you collect.
 *
 *************************************************************************/

public class BestPathTimer 
{
	public static void main(String[] args) 
	{
		double lo = 10.0, hi = 740.0;
		int n = 1000;
		if(args.length > 0)
		{
			n = Integer.parseInt(args[0]);
		}

		// generate data and run nearest insertion heuristic
		Stopwatch timer1 = new Stopwatch();
		BestPath path1 = new BestPath();
		for (int i = 0; i < n; i++) 
		{
			double x = lo + Math.random()*(hi - lo);
			double y = lo + Math.random()*(hi - lo);
			Point p = new Point(x, y);
			path1.insertPointAtNearestNeighbor(p);
		}
		double length1 = path1.length();
		double elapsed1 = timer1.elapsedTime();
		System.out.println("\n\n\nBest Path length = " + length1);
		System.out.println("Nearest insertion:  " + elapsed1 + " seconds");
		System.out.println();

		// generate data and run smallest insertion heuristic
		Stopwatch timer2 = new Stopwatch();
		BestPath path2 = new BestPath();
		for (int i = 0; i < n; i++) 
		{
			double x = lo + Math.random()*(hi - lo);
			double y = lo + Math.random()*(hi - lo);
			Point p = new Point(x, y);
			path2.insertPointAtSmallestIncrease(p);
		}
		double length2 = path2.length();
		double elapsed2 = timer2.elapsedTime();
		System.out.println("Best Path length = " + length2);
		System.out.println("Smallest insertion:  " + elapsed2 + " seconds\n\n\n");
	}
}
