package com.example.healthease.Doctor;


import java.util.ArrayList;
import java.util.List;
/**
 * Adapter class for converting a 2D array of doctor details into a list of {@link DoctorDetails} objects.
 * This class ensures that the adaptation process is only performed once.
 */
public class DoctorDetailsAdapter {
    private static boolean hasCalled = false;
    /**
     * Converts a 2D array of doctor details into a list of {@link DoctorDetails} objects.
     * Each element of the input array represents a doctor's details, which are parsed and used to create specific doctor instances.
     * This method ensures that the adaptation process is only performed once.
     *
     * @param doctorDetailsArray a 2D array of doctor details, where each element is an array of strings representing the details of a doctor.
     * @return a list of {@link DoctorDetails} objects, or null if the method has already been called.
     */
    public static List<DoctorDetails> adapt(String[][] doctorDetailsArray) {
        if(hasCalled) return null;
        hasCalled = true;

        Cardiologist cardiologist = Cardiologist.getInstance();
        FamilyPhysicians familyPhysicians = FamilyPhysicians.getInstance();
        Surgeons surgeons = Surgeons.getInstance();
        Dentists dentists = Dentists.getInstance();
        Dietisians dietisians = Dietisians.getInstance();
        List<DoctorDetails> doctorList = new ArrayList<>();
        for (String[] details : doctorDetailsArray) {
            String specialist = "";
            String doctorName = "";
            String hospitalAddress = "";
            String experience = "";
            String mobileNo = "";
            int consultationFee = 0;
            for (String detail : details) {
                if(detail.startsWith("Specialist :"))
                {
                    specialist = detail.substring(13).trim();
                }
                else if (detail.startsWith("Doctor Name :")) {
                    doctorName = detail.substring(14).trim();
                } else if (detail.startsWith("Hospital Address :")) {
                    hospitalAddress = detail.substring(18).trim();
                } else if (detail.startsWith("Exp :")) {
                    experience = detail.substring(6).trim();
                } else if (detail.startsWith("Mobile No:")) {
                    mobileNo = detail.substring(11).trim();
                } else {
                    consultationFee = Integer.parseInt(detail);
                }
            }

                doctorList.add(DoctorFactory.createDoctor(specialist, doctorName, hospitalAddress, experience, mobileNo, consultationFee));

        }
        return doctorList;
    }
}
