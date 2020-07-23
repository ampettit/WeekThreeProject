package morsecode;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mCode {
	
	private static void readTree(MorseCodeTree mtree) {
		/**
		 * Read in morse code from file and add to MorseCodeTree
		 * 
		 * @param: MorseCodeTree	The tree storing the morsecode
		 */
		// Scanner for reading file
		Scanner scnr = null;
		// try to open file - if not found catch file not found exception
		try {
			scnr = new Scanner(new File("Morse_Code.txt"));
		} catch(FileNotFoundException exception) {
			System.out.println("File not found");
		}
		// Read in each line from file and add to MorseCodeTree
		while (scnr.hasNextLine()) {
			String data = scnr.nextLine().trim();
			if(data.length() > 0) {
				mtree.add(data.charAt(0), data.substring(1).trim());
			}
		}
		scnr.close();
	}
	
	public static void main(String[] args){
		/**
		 * Main program
		 */
		MorseCodeTree mtree = new MorseCodeTree();
		
		// call readTree method
		readTree(mtree);
		
		// Scanner to get input from user
		Scanner scnr = new Scanner(System.in);
		
		// Display question and get input from user
		System.out.println("What would you like to be translated?");
		System.out.println("Enter either lowercase letters or Morse code. \n");
		String choice = scnr.nextLine().trim();
		
		// If there is a . or - in the input string do code to letter conversion
		if(choice.contains("-") || choice.contains(".")){
			String[] choice_split = choice.split(" ");
			for(int i = 0; i < choice_split.length; i++){
    			System.out.print(mtree.getLetter(choice_split[i]));
			}
		}
		// Otherwise do letter to code conversion
		else{
			for(int i = 0; i < choice.length(); i++){
    			System.out.print(mtree.getCode(choice.charAt(i)) + " ");
			}
		}

		scnr.close();
	}
}