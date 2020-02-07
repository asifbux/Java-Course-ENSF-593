
import java.io.*;

public class Sums {

    public static void sum(BufferedReader in, int mySum){ 
        // takes a sequence of integers as inputs, and outputs their sum

	int s;
	int nextInt;
	s = mySum;
	if(s == 0) {
		System.out.println("Please input the sequence of integers to sum, terminated by a 0");
	}

	try {
        nextInt = Integer.parseInt(in.readLine());
                //Read next datum in input. An integer is expected
        while (nextInt!=0) {
    	    s = s + nextInt;
    	    nextInt = Integer.parseInt(in.readLine());
    	}
        System.out.println("The sum is " + s);
	}
	catch (NumberFormatException e) {
		System.out.println("Invalid number. Please reenter.");
		sum(in, s);
	}
	catch(IOException e) {
		System.out.println("Invalid number. Please reenter");
		sum(in, s);
	}
    }

    public static void main(String[] arg) {         

	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                         //"in" will receive data from the standard input stream
	String c;
 
	System.out.println("Do you wish to calculate a sum? (y/n)");
	try {
	c = in.readLine();
         //Read next datum in input. A string "y" or "n" is expected

	while (!c.equals("y") && !c.equals("n")) {
	    System.out.println("Please answer y or n");
	    c = in.readLine();
	}

	while (c.equals("y")) {
	    sum(in, 0);
	    System.out.println("Do you wish to calculate another sum? (y/n)");
	    c = in.readLine();

	    while (!c.equals("y") && !c.equals("n")) {
		System.out.println("Please answer y or n");
		c = in.readLine();
	    }
	}
	}
	catch (NumberFormatException e) {
		System.out.println(e.getMessage());
	}
	catch(IOException e) {
		System.out.println(e.getMessage());
	}

	System.out.println("Goodbye");
    }
}
