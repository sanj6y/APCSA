

public class PracticeTest 
{
	public static void main(String[] args) 
	{
		PracticeTest run = new PracticeTest();
		run.methods();
	}
	
	public void methods ( )
	{
		System.out.println("\n\n");
		jumble();
		System.out.println("\n\n");
		System.out.println(guessTheString("MickeyMouse"));
		System.out.println("\n\n");
		runMomAndSon();
		System.out.println("\n\n");
		checkStrings();
		System.out.println("\n\n");
		System.out.println(exOut("Good work", "o"));
		System.out.println(exOut("Hello there!", "ere"));
		System.out.println(exOut("This is bliss.", "is"));
		System.out.println(repeatBuild("Monta"));
		System.out.println(repeatBuild("cool"));
		System.out.println(repeatBuild("Crazy"));
		System.out.println(repeatBuild("Loopy")); 
		System.out.println(repeatBuild(""));
		System.out.println("\n\n");
	}
	
	public void jumble ( )
	{
		String word = new String("JUMBLE");
		String result = new String("");
		for(int i = 1; i < word.length(); i++)
		{
			result += word.substring(i,i+1);
			if(i+2 < word.length())
			{
				result += word.substring(i,i+2);
			}
			System.out.println(result);
		}
	}
	
	public String guessTheString(String word) 
	{					
		String result = new String("");	
		char first = word.toLowerCase().charAt(0);
		switch (first) 
		{
			case 'a': case 'e': case 'i': case 'o': case 'u':
				result = word + "-ay";
				break;
			default:
				result = word.substring(1,2).toUpperCase() + 
					word.substring(2) + "-" + first + "ay";
		}
		return result;
	}
	
	public void runMomAndSon ( )
	{
		SonClass sc = new SonClass();
		MomClass mc = new SonClass();
		sc.instanceMethod();
		mc.instanceMethod();
		sc.staticMethod();
		mc.staticMethod();
	}
	
	public void checkStrings ( )
	{
		String goodGuy = new String("road runner");
		String badGuy = new String("coyote");
		String oneChar = "A";
		String animal = goodGuy;
		goodGuy = "road runner";

		System.out.println(badGuy.length());
		System.out.println(badGuy.indexOf('e'));	
		System.out.println(oneChar + 5);
		System.out.println(animal == goodGuy);	
		System.out.println(animal.equals(goodGuy));
		System.out.println(badGuy.substring(0,3) + goodGuy.substring(4));	
	}
	
	public String exOut(String phrase, String keep)
	{
		int index = phrase.indexOf(keep);
		int start = 0;
		while(index != -1 && index < phrase.length())
		{
		    for(int i = start; i < index; i++)
			{
				phrase = phrase.substring(0,i) + "X" + phrase.substring(i+1);
			}
			start = index+keep.length();
			index = phrase.indexOf(keep,index+1);
		}
		for(int i = start; i < phrase.length(); i++)
		{
			phrase = phrase.substring(0,i) + "X" + phrase.substring(i+1);
		}
		return phrase;
	}
	
	public String repeatBuild(String word)
	{
		String result = new String("");
		for(int i = 0; i < word.length(); i++)
		{
			result += word.substring(0,word.length()-i);
		}
		return result;
	}
}

class MomClass 
{
	public static void staticMethod() 
	{
		System.out.println("MomClass staticMethod");
	}
	public void instanceMethod() 
	{
		System.out.println("MomClass instanceMethod");
	}
}

class SonClass extends MomClass 
{
	public static void staticMethod() 
	{
		System.out.println("SonClass staticMethod");
	}
	public void instanceMethod() 
	{
		System.out.println("SonClass instanceMethod");
	}
}

class Horse 
{
	private String name;
	
	public Horse(String n) 
	{
		name = n;
	}
	
	public void setName(String n) 
	{
		name = n;
	}
	
	public String getName() 
	{
		return name;
	}
}

class Arabian extends Horse 
{
	private String prize;
	
	public Arabian(String n, String p) 
	{
		super(n);		// LINE 1
//		name = n;
//		setName(n);
//		super.setName(n);
		prize = p;
	}
	
	public String getPrize() 
	{
		return prize;
	}
}