/**
 * The Class Shop which provides access to data members and methods to use objects of 
 * type supplierList, Inventory and Order Repository.
 * The objects of class Shop call the inventory when modification needs to be made to the tool objects. 
 * As well passing new orders to the Order Repository for processing. 
 * @author Asif Bux
 * @version 1.0
 * @since October 14, 2019
 */
public class Shop {
	
	/** The inventory of the Shop object. */
	private Inventory theInventory;
	
	/** The Order Repository of the Shop object. */
	private OrderRep theRepo;
	
	/** The supplier List containing all the supplier objects. */
	private SupList theSupList;
	
	/**
	 * Instantiates a new shop by assigning the supList, Inventory and OrderRep.
	 *
	 * @param supList the sup list
	 * @param a1 the a 1
	 * @param o1 the o 1
	 */
	public Shop(SupList supList, Inventory a1, OrderRep o1) {
		this.theSupList = supList;
		this.theInventory = a1;
		this.theRepo = o1;
	}
	
	/**
	 * Search tool objects by their Name and this method then calls the Inventory object.
	 *
	 * @param toolName the tool name
	 * @return true, if successful
	 */
	public boolean searchToolByName(String toolName) {
		if (theInventory.searchToolName(toolName)) 
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Search tool by the tool's ID which calls the method of the Inventory object.
	 *
	 * @param toolId the tool id
	 * @return true, if successful
	 */
	public boolean searchToolById(int toolId) {
		if (theInventory.searchToolId(toolId)) 
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Check's the quantity of the tool by calling the Inventory object.
	 *
	 * @param toolId the tool id
	 * @return the integer
	 */
	public Integer checkQuantity(int toolId) {

		if (theInventory.checkStock(toolId) != null) 
		{
			return theInventory.checkStock(toolId);
		}
		System.err.println("Item Quantity does not exist!");
		return null;
	}
	
	/**
	 * Decrease the quantity of the tool by call the inventory object.
	 *
	 * @param toolId the tool id
	 * @param toolQuan the tool quan
	 * @return true, if successful
	 */
	public boolean decreaseQuantity(int toolId, int toolQuan) {
		
		if(theInventory.searchToolId(toolId))
		{
		if(theInventory.getToolById(toolId).getQuantity() < toolQuan) {
			System.out.println("Tool Avaliable is less than tool quantity to decrease!");
		return false;
		}
		else if(theInventory.decrementTool(toolId, toolQuan)) { 
			if (theInventory.getToolById(toolId).getQuantity() < 40) {
				theRepo.checkOrder(theInventory.decrementToolgetOrder(toolId, toolQuan));
			return true;
		}
			return true;
		}
		}
				return false;
		}
	
	/**
	 * To string methods which calls the Inventory object.
	 *
	 * @return the string
	 */
	public String toString() {
		String s = "";
		s += theInventory;
		return s;
	}


	/**
	 * Gets the the Order Repository object.
	 *
	 * @return the the order rep
	 */
	public OrderRep getTheOrderRep() {
		return theRepo;
	}


	/**
	 * Sets the Order Repository object.
	 *
	 * @param theOrderRep the OrderRep
	 */
	public void setTheOrderRep(OrderRep theOrderRep) {
		this.theRepo = theOrderRep;
	}


	/**
	 * Gets the the list containing all the supplier.
	 *
	 * @return the the sup list
	 */
	public SupList getTheSupList() {
		return theSupList;
	}


	/**
	 * Sets the list of suppliers.
	 *
	 * @param theSupList the suplist
	 */
	public void setTheSupList(SupList theSupList) {
		this.theSupList = theSupList;
	}


		
}

