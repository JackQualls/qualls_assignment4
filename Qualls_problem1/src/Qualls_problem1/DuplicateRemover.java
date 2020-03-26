package Qualls_problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
public class DuplicateRemover {
	HashSet <String> uniqueWords = new HashSet<>();

	public void remove(String dataFile) {
		File inputFile = new File(dataFile);
		try {
			Scanner fileIn = new Scanner(inputFile);
			while(fileIn.hasNextLine()) {
				String lineString = fileIn.nextLine().toLowerCase();
				String [] words = lineString.split(" ");
				for(String word: words) {
					uniqueWords.add(word);
					
				}
			}
		fileIn.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Could not print file");
		}
		
		
	}
	//----------------------------------------------------------
	public void write(String outputFile) {
		File fileOut = new File (outputFile);
		try {
			fileOut.createNewFile();
			FileWriter fw = new FileWriter(fileOut);
			for(String word: uniqueWords) {
				fw.write(word);
				fw.write("\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Could not print file");
		}
		
		
	}
	
	
}
