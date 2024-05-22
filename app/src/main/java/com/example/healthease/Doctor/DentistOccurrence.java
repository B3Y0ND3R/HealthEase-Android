package com.example.healthease.Doctor;

/**
 * Represents an occurrence of a dentist.
 * Extends the {@link DoctorDetails} class and implements the {@link AppointmentObserver} interface.
 * This class contains details about a dentist and provides functionality to update and retrieve the total number of appointments in this category.
 */
public class DentistOccurrence extends DoctorDetails implements AppointmentObserver {
    private String doctorName;
    private String hospitalAddress;
    private String experience;
    private String mobileNo;
    private int consultationFee;
    private int totalAppointmentInThisCategory;
    /**
     * Constructs a new DentistOccurrence with the specified details.
     *
     * @param doctorName the name of the dentist.
     * @param hospitalAddress the address of the hospital.
     * @param experience the experience of the dentist.
     * @param mobileNo the mobile number of the dentist.
     * @param consultationFee the consultation fee of the dentist.
     */
    public DentistOccurrence(String doctorName, String hospitalAddress, String experience, String mobileNo, int consultationFee) {
        super("Dentist");
        this.doctorName = doctorName;
        this.hospitalAddress = hospitalAddress;
        this.experience = experience;
        this.mobileNo = mobileNo;
        this.consultationFee = consultationFee;
        this.totalAppointmentInThisCategory = 0;
    }
    /**
     * Updates the total number of appointments in this category.
     *
     * @param totalAppointments the total number of appointments.
     */
    public void updateTotalAppointmentInThisCategory(int totalAppointments) {
        this.totalAppointmentInThisCategory = totalAppointments;
    }
    /**
     * Returns the total number of appointments in this category.
     *
     * @return the total number of appointments.
     */
    public int getTotalAppointmentInThisCategory() {
        return totalAppointmentInThisCategory;
    }
    /**
     * Returns the name of the dentist.
     *
     * @return the name of the dentist.
     */
    @Override
    public String getDoctorName() {
        return doctorName;
    }
    /**
     * Returns the address of the hospital.
     *
     * @return the address of the hospital.
     */
    @Override
    public String getHospitalAddress() {
        return hospitalAddress;
    }
    /**
     * Returns the experience of the dentist.
     *
     * @return the experience of the dentist.
     */
    @Override
    public String getExperience() {
        return experience;
    }
    /**
     * Returns the mobile number of the dentist.
     *
     * @return the mobile number of the dentist.
     */
    @Override
    public String getMobileNo() {
        return mobileNo;
    }
    /**
     * Returns the consultation fee of the dentist.
     *
     * @return the consultation fee of the dentist.
     */
    @Override
    public int getConsultationFee() {
        return consultationFee;
    }
}
