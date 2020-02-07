import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManager {
	
	private String filename;
	private String output1;
	private String output2;
	private PrintStream outputStream;
	private Tree myTree;
	
	public FileManager(String args[], Tree myTree) {
		filename = args[0];
		output1= args[1];
		output2 = args[2];
		this.myTree = myTree;
	}
	
	public void loadData() {

        try{
            Scanner sc = new Scanner(new FileReader(filename));

            while(sc.hasNextLine()) {
            	String line = sc.nextLine();
            	String firstLetter = line.split("")[0];
            	String name = line.split("([0-9]+)")[1].replaceAll("\\s+","");
            	if(firstLetter.equals("I")) {
            		// check for no duplicate student with same id
            		if(myTree.search(myTree.getRoot(),name) == null) {
                    	myTree.insert(createStudent(line));
            		}
            		else
            		{
            			System.err.println("Insert Requested for " + myTree.search(myTree.getRoot(), name) + " who is already in the system");
            		}
            	}
            	else if(firstLetter.equals("D")) {
            		// generate that student object
            	
            		if(myTree.search(myTree.getRoot(), name) != null) {
            			myTree.delete(myTree.getRoot(), name);
            			System.out.println(name + " deleted");
            		}
            		else {
            			System.err.println("Delete Requested for a student with Name: " + name + " that is not in the system.");
            		}
            	} 
            }
            System.out.println("Binary Search Tree has been created from the input file " + filename + "\n");
            sc.close();
        }
        catch(FileNotFoundException e) { 
        	System.err.println("File not Found!");
        	System.exit(0);}
        catch(Exception e) { e.printStackTrace(); }
    }
	public Student createStudent(String line) {
		int id = Integer.parseInt(line.split("([A-Za-z]+)")[1]);//line.split("\\d{7}")[0]); // ([0-9]+)
		String name = line.split("([0-9]+)")[1].replaceAll("\\s+","");
		int dept = Integer.parseInt(line.split("([A-Za-z]+)")[2].replaceAll("\\s+",""));
		String program = line.split("([0-9]+)")[2].replaceAll("\\s+","");
		int year = Integer.parseInt(line.split("([A-Za-z]+)")[3].replaceAll("\\s+",""));
		return new Student(name, id, dept, program, year);
	}
	
	public void generateOutput() {
		System.out.println("\n\nGenerating output files: " + output1 + "  " + output2 + "\n");
		try
		{
		outputStream = new PrintStream(output1);
		outputStream.println("*****Depth-first, in-order tree traversal******* \n\n");
		myTree.inOrderTraverse(myTree.getRoot(), outputStream);
		outputStream.close();
		outputStream = new PrintStream(output2);
		outputStream.println("*****Breadth-first Traversal******* \n\n");
		myTree.breadthFirst(myTree.getRoot(), outputStream);
		outputStream.close();
		} 
		catch(FileNotFoundException e) 
		{
			System.err.println("Error generating the output file" );
			System.exit(0);
		}
		
	}
}
