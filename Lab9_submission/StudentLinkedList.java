
/**
 * The Class StudentLinkedList.
 */
public class StudentLinkedList {
	
	/** The head. */
	private Student head;
	
	/**
	 * Instantiates a new student linked list.
	 */
	public StudentLinkedList() {
		head = null;
	}
	
	/**
	 * Insert to end of list.
	 *
	 * @param s the s
	 */
	public void insertToEndOfList(Student s) {
		//Student cursor = head; // need a temp Student object refrence to go through the linkedList since 
		//head cant move!
		if(head == null) {
			head = s;
		}
		else {
			getLastNode().setNext(s);;
			}
		}
		
//	public static void recursivePrintList(Student cursor) {
//		if(cursor != null ) {
//			recursivePrintList(cursor.getNext());
//			System.out.println(cursor); // if you add the print before the line it will print in reverse
//		}
//	
//	}
// we create a wrapper method so that we dont have to pass the head from main. The actual recursive implemntation is done
/**
 * Recursive print list.
 */
//  in the overloaded recursivePrintList which takes a Student object as an argument. 
	public void recursivePrintList() {
		recursivePrintList(head);
		}
	
	/**
	 * Recursive print list.
	 *
	 * @param cursor the cursor
	 */
	public void recursivePrintList(Student cursor) {
		if(cursor != null ) {
			System.out.println(cursor);
			recursivePrintList(cursor.getNext());
           // if you add the print before the line it will print in reverse
		}
	}
	
	/**
	 * Gets the head.
	 *
	 * @return the head
	 */
	public Student getHead() {
		return head;
		
	}
	
	/**
	 * Prints the list.
	 */
	void printList() {
		Student cursor = head;
		while (cursor != null) {
			System.out.println(cursor);
			cursor = cursor.getNext();
		}
	}
	
	/**
	 * Insert to front of list.
	 *
	 * @param s the s
	 */
	public void insertToFrontOfList(Student s) {
		if(head == null) {
			head = s;
		}
		else {
			s.setNext(head);
			head = s;
		}
	}
	
	/**
	 * Bubble sort.
	 */
	public void bubbleSort() { 
		Student cursor = head;
		int loopLimit = getSize();
		for(int i = loopLimit; i > 1; i--) {
				if(cursor != null && cursor.getNext() != null) {
					if(cursor.getId() > cursor.getNext().getId()) {
						Student nextNode = cursor.getNext(); // head = joe,
						cursor.setNext(nextNode.getNext()); // set moe to sarah , changes both head n cursor 
						nextNode.setNext(cursor); //joe next to moe
						head = nextNode;
					}
					else
						cursor = cursor.getNext();
				}
				boolean flag = true;
				int counter = 2;
				while(cursor != null && cursor.getNext() != null && flag) { // cursor = moe
				if(cursor.getId() > cursor.getNext().getId()) { // 14 > 4
					Student nextNode = cursor.getNext();
					cursor.setNext(nextNode.getNext()); // moe to sam
					nextNode.setNext(cursor); // sarah to moe
					Student previousNode = getPrevious(cursor);
					previousNode.setNext(nextNode); // Joe pointing at sarah
					counter += 1;
				}
				else 
					cursor = cursor.getNext();
				if( counter >= i) {
					flag = false;
					cursor = head;
				}

			}

			}
	}
	
	/**
	 * Insert in order.
	 *
	 * @param p the p
	 */
	public void InsertInOrder(Student p) {
		bubbleSort();
		if(search(p.getId()) == null) {
			Student cursor = head;
			if(head == null || p.getId() < cursor.getId()) {
				insertToFrontOfList(p);
			}
			while(cursor != null) {
				try {
					if(p.getId() > cursor.getId() && p.getId() < cursor.getNext().getId()) {
						Student nextNode = cursor.getNext();
						cursor.setNext(p); 
						p.setNext(nextNode);
						break;
				}
				}
				catch(Exception e){
					if(p.getId() > cursor.getId()) {
						insertToEndOfList(p);
						break;
					}
				}
				cursor = cursor.getNext();
			}
		}

	}
	
	/**
	 * Gets the previous.
	 *
	 * @param currentNode the current node
	 * @return the previous
	 */
	public Student getPrevious(Student currentNode) {
		Student cursor = head;
		while(cursor.getNext() != null ) {
			if(currentNode == head) {
				return null;
			}
			else {
				if (cursor.getNext().getId() == currentNode.getId()) {
					return cursor;
				}
			}
			cursor = cursor.getNext();
		}
		return null;
	}

		
	/**
	 * Removes the end element.
	 *
	 * @return the student
	 */
	public Student removeEndElement() {
		Student cursor = head;
		while(cursor != null) {
			if (cursor.getNext() == null) {
				this.head = null;
				return null;
			}
			else if(cursor.getNext().getNext() == null) {
				cursor.setNext(null); 
				return cursor;
			}

			cursor = cursor.getNext();
		}
		return null;
	}
	
	/**
	 * Removes the first element.
	 *
	 * @return the student
	 */
	public Student removeFirstElement() {
		Student cursor = head;
		if(cursor != null) {
			this.head = cursor.getNext();
			return this.head;
		}
		else  {
			return null;
		}
	}
	
	/**
	 * Removes the element.
	 *
	 * @param id the id
	 * @return the student
	 */
	public Student removeElement(int id) {
		if (search(id) != null) {
			Student match = search(id);
			Student cursor = head; // moe
			if(cursor.getId() == id)
				return removeFirstElement();
			while(cursor != null) {
				if (cursor.getNext().getId() == id) { // 5
					cursor.setNext(match.getNext()); 
					break;
				}
				cursor = cursor.getNext();
			}
		}
		return null;
	}
	
	/**
	 * Search.
	 *
	 * @param id the id
	 * @return the student
	 */
	public Student search(int id) {
		Student cursor = head;
		while(cursor != null) {
			if(cursor.getId() == id) {
				return cursor;
			}
			cursor = cursor.getNext();	
		}
		return null;
	}
	
	
	/**
	 * Gets the last node.
	 *
	 * @return the last node
	 */
	private Student getLastNode() {
		Student cursor = head;
		while(cursor.getNext() != null) {
			cursor = cursor.getNext();
		}
		return cursor;
	}
	
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		
		int sizeOfNodes = 0;
		Student cursor = head;
		
		while (cursor != null) {
			sizeOfNodes +=1;
			cursor = cursor.getNext();
		}
		return sizeOfNodes;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		Student cursor = head;
		while(cursor.getNext() != null) {
			cursor = cursor.getNext();
		}
		
		return "StudentLinkedList [head=" + head + "]";
	}
	
	

}
