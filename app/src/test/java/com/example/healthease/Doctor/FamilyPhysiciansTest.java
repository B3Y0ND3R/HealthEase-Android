package com.example.healthease.Doctor;

import static org.junit.Assert.*;

import org.junit.Test;

public class FamilyPhysiciansTest {
    @Test
    public void testGetDoctorDetails() {
        FamilyPhysicians familyPhysicians = new FamilyPhysicians();

        String[][] details = familyPhysicians.getDoctorDetails();

        assertEquals("Doctor Name : Aisha Khan", details[0][0]);
        assertEquals("Hospital Address : Pimpri", details[0][1]);
        assertEquals("Exp : 5yrs", details[0][2]);
        assertEquals("Mobile No: 9898989898", details[0][3]);
        assertEquals("1600", details[0][4]);

        assertEquals("Doctor Name : Mohammad Ali", details[1][0]);
        assertEquals("Hospital Address : Nigdi", details[1][1]);
        assertEquals("Exp : 15yrs", details[1][2]);
        assertEquals("Mobile No: 9898989898", details[1][3]);
        assertEquals("1900", details[1][4]);

        assertEquals("Doctor Name : Fatima Ahmed", details[2][0]);
        assertEquals("Hospital Address : Pune", details[2][1]);
        assertEquals("Exp : 8yrs", details[2][2]);
        assertEquals("Mobile No: 8899889898", details[2][3]);
        assertEquals("1300", details[2][4]);

        assertEquals("Doctor Name : Yusuf Abdullah", details[3][0]);
        assertEquals("Hospital Address : Chinchwad", details[3][1]);
        assertEquals("Exp : 6yrs", details[3][2]);
        assertEquals("Mobile No: 9898989898", details[3][3]);
        assertEquals("1500", details[3][4]);

        assertEquals("Doctor Name : Zara Hussain", details[4][0]);
        assertEquals("Hospital Address : Katraj", details[4][1]);
        assertEquals("Exp : 7yrs", details[4][2]);
        assertEquals("Mobile No: 7798989898", details[4][3]);
        assertEquals("1800", details[4][4]);
    }

}