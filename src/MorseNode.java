public class MorseNode {
 
    /** a letter of the alphabet */
    private char letter;
    /** reference to the left child */
    private MorseNode left;
    /** reference to the right child */
    private MorseNode right;
    /** value of letter if empty (not set) */
    public static final char EMPTY = ' ';

    public MorseNode() {
        letter = EMPTY;
        left = null;
        right = null;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public MorseNode getLeft() {
        return left;
    }

    public void setLeft(MorseNode left) {
        this.left = left;
    }

    public MorseNode getRight() {
        return right;
    }
 

    public void setRight(MorseNode right) {
        this.right = right;
    }
 
}