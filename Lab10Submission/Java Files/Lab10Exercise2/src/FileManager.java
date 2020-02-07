

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Reads the input file. 
 * 
 * @author A. Fardi
 * @version 1
 * @since November 18, 2019
 *
 */
public class FileManager {
		/** BufferedReader object type for reading files. */
		BufferedReader br;
		BufferedWriter bw;
		
		/**
		 * Open file.
		 *
		 * @param filename the filename
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public void openFile(String filename) throws IOException {
			br = new BufferedReader(new FileReader(filename));
		}
		
		/**
		 * Reads the input file.
		 *
		 * @param filename the filename
		 * @return arr the object array
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public ObjectArrayList readInputFile(String filename) throws IOException {
			openFile(filename);
			String line = null;
			ObjectArrayList arr = new ObjectArrayList();
			while ((line = br.readLine()) != null) {
				String input = line.strip();
				arr.addElement(new AnagramNode(line.strip()));
			}
			br.close();
			return arr;
		}
		/**
		 * Writes to file
		 * @param arr
		 * @param filename
		 * @throws IOException
		 */
		public void writeOutputFile(ObjectArrayList arr, String filename) throws IOException {
		    bw = new BufferedWriter(new FileWriter(filename + ".txt"));
		    for(int i=0; i<arr.getLength(); i++)
		    	bw.write(arr.getElement(i) +"\n");
		    bw.close();
		    File file = new File(filename + ".txt");
		    System.out.println("Wrote file to " + file.getAbsolutePath());
		}
	}

