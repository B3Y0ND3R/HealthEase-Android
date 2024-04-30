package com.example.healthease.Doctor;

import static org.junit.Assert.*;

import org.junit.Test;

public class DieticiansTest {
    @Test
    public void testGetDoctorDetails() {
        Dieticians dieticians = new Dieticians();

        String[][] details = dieticians.getDoctorDetails();

        assertEquals("Doctor Name : Ahmed Khan", details[0][0]);
        assertEquals("Hospital Address : Aundh", details[0][1]);
        assertEquals("Exp : 10yrs", details[0][2]);
        assertEquals("Mobile No: 8898989898", details[0][3]);
        assertEquals("1700", details[0][4]);

        assertEquals("Doctor Name : Amira Malik", details[1][0]);
        assertEquals("Hospital Address : Hinjewadi", details[1][1]);
        assertEquals("Exp : 12yrs", details[1][2]);
        assertEquals("Mobile No: 7799889898", details[1][3]);
        assertEquals("2000", details[1][4]);

        assertEquals("Doctor Name : Yusuf Ali", details[2][0]);
        assertEquals("Hospital Address : Hadapsar", details[2][1]);
        assertEquals("Exp : 9yrs", details[2][2]);
        assertEquals("Mobile No: 9899779898", details[2][3]);
        assertEquals("1400", details[2][4]);

        assertEquals("Doctor Name : Safiya Ahmed", details[3][0]);
        assertEquals("Hospital Address : Koregaon Park", details[3][1]);
        assertEquals("Exp : 11yrs", details[3][2]);
        assertEquals("Mobile No: 8899779898", details[3][3]);
        assertEquals("1750", details[3][4]);

        assertEquals("Doctor Name : Ibrahim Khan", details[4][0]);
        assertEquals("Hospital Address : Kothrud", details[4][1]);
        assertEquals("Exp : 13yrs", details[4][2]);
        assertEquals("Mobile No: 7799779898", details[4][3]);
        assertEquals("1650", details[4][4]);
    }

}