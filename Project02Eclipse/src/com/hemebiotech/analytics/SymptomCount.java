package com.hemebiotech.analytics;
import java.io.BufferedReader;
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
 */
public class SymptomCount {
	
	private Map<String, Integer> symptomsMap = new TreeMap<String, Integer>();
	
	/* TODO: Possibility to upgrade the code :
	 * If the output file already exists, read it and use it as a base for the map.
	*/
	
	// TODO: @bug if there are multiple line breaks in the symptoms.txt, it will be counted as one 
	
	/**
	 * Creates the map from a file of symptoms.
	 * @param filePath The file path to read the symptoms from. If the file at the given path has not been found, prints a message to the standard output.
	 */
	public SymptomCount(String filePath) {
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