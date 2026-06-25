package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filename;
    public WriteSymptomDataToFile (String filename) {
        this.filename = filename;
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (symptoms != null) {
            try {
                FileWriter writer = new FileWriter (filename);
                symptoms.forEach((symptom, value) -> {
                    try {
                    String text = symptom + ": " + value.toString() + "\n";
                    writer.write(text);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
