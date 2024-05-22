package com.example.healthease.LabTest;

/**
 * The {@code NormalLabTest} class represents a normal type of laboratory test.
 * It extends the {@link LabTest} class and provides specific functionality
 * for normal lab tests.
 */
public class NormalLabTest extends LabTest {

    /**
     * Constructs a new {@code NormalLabTest} with the specified name, details, and price.
     *
     * @param name    the name of the normal lab test
     * @param details the details of the normal lab test
     * @param price   the price of the normal lab test
     */
    public NormalLabTest(String name, String details, String price) {
        super(name, details, price);
    }
    /**
     * Returns the type of the lab test, which is "Normal".
     *
     * @return the type of the lab test
     */
    @Override
    public String getType() {
        return "Normal";
    }
}