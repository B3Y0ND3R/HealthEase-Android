package com.example.healthease.LabTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImmunityCheckTest
{
    private ImmunityCheck immunityCheck= new ImmunityCheck();



    @Test
    public void testGetName() {
        String expectedName = "Package 5: Immunity Check";
        assertEquals(expectedName, immunityCheck.getName());
    }

    @Test
    public void testGetDetails() {
        String expectedDetails = "Details about package 5";
        assertEquals(expectedDetails, immunityCheck.getDetails());
    }

    @Test
    public void testGetCost() {
        int expectedCost = 396;
        assertEquals(expectedCost, immunityCheck.getCost());
    }
}