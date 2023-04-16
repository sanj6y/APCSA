import java.util.ArrayList; 
import java.util.Arrays; 

public class ArrayStuff
{
	public static void main(String [] args)
	{
		ArrayStuff as = new ArrayStuff();
		as.method1();
		as.method2();
	}
	
	public void method1 ( )
	{
		System.out.println("\n\n\n");
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(2);
		list.add(3);
		list.add(1);
		int n = list.size();
		for (int i = 0; i < n; i++)
		{
			int value = list.get(i);
			if (value > 0)
			{
				list.add(value, (Integer)value);
			}
		}
		System.out.println(list);
		System.out.println("\n\n\n");
	}
	
	public void method2 ( )
	{
		ArrayList<String> myList = new ArrayList<String>(Arrays.asList("0", "1", "1", "2", "3", "4", "4", "4", "6", "7"));
		int index = 0;
		String value = "" + index;
		while (index < myList.size())
		{
			if (myList.get(index).equals(value))
			{
				myList.remove(index);
			}
			index += 2;
			value = "" + index;
			System.out.println(myList + ", index is " + index + "\n\n\n");
		}
	}
}