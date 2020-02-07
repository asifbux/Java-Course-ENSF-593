package models;
import java.util.Scanner;

/**
 * Provide data members and methods to create a player object for tic-tac-toe 
 * board game in a Java application.
 * The overall purpose of this class exercise is to illustrate how tic-tac-toe 
 * player is created and its mark is set along with the opponent of this player object.
 * @author Asif Bux
 * @version 1.0
 * @since November 5, 2019
 */
public class Player {
	
	/** The name of the player object. */
	String name;

	/** The board object which player belongs too. */
	Board board;
	
	/** The opponent of this player object. */
	Player opponent;
	
	/** The mark that belongs to this player either X or O. */
	char mark;
	
	/**
	 * Instantiates a new player object by assigning it a name and selected mark.
	 *
	 * @param name the name of the player object
	 * @param mark the mark of the player object
	 */
	public Player(String name, char mark) {
		this.name = name;
		this.mark = mark;
	
	}
	
	/**
	 * Sets the opponent of this player object.
	 *
	 * @param opp the new opponent
	 */
	public void setOpponent(Player opp) {
		this.opponent = opp;
		
	}
	
	/**
	 * Sets the board with the Tic-Tac-Toe logic.
	 *
	 * @param board the new board object for this player object.
	 */
	public void setBoard(Board board) {
		this.board = board; // Association, play uses the object of Board
		
	}
	
	/**
	 * Play method allows player to make their move if certain conditions are met.
	 * To make a move no user shall have won the game already and the board must not be full.
	 *  If a winner is confirmed it declares that winner or ends the game in tie.
	 */
	public void play() {
		if ( board.xWins() == false && board.oWins() == false && board.isFull() == false) { // 
			makeMove();
		}
		else {
			if (mark == 'X' && board.xWins()) {
				board.display();
				System.out.print("The GAME IS OVER: " + this.name + " is the winner");
				System.exit(0);
			}
			if (mark == 'O' && board.oWins()) {
				board.display();
				System.out.print("The GAME IS OVER: " + opponent.name + " is the winner");
				System.exit(0);
			}
			else {
				board.display();
				System.out.print("The GAME HAS ENDED IN TIE");
				System.exit(0);
			}
		}
	}
	
	/**
	 * Make move method displays and allows user to input their selected row and column for their move.
	 */
	public void makeMove() {
		System.out.println(name + " what row should your next " + mark + " be placed in? ");
		Scanner keyboard = new Scanner(System.in);
		int row = keyboard.nextInt();
		System.out.println(name + " what column should your next " + mark + " be placed in? ");
		int col = keyboard.nextInt();
		board.addMark(row, col, mark);
		board.display();
	
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the mark.
	 *
	 * @return the mark
	 */
	public char getMark() {
		return mark;
	}

	/**
	 * Sets the mark.
	 *
	 * @param mark the new mark
	 */
	public void setMark(char mark) {
		this.mark = mark;
	}

	/**
	 * Gets the opponent.
	 *
	 * @return the opponent
	 */
	public Player getOpponent() {
		return opponent;
	}
	

}
