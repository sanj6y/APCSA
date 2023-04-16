public class SuperHAlgorithm
{
	public static void main(String [] args)
	{
		SuperHAlgorithm superh = new SuperHAlgorithm();
		superh.run();
	}
	
	public void run ( )
	{
		String [] words1 = {"blend", "bless", "clerk", "crews", "crept", "dense", "embed", "event", 
			"excel", "feels", "fends", "fetch", "fleck", "geese", "gents", "hefts", "herbs", "jests", 
			"jewel", "kelps", "knees", "knelt", "lends", "level", "melts", "nerds", "rents", "shrew", 
			"speed", "strep", "three", "threw", "weeks"};
		System.out.println("\n\n\n");
		System.out.println("\n\n\n" + findIndexOfMaxOccurrence(words1,'e') + "\n\n\n");
	}
	
	public int findIndexOfMaxOccurrence(String [] wordlist, char ch)
	{
		int maxIndex = 0, maxCount = -1;
		for(int i = 0; i < wordlist[0].length(); i++)
		{
			int count = 0;
			for(int j = 0; j < wordlist.length; j++)
			{
				if(wordlist[j].indexOf(ch) == i && wordlist[j].substring(i+1).indexOf(ch) == -1) 
				{
					count++;
				}
			}
			System.out.print(count + "   ");
			if(count > maxCount)
			{
				maxCount = count;
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
/*
	public int findIndexOfMaxOccurrence(String [] wordlist, char ch)
	{
		int [] occur = new int[wordlist[0].length()];
		for(int i = 0; i < wordlist.length; i++)
		{
			if(wordlist[i].indexOf(ch) == wordlist[i].lastIndexOf(ch))
			{
				occur[wordlist[i].indexOf(ch)]++;
			}
		}
		for(int i = 0; i < occur.length; i++)
		{
			System.out.print(occur[i] + "   ");
		}
		int max = 0, maxIndex = -1;
		for(int i = 0; i < occur.length; i++)
		{
			if(occur[i] > max)
			{
				maxIndex = i;
				max = occur[i];
			}
		}
		return maxIndex;
	}
	
	public int findIndexOfMaxOccurrence(String [] wordlist, char ch)
	{
		int maxIndex = 0, maxCount = -1;
		for(int i = 0; i < wordlist[0].length(); i++)
		{
			int count = 0;
			for(int j = 0; j < wordlist.length; j++)
			{
				if(wordlist[j].contains(ch+"") && !wordlist[j].substring(wordlist[j].indexOf(ch+"")+1).contains(ch+""))
				{
					if(wordlist[j].charAt(i) == ch)
					{
						count++;
					}
				}
			}
			System.out.print(count + "   ");
			if(count > maxCount)
			{
				maxCount = count;
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	public int findIndexOfMaxOccurrence(String [] wordlist, char ch)
	{
		int [] indices = new int[9];
		
		for(int i = 0; i < wordlist.length; i++)
		{
			int j = wordlist[i].indexOf(ch);
			if(j != -1 && wordlist[i].indexOf(ch,j+1) == -1)
			{
				indices[j]++;
			}
		}
		
		for(int i = 0; i < indices.length; i++)
		{
			System.out.print(indices[i] + "   ");
		}
		
		int maxIndex = 0, maxCount = -1;
		for(int i = 0; i < indices.length; i++)
		{
			if(indices[i] > maxCount)
			{
				maxCount = indices[i];
				maxIndex = i;
			}
		}
	
		return maxIndex;
	}
*/
}