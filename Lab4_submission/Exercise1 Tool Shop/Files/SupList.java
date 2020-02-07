import java.util.ArrayList;

/**
 * The helper Class SupList which provides access to data members and methods to list of supplier objects 
 * @author Asif Bux
 * @version 1.0
 * @since October 14, 2019
 */
public class SupList {
	
	/** The list of supplier objects. */
	private ArrayList <Supplier> supplierList;
	
	/**
	 * Instantiates a new supplier list.
	 *
	 * @param supplierList the supplier list
	 */
	public SupList(ArrayList <Supplier> supplierList){
		this.supplierList = supplierList;
		
	}
	
	/**
	 * To find supplier by ID.
	 *
	 * @param supId the sup id
	 * @return the supplier
	 */
	public Supplier findSup(int supId) {
		Supplier mysup = new Supplier();
		for (Supplier s: supplierList) {
			if(s.getSupId() == supId) {
				mysup = s;
				}
			}
		return mysup;
		}
}
