import java.util.Scanner;

// Front End
public class AirlineReservationApp {
	
	public static void main (String []args) {
		Airplane a1 = new Airplane (4);
		/// Test passenger on the flight 
		app(a1);

	}
	
	public static void app(Airplane a1) {
		
		System.out.println("Welcome to Schulich Flight Reservation System! \n"
				+ "We are happy and excited to have you on board :) \n"
				+ "This flight is Boeing 737 Max 8 with 4 Rows & 5 Seats. ");
		while (true)
		{
			System.out.println( "\n" +
					"Please make a selection using the keyboard from the following list of options: \n"
					+ "Press 1: To add new Passenger. \n"
					+ "Press 2: To remove an existing Passenger. \n"
					+ "Press 3: To search a Passenger. \n"
					+ "Press 4: To view the SeatMap of this flight. \n"
					+ "Press 5: Print list of Passenger on this flight. \n"
					+ "Press 6: To exit from Schulich Flight Reservation System. \n");
			
		   Scanner keyboard =new Scanner(System.in);
		   int selection = keyboard.nextInt();
		   
		   switch(selection){
		        case 1:
		           System.out.println("Please enter the name of the passenger");
		           String passName = keyboard.next();
		           System.out.println("Please select a row between 0 to 3");
		           int passRow = keyboard.nextInt();
		           System.out.println("Please select a seat between A to E");
		           String seat = keyboard.next();
		           char passSeat = seat.charAt(0);
		           if(a1.addPassenger(passName, passRow, passSeat)) {
		        	   System.out.println("This Passenger has been added to the flight!");
		           }
		           else
		        	   System.out.println("Passenger could not be added: the seat is "
		        	   		+ "already booked or invalid inputs.");
		           break;

		        case 2:
		           System.out.println("Please enter the name of the passenger to be removed");
		           String passName1 = keyboard.next();
		           if(a1.removePassenger(passName1)) {
		        	   System.out.println("The passenger has been removed from this flight!");
		           }
		           else
		        	   System.out.println("Passenger is not on this flight!");
		           break;

		        case 3:
		           System.out.println("Please enter the name of the passenger you like to lookup");
		           String passName2 = keyboard.next();
		           if(a1.seatLookUp(passName2)) {
		        	   
		           }
		           else
		        	   System.out.println("Passenger is not on this flight!");
		           
		           break;
		        case 4:
		        	   a1.showSeatMap();
			           break;
		        case 5:
			           System.out.println("This is the list of Passenger on this flight: \n");
			           System.out.println(a1);
			           break;
		        case 6:
			           System.out.println("Thank you for using Schulich Flight Reservation System. See you again!");
			           System.exit(0);
			           break;
		        default: 
		        	System.out.println("Invalid selection, please select between 1 to 6!");
                   break;
		      }
		 }
	}
}
