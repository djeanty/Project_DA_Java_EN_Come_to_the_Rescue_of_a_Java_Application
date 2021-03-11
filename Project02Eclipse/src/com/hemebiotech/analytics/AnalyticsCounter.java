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
	 * Reads the file path of the symptoms's file and uses the class SymptomCount to count and write in a file the symptoms.
	 * 
	 * @param args if not empty, it is the symptoms file path.
	 */
	public static void main(String args[]) {

		// If we don't give a file path as an argument, we need to read one.
		SymptomCount symptomCount;
		if (args.length == 0) {
			symptomCount = new SymptomCount(pathOfFile());
		} else {
			symptomCount = new SymptomCount(args[0]);
		}
		SymptomCount.writeSymptoms("output.txt", symptomCount.toString());
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
