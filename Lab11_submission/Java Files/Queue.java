
public class Queue {
	
	private Node head;
	private Node tail;
	
	public Queue() {
		setHead(null);
		setTail(null);
	}
	
	public void enqueue (Node n) {
		if(n == null) {
			return;
		}
		else if(n.getNext() !=null) 
			n.setNext(null);
		if(isEmpty()) {
			head = n;
			tail =n;
		}
		else {
			getTail().setNext(n);
			setTail(n);
		}
	}
	
	public Node dequeue() {
		if(isEmpty()) 
			return null;
		
		Node temp = getHead();
		
		if(getHead().getNode().getName().equalsIgnoreCase(getTail().getNode().getName()))
		{
			setHead(null);
			setTail(null);
		}
		else {
			setHead(getHead().getNext()); // head = head.getNext()
		}
		temp.setNext(null);
		return temp; // returning a node that has been removed is a potential security risk, because that node 
		// links to all other nodes that come after it.
		//Solution: Ensure the next in the node to be removed is null before removing.
	}
	
	public boolean isEmpty() {
		if(getHead() == null || getTail() == null) {
			return true;
		}
		return false;
	}
	private Node getHead() {
		return head;
	}
	private void setHead(Node head) {
		this.head = head;
	}
	private Node getTail() {
		return tail;
	}
	private void setTail(Node tail) {
		this.tail = tail;
	}
	public void print() {
		Node cursor = getHead();
		while(cursor != null) {
			System.out.println(cursor);
			cursor = cursor.getNext();
		}
		
	}
	

}
