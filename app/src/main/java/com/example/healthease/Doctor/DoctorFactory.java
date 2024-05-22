package com.example.healthease.Doctor;

/**
 * Factory class for creating DoctorDetails objects based on specialization.
 */
public class DoctorFactory {
    /**
     * Creates a DoctorDetails object based on the given specialization.
     *
     * @param specialization    The specialization of the doctor (e.g., "cardiologist", "family physician", etc.)
     * @param doctorName        The name of the doctor
     * @param hospitalAddress   The address of the hospital where the doctor practices
     * @param experience        The experience of the doctor
     * @param mobileNo          The mobile number of the doctor
     * @param consultationFee   The consultation fee of the doctor
     * @return A DoctorDetails object corresponding to the specified specialization
     * @throws IllegalArgumentException if the specialization is unknown
     */
    public static DoctorDetails createDoctor(String specialization, String doctorName, String hospitalAddress, String experience, String mobileNo, int consultationFee) {
        System.out.println(specialization);
        Cardiologist cardiologist = Cardiologist.getInstance();
        FamilyPhysicians familyPhysicians = FamilyPhysicians.getInstance();
        Surgeons surgeons = Surgeons.getInstance();
        Dentists dentists = Dentists.getInstance();
        Dietisians dietisians = Dietisians.getInstance();
       // Cardiologist cardiologist = new Cardiologist("Cardiologist");
        switch (specialization.toLowerCase()) {
            case "cardiologist":
                CardiologistOccurence cardiologistOccurence = new CardiologistOccurence(doctorName, hospitalAddress, experience, mobileNo, consultationFee);
                cardiologist.addCardiologist(cardiologistOccurence);
                return cardiologistOccurence;

            case "family physician":
                FamilyPhysicianOccurrence familyPhysicianOccurrence = new FamilyPhysicianOccurrence(doctorName, hospitalAddress, experience, mobileNo, consultationFee);
                familyPhysicians.addFamilyPhysician(familyPhysicianOccurrence);
                return familyPhysicianOccurrence;

            case "dietician":
                DieticianOccurrence dieticianOccurrence = new DieticianOccurrence(doctorName, hospitalAddress, experience, mobileNo, consultationFee);
                dietisians.addDietician(dieticianOccurrence);
                return dieticianOccurrence;

            case "dentist":
                DentistOccurrence dentistOccurrence = new DentistOccurrence(doctorName, hospitalAddress, experience, mobileNo, consultationFee);
                dentists.addDentist(dentistOccurrence);
                return dentistOccurrence;

            case "surgeon":
                SurgeonOccurrence surgeonOccurrence = new SurgeonOccurrence(doctorName, hospitalAddress, experience, mobileNo, consultationFee);
                surgeons.addSurgeon(surgeonOccurrence);
                return surgeonOccurrence;

            // Add cases for other specializations
            default:
                throw new IllegalArgumentException("Unknown specialization: " + specialization);
        }
    }
}
