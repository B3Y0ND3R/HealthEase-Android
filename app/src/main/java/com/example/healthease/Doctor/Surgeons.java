package com.example.healthease.Doctor;


import java.util.ArrayList;
/**
 * Singleton class representing the collection of Surgeons.
 * Manages the list of SurgeonOccurrence and implements observer pattern to notify them of changes.
 */
public class Surgeons extends DoctorDetails {

    private static Surgeons instance = null;
    private ArrayList<SurgeonOccurrence> surgeonOccurrences = new ArrayList<>();
    private int totalAppointment = 0;
    /**
     * Private constructor to prevent instantiation from other classes.
     * Initializes the Surgeons with the specified specialization.
     */
    private Surgeons() {
        super("Surgeon");
    }
    /**
     * Returns the singleton instance of Surgeons.
     *
     * @return The singleton instance of Surgeons
     */
    public static Surgeons getInstance() {
        if (instance == null) {
            synchronized (Surgeons.class) {
                if (instance == null) {
                    instance = new Surgeons();
                }
            }
        }
        return instance;
    }
    /**
     * Returns the list of SurgeonOccurrence.
     *
     * @return An ArrayList of SurgeonOccurrence
     */
    public ArrayList<SurgeonOccurrence> getSurgeonOccurrences() {
        return surgeonOccurrences;
    }
    /**
     * Adds a SurgeonOccurrence to the list.
     *
     * @param surgeonOccurrence The SurgeonOccurrence to be added
     */
    public void addSurgeon(SurgeonOccurrence surgeonOccurrence) {
        surgeonOccurrences.add(surgeonOccurrence);
    }
    /**
     * Sets the total number of appointments for surgeons.
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
        surgeonOccurrences.remove(appointmentObserver);
    }
    /**
     * Notifies all SurgeonOccurrence observers of the updated total appointments.
     */
    @Override
    public void notifyObserver() {
        for (AppointmentObserver appointmentObserver : surgeonOccurrences) {
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
