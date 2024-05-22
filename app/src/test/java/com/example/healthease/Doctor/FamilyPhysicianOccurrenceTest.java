package com.example.healthease.Doctor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FamilyPhysicianOccurrenceTest {

    private FamilyPhysicianOccurrence familyPhysician;

    @Before
    public void setUp() {
        familyPhysician = new FamilyPhysicianOccurrence("Dr. Farhana Ahmed", "Apollo Hospital, Dhaka", "20 years", "+8801711887766", 600);
    }

    @Test
    public void testGetDoctorName() {
        assertEquals("Dr. Farhana Ahmed", familyPhysician.getDoctorName());
    }

    @Test
    public void testGetHospitalAddress() {
        assertEquals("Apollo Hospital, Dhaka", familyPhysician.getHospitalAddress());
    }

    @Test
    public void testGetExperience() {
        assertEquals("20 years", familyPhysician.getExperience());
    }

    @Test
    public void testGetMobileNo() {
        assertEquals("+8801711887766", familyPhysician.getMobileNo());
    }

    @Test
    public void testGetConsultationFee() {
        assertEquals(600, familyPhysician.getConsultationFee());
    }

    @Test
    public void testUpdateTotalAppointmentInThisCategory() {
        familyPhysician.updateTotalAppointmentInThisCategory(40);
        assertEquals(40, familyPhysician.getTotalAppointmentInThisCategory());
    }

    @Test
    public void testGetTotalAppointmentInThisCategory() {
        assertEquals(0, familyPhysician.getTotalAppointmentInThisCategory());
        familyPhysician.updateTotalAppointmentInThisCategory(35);
        assertEquals(35, familyPhysician.getTotalAppointmentInThisCategory());
    }
}
