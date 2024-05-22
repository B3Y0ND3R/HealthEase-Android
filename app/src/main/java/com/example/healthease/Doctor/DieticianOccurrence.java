package com.example.healthease.Doctor;

/**
 * Represents an occurrence of a dietician.
 * Extends the {@link DoctorDetails} class and implements the {@link AppointmentObserver} interface.
 * This class contains details about a dietician and provides functionality to update and retrieve the total number of appointments in this category.
 */
public class DieticianOccurrence extends DoctorDetails implements AppointmentObserver {
    private String doctorName;
    private String hospitalAddress;
    private String experience;
    private String mobileNo;
    private int consultationFee;
    private int totalAppointmentInThisCategory;
    /**
     * Constructs a new DieticianOccurrence with the specified details.
     *
     * @param doctorName the name of the dietician.
     * @param hospitalAddress the address of the hospital.
     * @param experience the experience of the dietician.
     * @param mobileNo the mobile number of the dietician.
     * @param consultationFee the consultation fee of the dietician.
     */
    public DieticianOccurrence(String doctorName, String hospitalAddress, String experience, String mobileNo, int consultationFee) {
        super("Dietician");
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
    @Override
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
     * Returns the name of the dietician.
     *
     * @return the name of the dietician.
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
     * Returns the experience of the dietician.
     *
     * @return the experience of the dietician.
     */
    @Override
    public String getExperience() {
        return experience;
    }
    /**
     * Returns the mobile number of the dietician.
     *
     * @return the mobile number of the dietician.
     */
    @Override
    public String getMobileNo() {
        return mobileNo;
    }
    /**
     * Returns the consultation fee of the dietician.
     *
     * @return the consultation fee of the dietician.
     */
    @Override
    public int getConsultationFee() {
        return consultationFee;
    }
}
