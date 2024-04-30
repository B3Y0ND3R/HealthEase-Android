package com.example.healthease.Doctor;

public class Surgeons implements DoctorDetails {
    @Override
    public String[][] getDoctorDetails() {
        return new String[][]
                {
                        {"Doctor Name : Mariam Akhtar", "Hospital Address : Baner", "Exp : 7yrs", "Mobile No: 9899559898", "1750"},
                        {"Doctor Name : Hassan Ali", "Hospital Address : Shivajinagar", "Exp : 13yrs", "Mobile No: 7799559898", "1800"},
                        {"Doctor Name : Fatima Begum", "Hospital Address : Yerwada", "Exp : 6yrs", "Mobile No: 8899559898", "1650"},
                        {"Doctor Name : Khalid Ahmed", "Hospital Address : Dhanori", "Exp : 12yrs", "Mobile No: 9899449898", "1900"}
                };
    }
}
