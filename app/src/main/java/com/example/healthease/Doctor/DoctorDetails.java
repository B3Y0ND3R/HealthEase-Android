package com.example.healthease.Doctor;


import java.util.Observer;
/**
 * Represents the details of a doctor.
 * This class serves as a base class for various types of doctors.
 */
public class DoctorDetails {

    private String specialist;
    /**
     * Constructs a new DoctorDetails with the specified specialist.
     *
     * @param specialist the specialization of the doctor.
     */
    public DoctorDetails(String specialist) {
        this.specialist = specialist;
    }
    /**
     * Constructs a new DoctorDetails with no specialization.
     */
    public DoctorDetails() {
        this.specialist = "";
    }
    /**
     * Returns the specialization of the doctor.
     *
     * @return the specialization of the doctor.
     */
    public String getSpecialist() {
        return specialist;
    }
    /**
     * Returns the name of the doctor.
     * This method should be overridden by subclasses to provide specific details.
     *
     * @return the name of the doctor, or "-1" if not specified.
     */
    public String getDoctorName() {
        return "-1";
    }
    /**
     * Returns the address of the hospital where the doctor practices.
     * This method should be overridden by subclasses to provide specific details.
     *
     * @return the hospital address, or "-1" if not specified.
     */
    public String getHospitalAddress() {
        return "-1";
    }
    /**
     * Returns the experience of the doctor.
     * This method should be overridden by subclasses to provide specific details.
     *
     * @return the experience of the doctor, or "-1" if not specified.
     */
    public String getExperience() {
        return "-1";
    }
    /**
     * Returns the mobile number of the doctor.
     * This method should be overridden by subclasses to provide specific details.
     *
     * @return the mobile number of the doctor, or "-1" if not specified.
     */
    public String getMobileNo() {
        return "-1";
    }
    /**
     * Returns the consultation fee of the doctor.
     * This method should be overridden by subclasses to provide specific details.
     *
     * @return the consultation fee, or 0 if not specified.
     */
    public int getConsultationFee() {
        return 0;
    }
    /**
     * Removes an observer from the observer list.
     * This method should be overridden by subclasses to provide specific functionality.
     *
     * @param appointmentObserver the observer to be removed.
     */

    public void removeObserver(AppointmentObserver appointmentObserver)
    {

    }
    /**
     * Notifies all observers of changes.
     * This method should be overridden by subclasses to provide specific functionality.
     */
    public void notifyObserver()
    {

    }
}
