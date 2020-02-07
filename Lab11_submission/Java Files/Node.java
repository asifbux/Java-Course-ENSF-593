
public class Node {
	
	private Student node;
	private Node next;
	
	public Node(Student node) {
		setNode(node);
		setNext(null);
	}


	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Student getNode() {
		return node;
	}

	public void setNode(Student node) {
		this.node = node;
	}
	@Override
	public String toString() {
		return "" + node;
	}



}
