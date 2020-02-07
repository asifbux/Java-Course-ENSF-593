

/**
 * ObjectArrayList imitates the functionality ArrayList for an object type
 * @author arsal
 *
 */


public class ObjectArrayList {
	/** Declare object Point array as a member variable */
	private Object[] obj;
	
	/**
	 * Constructor for integer array with a size parameter
	 * @param size
	 */
	public ObjectArrayList(int size) {
		obj = new Object[size];
	}
	/**
	 * Default constructor for integer array, array will be null
	 */
	public ObjectArrayList() {}
	/**
	 * Instance method to add an element, x, to an existing array.
	 * Checks whether the array is not null (i.e. has already been filled), otherwise a null pointer exception error is received
	 * @param x
	 */
	public void addElement (Object obj) {
		if (this.obj != null){
			Object[] arr = new Object[this.obj.length+1];
			for(int i=0; i<this.obj.length; i++) {
				arr[i] = this.obj[i];
			}
			arr[arr.length-1] = obj;
			this.obj = arr;
		}
		else {
			Object[] arr = {obj};
			this.obj = arr;
		}
	}
	/**
	 * Instance method to add a certain integer, x, to a specified index of an array. Does not allow for insertion at the end
	 * of the array, because the user should use addElement() instead.
	 * @param index
	 * @param x
	 */
	public void insertAt(int index, Object obj) {
		if (this.obj != null && index < this.obj.length && index >= 0){
			Object[] arr = new Object[this.obj.length+1];
			for(int i=0; i<index; i++) {
				arr[i] = this.obj[i];
			}
			arr[index] = obj;
			for(int i=index+1; i<arr.length; i++) {
				arr[i] = this.obj[i-1];
			}
			this.obj = arr;
		}
		else {
			System.out.println("Invalid insertion operation");
		}
	}
	/**
	 * Repurposed insertAt to create removeAt, which removes a specified index from the array.
	 * @param index
	 */
	public void removeAt(int index) {
		if (obj != null && index < obj.length && index >= 0){
			Object[] arr = new Object[obj.length-1];
			for(int i=0; i<index; i++) {
				arr[i] = obj[i];
			}
			for(int i=index+1; i<obj.length; i++) {
				arr[i-1] = obj[i];
			}
			obj = arr;
		}
		else {
			System.out.println("Invalid removal operation");
		}
	}
	/**
	 * Instance method to resize an array while maintaining its elements
	 * @param size
	 */
	public void resize(int size) {
		if (obj != null && size >=0) {
			Object[] arr = new Object[size];
			// Initialize arr elements with points of zero if the array is resized to be bigger. This way, arr has no null values when completed.
			if (size > obj.length){
				for(int i=0; i<arr.length; i++) {
					arr[i] = new Object();
				}
				System.arraycopy(obj, 0, arr, 0, obj.length);
			}
			else {
				System.arraycopy(obj, 0, arr, 0, size);
			}
			obj  = arr;
		}
		else {
			System.out.println("Invalid resize operation");
		}
	}
	/**
	 * Method to print the elements of the array
	 */
	public void printElements() {
		for(int i=0; i<obj.length; i++) {
			System.out.println(obj[i].toString());
		}
	}
	/**
	 * Returns element at specified index
	 * 
	 * @param index the desired index
	 * @returns object at position i in obj array
	 */
	public Object getElement(int index) {
		return obj[index];
	}
	
	/**
	 * Returns the length of the obj array
	 * 
	 * @returns length of the obj array
	 */
	public int getLength() {
		return obj.length;
	}
	
	public void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        AnagramNode pivot = ((AnagramLinkedList) obj[lowerIndex+(higherIndex-lowerIndex)/2]).getHead();
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which 
             * is greater then the pivot value, and also we will identify a number 
             * from right side which is less then the pivot value. Once the search 
             * is done, then we exchange both numbers.
             */
            while (((AnagramLinkedList) obj[i]).getHead().compareTo(pivot) < 0) {
                i++;
            }
            while (((AnagramLinkedList) obj[j]).getHead().compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
	 
    private void exchangeNumbers(int i, int j) {
        Object temp = obj[i];
        obj[i] = obj[j];
        obj[j] = temp;
    }
}