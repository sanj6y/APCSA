public class Weight
{
	private int pounds;
	
	public Weight(int lbs)
	{
		pounds = lbs;
	}
	
	public void increase(int more)
	{
		pounds += more;
	}
	
	public void decrease(int less)
	{
		pounds -= less;
	}
	
	public int getWeight ( )
	{
		return pounds;
	}
}