package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    /**
     * Runs the symptom analysis: reads the symptoms from a file,
     * counts their occurrences, sorts them alphabetically,
     * and writes the sorted results to an output file.
     */

    public static void main(String[] args) {
        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
        WriteSymptomDataToFile writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter analytics = new AnalyticsCounter(reader, writer);

        List<String> symptoms = analytics.getSymptoms();
        Map<String, Integer> countedSymptoms = analytics.countSymptoms(symptoms);
        Map<String, Integer> sortedSymptoms = analytics.sortSymptoms(countedSymptoms);
        analytics.writeSymptoms(sortedSymptoms);
    }
}
