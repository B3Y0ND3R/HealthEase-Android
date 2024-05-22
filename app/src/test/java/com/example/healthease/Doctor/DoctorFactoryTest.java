package com.example.healthease.Doctor;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoctorFactoryTest {




    @Test
    public void testCreateCardiologist() {
        DoctorDetails doctor = DoctorFactory.createDoctor("Cardiologist", "Aisha Khan", "Dhanmondi", "5yrs", "01711234567", 1600);
        assertNotNull(doctor);
        assertTrue(doctor instanceof CardiologistOccurence);

        CardiologistOccurence cardiologist = (CardiologistOccurence) doctor;
        assertEquals("Aisha Khan", cardiologist.getDoctorName());
        assertEquals("Dhanmondi", cardiologist.getHospitalAddress());
        assertEquals("5yrs", cardiologist.getExperience());
        assertEquals("01711234567", cardiologist.getMobileNo());
        assertEquals(1600, cardiologist.getConsultationFee());

        assertEquals(1, Cardiologist.getInstance().getCardiologistOccurrences().size());
    }

    @Test
    public void testCreateFamilyPhysician() {
        DoctorDetails doctor = DoctorFactory.createDoctor("Family Physician", "Parveen Sultana", "Dhanmondi", "9yrs", "01711234591", 1500);
        assertNotNull(doctor);
        assertTrue(doctor instanceof FamilyPhysicianOccurrence);

        FamilyPhysicianOccurrence familyPhysician = (FamilyPhysicianOccurrence) doctor;
        assertEquals("Parveen Sultana", familyPhysician.getDoctorName());
        assertEquals("Dhanmondi", familyPhysician.getHospitalAddress());
        assertEquals("9yrs", familyPhysician.getExperience());
        assertEquals("01711234591", familyPhysician.getMobileNo());
        assertEquals(1500, familyPhysician.getConsultationFee());

        assertEquals(1, FamilyPhysicians.getInstance().getFamilyPhysicianOccurrences().size());
    }

    @Test
    public void testCreateDietician() {
        DoctorDetails doctor = DoctorFactory.createDoctor("Dietician", "Leena Rahman", "Dhanmondi", "3yrs", "01711234585", 800);
        assertNotNull(doctor);
        assertTrue(doctor instanceof DieticianOccurrence);

        DieticianOccurrence dietician = (DieticianOccurrence) doctor;
        assertEquals("Leena Rahman", dietician.getDoctorName());
        assertEquals("Dhanmondi", dietician.getHospitalAddress());
        assertEquals("3yrs", dietician.getExperience());
        assertEquals("01711234585", dietician.getMobileNo());
        assertEquals(800, dietician.getConsultationFee());

        assertEquals(1, Dietisians.getInstance().getDieticianOccurrences().size());
    }

    @Test
    public void testCreateDentist() {
        DoctorDetails doctor = DoctorFactory.createDoctor("Dentist", "Afsana Islam", "Dhanmondi", "4yrs", "01711234579", 900);
        assertNotNull(doctor);
        assertTrue(doctor instanceof DentistOccurrence);

        DentistOccurrence dentist = (DentistOccurrence) doctor;
        assertEquals("Afsana Islam", dentist.getDoctorName());
        assertEquals("Dhanmondi", dentist.getHospitalAddress());
        assertEquals("4yrs", dentist.getExperience());
        assertEquals("01711234579", dentist.getMobileNo());
        assertEquals(900, dentist.getConsultationFee());

        assertEquals(1, Dentists.getInstance().getDentistOccurrences().size());
    }

    @Test
    public void testCreateSurgeon() {
        DoctorDetails doctor = DoctorFactory.createDoctor("Surgeon", "Imran Hasan", "Dhanmondi", "12yrs", "01711234573", 2000);
        assertNotNull(doctor);
        assertTrue(doctor instanceof SurgeonOccurrence);

        SurgeonOccurrence surgeon = (SurgeonOccurrence) doctor;
        assertEquals("Imran Hasan", surgeon.getDoctorName());
        assertEquals("Dhanmondi", surgeon.getHospitalAddress());
        assertEquals("12yrs", surgeon.getExperience());
        assertEquals("01711234573", surgeon.getMobileNo());
        assertEquals(2000, surgeon.getConsultationFee());

        assertEquals(1, Surgeons.getInstance().getSurgeonOccurrences().size());
    }
}
