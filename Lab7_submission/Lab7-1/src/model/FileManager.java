package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class FileManager.
 * @author Asif Bux
 * @version 1.0
 * @since November 5, 2019
 */
public class FileManager {
	
	/** The file path. */
	String filePath = "/Users/computer/Desktop/ensf593/Java/Lab7-1/src/model/";
	
	/**
	 * Instantiates a new file manager.
	 */
	public FileManager() {
		
	}
	
   /**
    * Read file.
    *
    * @param fileName the file name
    * @return the bin search tree
    */
   public BinSearchTree readFile(String fileName) {
	   
	   fileName = filePath + fileName;
       BinSearchTree binSearchTree = new BinSearchTree();
       String line = null;
       ArrayList<String> arrayList = new ArrayList<String>();
       
       try {
           FileReader fileReader = new FileReader(fileName);
           BufferedReader bufferedReader = new BufferedReader(fileReader);
           while((line = bufferedReader.readLine()) != null) {
               ArrayList<String> list = removeSpaces(line);
               binSearchTree.insert(list.get(0), list.get(1),list.get(2), list.get(3));
               System.out.println(binSearchTree.root.data);
           }
           bufferedReader.close();
       }
       catch(FileNotFoundException ex) {
           System.out.println("Unable to open file '" + fileName + "'");
       }
       catch(IOException ex) {
           System.out.println("Error reading file '" + fileName + "'");
       }
       return binSearchTree;
   }
   
   /**
    * Removes the spaces.
    *
    * @param arg the arg
    * @return the array list
    */
   public ArrayList<String> removeSpaces(String arg) {
       String[] someArray =  arg.split(" ");
       ArrayList<String> resultArray = new ArrayList<String>();
       for (int i = 0; i < someArray.length; i++){
           if(!someArray[i].isEmpty()) {
               resultArray.add(someArray[i]);
           }
       }
       return resultArray;
   }
}