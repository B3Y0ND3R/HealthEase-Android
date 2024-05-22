package com.example.healthease.Doctor;


import java.util.ArrayList;
/**
 * Factory class for retrieving lists of doctors based on their specialization.
 */
public class DoctorListViewFactory {
    /**
     * Returns a list of doctor occurrences based on the given specialization title.
     *
     * @param title The specialization of the doctors (e.g., "cardiologist", "family physician", etc.)
     * @return An ArrayList of doctor occurrences corresponding to the specified specialization
     * @throws IllegalArgumentException if the specialization is unknown
     */
    public static ArrayList getDoctorList(String title) {
        Cardiologist cardiologist = Cardiologist.getInstance();
        FamilyPhysicians familyPhysicians = FamilyPhysicians.getInstance();
        Surgeons surgeons = Surgeons.getInstance();
        Dentists dentists = Dentists.getInstance();
        Dietisians dietisians = Dietisians.getInstance();
        switch (title.toLowerCase()) {
            case "cardiologist":
                return cardiologist.getCardiologistOccurrences();
            case "family physician":
              return familyPhysicians.getFamilyPhysicianOccurrences();

            case "dietician":
              return dietisians.getDieticianOccurrences();

            case "dentist":
               return dentists.getDentistOccurrences();

            case "surgeon":
              return surgeons.getSurgeonOccurrences();
            // Add cases for other specializations
            default:
                throw new IllegalArgumentException("Unknown specialization: " + title);
        }
    }
}
