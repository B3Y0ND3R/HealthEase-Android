package com.example.healthease.LabTest;

import static org.junit.Assert.*;

import com.example.healthease.Doctor.DoctorDetails;
import com.example.healthease.Doctor.DoctorDetailsFactory;
import com.example.healthease.Doctor.FamilyPhysicians;

import org.junit.Test;

public class LabTestPackageFactoryTest {

    @Test
    public void testFullBodyCheckupPackageCreation() {
        LabTestPackageFactory factory = LabTestPackageFactory.getInstance();
        LabTestPackage labTestPackage = factory.createPackage(1);
        assertTrue(labTestPackage instanceof FullBodyCheckupPackage);
    }

    @Test
    public void testBloodGlucoseFastingPackageCreation() {
        LabTestPackageFactory factory = LabTestPackageFactory.getInstance();
        LabTestPackage labTestPackage = factory.createPackage(2);
        assertTrue(labTestPackage instanceof BloodGlucoseFastingPackage);
    }

    @Test
    public void testCOVID19AntibodyIgGPackageCreation() {
        LabTestPackageFactory factory = LabTestPackageFactory.getInstance();
        LabTestPackage labTestPackage = factory.createPackage(3);
        assertTrue(labTestPackage instanceof COVID19AntibodyIgG);
    }

    @Test
    public void testThyroidCheckPackageCreation() {
        LabTestPackageFactory factory = LabTestPackageFactory.getInstance();
        LabTestPackage labTestPackage = factory.createPackage(4);
        assertTrue(labTestPackage instanceof ThyroidCheck);
    }

    @Test
    public void testImmunityCheckPackageCreation() {
        LabTestPackageFactory factory = LabTestPackageFactory.getInstance();
        LabTestPackage labTestPackage = factory.createPackage(5);
        assertTrue(labTestPackage instanceof ImmunityCheck);
    }

//    @Test
//    public void testInvalidPackageId() {
//        LabTestPackageFactory factory = LabTestPackageFactory.getInstance();
//        assertThrows(IllegalArgumentException.class, () -> {
//            LabTestPackage labTestPackage = factory.createPackage(99);
//        }, "Expected IllegalArgumentException for invalid package ID");
//    }


}