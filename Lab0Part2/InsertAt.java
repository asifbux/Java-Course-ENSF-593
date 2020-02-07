// ASIF BUX ENSF593 LAB 0 PART || Question 1

public class InsertAt {
	
	public static void main ( String [] args) {
		
			 float[] array = {6.7f, 5.9f, 10, 23, 44, 4.6f, 9.1f, 100, 79};

			 array = insertAt(array, 255, 3);
			 
				 for(int i = 0; i < array.length; i++)
				 System.out.print(array[i] + " ");
			 
			 }
	
	public static float [] insertAt( float [] arr, float a, int b) {
		 
		if ( b > arr.length || b < 0) {
			System.out.println("Operation could not be completed because index is not in array");
			return null;
		}
		
		float [] temp = new float [arr.length +1]; // 9 + 1
		
		int loopLimit = arr.length + 1;
		
		for (int i = 0; i < b; i++)
			temp[i] = arr[i];
		
		temp[b] = a;
				
		for (int i = 1 + b; i < loopLimit; i++) {
			temp[i] = arr[i-1];
		 }
		return temp;
		
		
	}
}

