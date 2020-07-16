import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class MorseCodeTree {
	/**
	 * 
	 * @author rnjmur
	 * 
	 *	Morse Code Tree for storing Morse Code letters and to parse
	 *	tree to get Morse Code from letter or letter from Morse Code
	 */
	public static Scanner scnr = new Scanner(System.in);
    private static class Node {
    	/** a letter of the alphabet */
        public char letter = '\0';
        /** reference to the left child */
        public Node left;
        /** reference to the right child */
        public Node right;
        
        public Node() { }  // Default constructor
        /** Constructor with letter to add */
        public Node(char letter) { this.letter = letter; }
    }
    /** set root node to empty */
    public static Node root = new Node();
    
    /** value of letter if empty (not set) */
    public static final char EMPTY = ' ';

    public MorseCodeTree() { }  // Default Constructor
    
    public void add(char letter, String code) {
    	/**
    	 * Add an entry to the Tree based on the Morse code passed in
    	 * 
    	 * @param: char		The letter to add into the tree
    	 * @param: String	The morse code to use for placing the letter into the tree
    	 */
    	char[] dotOrDash = code.toCharArray();
    	Node current = root;
    	
    	/** 
    	 * Loop through Tree until finding proper place for letter based on
    	 * the code
    	 */
    	for(int i=0; i < dotOrDash.length; ++i) {
    		if (i == dotOrDash.length - 1) {
    			switch(dotOrDash[i]) {
        		case('.'):
        			if (current.left == null) { current.left = new Node(letter); }
        			else { current.left.letter = letter; }
        			break;
    			case('-'):
    				if (current.right == null) { current.right = new Node(letter); }
        			else { current.right.letter = letter; }
    				break;
    			}
    		} else {
    			switch(dotOrDash[i]) {
        		case('.'):
        			if (current.left == null) { current.left = new Node(); }
        			current = current.left;
        			break;
    			case('-'):
    				if (current.right == null) { current.right = new Node(); }
    				current = current.right;
    				break;
    			}
    		}
    	}
    }
    
    public static char getLetter(String code) {
    	/**
    	 * Parse Tree to find the letter from the code
    	 * 
    	 * @param: String	Morse code to find the equivalent letter
    	 * @return: char	return letter found in tree
    	 */
    	char[] dotOrDash = code.toCharArray();
    	Node current = root;
    	
    	/**
    	 * Loop through Tree looking for letter based on the given String
    	 */
    	for(int i=0; i < dotOrDash.length; ++i) {
    		if (i == dotOrDash.length - 1) {
    			switch(dotOrDash[i]) {
        		case('.'):
        			return current.left.letter;
    			case('-'):
    				return current.right.letter;
    			}
    		} else {
    			switch(dotOrDash[i]) {
        		case('.'):
        			current = current.left;
        			break;
    			case('-'):
    				current = current.right;
    				break;
    			}
    		}
    	}
    	return ' ';
    }
    
    public static String getCode(char letter) {
    	String leftSearch = getCode(root.left, letter, new String("."));
    	if (leftSearch != null) { return leftSearch; }
    	String rightSearch = getCode(root.right, letter, new String("-"));
    	if (rightSearch != null) { return rightSearch; }
    	return null;
    }
    
    private static String getCode(Node current, char letter, String morsecode) {
    	if (current.letter == letter) {
    		return morsecode;
    	} else {
    		if (current.left != null) {
    			getCode(current.left, letter, (morsecode.concat(".")));
    		}
    		else if (current.right != null) {
    			getCode(current.right, letter, (morsecode.concat("-")));
    		}
    	}
    	return null;
    }

	private void readTree() {
			Scanner scnr = null;
			try {
				scnr = new Scanner(new File("Morse_Code.txt"));
			} catch(FileNotFoundException exception) {
				System.out.println("File not found");
			}
			while (scnr.hasNextLine()) {
				String data = scnr.nextLine().trim();
				if(data.length() > 0) {
					add(data.charAt(0), data.substring(1).trim());
				}
			}
			scnr.close();
		}
    public static void main(String[] args){
    		System.out.println("What would you like to be translated? \n");
    		String choice = scnr.next();
    		MorseCodeTree mtree = new MorseCodeTree();
    		if(choice.contains("-") || choice.contains(".")){
    			for(int i = 0; i < choice.length() - 1; i++){
        			System.out.println(MorseCodeTree.getLetter(choice));
    			}
    		}
    		else{
    			for(int i = 0; i < choice.length() - 1; i++){
        			System.out.println(MorseCodeTree.getCode(choice.charAt(i)));
    			}
    		}
    }
}