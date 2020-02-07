

/**
 * AnagramNodeLinkedList class containing a pointer to the head AnagramNode node. 
 * 
 * @author A. Fardi
 * @version 1
 * @since November 21, 2019
 */
public class AnagramLinkedList {
	
	/** The head (or first) node in the linked list. */
	private AnagramNode head;
	
	/**
	 * Instantiates a new AnagramNode linked list.
	 */
	public AnagramLinkedList () {
		head = null;
	}
	
	/**
	 * Insert to end of list.
	 *
	 * @param s the inserted AnagramNode
	 */
	public void insertToEndOfList(AnagramNode an) {
		if (head == null) {
			head = an;
		}
		else {	
			getLastNode().setNext(an);
		}
	}
	
	/**
	 * Insert to front of list by changing the reference pointer for the head. 
	 *
	 * @param s the inserted AnagramNode
	 */
	public void insertToFrontOfList (AnagramNode s) {
		if (head == null) {
			head = s;
		}
		else {
			s.setNext(head);
			head = s;
		}
	}
	
	/**
	 * Inserts a AnagramNode in order by ascending ID number.
	 * 
	 * Traverses the LinkedList and compares IDs, and inserts the new AnagramNode either at the beginning, end or in-between existing nodes. 
	 * The comparison of ID numbers is performed in a way that a unique ID is required.
	 *
	 * @param s the inserted AnagramNode
	 */
	public void insertInOrder(AnagramNode an) {
		AnagramNode cursor = head;
		if (an.compareTo(head) == 0)
			return;
		else if (an.compareTo(head) < 0) {
			insertToFrontOfList(an);
			return;
		}
		while (cursor.getNext() != null) {
			if(an.compareTo(cursor.getNext()) == 0)
				return;
			else if(an.compareTo(cursor.getNext()) < 0) {
				insertBetween(cursor, an);
				return;
			}
			cursor = cursor.getNext();
		}
		insertToEndOfList(an);
	}
	/**
	 * Removes the AnagramNode with given ID, if it exists, from the linked list. 
	 *
	 * @param id the id of the removed AnagramNode.
	 * @return theAnagramNode the removed AnagramNode
	 */
	public AnagramNode removeElement(String word) {
		AnagramNode theAnagramNode = searchNodes(word);
		if (theAnagramNode == null)
			return null;
		if(theAnagramNode == head) {
			removeFirstElement();
		}
		else if(theAnagramNode.getNext() == null) {
			removeEndElement();
		}
		else if(theAnagramNode != null) {
			AnagramNode thePreviousAnagramNode = getPreviousNode(word);
			thePreviousAnagramNode.setNext(theAnagramNode.getNext());
		}
		return theAnagramNode;
	}

	/**
	 * Swaps the positions of two nodes (newMiddle and newLast).
	 * 
	 * Changes the next reference pointers for the two nodes as well as the pointers for the node preceding these two (curr),
	 *
	 * @param curr the current node preceding the two to be swapped; does not change position but has its next pointer changed
	 * @param last the new last node, swaps positions with its next node (middle)
	 * @param middle the new middle node, swaps positions with its previous node (last)
	 */
	private void swapnodes(AnagramNode curr, AnagramNode newLast, AnagramNode newMiddle) {
		curr.setNext(newMiddle);
		newLast.setNext(newMiddle.getNext());
		newMiddle.setNext(newLast);
	}

	/**
	 * Wrapper for the searchNodes method. 
	 *
	 * @param id the id to be searched
	 * @return the corresponding AnagramNode object
	 */
	public AnagramNode search(String word) {
		return searchNodes(word);
	}
	
	/**
	 * Removes the end element from the node.
	 *
	 * @return the removed AnagramNode
	 */
	public AnagramNode removeEndElement() {
		AnagramNode endnode = getLastNode();
		if (endnode == head) {
			removeFirstElement();
		}
		else {
			AnagramNode secondLastnode = getPreviousNode(endnode.getWord());
			secondLastnode.setNext(null);
		}
		return endnode;
	}
	
	/**
	 * Removes the first element.
	 *
	 * @return the removed AnagramNode
	 */
	public AnagramNode removeFirstElement() {
		AnagramNode temp = head;
		head = head.getNext();
		return temp;
	}
	
	/**
	 * Gets the head node.
	 *
	 * @return the head
	 */
	public AnagramNode getHead() {
		return head;
	}
	

//////////Helper methods
	/**
	 * Traverses the linked list to find a node with matching ID. 
	 *
	 * @param id the id
	 * @return the AnagramNode
	 */
	private AnagramNode searchNodes(String word) {
		AnagramNode cursor = head;
		while (cursor != null) {
			if (cursor.getWord().equals(word))
				return cursor;
			cursor = cursor.getNext();
		}
		return null;
	}
	
	/**
	 * Inserts a node in-between two existing nodes.
	 *
	 * Used in the insertInOrder() method. 
	 * @param curr the current node which will precede the new node
	 * @param s the inserted AnagramNode
	 */
	private void insertBetween(AnagramNode curr, AnagramNode s) {
		AnagramNode temp = curr.getNext();
		curr.setNext(s);
		s.setNext(temp);
	}
	
	/**
	 * To string for each node in linked list.
	 */
	@Override
	public String toString() {
		String s = "";
		AnagramNode cursor = head;
		while (cursor != null) {
			s += "\n" + cursor.toString();
			cursor = cursor.getNext();
		}
		return s;
	}
	
	/**
	 * Gets the node preceding the node with the given ID.
	 *
	 * @param id the id of the current node
	 * @return the previous node
	 */
	private AnagramNode getPreviousNode(String word) {
		AnagramNode theAnagramNode = searchNodes(word);
		AnagramNode cursor = head;
		if(theAnagramNode != head) {
			while(cursor.getNext() != null) {
				if(cursor.getNext().getWord().equals(word))
					return cursor;
				cursor = cursor.getNext();
			}
		}
		return null;
	}
	
	/**
	 * Gets the last node.
	 *
	 * @return the last node
	 */
	private AnagramNode getLastNode() {
		AnagramNode cursor = head;
		while (cursor.getNext() != null) {
			cursor = cursor.getNext();
		}
		return cursor;
	}

}