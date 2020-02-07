package view;

import javax.swing.*;

import model.BinSearchTree;
import controller.StudentRecordController;

import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The Class Frame.
 * @author Asif Bux
 * @version 1.0
 * @since November 5, 2019
 */
public class Frame extends JFrame {
	
	/** The area. */
	private JTextArea area;
	
	/** The tree button. */
	private Button insertButton, findButton, browseButton, treeButton;
	
	/**
	 * Instantiates a new frame.
	 */
	public Frame() {
		JPanel panel = setMainFrame();
		setSize(600,300);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	/**
	 * Sets the main frame.
	 *
	 * @return the j panel
	 */
	public JPanel setMainFrame() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JLabel label = new JLabel("An Application To Maintain Student Records", SwingConstants.CENTER);
		panel.add(label, BorderLayout.NORTH);
		area = new JTextArea(80, 0);
		panel.add(area, BorderLayout.CENTER);
		JScrollPane scroll = new JScrollPane(area);
		panel.add(scroll);
		insertButton = new Button("Insert");
		findButton = new Button("Find");
		browseButton = new Button("Browse");
		treeButton = new Button("Create Tree from File");
		
		JPanel bottomPanel  = new JPanel(new FlowLayout());
		bottomPanel.add(insertButton);
		bottomPanel.add(findButton);
		bottomPanel.add(browseButton);
		bottomPanel.add(treeButton);
		
		panel.add(bottomPanel, BorderLayout.SOUTH);
		return panel;
	}
	
	
	/**
	 * Find window.
	 *
	 * @return the string
	 */
	public String findWindow() {
		  String id = JOptionPane.showInputDialog("Please enter the student's id");
		  return id;
		  
	}
	
	/**
	 * Find result window.
	 *
	 * @param message the message
	 */
	public void findResultWindow(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	/**
	 * Input window.
	 *
	 * @return the string
	 */
	public String inputWindow() {
		    String name=JOptionPane.showInputDialog("Enter the file name:"); 
		    return name;
	}
	
	/**
	 * Error window.
	 */
	public void errorWindow() {
		JOptionPane.showMessageDialog(this, "Create the tree list!");
	}
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String [] args ) {
		Frame myframe = new Frame();
		BinSearchTree binSearchTree = new BinSearchTree();
		new StudentRecordController(binSearchTree, myframe);
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
	public void setArea(JTextArea area) {
		this.area = area;
	}

	/**
	 * Gets the insert button.
	 *
	 * @return the insert button
	 */
	public Button getInsertButton() {
		return insertButton;
	}

	/**
	 * Sets the insert button.
	 *
	 * @param insertButton the new insert button
	 */
	public void setInsertButton(Button insertButton) {
		this.insertButton = insertButton;
	}

	/**
	 * Gets the find button.
	 *
	 * @return the find button
	 */
	public Button getFindButton() {
		return findButton;
	}

	/**
	 * Sets the find button.
	 *
	 * @param findButton the new find button
	 */
	public void setFindButton(Button findButton) {
		this.findButton = findButton;
	}

	/**
	 * Gets the browse button.
	 *
	 * @return the browse button
	 */
	public Button getBrowseButton() {
		return browseButton;
	}

	/**
	 * Sets the browse button.
	 *
	 * @param browseButton the new browse button
	 */
	public void setBrowseButton(Button browseButton) {
		this.browseButton = browseButton;
	}

	/**
	 * Gets the tree button.
	 *
	 * @return the tree button
	 */
	public Button getTreeButton() {
		return treeButton;
	}

	/**
	 * Sets the tree button.
	 *
	 * @param treeButton the new tree button
	 */
	public void setTreeButton(Button treeButton) {
		this.treeButton = treeButton;
	}


}
