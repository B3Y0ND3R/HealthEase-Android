package com.example.healthease.Doctor;

/**
 * Represents a surgeon and their details.
 * Implements the AppointmentObserver interface to observe appointment changes.
 */
public class SurgeonOccurrence extends DoctorDetails implements AppointmentObserver {
    private String doctorName;
    private String hospitalAddress;
    private String experience;
    private String mobileNo;
    private int consultationFee;
    private int totalAppointmentInThisCategory;
    /**
     * Constructs a SurgeonOccurrence with the given details.
     *
     * @param doctorName        The name of the doctor
     * @param hospitalAddress   The address of the hospital where the doctor practices
     * @param experience        The experience of the doctor
     * @param mobileNo          The mobile number of the doctor
     * @param consultationFee   The consultation fee of the doctor
     */
    public SurgeonOccurrence(String doctorName, String hospitalAddress, String experience, String mobileNo, int consultationFee) {
        super("Surgeon");
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
     * @param totalAppointments The total number of appointments
     */
    public void updateTotalAppointmentInThisCategory(int totalAppointments) {
        this.totalAppointmentInThisCategory = totalAppointments;
    }
    /**
     * Returns the total number of appointments in this category.
     *
     * @return The total number of appointments
     */
    public int getTotalAppointmentInThisCategory() {
        return totalAppointmentInThisCategory;
    }
    /**
     * Returns the name of the doctor.
     *
     * @return The doctor's name
     */
    @Override
    public String getDoctorName() {
        return doctorName;
    }
    /**
     * Returns the address of the hospital where the doctor practices.
     *
     * @return The hospital address
     */
    @Override
    public String getHospitalAddress() {
        return hospitalAddress;
    }
    /**
     * Returns the experience of the doctor.
     *
     * @return The doctor's experience
     */
    @Override
    public String getExperience() {
        return experience;
    }
    /**
     * Returns the mobile number of the doctor.
     *
     * @return The doctor's mobile number
     */
    @Override
    public String getMobileNo() {
        return mobileNo;
    }
    /**
     * Returns the consultation fee of the doctor.
     *
     * @return The consultation fee
     */
    @Override
    public int getConsultationFee() {
        return consultationFee;
    }
}
