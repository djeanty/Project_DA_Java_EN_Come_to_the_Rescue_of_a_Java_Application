package com.hemebiotech.analytics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * A SymptomCount represents a map of a symptom (String) and the amount of times it has been seen (Integer).
 * 
 * @author dj
 *
 */
public class SymptomCount {
	
	private Map<String, Integer> symptomsMap = new TreeMap<String, Integer>();
	
	/* TODO: Possibility to upgrade the code :
	 * If the output file already exists, read it and use it as a base for the map.
	*/
	
	/**
	 * Creates an instance of SymptomCount from a filePath.
	 * @param filePath the file path to read the symptoms from.
	 */
	public SymptomCount(String filePath) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();
			
			line = reader.readLine();
			
			while (line != null && line != "") {
				if (symptomsMap.containsKey(line)) {
					symptomsMap.replace(line, symptomsMap.get(line)+1);
				} else {
					symptomsMap.put(line, 1);
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("Symptom file at the path : "+filePath+" not found.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Counts the frequency of each symptoms in a list of symptoms.
	 * 
	 * @param filePath the path of the file
	 */
	/*
	public void countSymptoms(String filePath) {

		ReadSymptomDataFromFile fileReader = new ReadSymptomDataFromFile(filePath);
		List<String> symptomList = fileReader.GetSymptoms();

		
		// TODO: Create a map from the existing output file or create a new one.
		// We'll go through the list of symptoms.
		//symptomsMap = new TreeMap<String, Integer>();
		for (int i = 0; i < symptomList.size(); i++) {

			// In case the symptom has been seen
			if (symptomsMap.containsKey(symptomList.get(i))) {
				// We need to increment the value of the key.
				int valueOfKey = symptomsMap.get(symptomList.get(i));
				valueOfKey++;
				// And replace it in the map
				symptomsMap.replace(symptomList.get(i), valueOfKey);
			}
			// In case the symptom has not been seen
			else {
				symptomsMap.put(symptomList.get(i), 1);
			}
		}
		//writeSymptoms("output.txt", symptomsToString(symptomsMap));
		
	}
	*/
	/**
	 * Creates a String from a TreeMap
	 * 
	 * @return the string created
	 * @override
	 */
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
	 * Write symptoms inside a File
	 * 
	 * @param fileName the name of the file 
	 * @param whatToWrite the symptoms to write
	 */
	public static void writeSymptoms(String fileName, String whatToWrite) {
		SymptomCountWriterInFile scwinf = new SymptomCountWriterInFile(fileName);
		scwinf.writeCounterToFile(whatToWrite);
	}

}