public class AverageCalculator {
	
	public static void main ( String [] args) {
	
		double sumOfNumbers = 0;
		
		for (int i = 0; i <args.length; i++)
		{
			double x = Double.parseDouble(args[i]);
			sumOfNumbers = x + sumOfNumbers;
		
		}
		
		double average = sumOfNumbers/args.length;
		
		System.out.print("The 4 numbers are: ");
		
		for (int i = 0; i <args.length; i++) 
		{
			System.out.print(args[i] + " ");
		}
		System.out.println(" ");
		System.out.print("and their average is: ");
		System.out.printf("%2.3f", average);
		System.out.println();
		
	}
}