import java.util.Scanner;
import java.util.ArrayList;

public class Exercise5 {
	
	public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> times = new ArrayList<>();

		// Define two array lists here to store the names and the running times
		// Read user input
		String sin;
		Scanner scan = new Scanner(System.in);
		while (true)
		{
			System.out.println("Please enter the name of the participant");
			sin = scan.nextLine();
			if(sin.toUpperCase().equals("QUIT")) {
					scan.close();
					break; 
			}
			names.add(sin);
			System.out.println("Please enter the running time of the participant");
			sin = scan.nextLine();
			times.add(Integer.parseInt(sin));
		}
		
		// Call the function findFastestRunner and pass the running times array list to it
		
		findFastestRunner(times);
		
		// Print the name of the fastestrunner to the console
		
		System.out.print("The fastest runner is: " +
		names.get(findFastestRunner(times)) + 
		" with running time of " + times.get(findFastestRunner(times)) + " min");
		
	}	
		public static int findFastestRunner(ArrayList<Integer> array) {
			int min = array.get(0);
			int lowest = 0;
			for ( int i = 1; i < array.size(); i++) 
			{
				if (min > array.get(i)) {
					min = array.get(i);
					lowest = i;
				}
			}
			return lowest;
			
		}
}
