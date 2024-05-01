package com.example.healthease.LabTest;


public class ThyroidCheck implements LabTestPackage{
    @Override
    public String getName() {
        return "Package 4: Thyroid Check";
    }

    @Override
    public String getDetails() {
        return "Details about package 4";
    }

    @Override
    public int getCost() {
        return 850;
    }
}