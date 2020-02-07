package frontEnd;

import models.Board;
import views.GameView;
import controller.GameController;

/**
 * The Class FrontEnd.
 * @author Asif Bux
 * @version 1.0
 * @since November 5, 2019
 */
public class FrontEnd {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String [] args) {
		
		Board newBoard = new Board();
		GameView mygame = new GameView();
		new GameController(mygame, newBoard);
		
	}

}
