package com.example.healthease.Doctor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DieticianOccurrenceTest {

    private DieticianOccurrence dietician;

    @Before
    public void setUp() {
        dietician = new DieticianOccurrence("Dr. Nadia Khan", "Square Hospital, Dhaka", "12 years", "+8801711223344", 400);
    }

    @Test
    public void testGetDoctorName() {
        assertEquals("Dr. Nadia Khan", dietician.getDoctorName());
    }

    @Test
    public void testGetHospitalAddress() {
        assertEquals("Square Hospital, Dhaka", dietician.getHospitalAddress());
    }

    @Test
    public void testGetExperience() {
        assertEquals("12 years", dietician.getExperience());
    }

    @Test
    public void testGetMobileNo() {
        assertEquals("+8801711223344", dietician.getMobileNo());
    }

    @Test
    public void testGetConsultationFee() {
        assertEquals(400, dietician.getConsultationFee());
    }

    @Test
    public void testUpdateTotalAppointmentInThisCategory() {
        dietician.updateTotalAppointmentInThisCategory(30);
        assertEquals(30, dietician.getTotalAppointmentInThisCategory());
    }

    @Test
    public void testGetTotalAppointmentInThisCategory() {
        assertEquals(0, dietician.getTotalAppointmentInThisCategory());
        dietician.updateTotalAppointmentInThisCategory(20);
        assertEquals(20, dietician.getTotalAppointmentInThisCategory());
    }
}
