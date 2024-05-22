package com.example.healthease.Doctor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DentistOccurrenceTest {

    private DentistOccurrence dentist;

    @Before
    public void setUp() {
        dentist = new DentistOccurrence("Dr. Tania Ahmed", "Apollo Hospital, Dhaka", "8 years", "+8801912345678", 300);
    }

    @Test
    public void testGetDoctorName() {
        assertEquals("Dr. Tania Ahmed", dentist.getDoctorName());
    }

    @Test
    public void testGetHospitalAddress() {
        assertEquals("Apollo Hospital, Dhaka", dentist.getHospitalAddress());
    }

    @Test
    public void testGetExperience() {
        assertEquals("8 years", dentist.getExperience());
    }

    @Test
    public void testGetMobileNo() {
        assertEquals("+8801912345678", dentist.getMobileNo());
    }

    @Test
    public void testGetConsultationFee() {
        assertEquals(300, dentist.getConsultationFee());
    }

    @Test
    public void testUpdateTotalAppointmentInThisCategory() {
        dentist.updateTotalAppointmentInThisCategory(25);
        assertEquals(25, dentist.getTotalAppointmentInThisCategory());
    }

    @Test
    public void testGetTotalAppointmentInThisCategory() {
        assertEquals(0, dentist.getTotalAppointmentInThisCategory());
        dentist.updateTotalAppointmentInThisCategory(10);
        assertEquals(10, dentist.getTotalAppointmentInThisCategory());
    }
}
