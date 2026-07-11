package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {

    /**
     * Writes the given symptoms to a file.
     *
     * @param symptoms a {@code Map<String, Integer>} where the key is the symptom name and the value is the associated count
     */

    public void writeSymptoms(Map<String, Integer> symptoms);

}
