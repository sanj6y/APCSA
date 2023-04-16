/**
 * Utilities for opening a text file.  The text file
 * can be opened and read from, or the file can be
 * opened (created) and written to.
 * @author   Your Name Here
 * @version  1.0
 * @since    9/10/2021
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OpenFile
{	
	/**
	 * Opens a file for reading.
	 *
	 * @param filestring   The name of the file to be opened.
	 * @return             A Scanner instance of the file to be opened.
	 */
	public static Scanner openToRead (String fileString)
	{		
		Scanner fromFile = null;
		File fileName = new File(fileString);
		try
		{
			fromFile = new Scanner(fileName);
		}
		catch(FileNotFoundException error)
		{
			System.err.println("Sorry, but the file " + fileString + " could not be found.");
			System.exit(1);
		}
		return fromFile;
	}
	
	/**
	 * Opens a file for writing.
	 *
	 * @param filestring   The name of the file to be opened (created).
	 * @return             A PrintWriter instance of the file to be opened (created).
	 */
	public static PrintWriter openToWrite (String fileString)
	{
		PrintWriter outFile = null;
		try
		{
			outFile = new PrintWriter(fileString);
		}
		catch(Exception error)
		{
			System.err.println("Sorry, but the file " + fileString + " could not be created.");
			System.exit(2);
		}
		return outFile;
	}
}