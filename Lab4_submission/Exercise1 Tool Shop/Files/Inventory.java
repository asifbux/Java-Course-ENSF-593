import java.util.ArrayList;

/**
 * Provide access data members and methods to create inventory class.
 * The overall purpose of this class exercise is to illustrate how inventory uses tool object
 * to manage supply and depends on the Orderline and Order classes to generate order when the 
 * minimum Quantity goes below 40.
 * @author Asif Bux
 * @version 1.0
 * @since October 14, 2019
 */
public class Inventory {
	
	/** The toolList array contains all the tool objects. */
	private ArrayList <Tool> toolList;

	/**
	 * Instantiates a new inventory object.
	 *
	 * @param toollist the array of tool objects.
	 */
	public Inventory(ArrayList <Tool> toollist) {
		this.toolList = toollist;
	}
	
	/**
	 * Search tool by Name.
	 *
	 * @param toolName the name of the tool object
	 * @return true, if method successfully finds an tool object with the passed name.
	 */
	public boolean searchToolName(String toolName) {
		for (Tool t: toolList) {
			if(t.getToolName().equalsIgnoreCase(toolName)) {
				System.out.println(t);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Search toolList by tool ID
	 *
	 * @param toolId the tool id of the tool object
	 * @return true, if method successfully finds an tool object.
	 */
	public boolean searchToolId(int toolId) {
		for (Tool t: toolList) {
			if(t.getToolId() == toolId) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets the tool by ID.
	 *
	 * @param toolId the tool ID of the tool object
	 * @return the tool by id
	 */
	public Tool getToolById(int toolId) {
		for (Tool t: toolList) {
			if(t.getToolId() == toolId) {
				return t;
			}
		}
		return null;
	}
	
	/**
	 * Increment tool quantity.
	 *
	 * @param toolId the tool id of the tool object
	 * @param quantity the quantity to be incremented for this tool object
	 */
	public void incrementTool(int toolId, int quantity) {
		for (Tool t: toolList) {
			if(t.getToolId() == toolId) {
				t.setQuantity(t.getQuantity() + quantity);
			}
		}	
	}
	
	/**
	 * Decrement tool quantity.
	 *
	 * @param toolId the tool id of the tool object
	 * @param quantity the quantity of the tool to be decremented
	 * @return true, if method successfully reduces the quantity
	 */
	public boolean decrementTool(int toolId, int quantity) {
		for (Tool t: toolList) {
			if(t.getToolId() == toolId) {
				if(t.getQuantity() < quantity)
					return false;
				else
					t.reduceQuantity(quantity);
				return true;
				}
		}
		return false;
	}
	
	/**
	 * Decrement's the tool and gets the order.
	 *
	 * @param toolId the tool id of the tool object
	 * @param quantity the quantity to be decremented
	 * @return the order
	 */
	public Order decrementToolgetOrder(int toolId, int quantity) {
		Tool t = getToolById(toolId); 
		if (t.getQuantity() < 40) {
			t.setQuantityOrder(50-t.getQuantity());
			return sendToShop(t);}
		return null;
		}
	
	
	/**
	 * Check's stock of the tool.
	 *
	 * @param toolId the tool ID of the tool object.
	 * @return the integer value of the Stock
	 */
	public Integer checkStock(int toolId) {
		int mystock =0;
		for (Tool t: toolList) {
		if(t.getToolId() == toolId) {
			mystock = t.getQuantity();
			return  mystock;
			}
		}
		return null;
	}
	
	/**
	 * Generates the orderline.
	 *
	 * @param t the tool object
	 * @return the orderline
	 */
	public Orderline generateOrderline(Tool t) {
		int amountOrdered = 50 - t.getQuantity();
		Orderline myOl = new Orderline(t);
		t.setQuantityOrder(amountOrdered);
		return myOl;
	}
	
	/**
	 * Generate auto order.
	 *
	 * @param myOl the oderline
	 * @return the order which contains the orderline
	 */
	public Order generateAutoOrder(Orderline myOl) {
		Order myOrder = new Order(myOl);
		return myOrder;
	}
	
	/**
	 * Shop will call this method if there are any order's to be picked 
	 * and needs to be sent to the Order Repository.
	 *
	 * @param t the tool object
	 * @return the order
	 */
	public Order sendToShop(Tool t) {
		return generateAutoOrder(generateOrderline(t));
		
	}
	
	/**
	 * To string which prints out all the tool object in the Inventory
	 *
	 * @return the string
	 */
	public String toString() {
		String s = "";
		int listSize = toolList.size();
		for (int i = 0; i < listSize; i++) {
			s += toolList.get(i) + "\n";
		}
		return s;
	}
	
}
