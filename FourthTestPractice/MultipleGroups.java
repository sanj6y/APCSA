import java.util.List;
import java.util.ArrayList;

interface IntegerSet
{
	boolean contains(int x);
}

class Range implements IntegerSet
{
	private int minValue, maxValue;

	public Range(int min, int max)
	{
		minValue = min;
		maxValue = max;
	}
  
	public boolean contains (int x)
	{
		return x >= minValue && x <= maxValue;
	}
}

public class MultipleGroups implements IntegerSet
{
	private List<IntegerSet> groupList;
	
	public MultipleGroups ( )
	{
		groupList = new ArrayList<IntegerSet>();
	}
	
	public void addIntegerSet(Range r)
	{
		groupList.add(r);
	}

	public boolean contains(int x)
	{
		for (IntegerSet g : groupList)
		{
			if (g.contains(x))
			{
				return true;
			}
        }
		return false;
	}
	
	public static void main(String [] args)
	{
		MultipleGroups multiple1 = new MultipleGroups();
		multiple1.addIntegerSet(new Range(5,8));
		multiple1.addIntegerSet(new Range(10,12));
		multiple1.addIntegerSet(new Range(1,6));
		System.out.println("\n\n");
		System.out.println("\n" + multiple1.contains(2));
		System.out.println("\n" + multiple1.contains(9));
		System.out.println("\n" + multiple1.contains(6));
		System.out.println("\n\n\n");
	}
}