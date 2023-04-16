/**
 * DanceFloor3.java
 * 
 * A "dance floor", where we can test the different types of
 * DancingPandas that have been created.  The dance floor uses the
 * dimensions found in the PandaConstants file, to set up a 
 * screen width and height.  An array of 50 DancingPandas is
 * created, and the Pandas are instantiated and added to this array.
 * An endless loop is created, so that the Pandas can dance without
 * ceasing.
 *
 * @author Scott DeRuiter
 * @version 1.0
 * @since 11/18/2021
 */

import java.awt.Color;
import java.awt.Font;

public class DanceFloor3
{ 
	/**  An array that stores all of the DancingPanda variants.               */
	private DancingPanda [] panda;
	
	/** 
	 *  Creates a DanceFloor object.  A no-args constructor.  
	 *  Sets up the size of the DancingPanda array.
	 */
	public DanceFloor3 ( )
	{
		panda = new DancingPanda[50];
	}

	/**
	 *  The main method, to create an instance of the DanceFloor.  The canvas
	 *  is set up, and the GUI runs.
	 */
	public static void main(String[] args)
	{
		DanceFloor3 dance = new DanceFloor3();
		dance.setUpCanvas();
		dance.runGUI();
	}
	
	/** 
	 *  Sets up the canvas, using methods from StdDraw.  This includes
	 *  setting up the canvas size, the horizontal scale (Xscale), and
	 *  the vertical scale (Yscale).  Double buffering is enabled, so that
	 *  the animation will run smoothly.
	 */
	public void setUpCanvas ( )
	{
		StdDraw.setCanvasSize(PandaConstants.SCREEN_WIDTH, PandaConstants.SCREEN_HEIGHT);
		StdDraw.setXscale(0, PandaConstants.SCREEN_WIDTH);
		StdDraw.setYscale(0, PandaConstants.SCREEN_HEIGHT);

		StdDraw.enableDoubleBuffering();
	}
	
	/** 
	 *  Runs the Graphical User Interface.  Pandas are added, and the loop runs without
	 *  stopping.  With each iteration of the loop the Pandas are drawn, and then
	 *  the next dance step is taken by all Pandas on the DanceFloor.
	 */
	public void runGUI ( )
	{
		boolean partyOn = true;
		int counter = 0;
		int rememberThisOne = -1;
		addPandas();
		while(partyOn)
		{
			StdDraw.clear(new Color(0,0,95));
			drawPandas();
			StdDraw.show();
			StdDraw.pause(PandaConstants.DRAW_DELAY);
			allPandasTakeNextDanceStep();
			counter++;
			if(counter == 17)
			{
				counter = 0;
				if(rememberThisOne != -1)
				{
					((RoutineLeaderPanda)panda[4]).addFollower(panda[rememberThisOne]);
				}
				rememberThisOne = (int)(Math.random() * (18 - 5 + 1) + 5);
				((RoutineLeaderPanda)panda[4]).removeFollower(panda[rememberThisOne]);
			}
		}
	}
	
	/** 
	 *  Adds DancingPandas to the array.
	 */

	public void addPandas ( )
	{
		panda[0] = new TravelingPanda(40, 40, Color.RED, PandaConstants.EAST);
		panda[1] = new FollowingPanda((Leader)panda[0], Color.WHITE);
		panda[2] = new TravelingPanda(1160, 760, Color.RED, PandaConstants.WEST);
		panda[3] = new FollowingPanda((Leader)panda[2], Color.WHITE);
		panda[4] = new RoutineLeaderPanda(600, 400, Color.RED, PandaConstants.NORTH, new PandaConstants.DanceStep[]{PandaConstants.DanceStep.LEFT, PandaConstants.DanceStep.FORWARD, 
			PandaConstants.DanceStep.TURN_RIGHT, PandaConstants.DanceStep.FORWARD, PandaConstants.DanceStep.TURN_LEFT, PandaConstants.DanceStep.TURN_LEFT, PandaConstants.DanceStep.PAUSE,
			PandaConstants.DanceStep.BACKWARD, PandaConstants.DanceStep.TURN_RIGHT, PandaConstants.DanceStep.BACKWARD, PandaConstants.DanceStep.BACKWARD, PandaConstants.DanceStep.LEFT,
			PandaConstants.DanceStep.LEFT, PandaConstants.DanceStep.FORWARD, PandaConstants.DanceStep.RIGHT, PandaConstants.DanceStep.PAUSE, PandaConstants.DanceStep.PAUSE});
		panda[5] = new FollowingPanda((Leader)panda[4], 600, 560, Color.WHITE, PandaConstants.NORTH);
		panda[6] = new FollowingPanda((Leader)panda[4], 760, 560, Color.WHITE, PandaConstants.NORTH);
		panda[7] = new FollowingPanda((Leader)panda[4], 760, 400, Color.WHITE, PandaConstants.NORTH);
		panda[8] = new FollowingPanda((Leader)panda[4], 760, 240, Color.WHITE, PandaConstants.NORTH);
		panda[9] = new FollowingPanda((Leader)panda[4], 600, 240, Color.WHITE, PandaConstants.NORTH);
		panda[10] = new FollowingPanda((Leader)panda[4], 440, 240, Color.WHITE, PandaConstants.NORTH);
		panda[11] = new FollowingPanda((Leader)panda[4], 440, 400, Color.WHITE, PandaConstants.NORTH);
		panda[12] = new FollowingPanda((Leader)panda[4], 440, 560, Color.WHITE, PandaConstants.NORTH);
		panda[13] = new FollowingPanda((Leader)panda[4], 920, 240, Color.WHITE, PandaConstants.NORTH);
		panda[14] = new FollowingPanda((Leader)panda[4], 920, 400, Color.WHITE, PandaConstants.NORTH);
		panda[15] = new FollowingPanda((Leader)panda[4], 920, 560, Color.WHITE, PandaConstants.NORTH);
		panda[16] = new FollowingPanda((Leader)panda[4], 280, 240, Color.WHITE, PandaConstants.NORTH);
		panda[17] = new FollowingPanda((Leader)panda[4], 280, 400, Color.WHITE, PandaConstants.NORTH);
		panda[18] = new FollowingPanda((Leader)panda[4], 280, 560, Color.WHITE, PandaConstants.NORTH);
	}
	
	/** 
	 *  Draws DancingPandas on the DanceFloor.
	 */
	public void drawPandas ( )
	{			
		for(int i = 0; i < panda.length; i++)
		{
			if(panda[i] != null)
			{
				panda[i].draw();
			}
		}
	}
	
	/** 
	 *  All of the DancingPandas in the array take the next dance step.
	 */
	public void allPandasTakeNextDanceStep ( )
	{			
		for(int i = 0; i < panda.length; i++)
		{
			if(panda[i] != null)
			{
				panda[i].step();
			}
		}
	}
}
