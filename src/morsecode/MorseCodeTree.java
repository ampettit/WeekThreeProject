package morsecode;

public class MorseCodeTree {
	/**
	 *	Morse Code Tree for storing Morse Code letters and to parse
	 *	tree to get Morse Code from letter or letter from Morse Code
	 */
    private class Node {
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
    private Node root = new Node();

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
    		// If this is the last dot or dash then set the letter in the Node
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
    		} 
    		// If not the last dot or dash continue down the tree
    		else {
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
    
    public char getLetter(String code) {
    	/**
    	 * Parse Tree to find the letter from the code
    	 * 
    	 * @param: String	Morse code to find the equivalent letter
    	 * @return: char	return letter found in tree
    	 */
    	// split passed String into a Char Array
    	char[] dotOrDash = code.toCharArray();
    	// create a copy of root to use for moving through the Nodes
    	Node current = root;
    	
    	/**
    	 * Loop through Tree looking for letter based on the given String
    	 */
    	for(int i=0; i < dotOrDash.length; ++i) {
    		// At the last dot or dash return the letter
    		if (i == dotOrDash.length - 1) {
    			switch(dotOrDash[i]) {
        		case('.'):
        			return current.left.letter;
    			case('-'):
    				return current.right.letter;
    			}
    		} else {  // If not the last dot or dash continue through Nodes
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
    	// Return a space if nothing is found
    	return ' ';
    }
    
    public String getCode(char letter) {
    	/**
    	 * Wrapper for the method to look for the code that corresponds to the
    	 * given letter
    	 * 
    	 * @param: char		the letter to get the code conversion for
    	 * @return: String	the code conversion
    	 */
    	String search = getCode(root, letter, new String());
    	// If the String returned is not empty then return the String
    	if (!search.equals("")) { return search; }
    	// If the String is empty then return this String
    	return "";
    }
    
    private String getCode(Node current, char letter, String morsecode) {
    	/**
    	 * Recursive method to search the MorseCodeTree for the given letter then
    	 * return the proper code sequence
    	 * 
    	 * @param: Node		The current Node to check
    	 * @param: char		The letter searching for
    	 * @param: String	the code for the current Node
    	 * 
    	 * @return: String	If letter is found return the code
    	 */
    	// Create an empty String to return if letter is not matched
    	String ret_code = "";
    	// If the letter at the current Node matches the one being serched for
    	// then return the current code conversion
    	if (current.letter == letter) {
    		ret_code = morsecode;
    	} else {  // If no match then continue searching
    		// If there is a left branch search it for a match
    		if (current.left != null) {
    			// Store recursive call into a temp String
    			String temp = getCode(current.left, letter, morsecode.concat("."));
    			// If the returned String is not empty then return the code
    			if (!temp.isEmpty()) { ret_code = temp; }
    		}
    		// If there is a right branch search it for a match
    		if (current.right != null) {
    			// Store recursive call into a temp String
    			String temp = getCode(current.right, letter, morsecode.concat("-"));
    			// If the returned String is not empty then return the code
    			if (!temp.isEmpty()) { ret_code = temp; }
    		}
    	}
    	// return the ret_code String
    	return ret_code;
    }
}