package com.example.healthease.Doctor;

public class Dentists implements DoctorDetails {
    @Override
    public String[][] getDoctorDetails() {
        return new String[][]{
                {"Doctor Name : Layla Abbas", "Hospital Address : Wakad", "Exp : 8yrs", "Mobile No: 7799669898", "1850"},
                {"Doctor Name : Omar Farooq", "Hospital Address : Kondhwa", "Exp : 11yrs", "Mobile No: 9899669898", "1700"},
                {"Doctor Name : Amina Khan", "Hospital Address : Magarpatta", "Exp : 9yrs", "Mobile No: 8899669898", "1950"},
                {"Doctor Name : Yusuf Khan", "Hospital Address : Warje", "Exp : 10yrs", "Mobile No: 7799669898", "1600"}
        };
    }
}
