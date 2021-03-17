package com.hemebiotech.analytics;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

/**
 * Creates a file and writes a SymptomCount to it.
 * @author Damien Jeanty
 */
public class SymptomCountWriterInFile {
	File file;
	
	/**
	 * Creates a file with a given name and prints the result of this action to System.out (the file has been created successfully or already exists).   
	 * 
	 * @param fileName the name of the file to create
	 */
	public SymptomCountWriterInFile(String fileName) {
		try {
			file = new File(fileName);
			if (file.createNewFile()) {
				System.out.println("File created: results.out");
			} else {
				System.out.println("File results.out already created, it will be overwritten.");
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Writes the String version of a SymptomCount to this file.
	 * 
	 * @param counterToString the SymptomCount to write to this file
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
