package com.example.healthease.Doctor;

/**
 * Represents an occurrence of a cardiologist.
 * Extends the {@link DoctorDetails} class and implements the {@link AppointmentObserver} interface.
 * This class contains details about a cardiologist and provides functionality to update and retrieve the total number of appointments in this category.
 */
public class CardiologistOccurence extends DoctorDetails implements AppointmentObserver{
    private String doctorName;
    private String hospitalAddress;
    private String experience;
    private String mobileNo;
    private int consultationFee;
    private int totalAppointmentInThisCategory;

    /**
     * Constructs a new CardiologistOccurence with the specified details.
     *
     * @param doctorName the name of the cardiologist.
     * @param hospitalAddress the address of the hospital.
     * @param experience the experience of the cardiologist.
     * @param mobileNo the mobile number of the cardiologist.
     * @param consultationFee the consultation fee of the cardiologist.
     */
    public CardiologistOccurence(String doctorName, String hospitalAddress, String experience, String mobileNo, int consultationFee) {
       super("Cardiologist");
        this.doctorName = doctorName;
        this.hospitalAddress = hospitalAddress;
        this.experience = experience;
        this.mobileNo = mobileNo;
        this.consultationFee = consultationFee;
        this.totalAppointmentInThisCategory=0;
    }
    /**
     * Updates the total number of appointments in this category.
     *
     * @param a the total number of appointments.
     */
    public void updateTotalAppointmentInThisCategory(int a)
    {
        this.totalAppointmentInThisCategory=a;
    }
    /**
     * Returns the total number of appointments in this category.
     *
     * @return the total number of appointments.
     */
    public int getTotalAppointmentInThisCategory()
    {
        return totalAppointmentInThisCategory ;
    }
    /**
     * Returns the name of the cardiologist.
     *
     * @return the name of the cardiologist.
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
     * Returns the experience of the cardiologist.
     *
     * @return the experience of the cardiologist.
     */
    @Override
    public String getExperience() {
        return experience;
    }
    /**
     * Returns the mobile number of the cardiologist.
     *
     * @return the mobile number of the cardiologist.
     */
    @Override
    public String getMobileNo() {
        return mobileNo;
    }
    /**
     * Returns the consultation fee of the cardiologist.
     *
     * @return the consultation fee of the cardiologist.
     */
    @Override
    public int getConsultationFee() {
        return consultationFee;
    }

}
