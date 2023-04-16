/*
class ParentClass
{
	private String idiom;
	public ParentClass() 
	{ 
		idiom = new String("");
		setPhrase("Your ");
	}
	public void setPhrase(String str) 
	{ 
		setMorePhrase(str);
		idiom += str + "mine"; 
	}
	public void setMorePhrase(String str)
	{
		idiom += str + "as good ";
	}
	public String toString() 
	{ 
		return idiom; 
	}
}

public class ChildClass extends ParentClass
{
	public void setPhrase(String str) 
	{ 
		super.setPhrase(str + "guess is "); 
	}
	public String toString() 
	{  
		return super.toString(); 
	}
	
	public static void main(String [] args)
	{
		ParentClass parent = new ParentClass();
		System.out.println(parent);
		ParentClass child = new ChildClass();
		System.out.println(child);
	}
}
*/

class ParentClass
{
	private String idiom;
	public ParentClass() 
	{ 
		idiom = new String("");
		setPhrase("Your guess ");
	}
	public void setPhrase(String str) 
	{ 
		setMorePhrase(str);
		idiom += str + "as mine"; 
	}
	public void setMorePhrase(String str)
	{
		idiom += str + "good ";
	}
	public String toString() 
	{ 
		return idiom; 
	}
}

public class ChildClass extends ParentClass
{
	public void setPhrase(String str) 
	{ 
		super.setPhrase(str + "is "); 
	}
	public String toString() 
	{  
		return super.toString(); 
	}
	
	public static void main(String [] args)
	{
		ParentClass parent = new ParentClass();
		System.out.println(parent);
		ParentClass child = new ChildClass();
		System.out.println(child);
	}
}

