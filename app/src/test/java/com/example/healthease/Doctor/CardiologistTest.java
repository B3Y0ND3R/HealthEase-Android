package com.example.healthease.Doctor;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.example.healthease.Doctor.Cardiologist;

public class CardiologistTest {

    private Cardiologist cardiologist;

    @Before
    public void setUp() {
        cardiologist = Cardiologist.getInstance();
        cardiologist.getCardiologistOccurrences().clear();
        cardiologist.setTotalAppointment(0);
    }

    @Test
    public void testSingletonInstance() {
        Cardiologist a = Cardiologist.getInstance();
        Cardiologist b = Cardiologist.getInstance();
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void testAddCardiologistOccurrence() {
        CardiologistOccurence occurrence = mock(CardiologistOccurence.class);
        cardiologist.addCardiologist(occurrence);
        ArrayList<CardiologistOccurence> occurrences = cardiologist.getCardiologistOccurrences();
        assertTrue("Occurrence should be added to the list", occurrences.contains(occurrence));
    }

    @Test
    public void testAddRemoveObserver() {
        CardiologistOccurence occurrence1 = new CardiologistOccurence("Sakib" , "Dhaka" , "5yr" , "01794111768",100 );
        CardiologistOccurence occurrence2 = new CardiologistOccurence("Sakib1" , "Dhaka" , "5yr" , "01794111768",100 );

        cardiologist.addCardiologist(occurrence1);
        cardiologist.addCardiologist(occurrence2);
        assertEquals(2,cardiologist.getCardiologistOccurrences().size());
        cardiologist.removeObserver(occurrence2);
        assertEquals(1,cardiologist.getCardiologistOccurrences().size());
        cardiologist.addCardiologist(occurrence2);
        assertEquals(2,cardiologist.getCardiologistOccurrences().size());
    }

    @Test
    public void testNotifyObservers() {
        CardiologistOccurence occurrence1 = new CardiologistOccurence("Sakib" , "Dhaka" , "5yr" , "01794111768",100 );
        CardiologistOccurence occurrence2 = new CardiologistOccurence("Sakib1" , "Dhaka" , "5yr" , "01794111768",100 );

        cardiologist.addCardiologist(occurrence1);
        cardiologist.addCardiologist(occurrence2);

        cardiologist.setTotalAppointment(5);
        cardiologist.notifyObserver();

        assertEquals(5,cardiologist.getCardiologistOccurrences().get(0).getTotalAppointmentInThisCategory());
        assertEquals(5,cardiologist.getCardiologistOccurrences().get(1).getTotalAppointmentInThisCategory());

    }

    @Test
    public void testSetAndGetTotalAppointment() {
        cardiologist.setTotalAppointment(10);
        assertEquals("Total appointments should be set to 10", 10, cardiologist.getTotalAppointment());
    }
}
