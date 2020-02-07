package controller;

import views.*;
import models.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import models.Board;
import models.Constants;

/**
 * The Class GameController.
 * @author Asif Bux
 * @version 1.0
 * @since November 5, 2019
 */
public class GameController implements Constants {

	/** The board. */
	private Board theBoard;
	
	/** The frame. */
	private GameView frame;
	
	/** The watch player. */
	private Player xPlayer, oPlayer, watchPlayer;
	
    /**
     * Instantiates a new game controller.
     *
     * @param frame the frame
     * @param theBoard the the board
     */
    public GameController(GameView frame, Board theBoard ) {
        this.theBoard  = theBoard; // Class game makes the object of Board therefore, composition
        this.frame = frame;
        setTheGame();
        runTheGame();
        this.frame.createActionListener(new TicTacToeListener());
    }
    
	/**
	 * Sets the the game.
	 */
	public void setTheGame() {

		xPlayer = new Player(frame.getPlayersName("Enter the Player X's name"), LETTER_X);
		oPlayer = new Player(frame.getPlayersName("Enter the Player O's name"), LETTER_O);
		oPlayer.setBoard(theBoard);
		xPlayer.setBoard(theBoard);
	}
	
	/**
	 * Run the game.
	 */
	public void runTheGame() {
		//setOpponent of Player class to setX and setO players
		this.xPlayer.setOpponent(oPlayer);
		this.oPlayer.setOpponent(xPlayer);
		makeMove(xPlayer);
	}
	
	/**
	 * Make move.
	 *
	 * @param thePlayer the the player
	 */
	public void makeMove(Player thePlayer) {
		this.frame.setArea(thePlayer.getName() + " is your turn");
		this.frame.setPlayerNameText(thePlayer.getName());
		this.frame.setPlayerText(String.valueOf(thePlayer.getMark()));
		this.watchPlayer = thePlayer.getOpponent();
	
	}
	
    /**
     * Check move.
     */
    public void checkMove() {
        if(this.theBoard.xWins()) {
            this.frame.setArea("GAME OVER: " + xPlayer.getName() + " is winner!");
            this.frame.setPlayerText(String.valueOf(xPlayer.getMark()));
            this.frame.setPlayerNameText(xPlayer.getName());
            this.frame.createMessage("GAME OVER: " + xPlayer.getName() + " is winner!");
        }
        else if(this.theBoard.oWins()) {
            this.frame.setArea("GAME OVER: " + oPlayer.getName() + " is winner!");
            this.frame.setPlayerText(String.valueOf(oPlayer.getMark()));
            this.frame.setPlayerNameText(oPlayer.getName());
            this.frame.createMessage("GAME OVER: "+ oPlayer.getName() + " is winner!");
        }
        else if(this.theBoard.isFull()) {
            System.out.print("GAME OVER: It's tie!");
            frame.createMessage("GAME OVER: It's tie!");
        }
    }
	
    /**
     * The listener interface for receiving ticTacToe events.
     * The class that is interested in processing a ticTacToe
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addTicTacToeListener<code> method. When
     * the ticTacToe event occurs, that object's appropriate
     * method is invoked.
     *
     * @see TicTacToeEvent
     */
    private class TicTacToeListener implements ActionListener {
        
        /**
         * Action performed.
         *
         * @param e the e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int[] position = frame.getButtonPosition((JButton) e.getSource(), watchPlayer.getMark());
            if(theBoard.getMark(position[0], position[1]) == SPACE_CHAR) {
                makeMove(watchPlayer);
                theBoard.addMark(position[0], position[1], watchPlayer.getMark());
                frame.addMarkOnView((JButton) e.getSource(), watchPlayer.getMark());
            }
            checkMove();
        }
    }
}