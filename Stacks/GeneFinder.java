/**
 * GeneFinder.java
 * 
 * Provide a description here.
 *
 * @author Your Name Here
 * @version 1.0
 * @since 3/10/2022
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class GeneFinder
{
	private ArrayQueue<String> queue;
	int sequencesCount;
	
	//  You will need to write a constructor for GeneFinder.
	public GeneFinder()
	{
		queue = new ArrayQueue<String>();
		sequencesCount = 0;
	}
	
	public static void main(String [] args)
	{
		GeneFinder run = new GeneFinder();
		run.findProteins();
	}
	
	public void findProteins ( )
	{
		openFileAndProcessIt();
	}
	
	public void openFileAndProcessIt()
	{
		//  Here is where most of the work will need to be done.  You will need to open the
		//  text file and process it, one line at a time.  Other methods will need to be 
		//  called here.  Don't let this method get too long!
		
		Scanner sc = OpenFile.openToRead("dna.txt");
		
		int index = 0;
		String leftover = "";
		int count = 0;
		boolean flag = false;
		
		while (sc.hasNext())
		{
			index = 0;
			String line = leftover + sc.nextLine();
			
			while (index + 3 < line.length() && !(line.length() - 1 - index < 3))
			{
				String codon = line.substring(index, index + 3);
				index += 3;
				
				if (isStartCodon(codon))
				{
					flag = true;
				}
				if (isStopCodon(codon) && flag == true)
				{
					queue.add(codon);
					flag = false;
					sequencesCount++;
					queue = printAndRebuild(queue);
					queue = createAminoAcids(queue);
					printAndClearQueue(queue);
					System.out.println();
				}
				
				System.out.print(codon + " ");
				count++;
				
				if (count % 12 == 0)
					System.out.println();
					
				if (flag)
					queue.add(codon);
			}
			
			if (line.length() - 1 - index < 3)
			{
				leftover = line.substring(index);
			}
				
				
							
			//~ while (!(codon.equals("ATG")) && (index + 6 < line.length()))
			//~ {
				//~ index += 3;
				//~ codon = line.substring(index, index + 3);
			//~ }
			
			//~ if (codon.equals("ATG"))
			//~ {
				//~ while(!(codon.equals("TAA") || codon.equals("TAG") || codon.equals("TGA")) && index + 3 < line.length())
				//~ {
					//~ queue.add(codon);
					//~ System.out.print(codon + " ");
					//~ codon = line.substring(index, index + 3);
					//~ index += 3;
				//~ }
			//~ }
		}
	}
	
	public boolean isStartCodon(String codon)
	{
		if (codon.equals("ATG"))
			return true;
		else
			return false;
	}
	
	public boolean isStopCodon(String codon)
	{
		if (codon.equals("TAA"))
			return true;
		else if (codon.equals("TAG"))
			return true;
		else if (codon.equals("TGA"))
			return true;
		else
			return false;
	}
	
	//  You may need to write other methods, in addition to the ones starter for you here.
	
	
	/**
	 *  Prints the ArrayQueue of Strings (codons) and puts it back together in a new 
	 *  ArrayQueue.  This ArrayQueue is returned.
	 *  @param q           The ArrayQueue to be printed and rebuilt
	 *  @return            The ArrayQueue, containing the same Strings (codons) as the original
	 */
	public ArrayQueue<String> printAndRebuild(ArrayQueue<String> q)
	{
		System.out.print(sequencesCount + ": ");
		
		ArrayQueue<String> temp = new ArrayQueue<String>();
		
		while (!q.isEmpty())
		{
			String str = q.remove();
			System.out.print(str);
			temp.add(str);
		}
		
		System.out.println();
		
		return temp;
	}
	
	/**
	 *  Creates a new ArrayQueue of amino acids from the codons in the ArrayQueue passed in.
	 *  @param q           The ArrayQueue to be used to create the ArrayQueue of amino acids
	 *  @return            The ArrayQueue created, of amino acids.
	 */
	public ArrayQueue<String> createAminoAcids(ArrayQueue<String> q)
	{
		ArrayQueue<String> temp = new ArrayQueue<String>();
		
		while (!q.isEmpty())
		{
			String str = GeneTools.codonToAminoAcid(q.remove());
			if (!str.equals("X"))
			{
				temp.add(str);
			}
		}
		
		return temp;
	}
	
	/**
	 *  Prints and clears the ArrayQueue
	 *  @param q           The ArrayQueue to be printed and cleared.
	 */
	public void printAndClearQueue(ArrayQueue<String> q)
	{
		System.out.print(sequencesCount + ": ");
		while (!q.isEmpty())
		{
			System.out.print(q.peek());
			q.remove();
		}
		
		System.out.println();
	}
}