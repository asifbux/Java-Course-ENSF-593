//ASIF BUX ENSF593 LAB 0 PART || Question 3

import java.util.Scanner;
	
public class AllUnique {
	
	public static void main (String [] args) {
		
		System.out.println("How integers in your arrays? ");
		Scanner s = new Scanner(System.in);
		int sizeArray = s.nextInt();
		
		
		// takes the size of the array by user and sets it up to empty array with Zeros
		int [] array = new int[sizeArray]; 
		System.out.println("Enter your integers one at a time and hit enter!");
		
		// takes array one at a time up to the max sizeArray
		for (int i = 0; i < sizeArray; i++)   
			array[i] = s.nextInt();
		s.close();
		
		// Prints entered array
		System.out.print("Your array is: ");
		for(int i = 0; i < sizeArray; i++)  
			System.out.print(array[i]+ " ");
		
		System.out.println();
		
		boolean isUnique = allUnique(array);
		
		// Prints user if the array is unique or not.
		
		if ( isUnique == true)
			System.out.println("The array is Unique, therefore " + isUnique +".");
		else
			System.out.println("The array is not Unique, therefore " + isUnique +".");
		
	}
	
	public static boolean allUnique(int [] arr) {
		
		for ( int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ( arr[i] == arr[j]) {
					return false;
				}
			}
		}
		return true;		
	}
}