//package com.example.healthease.Doctor;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import static org.junit.Assert.*;
//
//public class DoctorDetailsAdapter_DoctorFactoryIT {
//
//    private static String[][] doctorDetailsArray;
//
//    @BeforeClass
//    public static void setUp() {
//        doctorDetailsArray = new String[][] {
//                {"Specialist : Cardiologist", "Doctor Name : Sakib", "Hospital Address : Heart Hospital", "Exp : 10 years", "Mobile No: +0179411768", "200"},
//                {"Specialist : Dentist", "Doctor Name : Sadman", "Hospital Address : City Clinic", "Exp : 8 years", "Mobile No: +01794111768", "150"},
//                {"Specialist : Dietician", "Doctor Name : Sakib", "Hospital Address : Heart Hospital", "Exp : 10 years", "Mobile No: +0179411768", "200"},
//                {"Specialist : Family Physician", "Doctor Name : Sadman", "Hospital Address : City Clinic", "Exp : 8 years", "Mobile No: +01794111768", "150"},
//                {"Specialist : Surgeon", "Doctor Name : Sakib", "Hospital Address : Heart Hospital", "Exp : 10 years", "Mobile No: +0179411768", "200"}
//        };
//
//
//    }
//
//    @Test
//   public void test1()
//    {
//
//
//        List<DoctorDetails> a =  DoctorDetailsAdapter.adapt(doctorDetailsArray);
//
//        assertEquals("Sakib", a.get(0).getDoctorName());
//        assertEquals("Heart Hospital", a.get(0).getHospitalAddress());
//        assertEquals("10 years", a.get(0).getExperience());
//        assertEquals("+0179411768", a.get(0).getMobileNo());
//        assertEquals(200, a.get(0).getConsultationFee());
//
//        assertEquals("Sadman", a.get(1).getDoctorName());
//        assertEquals("City Clinic", a.get(1).getHospitalAddress());
//        assertEquals("8 years", a.get(1).getExperience());
//        assertEquals("+01794111768", a.get(1).getMobileNo());
//        assertEquals(150, a.get(1).getConsultationFee());
//
//    }
//
//    @Test
//    public void test2()
//    {
//        Cardiologist cardiologist = Cardiologist.getInstance();
//
//
//        DoctorDetailsAdapter.adapt(doctorDetailsArray);
//
//        List<CardiologistOccurence> a =  cardiologist.getCardiologistOccurrences();
//
//        assertEquals("Sakib", a.get(0).getDoctorName());
//        assertEquals("Heart Hospital", a.get(0).getHospitalAddress());
//        assertEquals("10 years", a.get(0).getExperience());
//        assertEquals("+0179411768", a.get(0).getMobileNo());
//        assertEquals(200, a.get(0).getConsultationFee());
//
//
//
//    }
//
//    @Test
//    public void test3()
//    {
//
//        Dentists dentists = Dentists.getInstance();
//
//
//        DoctorDetailsAdapter.adapt(doctorDetailsArray);
//
//
//        List<DentistOccurrence> a =  dentists.getDentistOccurrences();
//        assertEquals("Sadman", a.get(0).getDoctorName());
//        assertEquals("City Clinic", a.get(0).getHospitalAddress());
//        assertEquals("8 years", a.get(0).getExperience());
//        assertEquals("+01794111768", a.get(0).getMobileNo());
//        assertEquals(150, a.get(0).getConsultationFee());
//    }
//
//    @Test
//    public void test4()
//    {
//        Dietisians dietisians = Dietisians.getInstance();
//
//
//        DoctorDetailsAdapter.adapt(doctorDetailsArray);
//
//        List<DieticianOccurrence> a =  dietisians.getDieticianOccurrences();
//
//        assertEquals("Sakib", a.get(0).getDoctorName());
//        assertEquals("Heart Hospital", a.get(0).getHospitalAddress());
//        assertEquals("10 years", a.get(0).getExperience());
//        assertEquals("+0179411768", a.get(0).getMobileNo());
//        assertEquals(200, a.get(0).getConsultationFee());
//
//
//
//    }
//
//    @Test
//    public void test5()
//    {
//
//        FamilyPhysicians familyPhysicians = FamilyPhysicians.getInstance();
//
//
//        DoctorDetailsAdapter.adapt(doctorDetailsArray);
//
//
//        List<FamilyPhysicianOccurrence> a =  familyPhysicians.getFamilyPhysicianOccurrences();
//        assertEquals("Sadman", a.get(0).getDoctorName());
//        assertEquals("City Clinic", a.get(0).getHospitalAddress());
//        assertEquals("8 years", a.get(0).getExperience());
//        assertEquals("+01794111768", a.get(0).getMobileNo());
//        assertEquals(150, a.get(0).getConsultationFee());
//    }
//
//    @Test
//    public void test6()
//    {
//        Surgeons surgeons = Surgeons.getInstance();
//
//
//        DoctorDetailsAdapter.adapt(doctorDetailsArray);
//
//        List<SurgeonOccurrence> a =  surgeons.getSurgeonOccurrences();
//
//        assertEquals("Sakib", a.get(0).getDoctorName());
//        assertEquals("Heart Hospital", a.get(0).getHospitalAddress());
//        assertEquals("10 years", a.get(0).getExperience());
//        assertEquals("+0179411768", a.get(0).getMobileNo());
//        assertEquals(200, a.get(0).getConsultationFee());
//
//
//
//    }
//
//
//
//}
