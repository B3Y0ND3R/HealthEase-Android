package com.example.healthease.LabTest;

/**
 * The {@code SpecialLabTest} class represents a special type of laboratory test.
 * It extends the {@link LabTest} class and provides specific functionality
 * for special lab tests.
 */
public class SpecialLabTest extends LabTest {
    /**
     * Constructs a new {@code SpecialLabTest} with the specified name, details, and price.
     *
     * @param name    the name of the special lab test
     * @param details the details of the special lab test
     * @param price   the price of the special lab test
     */
    public SpecialLabTest(String name, String details, String price) {
        super(name, details, price);
    }
    /**
     * Returns the type of the lab test, which is "Special".
     *
     * @return the type of the lab test
     */
    @Override
    public String getType() {
        return "Special";
    }
}