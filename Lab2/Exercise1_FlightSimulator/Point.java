/**
 * The Class Point.
 */
public class Point {
	
	/** The x point on the Cartesian plane. */
	private double x;
	
	/** The y point on the Cartesian plane. */
	private double y;
	
	/** The location label. */
	String location;
	
	/**
	 * Instantiates a new point to (0,0) and empty string.
	 */
	public Point() {
		this(0,0, "");
	}
	
	/**
	 * Instantiates a new point.
	 *
	 * @param x the x point
	 * @param y the y point
	 * @param location the location 
	 */
	public Point(double x, double y, String location) {
		this.x = x;
		this.y = y;
		this.location = location;
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Sets the label.
	 *
	 * @param location the new label
	 */
	public void set_label(String location) {
		this.location = location;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		String point = String.format("%s (%.2f , %.2f)", this.location,this.x,this.y); 
		return point;
	}
	
}
