package com.hemebiotech.analytics;

import java.util.Scanner;

/**
 * This program counts symptoms from a file and then writes the count of these symptoms in another file.
 * symptoms.
 * 
 * @author Damien Jeanty
 *
 */
public class AnalyticsCounter {

	/**
	 * Uses the method pathOfFile() to read the file path of the symptoms file.
	 * It then uses an instance of the class SymptomCount to count the symptoms and writes the sum in another file.
	 * 
	 * @param args if not empty, it is the symptoms file path.
	 */
	public static void main(String args[]) {

		/* If the user doesn't give a file path as an argument when starting the application
		 * the method needs to read one.
		*/
		SymptomCount symptomCount;
		if (args.length == 0) {
			symptomCount = new SymptomCount(pathOfFile());
		} else {
			symptomCount = new SymptomCount(args[0]);
		}
		SymptomCount.writeSymptoms("results.out", symptomCount.toString());
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

}
