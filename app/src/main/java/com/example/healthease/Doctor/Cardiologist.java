package com.example.healthease.Doctor;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Observer;

public class Cardiologist extends DoctorDetails {

    private static Cardiologist instance = null;
    private ArrayList<CardiologistOccurence> cardiologistOccurrences = new ArrayList<>();
    private int totalAppointment=0;

    /**
     * Private constructor to prevent instantiation.
     * Sets the category name to "Cardiologist".
     */
    private Cardiologist() {
        super("Cardiologist");
    }
    /**
     * Returns the single instance of the Cardiologist class.
     * Uses double-checked locking for thread safety.
     *
     * @return the singleton instance of the Cardiologist class.
     */
    public static Cardiologist getInstance() {
        if (instance == null) {
            synchronized (Cardiologist.class) {
                if (instance == null) {
                    instance = new Cardiologist();
                }
            }
        }
        return instance;
    }
    /**
     * Returns the list of cardiologist occurrences.
     *
     * @return an ArrayList of {@link CardiologistOccurence}.
     */

    public ArrayList<CardiologistOccurence> getCardiologistOccurrences() {
        return cardiologistOccurrences;
    }

    /**
     * Adds a cardiologist occurrence to the list.
     *
     * @param cardiologistOccurrence the {@link CardiologistOccurence} to add.
     */
    public void addCardiologist(CardiologistOccurence cardiologistOccurrence) {


        cardiologistOccurrences.add(cardiologistOccurrence);
    }

    /**
     * Removes an observer from the list of cardiologist occurrences.
     *
     * @param appointmentObserver the {@link AppointmentObserver} to remove.
     */
    @Override
    public void removeObserver(AppointmentObserver appointmentObserver)
    {
        cardiologistOccurrences.remove(appointmentObserver);
    }
    /**
     * Sets the total number of appointments in this category.
     *
     * @param a the total number of appointments.
     */
    public void setTotalAppointment(int a)
    {
        this.totalAppointment=a;
    }
    /**
     * Returns the total number of appointments in this category.
     *
     * @return the total number of appointments.
     */
    public int getTotalAppointment() { return totalAppointment;}
    /**
     * Notifies all observers of the total number of appointments in this category.
     */
    @Override
    public void notifyObserver()
    {
        for (AppointmentObserver appointmentObserver : cardiologistOccurrences) {
            appointmentObserver.updateTotalAppointmentInThisCategory(totalAppointment);
        }
    }
}
