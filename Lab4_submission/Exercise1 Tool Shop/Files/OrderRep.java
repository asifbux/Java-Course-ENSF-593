import java.util.ArrayList;

/**
 * The Class OrderRep which provides access to data members and methods to use order objects
 * in a way where only one order is being generated per day for all the orderlines in that day.
 * @author Asif Bux
 * @version 1.0
 * @since October 14, 2019
 */
public class OrderRep {
	
	/** The order list containing all the orders. */
	private ArrayList <Order> orderList = new ArrayList<Order>();
	
	/**
	 * Instantiates a new Order Repository containing orders.
	 *
	 * @param theorder the theorder
	 */
	public OrderRep(Order theorder) {
		orderList.add(theorder);
	}
	
	/**
	 * Instantiates a default new order Repository.
	 */
	public OrderRep() {}

	/**
	 * Check's existing order if the new incoming order has the same date 
	 * as any order that may exist already in the Order Repository. If an 
	 * order does match, then this method copies over the orderlines of that order 
	 * to the existing of order with the same date.
	 *
	 * @param theorder the theorder
	 */
	public void checkOrder(Order theorder) {
		if(orderList.size() == 0) {
			orderList.add(theorder);
		}
		else if (orderList != null && orderList.size() > 0) {
			for (Order o: orderList) {
				if(o != null && o.getDate().equals(theorder.getDate())) {
					boolean flag = true;
					for(Orderline ol: o.getOrderlineList()) {
						if(ol.getOlNme().equals(theorder.getTheorderline().getOlNme())) {
								ol.setAmountOrdered(ol.getAmountOrdered() + theorder.getTheorderline().getAmountOrdered()); 
								flag = false;
						}
						}
					if(flag)
						o.setOrderlineList(theorder.getTheorderline());
				}
				else
					orderList.add(theorder);
				}
		}
	}
	
	/**
	 * Display latest order in the Order Repository object.
	 */
	public void displayLatestOrder()
	{
		if(orderList.size() == 0) {
			System.out.println("There is no order yet");
		}
		else 
			for (Order o: orderList) {
				if(o == null) {
					System.out.println("There is no order yet");
					break;
				}
				System.out.println(o);
				o.createOrder();
				System.out.println("Order.txt has been generated!");
			}			
	}	
}

	
