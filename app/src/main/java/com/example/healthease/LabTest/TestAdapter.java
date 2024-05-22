package com.example.healthease.LabTest;


import java.util.ArrayList;
/**
 * The {@code TestAdapter} class provides a method to convert test data into TestOccurrences.
 * It adapts the input data into a format suitable for creating TestOccurrences.
 */
public class TestAdapter {
    /**
     * Converts the provided test package data into a list of TestOccurrences.
     *
     * @param packages        a 2D array containing test package data (name, details, price)
     * @param packageDetails  an array containing details for each test package
     * @return a list of TestOccurrences representing the converted test data
     */
    public static ArrayList<TestOccurrence> convert(String[][] packages, String[] packageDetails) {
        ArrayList<TestOccurrence> testOccurrences = new ArrayList<TestOccurrence>();
        LabTestFlyweightFactory factory = new LabTestFlyweightFactory();
        int occurrenceIndex = 0;
        for (int i = 0; i < packages.length; i++) {

            String name =  packages[i][0];
            String price = packages[i][3];
            String details = packageDetails[i];
            String type = determineTestType(name); // Determine test type logic

            LabTest labTest = factory.getLabTest(name, details, price, type);

            testOccurrences.add(new TestOccurrence(labTest, "Mirpur"));
            testOccurrences.add(new TestOccurrence(labTest, "Uttara"));

        }
        return testOccurrences;
    }
    /**
     * Determines the type of test based on the test name.
     *
     * @param name the name of the test
     * @return the type of the test (Special or Normal)
     */
    private static String determineTestType(String name) {
        // Logic to determine if a test is special or normal
        if (name.contains("COVID") || name.contains("Full Body")) {
            return "Special";
        } else {
            return "Normal";
        }
    }
}
