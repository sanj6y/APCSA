/**
 * Pegs.java
 * 
 * Implementation of Peg Solitaire game on
 * 7x7 or 9x9 board. Highlights possible moves,
 * prints lose/win message depending on game
 * result, and provides reset 7x7 / reset 9x9
 * buttons to reset game to a 7x7 or 9x9 board
 * respectively.
 * 
 * @author Sanjay Chandrasekar
 * @version 1.0
 * @since 1/24/2022
 */
import java.awt.Color;
import java.awt.Font;

public class Pegs
{
	/**    The board object.  1 represents a peg on the board, 0 is an empty space,
	 *     and -1 would indicate that this cell is not part of the board.                  */
	private int [][] board;
	
	/**    How long the GUI should pause, before expecting new input.                      */
	private int pause;
	
	/**    Current x and y values of the user's choice.  The x values count the cells
	 *     from the lower left to the right, while the y values count the cells from
	 *     the bottom left up.                                                             */
	private int xposition, yposition;
		
	/**
	 *  Creates a Pegs object, with the font to be used, current position initially
	 *  pause off the board, pause at 50 milliseconds, and the board values initialized
	 *  in a 9 x 9 grid.
	 */
	public Pegs ( )
	{
		Font font = new Font("Arial", Font.BOLD, 18);
		StdDraw.setFont(font);
		xposition = yposition = -5;
		pause = 50;
		board = new int[][]{{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},
						{1,1,1,1,1,1,1,1,1},{1,1,1,1,0,1,1,1,1},{1,1,1,1,1,1,1,1,1},
						{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1}};
	}
	
	/**
	 *  Sets up and runs the game of Pegs.
	 *  @param  args     An array of String arguments (not used here).
	 */
	public static void main(String [] args)   
	{
		Pegs run = new Pegs();
		run.playGame();
	}
	
	/**
	 *  Calls neccessary methods to run
	 * 	the game of Pegs.
	 */
	public void playGame ( )
	{
		StdDraw.enableDoubleBuffering();
		boolean done = false;
		do
		{
			drawBoard();
			if(StdDraw.isMousePressed())
			{
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();
				int checkx = (int)(10 * x - 0.5);
				int checky = (int)(10 * y - 0.5);
				if(reset(x,y))
				{
					xposition = yposition = -5;
				}
				else if(possibleMoveSpace(xposition,yposition,checkx,checky))
				{
					board[checkx][checky] = 1;
					board[xposition][yposition] = 0;
					board[(xposition+checkx)/2][(yposition+checky)/2] = 0;

					//  You'll need to figure out how to "jump" from xposition, yposition to checkx, checky.
					
					StdDraw.show();
					StdDraw.pause(4 * pause);
				}
				else
				{
					xposition = checkx;
					yposition = checky;
					StdDraw.show();
					StdDraw.pause(pause);
				}
			}
			StdDraw.show();
			StdDraw.pause(pause);
		}
		while(!done);
	}
	
	/**
	 *  Draws the entire board (every frame) that
	 * 	the game is played on.
	 */
	public void drawBoard ( )
	{
		StdDraw.setPenColor(new Color(0,0,0));
		StdDraw.filledSquare(0.5,0.5,0.5);
		StdDraw.setPenColor(new Color(120,120,120));
		StdDraw.filledSquare(0.5,0.5,0.475);
		for ( int i = 0; i < board.length; i++ )
		{
			for ( int j = 0; j < board[i].length; j++ )
			{
				if(board[i][j] != -1)
				{
					drawCell(i,j);
				}
			}
		}
		drawResetButtons();
		drawWinOrLoseMessage();

	}
	
	/**
	 *  Draws the "RESET 7 x 7" and "RESET 9 x 9"
	 * 	buttons for the user to click to reset the
	 * 	board to a 7x7 game or a 9x9 game respectively.
	 */
	public void drawResetButtons ( )
	{
		StdDraw.setPenColor(new Color(0,0,0));
		StdDraw.filledRectangle(0.8, 0.27, 0.125, 0.05);
		StdDraw.setPenColor(new Color(255,255,255));
		StdDraw.text(0.8, 0.27, "RESET 7 x 7");
		
		StdDraw.setPenColor(new Color(0,0,0));
		StdDraw.filledRectangle(0.8, 0.12, 0.125, 0.05);
		StdDraw.setPenColor(new Color(255,255,255));
		StdDraw.text(0.8, 0.12, "RESET 9 x 9");
	}
	
	/**
	 *  Draws a "YOU LOSE!" message or a
	 * 	"YOU WIN!" message when the game
	 *  is over depending on the outcome
	 *  of the game.
	 */
	public void drawWinOrLoseMessage ( )
	{
		if (countPegs() == 1)
		{
			StdDraw.setPenColor(new Color(0,0,0));
			StdDraw.filledRectangle(0.2, 0.8, 0.125, 0.05);
			StdDraw.setPenColor(new Color(255,255,255));
			StdDraw.text(0.2, 0.8, "YOU WIN!");
		}
		else if (gameIsFinished())
		{
			StdDraw.setPenColor(new Color(0,0,0));
			StdDraw.filledRectangle(0.2, 0.8, 0.125, 0.05);
			StdDraw.setPenColor(new Color(255,255,255));
			StdDraw.text(0.2, 0.8, "YOU LOSE!");
		}
	}
	
	/**
	 *  Resets the board to a 7x7 or 9x9 depending
	 *  on which button is clicked, the "RESET 7 x 7"
	 * 	button or the "RESET 9 x 9" button.
	 */
	public boolean reset(double x, double y)
	{
		if (x >= 0.8 - 0.125 && x <= 0.8 + 0.125 && y >= 0.27 - 0.05 && y <= 0.27 + 0.05)
		{
			board = new int[][]{{-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},
				{-1,-1,-1,1,1,1,-1,-1,-1}, {-1,1,1,1,1,1,1,1,-1},{-1,1,1,1,0,1,1,1,-1},
				{-1,1,1,1,1,1,1,1,-1}, {-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1}};
			return true;
		}
		
		else if (x >= 0.8 - 0.125 && x <= 0.8 + 0.125 && y >= 0.12 - 0.05 && y <= 0.12 + 0.05)
		{
			board = new int[][]{{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},
				{-1,-1,-1,1,1,1,-1,-1,-1}, {1,1,1,1,1,1,1,1,1},{1,1,1,1,0,1,1,1,1},
				{1,1,1,1,1,1,1,1,1}, {-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},
				{-1,-1,-1,1,1,1,-1,-1,-1}};
			return true;
		}
		
		else
			return false;
	}
	
	/**
	 *  Draws each individual cell, corresponding to
	 * 	whether there's a peg in it or not, or even
	 * 	if it's a square in the game at all (varies
	 * 	between 7x7 games and 9x9 games). Also highlights
	 * 	in red the selected peg, and displays possible
	 * 	moves for selected peg.
	 */
	public void drawCell(int x, int y)   
	{
		StdDraw.setPenColor(new Color(0,0,0));
		StdDraw.filledSquare(0.1 + 0.1 * x, 0.1 + 0.1 * y, 0.055);
		StdDraw.setPenColor(new Color(255,255,255));
		StdDraw.filledSquare(0.1 + 0.1 * x, 0.1 + 0.1 * y, 0.0425);
		StdDraw.setPenColor(new Color(200,200,200));
		StdDraw.filledCircle(0.1 + 0.1 * x, 0.1 + 0.1 * y, 0.02);
		if(x == xposition && y == yposition && board[x][y] == 1)
		{
			StdDraw.setPenColor(new Color(0,0,0));
			StdDraw.filledSquare(0.1 + 0.1 * x, 0.1 + 0.1 * y, 0.05);
			StdDraw.setPenColor(new Color(230,30,30));
			StdDraw.filledCircle(0.1 + 0.1 * x, 0.1 + 0.1 * y, 0.04);
		}
		if(possibleMoveSpace(xposition,yposition,x,y))
		{
			StdDraw.setPenColor(new Color(0,0,0));
			StdDraw.filledSquare(0.1 + 0.1 * x, 0.1 + 0.1 * y, 0.05);
			StdDraw.setPenColor(new Color(230,30,30));
			StdDraw.filledCircle(0.1 + 0.1 * x, 0.1 + 0.1 * y, 0.03);
		}
		if(board[x][y] == 1)
		{
			StdDraw.picture(0.1 + 0.1 * x, 0.1 + 0.1 * y,"peg.png");
		}
	}
	
	/**
	 *  Determines whether it's possible for a marble
	 * 	that is currently on a certain square to move
	 * 	to another certain square.
	 */
	public boolean possibleMoveSpace(int x, int y, int xval, int yval)
	{
		if (x == -5 && y == -5) return false;
		if (board[x][y] == 1 && board[xval][yval] == 0)
		{
			if (Math.abs(x - xval) == 2 && y - yval == 0)
			{
				if (board[(x + xval) / 2][yval] == 1)
					return true;
			}
			if (Math.abs(y - yval) == 2 && x - xval == 0)
			{
				if (board[xval][(y + yval) / 2] == 1)
					return true;
			}
		}
		
		return false;
	}
	
	/**
	 *  Determines if the game is over, by checking
	 *  if there are no more possible moves for any
	 * 	of the pegs, meaning the game is lost, or by
	 * 	simply seeing if there's only one peg left,
	 * 	meaning the game has been won.
	 */
	public boolean gameIsFinished()
	{
		if (countPegs() == 1) return true;

		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				if (board[i][j] == 1)
				{
					/*
					for (int row = 0; row < board.length; row++)
					{
						for (int col = 0; col < board[0].length; col++)
						{
							if (possibleMoveSpace(i, j, row, col))
								return false;
						}
					}
					*/
					
					if (i-2 >= 0 && possibleMoveSpace(i, j, i-2, j)) return false;
					if (j-2 >= 0 && possibleMoveSpace(i, j, i, j-2)) return false;
					if (board.length > i+2 && possibleMoveSpace(i, j, i+2, j)) return false;
					if (board[0].length > j+2 && possibleMoveSpace(i, j, i, j+2)) return false;
					 
				}
			}
		}
		
		return true;
		
	}
	
	/**
	 *  Counts and returns the number of pegs
	 * 	currently on the board.
	 */
	public int countPegs ( )
	{
		int count = 0;
		
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				if (board[i][j] == 1)
					count++;
			}
		}
		
		return count;
	}
}