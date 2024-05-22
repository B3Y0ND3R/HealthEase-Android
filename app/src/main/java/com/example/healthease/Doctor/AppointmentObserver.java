package com.example.healthease.Doctor;
/**
 * Interface for observing changes in the total number of appointments in a specific category.
 */
public interface AppointmentObserver {
    /**
     * Updates the observer with the total number of appointments in this category.
     *
     * @param a the total number of appointments in the category.
     */
    void updateTotalAppointmentInThisCategory(int a);
}
