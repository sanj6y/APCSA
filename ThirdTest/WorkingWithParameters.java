public class WorkingWithParameters
{
	public static void main (String [] args)
	{
		WorkingWithParameters run = new WorkingWithParameters();
		run.changeValues();
		run.changeMore();
	}
	public void changeValues ( )
	{
		char letter1 = 'c', letter2 = 's';
		printLetters(letter1, letter2);
		changeLetters(letter1, letter2);
		printLetters(letter1, letter2);
	}
	
	public void printLetters (char let1, char let2)
	{
		System.out.println(let1 + "  " + let2);
	}
	
	public void changeLetters (char let1, char let2)
	{
		let1 = 'a';
		let2 = 'p';
		printLetters(let1, let2);
	}
	
	public void changeMore ( )
	{
		String course = "APCS", name = "JAVA";
		printStrings(course, name);
		changeStrings(course, name);
		printStrings(course, name);
	}
	
	public void printStrings (String s1, String s2)
	{
		System.out.println(s1 + "  " + s2);
	}
	
	public void changeStrings (String s1, String s2)
	{
		s1 = new String("MONTA");
		s2 = new String("VISTA");
		printStrings(s1, s2);
	}
}