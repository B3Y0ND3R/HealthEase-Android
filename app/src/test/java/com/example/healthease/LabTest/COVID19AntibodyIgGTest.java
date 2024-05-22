package com.example.healthease.LabTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class COVID19AntibodyIgGTest {
    private COVID19AntibodyIgG covid19AntibodyIgG = new COVID19AntibodyIgG();



    @Test
    public void testGetName() {
        String expectedName = "Package 3: COVID-19 Antibody - IgG";
        assertEquals(expectedName, covid19AntibodyIgG.getName());
    }

    @Test
    public void testGetDetails() {
        String expectedDetails = "Details about package 3";
        assertEquals(expectedDetails, covid19AntibodyIgG.getDetails());
    }

    @Test
    public void testGetCost() {
        int expectedCost = 420;
        assertEquals(expectedCost, covid19AntibodyIgG.getCost());
    }
}