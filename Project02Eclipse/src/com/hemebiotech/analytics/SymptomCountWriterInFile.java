package com.hemebiotech.analytics;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;


public class SymptomCountWriterInFile {
	File file;
	
	public SymptomCountWriterInFile(String fileName) {
		try {
			file = new File(fileName);
			if (file.createNewFile()) {
				System.out.println("File created");
			} else {
				System.out.println("File alread created");
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeInCountFile(String text) {
		try {
			FileWriter myWriter = new FileWriter(file);
			myWriter.write(text);
			myWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
