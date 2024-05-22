package com.example.healthease.Doctor;


import java.util.ArrayList;
/**
 * Singleton class representing the collection of Family Physicians.
 * Manages the list of FamilyPhysicianOccurrence and implements observer pattern to notify them of changes.
 */
public class FamilyPhysicians extends DoctorDetails {

    private static FamilyPhysicians instance = null;
    private ArrayList<FamilyPhysicianOccurrence> familyPhysicianOccurrences = new ArrayList<>();
    private int totalAppointment = 0;
    /**
     * Private constructor to prevent instantiation from other classes.
     * Initializes the FamilyPhysicians with the specified specialization.
     */
    private FamilyPhysicians() {
        super("Family Physician");
    }
    /**
     * Returns the singleton instance of FamilyPhysicians.
     *
     * @return The singleton instance of FamilyPhysicians
     */
    public static FamilyPhysicians getInstance() {
        if (instance == null) {
            synchronized (FamilyPhysicians.class) {
                if (instance == null) {
                    instance = new FamilyPhysicians();
                }
            }
        }
        return instance;
    }
    /**
     * Returns the list of FamilyPhysicianOccurrence.
     *
     * @return An ArrayList of FamilyPhysicianOccurrence
     */
    public ArrayList<FamilyPhysicianOccurrence> getFamilyPhysicianOccurrences() {
        return familyPhysicianOccurrences;
    }
    /**
     * Adds a FamilyPhysicianOccurrence to the list.
     *
     * @param familyPhysicianOccurrence The FamilyPhysicianOccurrence to be added
     */
    public void addFamilyPhysician(FamilyPhysicianOccurrence familyPhysicianOccurrence) {
        familyPhysicianOccurrences.add(familyPhysicianOccurrence);
    }
    /**
     * Sets the total number of appointments for family physicians.
     *
     * @param totalAppointment The total number of appointments
     */
    public void setTotalAppointment(int totalAppointment) {
        this.totalAppointment = totalAppointment;
    }
    /**
     * Removes an AppointmentObserver from the list.
     *
     * @param appointmentObserver The AppointmentObserver to be removed
     */
    @Override
    public void removeObserver(AppointmentObserver appointmentObserver) {
        familyPhysicianOccurrences.remove(appointmentObserver);
    }
    /**
     * Notifies all FamilyPhysicianOccurrence observers of the updated total appointments.
     */
    @Override
    public void notifyObserver() {
        for (AppointmentObserver appointmentObserver : familyPhysicianOccurrences) {
            appointmentObserver.updateTotalAppointmentInThisCategory(totalAppointment);
        }
    }
    /**
     * Returns the total number of appointments.
     *
     * @return The total number of appointments
     */
    public int getTotalAppointment()
    {
        return this.totalAppointment;
    }
}
