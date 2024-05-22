package com.example.healthease.Doctor;

/**
 * Factory class to update the total number of appointments for different specializations.
 * Notifies observers about the changes in the appointment numbers.
 */
public class TotalAppointmentFactory {
    /**
     * Updates the total number of appointments for the specified specialization.
     * Notifies the observers about the change.
     *
     * @param specialization The specialization of the doctors
     * @param number         The updated number of appointments
     * @throws IllegalArgumentException If the specialization is unknown
     */
    public static void updateAppointmentNumber(String specialization, int number) {
        System.out.println(specialization);
        // Cardiologist cardiologist = new Cardiologist("Cardiologist");
        Cardiologist cardiologist = Cardiologist.getInstance();
        Dentists dentists = Dentists.getInstance();
        Dietisians dietisians = Dietisians.getInstance();
        Surgeons surgeons = Surgeons.getInstance();
        FamilyPhysicians familyPhysicians = FamilyPhysicians.getInstance();
        switch (specialization.toLowerCase()) {
            case "cardiologist":
                cardiologist.setTotalAppointment(number);
                cardiologist.notifyObserver();
                break;
            case "family physician":
                familyPhysicians.setTotalAppointment(number);
                familyPhysicians.notifyObserver();
                break;
            case "dietician":
                dietisians.setTotalAppointment(number);
                dietisians.notifyObserver();
                break;
            case "dentist":
                dentists.setTotalAppointment(number);
                dentists.notifyObserver();
                break;
            case "surgeon":
                surgeons.setTotalAppointment(number);
                surgeons.notifyObserver();
                break;
            default:
                throw new IllegalArgumentException("Unknown specialization: " + specialization);
        }
    }
}
