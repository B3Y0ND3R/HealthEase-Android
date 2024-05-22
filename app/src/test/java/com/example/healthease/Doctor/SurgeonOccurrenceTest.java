package com.example.healthease.Doctor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SurgeonOccurrenceTest {

    private SurgeonOccurrence surgeon;

    @Before
    public void setUp() {
        surgeon = new SurgeonOccurrence("Dr. Arif Hossain", "Evercare Hospital, Dhaka", "25 years", "+8801711998877", 1000);
    }

    @Test
    public void testGetDoctorName() {
        assertEquals("Dr. Arif Hossain", surgeon.getDoctorName());
    }

    @Test
    public void testGetHospitalAddress() {
        assertEquals("Evercare Hospital, Dhaka", surgeon.getHospitalAddress());
    }

    @Test
    public void testGetExperience() {
        assertEquals("25 years", surgeon.getExperience());
    }

    @Test
    public void testGetMobileNo() {
        assertEquals("+8801711998877", surgeon.getMobileNo());
    }

    @Test
    public void testGetConsultationFee() {
        assertEquals(1000, surgeon.getConsultationFee());
    }

    @Test
    public void testUpdateTotalAppointmentInThisCategory() {
        surgeon.updateTotalAppointmentInThisCategory(60);
        assertEquals(60, surgeon.getTotalAppointmentInThisCategory());
    }

    @Test
    public void testGetTotalAppointmentInThisCategory() {
        assertEquals(0, surgeon.getTotalAppointmentInThisCategory());
        surgeon.updateTotalAppointmentInThisCategory(45);
        assertEquals(45, surgeon.getTotalAppointmentInThisCategory());
    }
}
