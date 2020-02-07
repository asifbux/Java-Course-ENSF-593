public class Marathon {
	
	public static int indexOfFastest(int [] arr) {
		
		int min = arr[0];
		int lowest = 0;
		for ( int i = 1; i < arr.length; i++) 
		{
			if (min > arr[i]) {
				min = arr[i];
				lowest = i;
			}
		}
		
		return lowest;
		
	}
	
	public static void main (String[] args) {
		
	String[] names = { "Elena", "Thomas", "Hamilton", "Suzie",
	"Phil", "Matt", "Alex", "Emma", "John", "James", "Jane",
	"Emily", "Daniel", "Neda", "Aaron", "Kate" };
	
	int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243,
	334, 412, 393, 299, 343, 317, 265 };
	
	int fastestIndex = Marathon.indexOfFastest(times);
	
	System.out.println("Name of the fastest runner is " + names[fastestIndex]);
	System.out.println("Time of the fastest runner is " + times[fastestIndex]);
	
	} 
}
