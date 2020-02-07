import java.util.Scanner;

/**
 * Provide access data members and methods to create Inventory management system
 * in a Java application.
 * This class depends on the fileManager class to provide the necessary Arraylist 
 * so that other classes that depend on this class can be properly instantiated.
 * @author Asif Bux
 * @version 1.0
 * @since October 14, 2019
 */
public class InventoryApp {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String [] args) {

	    InventoryApp myapp = new InventoryApp();	
		FileManager fm1 = new FileManager();
		Inventory i1 = new Inventory(fm1.getToolList());
		OrderRep o1 = new OrderRep();
		SupList sl1 = new SupList(fm1.getSupplierList());
		Shop s1 = new Shop(sl1,i1, o1);
		myapp.theapp(s1);

		}
		
		/**
		 * The app method that displays user interface and takes user input .
		 *
		 * @param s1 the the shop object 
		 */
		public void theapp(Shop s1) {
			
			System.out.println("Welcome to Schulich Inventory Management System! \n"
					+ "");
			while (true)
			{
				System.out.println( "\n" +
						"Please make a selection using the keyboard from the following list of options: \n"
						+ "Press 1: Print the list of tools currently in the Shop. \n"
						+ "Press 2: Search for tool by Tool Name.  \n"
						+ "Press 3: Search for tool by Tool ID.  \n"
						+ "Press 4: Check Item Quantity. \n"
						+ "Press 5: Decrease Item Quantity. \n"
						+ "Press 6: To generate Order. \n"
						+ "Press 7: Quit Schulich Inventory Management System. \n");
				
			   Scanner keyboard =new Scanner(System.in);
			   int selection = keyboard.nextInt();
			   
			   switch(selection){
		        	case 1:
			           System.out.println("Following is the List of tools currently in our Inventory System");
			           System.out.println(s1);
			           break;
			        case 2:
			           System.out.println("Please enter the name of the tool.");
			           keyboard.nextLine();
			           String toolName = keyboard.nextLine();
			           if(s1.searchToolByName(toolName)) {
			           }
			           else
			        	   System.out.printf("%s is not found in the Item List \n", toolName);
			           break;

			        case 3:
			           System.out.println("Please enter the ID of the tool.");
			           int toolId = keyboard.nextInt();
			           if(s1.searchToolById(toolId)) {
			           }
			           else
			        	   System.out.printf("A tool with ID# %d is not on the Item List", toolId);
			           break;
			        case 4:
			           System.out.println("Please enter the ID of the tool to check Quantity");
			           int toolId2 = keyboard.nextInt();
			           if(s1.checkQuantity(toolId2)!= null) {
			        	   System.out.printf("A tool with Id %d is on the Item List with a Stock of %d", toolId2, s1.checkQuantity(toolId2));
			           }
			           else
			        	   System.out.printf("A tool with Id %d is not on the Item List", toolId2);
			           break;
			        case 5:
				           System.out.println("Please enter the ID of the tool that you want to decrease the quantity for");
				           int toolId3 = keyboard.nextInt();
				           if(s1.searchToolById(toolId3)) {
				        	   System.out.println("Please enter the quantity to decrease");
					           int toolQuan = keyboard.nextInt();
					           if (s1.decreaseQuantity(toolId3, toolQuan)) {
					        	   System.out.printf("The tool Quantity has been updated to %d!", s1.checkQuantity(toolId3));
					           }
					           else
					        	   System.out.println("The tool Quantity has not been updated!");
				           }
				           else
				        	   System.out.printf("A tool with Id %d is not on the Item List", toolId3);
				           break;
			        case 6:
			        	s1.getTheOrderRep().displayLatestOrder();
			        	break;

			        case 7:
				           System.out.println("Thank you for using Schulich Inventory Management System. See you again!");
				           System.exit(0);
				           break;
			        	
			        default: 
			        	System.out.println("Invalid selection, please select between 1 to 6!");
	                   break;
			      }
			 }
		}
	}