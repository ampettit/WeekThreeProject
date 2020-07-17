import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mCode {
/*	public static void main(String[] args) {
		MorseCodeTree mtree = new MorseCodeTree();
		
		readTree(mtree);
		
		Scanner scrn = new Scanner(System.in);
		
		String choice = scrn.next();
		char[] choice_arr = choice.toCharArray();
		if (choice.contains('.')) {
			
		}
		for (int i=0; i < choice_arr.length; ++i) {
			
		}
		
		System.out.print(mtree.getCode('a'));
		System.out.print(mtree.getLetter("..-"));
		
	}
	
	private static void readTree(MorseCodeTree mtree) {
		Scanner scnr = null;
		try {
			scnr = new Scanner(new File("Morse_Code.txt"));
		} catch(FileNotFoundException exception) {
			System.out.println("File not found");
		}
		while (scnr.hasNextLine()) {
			String data = scnr.nextLine().trim();
			if(data.length() > 0) {
				mtree.add(data.charAt(0), data.substring(1).trim());
			}
		}
		scnr.close();
	}
	*/
	
	private static void readTree(MorseCodeTree mtree) {
		Scanner scnr = null;
		try {
			scnr = new Scanner(new File("Morse_Code.txt"));
		} catch(FileNotFoundException exception) {
			System.out.println("File not found");
		}
		while (scnr.hasNextLine()) {
			String data = scnr.nextLine().trim();
			if(data.length() > 0) {
				mtree.add(data.charAt(0), data.substring(1).trim());
			}
		}
		scnr.close();
	}
	
	public static void main(String[] args){
		MorseCodeTree mtree = new MorseCodeTree();
	
		readTree(mtree);
	
		Scanner scnr = new Scanner(System.in);
	
		System.out.println("What would you like to be translated? \n");
//		String choice = scnr.next();
		

/*		if(choice.contains("-") || choice.contains(".")){
			for(int i = 0; i < choice.length() - 1; i++){
				System.out.println(choice);
    			System.out.println(mtree.getLetter("..-"));
			}
		}
		else{
			for(int i = 0; i < choice.length() - 1; i++){
    			System.out.println(mtree.getCode('a'));
			}
		}
*/		
		System.out.print("Code == ");
		System.out.println(mtree.getLetter("..-"));
		System.out.print("Letter == ");
		System.out.println(mtree.getCode('u'));
		
		scnr.close();
	}
}