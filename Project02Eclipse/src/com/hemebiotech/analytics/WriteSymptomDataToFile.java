package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filename;

    /**
     * Creates a new writer that will write to the specified file.
     *
     * @param filename the path of the file to write to
     */
    public WriteSymptomDataToFile (String filename) {
        this.filename = filename;
    }

    /**
     * Writes a specified map of symptoms and their occurrence to the file,
     * one line per symptom, in the format "symptom: count".
     *
     * @param symptoms the map of symptoms to write with their occurrence
     */
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
