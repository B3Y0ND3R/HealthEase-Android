package com.example.healthease.LabTest;

public class LabTestPackageFactory {

    private static LabTestPackageFactory instance;

    public static LabTestPackageFactory getInstance() {
        if (instance == null) {
            instance = new LabTestPackageFactory();
        }
        return instance;
    }

    public LabTestPackage createPackage(int packageId) {
        switch (packageId) {
            case 1:
                return new FullBodyCheckupPackage();
            case 2:
                return new BloodGlucoseFastingPackage();
            case 3:
                return new COVID19AntibodyIgG();
            case 4:
                return new ThyroidCheck();
            case 5:
                return new ImmunityCheck();
            default:
                throw new IllegalArgumentException("Invalid package ID");
        }
    }
}
