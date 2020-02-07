/**
 * The Class Supplier which provides access to data members and methods to supplier objects.
 * @author Asif Bux
 * @version 1.0
 * @since October 14, 2019
 */
public class Supplier {
	
	/** The supplier ID. */
	private int supId;
	
	/** The supplier name. */
	private String supName;
	
	/** The supplier address. */
	private String supAddress;
	
	/** The supplier contact. */
	private String supContact;
	
	/**
	 * Instantiates a new supplier.
	 *
	 * @param supId the supplier id
	 * @param supName the supplier name
	 * @param supAddress the supplier address
	 * @param supContact the supplier contact
	 */
	public Supplier(int supId, String supName, String supAddress, String supContact) {
		this.supId = supId;
		this.supName = supName;
		this.supAddress = supAddress;
		this.supContact = supContact;
		
	}
	
	/**
	 * Instantiates a new supplier object.
	 */
	public Supplier() {
		
	}
	
	/**
	 * Gets the supplier ID.
	 *
	 * @return the supplier ID
	 */
	public int getSupId() {
		return supId;
	}
	
	/**
	 * Sets the supplier ID.
	 *
	 * @param supId the new supplier ID.
	 */
	public void setSupId(int supId) {
		this.supId = supId;
	}
	
	/**
	 * Gets the supplier name.
	 *
	 * @return the supplier name
	 */
	public String getSupName() {
		return supName;
	}
	
	/**
	 * Sets the supplier name.
	 *
	 * @param supName the new supplier name
	 */
	public void setSupName(String supName) {
		this.supName = supName;
	}
	
	/**
	 * Gets the supplier address.
	 *
	 * @return the supplier address
	 */
	public String getSupAddress() {
		return supAddress;
	}
	
	/**
	 * Sets the supplier address.
	 *
	 * @param supAddress the new supplier address
	 */
	public void setSupAddress(String supAddress) {
		this.supAddress = supAddress;
	}
	
	/**
	 * Gets the supplier contact.
	 *
	 * @return the supplier contact
	 */
	public String getSupContact() {
		return supContact;
	}
	
	/**
	 * Sets the supplier contact.
	 *
	 * @param supContact the new supplier contact
	 */
	public void setSupContact(String supContact) {
		this.supContact = supContact;
	}
	
	/**
	 * To string to print out supplier object.
	 *
	 * @return the string
	 */
	public String toString() {
		String s =String.format("Supplier ID; %d Supplier Name: %s; Supplier Address: %s; Supplier Contact: %s", supId, supName, supAddress, supContact);	
	    return s;	
	}

}
