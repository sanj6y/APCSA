/**
 * Wordle.java
 * 
 * An implementation of the game Wordle.
 *
 * @author Scott DeRuiter and Sanjay Chandrasekar
 * @version 1.0
 * @since 3/28/2022
 */
 
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;
import java.io.PrintWriter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JDialog;

public class Wordle
{ 
	/**  A String to store the word that the player is trying to find.                         */
	private String word;
	
	/**  An array of String to store the guesses that have been made.                          */
	private String [] wordGuess;
	
	/**  A String to store the letters in the current guess.  Can have from 0 to 5 chars       */
	private String letters;
	
	/**  A variety of boolean variables to turn things on and off.  These include:
	 *   show                -    when true, will print the current word to the terminal, when false, will not print the word.
	 *   readyForKeyInput    -    when true, will accept keyboard input, when false, will not accept keyboard input.
	 *   readyForMouseInput  -    when true, will accept mouse input, when false, will not accept mouse input.
	 *   activeGame          -    when false, will only accept action on the RESET button.
	 */
	private boolean show, readyForKeyInput, readyForMouseInput, activeGame;
	
	/**  An array to determine how to color the keyboard at the bottom of the gameboard.
	 *   0 for not checked yet, 1 for no match, 2 for partial, 3 for exact
	 */
	private int [] keyBoardColors;						
	
	/** 
	 *  Creates a Wordle object.  A 2-args constructor.  Initializes all of the variables by calling the method initAll.
	 *  @param showIt         if showIt is equal to "show", will print the word to the terminal
	 *  @param testWord       if this String is found in words5allowed.txt, it will be used to set word.
	 */
	public Wordle(String showIt, String testWord)
	{
		show = false;
		if(showIt.equalsIgnoreCase("show"))					//  THIS METHOD IS COMPLETE.
		{
			show = true;
		}
		initAll(testWord);
	}
	
	/** 
	 *  Initializes all fields.  Calls openFileAndChooseWord to choose the word.  Sets all of the
	 *  keyboard colors to light gray to start.
	 *  @param testWord       if this String is found in words5allowed.txt, it will be used to set word.
	 */
	public void initAll(String testWord)
	{
		wordGuess = new String[6];							//  THIS METHOD IS COMPLETE.
		for(int i = 0; i < wordGuess.length; i++)
		{
			wordGuess[i] = new String("");
		}
		letters = "";
		readyForKeyInput = activeGame = true;
		readyForMouseInput = false;
		keyBoardColors = new int[29];
		word = openFileAndChooseWord("words5.txt", testWord);		
	}

	/**
	 *  The main method, to run the program.  The constructor is called, so that all of the fields are
	 *  initialized.  The canvas is set up, and the GUI (the game of Wordle) runs.
	 */
	public static void main(String[] args)
	{
		String showIt = new String("");
		String testWord = new String("");					//  THIS METHOD IS INCOMPLETE.

		if (args.length > 0)
			showIt = args[0];
		
		if (args.length > 1)
			testWord = args[1];
															//  You should respond to args[0] and args[1] here.
		Wordle run = new Wordle(showIt, testWord);
		run.setUpCanvas();
		run.playGame();
	}

	/**
	 *  Sets up the canvas.  Enables double buffering so that the gameboard is drawn offscreen first,
	 *  then drawn to the gameboard when everything is ready (with the show method).
	 */
	public void setUpCanvas ( )
	{
		StdDraw.setCanvasSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		StdDraw.setXscale(0, Constants.SCREEN_WIDTH);
		StdDraw.setYscale(0, Constants.SCREEN_HEIGHT);							//  THIS METHOD IS COMPLETE.

		StdDraw.enableDoubleBuffering();
	}
	
	/**
	 *  Runs the game.  An endless loop is created, constantly cycling and looking for user input.
	 */
	public void playGame ( )
	{
		boolean keepGoing = true;
		while(keepGoing)
		{
			if(activeGame)														//  THIS METHOD IS COMPLETE.
			{
				drawPanel();
			}
			update();
		}
	}

	/** 
	 *  If the testWord is valid, it is used as the "goal word".  If it is not, then the text file
	 *  is opened, and a word is chosen at random from the list to be the "goal word".  If the field
	 *  variable show is true, it will print the chosen word to the terminal window.
	 *  @param inFileName     this file is to be opened, and a random word is to be chosen from it.
	 *  @param testWord       if this String is found in words5allowed.txt, it will be used to set word.
	 *  @return               the word chosen as the "goal word".
	 */
	public String openFileAndChooseWord(String inFileName, String testWord)
	{
		Scanner sc = OpenFile.openToRead(inFileName);
		String result = "SMART";

		int lineNumber = (int)(Math.random() * 2309) + 1;
		int currLine = 0;
		
		while (sc.hasNext())
		{
			String line = sc.nextLine();
			currLine++;
			
			if (lineNumber == currLine && !(result.equals(testWord)))
				result = line;	
		}
		
		if (inAllowedWordFile(testWord))
		{
			result = testWord;
		}
			
		if (show)
			System.out.println(result);
			
		return result.toUpperCase();
	}
	
	/** 
	 *  Draws the entire game panel.  This includes the guessed words, the current word being
	 *  guessed, and all of the letters in the "keyboard" at the bottom of the gameboard.  The
	 *  correct colors will need to be chosen for every letter.
	 */
	public void drawPanel ( )
	{
		StdDraw.clear(StdDraw.WHITE);
		Font font = new Font("Arial", Font.BOLD, 12);
		StdDraw.setFont(font);
		StdDraw.picture(Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT - 30, "wordle.png");
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		int place = 0;
		String tempWord = "";
		for(int [] pair : Constants.KEYPLACEMENT)
		{
			if(place == 19 || place == 27 || place == 28)
			{
				StdDraw.picture(pair[0], pair[1], "keyBackgroundBig.png");						//  This method needs to be modified a great deal,
			}																					//  so that the correct colors show up.
			else
			{
				if (keyBoardColors[Constants.KEYBOARD[place].charAt(0) - 'A'] == 0)
					StdDraw.picture(pair[0], pair[1], "keyBackground.png");
				else if (keyBoardColors[Constants.KEYBOARD[place].charAt(0) - 'A'] == 1)
					StdDraw.picture(pair[0], pair[1], "keyBackgroundDarkGray.png");
				else if (keyBoardColors[Constants.KEYBOARD[place].charAt(0) - 'A'] == 2)
					StdDraw.picture(pair[0], pair[1], "keyBackgroundYellow.png");
				else 
					StdDraw.picture(pair[0], pair[1], "keyBackgroundGreen.png");
			}
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(pair[0], pair[1], Constants.KEYBOARD[place]);
			place++;
		}
		drawAllLettersGuessed();
		StdDraw.show();
		StdDraw.pause(Constants.DRAW_DELAY);
		checkIfWonOrLost();
	}
	
	/** 
	 *  This method is called by drawPanel, and draws all of the letters in the guesses made
	 *  by the user.
	 */
	public void drawAllLettersGuessed ( )
	{	
		for(int row = 0; row < 6; row++)
		{
			int[] matches = new int[5];
			if (wordGuess[row].length() > 0)
				matches = checkMatches(wordGuess[row]);
			
			for(int col = 0; col < 5; col++)
			{
				if(wordGuess[row].length() != 0)											//  THIS METHOD IS INCOMPLETE.
				{
					if (matches[col] == 2)
						StdDraw.picture(209 + col * 68, 650 - row * 68, "letterFrameGreen.png");
					else if (matches[col] == 1)
						StdDraw.picture(209 + col * 68, 650 - row * 68, "letterFrameYellow.png");
					else
						StdDraw.picture(209 + col * 68, 650 - row * 68, "letterFrameDarkGray.png");
				}
				else
				{
					StdDraw.picture(209 + col * 68, 650 - row * 68, "letterFrame.png");
				}
			}
		}
		if(wordGuess[wordGuess.length - 1].length() == 5)
		{
			activeGame = false;
		}
		Font font = new Font("Arial", Font.BOLD, 34);
		StdDraw.setFont(font);
		int guessNumber = 0;
		for(int i = 0; i < wordGuess.length; i++)
		{
			if(wordGuess[i].length() > 0)
			{
				for(int j = 0; j < wordGuess[i].length(); j++)
				{
					StdDraw.text(209 + j * 68, 644 - i * 68, "" + wordGuess[i].charAt(j));
				}
			}
			if(wordGuess[i].length() == 5)
			{
				guessNumber = i + 1;
			}
		}
		for(int i = 0; i < letters.length(); i++)
		{
			StdDraw.text(209 + i * 68, 644 - guessNumber * 68, "" + letters.substring(i, i+1));
		}
	}
	
	/**
	 *	Compares the guess to the chosen word to find which letters should be green, which should
	 * 	be yellow, and which should be gray.
	 */
	public int[] checkMatches(String guess)
	{		
		boolean[] masterArr = new boolean[5];
		boolean[] guessArr = new boolean[5];
		int[] letterColors = new int[5];

		for (int i = 0; i < 5; i++)
		{
			if (guess.charAt(i) == word.charAt(i))
			{
				keyBoardColors[guess.charAt(i) - 'A'] = 3;
				letterColors[i] = 2;
				masterArr[i] = true;
				guessArr[i] = true;
			}
			else
			{
				if (keyBoardColors[guess.charAt(i) - 'A'] < 1)
					keyBoardColors[guess.charAt(i) - 'A'] = 1;
			}
		}
		
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				if (i != j)
				{
					if (guess.charAt(i) == word.charAt(j) && !masterArr[j] && !guessArr[i])
					{
						if (keyBoardColors[guess.charAt(i) - 'A'] < 2)
							keyBoardColors[guess.charAt(i) - 'A'] = 2;
						letterColors[i] = 1;
						masterArr[j] = true;
						guessArr[i] = true;
					}
				}
			}
			
		}

		return letterColors;
	}

	/** 
	 *  Checks to see if the game has been won or lost.  The game is won if the user enters the
	 *  correct word with a guess.  The game is lost when the user does not enter the correct word
	 *  with the last (6th) guess.  An appropriate message is displayed to the user in the form of 
	 *  a JOptionPane with JDialog for a win or a loss.
	 */
	public void checkIfWonOrLost ( )
	{
		String lastWord = "";
		for(int i = 0; i < wordGuess.length; i++)
		{
			if(wordGuess[i].length() == 5)
			{
				lastWord = wordGuess[i];
			}
		}
		if (lastWord.equalsIgnoreCase(word))
		{
			activeGame = false;
			JOptionPane pane = new JOptionPane(lastWord + " is the word!  Press RESET to begin again");
			JDialog d = pane.createDialog(null, "CONGRATULATIONS!");
			d.setLocation(365,250);
			d.setVisible(true);
		}
		else if (wordGuess[wordGuess.length - 1] != null && wordGuess[wordGuess.length - 1].length() == 5)
		{
			activeGame = false;
			JOptionPane pane = new JOptionPane(word + " was the word! Press RESET to begin again");
			JDialog d = pane.createDialog(null, "Sorry!");
			d.setLocation(365, 250);
			d.setVisible(true);
		}
	}
	
	/** 
	 *  This method is constantly looking for keyboard or mouse input from the user, and reacting
	 *  to this input.
	 */
	public void update ( )
	{
		if(activeGame)
		{
			respondToKeys();															//  THIS METHOD IS COMPLETE.
		}
		respondToMouse();
	}
	
	/** 
	 *  Responds to input from the keyboard.  Will call the method processGuess when the user has entered
	 *  a word to guess.
	 */
	public void respondToKeys ( )
	{
		if(readyForKeyInput && StdDraw.hasNextKeyTyped() && StdDraw.isKeyPressed(KeyEvent.VK_BACK_SPACE) && letters.length() > 0)
		{
			letters = letters.substring(0, letters.length() - 1);
			readyForKeyInput = false;
		}
		else if(readyForKeyInput && StdDraw.hasNextKeyTyped() && StdDraw.isKeyPressed(KeyEvent.VK_ENTER) && letters.length() == 5)
		{
			processGuess();
			readyForKeyInput = false;
		}
		else if(readyForKeyInput && StdDraw.hasNextKeyTyped() && letters.length() < 5)
		{
			String letter = "" + StdDraw.nextKeyTyped();								//  THIS METHOD IS COMPLETE.
			letter = letter.toUpperCase();
			if(letter.charAt(0) >= 'A' && letter.charAt(0) <= 'Z')
			{
				letters += letter;
			}
			readyForKeyInput = false;
		}
		else
		{
			while(StdDraw.hasNextKeyTyped())
			{	
				StdDraw.nextKeyTyped();
			}
			if(!StdDraw.hasNextKeyTyped())
			{
				readyForKeyInput = true;
			}
		}
	}
	
	/** 
	 *  Responds to input from the mouse, simulating the typing of keys on the "keyboard" at the bottom of the game panel.  
	 *  Will call the method processGuess when the user has entered a word to guess.
	 */
	public void respondToMouse ( )
	{
		if(readyForMouseInput && StdDraw.isMousePressed())
		{
			for(int i = 0; i < Constants.KEYPLACEMENT.length; i++)
			{
				if(StdDraw.mouseX() > Constants.KEYPLACEMENT[i][0] - 22 && StdDraw.mouseX() < Constants.KEYPLACEMENT[i][0] + 22 && StdDraw.mouseY() > Constants.KEYPLACEMENT[i][1] - 29 && StdDraw.mouseY() < Constants.KEYPLACEMENT[i][1] + 29)
				{
					if(i == 28)
					{
						initAll("");
						activeGame = true;
					}
					else if(activeGame && i == 27 && letters.length() > 0)				//  THIS METHOD IS COMPLETE.
					{
						letters = letters.substring(0, letters.length() - 1);
					}
					else if(activeGame && i == 19 && letters.length() == 5)
					{
						processGuess();
					}
					else if(activeGame && i != 19 && i != 27 && i != 28 && letters.length() < 5)
					{
						String letter = Constants.KEYBOARD[i].toUpperCase();
						letters += letter;
					}
				}
			}
			readyForMouseInput = false;
		}
		else if(!StdDraw.isMousePressed())
		{
			readyForMouseInput = true;
		}
	}
	
	/** 
	 *  Processes the guess made by the user.  This method will only be called if the field variable letters
	 *  has length 5.  The guess in letters will need to be checked against the words in words5allowed.txt.
	 *  The method inAllowedWordFile will be called for this task.  If the guess in letters does not exist
	 *  in the text file, a message is displayed to the user in the form of a JOptionPane with JDialog.
	 */
	public void processGuess ( )
	{
		int guessNumber = 0;
		for(int i = 0; i < wordGuess.length; i++)
		{
			if(wordGuess[i].length() == 5)
			{
				guessNumber = i + 1;
			}
		}
		letters = letters.toLowerCase();
		if (inAllowedWordFile(letters))
		{
			wordGuess[guessNumber] = letters.toUpperCase();
			checkMatches(wordGuess[guessNumber]);
		}
		else
		{
			JOptionPane pane = new JOptionPane(letters + " not in word list");
			JDialog d = pane.createDialog(null, "INVALID INPUT");
			d.setLocation(365,250);
			d.setVisible(true);
		}
		
		letters = "";
	}

	/** 
	 *  Checks to see if the word in the parameter list is found in the text file words5allowed.txt
	 *  Returns true if the word is in the file, false otherwise.
	 *  @param possibleWord       the word to looked for in words5allowed.txt
	 *  @return                   true if the word is in the text file, false otherwise
	 */
	public boolean inAllowedWordFile(String possibleWord)
	{
		Scanner sc = OpenFile.openToRead("words5allowed.txt");
		while (sc.hasNext())
		{
			String line = sc.next();
			if (line.trim().equals(possibleWord))
				return true;
		}
		return false;
	}
}