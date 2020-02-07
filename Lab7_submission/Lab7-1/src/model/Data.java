package model;

/**
 * Represents data within a node.
 * @author Asif Bux
 * @version 1.0
 * @since November 5, 2019
 */
public class Data {
	
	/** id is the student's id faculty is the student's faculty. */
	String  id,faculty, major, year;
	
	/**
	 * Instantiates a new data.
	 *
	 * @param i the i
	 * @param f the f
	 * @param m the m
	 * @param y the y
	 */
	public Data( String i, String f, String m, String y)
	{
		id = i;
		faculty = f;
		major = m;
		year = y;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString()
	{
		return ("id : " + id + " faculty: " + faculty + " major: " + major + 
						" year: " + year);
	}	
}
