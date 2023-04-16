/**
 * DanceFloor2.java
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

public class DanceFloor2
{ 
	/**  An array that stores all of the DancingPanda variants.               */
	private DancingPanda [] panda;
	
	/** 
	 *  Creates a DanceFloor object.  A no-args constructor.  
	 *  Sets up the size of the DancingPanda array.
	 */
	public DanceFloor2 ( )
	{
		panda = new DancingPanda[50];
	}

	/**
	 *  The main method, to create an instance of the DanceFloor.  The canvas
	 *  is set up, and the GUI runs.
	 */
	public static void main(String[] args)
	{
		DanceFloor2 dance = new DanceFloor2();
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
		addPandas();
		while(partyOn)
		{
			StdDraw.clear(new Color(0,0,95));
			drawPandas();
			StdDraw.show();
			StdDraw.pause(PandaConstants.DRAW_DELAY);
			allPandasTakeNextDanceStep();
		}
	}
	
	/** 
	 *  Adds DancingPandas to the array.
	 */
	public void addPandas ( )
	{
		panda[0] = new TwirlingPanda(920, 760, Color.BLUE);
		panda[1] = new TwirlingPanda(1000, 760, Color.GREEN, PandaConstants.WEST);
		panda[2] = new TwirlingPanda(1080, 760, Color.GRAY, PandaConstants.NORTH);
		panda[3] = new TwirlingPanda(1160, 760, Color.ORANGE, PandaConstants.EAST);
		panda[4] = new ForwardAndBackPanda(840, 760, Color.CYAN);
		panda[5] = new ForwardAndBackPanda(760, 760, Color.RED, PandaConstants.WEST);
		panda[6] = new SideToSidePanda(680, 760, Color.MAGENTA);
		panda[7] = new SideToSidePanda(520, 760, Color.WHITE, PandaConstants.EAST);
		panda[8] = new RoutinePanda(1160, 40, Color.RED, PandaConstants.WEST, new PandaConstants.DanceStep[]{PandaConstants.DanceStep.LEFT, PandaConstants.DanceStep.TURN_LEFT, 
			PandaConstants.DanceStep.LEFT, PandaConstants.DanceStep.BACKWARD, PandaConstants.DanceStep.TURN_RIGHT, PandaConstants.DanceStep.FORWARD, PandaConstants.DanceStep.PAUSE});
		panda[9] = new RoutinePanda(1000, 40, Color.YELLOW, PandaConstants.NORTH, new PandaConstants.DanceStep[]{PandaConstants.DanceStep.FORWARD, PandaConstants.DanceStep.TURN_LEFT, 
			PandaConstants.DanceStep.FORWARD, PandaConstants.DanceStep.RIGHT, PandaConstants.DanceStep.TURN_RIGHT, PandaConstants.DanceStep.LEFT, PandaConstants.DanceStep.BACKWARD, 
			PandaConstants.DanceStep.BACKWARD, PandaConstants.DanceStep.RIGHT, PandaConstants.DanceStep.PAUSE, PandaConstants.DanceStep.RIGHT, PandaConstants.DanceStep.PAUSE, PandaConstants.DanceStep.PAUSE});
		panda[10] = new TravelingPanda(40, 120, Color.YELLOW);
		panda[11] = new FollowingPanda((Leader)panda[10], Color.ORANGE);
		((TravelingPanda)panda[10]).addFollower(panda[11]);
		panda[12] = new TravelingPanda(120, 760, Color.LIGHT_GRAY, PandaConstants.SOUTH);
		panda[13] = new FollowingPanda((Leader)panda[12], Color.ORANGE);
		((TravelingPanda)panda[12]).addFollower(panda[13]);
		panda[14] = new RoutineLeaderPanda(280, 440, Color.DARK_GRAY, PandaConstants.EAST, new PandaConstants.DanceStep[]{PandaConstants.DanceStep.LEFT, PandaConstants.DanceStep.TURN_LEFT, 
			PandaConstants.DanceStep.TURN_LEFT, PandaConstants.DanceStep.FORWARD, PandaConstants.DanceStep.BACKWARD, PandaConstants.DanceStep.TURN_RIGHT, PandaConstants.DanceStep.PAUSE,
			PandaConstants.DanceStep.LEFT, PandaConstants.DanceStep.BACKWARD, PandaConstants.DanceStep.TURN_RIGHT, PandaConstants.DanceStep.FORWARD, PandaConstants.DanceStep.PAUSE,
			PandaConstants.DanceStep.PAUSE});
		panda[15] = new FollowingPanda((Leader)panda[14], 440, 360, Color.ORANGE, PandaConstants.EAST);
		panda[16] = new FollowingPanda((Leader)panda[14], 440, 520, Color.ORANGE, PandaConstants.EAST);
		panda[17] = new FollowingPanda((Leader)panda[14], 600, 360, Color.ORANGE, PandaConstants.EAST);
		panda[18] = new FollowingPanda((Leader)panda[14], 600, 520, Color.ORANGE, PandaConstants.EAST);
		panda[19] = new FollowingPanda((Leader)panda[14], 760, 360, Color.ORANGE, PandaConstants.EAST);
		panda[20] = new FollowingPanda((Leader)panda[14], 760, 520, Color.ORANGE, PandaConstants.EAST);
		panda[21] = new FollowingPanda((Leader)panda[14], 920, 360, Color.ORANGE, PandaConstants.EAST);
		panda[22] = new FollowingPanda((Leader)panda[14], 920, 520, Color.ORANGE, PandaConstants.EAST);
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
