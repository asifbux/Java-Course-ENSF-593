//ASIF BUX LAB ENSF593 0 PART || Question 2

public class SwapArrays {
	
	public static void main (String [] args) {
			 float [] first_array = {6.7f, 5.9f, 10, 23, 44, 4.6f, 9.1f};
			 float [] second_array = {11, 12, 13, 14, 15, 16, 17};

			 //call SwapArrays function here
			//print both arrays here
			
			
			swapArrays(first_array, second_array);
			
			 
			 System.out.print("the first swapped array is: ");
			 for ( int i = 0; i < first_array.length; i++)
				 System.out.print(first_array[i] +" ");
			 
			 System.out.println();
			 
			 System.out.print("the second swapped array is: ");
			 for ( int i = 0; i < second_array.length; i++)
				 System.out.print(second_array[i] + " ");
			 
			}
	public static void swapArrays (float [] arr1, float [] arr2) {
		
		if (arr1.length != arr2.length) {
			System.out.println("Operation could not be completed because length is not equal");
		}
		else {
	
		int arrayLength = arr1.length;
		
		float [] temp = new float [arrayLength];
		
		for (int i = 0; i < arrayLength; i++)
			temp[i] = arr1[i];
		
		for (int i = 0; i < arrayLength; i++)
			arr1[i] = arr2[i];
		
		for (int i = 0; i < arrayLength; i++)
			arr2[i] = temp[i];
		
	}

}
}
