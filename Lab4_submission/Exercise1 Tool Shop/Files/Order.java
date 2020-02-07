import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Random; 

/**
 * The Class Order which provides access to data members and methods to generate 
 * order and hold the orderlines for the order object.
 * @author Asif Bux
 * @version 1.0
 * @since October 14, 2019
 */
public class Order {
	
	/** The order ID of the order object. */
	private int orderID;
	
	/** The date of the order object. */
	private String date;
	
	/** The theorderline an instance of orderline in the order object. */
	private Orderline theorderline;
	
	/** The order file which is the output file once the order for the day is complete. */
	private String orderFile = "order.txt";
	
	/** The output stream which is the outout Stream file. */
	private PrintWriter outputStream;
	
	/** The orderline list which contains all the orderlines for this order object. */
	private ArrayList <Orderline> orderlineList = new ArrayList<Orderline>() ;
	
	/**
	 * Instantiates a new order with one orderline object and adds that to arraylist of orderlines.
	 * It also generates a random Order ID as well as captures today's calendar date.
	 *
	 * @param theorderline the theorderline type of orderline object
	 */
	public Order (Orderline theorderline) {
		this.theorderline = theorderline;
		this.orderlineList.add(theorderline);
		generateDate();
		generateOrderID();
	}

	
	/**
	 * Auto generate's todays date.
	 */
	public void generateDate() {
		SimpleDateFormat df = new SimpleDateFormat("MM-dd-YYYY");
		this.date = df.format(new Date());
	}
	
	/**
	 * Generates a random order ID.
	 */
	public void generateOrderID() {
		Random rand = new Random();
		int rand_int = rand.nextInt(10000) + 5676;
		this.orderID = rand_int;
	}
	
	/**
	 * Creates the ouput order file.
	 */
	public void createOrder() {
		try
		{
		outputStream = new PrintWriter(orderFile);
		outputStream.println(toString());
		outputStream.close();
		} 
		catch(FileNotFoundException e) 
		{
			System.out.println("Error openning the file" + orderFile);
			System.exit(0);
		}
	}
	
	/**
	 * Header of the output file which uses this method to generate header.
	 *
	 * @return the string
	 */
	public String orderHeader() {
		String asterisks = "****************************************************";
		return asterisks;
	}
	
	/**
	 * Gets the order ID of this order object.
	 *
	 * @return the order ID
	 */
	public int getOrderID() {
		return orderID;
	}

	/**
	 * Gets the date of this oder object.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Gets the orderline object variable for this order object.
	 *
	 * @return the theorderline
	 */
	public Orderline getTheorderline() {
		return theorderline;
	}
	
	/**
	 * Sets the orderline variable for this order object.
	 *
	 * @param theorderline the new theorderline
	 */
	public void setTheorderline(Orderline theorderline) {
		this.theorderline = theorderline;
	}
	
	/**
	 * Gets the list containing all the orderlines.
	 *
	 * @return the orderline list
	 */
	public ArrayList <Orderline> getOrderlineList() {
		return orderlineList;
	}
	
	/**
	 * Appends a new orderline variable to the list of orderlines.
	 *
	 * @param orderline the new orderline list
	 */
	public void setOrderlineList(Orderline orderline) {
		this.orderlineList.add(orderline);
	}

	/**
	 * To string method to print all the orderlines in this order.
	 *
	 * @return the string
	 */
	
	public String toString() {
		
		String s = orderHeader() + "\n" + "ORDER ID:       " + orderID + "\n" + "Date Ordered:" + date + "\n\n";
		for(Orderline ol: orderlineList) {
			s += ol + "\n\n\n";
		}
		s += orderHeader();
		return s;
	}
}
