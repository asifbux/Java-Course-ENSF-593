
public class Airplane {
	
	private Passenger[] passArray; // list of passenger on the plane
	private char [][] seatMap;
	private int numOfPassengers;
	private final int numOfRows;
	
	public Airplane(int row) {
		setNumOfPassengers (0);
		numOfRows = row;
		passArray = new Passenger[1]; //array of objects of size 1
		seatMap = new char [row][5]; // assuming 5 seats per row
		populateSeatMap();
	}
	// this method takes a name, seat, and row information 
	// this method must check to see if the position is avilable. If position
	// is available, then the passenger is added to the passArray, and
	// an X is recorded in the seat map in that position 
	// if the position is not available, the method returns false
	
	public boolean addPassenger(String passName, int row, char seat) {
		
		if(markSeatMap(row, seat) == false) {
			return false;
		}
		Passenger p = new Passenger (passName, row, seat);
//		
		if (numOfPassengers == 0) { // we are saying if the list is completely empty
			passArray[0] = p;
//			passArray = new Passenger[1]; // array of objects
//			passArray[0] = new Passenger (passName, row, seat);
			// alternativetly we could call the constructor here instead of = p
		}
		
		else {
//			Passenger p = new Passenger (passName, row, seat);
			// we could instead call this outside and not having to write it here

			appendPassenger(p);
		}
		
		markSeatMap(row, seat);
		incrementNumOfPassengers();
		return true;
	}
	
	public boolean removePassenger(String passName) {
		if(numOfPassengers > 0) {
			for (int i = 0; i < passArray.length; i++)
			{
				if(passArray[i].getName().equalsIgnoreCase(passName)) {
					removeSeat(passArray[i].getAssignedSeat().getRow(), passArray[i].getAssignedSeat().getSeat());
					updatePassArray(i);
					decrementNumOfPassengers();
					return true;
				}
					
			}
				return false;
		}
		else
			return false;
	}
	
	// this is a wrapper method, that helps us abide to the gudilines which states
	// public methods must NOT call other public methods

	public boolean CheckSeatAvailability(int row, char seat) {
		return checkAvailability(row, seat);
	}
	
	//Method that prints the seatMap to the console
	public void showSeatMap() {
		System.out.println("The seat Map:\n");
		for ( int i = 0; i < seatMap.length; i++) {
			for (int j = 0; j < seatMap[i].length; j++) {
				System.out.print(seatMap[i][j] + " ");
		}
		System.out.println();	
		}
	}
	
// Helper Methods

	private void incrementNumOfPassengers() {
		// TODO Auto-generated method stub
		numOfPassengers++;
		
	}
	
	private void decrementNumOfPassengers() {
		numOfPassengers--;
	}

	private boolean markSeatMap(int row, char seat) {
		// TODO Auto-generated method stub
		if (checkAvailability (row, seat) == false)
			return false;
		seatMap[row][seat -'A'] = 'X';
		return true;
		
	}
	private boolean removeSeat(int row, char seat) {
		// TODO Auto-generated method stub
		seatMap[row][seat -'A'] = 'O';
		return true;
	}
	
	private void appendPassenger(Passenger p) {
		// step 1: create new memory
		Passenger [] temp = new Passenger [passArray.length + 1];
		// step 2: copy
		for (int i = 0; i < passArray.length; i++) {
			temp[i] = passArray[i];
		}
		// step 3: append new object
		temp[temp.length-1] = p;
		// step 4 : reassign passArray
		passArray = temp;
	
	}
	
	private void updatePassArray(int index) {
		Passenger [] temp = new Passenger [passArray.length - 1];
//		for (int i = 0; i < passArray.length; i++) {
//			temp[i] = passArray[i];
//		}
		for (int i = 0; i < passArray.length-1; i++) {
			if ( i < index)
				temp[i] = passArray[i];
			else if (i >= index)
				temp[i] = passArray[i+1];
		}
		passArray = temp;
		
	}
	private void populateSeatMap() {
		//TODO Auto-generted method stub
		for( int i =0; i < seatMap.length; i++) {
			for (int j = 0; j < seatMap[i].length; j++) {
				seatMap[i][j] ='O';
			}
		}
		
	}
	private boolean checkAvailability(int row, char seat) {
		
		if ((row >= numOfRows) || (row < 0)) {
			return false;
		}
		
		if ((seat > 'E') || (seat < 'A'))
			return false;
		
		if ((seatMap[row][seat- 'A']) == 'O')
			return true;
		
		return false;
	}
	
	public boolean seatLookUp(String passName)  {// being simplistic and assuming all passengers 
//	                            		// have unique names
//		// step1: search for passenger
		if(numOfPassengers > 0) {
			for (int i = 0; i < passArray.length; i++)
			{
				if(passArray[i].getName().equalsIgnoreCase(passName)) {
					System.out.println("This passenger is seated at Row: " + 
					passArray[i].getAssignedSeat().getRow() + " and Seat: " + 
					passArray[i].getAssignedSeat().getSeat());
					return true;
				}
			} 
				return false;
					
			}
		return false;
		
	}			
//	// Getter & Setter Methods
	
	public int getNumOfPassengers() {
		return numOfPassengers;
	}
	public void setNumOfPassengers(int numOfPassengers) {
		this.numOfPassengers = numOfPassengers;
	}

	public int getNumOfRows() {
		return numOfRows;
	}
@Override
	public String toString() {
	String st = "";
	for (int i = 0; i < passArray.length; i++) {
		//passArray[i] is a reference (i.e pointer) to a Passenger Object
		//The line: st += passArray[i]; makes a call to the toString method
		//of class Passenger. And, the toString() in class Passenger, makes
		// a call to the String in class Position
		st += passArray[i];
		st += "\n\n";
		
	}
	return st;
}
}
