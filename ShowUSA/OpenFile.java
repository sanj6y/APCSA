/**
 * Utilities for opening a text file. The text file
 * can be opened and read from or the file can be
 * opened (created) and written to.
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 9/7/2021
 */
 
 import java.util.Scanner;
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.PrintWriter;
 import java.io.IOException;
 
 public class OpenFile
 {
	 /**
	  * Open a file for reading
	  * 
	  * @param fileString	The name of the text file to be opened
	  * @return				A Scanner instance to be opened.
	  */
	  public static Scanner openToRead(String fileString)
	  {
		  Scanner fromFile = null;
		  File fileName = new File(fileString);
		  try
		  {
			  fromFile = new Scanner(fileName);
		  }
		  catch(FileNotFoundException e)
		  {
			  System.err.println("Sorry, but the file " + fileString +
					" could not be found.");
			  System.exit(1);
		  }
		  return fromFile;
	  }
	  
	  /**
	   * Opens a file for writing.
	   * 
	   * @param fileString	The name of the text file to be created.
	   * @return			A PrintWriter insstance of the file to be opened (created).
	   */
	   public static PrintWriter openToWrite(String fileString)
	   {
		   PrintWriter outFile = null;
		   try
		   {
			  outFile = new PrintWriter(fileString);
		   }
		   catch(IOException e)
		   {
			  System.err.println("Sorry, but the file " + fileString +
					" could not be found.");
			  System.exit(1);
		   }
		  return outFile;
	   }
 }
