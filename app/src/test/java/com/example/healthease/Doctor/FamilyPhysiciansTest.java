package com.example.healthease.Doctor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FamilyPhysiciansTest {

    private FamilyPhysicians familyPhysicians;

    @Before
    public void setUp() {
        familyPhysicians = FamilyPhysicians.getInstance();
        familyPhysicians.getFamilyPhysicianOccurrences().clear();
        familyPhysicians.setTotalAppointment(0);
    }

    @Test
    public void testSingletonInstance() {
        FamilyPhysicians a = FamilyPhysicians.getInstance();
        FamilyPhysicians b = FamilyPhysicians.getInstance();
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void testAddFamilyPhysicianOccurrence() {
        FamilyPhysicianOccurrence occurrence = mock(FamilyPhysicianOccurrence.class);
        familyPhysicians.addFamilyPhysician(occurrence);
        ArrayList<FamilyPhysicianOccurrence> occurrences = familyPhysicians.getFamilyPhysicianOccurrences();
        assertTrue("Occurrence should be added to the list", occurrences.contains(occurrence));
    }

    @Test
    public void testAddRemoveObserver() {
        FamilyPhysicianOccurrence occurrence1 = new FamilyPhysicianOccurrence("sakib", "Tangail", "10yr", "1234567890", 50);
        FamilyPhysicianOccurrence occurrence2 = new FamilyPhysicianOccurrence("sakib", "Mirzapur", "8yr", "0987654321", 70);

        familyPhysicians.addFamilyPhysician(occurrence1);
        familyPhysicians.addFamilyPhysician(occurrence2);
        assertEquals(2, familyPhysicians.getFamilyPhysicianOccurrences().size());
        familyPhysicians.removeObserver(occurrence2);
        assertEquals(1, familyPhysicians.getFamilyPhysicianOccurrences().size());
        familyPhysicians.addFamilyPhysician(occurrence2);
        assertEquals(2, familyPhysicians.getFamilyPhysicianOccurrences().size());
    }

    @Test
    public void testNotifyObservers() {
        FamilyPhysicianOccurrence occurrence1 = new FamilyPhysicianOccurrence("sakib", "Tangail", "10yr", "1234567890", 50);
        FamilyPhysicianOccurrence occurrence2 = new FamilyPhysicianOccurrence("sakib", "Mirzapur", "8yr", "0987654321", 70);

        familyPhysicians.addFamilyPhysician(occurrence1);
        familyPhysicians.addFamilyPhysician(occurrence2);

        familyPhysicians.setTotalAppointment(5);
        familyPhysicians.notifyObserver();

        assertEquals(5, familyPhysicians.getFamilyPhysicianOccurrences().get(0).getTotalAppointmentInThisCategory());
        assertEquals(5, familyPhysicians.getFamilyPhysicianOccurrences().get(1).getTotalAppointmentInThisCategory());
    }

    @Test
    public void testSetAndGetTotalAppointment() {
        familyPhysicians.setTotalAppointment(10);
        assertEquals("Total appointments should be set to 10", 10, familyPhysicians.getTotalAppointment());
    }
}
