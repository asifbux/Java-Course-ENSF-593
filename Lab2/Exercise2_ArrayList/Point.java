public class Point {

	
	private double x;
	private double y;
	String location;
	
	public Point() {
		this(0,0, "");
	}
	
	public Point(double x, double y, String location) {
		this.x = x;
		this.y = y;
		this.location = location;
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	public String getLocation() {
		return location;
	}
	public void set_label(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		String point = this.location + "(" + this.x + ", " + this.y + ")"; 
		return point;
	}
	
}
