package com.example.healthease.LabTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class BloodGlucoseFastingPackageTest {
    private BloodGlucoseFastingPackage bloodGlucoseFastingPackage=new BloodGlucoseFastingPackage();;



    @Test
    public void testGetName() {
        String expectedName = "Package 2: Blood Glucose Fasting";
        assertEquals(expectedName, bloodGlucoseFastingPackage.getName());
    }

    @Test
    public void testGetDetails() {
        String expectedDetails = "Details about package 2";
        assertEquals(expectedDetails, bloodGlucoseFastingPackage.getDetails());
    }

    @Test
    public void testGetCost() {
        int expectedCost = 299;
        assertEquals(expectedCost, bloodGlucoseFastingPackage.getCost());
    }

}