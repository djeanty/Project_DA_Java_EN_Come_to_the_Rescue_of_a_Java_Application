package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.Scanner;
import java.util.List;

public class AnalyticsCounter {
	
	/**
	 * Reads the file path of the symptoms's file and calls another method that will count the symptoms.
	 * @param args if not empty, it is the symptoms file path.
	 */
	public static void main(String args[]){
					
		// If we don't give a file path as an argument, we need to read one. 
		if (args.length == 0) {
			System.out.println("Please enter the path of your file.");
			Scanner sc = new Scanner(System.in);
			String filePath = sc.nextLine();
			sc.close();
			countSymptoms(filePath);
		} else {
			countSymptoms(args[0]);
		}
		// countSymptoms("/home/dj/git/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt");
		
	}

	/**
	 * Sort, count and prints the total of each symptoms in a given file.
	 * 
	 * @param filePath the path of the file
	 */
	public static void countSymptoms(String filePath) {
		ReadSymptomDataFromFile fileReader = new ReadSymptomDataFromFile(filePath);

		/*
		 * Sorting the list of symptoms
		 */
		List<String> symptomList = fileReader.GetSymptoms();
		Collections.sort(symptomList);

		String currentSymptom;
		int countCurrentSymptom = 1;

		for (int currentSymptomIndex = 0; currentSymptomIndex < symptomList.size() - 1; currentSymptomIndex++) {
			currentSymptom = symptomList.get(currentSymptomIndex);
				if (currentSymptom.equals(symptomList.get(currentSymptomIndex + 1))) {
					countCurrentSymptom++;
				} else {
					System.out.println(currentSymptom + " : " + countCurrentSymptom);
					countCurrentSymptom = 1;
				}
		}
	}
}
