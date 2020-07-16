	/*
public class MorseCodeTree {

	 * 
	 * @author rnjmur
	 * 
	 *	Morse Code Tree for storing Morse Code letters and to parse
	 *	tree to get Morse Code from letter or letter from Morse Code

    private class Node {
    	/** a letter of the alphabet 
        public char letter = '\0';
         reference to the left child 
        public Node left;
        reference to the right child 
        public Node right;
        
        public Node() { }  // Default constructor
        /** Constructor with letter to add 
        public Node(char letter) { this.letter = letter; }
    }
    * set root node to empty 
    private Node root = new Node();
    
    value of letter if empty (not set) 
    public static final char EMPTY = ' ';

    public MorseCodeTree() { }  // Default Constructor
    
    public void add(char letter, String code) {
    	
    	 * Add an entry to the Tree based on the Morse code passed in
    	 * 
    	 * @param: char		The letter to add into the tree
    	 * @param: String	The morse code to use for placing the letter into the tree
    	 
    	char[] dotOrDash = code.toCharArray();
    	Node current = root;
    	
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
    
    public char getLetter(String code) {
    	char[] dotOrDash = code.toCharArray();
    	Node current = root;
    	
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
    
    public String getCode(char letter) {
    	String leftSearch = getCode(root.left, letter, new String("."));
    	if (leftSearch != null) { return leftSearch; }
    	String rightSearch = getCode(root.right, letter, new String("-"));
    	if (rightSearch != null) { return rightSearch; }
    	return null;
    }
    
    private String getCode(Node current, char letter, String morsecode) {
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
}	 
*/