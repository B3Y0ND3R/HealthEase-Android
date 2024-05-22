package com.example.healthease.LabTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class LabTestFlyweightFactoryTest {

    private LabTestFlyweightFactory factory;

    @Before
    public void setUp() {
        factory = new LabTestFlyweightFactory();
    }

    @Test
    public void testGetLabTestNormal() {
        LabTest labTest1 = factory.getLabTest("Blood Test", "Complete Blood Count", "50 ", "Normal");
        LabTest labTest2 = factory.getLabTest("Blood Test", "Complete Blood Count", "50 ", "Normal");

        assertEquals(labTest1.hashCode(),labTest2.hashCode());

        assertSame(labTest1, labTest2);
        assertEquals("Blood Test", labTest1.getName());
        assertEquals("Complete Blood Count", labTest1.getDetails());
        assertEquals("50 ", labTest1.getPrice());
        assertEquals("Normal", labTest1.getType());
    }

    @Test
    public void testGetLabTestSpecial() {
        LabTest labTest1 = factory.getLabTest("Blood Test", "Complete Blood Count", "100 ", "Special");
        LabTest labTest2 = factory.getLabTest("Blood Test", "Complete Blood Count", "100 ", "Special");

        assertEquals(labTest1.hashCode(),labTest2.hashCode());

        assertSame(labTest1, labTest2);
        assertEquals("Blood Test", labTest1.getName());
        assertEquals("Complete Blood Count", labTest1.getDetails());
        assertEquals("100 ", labTest1.getPrice());
        assertEquals("Special", labTest1.getType());
    }

    @Test
    public void testGetDifferentLabTests() {
        LabTest labTest1 = factory.getLabTest("Blood Test", "Complete Blood Count", "50 ", "Normal");
        LabTest labTest2 = factory.getLabTest("Urine Test", "Routine Check", "30 ", "Normal");
        LabTest labTest3 = factory.getLabTest("Blood Test", "Complete Blood Count", "100 ", "Special");

        assertNotEquals(labTest1.hashCode(),labTest2.hashCode());
        assertNotEquals(labTest1.hashCode(),labTest3.hashCode());
        assertNotEquals(labTest3.hashCode(),labTest2.hashCode());

        assertEquals("Blood Test", labTest1.getName());
        assertEquals("Complete Blood Count", labTest1.getDetails());
        assertEquals("50 ", labTest1.getPrice());
        assertEquals("Normal", labTest1.getType());

        assertEquals("Urine Test", labTest2.getName());
        assertEquals("Routine Check", labTest2.getDetails());
        assertEquals("30 ", labTest2.getPrice());
        assertEquals("Normal", labTest2.getType());

        assertEquals("Blood Test", labTest3.getName());
        assertEquals("Complete Blood Count", labTest3.getDetails());
        assertEquals("100 ", labTest3.getPrice());
        assertEquals("Special", labTest3.getType());
    }
}
