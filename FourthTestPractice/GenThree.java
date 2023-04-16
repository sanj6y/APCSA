public class GenThree
{
	public static void main(String [] args)
	{
		GenThree run = new GenThree();
		run.tester();
	}
	
	public void tester ( )
	{
		int [] values = {-2,-1,1,2,3};
		
		for(int i = 0; i < values.length; i++)
		{
			values[i] -= genThree(values[i]);
			values[i] += genThree(values[i]);
		}
		System.out.println("\n\n\n");
		for(int i = 0; i < values.length; i++)
		{
			System.out.print(values[i] + "  ");
		}
		
		values = new int []{-3,-2,-1,1,2};
		
		for(int i = 0; i < values.length; i++)
		{
			values[i] -= genThree(values[i]);
			values[i] += genThree(values[i]);
		}
		System.out.println("\n\n\n");
		for(int i = 0; i < values.length; i++)
		{
			System.out.print(values[i] + "  ");
		}
		
		values = new int []{3,2,1,-1,-2};
		
		for(int i = 0; i < values.length; i++)
		{
			values[i] -= genThree(values[i]);
			values[i] += genThree(values[i]);
		}
		System.out.println("\n\n\n");
		for(int i = 0; i < values.length; i++)
		{
			System.out.print(values[i] + "  ");
		}
		
		values = new int []{-1,2,3,1,-2};
		
		for(int i = 0; i < values.length; i++)
		{
			values[i] -= genThree(values[i]);
			values[i] += genThree(values[i]);
		}
		System.out.println("\n\n\n");
		for(int i = 0; i < values.length; i++)
		{
			System.out.print(values[i] + "  ");
		}
		System.out.println("\n\n\n");
	}
	
	public int genThree (int number)
	{
		if(number > 0)
		{
			return 3;
		}
		return -3;
	}
}