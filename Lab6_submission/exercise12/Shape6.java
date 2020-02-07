
abstract class Shape implements Cloneable, Accessible, Resizable
{
	protected Point origin;
	protected Text name;
	abstract protected Double area();
	abstract protected Double perimeter();
	abstract protected Double volume();
	
	protected Shape(Double x_origin, Double y_origin, String name, Colour colour){
		
		origin = new Point(x_origin,y_origin, colour);
		this.name = new Text(name);
	}
	
	protected Point  getOrigin()   
	{
		return origin;
	}
	
	
	protected  Double distance(   Shape  other)
	{
		return origin.distance(other.origin);
	}
	
	protected Double  distance(   Shape  a,    Shape  b)
	{
		return Point.distance(a.origin, b.origin);
	}
	
	
	protected void  move(Double dx, Double dy)
	{
		origin.setx(origin.getx()+dx);
		origin.sety(origin.gety()+dy);
	}
	
	public void shrink(Double divisor) throws SizeFactorException {
		//throw a SizeFactorException if
		//the value of n (i.e. the divisor) is less than LIMIT (e.g. 1.0)
		if (divisor < $LIMIT ) {
			throw new SizeFactorException();
		}
	}
	public void enlarge(Double multiplier) throws SizeFactorException {
		if (multiplier < $LIMIT ) {
			throw new SizeFactorException();
		}
	}
	
	public String getName() {
		return name.getText();
	}
	public void setName(String newName) {
		name.setText(newName);
	}
		
	@Override
	public Object clone() throws CloneNotSupportedException {
		Shape copy = (Shape) super.clone();
		copy.origin = (Point) origin.clone();
		copy.name = (Text) name.clone();
		return copy;
	}
	@Override
	public String toString(){
		String s = "\nShape name: " + name + "\nOrigin: " + origin;
		return s;
	}

}

