/**
 * Leader.java
 * 
 * An interface with simple methods to enable some
 * DancingPandas to lead other DancingPandas.
 * 
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 11/18/2021
 */

public interface Leader
{
	public abstract Point getLocation(); //so the leader can report its position to its follower(s)
	
	public abstract Point getDirection(); //so the leader can report its direction to its follower(s)
	
	public abstract void addFollower(DancingPanda panda); //so the leader can add a follower
	
	public abstract void removeFollower(DancingPanda panda); //so the leader can remove a follower
}
