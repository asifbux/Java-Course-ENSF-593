package view;

import javax.swing.*;
import model.BinSearchTree;
import controller.StudentRecordController;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The Class InsertFrame.
 * @author Asif Bux
 * @version 1.0
 * @since November 5, 2019
 */
public class InsertFrame extends JFrame {
	
    /** The insert. */
    JButton insert;
	
	/** The cancel. */
	JButton cancel;
    
    /** The id. */
    JTextField id;
    
    /** The year. */
    JTextField faculty, major, year;
    
    /**
     * Instantiates a new insert frame.
     */
    public InsertFrame() {
        JPanel panel = createTextPanel();
        JPanel buttonPanel = createButtonPanel();
        JLabel title = new JLabel("Insert a New Node");
        title.setHorizontalAlignment(JLabel.CENTER);
        add("North", title);
        add("Center", panel);
        add("South", buttonPanel);
        setVisible(true);
        setSize(700, 150);
    }
    
    /**
     * Creates the button panel.
     *
     * @return the j panel
     */
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        insert = new JButton("Insert");
        cancel = new JButton("Return to Main Window");
        buttonPanel.add(insert);
        buttonPanel.add(cancel);
        return buttonPanel;
    }
    
    /**
     * Creates the text panel.
     *
     * @return the j panel
     */
    private JPanel createTextPanel() {
        JPanel panel = new JPanel();
        id = new JTextField(20);
        faculty = new JTextField(10);
        major = new JTextField(20);
        year = new JTextField(10);
        panel.add(new JLabel("Enter the Student ID"));
        panel.add(id);
        panel.add(new JLabel("Enter Faculty"));
        panel.add(faculty);
        panel.add(new JLabel("Enter Student's Major"));
        panel.add(major);
        panel.add(new JLabel("Enter Year"));
        panel.add(year);
        return panel;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id.getText();
    }
    
    /**
     * Gets the faculty.
     *
     * @return the faculty
     */
    public String getFaculty() {
        return faculty.getText();
    }
    
    /**
     * Gets the major.
     *
     * @return the major
     */
    public String getMajor() {
        return major.getText();
    }
    
    /**
     * Gets the year.
     *
     * @return the year
     */
    public String getYear() {
        return year.getText();
    }
    
    /**
     * Gets the insert.
     *
     * @return the insert
     */
    public JButton getInsert() {
		return insert;
	}
	
	/**
	 * Gets the cancel.
	 *
	 * @return the cancel
	 */
	public JButton getCancel() {
		return cancel;
	}

}

