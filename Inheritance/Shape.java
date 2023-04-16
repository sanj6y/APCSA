public abstract class Shape
{
	private String color;
	
	public Shape()
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
