package com.example.healthease.LabTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThyroidCheckTest {
    private ThyroidCheck thyroidCheck = new ThyroidCheck();



    @Test
    public void testGetName() {
        String expectedName = "Package 4: Thyroid Check";
        assertEquals(expectedName, thyroidCheck.getName());
    }

    @Test
    public void testGetDetails() {
        String expectedDetails = "Details about package 4";
        assertEquals(expectedDetails, thyroidCheck.getDetails());
    }

    @Test
    public void testGetCost() {
        int expectedCost = 850;
        assertEquals(expectedCost, thyroidCheck.getCost());
    }

}