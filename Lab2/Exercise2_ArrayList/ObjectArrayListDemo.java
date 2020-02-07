public class ObjectArrayListDemo {

public static void main (String [] args) {
		
		ObjectArrayList ar = new ObjectArrayList();
		ar.addElement (new Point (200, 200, "Calgary Airport"));
		ar.addElement (new Point (300, 300, "Edmonton Airport"));
		ar.addElement (new Point (400, 400, "Toronto Airport"));
		ar.addElement (new Point (500, 500, "Halifax Airport"));
		ar.insertAt (2, new Point(500, 500, "SpringBank Airport")); //inserting number 5 at index 2
		ar.removeAt (1); //remove the element at index 1
		ar.resize (7); //the new size of the array will be 2 elements
		ar.printElements(); //This should print all elements in the array
	}
}