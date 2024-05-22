package com.example.healthease.Doctor;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class DoctorDetailsAdapterTest {

    @Test
    public void testAdapt_EmptyArray() {
        String[][] emptyArray = new String[0][0];
        List<DoctorDetails> doctorList = DoctorDetailsAdapter.adapt(emptyArray);
        assertNull(doctorList);
    }

    @Test
    public void test1() {
        String[][] validData = {
                {"Specialist : Cardiologist", "Doctor Name : Dr. A", "Hospital Address : Heart Hospital", "Exp : 10 years", "Mobile No: +1234567890", "200"},
                {"Specialist : Dentist", "Doctor Name : Dr. Jane Smith", "Hospital Address : Smile Dental Clinic", "Exp : 8 years", "Mobile No: +9876543210", "150"}
        };
        List<DoctorDetails> doctorList = DoctorDetailsAdapter.adapt(validData);
        assertNotNull(doctorList);
        assertEquals(2, doctorList.size());
    }

    @Test
    public void test2() {
        // Doctor details with missing fields
        String[][] invalidData = {
                {"Specialist : Cardiologist", "Doctor Name : Dr. B", "Exp : 10 years", "Mobile No: +01712121212", "200"},
                {"Specialist : Dentist", "Hospital Address : Smile Dental Clinic", "Exp : 8 years", "Mobile No: +01712121212", "150"}
        };
        List<DoctorDetails> doctorList = DoctorDetailsAdapter.adapt(invalidData);
        assertNull(doctorList);
    }


}
