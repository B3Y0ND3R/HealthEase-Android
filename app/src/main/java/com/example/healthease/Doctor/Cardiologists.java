package com.example.healthease.Doctor;

public class Cardiologists implements DoctorDetails {
    @Override
    public String[][] getDoctorDetails() {
        return new String[][]
                {
                        {"Doctor Name : Ayesha Siddiqui", "Hospital Address : Kharadi", "Exp : 8yrs", "Mobile No: 7799449898", "1700"},
                        {"Doctor Name : Abdul Rahman", "Hospital Address : Senapati Bapat Road", "Exp : 10yrs", "Mobile No: 9899449898", "1850"},
                        {"Doctor Name : Safiya Khan", "Hospital Address : Dhayari", "Exp : 9yrs", "Mobile No: 8899449898", "1600"},
                        {"Doctor Name : Amir Khan", "Hospital Address : Vishrantwadi", "Exp : 11yrs", "Mobile No: 7799339898", "1950"}
                };
    }
}
