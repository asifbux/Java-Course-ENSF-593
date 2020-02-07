import java.io.*;


public class FileManager {
	BufferedWriter bw;
	
	public void writeOutputFile(int[] arr, String filename) throws IOException {
	    bw = new BufferedWriter(new FileWriter(filename + ".txt"));
	    for(int i=0; i<arr.length; i++)
	    	bw.write(arr[i] +"\n");
	    bw.close();
	    File file = new File(filename + ".txt");
	    System.out.println("Wrote file to " + file.getAbsolutePath());
	}
}
