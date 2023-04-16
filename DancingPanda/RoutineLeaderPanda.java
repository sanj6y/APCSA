/**
 * RoutineLeaderPanda.java
 * 
 * A subclass of RoutinePanda to move in
 * a certain given routine, and have some
 * amount of FollowingPandas following
 * the RoutineLeaderPanda's movements.
 * 
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 11/18/2021
 */

import java.awt.Color;
import java.awt.Font;

public class RoutineLeaderPanda extends RoutinePanda implements Leader
{
    private FollowingPanda[] followers;
    private int followerCount;

    /**
     * Creates a new RoutineLeaderPanda at the given location with the given
     * color, using the superclass RoutinePanda's constructor. Also sets the
     * field variable followerCount to track the number of FollowingPandas
     * that are following the RoutineLeaderPanda, and sets the field variable
     * followers for the actual FollowingPandas following the RoutineLeaderPanda.
     * @param x the RoutinePanda's x location
     * @param y the RoutinePanda's y location
     * @param c the RoutinePanda's color
     * @param moves the array of steps for the RoutinePanda to carry out
     */
    public RoutineLeaderPanda(int x, int y, Color c, PandaConstants.DanceStep[] moves)
    {
        super(x, y, c, moves);
        followers = new FollowingPanda[20];
        followerCount = 0;
    }

    /**
     * Creates a new RoutineLeaderPanda at the given location, with the given color, 
     * facing in the given direction, using the superclass RoutinePanda's constructor.
     * Also sets the field variable followerCount to track the number of FollowingPandas
     * that are following the RoutineLeaderPanda, and sets the field variable followers
     * for the actual FollowingPandas following the RoutineLeaderPanda.
     * @param x the RoutinePanda's x location
     * @param y the RoutinePanda's y location
     * @param c the RoutinePanda's color
     * @param p the RoutinePanda's direction
     * @param mov the array of steps for the RoutinePanda to carry out
     */
    public RoutineLeaderPanda(int x, int y, Color c, Point p, PandaConstants.DanceStep[] moves)
    {
        super(x, y, c, p, moves);
        followers = new FollowingPanda[20];
        followerCount = 0;
    }

    /**
     * Adds a follower (FollowingPanda) to the TravelingPanda.
     * Increments the followerCount to keep track of the number
     * of followers on the RoutineLeaderPanda.
     */
    public void addFollower(DancingPanda panda)
    {
        followers[followerCount] = (FollowingPanda) panda;
        followerCount++;
    }

    /**
     * Removes the given FollowingPanda from the array of
     * followers by setting it as null.
     */
    public void removeFollower(DancingPanda panda)
    {
        for (int i = 0; i < followers.length; i++)
        {
            if (panda == followers[i])
            {
                followers[i] = null;
            }
        }
    }

   /**
     * Method to make Leader and all Followers take a step.
     */
    public void step()
    {
        PandaConstants.DanceStep[] moves = getMoves();
        int count = getCurrentMove();

        count = count % moves.length;

        if (moves[count] == PandaConstants.DanceStep.FORWARD)
        {
            this.moveForward(64);
        }
        else if (moves[count] == PandaConstants.DanceStep.BACKWARD)
        {
            this.moveForward(-64);
        }
        else if (moves[count] == PandaConstants.DanceStep.TURN_LEFT)
        {
            this.spinLeft();
        }
        else if (moves[count] == PandaConstants.DanceStep.TURN_RIGHT)
        {
            this.spinRight();
        }
        else if (moves[count] == PandaConstants.DanceStep.LEFT)
        {
            this.moveSide(-64);
        }
        else if (moves[count] == PandaConstants.DanceStep.RIGHT)
        {
            this.moveSide(64);
        }

        for (int i = 0; i < followers.length; i++)
        {
            if (followers[i] != null)
            {
                if (moves[count] == PandaConstants.DanceStep.FORWARD)
                {
                    followers[i].moveForward(64);
                }
                else if (moves[count] == PandaConstants.DanceStep.BACKWARD)
                {
                    followers[i].moveForward(-64);
                }
                else if (moves[count] == PandaConstants.DanceStep.TURN_LEFT)
                {
                    followers[i].spinLeft();
                }
                else if (moves[count] == PandaConstants.DanceStep.TURN_RIGHT)
                {
                    followers[i].spinRight();
                }
                else if (moves[count] == PandaConstants.DanceStep.LEFT)
                {
                    followers[i].moveSide(-64);
                }
                else if (moves[count] == PandaConstants.DanceStep.RIGHT)
                {
                    followers[i].moveSide(64);
                } 
            }
        }
        setCurrentMove(getCurrentMove() + 1);
    }

    /**
     * Overridden method from direct superclass's (RoutinePanda)
     * superclass (DancingPanda). Does same thing as DancingPanda's
     * draw method except it also draws a big blue "L" (for Leader)
     * on the RoutineLeaderPanda.
     */
    public void draw ()
    {
        super.draw();
        Font font = new Font("Arial", Font.BOLD, 60);
        StdDraw.setFont(font);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.text(getX(), getY(), "L");
    }
}
