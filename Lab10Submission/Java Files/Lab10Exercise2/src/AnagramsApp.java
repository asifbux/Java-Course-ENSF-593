

import java.io.IOException;
import java.util.Arrays;


public class AnagramsApp {
	public static void main(String[] args) {
		FileManager fm = new FileManager();
		ObjectArrayList words = new ObjectArrayList();
		Long start = System.nanoTime();
		try {
			words = fm.readInputFile(args[0]);
		} 
		catch (IOException e) {
			System.err.println("Could not read input file!");
		}
		ObjectArrayList linkedLists = new ObjectArrayList();
		
		//Loop through the list of words, and find anagrams for the current word in outer loop (curr).
		//If anagrams are found, remove the word from words list, and add the word to a new linked list which has curr as the head.
		for(int i=0; i<words.getLength(); i++) {
			AnagramNode curr = (AnagramNode) words.getElement(i);
			AnagramLinkedList linkedList = new AnagramLinkedList();
			linkedList.insertToEndOfList(curr);
			for(int j=i+1; j<words.getLength(); j++) {
				AnagramNode next = (AnagramNode) words.getElement(j);
				if(isAnagram(curr, next)) {
					linkedList.insertInOrder(next);
					words.removeAt(j);
					j--; //decrement j every time a word is removed to avoid skipping elements in the list
				}
			}
			linkedLists.addElement(linkedList);
		}
		linkedLists.quickSort(0, linkedLists.getLength()-1);
		Long end = System.nanoTime();
		try {
			fm.writeOutputFile(linkedLists, args[1]);
		} catch (IOException e) {
			System.err.println("Could not print file!");
		}
		System.out.println("Time for processing input: " + String.valueOf(end-start));
	}

	private static boolean isAnagram(AnagramNode an1, AnagramNode an2) {
		if(sortWord(an1).equalsIgnoreCase(sortWord(an2)))
			return true;
		return false;
	}

	private static String sortWord(AnagramNode an1) {
		char[] chars= an1.getWord().toCharArray();
		for(int i=0; i<chars.length; i++) {
			char temp = chars[i];
			int j = i;
			while(j>0 && temp<chars[j-1]) {
				chars[j] = chars[j-1];
				j -= 1;
			}
			chars[j] = temp;
		}
		return new String(chars);
	}
}
