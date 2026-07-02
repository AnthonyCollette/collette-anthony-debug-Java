package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
    private ISymptomReader reader;
    private ISymptomWriter writer;
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    };

    /**
     * Retrieving a list of symptoms.
     *
     * @return a list of symptoms
     */
    public List<String> getSymptoms() {
        return reader.GetSymptoms();
    };

    /**
     * Counts the occurrences of each symptom.
     *
     * @param symptoms list of symptoms
     * @return a map associating each symptom with its number of occurrences
     */
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

    /**
     * Sorts a map of symptoms by symptom nam (alphabetical order).
     *
     * @param symptoms the map of symptoms to sort
     * @return a map of symptoms ordered alphabetically by symptom name
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        Map<String, Integer> sortedResults = new TreeMap<String, Integer>(symptoms);
        return sortedResults;
    };

    /**
     * Writes the given symptoms and their occurrence counts to a new file.
     *
     * @param symptoms map of symptoms to write with their numbers
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    };
}
