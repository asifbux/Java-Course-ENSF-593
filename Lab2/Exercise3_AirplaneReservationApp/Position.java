
public class Position {
	
	private int row;
	private char seat;
	
	public Position(int row, char seat) {
		
		setRow(row); // could have said this.row = row;
		setSeat(seat);
	
	}
	
	// This constructor is called a copy constructor 
	// This receives an object of type position, and create a
	// deep copy for the this object
	
	public Position(Position p) { 
		if ( p != null) {
			setRow(p.row); //could have said this.row = p.row;
			setSeat(p.seat);
		}
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	public char getSeat() {
		return seat;
	}
	public void setSeat(char seat) {
		this.seat = seat;
	}
	
	public String toString() {
		return "Row " + row + ", and Seat " + seat;
		
	}
	
	
	

}
