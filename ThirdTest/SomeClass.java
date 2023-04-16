public class SomeClass implements Comparable
{
	public int compareTo(Object other)
	{
		return -1;
	}
/*
	public int compareTo(SomeClass other)
	{
		return -1;
	}
	
	public boolean compareTo(Object other)
	{
		return -1;
	}
*/
}

interface Comparable
{
	public int compareTo(Object other);
}