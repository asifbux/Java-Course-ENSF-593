
/**
 * The Class Orderline which provides access to data members and methods to generate 
 * orderline. 
 * This class is uses the objects of class tool to get necessary information 
 * required by the orderline objects.
 * @author Asif Bux
 * @version 1.0
 * @since October 14, 2019
 */
public class Orderline {
	
	/** thetool an object of tool. */
	private Tool thetool;
	
	/** The amount ordered for this orderline object. */
	private int amountOrdered;
	
	/**
	 * Instantiates a new orderline object.
	 *
	 * @param t the tool object
	 */
	public Orderline(Tool t) {
		this.thetool = t;
		this.setAmountOrdered(thetool.getQuantityOrder());
	}
	
	
	/**
	 * Gets the item description for this order object from the tool object.
	 *
	 * @return the orderline Description
	 */
	public String getOlNme() {
		
		return thetool.getToolName();
	}
	
	/**
	 * Gets the amount to be ordered for this order object from the tool object.
	 *
	 * @return the order Amount
	 */
	public int getOlAmount() {
		
		return thetool.getQuantityOrder();
		
	}
	
	/**
	 * Gets the supplier information for this order object from the tool object.
	 *
	 * @return the supplier's Name
	 */
	public String getOlSup() {
		return thetool.getSupInfo().getSupName();
	}

	/**
	 * Gets the amount ordered for the orderline object.
	 *
	 * @return the amount ordered
	 */
	public int getAmountOrdered() {
		return amountOrdered;
	}


	/** 
	 * Sets the amount ordered for the orderline object.
	 *
	 * @param amountOrdered the new amount ordered
	 */
	public void setAmountOrdered(int amountOrdered) {
		this.amountOrdered = amountOrdered;
	}
	
	/**
	 * To string method which prints out all the item required for an instance of oderline object.
	 *
	 * @return the string
	 */
	public String toString() {
		String s = "";
		s = "Item Description: " + thetool.getToolName() + "\n" + "Amount Ordered: " + thetool.getQuantityOrder() + "\n" + "Supplier: " + thetool.getSupInfo().getSupName();
		return s;
	}

}
