package com.example.healthease.Doctor;

import static org.junit.Assert.*;

import org.junit.Test;

public class DentistsTest {
    @Test
    public void testGetDoctorDetails() {
        Dentists dentists = new Dentists();

        String[][] details = dentists.getDoctorDetails();

        assertEquals("Doctor Name : Layla Abbas", details[0][0]);
        assertEquals("Hospital Address : Wakad", details[0][1]);
        assertEquals("Exp : 8yrs", details[0][2]);
        assertEquals("Mobile No: 7799669898", details[0][3]);
        assertEquals("1850", details[0][4]);

        assertEquals("Doctor Name : Omar Farooq", details[1][0]);
        assertEquals("Hospital Address : Kondhwa", details[1][1]);
        assertEquals("Exp : 11yrs", details[1][2]);
        assertEquals("Mobile No: 9899669898", details[1][3]);
        assertEquals("1700", details[1][4]);

        assertEquals("Doctor Name : Amina Khan", details[2][0]);
        assertEquals("Hospital Address : Magarpatta", details[2][1]);
        assertEquals("Exp : 9yrs", details[2][2]);
        assertEquals("Mobile No: 8899669898", details[2][3]);
        assertEquals("1950", details[2][4]);

        assertEquals("Doctor Name : Yusuf Khan", details[3][0]);
        assertEquals("Hospital Address : Warje", details[3][1]);
        assertEquals("Exp : 10yrs", details[3][2]);
        assertEquals("Mobile No: 7799669898", details[3][3]);
        assertEquals("1600", details[3][4]);
    }

}