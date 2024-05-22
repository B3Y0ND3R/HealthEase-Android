package com.example.healthease.Doctor;

import static com.example.healthease.Doctor.TotalAppointmentFactory.updateAppointmentNumber;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TotalAppointmentNotifyIT {



    @Test
    public void test1()
    {
        Cardiologist cardiologist = Cardiologist.getInstance();
        updateAppointmentNumber("cardiologist", 10);
        CardiologistOccurence a = new CardiologistOccurence("sakib", "khulna medical college", "7yr", "01794111768",1000);
        cardiologist.addCardiologist(a);
        cardiologist.notifyObserver();
        assertEquals(10,a.getTotalAppointmentInThisCategory(),0.0);
    }
    @Test
    public void testCardiologist() {
        Cardiologist cardiologist = Cardiologist.getInstance();
        TotalAppointmentFactory.updateAppointmentNumber("cardiologist", 10);
        CardiologistOccurence a = new CardiologistOccurence("sakib", "khulna medical college", "7yr", "01794111768", 1000);
        cardiologist.addCardiologist(a);
        cardiologist.notifyObserver();
        assertEquals(10, a.getTotalAppointmentInThisCategory(), 0.0);
    }

    @Test
    public void testDentist() {
        Dentists dentists = Dentists.getInstance();
        TotalAppointmentFactory.updateAppointmentNumber("dentist", 15);
        DentistOccurrence d = new DentistOccurrence("emily", "dental care clinic", "5yr", "01711112222", 1500);
        dentists.addDentist(d);
        dentists.notifyObserver();
        assertEquals(15, d.getTotalAppointmentInThisCategory(), 0.0);
    }

    @Test
    public void testDietitian() {
        Dietisians dietitians = Dietisians.getInstance();
        TotalAppointmentFactory.updateAppointmentNumber("dietician", 8);
        DieticianOccurrence di = new DieticianOccurrence("sophia", "healthy diet center", "3yr", "01888887777", 1200);
        dietitians.addDietician(di);
        dietitians.notifyObserver();
        assertEquals(8, di.getTotalAppointmentInThisCategory(), 0.0);
    }

    @Test
    public void testSurgeon() {
        Surgeons surgeons = Surgeons.getInstance();
        TotalAppointmentFactory.updateAppointmentNumber("surgeon", 20);
        SurgeonOccurrence s = new SurgeonOccurrence("liam", "city hospital", "10yr", "01666665555", 2500);
        surgeons.addSurgeon(s);
        surgeons.notifyObserver();
        assertEquals(20, s.getTotalAppointmentInThisCategory(), 0.0);
    }

    @Test
    public void testFamilyPhysician() {
        FamilyPhysicians familyPhysicians = FamilyPhysicians.getInstance();
        TotalAppointmentFactory.updateAppointmentNumber("family physician", 12);
        FamilyPhysicianOccurrence f = new FamilyPhysicianOccurrence("emon", "community health center", "6yr", "01999998888", 2000);
        familyPhysicians.addFamilyPhysician(f);
        familyPhysicians.notifyObserver();
        assertEquals(12, f.getTotalAppointmentInThisCategory(), 0.0);
    }

}