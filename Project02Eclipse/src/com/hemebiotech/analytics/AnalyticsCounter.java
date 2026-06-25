package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
    private ISymptomReader reader;
    private ISymptomWriter writer;
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    };
    public List<String> getSymptoms() {
        return reader.GetSymptoms();
    };
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> results = new HashMap<>();

        for (String symptom : symptoms) {
            if (results.containsKey(symptom)) {
                results.put(symptom, results.get(symptom) + 1);
            } else {
                results.put(symptom, 1);
            }
        };

        return results;
    };
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        Map<String, Integer> sortedResults = new TreeMap<String, Integer>(symptoms);
        return sortedResults;
    };
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    };

    public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

        ReadSymptomDataFromFile symptomsReader = new ReadSymptomDataFromFile("symptoms.txt");

        System.out.println(symptomsReader.GetSymptoms());

		int i = 0;
		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
                // Changed headCount for headacheCount and removed headCount variable
                headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
            // Changed "rush" into "rash"
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}


		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
