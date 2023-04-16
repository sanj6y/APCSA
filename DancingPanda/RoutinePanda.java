/**
 * RoutinePanda.java
 * 
 * A subclass of DancingPanda, with the step method written
 * to make the RoutinePanda move according to a certain given
 * routine.
 * 
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 11/15/21
 */

import java.awt.Color;

public class RoutinePanda extends DancingPanda
{
	private int currentMove;
	private PandaConstants.DanceStep[] moves;
	
	/**
	 * Creates a new RoutinePanda at the given location with the given color,
	 * using the superclass DancingPanda's constructor. Also sets the field
	 * variable moves to get the series of steps that the DancingPanda will
	 * carry out.
	 * @param x the RoutinePanda's x location
	 * @param y the RoutinePanda's y location
	 * @param c the RoutinePanda's color
	 * @param mov the array of steps for the RoutinePanda to carry out
	 */
	public RoutinePanda(int x, int y, Color c, PandaConstants.DanceStep[] mov)
	{
		super(x, y, c);
		currentMove = 0;
		moves = mov;
	}
	
	/**
	 * Creates a new RoutinePanda at the given location, with the given color, 
	 * facing in the given direction, using the superclass DancingPanda's constructor.
	 * Also sets the field variable moves to get the series of steps that the
	 * DancingPanda will carry out.
	 * @param x the RoutinePanda's x location
	 * @param y the RoutinePanda's y location
	 * @param c the RoutinePanda's color
	 * @param p the RoutinePanda's direction
	 * @param mov the array of steps for the RoutinePanda to carry out
	 */
	public RoutinePanda(int x, int y, Color c, Point p, PandaConstants.DanceStep[] mov)
	{
		super(x, y, c, p);
		currentMove = 0;
		moves = mov;
	}

	/**
	 * Getter for moves array.
	 */
	public PandaConstants.DanceStep[] getMoves()
	{
		return moves;
	}

	/** 
	 * Setter for currentMove.
	 */
	public void setCurrentMove(int newCurrentMove)
	{
		currentMove = newCurrentMove;
	}

	/**
	 * Getter for currentMove.
	 */
	public int getCurrentMove()
	{
		return currentMove;
	}
	
	/**
	 * An overridden method that causes the RoutinePanda to perform a single dance step
	 * according to moves (given array of steps for the RoutinePanda to carry out).
	 */
	public void step()
	{
		if (moves[currentMove] == PandaConstants.DanceStep.FORWARD)
			moveForward(64);
		else if (moves[currentMove] == PandaConstants.DanceStep.BACKWARD)
			moveForward(-64);
		else if (moves[currentMove] == PandaConstants.DanceStep.RIGHT)
			moveSide(64);
		else if (moves[currentMove] == PandaConstants.DanceStep.LEFT)
			moveSide(-64);
		else if (moves[currentMove] == PandaConstants.DanceStep.TURN_RIGHT)
			spinRight();
		else if (moves[currentMove] == PandaConstants.DanceStep.TURN_LEFT)
			spinLeft();

		currentMove = (currentMove + 1) % moves.length;
	}
}
