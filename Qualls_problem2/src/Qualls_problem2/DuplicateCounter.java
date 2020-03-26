package Qualls_problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
public class DuplicateCounter {
	HashMap <String, Integer> wordCounter = new HashMap<>();

	public void count (String dataFile) {
		File inputFile = new File(dataFile);
		try {
			Scanner fileIn = new Scanner(inputFile);
			while(fileIn.hasNextLine()) {
				String lineString = fileIn.nextLine().toLowerCase();
				String [] words = lineString.split(" ");
				for(String word: words) {
					if(wordCounter.containsKey(word)) {
						wordCounter.put(word, wordCounter.get(word)+1);
					}
					else {
						wordCounter.put(word, 1);
					}
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
			for(Entry<String, Integer> entry : wordCounter.entrySet()) {
			    String word = entry.getKey();
			    int count = entry.getValue();
			    fw.write(word+" "+count);
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
