public class AccountDemo 
{
    public static void main (String args[])
    {
        // Create an empty account
        InterestBearingAccount my_account = new InterestBearingAccount();

        // Deposit money
        my_account.deposit(250.00);

        // Print current balance
        System.out.println ("\n\n\nCurrent balance " + my_account.getbalance() + "\n");

        // Withdraw money
        my_account.withdraw(80.00);

        // Print remaining balance
        System.out.println ("Remaining balance " + my_account.getbalance() + "\n");

        System.out.println ("Adding interest to account each month for 6 months . . .");
		for(int i = 1; i <= 6; i++)
		{
			// Allow a month to pass
			my_account.add_monthly_interest();
			// Print remaining balance
			System.out.println ("Remaining balance after " + i + " month(s): " + my_account.getbalance());
		}

        // Print remaining balance
        System.out.println("\n\n\n");
    }
}

class Account 
{
    private double balance;

    // Constructor to initialize balance
    public Account( double amount )
    {
        balance = amount;
    }

    // Overloaded constructor for empty balance
    public Account()
    {
        balance = 0.0;
    }

    public void deposit( double amount )
    {
        balance += amount;
    }

    public double withdraw( double amount )
    {
        // See if amount can be withdrawn
        if (balance >= amount)
        {
            balance -= amount;
            return amount;
        }
        else
            // Withdrawal not allowed
            return 0.0;
    }
	
    public void setbalance (double b)
    {
        balance = b;
    }

    public double getbalance ( )
    {
        return balance;
    }
}  

class InterestBearingAccount extends Account
{
    // Default interest rate of 7.95 percent (const)
    private static double default_interest = 7.95;

    // Current interest rate
    private double interest_rate;

    // Overloaded constructor accepting balance and an interest rate
    public InterestBearingAccount( double amount, double interest)
    {
        setbalance(amount);
        interest_rate = interest;
    }

    // Overloaded constructor accepting balance with a default interest rate
    public InterestBearingAccount( double amount )
    {
        setbalance(amount);
        interest_rate = default_interest;
    }

    // Overloaded constructor with empty balance and a default interest rate
    public InterestBearingAccount()
    {
        setbalance(0.0);
        interest_rate = default_interest;
    }
	
    public void add_monthly_interest()
    {
        // Add interest to our account
        setbalance(getbalance() + (getbalance() * interest_rate / 100) / 12);
    }
}
