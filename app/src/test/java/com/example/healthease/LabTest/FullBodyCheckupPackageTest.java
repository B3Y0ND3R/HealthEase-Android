package com.example.healthease.LabTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class FullBodyCheckupPackageTest
{
    private FullBodyCheckupPackage fullBodyCheckupPackage=new FullBodyCheckupPackage();



    @Test
    public void testGetName() {
        String expectedName = "Package 1: Full Body Checkup";
        assertEquals(expectedName, fullBodyCheckupPackage.getName());
    }

    @Test
    public void testGetDetails() {
        String expectedDetails = "Details about package 1";
        assertEquals(expectedDetails, fullBodyCheckupPackage.getDetails());
    }

    @Test
    public void testGetCost() {
        int expectedCost = 999;
        assertEquals(expectedCost, fullBodyCheckupPackage.getCost());
    }
}