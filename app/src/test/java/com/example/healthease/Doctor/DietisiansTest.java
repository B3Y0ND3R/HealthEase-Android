package com.example.healthease.Doctor;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DietisiansTest {

    private Dietisians dietisians;

    @Before
    public void setUp() {
        dietisians = Dietisians.getInstance();
        dietisians.getDieticianOccurrences().clear();
        dietisians.setTotalAppointment(0);
    }

    @Test
    public void testSingletonInstance() {
        Dietisians a = Dietisians.getInstance();
        Dietisians b = Dietisians.getInstance();
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void testAddDieticianOccurrence() {
        DieticianOccurrence occurrence = mock(DieticianOccurrence.class);
        dietisians.addDietician(occurrence);
        ArrayList<DieticianOccurrence> occurrences = dietisians.getDieticianOccurrences();
        assertTrue("Occurrence should be added to the list", occurrences.contains(occurrence));
    }

    @Test
    public void testAddRemoveObserver() {
        DieticianOccurrence occurrence1 = new DieticianOccurrence("getTotalAppointment", "Rajshahi", "10yr", "1234567890", 50);
        DieticianOccurrence occurrence2 = new DieticianOccurrence("Sakib1", "Mongla", "8yr", "0987654321", 70);

        dietisians.addDietician(occurrence1);
        dietisians.addDietician(occurrence2);
        assertEquals(2, dietisians.getDieticianOccurrences().size());
        dietisians.removeObserver(occurrence2);
        assertEquals(1, dietisians.getDieticianOccurrences().size());
        dietisians.addDietician(occurrence2);
        assertEquals(2, dietisians.getDieticianOccurrences().size());
    }

    @Test
    public void testNotifyObservers() {
        DieticianOccurrence occurrence1 = new DieticianOccurrence("getTotalAppointment", "Rajshahi", "10yr", "1234567890", 50);
        DieticianOccurrence occurrence2 = new DieticianOccurrence("Sakib1", "Mongla", "8yr", "0987654321", 70);

        dietisians.addDietician(occurrence1);
        dietisians.addDietician(occurrence2);

        dietisians.setTotalAppointment(5);
        dietisians.notifyObserver();

        assertEquals(5, dietisians.getDieticianOccurrences().get(0).getTotalAppointmentInThisCategory());
        assertEquals(5, dietisians.getDieticianOccurrences().get(1).getTotalAppointmentInThisCategory());
    }

    @Test
    public void testSetAndGetTotalAppointment() {
        dietisians.setTotalAppointment(10);
        assertEquals("Total appointments should be set to 10", 10, dietisians.getTotalAppointment());
    }
}
