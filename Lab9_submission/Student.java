 /**
 * The Class Student.This is the "node" , i.e class Student is used to
 *  create a Linkedlist , such that each student object is a node in linkedList
 */
public class Student {
	
	/** The id. */
	private int id;
	
	/** The name. */
	private String name;
	
	/** The next. */
	private Student next;
	
	
	/**
	 * Instantiates a new student.
	 *
	 * @param name the name
	 * @param id the id
	 */
	public Student(String name, int id) {
		this.name = name;
		this.id =id;
		setNext(null);
		// Good practice to set the next pointer to null when creating
		// a new node
	
	}


	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
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
	 * Gets the next.
	 *
	 * @return the next
	 */
	public Student getNext() {
		return next;
	}


	/**
	 * Sets the next.
	 *
	 * @param next the new next
	 */
	public void setNext(Student next) {
		this.next = next;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Name: " + getName() + " ID Number: " + getId();
	}

}
