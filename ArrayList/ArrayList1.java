// Demonstrate ArrayList. 

import java.util.ArrayList; 

class ArrayList1
{ 
	private ArrayList<String> al;
	private ArrayList<Integer> al2;

	public ArrayList1 ( )
	{
		al = new ArrayList<String>();
		al2 = new ArrayList<Integer>();
	}

	public static void main (String [] args)
	{ 
		ArrayList1 arrdemo = new ArrayList1 ( );

		arrdemo.StringDemo ( );
		arrdemo.IntegerDemo ( );
	} 

	public void StringDemo ( )
	{
		System.out.println("\n\n\nInitial size of al: " + al.size()); 

		// add elements to the array list 
		al.add("C"); 
		al.add("A"); 
		al.add("E"); 
		al.add("B"); 
		al.add("D"); 
		al.add("F"); 
		al.add(1, "A2"); 
		System.out.println("Size of al after additions: " + al.size()); 

		// display the array list 
		System.out.println("Contents of al: " + al); 

		// Remove elements from the array list 
		al.remove("F"); 
		al.remove(2); 
		System.out.println("Size of al after deletions: " + al.size()); 
		System.out.println("Contents of al: " + al + "\n"); 

		for (int i = 0; i < al.size(); i++)
			System.out.print(al.get(i) + "   ");
		System.out.println("\n\n\n");
	}

	public void IntegerDemo ( )
	{
		System.out.println("\n\n\nInitial size of al2: " + al2.size()); 

		// add elements to the array list 
		al2.add(11); 
		al2.add(12); 
		al2.add(13); 
		al2.add(14); 
		al2.add(15); 
		al2.add(16); 
		al2.add(1, 10); 
		System.out.println("Size of al after additions: " + al2.size()); 

		// display the array list 
		System.out.println("Contents of al2: " + al2); 

		// Remove elements from the array list 
		
		Integer temp = 13;
		al2.remove(5); 
		al2.remove(0); 
		al2.remove(temp); 
		System.out.println("Size of al2 after deletions: " + al2.size()); 
		System.out.println("Contents of al2: " + al2 + "\n"); 

		for (int i = 0; i < al2.size(); i++)
			System.out.print(al2.get(i) + "   ");
		System.out.println("\n\n\n");
	}
}



