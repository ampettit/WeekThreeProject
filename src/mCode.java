import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mCode {
	
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
		String choice = scnr.nextLine().trim();
		

		if(choice.contains("-") || choice.contains(".")){
			String[] choice_split = choice.split(" ");
			for(int i = 0; i < choice_split.length; i++){
    			System.out.print(mtree.getLetter(choice_split[i]));
			}
		}
		else{
			for(int i = 0; i < choice.length(); i++){
    			System.out.print(mtree.getCode(choice.charAt(i)) + " ");
			}
		}

		scnr.close();
	}
}