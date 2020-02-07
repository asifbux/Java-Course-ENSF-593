package views;
import java.io.*;

import models.Board;
import models.Constants;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 

/**
 * Provide data members and methods to run tic-tac-toe 
 * board game in a Java application.
 * The overall purpose of this class exercise is to illustrate how different tic-tac-toe 
 * classes come together to allow users to play game in real time, such as letting user choose their opponents. 
 * @author Asif Bux
 * @version 1.0
 * @since October 4, 2019
 */
public class Game implements Constants {

	/** The board object. */
	private Board theBoard;
	
	/** The referee object which will control the game. */
	private Referee theRef;
	
    /**
     * Instantiates a new game object by constructing new board object.
     */
    public Game( ) {
        setTheBoard(new Board()); // Class game makes the object of Board therefore, composition
	}
    
    /**
     * Appoint referee object to this game object.
     *
     * @param r the r of type referee 
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }
	
	/**
	 * The main method of the game.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name= stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.getTheBoard());
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		
		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.getTheBoard());
		
		theRef = new Referee();
		theRef.setBoard(theGame.getTheBoard());
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
        
        theGame.appointReferee(theRef);
	}

	public Board getTheBoard() {
		return theBoard;
	}

	public void setTheBoard(Board theBoard) {
		this.theBoard = theBoard;
	}
	

}
