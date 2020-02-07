public class ObjectArrayList {
	
	private Point [] array;
	
	public ObjectArrayList (int size) {
		
	if (size > 0) {
		array = new Point [size];
		}
	}
	public ObjectArrayList () {}
	
	public void addElement (Point x) {
		if (array == null) {
			array = new Point[1];
			array[0] = x;
		}
		else if (array.length >= 1) {
			int lenOfArray = array.length;
			Point [] arr = new Point[lenOfArray+1];
			Point [] temp = array;
			for (int j = 0; j < arr.length-1; j++) {
				arr[j] = temp[j];
				}
			arr[arr.length-1] = x;
			array = arr;
		} 
	}
	public void insertAt (int index, Point number) { 
		if ( array == null)
		{
			System.out.println("Array has not been initilized");
		}
		else if ( index < array.length && index >= 0)
			array[index] = number;
		else
			System.out.println("ERROR: Trying to insert out Of range index");
	}
	
	public void removeAt (int index) {//remove the element at a index 
		if ( index < array.length && index >= 0) {
		Point [] temp =  new Point[array.length-1];
		for (int i = 0; i < array.length-1; i++) {
			if ( i < index)
				temp[i] = array[i];
			else if (i >= index)
				temp[i] = array[i+1];
		}
		array = temp;
	}
		else if ( array == null) {
			System.out.println("Array has not been initilized");
		}
		else
			System.out.println("ERROR: Trying to insert out Of range index");
	}
	public void resize (int elements) { //the new size of the array will be 2 elements
		if ( array == null)
		{
			Point [] temp = new Point [elements];
			array = temp;
		}
		else if ( elements > 0)
		{
			Point [] temp = new Point[elements];
			if ( elements > array.length) {
			for (int i = 0; i < array.length; i++)
				temp[i] = array[i];
			for (int i = array.length; i < temp.length; i++)
//				temp[i] = new Point(); optional
			array = temp;
			}
			else
			{
				for (int i = 0; i < elements; i++)
					temp[i] = array[i];
					array = temp;
			}
		}
		else
			System.out.println("ERROR: Number of elements can not be negative!");
	}

	public void printElements() {
		if ( array != null)
		 {for (int i = 0; i < array.length; i++)
			System.out.println(array[i] +" ");
		 }
		else
			System.out.println("Array is null & can not be printed!");
	}
}

	
