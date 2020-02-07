package views;

import javax.swing.*;

import models.Board;

import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Provide data members and methods to run tic-tac-toe 
 * board game in a Java application.
 * The overall purpose of this class exercise is to illustrate how different tic-tac-toe 
 * classes come together to allow users to play game in real time, such as letting user choose their opponents. 
 * @author Asif Bux
 * @version 1.0
 * @since November 5, 2019
 */
public class GameView extends JFrame {
	
	/** The j buttons. */
	private JButton [][] jButtons = new JButton[3][3];
	
	/** The area. */
	private JTextArea area;
	
	/** The player name text. */
	private JTextField playerText, playerNameText;
	
	/**
	 * Instantiates a new game view.
	 */
	public GameView() {
		JPanel panel = new JPanel();
		panel.setLayout(( new GridBagLayout()));
		GridBagConstraints gbc = new GridBagConstraints();
		setGridBagLayout(gbc, panel);
		setSize(600,300);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	/**
	 * Sets the grid bag layout.
	 *
	 * @param gbc the gbc
	 * @param panel the panel
	 */
	public void setGridBagLayout(GridBagConstraints gbc, JPanel panel) {
	      gbc.gridx = 0;
	      gbc.gridy = 0;
	      setGrid(panel, gbc);

	      gbc.gridx = 1;
	      gbc.gridy = 0;
	      setWindowArea(panel, gbc);
  
	      gbc.gridx = 0;
	      gbc.gridy = 1;
	      playerText = new JTextField();
	      populateLabelTextField(panel,gbc, "Player: ", " ", 30, 20, playerText);

	      gbc.gridx = 0;
	      gbc.gridy = 2; 
	      playerNameText = new JTextField();
	      populateLabelTextField(panel,gbc, "User Name: ", " ", 150, 20, playerNameText);
 
	}
	
	/**
	 * Sets the grid.
	 *
	 * @param panel the panel
	 * @param gbc the gbc
	 */
	public void setGrid(JPanel panel, GridBagConstraints gbc) {
		JPanel p = new JPanel();
		p.setSize(500, 400);
		p.setLayout( new GridLayout(3,3));
        for(int i = 0; i < jButtons.length; i++) {
            for(int j = 0; j < jButtons.length; j++ ) {
                jButtons[i][j] = new JButton();
                jButtons[i][j].setPreferredSize(new Dimension(40, 40));
                p.add(jButtons[i][j]);
            }
        }
		panel.add(p,gbc);
		
	}
	
	/**
	 * Sets the window area.
	 *
	 * @param panel the panel
	 * @param gbc the gbc
	 */
	public void setWindowArea(JPanel panel, GridBagConstraints gbc) {
		JPanel window = new JPanel(new BorderLayout(5,5));
		window.setSize(200, 200);
		JLabel label = new JLabel("Message Window:");
		area = new JTextArea("Game has not yet started", 5, 20);
		area.setEditable(true);
		window.add(label, BorderLayout.NORTH);
		window.add(area);
		panel.add(window, gbc);
	}
	
	/**
	 * Populate label text field.
	 *
	 * @param panel the panel
	 * @param gbc the gbc
	 * @param labelName the label name
	 * @param textName the text name
	 * @param width the width
	 * @param length the length
	 * @param textField the text field
	 */
	public void populateLabelTextField(JPanel panel, GridBagConstraints gbc,
		String labelName, String textName, int width, int length, JTextField textField) {
		JPanel p = new JPanel();
		p.setSize(100,100);
		JLabel label = new JLabel(labelName);
		textField.setText(textName);
		textField.setPreferredSize(new Dimension(width, length));
		p.add(label);
		p.add(textField);
		panel.add(p, gbc);
		
	}

	    /**
    	 * Gets the players name.
    	 *
    	 * @param message the message
    	 * @return the players name
    	 */
    	public String getPlayersName(String message) {
	        String name = JOptionPane.showInputDialog(message);
	        return name;
	    }
	    
    	/**
    	 * Creates the action listener.
    	 *
    	 * @param listener the listener
    	 */
    	public void createActionListener(ActionListener listener) {
	        for(int i = 0; i < jButtons.length; i++) {
	            for(int j = 0; j < jButtons.length; j++ ) {
	                jButtons[i][j].addActionListener(listener);
	            }
	        }
	    }
	    
	    /**
    	 * Adds the mark on view.
    	 *
    	 * @param theButton the the button
    	 * @param theMark the the mark
    	 */
    	public void addMarkOnView(JButton theButton, char theMark) {
	        for(int i = 0; i < jButtons.length; i++) {
	            for(int j = 0; j < jButtons.length; j++ ) {
	                if(theButton == jButtons[i][j]) {
	                	jButtons[i][j].setText(String.valueOf(theMark));
	                }
	            }
	        }
	    }
	    
	    /**
    	 * Gets the button position.
    	 *
    	 * @param theButton the the button
    	 * @param mark the mark
    	 * @return the button position
    	 */
    	public int[] getButtonPosition(JButton theButton, char mark) {
	    	for(int i = 0; i < jButtons.length; i++) {
	            for(int j = 0; j < jButtons.length; j++ ) {
	            	if(theButton == jButtons[i][j])
	            		return new int[] {i ,j};
	            }
	    }
	    	return null;
	    }
	    
	    /**
    	 * Creates the message.
    	 *
    	 * @param message the message
    	 */
    	public void createMessage(String message) {
	    	JOptionPane.showMessageDialog(this, message);
	    	dispose();
	    }

	/**
	 * Gets the area.
	 *
	 * @return the area
	 */
	public JTextArea getArea() {
		return area;
	}

	/**
	 * Sets the area.
	 *
	 * @param area the new area
	 */
	public void setArea(String area) {
		this.area.setText(area);
	}

	/**
	 * Gets the player text.
	 *
	 * @return the player text
	 */
	public JTextField getPlayerText() {
		return playerText;
	}

	/**
	 * Sets the player text.
	 *
	 * @param playerText the new player text
	 */
	public void setPlayerText(String playerText) {
		this.playerText.setText(playerText);
	}

	/**
	 * Gets the player name text.
	 *
	 * @return the player name text
	 */
	public JTextField getPlayerNameText() {
		return playerNameText;
	}

	/**
	 * Sets the player name text.
	 *
	 * @param playerNameText the new player name text
	 */
	public void setPlayerNameText(String playerNameText) {
		this.playerNameText.setText(playerNameText);
	}

	/**
	 * Gets the j buttons.
	 *
	 * @return the j buttons
	 */
	public JButton[][] getjButtons() {
		return jButtons;
	}

	/**
	 * Sets the j buttons.
	 *
	 * @param jButtons the new j buttons
	 */
	public void setjButtons(JButton[][] jButtons) {
		this.jButtons = jButtons;
	}
	

		}