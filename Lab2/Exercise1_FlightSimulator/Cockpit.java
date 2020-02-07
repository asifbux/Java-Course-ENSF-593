/* This class makes a very simple abstraction of an aircraft's cockpit.
 * An objects of this class contains the following information: the current position 
 * of the aircraft, the starting point of the travel (source), the destination,
 * and the total traveled time(elapsed time from point of departure). This
 * class also provides instance methods to calculate the average speed, 
 * the distance between two points, the remaining travel time and a few more 
 * access methods and a constructor, as explained in the given  
 * comments, below.
 */

import java.lang.Math; 

/**
 * The Class Cockpit.
 */
public class Cockpit {
	
	/** The source point of the flight that represents the source airport  */
	private Point source;          
	
	/** The destination point of the flight that represents the destination airport. */
	private Point destination;     
	
	/** The current point of the flight on land or in the sky */
	private Point currentPoint;   
	                       
    /** The elapsed time since started travel from source. */
	private Time elapsedTime;     
	
	/** The flight's identification number. */
	private String flightNumber;  
	
	/**
	 * Instantiates a new Cockpit object.
	 *
	 * @param src the source airport 
	 * @param dest the destination airport
	 * @param fn the fight number
	 */
	public Cockpit (Point src, Point dest, String fn) {
		source = src;
		destination = dest;
		flightNumber = fn;
		elapsedTime = new Time();
		currentPoint = new Point(src.getX(), src.getY(), "Current Point");
		/* REQUIRES: src represents the starting point of travel (source), dest 
		 *           represents the destination, and fn represents the flight number. 
		 *           You may assume that the units for x and y coordinates of these 
		 *           points are in miles.
		 * PROMISES: initializes the private data members, source, destination, and 
		 *           flight_number with the values of arguments src, dest, and fn, 
		 *           respectively. It also initializes the data member current_point
		 *           (the current position of the aircraft) with src, and the 
		 *           elapsed_time with zero.
	   */	
	}
	
	/**
	 * Move forward.
	 *
	 * @param dx changes the current position of the aircraft by dx
	 * @param dy changes the current position of the aircraft by dy
	 */
	public void moveForward(double dx, double dy) {
	/* PROMISES: changes the current position of the aircraft by dx and dy. Which 
	 *           means the values of x and y coordinates of the current_point
	 *           increases by dx and dy, respectively.
	 */
		currentPoint.setX(currentPoint.getX() + dx);
		currentPoint.setY(currentPoint.getY() + dy);
	}
	
	/**
	 * Sets the elapsed time.
	 *
	 * @param dt the new elapsed time
	 */
	public void setElapsedTime(int dt) {
	/* PROMISES: increases the value of elapsed time by dt in (seconds).
	 */
		elapsedTime.increment(dt);
		
	}
	
	/**
	 * Average speed calculator.
	 *
	 * @return the double
	 */
	public double averageSpeedCalculator() {
//	/* PROMISES: returns the average speed in miles per hour. Which is the 
//	 *           distance from source divided by the elapsed time. 
//	 */	
		double distance = Math.sqrt(Math.pow((currentPoint.getX()-source.getX()),2) + 
				Math.pow((currentPoint.getY()-source.getY()),2));
		double speed = distance/elapsedTime.totalHours();
		return (speed);
	}
	
	/**
	 * Distance indicator.
	 *
	 * @param p1 the Point 1 refers to a point on the Cartesian plane 
	 * @param p2 the Point 2 refers to another point on the Cartesian plane
	 * @return the double
	 */
	public double distanceIndicator(Point p1, Point p2) {
//	/* REQUIRES: p1 and p2 refer to two points on a Cartesian plane 
//	 * PROMISES: calculates the distance between p1 and p2 (in miles)
//	 */	
		double distance = Math.sqrt(Math.pow((p1.getX()-p2.getX()),2) + 
				Math.pow((p1.getY()-p2.getY()),2));
		return distance;
	}
	
	/**
	 * Remaining travel time.
	 *
	 * @return the time
	 */
	public Time remainingTravelTime() {
//	/* PROMISES: returns a time object which represents the estimated remaining 
//	 *           travel time. Which is the remaining travel distance divided by 
//	 *           the aircraft's average speed. 
//	 */	
		double time = distanceIndicator(destination, currentPoint)/averageSpeedCalculator();
		int totalSeconds = (int) Math.round((time * 3600));
		Time remainingTravelTime = new Time(totalSeconds);
		return remainingTravelTime;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
//	/* PROMISES: Returns a string containing flight number, and the aircraft's status:
//	 *           current location (current point's x and y coordinates), 
//	 *           average speed of the aircraft in miles per hour, elapsed time,
//	 *           and the estimated remaining time to the destination.
//	 */	
		String print = "Flight number: " + this.flightNumber + "\n" +
						"Current Location: " + this.currentPoint + "\n" +
						"Traveled Time from Source: " + this.elapsedTime + "\n" +
						"Current Average Speed: " + String.format("%.2f",averageSpeedCalculator()) + " miles/hour" + "\n"+
						"Estimated Remaining Travel Time: " + remainingTravelTime() + "\n";
		return print;
	}	
	
	/**
	 * Display monitor.
	 */
	public void displayMonitor () {
		System.out.println(toString());
	}
	
	/**
	 * Sets the current label.
	 *
	 * @param new_label the new current label
	 */
	public void setCurrentLabel(String new_label) {
	/* PROMISES: changes the label (name) of the current_point to a new label,
	 *           by calling the function set_label from class Point.
	 */	
		currentPoint.set_label(new_label);
	}

}
