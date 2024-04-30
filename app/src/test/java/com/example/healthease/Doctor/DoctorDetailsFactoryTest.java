package com.example.healthease.Doctor;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoctorDetailsFactoryTest {

    @Test
    public void testCreateDoctorDetails() {
        DoctorDetails doctorDetails = DoctorDetailsFactory.createDoctorDetails("Family Physicians");
        assertTrue(doctorDetails instanceof FamilyPhysicians);

        doctorDetails = DoctorDetailsFactory.createDoctorDetails("Dietician");
        assertTrue(doctorDetails instanceof Dieticians);

        doctorDetails = DoctorDetailsFactory.createDoctorDetails("Dentist");
        assertTrue(doctorDetails instanceof Dentists);

        doctorDetails = DoctorDetailsFactory.createDoctorDetails("Surgeon");
        assertTrue(doctorDetails instanceof Surgeons);

        doctorDetails = DoctorDetailsFactory.createDoctorDetails("Other");
        assertTrue(doctorDetails instanceof Dieticians);
    }

}