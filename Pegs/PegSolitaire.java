import java.util.Scanner;


/**
 * Program used to play the peg solitaire game.
 * Adhering to the game rules, the user is only allowed to
 * jump a distance of 2 positions, and this jump must be over an existing peg.
 * 
 * The user is allowed to play the game until:
 * they win (only one peg left, in the middle of the board)
 * they lose (there are no valid moves left to be made)
 * they quit (the user enters -1 into the command prompt, effectively ending the game)
 * 
 * @author Christopher Grate
 *
 */
public class PegSolitaire {

	static int[][] puzzleRep; //Representation of the board state
	public static void main(String[] args) {
		banner();
		//initialPuzzle();
		puzzleFill();
		printBoard();
		Scanner input = new Scanner(System.in);
		int n = 0;
		int startingRow;
		int startingCol;
		int endingRow;
		int endingCol;
		boolean restart;
		
		//While the user does not quit (hence they have not entered -1)
		while(n != -1){
			restart = false;
			//Valid move check
			if(!validMove()){
				System.out.println("There are no more legal moves.");
				break;
				
			}
			//Moving from
			do{
				System.out.println();
				System.out.print("Enter the location of the peg to move (RC, -1 to quit): ");
				n = input.nextInt();
				startingRow = n / 10;
				startingCol = n %10;
				if(n == -1){
					//User exited
					System.out.println("Player quit.");
					break;
				}
			}
			while(!checkStart(startingRow,startingCol));
			
			if(n!=-1){
			
				//Moving to
				do{
					System.out.println();
					System.out.print("Enter the location where the peg is moving to (RC, -1 to quit): ");
					n = input.nextInt();
					endingRow = n / 10;
					endingCol = n %10;
					if(n == -1){
						//User exited
						System.out.println("Player quit.");
						break;
					}
					
					if(!checkEndMove(startingRow,startingCol,endingRow,endingCol)){
						restart = true;
						break;
					}
				}
				while(!checkEndError(endingRow,endingCol));
				
				//At this point, were both choices not quitting?
				if(n!=-1 && !restart){

					//If a valid move
					makeMove(startingRow,startingCol,endingRow,endingCol);
					printBoard();
				}
			
			}		
			
		}
			//Tally the ammount of pegs left on the board	
			int pegCount = 0;
			for(int i = 0; i < 7;i++){
				for(int j = 0; j < 7; j ++){
					if(puzzleRep[i][j] == 1){
						pegCount+=1;	
					}
				}
			}//End for loop
			System.out.println("You left "+pegCount+" on the board.");
			
	}//End main

/**
 * Method used to  print the current board state, generally after every move the user makes.
 */
public static void printBoard(){
	String border = "        +---------+\n";
	String shortLBorder = "       |";
	String shortRBorder = "|\n";
	String shortdashBorder = " +-----+";
	String shortdashBorderR = "+-----+\n";
	String lBorder = "|";
	String space = "   ";
	String peg = " X ";
	String column = "    0  1  2  3  4  5  6\n";
	
	System.out.print(column);
	System.out.print(border);
	System.out.print("0");
	System.out.print(shortLBorder);
	if(puzzleRep[0][2]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	
	if(puzzleRep[0][3]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	
	if(puzzleRep[0][4]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
    System.out.print(shortRBorder);
    System.out.print(1);
    System.out.print(shortdashBorder);
    
    if(puzzleRep[1][2]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	
	if(puzzleRep[1][3]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	
	if(puzzleRep[1][4]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	System.out.print(shortdashBorderR);
	
	for(int i = 2; i < 5;i++){
		System.out.print(i+" ");
		System.out.print(lBorder);
		for(int j = 0; j < 7; j ++){
			if(puzzleRep[i][j] == 1){
				System.out.print(peg);
			}
			else{
				System.out.print(space);
			}
		}//End for loop
		
		System.out.print(shortRBorder);
	}//End row 2-4 border print
	
	System.out.print("5");
	System.out.print(shortdashBorder);
	if(puzzleRep[5][2]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	
	if(puzzleRep[5][3]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	
	if(puzzleRep[5][4]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
    System.out.print(shortdashBorderR);
    
    
    System.out.print(6);
    System.out.print(shortLBorder);
    if(puzzleRep[6][2]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	
	if(puzzleRep[6][3]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	
	if(puzzleRep[6][4]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	System.out.print(shortRBorder);
	System.out.print(border);
	
	
	
}

/**
 * Method used to fill the puzzle representation logic.
 * For the purposes of the game, a 0 represents an empty space, a 2 represents a peg.
 */
public static void puzzleFill(){
		System.out.println();
		puzzleRep = new int[7][7];
		for(int i = 0; i < 7;i++){
			for(int j = 0; j < 7;j++){
				puzzleRep[i][j] = 1;
			}
		
		}
		puzzleRep[3][3] = 0;
		puzzleRep[0][0] = 2;
		puzzleRep[0][1] = 2;
		puzzleRep[0][5] = 2;
		puzzleRep[0][6] = 2;
		puzzleRep[1][0] = 2;
		puzzleRep[1][1] = 2;
		puzzleRep[1][5] = 2;
		puzzleRep[1][6] = 2;
		
	
		puzzleRep[5][0] = 2;
		puzzleRep[5][1] = 2;
		puzzleRep[5][5] = 2;
		puzzleRep[5][6] = 2;
		puzzleRep[6][0] = 2;
		puzzleRep[6][1] = 2;
		puzzleRep[6][5] = 2;
		puzzleRep[6][6] = 2;
		
	}//End puzzle
	

/**
 * 
 * Method used to make the move indicated by the player (at this point it has been confirmed to be valid)
 * Update the gameboard representation accordingly.
 * 
 * @param startRow - the row our move starts on
 * @param startCol - the column our move starts on
 * @param endRow - the row our move end on
 * @param endCol - the column our move ends on
 * 
 */
public static void makeMove(int startRow, int startCol, int endRow, int endCol){
	
		//Start peg jumping, hence it becomes 0
		puzzleRep[startRow][startCol] = 0;
		//End spot being jumped to, hence it becomes 1
		puzzleRep[endRow][endCol] = 1;
		
		int middleRow = ((startRow + endRow) / 2);
		int middleCol = ((startCol + endCol) /2);
		
		//Middle peg removed, hence becomes 0
		puzzleRep[middleRow][middleCol] = 0;
	
}


/**
 * Method used to check if there are any more valid moves to make.
 * @return - a boolean denoting whether there exists any more valid moves
 */
public static boolean validMove(){
	
	for(int i = 0; i < 7; i ++){
		for(int j = 0; j < 7; j ++){
			if(puzzleRep[i][j] == 1){
				//Check up
				if( (i > 1 && j > 1 && j < 5)  || (i > 3 && j < 2 && j > 4)){
					//If peg exists above current
					if(puzzleRep[i-1][j] == 1 && puzzleRep[i-2][j] == 0){
						return true;
					}
				}
				
				//Check down
				if( (i < 5 && j > 1 && j < 5)  || (i < 3 && j < 2 && j > 4)){
					//If peg exists above current
					if(puzzleRep[i+1][j] == 1 && puzzleRep[i+2][j] == 0){
						return true;
					}
				}
				
				//Check left
				if( (j > 1 && i > 1 && i < 5)  || (j > 3 && i < 2 && i > 4)){
					//If peg exists above current
					if(puzzleRep[i][j-1] == 1 && puzzleRep[i][j-2] == 0){
						return true;
					}
				}
				
				//Check right
				if( (j < 5 && i > 1 && i < 5)  || (j < 3 && i < 2 && i > 4)){
					//If peg exists above current
					if(puzzleRep[i][j+1] == 1 && puzzleRep[i][j+2] == 0){
						return true;
					}
				}
				
			}
		}
	}
	return false;
	
}

/**
 * Method used to determine whether the player is attempting to move a valid piece.
 * A valid piece to be moved is one that is actually on the gameboard, and actually exists
 * at the position in question (the combination of startRow and startCol)
 * 
 * @param startRow - The row the player is attempting to move a piece from
 * @param startCol - The column the player is attempting to move a piece from
 * @return - a boolean denoting whether or not the player is attempting to move a valid piece.
 */

public static boolean checkStart(int startRow,int startCol){
	
		
		//Check top 2 corners (Start)
		if((startRow < 2 && startCol < 2) || (startRow < 2 && startCol > 4) ){
			System.out.println("Illegal location.");
			return false;
		}
		
		//Check bottom 2 corners (Start)
		if((startRow > 4 && startCol < 2) || (startRow > 4 && startCol > 4) ){
			System.out.println("Illegal location.");
			return false;
		}
		
		//Is there a peg at start spot?
		if(puzzleRep[startRow][startCol] != 1){
			System.out.println("Illegal move, no peg at source location.");	
			return false;
		}	
				
		return true;
}


/**
 * Method used to check whether the user is jumping to a valid position on the board.
 * A valid position is one not currently occupied by a peg, and on the gameboard itself.
 * 
 * 
 * @param endRow - the row position being jumped to
 * @param endCol - the column position being jumped to
 * @return - a boolean denoting whether the move is valid.
 */

public static boolean checkEndError(int endRow, int endCol){
	//Is there a peg at end spot?
	if(puzzleRep[endRow][endCol] == 1){	
		System.out.println("Illegal move, destination location is occupied");
		return false;
	}
	
	//Check top 2 corners(End)
	if((endRow < 2 && endCol < 2) || (endRow < 2 && endCol > 4) ){
		System.out.println("Illegal location.");
		return false;
	}
	
	//Check bottom 2 corners(End)
	if((endRow > 4 && endCol < 2) || (endRow > 4 && endCol > 4) ){
		System.out.println("Illegal location.");
		return false;
	}
	
	return true;
	
}

/**
 * Method used to check whether the move the user is attempting to make is indeed a valid move, given the ruleset of the game.
 * 
 * @param startRow - the row our move starts on
 * @param startCol - the column our move starts on
 * @param endRow - the row our move end on
 * @param endCol - the column our move ends on
 * @return - a boolean whether the move is valid, or not valid, along with an appropriate error message.
 */

public static boolean checkEndMove(int startRow, int startCol, int endRow, int endCol){
		int middleRow;
		int middleCol;
		
		//Check column distance
		if(startRow == endRow){
			//Not moving, start and end are same
			if(startCol == endCol){
				System.out.println("Illegal move, no peg being jumped over, re-enter move.");
				return false;
			}
			//Not jumping a distance of 2
			if(Math.abs(startCol - endCol) !=2){
				System.out.println("Illegal move, can only jump over one peg, re-enter move.");
				return false;
			}
		}
		
		//Check row distance
		else{
			System.out.println("Also here");
			//Check for diagonal move
			if(startCol != endCol){
				System.out.println("Illegal move, can only jump over one peg, re-enter move.");
				return false;
			}
			// Not jumping a distance of 2
			if(Math.abs(startRow - endRow)!=2){
				System.out.println();
				System.out.println("Illegal move, can only jump over one peg, re-enter move.");
				return false;
			}
		}
		
		middleRow = ((startRow + endRow) / 2);
		middleCol = ((startCol + endCol) /2);
		
		//Check whether the user is actually jumping over a peg.
		if(puzzleRep[middleRow][middleCol] != 1){
			System.out.println("Illegal move, no peg being jumped over, re-enter move.");
			return false;
		}
	return true;
	
}// End checkEnd




/**
 * Method used to set up the Peg Solitaire gameboard representation at the start of the game.
 */
public static void initialPuzzle(){
		System.out.print("   ");
		for(int i = 0; i < 7; i ++){
			if(i !=6){
				System.out.print(i+"  ");
			}
			else{
				System.out.print(i);
			}		
		}
		System.out.println();
		
		System.out.print("        ");
		System.out.print("+---------+");
		System.out.println();
		
		for(int i = 0; i <7;i++){
			System.out.print(i+" ");
			if(i == 0 || i == 6){
				System.out.print("      | X  X  X |      ");
				System.out.println();
			}
			
			if(i == 1 || i==5){
				System.out.print("+-----+ X  X  X +-----+");
				System.out.println();	
			}
			
			if(i == 2 || i == 4){
				System.out.print("| X  X  X  X  X  X  X |");
				System.out.println();
			}
			
			if(i == 3){
				System.out.print("| X  X  X     X  X  X |");
				System.out.println();
			}
		}//End for loop
		System.out.print("        ");
		System.out.print("+---------+");
		System.out.println();
		
	}
	
	public static void banner(){
		System.out.println("************************");
		System.out.println("**     Peg Puzzle     **");
		System.out.println("************************");
		System.out.println();
	}

}