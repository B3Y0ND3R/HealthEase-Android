package com.example.healthease.LabTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class NormalLabTestTest {

    private NormalLabTest normalLabTest;

    @Before
    public void setUp() {
        normalLabTest = new NormalLabTest("Complete Blood Count", "Measures various components of the blood", "50 ");
    }

    @Test
    public void testGetName() {
        assertEquals("Complete Blood Count", normalLabTest.getName());
    }

    @Test
    public void testGetDetails() {
        assertEquals("Measures various components of the blood", normalLabTest.getDetails());
    }

    @Test
    public void testGetPrice() {
        assertEquals("50 ", normalLabTest.getPrice());
    }

    @Test
    public void testGetType() {
        assertEquals("Normal", normalLabTest.getType());
    }

    @Test
    public void testNormalLabTestInitialization() {
        assertNotNull(normalLabTest);
        assertEquals("Complete Blood Count", normalLabTest.getName());
        assertEquals("Measures various components of the blood", normalLabTest.getDetails());
        assertEquals("50 ", normalLabTest.getPrice());
        assertEquals("Normal", normalLabTest.getType());
    }
}
