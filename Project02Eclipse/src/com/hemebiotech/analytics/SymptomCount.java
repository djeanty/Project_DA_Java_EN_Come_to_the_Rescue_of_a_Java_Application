package com.hemebiotech.analytics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Reads a file that contains one String per line, the String being a Symptom.
 * Creates a TreeMap that is made of the symptom name (String) and the amount of times it has been seen (Integer).
 * @author Damien Jeanty
 *
 *
 */
public class SymptomCount {
	
	private Map<String, Integer> symptomsMap = new TreeMap<String, Integer>(); 
	
	/**
	 * Creates the map from a file of symptoms.
	 * @param filePath The file path to read the symptoms from. If the file at the given path has not been found, prints a message to the standard output.
	 */
	public SymptomCount(String filePath) {
		File output = new File("/home/dj/git/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/results.out");
		if (output.exists()) {
			useExistingOutputFile();
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();
			
			while (line != null) {
				// ignoring line breaks in the file
				if (!line.equals("")) {	
					// if the TreeMap contains the symptoms, increments its value.
					if (symptomsMap.containsKey(line)) {
						symptomsMap.replace(line, symptomsMap.get(line)+1);
					} else {
						symptomsMap.put(line, 1);
					}
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("Symptom file not found : "+filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * If there is an existing results.out file, uses it to implements symptomsMap.
	 * 
	 */
	public void useExistingOutputFile(){
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("/home/dj/git/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/results.out"));
			String line = reader.readLine();
			
			String[] myLine = new String[2];
			
			while (line != null) {
				if (!line.equals("")) {
					
					myLine = line.split(" : ");
					
					if (symptomsMap.containsKey(myLine[0])) {
						symptomsMap.replace(myLine[0], (Integer.parseInt(myLine[1])+1));
					} else {
						symptomsMap.put(myLine[0], Integer.parseInt(myLine[1]));
					}
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		String result = "";
		
		for(Map.Entry<String,Integer> symptom : symptomsMap.entrySet()) {
			
			  String key = symptom.getKey();
			  Integer value = symptom.getValue();
			  result = result + key+" : "+value+"\n";
			  
		}
		
		return result;
	}
	
	/**
	 * Uses the SymptomCountWriterInFile class to write this SymptomCount to a file.
	 * 
	 * @param fileName the name of the file
	 * @param symptomCounterToString the String version of this SymptomCounter
	 */
	public static void writeSymptoms(String fileName, String symptomCounterToString) {
		SymptomCountWriterInFile scwinf = new SymptomCountWriterInFile(fileName);
		scwinf.writeCounterToFile(symptomCounterToString);
	}

}