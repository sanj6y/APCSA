public class SecretWordChecker implements StringChecker
{
	private int min;
	private int max;
	private String notInWord;

	public SecretWordChecker(String notInWord)
	{
		min = 6;
		max = 20;
		this.notInWord = notInWord;
	}
	public SecretWordChecker(int min, int max, String notInWord)
	{
		this.min = min;
		this.max = max;
		this.notInWord = notInWord;
	}

	public boolean isValid(String str)
	{
		if (str.length() < min)
			return false;
		if (str.length() > max)
			return false;

		if (str.indexOf(notInWord) != -1)
		{
				return false;
		}

		return true;
	}
}