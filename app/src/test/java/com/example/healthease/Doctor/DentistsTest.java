package com.example.healthease.Doctor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DentistsTest {

    private Dentists dentists;

    @Before
    public void setUp() {
        dentists = Dentists.getInstance();
        dentists.getDentistOccurrences().clear();
        dentists.setTotalAppointment(0);
    }

    @Test
    public void testSingletonInstance() {
        Dentists a = Dentists.getInstance();
        Dentists b = Dentists.getInstance();
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void testAddDentistOccurrence() {
        DentistOccurrence occurrence = mock(DentistOccurrence.class);
        dentists.addDentist(occurrence);
        ArrayList<DentistOccurrence> occurrences = dentists.getDentistOccurrences();
        assertTrue("Occurrence should be added to the list", occurrences.contains(occurrence));
    }

    @Test
    public void testAddRemoveObserver() {
        DentistOccurrence occurrence1 = new DentistOccurrence("Sakib", "Mirpur", "10yr", "1234567890", 50);
        DentistOccurrence occurrence2 = new DentistOccurrence("Sakib1", "Mirzapur", "8yr", "0987654321", 70);

        dentists.addDentist(occurrence1);
        dentists.addDentist(occurrence2);
        assertEquals(2, dentists.getDentistOccurrences().size());
        dentists.removeObserver(occurrence2);
        assertEquals(1, dentists.getDentistOccurrences().size());
        dentists.addDentist(occurrence2);
        assertEquals(2, dentists.getDentistOccurrences().size());
    }

    @Test
    public void testNotifyObservers() {
        DentistOccurrence occurrence1 = new DentistOccurrence("Sakib", "Mirpur", "10yr", "1234567890", 50);
        DentistOccurrence occurrence2 = new DentistOccurrence("Sakib1", "Mirzapur", "8yr", "0987654321", 70);

        dentists.addDentist(occurrence1);
        dentists.addDentist(occurrence2);

        dentists.setTotalAppointment(5);
        dentists.notifyObserver();

        assertEquals(5, dentists.getDentistOccurrences().get(0).getTotalAppointmentInThisCategory());
        assertEquals(5, dentists.getDentistOccurrences().get(1).getTotalAppointmentInThisCategory());
    }

    @Test
    public void testSetAndGetTotalAppointment() {
        dentists.setTotalAppointment(10);
        assertEquals("Total appointments should be set to 10", 10, dentists.getTotalAppointment());
    }
}
