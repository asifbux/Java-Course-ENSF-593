package model;
// TODO: Auto-generated Javadoc

/**
 * A node with data and two references to the next-left and next-right node.
 *
 * @author Asif Bux
 * @version 1.0
 * @since November 5, 2019
 */
public class Node {

	/** The data. */
	Data data;
	
	/** The right. */
	Node left, right;
	
	/**
	 * Instantiates a new node.
	 *
	 * @param id student id
	 * @param faculty faculty code
	 * @param major student's major
	 * @param year student's year of study
	 */
	public Node(String id, String faculty, String major, String year) {
		// creating a data item
		data = new Data(id, faculty, major, year);
		left = null;
        right = null;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return data.toString();
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Data getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(Data data) {
		this.data = data;
	}

	/**
	 * Gets the left.
	 *
	 * @return the left
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * Sets the left.
	 *
	 * @param left the new left
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * Gets the right.
	 *
	 * @return the right
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * Sets the right.
	 *
	 * @param right the new right
	 */
	public void setRight(Node right) {
		this.right = right;
	}
}

