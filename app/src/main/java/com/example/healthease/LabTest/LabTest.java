package com.example.healthease.LabTest;
import java.util.ArrayList;
/**
 * The {@code LabTest} class represents a generic laboratory test.
 * It provides basic attributes and methods common to all types of lab tests.
 * This class is intended to be extended by specific types of lab tests.
 *
 * <p>Each lab test has a name, details, and price, and keeps a list of test occurrences.
 */
public abstract class LabTest {
    /** The name of the lab test. */

    protected String name;
    /** The details of the lab test. */

    protected String details;
    /** The price of the lab test. */

    protected String price;
    /**
     * A list of occurrences of this lab test.
     * Each occurrence represents an instance of the test being performed.
     */
    ArrayList<TestOccurrence> testOccurrences = new ArrayList<TestOccurrence>();
    /**
     * Constructs a new {@code LabTest} with the specified name, details, and price.
     *
     * @param name the name of the lab test
     * @param details the details of the lab test
     * @param price the price of the lab test
     */
    public LabTest(String name, String details, String price) {
        this.name = name;
        this.details = details;
        this.price = price;
    }
    /**
     * Returns the type of the lab test.
     * This method is abstract and must be implemented by subclasses to specify the type.
     *
     * @return the type of the lab test
     */
    public abstract String getType();
    /**
     * Returns the name of the lab test.
     *
     * @return the name of the lab test
     */
    public String getName() { return name; }
    /**
     * Returns the details of the lab test.
     *
     * @return the details of the lab test
     */
    public String getDetails() { return details; }
    /**
     * Returns the price of the lab test.
     *
     * @return the price of the lab test
     */
    public String getPrice() { return price; }
}
