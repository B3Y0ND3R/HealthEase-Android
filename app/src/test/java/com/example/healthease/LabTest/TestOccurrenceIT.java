package com.example.healthease.LabTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import static org.junit.Assert.assertEquals;

public class TestOccurrenceIT {

    private String[][] packages = {
            {"Full Body Checkup", "", "", "3500"},
            {"Blood Glucose Fasting", "", "", "400"},

    };

    private String[] package_details = {
            "Comprehensive health checkup including blood tests, urine tests, and imaging tests.",
            "Measures blood glucose levels after fasting to check for diabetes.",

    };

    @Test
    public void test1() {
        LabTestFlyweightFactory factory = new LabTestFlyweightFactory();
        LabTest labTest = factory.getLabTest("name", "details", "price", "Normal");
        TestOccurrence x = new TestOccurrence(labTest,"Mirpur");
        assertEquals("name", x.getLabTest().getName());
        assertEquals("details", x.getLabTest().getDetails());
        assertEquals("price", x.getLabTest().getPrice());


    }



}
