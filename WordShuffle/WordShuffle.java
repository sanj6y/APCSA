/**
 * WordShuffle.java
 * 
 * The program starts with a random word being chosen from a list of
 * 48 10-letter words.  This word is then saved into a String (the key).  
 * The word is scrambled, one letter at a time, and is saved to another
*  String (the word).
 * The user may choose to run either:
 * java WordShuffle or java WordShuffle show.  If the user runs the 
 * program with java WordShuffle show, then the chosen word will be
 * printed to the terminal window.  Using a graphical user interface, 
 * the user may choose from a menu of buttons, to manipulate the
 * jumbled word.  This menu of buttons includes:
 * (1) SWAP, where two letters are swapped in the word, with the word
 *     being resaved.  The two letters to be swapped are chosen by the 
 *     user.
 * (2) ROTATE RIGHT, where all letters are shifted one position to
 *     the right.  The last letter becomes the first letter in the
 *     new word.
 * (3) ROTATE LEFT, where all letters are shifted one position to
 *     the left.  The first letter becomes the last letter in the
 *     new word.
 * (4) JUMBLE, where all of the letters in the word are shuffled.
 *     No letters should be lost, and the ordering should be random.
 * (5) RESET, where a new word in the list of 48 10-letter words is
 *     chosen, and the key becomes this new word.  The word is also 
 *     filled with the letters of this new word, jumbling them. If 
 *     the user runs the program with Java WordShuffle show, then the 
 *     new word chosen (key) should be printed to the terminal window.
 * (6) COPY KEY, where the word becomes a copy of the key.  That is 
 *     to say, both the key and the word contain the letters of the 
 *     word, in the correct order.
 * (7) REVERSE, where the letters in the word are reversed.  That is
 *     to say, that first and last letters are swapped, the second and 
 *     second to last letters are swapped, etc.
 * (8) PUSH FROM MIDDLE, where the 5th letter is pushed to the 4th,
 *     the 4th to the 3rd, etc.  Also, the 6th letter is pushed to
 *     the 7th, the 7th is pushed to the 8th, etc.  The letters on
 *     ends are rotated to the middle.
 * (9) SWAP PAIRS, where all 5 adjacent pairs are swapped.
 *
 * After each button action, the word is compared to the key, and if 
 * they match exactly, then a "You Got It!" message is printed.  
 * Otherwise, a "They're Not In Order" message is printed.
 *
 * @author Scott DeRuiter and Sanjay Chandrasekar
 * @version 1.0
 * @since 11/1/2021
 */

import java.awt.Color;
import java.awt.Font;

public class WordShuffle 
{ 
	/**  A list of possible Strings (words) to be used for the game.                         */
	private String [] words = new String[]
		{"everything", "frightened", "characters", "literature", "everywhere", "compliment", "appearance", "difference",
		"perfection", "technology", "watermelon", "appreciate", "relaxation", "strawberry", "aberration", "retirement",
		"television", "contraband", "silhouette", "friendship", "loneliness", "punishment", "confidence", "discipline",
		"renovation", "helicopter", "generation", "adaptation", "understand", "leadership", "revolution", "wilderness", 
		"motivation", "diabolical", "conscience", "reciprocal", "girlfriend", "trampoline", "resolution", "vegetables",
		"tambourine", "endearment", "individual", "conference", "adrenaline", "accomplish", "instrument", "ubiquitous"};
	
	/**  The word currently being used.                                                      */
	private String key;
	
	/**  The word, containing letters from the key (typically scrambled).                    */
	private String word;
	
	/**  The index values to be swapped.  These will be chosen by the user.                  */
	private int iswap, jswap;
	
	/**  The boolean to determine if the key word should be printed to the terminal window.   */
	private boolean show;
	
	/**  A boolean toggle to ensure that a button does not repeat its action.                 */
	private boolean mousePressReady;

	/** 
	 *  Creates a WordShuffle object. If the user called the program with
	 *  java WordShuffle show, then the chosen word is always shown (at
	 *  the start and on reset).  The word is chosen, and saved in the
	 *  String key.  The word is also saved into the String word, then
	 *  jumbled.  mousePressReady is set to true, and the swap indices
	 *  are set to values outside the indices of the word or key (-1).
	 */
	public WordShuffle(String showIt)
	{
		show = false;
		if(showIt.equalsIgnoreCase("show"))
		{
			show = true;
		}
		mousePressReady = true;
		iswap = jswap = -1;
		chooseWord();
		jumble();
	}
	
	/** 
	 *  Chooses a word at random from the list of 48 10-letter words.
	 *  If the user runs the program with java WordShuffle show, then this
	 *  word is printed to the terminal window.  The word is then saved
	 *  into both the key and the word Strings.
	 */
	public void chooseWord ( )
	{
		key = word = words[(int)(Math.random() * 48)];                                               //  This method needs to choose a word at random,
		                                                                      //  and then print the key to the terminal window
		if (show)
			System.out.println(key);															//  if show is true.
	}
	
	/** 
	 *  Jumbles the 10 letters in the word String, making use of a swap
	 *  of random pairs of indices.
	 */
	public void jumble ( )
	{
		for(int i = 0; i < 5; i++)
		{
			int index1 = (int)(Math.random() * 10);
			int index2 = (int) (Math.random() * 10);
			if (index1 != index2)
				word = swap(word, index1, index2);
		}                                                                     //  Make use of random numbers and swap.
	}
	

	/**
	 *  Compares the letters in the Strings key and word,
	 *  determining if they match, letter for letter.
	 *  @return         true if the letters in the key and word Strings
	 *                  match, letter for letter, false otherwise
	 */
	public boolean isMatch ( )
	{
		return word.equals(key);
	}
	
	/** 
	 *  Swaps the letters in char String w, at indices i and j.
	 *  @param w        The String, where two letters are to be swapped
	 *  @param i        The first swap index.
	 *  @param j        The second swap index.
	 *  @return         The String with the letters swapped
	 */
	public String swap(String w, int i, int j)
	{
		String result = "";
		char charAtI = w.charAt(i);
		char charAtJ = w.charAt(j);
		for (int index = 0; index < w.length(); index++)
		{
			if (index == i)
				result += charAtJ;
			else if (index == j)
				result += charAtI;
			else
				result += w.charAt(index);
		}
		
		return result;
	}

	/**
	 *  The main method, to choose the word, set up the GUI, and run the program.
	 */
	public static void main(String[] args)
	{
		String showIt = new String("");
		if(args.length > 0)
		{
			showIt = args[0];
		}
		WordShuffle run = new WordShuffle(showIt);
		run.setUpCanvas();
		run.playGame();
    } 
	
	/** 
	 *  Sets up the canvas, using methods from StdDraw.  This includes
	 *  setting up the canvas size, the horizontal scale (Xscale), and
	 *  the vertical scale (Yscale).  Double buffering is enabled,
	 *  in case you want to add an animation.
	 */
	public void setUpCanvas ( )
	{
		StdDraw.setCanvasSize(600, 200);
		StdDraw.setXscale(0.0, 600.0);        //  Related to the width
		StdDraw.setYscale(0.0, 200.0);        //  Related to the height
		
		StdDraw.enableDoubleBuffering();
	}
	
	/** 
	 *  Runs an endless loop (an event model), so that the GUI is constantly
	 *  ready for the press of the mouse.
	 */
	public void playGame ( )
	{
		while(true)
		{
			double x = StdDraw.mouseX();
			double y = StdDraw.mouseY();
			drawFullWord(x,y);
			drawButtons(x,y);
			drawWordMatchMessage();
			StdDraw.show();
			StdDraw.pause(10);
		}
	}
	
	/**
	 *  Draws the full word String, letter by letter on the GUI (cell by cell).
	 *  @param x        x position of a mouse press.
	 *  @param y        y position of a mouse press.
	 */
	public void drawFullWord(double x, double y)
	{
		for(int i = 0; i < word.length(); i++)
		{
			drawLetterCell(i, word.charAt(i), x, y);
		}
	}
	
	/**
	 *  Draws an individual letter cell.  Checks the position of a mouse press
	 *  on the cell, responding by choosing index values and including color on
	 *  the cell letter, when appropriate.
	 *  @param i        The corresponding String index for the current cell.
	 *  @param c        The letter to be drawn in the cell.
	 *  @param x        x position of a mouse press.
	 *  @param y        y position of a mouse press.
	 */
	public void drawLetterCell(int i, char c, double x, double y)
	{
		Font font = new Font("Arial", Font.BOLD, 40);
		StdDraw.setFont(font);
		for(int j = 0; j < 5; j++)
		{
			StdDraw.setPenColor(new Color(10*j,10*j,50*j));
			StdDraw.filledRectangle(i * 60 + 30, 170, 25-j, 25-j);
		}
		StdDraw.setPenColor(new Color(255,255,255));
		if(x >= i * 60 + 30 - 25 && x <= i * 60 + 30 + 25 && y >= 170 - 25 && y <= 170 + 25)
		{
			if(StdDraw.isMousePressed() && mousePressReady)
			{
				if (i != iswap)
				{
					jswap = iswap;
					iswap = i;
				}
			}
		}
		if(i == iswap || i == jswap)
		{
			StdDraw.setPenColor(new Color(0,200,0));
		}
		StdDraw.text(i * 60 + 30, 166, "" + c);
	}
	
	/**
	 *  Draws the 9 buttons on the GUI, with choices for how to manipulate
	 *  the word String.
	 *  @param x        x position of a mouse press.
	 *  @param y        y position of a mouse press.
	 */
	public void drawButtons(double x, double y)
	{
		if(!StdDraw.isMousePressed())
		{
			mousePressReady = true;
		}
		drawButtonAndAct("SWAP", 44, 120, 38, 15, x, y);
		drawButtonAndAct("ROTATE RIGHT", 174, 120, 82, 15, x, y);
		drawButtonAndAct("ROTATE LEFT", 340, 120, 76, 15, x, y);
		drawButtonAndAct("JUMBLE", 467, 120, 42, 15, x, y);
		drawButtonAndAct("RESET", 556, 120, 38, 15, x, y);
		drawButtonAndAct("COPY KEY", 64, 82, 58, 15, x, y);
		drawButtonAndAct("REVERSE", 182, 82, 51, 15, x, y);
		drawButtonAndAct("PUSH FROM MIDDLE", 345, 82, 103, 15, x, y);
		drawButtonAndAct("SWAP PAIRS", 526, 82, 68, 15, x, y);
	}
	
	/**
	 *  Draws an individual button, with the given title and dimensions.  Includes
	 *  information about position of mouse press.  Acts appropriately when mouse
	 *  is pressed on the button.
	 *  @param title        The title of the button, to be printed on the button.
	 *  @param xpos         The xpos of the center of the button.
	 *  @param ypos         The ypos of the center of the button.
	 *  @param halfWidth    Half the width of the button.
	 *  @param halfHeight   Half the height of the button.
	 *  @param y            x position of a mouse press.
	 *  @param y            y position of a mouse press.
	 */
	public void drawButtonAndAct(String title, int xpos, int ypos, int halfWidth, int halfHeight, double x, double y)
	{
		Font font = new Font("Arial", Font.PLAIN, 20);
		StdDraw.setFont(font);
		for(int j = 0; j < 5; j++)
		{
			StdDraw.setPenColor(new Color(255 - (2 + j) * 40, 255 - (2 + j) * 40, 255 - (2 + j) * 40));
			StdDraw.filledRectangle(xpos, ypos, halfWidth - j, halfHeight - j);
		}
		StdDraw.setPenColor(new Color(255,255,255));		
		if(x >= xpos - halfWidth && x <= xpos + halfWidth && y >= ypos - halfHeight && y <= ypos + halfHeight)
		{
			if(StdDraw.isMousePressed())
			{
				StdDraw.setPenColor(new Color(0,255,0));
				if(mousePressReady)
				{
					act(title);
				}
			}
		}
		StdDraw.text(xpos, ypos - 4, title);
	}
	
	/**
	 *  Calls appropriate methods when a button is pressed.
	 *  @param act        The title of the button.
	 */
	public void act(String act)
	{
		if(act.equals("SWAP"))
		{
			doSwap();
		}
		else if(act.equals("ROTATE RIGHT"))
		{
			rotateRight();
		}
		else if(act.equals("ROTATE LEFT"))
		{
			rotateLeft();
		}
		else if(act.equals("JUMBLE"))
		{
			jumble();
		}
		else if(act.equals("RESET"))
		{
			chooseWord();
			jumble();
		}
		else if(act.equals("COPY KEY"))
		{
			copyKey();
		}
		else if(act.equals("REVERSE"))
		{
			reverse();
		}
		else if(act.equals("PUSH FROM MIDDLE"))
		{
			pushFromMiddle();
		}
		else if(act.equals("SWAP PAIRS"))
		{
			swapPairs();
		}
		mousePressReady = false;
		iswap = jswap = -1;
	}
	
	/**
	 *  Swaps the letters in the word String, at indices iswap
	 *  and jswap.  Does not perform a swap if iswap is equal
	 *  to -1, or jswap is equal to -1.
	 */
	public void doSwap ( )
	{
		if(iswap != -1 && jswap != -1)
		{
			word = swap(word, iswap, jswap);                          //  This method is complete.  Do not change it.
		}
	}
	
	/**
	 *  Rotates all letters in the word String to the right.  The
	 *  last letter is rotated to the start of the String.
	 */
	public void rotateRight ( )
	{
		String rotated = "";
		rotated += word.charAt(word.length() - 1);
		for (int i = 0; i < word.length() - 1; i++)
		{
			rotated += word.charAt(i);
		}
		
		word = rotated;
			                                                              //  Build the word one letter at a time.  A loop is required.
	}
	
	/**
	 *  Rotates all letters in the word String to the left.  The
	 *  first letter is rotated to the end of the String.
	 */
	public void rotateLeft ( )
	{
		String rotated = "";
		for (int i = 1; i < word.length(); i++)
		{
			rotated += word.charAt(i);
		}
		rotated += word.charAt(0);
		
		word = rotated;
		                                                              //  Build the word one letter at a time.  A loop is required.
	}
	
	/**
	 *  Copies the key String to the word String.
	 */
	public void copyKey ( )
	{
		word = key;
	}
	
	/**
	 *  Reverses the letters in the word String, with the first and
	 *  last letters swapped, the second and the second to last letters
	 *  swapped, etc.
	 */
	public void reverse ( )
	{
		for (int i = 0; i < 5; i++)
		{
			word = swap(word, i, 9 - i);
		}
	}
	
	/**
	 *  "Pushes" the letters out from the middle, with the 6th letter
	 *  going to the 7th position, the 7th going to the 8th, etc.
	 *  Also, the 5th letter goes to the 4th position, the 4th to the
	 *  3rd, etc.  The letters on the outside get placed in the middle
	 *  of the String (10th to the 6th, 1st to the 5th).
	 */
	public void pushFromMiddle ( )
	{
		String newWord = "";
		for (int i = 1; i < 5; i++)
		{
			newWord += word.charAt(i);
		}
		newWord += word.charAt(0);
		newWord += word.charAt(word.length() - 1);
		
		for (int i = 5; i < word.length() - 1; i++)
		{
			newWord += word.charAt(i);
		}
		
		word = newWord;
		
		                                                              //  A loop is required.
	}
	
	/**
	 *  Swaps the 5 adjacent pairs of letters in the word String, 
	 *  starting with the letters at indices 0 and 1.
	 */
	public void swapPairs ( )
	{
		for (int i = 0; i < word.length() - 1; i += 2)
		{
			word = swap(word, i, i+1);
		}
	}
	
	/**
	 *  Draws a message indicating that the letters of the word String
	 *  are in order, or not in order.
	 */
	public void drawWordMatchMessage ( )
	{
		String message;
		
		Font font = new Font("Arial", Font.BOLD, 30);
		StdDraw.setFont(font);
		
		StdDraw.setPenColor(new Color(255,255,255));
		StdDraw.filledRectangle(300, 30, 300, 20);
		
		StdDraw.setPenColor(new Color(255,135,0));
		if (isMatch())
			message = "You Got It!";
		else
			message = "They're not in order.";
		StdDraw.text(300, 28, message);
	}
} 