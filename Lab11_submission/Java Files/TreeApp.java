
public class TreeApp {
	
	public static void main(String[] args) {
	    if(args.length != 3)
	    {
	        System.err.println("Proper Usage is as following: javaProgramFileName InputFileName OutputFileName1 OutputFileName2");
	        System.exit(0);
	    }
		Tree myTree = new Tree();
		FileManager fileManager = new FileManager(args, myTree);
		fileManager.loadData();

		System.out.println("\nCalling in-order traversal\n");
		myTree.inOrderTraverse(myTree.getRoot());
		
		System.out.println("\nCalling Breadth-First traversal\n");
		myTree.breadthFirst(myTree.getRoot());

		// Method to generate the above to operation to output file
		fileManager.generateOutput();
		System.out.println("\n\n**********Program has ended****************\n\n");
	}
	


}
