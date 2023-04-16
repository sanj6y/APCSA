public abstract class BaseShape
{
	private String color;
	
	public BaseShape()
	{
		color = "YELLOW";
	}
	
	public void setColor(String c)
	{
		color = c;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public abstract double area();
}
