import java.io.IOException;
import java.util.Random;

public class Exercise1 {
	public static void main(String[] args) {
		FileManager fm = new FileManager();
		try {
			String order = args[0];
			int size = Integer.valueOf(args[1]);
			String algorithm = args[2];
			String filename = args[3];
			int[] arr = createArray(order, size);
			Long start = System.nanoTime();
			sort(algorithm, arr);
			Long end = System.nanoTime();
			System.out.println("Processing time for " + algorithm + " sort on " + size + " items: " + String.valueOf(end-start));
			fm.writeOutputFile(arr, filename);
		} 
		catch(NumberFormatException e) {
			System.err.println("Invalid entry for the array size, an integer value is required.");
		}
		catch (NoSuchMethodException e) {
			System.err.println(e);
		}
		catch(NegativeArraySizeException e) {
			System.err.println("Invalid entry for array size, a positive number is required.");
		}
		catch(IOException e) {
			System.err.println("Unable to write to output file.");
		}
	}
	
	private static void sort(String algorithm, int[] arr) throws NoSuchMethodException {
		switch(algorithm.toLowerCase()) {
			case "bubble":
				bubbleSort(arr);
				break;
			case "insertion":
				insertionSort(arr);
				break;
			case "merge":
				mergeSort(arr, 0, arr.length-1);
				break;
			case "quick":
				quickSort(arr, 0, arr.length-1);
				break;
			default:
				throw new NoSuchMethodException("Invalid entry for sort type, enter either bubble, insertion, merge or quick.");
		}
	}
	
	private static void bubbleSort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<(arr.length-1-i); j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	private static void insertionSort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			int temp = arr[i];
			int j = i;
			while(j>0 && temp<arr[j-1]) {
				arr[j] = arr[j-1];
				j -= 1;
			}
			arr[j] = temp;
		}
	}
	public static void mergeSort(int[] arr, int first, int last) {
		if(first < last){
			int mid = (first + last)/2;
			mergeSort(arr, first, mid);
			mergeSort(arr, mid+1, last);
			merge(arr, first, mid, last);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		//Step 1: Finding the sizes of the left and right subarrays which are to be merged
		int leftSize = mid - left + 1;
		int rightSize = right - mid;
		
		//Step 2: create new memory for temp arrays
		int[] leftTemp = new int [leftSize];
		int[] rightTemp = new int[rightSize];
		
		//Step 3 - copy data to temp arrays
		for(int i=0; i<leftSize; i++) {
			leftTemp[i] = arr[left + i];
		}
		
		for(int i=0; i<rightSize; i++) {
			rightTemp[i] = arr[mid+1+i];
		}
		
		//Step 4 - merge the temp arrays
		int iLeft = 0, iRight = 0;
		//Index for the merged array
		int j = left;
		while((iLeft < leftSize) && (iRight < rightSize)) {
			if(leftTemp[iLeft] <= rightTemp[iRight]) {
				arr[j] = leftTemp[iLeft];
				iLeft++;
			}
			else {
				arr[j] = rightTemp[iRight];
				iRight++;
			}
			j++;
		}
		//Copy the remaining elements of left or right:
		while(iLeft < leftSize) {
			arr[j] = leftTemp[iLeft];
			iLeft++;
			j++;
		}
		while(iRight < rightSize) {
			arr[j] = rightTemp[iRight];
			iRight++;
			j++;
		}
	}
	//Previous implementation of quick sort (pivot as end value):
//	private static void quickSort(int arr[], int begin, int end) {
//	    if (begin < end) {
//	        int partitionIndex = partition(arr, begin, end);
//	        quickSort(arr, begin, partitionIndex-1);
//	        quickSort(arr, partitionIndex+1, end);
//	    }
//	}
	
//	private static int partition(int[] arr, int start, int end) {
//		int pivot = arr[end];
//		int pivotIndex = start; //tracks index which pivot will eventually go
//		for(int i = start; i<end; i++) { //i
//			if(arr[i] < pivot) {
//				//swap with pivot index position, increment pivot index
//				int temp = arr[i];
//				arr[i] = arr[pivotIndex];
//				arr[pivotIndex] = temp;
//				pivotIndex++;
//			}
//		}
//		//place pivot into it's proper position
//		int temp = arr[pivotIndex];
//		arr[pivotIndex] = pivot;
//		arr[end] = temp;
//		return pivotIndex;
//	}
	
	private static void quickSort(int[] arr, int low, int high) {
		int pi = partition(arr, low, high);
		if(low < pi-1)
		{
			quickSort(arr, low, pi-1); // left side
		}
		if(pi < high) { // NO ELSE IF
			quickSort(arr, pi, high); // Right side
		}
	}
	
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[(low+high)/2];
		while(low <= high) { 
			while(arr[low] < pivot)
				{low++;}
			while(arr[high] > pivot)
				{high--;}
			if(low <= high) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				low++;
				high--;
			}
		}
		return low;
	}
	
	private static int[] createArray(String order, int size) throws NoSuchMethodException {
		switch(order.toLowerCase()) {
			case "ascending":
				return ascendingArray(size);
			case "descending":
				return descendingArray(size);
			case "random":
				return randomArray(size);
			default:
				throw new NoSuchMethodException("Invalid entry for array type, enter either ascending, descending or random.");
		}
	}
	
	private static int[] randomArray(int size) throws NegativeArraySizeException {
		int[] arr = new int[size];
		Random r = new Random();
		for(int i=0; i<size; i++) {
			arr[i] = r.nextInt(size*10);
		}
		return arr;
	}
	
	private static int[] descendingArray(int size) throws NegativeArraySizeException  {
		int[] arr = new int[size];
		for(int i=size; i>0; i--) {
			arr[i-1] = i;
		}
		return arr;
	}
	private static int[] ascendingArray(int size) throws NegativeArraySizeException  {
		int[] arr = new int[size];
		for(int i=0; i<size; i++) {
			arr[i] = i+1;
		}
		return arr;
	}
}
