public class Statistics
{
	private ArrayList<TestInfo> scoreList;
	// listed in increasing score order; no two TestInfo objects contain the same score

	/**
	 * Records a score in the database, keeping the database in increasing score order. If no other
	 * TestInfo object represents score, a new TestInfo object representing score is added to the
	 * dayabase; otherwise, the frequency in the TestInfo object representing score is incremented.
	 * @param	score	a score to be recorded in the list
	 * @return	true	if a new TestInfo object representing score was added to the list; false otherwise
	 */
	public boolean addRecord(int score)
	{

	}

	/**
	 * Records all scores in stuScores in the database, keeping the database in increasing score order
	 * @param	stuScores	an array of student test scores
	 */
	public void recordAllScores(int[] stuScores)
	{
		
	}
}