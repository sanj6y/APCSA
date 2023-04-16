/**
 * AmicableSum.java
 * Finds the sum of all amicable pairs
 * under 10000.  Amicable numbers are two different numbers
 * related in such a way that the sum of the proper divisors
 * of each is equal to the other number
 * @author Scott DeRuiter
 * @version 1.0
 * @since 8/26/2021
 */
public class AmicableSum
{
    /**  Runs an instance of AmicableSum.  */
    public static void main(String [] args)
    {
        AmicableSum run = new AmicableSum();
        run.findAmicableSum2Pairs();
    }
    
    /**
     *  Finds the amicable pairs, adding to the total.
     *  Prints out the total after the loop.
     */
    public void findAmicableSum2Pairs ( )
    {
        System.out.println("\n\n\n");
        int total = 0;
        for(int i = 2; i < 100000; i++)
        {

            int sum = findSumOfFactors(i);
            if(findSumOfFactors(sum) == i && i != sum)
            {
//                System.out.print(i);
//                printFactors(i);
                System.out.println(i + ", " + sum);
                total += i;
            }
        }
        System.out.println("\n\n" + total + "\n\n\n");
    }
    
    /**  Prints the factors (for debugging).   */
    public void printFactors(int value)
    {
        System.out.print(" -> 1");
        for(int i = 2; i < value; i++)
        {
            if(value % i == 0)
            {
                System.out.print(", " + i);
            }
        }
        System.out.println();
    }
    
    /**  Finds the sum of the proper factors.    */
    public int findSumOfFactors(int value)
    {
        int sum = 1;
        for(int i = 2; i <= Math.sqrt(value); i++)
        {
            if(value % i == 0)
            {
                sum += i;
                if(i != value/i)
                {
                    sum += (value / i);
                }
            }
        }
        return sum;
    }
}