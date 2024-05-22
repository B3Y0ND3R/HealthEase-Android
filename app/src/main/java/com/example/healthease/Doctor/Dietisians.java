package com.example.healthease.Doctor;


import java.util.ArrayList;
/**
 * Singleton class representing a collection of dietician occurrences.
 * Extends the {@link DoctorDetails} class.
 * This class is responsible for managing dietician occurrences and notifying observers about changes in appointments.
 */
public class Dietisians extends DoctorDetails {

    private static Dietisians instance = null;
    private ArrayList<DieticianOccurrence> dieticianOccurrences = new ArrayList<>();
    private int totalAppointment = 0;
    /**
     * Private constructor to prevent instantiation.
     * Sets the category name to "Dietician".
     */
    private Dietisians() {
        super("Dietician");
    }
    /**
     * Returns the single instance of the Dietisians class.
     * Uses double-checked locking for thread safety.
     *
     * @return the singleton instance of the Dietisians class.
     */
    public static Dietisians getInstance() {
        if (instance == null) {
            synchronized (Dietisians.class) {
                if (instance == null) {
                    instance = new Dietisians();
                }
            }
        }
        return instance;
    }
    /**
     * Returns the list of dietician occurrences.
     *
     * @return an ArrayList of {@link DieticianOccurrence}.
     */
    public ArrayList<DieticianOccurrence> getDieticianOccurrences() {
        return dieticianOccurrences;
    }
    /**
     * Adds a dietician occurrence to the list.
     *
     * @param dieticianOccurrence the {@link DieticianOccurrence} to add.
     */
    public void addDietician(DieticianOccurrence dieticianOccurrence) {
        dieticianOccurrences.add(dieticianOccurrence);
    }
    /**
     * Sets the total number of appointments in this category.
     *
     * @param totalAppointment the total number of appointments.
     */
    public void setTotalAppointment(int totalAppointment) {
        this.totalAppointment = totalAppointment;
    }
    /**
     * Removes an observer from the list of dietician occurrences.
     *
     * @param appointmentObserver the {@link AppointmentObserver} to remove.
     */
    @Override
    public void removeObserver(AppointmentObserver appointmentObserver) {
        dieticianOccurrences.remove(appointmentObserver);
    }
    /**
     * Notifies all observers of the total number of appointments in this category.
     */
    @Override
    public void notifyObserver() {
        for (AppointmentObserver appointmentObserver : dieticianOccurrences) {
            appointmentObserver.updateTotalAppointmentInThisCategory(totalAppointment);
        }
    }
    /**
     * Returns the total number of appointments in this category.
     *
     * @return the total number of appointments.
     */
    public int getTotalAppointment()
    {
        return this.totalAppointment;
    }
}
