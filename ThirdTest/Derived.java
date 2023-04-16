class Base
{
	private String wisdom;
	public Base() 
	{ 
		setPhrase("Early to bed");
	}
	public void setPhrase(String str) 
	{ 
		wisdom = str + " and "; 
	}
	public String toString() 
	{ 
		return wisdom; 
	}
}

public class Derived extends Base
{
	public void setPhrase(String str) 
	{ 
		super.setPhrase(str + " early to rise"); 
	}
	public String toString() 
	{  
		return super.toString(); 
	}
	
	public static void main(String [] args)
	{
		Base b1 = new Base();
		System.out.println(b1);
		Base d2 = new Derived();
		System.out.println(d2);
	}
}
