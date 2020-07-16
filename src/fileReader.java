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
