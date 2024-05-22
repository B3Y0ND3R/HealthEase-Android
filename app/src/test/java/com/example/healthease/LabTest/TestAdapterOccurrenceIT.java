package com.example.healthease.LabTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import static org.junit.Assert.assertEquals;

public class TestAdapterOccurrenceIT {

    private String[][] packages = {
            {"Full Body Checkup", "", "", "3500"},
            {"Blood Glucose Fasting", "", "", "400"},

    };

    private String[] package_details = {
            "Comprehensive health checkup including blood tests, urine tests, and imaging tests.",
            "Measures blood glucose levels after fasting to check for diabetes.",

    };
    @Test
    public void test1()
    {
        ArrayList<TestOccurrence> a = TestAdapter.convert(packages, package_details);

        TestOccurrence x = a.get(0);
        TestOccurrence y = a.get(1);
        TestOccurrence z = a. get(2);
        TestOccurrence p = a. get(3);

        assertEquals("Full Body Checkup", x.getLabTest().getName());
        assertEquals("Full Body Checkup", y.getLabTest().getName());
        assertEquals("Blood Glucose Fasting", z.getLabTest().getName());
        assertEquals("Blood Glucose Fasting", p.getLabTest().getName());
        assertEquals("Mirpur", x.getBranch());
        assertEquals("Uttara", y.getBranch());
        assertEquals("Mirpur", z.getBranch());
        assertEquals("Uttara", p.getBranch());


    }



}
