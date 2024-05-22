package com.example.healthease.LabTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class SpecialLabTestTest {

    private SpecialLabTest specialLabTest;

    @Before
    public void setUp() {
        specialLabTest = new SpecialLabTest("Advanced Blood Test", "Detailed analysis of blood components", "150 USD");
    }

    @Test
    public void testGetName() {
        assertEquals("Advanced Blood Test", specialLabTest.getName());
    }

    @Test
    public void testGetDetails() {
        assertEquals("Detailed analysis of blood components", specialLabTest.getDetails());
    }

    @Test
    public void testGetPrice() {
        assertEquals("150 USD", specialLabTest.getPrice());
    }

    @Test
    public void testGetType() {
        assertEquals("Special", specialLabTest.getType());
    }

    @Test
    public void testSpecialLabTestInitialization() {
        assertNotNull(specialLabTest);
        assertEquals("Advanced Blood Test", specialLabTest.getName());
        assertEquals("Detailed analysis of blood components", specialLabTest.getDetails());
        assertEquals("150 USD", specialLabTest.getPrice());
        assertEquals("Special", specialLabTest.getType());
    }
}
