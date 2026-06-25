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
}
