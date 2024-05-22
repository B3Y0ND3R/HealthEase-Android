package com.example.healthease.Doctor;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SurgeonsTest {

    private Surgeons surgeons;

    @Before
    public void setUp() {
        surgeons = Surgeons.getInstance();
        surgeons.getSurgeonOccurrences().clear();
        surgeons.setTotalAppointment(0);
    }

    @Test
    public void testSingletonInstance() {
        Surgeons a = Surgeons.getInstance();
        Surgeons b = Surgeons.getInstance();
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void testAddSurgeonOccurrence() {
        SurgeonOccurrence occurrence = mock(SurgeonOccurrence.class);
        surgeons.addSurgeon(occurrence);
        ArrayList<SurgeonOccurrence> occurrences = surgeons.getSurgeonOccurrences();
        assertTrue("Occurrence should be added to the list", occurrences.contains(occurrence));
    }

    @Test
    public void testAddRemoveObserver() {
        SurgeonOccurrence occurrence1 = new SurgeonOccurrence("Sakib", "Dhaka", "15yr", "1234567890", 100);
        SurgeonOccurrence occurrence2 = new SurgeonOccurrence("Sakib1", "Tangail", "12yr", "0987654321", 120);

        surgeons.addSurgeon(occurrence1);
        surgeons.addSurgeon(occurrence2);
        assertEquals(2, surgeons.getSurgeonOccurrences().size());
        surgeons.removeObserver(occurrence2);
        assertEquals(1, surgeons.getSurgeonOccurrences().size());
        surgeons.addSurgeon(occurrence2);
        assertEquals(2, surgeons.getSurgeonOccurrences().size());
    }

    @Test
    public void testNotifyObservers() {
        SurgeonOccurrence occurrence1 = new SurgeonOccurrence("Sakib", "Dhaka", "15yr", "1234567890", 100);
        SurgeonOccurrence occurrence2 = new SurgeonOccurrence("Sakib1", "Tangail", "12yr", "0987654321", 120);

        surgeons.addSurgeon(occurrence1);
        surgeons.addSurgeon(occurrence2);

        surgeons.setTotalAppointment(5);
        surgeons.notifyObserver();

        assertEquals(5, surgeons.getSurgeonOccurrences().get(0).getTotalAppointmentInThisCategory());
        assertEquals(5, surgeons.getSurgeonOccurrences().get(1).getTotalAppointmentInThisCategory());
    }

    @Test
    public void testSetAndGetTotalAppointment() {
        surgeons.setTotalAppointment(10);
        assertEquals("Total appointments should be set to 10", 10, surgeons.getTotalAppointment());
    }
}
