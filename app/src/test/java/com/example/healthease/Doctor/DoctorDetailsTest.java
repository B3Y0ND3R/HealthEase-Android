package com.example.healthease.Doctor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoctorDetailsTest {

    private DoctorDetails doctorDetailsWithSpecialist;
    private DoctorDetails doctorDetailsDefault;

    @Before
    public void setUp() {
        doctorDetailsWithSpecialist = new DoctorDetails("Cardiologist");
        doctorDetailsDefault = new DoctorDetails();
    }

    @Test
    public void testGetSpecialist() {
        assertEquals("Cardiologist", doctorDetailsWithSpecialist.getSpecialist());
        assertEquals("", doctorDetailsDefault.getSpecialist());
    }

    @Test
    public void testGetDoctorName() {
        assertEquals("-1", doctorDetailsWithSpecialist.getDoctorName());
        assertEquals("-1", doctorDetailsDefault.getDoctorName());
    }

    @Test
    public void testGetHospitalAddress() {
        assertEquals("-1", doctorDetailsWithSpecialist.getHospitalAddress());
        assertEquals("-1", doctorDetailsDefault.getHospitalAddress());
    }

    @Test
    public void testGetExperience() {
        assertEquals("-1", doctorDetailsWithSpecialist.getExperience());
        assertEquals("-1", doctorDetailsDefault.getExperience());
    }

    @Test
    public void testGetMobileNo() {
        assertEquals("-1", doctorDetailsWithSpecialist.getMobileNo());
        assertEquals("-1", doctorDetailsDefault.getMobileNo());
    }

    @Test
    public void testGetConsultationFee() {
        assertEquals(0, doctorDetailsWithSpecialist.getConsultationFee());
        assertEquals(0, doctorDetailsDefault.getConsultationFee());
    }

    @Test
    public void testRemoveObserver() {
        doctorDetailsWithSpecialist.removeObserver(null);
        doctorDetailsDefault.removeObserver(null);
    }

    @Test
    public void testNotifyObserver() {
        doctorDetailsWithSpecialist.notifyObserver();
        doctorDetailsDefault.notifyObserver();
    }
}
