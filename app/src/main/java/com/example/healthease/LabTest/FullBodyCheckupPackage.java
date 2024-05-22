package com.example.healthease.LabTest;

public class FullBodyCheckupPackage implements LabTestPackage {
    @Override
    public String getName() {
        return "Package 1: Full Body Checkup";
    }

    @Override
    public String getDetails() {
        return "Details about package 1";
    }

    @Override
    public int getCost() {
        return 999;
    }
}