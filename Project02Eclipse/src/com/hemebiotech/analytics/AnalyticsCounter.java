package com.hemebiotech.analytics;
import java.util.Collections;
import java.util.List;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		
		/*
		 * The main Method should just be to enter the file of the symptoms.
		 * It should call another method that does the job.
		 */
		
		countSymptoms("/home/dj/git/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt");
		}
		
	/**
	 * Sort, count and prints the symptoms in a given file.
	 * @param filePath the path of the file
	 */
	public static void countSymptoms (String filePath) throws IndexOutOfBoundsException {
		ReadSymptomDataFromFile fileReader = new ReadSymptomDataFromFile(filePath);
		
		/*
		 * Sorting the list of symptoms
		 */
		List<String> symptomList = fileReader.GetSymptoms();
		Collections.sort(symptomList);
		
		String currentSymptom;
		int countCurrentSymptom = 1;
		
		for (int currentSymptomIndex=0;currentSymptomIndex < symptomList.size();currentSymptomIndex++) {
			currentSymptom = symptomList.get(currentSymptomIndex);
			try {
				if (currentSymptom.equals(symptomList.get(currentSymptomIndex+1))) {
					countCurrentSymptom++;
				} else {
					System.out.println(currentSymptom+" : "+countCurrentSymptom);
					countCurrentSymptom = 1;
				}
			} catch (IndexOutOfBoundsException exception) {
				
			}
		}		
	}
}
