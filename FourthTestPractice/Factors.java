import java.util.ArrayList;

public class Factors
{
	public static void main(String [] args)
	{
		int[] factors = {2, 3, 4, 7, 2, 5};
		int product = 1;
		for (int i = 1; i < factors.length; i += 2)
		{
			product *= (factors[i] % factors[i - 1]);
        }
		System.out.println("\n\n\n");
		System.out.println(product);
		
		factors = new int []{3, 7, 5, 2, 3, 4};
		product = 1;
		for (int i = 1; i < factors.length; i += 2)
		{
			product *= (factors[i] % factors[i - 1]);
        }
		System.out.println("\n\n\n");
		System.out.println(product);
		
		factors = new int []{3, 10, 5, 3, 3, 8};
		product = 1;
		for (int i = 1; i < factors.length; i += 2)
		{
			product *= (factors[i] % factors[i - 1]);
        }
		System.out.println("\n\n\n");
		System.out.println(product);
		
		factors = new int []{4, 3, 3, 4, 4, 11};
		product = 1;
		for (int i = 1; i < factors.length; i += 2)
		{
			product *= (factors[i] % factors[i - 1]);
        }
		System.out.println("\n\n\n");
		System.out.println(product);
		
		
		
		
		
		
		
		
		System.out.println("\n\n\n");
		
		ArrayList <Integer> numbers = new ArrayList <Integer> ();
		for (int value = 1; value <= 5; value++)
		{
			numbers.add(value * (value - 1));
		}
		System.out.println(numbers);

		for (int i = 0; i < numbers.size(); i++)
		{
			if (numbers.get(i).intValue() % 3 == 0)
			{
				numbers.remove(i);
			}
		}
		System.out.println(numbers);
		System.out.println("\n\n\n");
		
		numbers = new ArrayList <Integer> ();
		for (int value = 2; value <= 6; value++)
		{
			numbers.add(value * (value - 2));
		}
		System.out.println(numbers);

		for (int i = 0; i < numbers.size(); i++)
		{
			if (numbers.get(i).intValue() % 3 == 0)
			{
				numbers.remove(i);
			}
		}
		System.out.println(numbers);
		System.out.println("\n\n\n");
		
		numbers = new ArrayList <Integer> ();
		for (int value = 3; value <= 7; value++)
		{
			numbers.add(value * (value - 1));
		}
		System.out.println(numbers);

		for (int i = 0; i < numbers.size(); i++)
		{
			if (numbers.get(i).intValue() % 3 == 0)
			{
				numbers.remove(i);
			}
		}
		System.out.println(numbers);
		System.out.println("\n\n\n");
		
		numbers = new ArrayList <Integer> ();
		for (int value = 7; value >= 3; value--)
		{
			numbers.add(value * (value - 1));
		}
		System.out.println(numbers);

		for (int i = 0; i < numbers.size(); i++)
		{
			if (numbers.get(i).intValue() % 3 == 0)
			{
				numbers.remove(i);
			}
		}
		System.out.println(numbers);
		System.out.println("\n\n\n");
	}
}