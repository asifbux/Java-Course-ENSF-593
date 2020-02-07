
public class Passenger {
	
	private String name;
	private Position assignedSeat; // object of type position
	
	public Passenger(String name, int row, char seat) {
		this.setName(name);
		setAssignedSeat(new Position(row, seat));
		
	}
	
	public Passenger(String name, Position assignedSeat) {
		this.setName(name);
		//this.assignedSeat = assignedSeat; 
		// the above will result in two passenger to have 
		// the same seat! not acceptable
		// instead of below line we will use  copy constructor
		// to create a deep copy of the 10 , A
		//this.assignedSeat = new Position(assignedSeat.getRow(),
										//assignedSeat.getSeat();
		// this will create a deep copy of the 10 , A
		// before we had this 
		//this.assignedSeat = new Position (assignedSeat);
		// to below using the setter function
		this.setAssignedSeat(new Position (assignedSeat));
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Position getAssignedSeat() { // send a copy of the object
		return assignedSeat;
	}

	public void setAssignedSeat(Position assignedSeat) {
		this.assignedSeat = assignedSeat;
	}
	
	
	@Override
	public String toString() {
		return "Passenger Name: " + this.name + "\nAssigned Seat: " + assignedSeat;
		
	}
	

}
