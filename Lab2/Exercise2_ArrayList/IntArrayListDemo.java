public class IntArrayListDemo {
	
	public static void main (String [] args) {
		
		IntArrayList ar = new IntArrayList ();
		ar.addElement (2);
		ar.addElement (4);
		ar.addElement (6);
		ar.addElement (8);
		ar.insertAt (2, 5); //inserting number 5 at index 2
		ar.removeAt (1); //remove the element at index 1
		ar.resize (2); //the new size of the array will be 2 elements
     	ar.printElements(); //This should print all elements in the array
	}
}
