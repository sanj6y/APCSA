public class ArrayPlay
{
	public static void main (String [] args)			//	PRINTED:
	{
		char [] letter = {'S', 'H', 'I', 'V', 'E', 'R'};
		ArrayPlay myarray = new ArrayPlay();
		myarray.change(letter);
	}
	
	public void change (char [] array)
	{
		System.out.println("\n\n\n");
		
		int min;
		char temp;

		for (int outer = array.length - 1; outer > 0; outer--)
		{
			min = outer;
			for (int inner = outer - 1; inner >= 0; inner--)
			{
				if (array[inner] < array[min])
				{
					min = inner;
				}
			}
			temp = array[outer];
			array[outer] = array[min];
			array[min] = temp;
			print(array);
		}
		System.out.println("\n\n\n");
	}
	
	public void print (char [] A)
	{
		System.out.println();
		for (int i = 0; i < A.length; i++)
			System.out.print (A[i] + "  ");
		System.out.println();
	}
}  
