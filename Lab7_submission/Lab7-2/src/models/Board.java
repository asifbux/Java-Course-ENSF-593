package models;
//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 
/**
 * Provide data members and methods to create and stimulate tic-tac-toe 
 * board game in a Java application.
 * The overall purpose of this class exercise is to illustrate how tic-tac-toe 
 * logic works in real life, by allowing players to Mark X or O on the board, 
 * and finally declaring the outcome of the game.
 * @author Asif Bux
 * @version 1.0
 * @since November 5, 2019
 */
public class Board implements Constants {
	
	/** The row and column of the board game. */
	private char theBoard[][];
	
	/** The mark count of X's & O's on the board. */
	private int markCount;

	/**
	 * Instantiates a new board object with the markCount set to 0 and empty space 
	 * of rows and columns. 
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/**
	 * Gets the mark of the board object from its rows and columns.
	 *
	 * @param row the board object's row
	 * @param col the board object's column
	 * @return the mark
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * Checks if the board object is full with marking.
	 *
	 * @return true, if is full
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * Returns true if X player wins the board game and otherwise false.
	 * This method calls another method checkWinner(LETTER_X) which performs the checking on the board object.
	 *
	 * @return true, if X player win is successful.
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Returns true if O player wins the board game and otherwise false.
	 *
	 * @return true, if O player win is successful.
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Display's the rows and columns of the board game with the marking if any. 
	 * Helps users understand the capacity on the board object by displaying it.
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * Adds the mark on the board object.
	 * Allows players to add the respective marks on the board object.
	 *
	 * @param row the row of the board object
	 * @param col the column of the board object
	 * @param mark the mark
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 * Clears the board object with empty spaces and sets the markCount data member to 0.
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * Check for the winner of the board object by iterating over rows, columns and diagonally. 
	 * 
	 *
	 * @param mark the mark on the board object.
	 * @return the int, returns 1 for Win and 0 for loss.
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * Display's column headers of the board object to the player on the screen.
	 * Helps the player understand which row and column to select by displaying it.
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * Adds the hyphens to the board which allows the construction of visual board game.
	 * Helps user see the actual visual board game.
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * Adds the spaces in between of the hyphens of the board object on the screen to allow players to mark.
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
