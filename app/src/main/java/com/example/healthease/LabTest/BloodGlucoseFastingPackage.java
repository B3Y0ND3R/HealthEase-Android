package com.example.healthease.LabTest;

public class BloodGlucoseFastingPackage implements LabTestPackage {
    @Override
    public String getName() {
        return "Package 2: Blood Glucose Fasting";
    }

    @Override
    public String getDetails() {
        return "Details about package 2";
    }

    @Override
    public int getCost() {
        return 299;
    }
}