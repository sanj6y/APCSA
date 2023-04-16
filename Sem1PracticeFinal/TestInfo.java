public class TestInfo
{
	private int score;
	private int numStudents;

	public TestInfo(int aScore)
	{
		score =  aScore;
		numStudents = 1;
	}

	/**
	 * adds 1 to the number of students who earned this score
	 */
	public void increment()
	{
		numStudents++;
	}

	/**
	 * @return	this score
	 */
	public int getScore
	{
		return score;
	}

	/**
	 * @return	the number of students who earned this score
	 */
	public int getFrequency()
	{
		return numStudents;
	}
}