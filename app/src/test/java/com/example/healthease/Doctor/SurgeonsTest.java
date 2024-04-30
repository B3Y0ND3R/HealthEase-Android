package com.example.healthease.Doctor;

import static org.junit.Assert.*;

import org.junit.Test;

public class SurgeonsTest
{
    @Test
    public void testGetDoctorDetails() {
        Surgeons surgeons = new Surgeons();

        String[][] details = surgeons.getDoctorDetails();

        assertEquals("Doctor Name : Mariam Akhtar", details[0][0]);
        assertEquals("Hospital Address : Baner", details[0][1]);
        assertEquals("Exp : 7yrs", details[0][2]);
        assertEquals("Mobile No: 9899559898", details[0][3]);
        assertEquals("1750", details[0][4]);

        assertEquals("Doctor Name : Hassan Ali", details[1][0]);
        assertEquals("Hospital Address : Shivajinagar", details[1][1]);
        assertEquals("Exp : 13yrs", details[1][2]);
        assertEquals("Mobile No: 7799559898", details[1][3]);
        assertEquals("1800", details[1][4]);

        assertEquals("Doctor Name : Fatima Begum", details[2][0]);
        assertEquals("Hospital Address : Yerwada", details[2][1]);
        assertEquals("Exp : 6yrs", details[2][2]);
        assertEquals("Mobile No: 8899559898", details[2][3]);
        assertEquals("1650", details[2][4]);

        assertEquals("Doctor Name : Khalid Ahmed", details[3][0]);
        assertEquals("Hospital Address : Dhanori", details[3][1]);
        assertEquals("Exp : 12yrs", details[3][2]);
        assertEquals("Mobile No: 9899449898", details[3][3]);
        assertEquals("1900", details[3][4]);
    }

}