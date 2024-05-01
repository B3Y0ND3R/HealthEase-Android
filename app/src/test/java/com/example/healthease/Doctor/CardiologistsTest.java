package com.example.healthease.Doctor;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardiologistsTest {
    @Test
    public void testGetDoctorDetails() {
        Cardiologists cardiologists = new Cardiologists();

        String[][] details = cardiologists.getDoctorDetails();

        assertEquals("Doctor Name : Ayesha Siddiqui", details[0][0]);
        assertEquals("Hospital Address : Kharadi", details[0][1]);
        assertEquals("Exp : 8yrs", details[0][2]);
        assertEquals("Mobile No: 7799449898", details[0][3]);
        assertEquals("1700", details[0][4]);

        assertEquals("Doctor Name : Abdul Rahman", details[1][0]);
        assertEquals("Hospital Address : Senapati Bapat Road", details[1][1]);
        assertEquals("Exp : 10yrs", details[1][2]);
        assertEquals("Mobile No: 9899449898", details[1][3]);
        assertEquals("1850", details[1][4]);

        assertEquals("Doctor Name : Safiya Khan", details[2][0]);
        assertEquals("Hospital Address : Dhayari", details[2][1]);
        assertEquals("Exp : 9yrs", details[2][2]);
        assertEquals("Mobile No: 8899449898", details[2][3]);
        assertEquals("1600", details[2][4]);

        assertEquals("Doctor Name : Amir Khan", details[3][0]);
        assertEquals("Hospital Address : Vishrantwadi", details[3][1]);
        assertEquals("Exp : 11yrs", details[3][2]);
        assertEquals("Mobile No: 7799339898", details[3][3]);
        assertEquals("1950", details[3][4]);
    }

}