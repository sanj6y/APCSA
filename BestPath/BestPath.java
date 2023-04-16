/**
 * BestPath.java
 *
 * A program that uses the Nearest Neighbor Heuristic
 * and Smallest Increase Heuristic to find optimal
 * solutions to the common problem, the Traveling Salesman
 * problem. 
 *
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 5/2/2022
 */

import java.awt.Color;

public class BestPath
{
	/** A pointer to the first ListNode in the LinkedList. */
	private ListNode first;
	
	/** Constructor that initializes first ListNode to null. */
	public BestPath()
	{
		first = null;
	}
	
	/** Returns the number of elements in the LinkedList. */
	public int size ( )
	{
		int count = 1;
		ListNode temp = first;
		
		if (temp == null)
			return 0;
		
		while (temp.getNext() != null)
		{
			count++;
			temp = temp.getNext();
		}
		
		return count;
	}
	
	/** Returns the total length between each point in the LinkedList. */
	public double length ( )
	{
		double length = 0;
		
		if (first == null)
			return length;
		
		ListNode node = first;
		while (node.getNext() != null)
		{
			length += ((Point)(node.getValue())).getDist((Point)(node.getNext().getValue()));
			node = node.getNext();
		}
		length += ((Point)(node.getValue())).getDist((Point)(first.getValue()));
		return length;
	}
	
	/** Uses Nearest Neighbor Heurisic to determine nearest neighbor to
	 *  a certain Point in the LinkedList, then inserts the passed in
	 * 	Point object into the LinkedList at that optimal position. */ 
	public void insertPointAtNearestNeighbor(Point p)
	{
		double shortest = Double.MAX_VALUE;		
		if (first == null)
		{
			first = new ListNode(p);
			return;
		}

		ListNode temp = first;
		ListNode best = null;
		
		while (temp != null)
		{
			double dist = p.getDist((Point)(temp.getValue()));
			if (dist < shortest)
			{
				shortest = dist;
				best = temp;
			}
			temp = temp.getNext();
		}
		
		best.setNext(new ListNode(p, best.getNext()));
	}
	
	/** Uses Smallest Increase Heurisic to determine smallest increase
	 *  from a certain Point in the LinkedList to the passed in Point,
	 * 	then draws line to add Point object into the LinkedList at an optimal position. */
	public void insertPointAtSmallestIncrease(Point p)
	{
		
		if (first == null)
		{
			first = new ListNode(p);
			return;
		}
		
		if (first.getNext() == null)
		{
			first.setNext(new ListNode(p));
			return;  
		}

		double bestDist = increaseInPathLength((Point)first.getValue(), (Point)first.getNext().getValue(), p);
		ListNode node = first.getNext(), best = first;
		
		while (node != null)
		{
			double dist = 0.0;
			if (node.getNext() == null)
				dist = increaseInPathLength((Point)node.getValue(), (Point)first.getValue(), p);
			else
				dist = increaseInPathLength((Point)node.getValue(), (Point)node.getNext().getValue(), p);
			if (dist < bestDist)
			{
				best = node;
				bestDist = dist;
			}
			node = node.getNext();
		}
		
		best.setNext(new ListNode(p, best.getNext()));
	}
	
	/**
	 * Calculates the increase in path length that would occur
	 * if the Point p was inserted in between p1 and p2.
	 */
	public double increaseInPathLength(Point p1, Point p2, Point p)
	{
		return p1.getDist(p) + p2.getDist(p) - p1.getDist(p2);
	}
	
	//  You'll need other methods
	
	/**
	 * Draws all Points in the LinkedList and draws lines to connect all Points
	 * at optimal positions.
	 */
	public void draw ( )
	{
		int radius = 4;
		int count = 0;
		ListNode node = first;
		while(node != null)
		{
			double x = getX(node);
			double y = getY(node);
			StdDraw.setPenColor(new Color(0, 0, 255));

			if (node.getNext() == null)
				StdDraw.line(x, y, getX(first), getY(first));
			else
				StdDraw.line(x, y, getX(node.getNext()), getY(node.getNext()));
			
			StdDraw.setPenColor(new Color(255, 0, 0));
			StdDraw.filledCircle(x, y, radius);
			
			node = node.getNext();
		}
	}
	
	/** Helper method to return x-value of the Point of a specific ListNode in the LinkedList. */
	public double getX(ListNode node)
	{
		return ((Point)(node.getValue())).getX();
	}
	
	/** Helper method to return x-value of the Point of a specific ListNode in the LinkedList. */
	public double getY(ListNode node)
	{
		return ((Point)(node.getValue())).getY();
	}
	
	/** String representation of complete BestPath object. */
    public String toString()
    {
		int count = 0;
		ListNode node = first;
		String result = new String("");
		while(node != null)
		{
			result += String.format("%4d: %s%n",count,(Point)node.getValue());
			node = node.getNext();
			count++;
		}
		return result;
    }
}
