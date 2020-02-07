
class Circle extends Shape
{
	private Double radius;

	Circle(Double x_origin, Double y_origin, Double newradius,  String name, Colour colour){
		super(x_origin, y_origin, name, colour);
		radius = newradius;
	}
	
	
	public void set_radius(Double newradius){
		radius = newradius;
	}
	
	public Double get_radius() {
		return radius;
	}
	
	public Double area() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public Double perimeter() {
		return 2 * Math.PI * radius;
	}
	
	public Double  volume(){
		return 0.0;
	}
	@Override
	public void shrink(Double divisor) throws SizeFactorException {
		super.shrink(divisor);
		this.radius = radius / divisor;
	}
	@Override
	public void enlarge(Double multiplier) throws SizeFactorException {
		super.enlarge(multiplier);
		this.radius = radius * multiplier;
	}
	
	public Object clone() {
		try {
			return super.clone();
		}
		catch( CloneNotSupportedException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public String toString(){
		String s = super.toString()+ "\nRadius: " + radius;
		return s;
	}
         
}