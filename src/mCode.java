import java.io.*;
import java.util.*;

public class mCode implements mCodeInterface {
	private MorseNode root;
	
	public mCode() {
		root = new MorseNode();
		readTree();
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
				add(data.substring(1).trim(), data.charAt(0));
			}
		}
		scnr.close();
	}
	
	private void add(String code, char letter) {
		MorseNode current = root;
		String signal = " ";
		
		for (int i = 0; i < code.length(); i++) {
            signal = code.substring(i, i + 1);
            if (signal.equals(".")) {
                if (current.getLeft() != null) {
                    current = current.getLeft();
                } else {
                    current.setLeft(new MorseNode());
                    current = current.getLeft();
                }
            } else {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else {
                    current.setRight(new MorseNode());
                    current = current.getRight();
                }
            }
        }
        current.setLetter(letter);
    }
	
	private void printInorder(MorseNode current) {
		if(current != null) {
			printInorder(current.getLeft());
			System.out.println(current.getLetter());
			printInorder(current.getRight());
		}
	}
	public String decode(String str) {
        String signal = "";
        StringBuffer result = new StringBuffer("");
        MorseNode current = root;
         
        for (int i = 0; i < str.length(); i++) {
            signal = str.substring(i, i + 1);
            if (signal.equals(".")) {
                if (current.getLeft() != null) {
                    current = current.getLeft();
                } else {
                    current.setLeft(new MorseNode());
                    current = current.getLeft();
                }
            } else if (signal.equals("-")) {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else {
                    current.setRight(new MorseNode());
                    current = current.getRight();
                }
            } else {
                result = result.append(current.getLetter());
                current = root;
            }
        }
        result = result.append(current.getLetter());
 
        return result.toString();
    }
	public String encode(String str) {
        MorseNode current = root;
        String result = "";
        String s = "";
        char ltr;
         
        for (int i = 0; i < str.length(); i++) {
            ltr = str.charAt(i);
            result = searchTree(current, ltr, s);
            }
        return result;
    }
	public String searchTree(MorseNode current, char ltr, String s) {
        char temp = current.getLetter();  //for debugging purposes
 
        if (current.getLetter() == ltr) { 
            return s;
        } else {
            if (current.getLeft() != null) {
                return searchTree(current.getLeft(), ltr, s + ".");
            }
            if (current.getRight() != null) {
                return searchTree(current.getRight(), ltr, s + "-");
            }       
            return s;
        }
    }
	@Override
	public void inOrderPrint() {
		MorseNode current = root;
		printInorder(current);
		
	}
}
