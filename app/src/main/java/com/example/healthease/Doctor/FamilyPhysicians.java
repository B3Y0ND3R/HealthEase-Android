package com.example.healthease.Doctor;

public class FamilyPhysicians implements DoctorDetails {
    @Override
    public String[][] getDoctorDetails() {
        return new String[][]{
                {"Doctor Name : Aisha Khan", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9898989898", "1600"},
                {"Doctor Name : Mohammad Ali", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No: 9898989898", "1900"},
                {"Doctor Name : Fatima Ahmed", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No: 8899889898", "1300"},
                {"Doctor Name : Yusuf Abdullah", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No: 9898989898", "1500"},
                {"Doctor Name : Zara Hussain", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No: 7798989898", "1800"}
        };
    }
}
