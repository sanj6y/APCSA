public class ThirdTestString
{
	public static void main(String [] args)
	{
		ThirdTestString run = new ThirdTestString();
		run.method();
	}
	
	public void method ( )
	{
		String str = changeString("JAVAC");
		System.out.println("\n\n\n" + str);
		str = changeString("STRING");
		System.out.println("\n\n\n" + str + "\n\n\n");
	}

	public String changeString(String word)
	{
		word.toLowerCase();
		String result = new String("");
		for(int i = word.length()-1; i > 0; i--)
		{
			result += word.charAt(i-1);
			result += word.substring(i,i+1);
		}
		return result;
	}
}