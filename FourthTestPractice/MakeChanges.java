public class MakeChanges
{
	public static void main(String [] args)
	{
		MakeChanges run = new MakeChanges();
		run.tester();
	}
	
	public void tester ( )
	{
		int [] values = {1,4,2,5,3};
		int index = 4;
		for(int i = 0; i < values.length; i++)
		{
			index = makeChangeOrig(values,index);
		}
		System.out.println("\n\n\n");
		for(int i = 0; i < values.length; i++)
		{
			System.out.print(values[i] + "  ");
		}
		System.out.println("\n\n\n");
		
		values = new int []{3,2,1,4,0};
		index = 2;
		for(int i = 0; i < values.length; i++)
		{
			index = makeChange(values,index);
		}
		for(int i = 0; i < values.length; i++)
		{
			System.out.print(values[i] + "  ");
		}
		System.out.println("\n\n\n");
		
		values = new int []{1,2,4,1,3};
		index = 2;
		for(int i = 0; i < values.length; i++)
		{
			index = makeChange(values,index);
		}
		for(int i = 0; i < values.length; i++)
		{
			System.out.print(values[i] + "  ");
		}
		System.out.println("\n\n\n");
		
		values = new int []{4,1,3,2,1};
		index = 3;
		for(int i = 0; i < values.length; i++)
		{
			index = makeChange(values,index);
		}
		for(int i = 0; i < values.length; i++)
		{
			System.out.print(values[i] + "  ");
		}
		System.out.println("\n\n\n");
		
		values = new int []{2,0,3,4,1};
		index = 3;
		for(int i = 0; i < values.length; i++)
		{
			index = makeChange(values,index);
		}
		for(int i = 0; i < values.length; i++)
		{
			System.out.print(values[i] + "  ");
		}
		System.out.println("\n\n\n");
	}
	
	public int makeChange (int [] n, int i)
	{
		n[i] = n[i - 1];
		return n[i];
	}
	
	public int makeChangeOrig (int [] n, int i)
	{
		n[i] = i - 1;
		return n[i];
	}
}

