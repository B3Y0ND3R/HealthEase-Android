package com.example.healthease.LabTest;


public class ImmunityCheck implements LabTestPackage{
    @Override
    public String getName() {
        return "Package 5: Immunity Check";
    }

    @Override
    public String getDetails() {
        return "Details about package 5";
    }

    @Override
    public int getCost() {
        return 396;
    }
}
