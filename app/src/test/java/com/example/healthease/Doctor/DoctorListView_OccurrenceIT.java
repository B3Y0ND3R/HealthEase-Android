//package com.example.healthease.Doctor;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//public class DoctorListView_OccurrenceIT {
//
//    @Test
//    public void test1() {
//        DoctorDetails doctor = DoctorFactory.createDoctor("Cardiologist", "Aisha Khan", "Dhanmondi", "5yrs", "01711234567", 1600);
//        DoctorDetails doctor1 = DoctorFactory.createDoctor("Cardiologist", "Eram Khan", "Dhanmondi", "5yrs", "01711234567", 1600);
//
//        assertNotNull(doctor);
//
//        ArrayList<CardiologistOccurence> a = DoctorListViewFactory.getDoctorList("Cardiologist");
//        assertEquals("Aisha Khan", a.get(0).getDoctorName());
//        assertEquals("Eram Khan", a.get(1).getDoctorName());
//        assertEquals("Dhanmondi", a.get(0).getHospitalAddress());
//        assertEquals("5yrs", a.get(0).getExperience());
//        assertEquals("01711234567", a.get(0).getMobileNo());
//        assertEquals(1600, a.get(0).getConsultationFee(), 0.0);
//    }
//
//    @Test
//    public void test2() {
//        DoctorDetails doctor = DoctorFactory.createDoctor("Family Physician", "Karim", "Gulshan", "10yrs", "01812345678", 2000);
//        DoctorDetails doctor1 = DoctorFactory.createDoctor("Family Physician", "Rahim", "Banani", "8yrs", "01887654321", 1800);
//
//        assertNotNull(doctor);
//
//        ArrayList<FamilyPhysicianOccurrence> a = DoctorListViewFactory.getDoctorList("Family Physician");
//        assertEquals("Karim", a.get(0).getDoctorName());
//        assertEquals("Rahim", a.get(1).getDoctorName());
//        assertEquals("Gulshan", a.get(0).getHospitalAddress());
//        assertEquals("10yrs", a.get(0).getExperience());
//        assertEquals("01812345678", a.get(0).getMobileNo());
//        assertEquals(2000, a.get(0).getConsultationFee(), 0.0);
//    }
//
//    @Test
//    public void test3() {
//        DoctorDetails doctor = DoctorFactory.createDoctor("Dentist", "Rahim", "Uttara", "7yrs", "01923456789", 1500);
//        DoctorDetails doctor1 = DoctorFactory.createDoctor("Dentist", "Karim", "Mirpur", "6yrs", "01987654321", 1600);
//
//        assertNotNull(doctor);
//
//        ArrayList<DentistOccurrence> a = DoctorListViewFactory.getDoctorList("Dentist");
//        assertEquals("Rahim", a.get(0).getDoctorName());
//        assertEquals("Karim", a.get(1).getDoctorName());
//        assertEquals("Uttara", a.get(0).getHospitalAddress());
//        assertEquals("7yrs", a.get(0).getExperience());
//        assertEquals("01923456789", a.get(0).getMobileNo());
//        assertEquals(1500, a.get(0).getConsultationFee(), 0.0);
//    }
//
//    @Test
//    public void test4() {
//        DoctorDetails doctor = DoctorFactory.createDoctor("dietician", "Abul", "Bashundhara", "4yrs", "01798765432", 1200);
//        DoctorDetails doctor1 = DoctorFactory.createDoctor("dietician", "Kabul", "Mohakhali", "3yrs", "01787654321", 1300);
//
//        assertNotNull(doctor);
//
//        ArrayList<DieticianOccurrence> a = DoctorListViewFactory.getDoctorList("dietician");
//        assertEquals("Abul", a.get(0).getDoctorName());
//        assertEquals("Kabul", a.get(1).getDoctorName());
//        assertEquals("Bashundhara", a.get(0).getHospitalAddress());
//        assertEquals("4yrs", a.get(0).getExperience());
//        assertEquals("01798765432", a.get(0).getMobileNo());
//        assertEquals(1200, a.get(0).getConsultationFee(), 0.0);
//    }
//
//    @Test
//    public void test5() {
//        DoctorDetails doctor = DoctorFactory.createDoctor("Surgeon", "James", "Malibagh", "12yrs", "01612345678", 2500);
//        DoctorDetails doctor1 = DoctorFactory.createDoctor("Surgeon", "Eram", "Khilgaon", "10yrs", "01687654321", 2400);
//
//        assertNotNull(doctor);
//
//        ArrayList<SurgeonOccurrence> a = DoctorListViewFactory.getDoctorList("Surgeon");
//        assertEquals("James", a.get(0).getDoctorName());
//        assertEquals("Eram", a.get(1).getDoctorName());
//        assertEquals("Malibagh", a.get(0).getHospitalAddress());
//        assertEquals("12yrs", a.get(0).getExperience());
//        assertEquals("01612345678", a.get(0).getMobileNo());
//        assertEquals(2500, a.get(0).getConsultationFee(), 0.0);
//    }
//}
