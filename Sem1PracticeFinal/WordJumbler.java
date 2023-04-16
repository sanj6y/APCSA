import java.util.Arrays;

public class WordJumbler
{
	private String[] jumbledWords;

	/**
	 * @param	wordArr an array of String objects
	 * 			Precondition: wordArr.length is even
	 */
	public WordJumbler(String[] wordArr)
	{
		jumbledWords = makeJumble(wordArr);
	}

	/**
	 * @param	word1	a String of characters
	 * @param	word2	a String of characters
	 * @return	a String that contains the first half of word1 and the second half of word2
	 */
	private String halfAndHalf(String word1, String word2)
	{
		return word1.substring(0, word1.length() / 2) + word2.substring(word2.length() / 2);
	}

	/**
	 * @param	words	an array of String objects
	 * 					Precondition: words.length is even
	 * @return	an array of String objects created by recombining pairs of strings in array words
	 * 			Postcondition: the length of the returned array is words.length
	 */
	private String[] makeJumble(String[] words)
	{
		String[] result = new String[words.length];
		for (int i = 0; i < words.length - 1; i += 2)
		{
			result[i] = halfAndHalf(words[i], words[i + 1]);
			result[i + 1] = halfAndHalf(words[i + 1], words[i]);
		}

		return result;
	}

	public static void main(String[] args)
	{
		String[] arr = new String[] {"apple", "pear", "this", "cat"};
		WordJumbler run = new WordJumbler(arr);
		System.out.println(run.halfAndHalf(arr[0], arr[1]));
		System.out.println(run.halfAndHalf(arr[1], arr[0]));
		System.out.println(Arrays.toString(run.makeJumble(arr)));
	}
}