import java.util.ArrayList;

public class ArrayList0
{
	public static void main (String[] args)
	{

		ArrayList<String> arlist=new ArrayList<String>();
		//<E> it is return type of ArrayList

		arlist.add("First Element"); // adding element in ArrayList
		arlist.add("Second Element");
		arlist.add("Third Element");
		arlist.add("Fourth Element");
		arlist.add("Fifth Element");

		System.out.println("\n\n\n");

		// get and print elements of ArrayList 
		for(int i=0; i < arlist.size(); i++)
		{
			System.out.println("ArrayList Element "+i+": "+arlist.get(i));
		}
		// arlist.size() inform number of elements in ArrayList
		System.out.println("ArrayList Size: "+arlist.size());

		// add element with index for fix order  
		arlist.add(2, "Insert at Index 2");

		System.out.println("\n\n\n");

		// get and print elements of ArrayList 
		for(int i=0; i < arlist.size(); i++)
		{
			System.out.println("ArrayList Element "+i+": "+arlist.get(i));
		}
		// arlist.size() inform number of elements in ArrayList
		System.out.println("ArrayList Size: "+arlist.size());

		System.out.println("\n\n\n");
	}
}