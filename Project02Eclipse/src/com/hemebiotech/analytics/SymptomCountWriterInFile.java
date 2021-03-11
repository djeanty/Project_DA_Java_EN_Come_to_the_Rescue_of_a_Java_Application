package com.hemebiotech.analytics;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

/**
 * This class handles the output file (creates, writes and reads).
 * 
 * @author dj
 *
 */
public class SymptomCountWriterInFile {
	File file;
	
	/**
	 * Create a file with a given name.
	 * @param fileName the name of the file.
	 */
	public SymptomCountWriterInFile(String fileName) {
		try {
			file = new File(fileName);
			if (file.createNewFile()) {
				System.out.println("File created");
			} else {
				System.out.println("File already created");
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Writes a String to the file.
	 * @param counterToString The string to write into the file.
	 */
	public void writeCounterToFile(String counterToString) {
		try {
			FileWriter myWriter = new FileWriter(file);
			myWriter.write(counterToString);
			myWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
