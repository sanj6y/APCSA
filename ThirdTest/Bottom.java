class Top
{
	private String phrase;
	public Top() 
	{ 
		setPhrase("Top"); 
	}
	public void setPhrase(String str) 
	{ 
		phrase = str + " and Top"; 
	}
	public String toString() 
	{ 
		return phrase; 
	}
}

public class Bottom extends Top
{
	public void setPhrase(String str) 
	{ 
		super.setPhrase(str + " and Bottom"); 
	}
	public String toString() 
	{  
		return super.toString(); 
	}
	
	public static void main(String [] args)
	{
		Top t1 = new Top();
		System.out.println(t1);
		Top t2 = new Bottom();
		System.out.println(t2);
	}
}
