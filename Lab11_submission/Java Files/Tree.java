import java.io.PrintStream;

public class Tree {
	
	private Student root;
	
	public Tree() {setRoot(null);}
	
	public void insert(Student st) {
		if(st==null) 
			return;
		st.setLeft(null);
		st.setLeft(null);
		if(isEmpty())
			root = st;
		else {
			// Start with the root and look for spot to insert
			// i.e traverse the tree look for the proper spot to insert node
			Student cursor = getRoot(); // cursor == root
			while(true) {
				Student parent = cursor; //parent == root
				// question: insert left or right?
				// A < Z => A.compareTo(Z) < 0 then A comes first 
				if(st.getName().compareToIgnoreCase(cursor.getName()) < 0) { // insert node id < root id
					cursor = cursor.getLeft(); // cursor == root's left node to iterate
					// if the left child has no children, insert 
					if(cursor ==null) { // if the cursor.getLeft is null that means we can insert this given node
						parent.setLeft(st);
						return;
					}
				}
				else if(st.getName().compareToIgnoreCase(cursor.getName()) >= 0) {
					cursor = cursor.getRight();
					if(cursor == null) {
						parent.setRight(st);
						return;
					}
				}
			}
		}
		
	}
	
	// Following are the example of printing recursion vs iterative 
	public void printLeftEdge() {
		Student cursor = getRoot();
		while(cursor != null) {
			System.out.println(cursor);
			cursor = cursor.getLeft();
		}
	}
	// this function prints the left edge of a tree in ascending order. 
	//So, this function works on a liner list
	public void printLeftEdge(Student cursor) {
		if(cursor != null) { 
			System.out.println(cursor);
			printLeftEdge(cursor.getLeft());
			
		}
	}
	
	// method for console printing
	public void inOrderTraverse(Student cursor) {
		if(cursor != null) {
			// Ascending order
			inOrderTraverse(cursor.getLeft());
			// when the left returns then print
			System.out.println(cursor);
			inOrderTraverse(cursor.getRight());
		}
	}
	
	// Method to print to output file
	public void inOrderTraverse(Student cursor, PrintStream print) {
		if(cursor != null) {
			// Ascending order
			inOrderTraverse(cursor.getLeft(), print);
			// when the left returns then print
			print.println(cursor);
			inOrderTraverse(cursor.getRight(), print);
		}
	}
	// Breadth First for console printing 
	public String breadthFirst(Student cursor) {
		if(root ==null) {
			return null;
		}
		Queue myQ = new Queue();
		myQ.enqueue(new Node(cursor));
		while(!myQ.isEmpty()) {
			Node tempNode = myQ.dequeue();
			System.out.println(tempNode);
			Student tempLeft = tempNode.getNode().getLeft();
			Student tempRight = tempNode.getNode().getRight();
			if(tempLeft != null)
				myQ.enqueue(new Node(tempLeft));
			if(tempRight != null)
				myQ.enqueue(new Node(tempRight));
		}
		return null;
	}
	// Breadth First for file printing 
	public String breadthFirst(Student cursor, PrintStream print) {
		if(root ==null) {
			return null;
		}
		Queue myQ = new Queue();
		myQ.enqueue(new Node(cursor));
		while(!myQ.isEmpty()) {
			Node tempNode = myQ.dequeue();
			print.println(tempNode);
			Student tempLeft = tempNode.getNode().getLeft();
			Student tempRight = tempNode.getNode().getRight();
			if(tempLeft != null)
				myQ.enqueue(new Node(tempLeft));
			if(tempRight != null)
				myQ.enqueue(new Node(tempRight));
		}
		return null;
	}
	
	public void preOrderTraverse(Student cursor) {
		if(cursor != null) {
			// Descending order
			// print 
			System.out.println(cursor); 
			preOrderTraverse(cursor.getLeft());
			// when the left returns then print
			preOrderTraverse(cursor.getRight());	
		}
	}

	public Student search(Student cursor, String key) {
		if(cursor != null) {
			if(key.equalsIgnoreCase(cursor.getName())) {
				return cursor;
			}
			else if(key.compareToIgnoreCase(cursor.getName()) < 0) { //(key < cursor.getId()) 
				return search(cursor.getLeft(), key);
			}
			else {
				return search(cursor.getRight(), key);
			}
		}
		return null;
	}
	
	public Student delete(Student cursor, String key) {

        if (cursor == null)  return cursor; 
        if(root.getLeft() == null && root.getRight() == null && root.getName().equalsIgnoreCase(key) )
        	setRoot(null);
        if (key.compareTo(cursor.getName()) < 0) 
            cursor.setLeft(delete(cursor.getLeft(), key)); 
        else if (key.compareTo(cursor.getName()) > 0) 
            cursor.setRight(delete(cursor.getRight(), key)); 
        else
        { 
            if (cursor.getLeft() == null) 
                return cursor.getRight(); 
            else if (cursor.getRight() == null) 
                return cursor.getLeft(); 
            cursor.setName(minValue(cursor.getRight())); 
            cursor.setRight(delete(cursor.getRight(), cursor.getName())); 
        } 
        return cursor; 
	    } 
	
    private String minValue(Student cursor) 
    { 
        String min = cursor.getName(); 
        while (cursor.getLeft() != null) 
        { 
            min = cursor.getLeft().getName(); 
            cursor = cursor.getLeft(); 
        } 
        return min; 
    } 
	
	public boolean isEmpty() {
		if(getRoot() == null)
			return true;
		return false;
	}
	public Student getRoot() {
		return root;
	}
	private void setRoot(Student root) {
		this.root = root;
	}
	public String peek() {
		return root.toString();
	}


}
