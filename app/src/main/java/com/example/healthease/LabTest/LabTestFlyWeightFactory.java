package com.example.healthease.LabTest;


import java.util.HashMap;
import java.util.Map;
/**
 * The {@code LabTestFlyweightFactory} class is responsible for managing flyweight objects of LabTest instances.
 * It optimizes memory usage by reusing existing LabTest objects based on their intrinsic state.
 */
class LabTestFlyweightFactory {
    /**
     * A map to store flyweight LabTest objects.
     * The key is a concatenated string of name, details, price, and type,
     * uniquely identifying each type of LabTest.
     */
    private Map<String, LabTest> labTests = new HashMap<>();
    /**
     * Retrieves or creates a LabTest object based on the provided parameters.
     * If a LabTest object with the same intrinsic state exists, it is reused;
     * otherwise, a new LabTest object is created and stored in the flyweight pool.
     *
     * @param name the name of the lab test
     * @param details the details of the lab test
     * @param price the price of the lab test
     * @param type the type of the lab test (e.g., "Special" or "Normal")
     * @return a LabTest object based on the provided parameters
     */
    public LabTest getLabTest(String name, String details, String price, String type) {
        String key = name + "|" + details + "|" + price + "|" + type;
        if (!labTests.containsKey(key)) {
            LabTest labTest;
            if (type.equals("Special")) {
                labTest = new SpecialLabTest(name, details, price);
            } else {
                labTest = new NormalLabTest(name, details, price);
            }
            labTests.put(key, labTest);
        }
        return labTests.get(key);
    }
}
