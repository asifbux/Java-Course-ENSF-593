public class IntArrayList {
	
	private int [] array;
	
	public IntArrayList (int size) {
		
	if (size > 0) {
		array = new int [size];
		}
	}
	public IntArrayList () {}
	
	public void addElement (int x) {
		if (array == null) {
			array = new int[1];
			array[0] = x;
		}
		else if (array.length >= 1) {
			int lenOfArray = array.length;
			int [] arr = new int [lenOfArray+1];
			int [] temp = array;
			for (int j = 0; j < arr.length-1; j++) {
				arr[j] = temp[j];
				}
			arr[arr.length-1] = x;
			array = arr;
		} 
	}
	public void insertAt (int index, int number) { 
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
		if ( array != null && index >0 && index < array.length) {
		int [] temp =  new int[array.length-1];
		for (int i = 0; i < array.length-1; i++) {
			if ( i < index)
				temp[i] = array[i];
			else if (i >= index)
				temp[i] = array[i+1];
		}
		array = temp;
	}
		else if (array == null) {
			System.out.println("Array has not been initilized");
		}
		else
			System.out.println("ERROR: Trying to insert out Of range index");
	}
	public void resize (int elements) { //the new size of the array will be 2 elements
		if ( array == null)
		{
			int [] temp = new int[elements];
			array = temp;
		}
		else if ( elements > 0)
		{
			int [] temp = new int[elements];
			if ( elements > array.length) {
			for (int i = 0; i < array.length; i++)
				temp[i] = array[i];
			for (int i = array.length; i < temp.length; i++)
				temp[i] = 0;
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
			System.out.print(array[i] +" ");
		 }
		else
			System.out.println("Array is null & can not be printed!");
	}
}
