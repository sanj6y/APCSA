/**
 * ISBNChecker.java
 * 
 * A program, using the OpenFile class, to check
 * a text file with a list of books and their
 * corresponding ISBN numbers for invalid ISBN
 * numbers. All the ISBN Numbers are checked and
 * the ones found to be invalid are printed with
 * all their details (book, ISBN number, price,
 * and other relevant details given in the text
 * file).
 *
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 9/30/2021
 */
 
 import java.util.Scanner;
 
 public class ISBNChecker
 {
	
	private String fileName = "i1.txt";
	
	public ISBNChecker()
	{
		
	}
	
	public static void main(String[] args)
	{
		ISBNChecker test = new ISBNChecker();
		test.threeLines();
		if (args.length != 0)
		{
			test.setFileName(args[0]);
		}

		test.run();
		test.threeLines();
	}
	
	/**
	 * A method that takes in a string
	 * and sets it equal to the name of
	 * the file to be read.
	 */
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	
	/**
	 * Opens the file using the OpenFile
	 * class. Gets each line and its
	 * corresponding ISBN number and
	 * checks if the ISBN number is valid.
	 * If it isn't, then a message is printed
	 * out (for each invalid ISBN number in
	 * the text file).
	 */
	public void run()
	{
		Scanner sc = OpenFile.openToRead(fileName);
		while (sc.hasNextLine())
		{
			String line = sc.nextLine();
			String ISBNNumber = line.substring(0, line.indexOf(' '));
			
			if (!(isValid(ISBNNumber)))
				printMessage(line, ISBNNumber);
		}
	}
	
	/**
	 * A method to print three new lines. Called in main
	 * method to get three new lines at the very start
	 * of the program and at the very end.
	 */
	public void threeLines()
	{
		System.out.print("\n\n\n");
	}
	
	/**
	 * A method that takes in the line and the ISBN number for the
	 * book in that line, and prints an error message. This method
	 * is called only when the calculated checkSum digit doesn't
	 * match with the checkSum digit that's the last digit in the
	 * given ISBN number.
	 */
	public void printMessage(String line, String ISBNNumber)
	{
		System.out.println("Sorry, but the ISBN Number " + ISBNNumber + " is not valid.");
		System.out.println("Full Title: " + line);
		System.out.println("Checksum should be: " + getCheckSum(ISBNNumber));
		System.out.println();
	}
	
	/**
	 * A method to get the checkSum of some ISBN number. It goes
	 * through each character in the ISBN string that isn't a
	 * dash and adds it to sum. Every other value that is added
	 * to sum is first multiplied by 3, as that's the proper way
	 * to calculate an ISBN number's checkSum. With the sum, the
	 * processes needed to get the checkSum are carried out, then
	 * the checkSum is returned.
	 */
	public int getCheckSum(String ISBNNumber)
	{
		boolean alternate = false; // to check if you multiply 1 or 3 to a number
		int sum = 0;
		for (int i = 0; i < ISBNNumber.length() - 1; i++)
		{
			if (ISBNNumber.charAt(i) != '-')
			{
				if (alternate)
					sum += Integer.parseInt("" + ISBNNumber.charAt(i)) * 3;
				else
					sum += Integer.parseInt("" + ISBNNumber.charAt(i));
				
				alternate = !alternate;
			}
		}
		
		int remainder = sum % 10;
		int checkSum = 10 - remainder;
		checkSum %= 10;
		
		return checkSum;
	}
	
	/**
	 * A method to check whether or not the ISBN number is valid.
	 * This checking is done by comparing the calculated checkSum
	 * (done in getCheckSum method) to the last digit of the ISBN
	 * number.
	 */
	public boolean isValid(String ISBNNumber)
	{
		if (("" + ISBNNumber.charAt(ISBNNumber.length() - 1)).equals(getCheckSum(ISBNNumber) + ""))
			return true;
		else
			return false;
	} 
}