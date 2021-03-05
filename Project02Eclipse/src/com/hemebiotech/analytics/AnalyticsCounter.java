package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

/**
 * Reads a file with symptoms, counts them and print the total of each of these
 * symptoms.
 * 
 * @author Damien Jeanty
 *
 */
public class AnalyticsCounter {

	/**
	 * Reads the file path of the symptoms's file and calls another method that will
	 * count the symptoms.
	 * 
	 * @param args if not empty, it is the symptoms file path.
	 */
	public static void main(String args[]) {

		// If we don't give a file path as an argument, we need to read one.
		if (args.length == 0) {
			countSymptoms(pathOfFile());
		} else {
			countSymptoms(args[0]);
		}
		// printSymptoms();
		// TODO : use my class Symptom to store the TreeMap.
	}

	/**
	 * Reads a String that will be used as the path, from the Scanner.
	 * 
	 * @return the path of the file
	 */
	public static String pathOfFile() {
		System.out.println("Please enter the path of your file");
		Scanner sc = new Scanner(System.in);
		String filePath = sc.nextLine();
		sc.close();
		return filePath;
	}

	/**
	 * Counts the frequency of each symptoms in a list of symptoms.
	 * 
	 * @param filePath the path of the file
	 * @return a map with the key being the symptom and the value its frequency
	 */
	public static Map<String, Integer> countSymptoms(String filePath) {

		ReadSymptomDataFromFile fileReader = new ReadSymptomDataFromFile(filePath);
		List<String> symptomList = fileReader.GetSymptoms();

		// We'll go through the list of symptoms.
		Map<String, Integer> symptoms = new TreeMap<String, Integer>();
		for (int i = 0; i < symptomList.size(); i++) {

			// In case the symptom has been seen
			if (symptoms.containsKey(symptomList.get(i))) {
				// We need to increment the value of the key.
				int valueOfKey = symptoms.get(symptomList.get(i));
				valueOfKey++;
				// And replace it in the map
				symptoms.replace(symptomList.get(i), valueOfKey);
			}
			// In case the symptom has not been seen
			else {
				symptoms.put(symptomList.get(i), 1);
			}
		}
		System.out.println(symptoms);
		return symptoms;
	}

	public static void printSymptoms(Map<String, Integer> symptoms) {
		System.out.println(symptoms);
	}
}
