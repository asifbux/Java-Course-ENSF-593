package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import model.*;
import view.Frame;
import view.InsertFrame;

/**
 * The Class StudentRecordController.
 * @author Asif Bux
 * @version 1.0
 * @since November 5, 2019
 */
public class StudentRecordController {
	
	/** The bin search tree. */
	private BinSearchTree binSearchTree;
	
	/** The frame. */
	private Frame frame;
	
	/** The insert frame. */
	private InsertFrame insertFrame;
	
	/**
	 * Instantiates a new student record controller.
	 *
	 * @param binSearchTree the bin search tree
	 * @param frame the frame
	 */
	public StudentRecordController (BinSearchTree binSearchTree, Frame frame) {
		
		this.binSearchTree = binSearchTree;
		this.frame = frame;
		attachListeners();
	}
	
	/**
	 * Attach listeners.
	 */
	private void attachListeners() {
		frame.getTreeButton().addActionListener(new ActionListener() {
			
			/**
			 * Action performed.
			 *
			 * @param e the e
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				String fileName = frame.inputWindow();
				if(fileName != null) {
					FileManager fm = new FileManager();
					binSearchTree = fm.readFile(fileName);
				}
			}
	});
		frame.getFindButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = frame.findWindow();
				Node data = binSearchTree.find(binSearchTree.getRoot(), id);
	            frame.findResultWindow(data.toString());
			}
		});
		frame.getBrowseButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					browse();
			}
		});
		frame.getInsertButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    insertFrame = new InsertFrame();
			    insertListeners();
				
			}
		});
	}
	
	/**
	 * Browse.
	 */
	public void browse() {
		
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		Node root = binSearchTree.getRoot();
        try {
        	if (root != null) {
            binSearchTree.print_tree(root, printWriter);
            frame.getArea().setText(stringWriter.toString());}
        	else
        		frame.errorWindow();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
	}
	
	/**
	 * Insert listeners.
	 */
	private void insertListeners() {
		insertFrame.getInsert().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			  if(insertFrame.getId() != null && insertFrame.getYear() != null && insertFrame.getFaculty() != null && insertFrame.getMajor() !=null)
		         {
		           binSearchTree.insert(insertFrame.getId(), insertFrame.getFaculty(), insertFrame.getMajor(), insertFrame.getYear());
		        }
			}
		});
		insertFrame.getCancel().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertFrame.dispose();
			}
		});
}
}
