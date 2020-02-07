import java.util.Scanner;

public class CharArray {


	public static void main (String [] args) {
		
		char [][] myArray = new char[3][60];
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter your first sentence (must be less than 60 characters, including spaces and special characters):");
		String firstString = keyboard.nextLine();
		firstString = exceedChar(firstString);
		System.out.print("The first sentence is: ");
		reverseLetter(firstString, myArray);
		System.out.println("");
		
		System.out.println("Enter your second 60 character?");
		String secondString = keyboard.nextLine();
		secondString = exceedChar(secondString);
		System.out.print("The second sentence is: ");
		reverseWord(secondString, myArray);
		System.out.println("");
		
		System.out.println("Enter your third 60 character?");
		String thirdString = keyboard.nextLine();
		thirdString = exceedChar(thirdString);
		System.out.print("The third sentence is: ");
		upperCase(thirdString, myArray);
		System.out.println("\n");
	
		System.out.println("The final 3 x 60 array is as following:");
		for(int i = 0; i < 1; i++)
		    for(int j = 0; j < 60; j++)
		        System.out.print(myArray[i][j]);
		System.out.println("");
		
		for(int i = 1; i < 2; i++)
		    for(int j = 0; j < 60; j++)   	
		        System.out.print(myArray[i][j]);
		System.out.println("");
		
		for(int i = 2; i < 3; i++)	
		    for(int j = 0; j < 60; j++)
		        System.out.print(myArray[i][j]);
		System.out.println("");
		
		keyboard.close();
	}
		

	public static char[][] reverseLetter(String sentence, char[][] myArray) {
		
		char[] array = sentence.toCharArray();
		String result = "";
		for ( int column = array.length -1; column >= 0; column--) {
			result = result + array[column];
			}
		for (int i = 0; i < array.length; i++) {
			myArray[0][i] = result.toCharArray()[i];
			System.out.print(myArray[0][i]);
			}
		return myArray;
	}
	

	public static char[][] reverseWord(String sentence, char[][] myArray) {
		int wordEnd = sentence.length() -1;
		int wordStart;
		int j = 0;
		for ( int i = sentence.length() - 1; i >=0; i--) {
			if (sentence.charAt(i) == ' ') {
				wordStart = i + 1;
				while (wordStart <= wordEnd) {
					myArray[1][j] = sentence.charAt(wordStart);
					wordStart++;
					j++;
				}
			wordEnd = i - 1;
			myArray[1][j] = sentence.charAt(i);
			j++;
			}
		}	
		for (int i = 0; i <= wordEnd; i++) {
			myArray[1][j] = sentence.charAt(i);
			j++;
		}
			
		for (int i = 0; i < 60; i++) {
			System.out.print(myArray[1][i]);
		} 
		System.out.println("");
		return myArray;
	}
	
	public static char[][] upperCase(String sentence, char[][] myArray) {
		char[] array = sentence.toCharArray();
		for (int i =0; i < sentence.length(); i++) {
			if (i % 5 == 0) {
				array[i] = Character.toUpperCase(sentence.charAt(i));
			}
		}
		for (int i = 0; i < array.length; i++) {
			myArray[2][i] = array[i];
			System.out.print(myArray[2][i]);
			}
		System.out.println("");
		return myArray;
	}

	public static String exceedChar(String sentence) {
		
		while (sentence.length() > 60) {
			System.out.println("Please enter less than 60 characters (including special characters or spaces)");
			Scanner keyboard = new Scanner(System.in);
			sentence = keyboard.nextLine();
			}
		System.out.println("");
		return sentence;
	}
}