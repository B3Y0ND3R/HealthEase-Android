package com.example.healthease.Doctor;

public class DoctorDetailsFactory {
    public static DoctorDetails createDoctorDetails(String title) {
        switch (title) {
            case "Family Physicians":
                return new FamilyPhysicians();
            case "Dietician":
                return new Dieticians();
            case "Dentist":
                return new Dentists();
            case "Surgeon":
                return new Surgeons();
            case "Cardiologists":
                return new Cardiologists();
            default:
                return new Dieticians();
        }
    }
}
