package com.example.healthease.Doctor;

import java.util.ArrayList;

/**
 * Singleton class representing a collection of dentist occurrences.
 * Extends the {@link DoctorDetails} class.
 * This class is responsible for managing dentist occurrences and notifying observers about changes in appointments.
 */
public class Dentists extends DoctorDetails {

    private static Dentists instance = null;
    private ArrayList<DentistOccurrence> dentistOccurrences = new ArrayList<>();
    private int totalAppointment = 0;

    /**
     * Private constructor to prevent instantiation.
     * Sets the category name to "Dentist".
     */
    private Dentists() {
        super("Dentist");
    }

    /**
     * Returns the single instance of the Dentists class.
     * Uses double-checked locking for thread safety.
     *
     * @return the singleton instance of the Dentists class.
     */
    public static Dentists getInstance() {
        if (instance == null) {
            synchronized (Dentists.class) {
                if (instance == null) {
                    instance = new Dentists();
                }
            }
        }
        return instance;
    }

    /**
     * Returns the list of dentist occurrences.
     *
     * @return an ArrayList of {@link DentistOccurrence}.
     */
    public ArrayList<DentistOccurrence> getDentistOccurrences() {
        return dentistOccurrences;
    }

    /**
     * Adds a dentist occurrence to the list.
     *
     * @param dentistOccurrence the {@link DentistOccurrence} to add.
     */
    public void addDentist(DentistOccurrence dentistOccurrence) {
        dentistOccurrences.add(dentistOccurrence);
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
     * Returns the total number of appointments in this category.
     *
     * @return the total number of appointments.
     */
    public int getTotalAppointment()
    {
        return this.totalAppointment;
    }

    /**
     * Removes an observer from the list of dentist occurrences.
     *
     * @param appointmentObserver the {@link AppointmentObserver} to remove.
     */
    @Override
    public void removeObserver(AppointmentObserver appointmentObserver) {
        dentistOccurrences.remove(appointmentObserver);
    }


    /**
     * Notifies all observers of the total number of appointments in this category.
     */
    @Override
    public void notifyObserver() {
        for (AppointmentObserver appointmentObserver : dentistOccurrences) {
            appointmentObserver.updateTotalAppointmentInThisCategory(totalAppointment);
        }
    }
}
