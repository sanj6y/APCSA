import java.util.List;
import java.util.ArrayList;

public class ColumnMajor
{
	public static void main(String [] args)
	{
		ColumnMajor test = new ColumnMajor();
		test.run();
	}
	
	public void run ( )
	{
		int [][] first = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int [][] second = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
		int [][] third = {{1,2,3,4,5,6,7,8},{9,10,11,12,13,14,15,16}};
		List<Integer> resultFirst = convertToColumnMajor(first);
		List<Integer> resultSecond = convertToColumnMajor(second);
		List<Integer> resultThird = convertToColumnMajor(third);
		System.out.println("\n\n\n");
		print2DArray(first);
		System.out.println("\n");
		print1DArray(resultFirst);
		System.out.println("\n   3 rows, row index 1");
		print1DArray(getRow(resultFirst,3,1));
		System.out.println("\n\n\n");
		print2DArray(second);
		System.out.println("\n");
		print1DArray(resultSecond);
		System.out.println("\n   5 rows, row index 1");
		print1DArray(getRow(resultSecond,5,1));
		System.out.println("\n\n\n");
		print2DArray(third);
		System.out.println("\n");
		print1DArray(resultThird);
		System.out.println("\n   2 rows, row index 1");
		print1DArray(getRow(resultThird,2,1));
		System.out.println("\n   4 rows, row index 3");
		print1DArray(getRow(resultThird,4,3));
		System.out.println("\n   8 rows, row index 7");
		print1DArray(getRow(resultThird,8,7));
		System.out.println("\n\n\n");
	}
	
	public List<Integer> convertToColumnMajor(int [][] arr)
	{
		List<Integer> result = new ArrayList<Integer>();
		for(int col = 0; col < arr[0].length; col++)
		{
			for(int row = 0; row < arr.length; row++)
			{
				result.add(arr[row][col]);
			}
		}
		return result;
	}
	
	public void print1DArray(List<Integer> arr)
	{
		for(int i = 0; i < arr.size(); i++)
		{
			System.out.printf("%4d",arr.get(i).intValue());
		}
	}
	
	public void print2DArray(int [][] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr[i].length; j++)
			{
				System.out.printf("%4d",arr[i][j]);
			}
			System.out.println();
		}
	}
	public List<Integer> getRow(List<Integer> arr, int numRows, int theRow)
	{
		int counter = theRow;
		List<Integer> result = new ArrayList<Integer>();
		while(counter < arr.size())
		{
			result.add(arr.get(counter));
			counter += numRows;
		}
		return result;
	}
}









