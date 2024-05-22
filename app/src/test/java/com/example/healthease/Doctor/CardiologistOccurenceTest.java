package com.example.healthease.Doctor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardiologistOccurenceTest {

    private CardiologistOccurence cardiologist;

    @Before
    public void setUp() {
        cardiologist = new CardiologistOccurence("Dr. Ayesha Rahman", "Dhaka Medical College Hospital", "15 years", "+8801712345678", 500);
    }

    @Test
    public void testGetDoctorName() {
        assertEquals("Dr. Ayesha Rahman", cardiologist.getDoctorName());
    }

    @Test
    public void testGetHospitalAddress() {
        assertEquals("Dhaka Medical College Hospital", cardiologist.getHospitalAddress());
    }

    @Test
    public void testGetExperience() {
        assertEquals("15 years", cardiologist.getExperience());
    }

    @Test
    public void testGetMobileNo() {
        assertEquals("+8801712345678", cardiologist.getMobileNo());
    }

    @Test
    public void testGetConsultationFee() {
        assertEquals(500, cardiologist.getConsultationFee());
    }

    @Test
    public void testUpdateTotalAppointmentInThisCategory() {
        cardiologist.updateTotalAppointmentInThisCategory(20);
        assertEquals(20, cardiologist.getTotalAppointmentInThisCategory());
    }

    @Test
    public void testGetTotalAppointmentInThisCategory() {
        assertEquals(0, cardiologist.getTotalAppointmentInThisCategory());
        cardiologist.updateTotalAppointmentInThisCategory(15);
        assertEquals(15, cardiologist.getTotalAppointmentInThisCategory());
    }
}
