/**
 * The Class StudentLinkedListApp.
 */
public class StudentLinkedListApp {
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		StudentLinkedList theList = new StudentLinkedList();
		theList.insertToEndOfList(new Student("Joe", 5));
		theList.insertToEndOfList(new Student("Sarah", 4));
		theList.insertToEndOfList(new Student("Sam", 2));
//		theList.insertToFrontOfList(new Student("Mo", 14));
//		theList.insertToEndOfList(new Student("Joe", 1));
//		theList.insertToEndOfList(new Student("Sarah", 2));
//		theList.insertToEndOfList(new Student("Sam", 4));
//		theList.insertToFrontOfList(new Student("Mo", 1));
		theList.recursivePrintList();
		System.out.println("\nFollowing is the result after uncommenting the below method: \n");
		//System.out.println(theList.search(4).getName());
		//theList.InsertInOrder(new Student("Bob", 8));
		//theList.bubbleSort();
		theList.removeFirstElement(); 
		theList.removeElement(4); 
		theList.removeEndElement();
		//theList.printList();
		//theList.recursivePrintList(theList.getHead()); //Static 
		theList.recursivePrintList();
	}

}
