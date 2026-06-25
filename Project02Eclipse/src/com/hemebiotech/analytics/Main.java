package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main() {
        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
        WriteSymptomDataToFile writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter analytics = new AnalyticsCounter(reader, writer);

        List<String> symptoms = analytics.getSymptoms();
        Map<String, Integer> countedSymptoms = analytics.countSymptoms(symptoms);
        Map<String, Integer> sortedSymptoms = analytics.sortSymptoms(countedSymptoms);
        analytics.writeSymptoms(sortedSymptoms);
    }
}
