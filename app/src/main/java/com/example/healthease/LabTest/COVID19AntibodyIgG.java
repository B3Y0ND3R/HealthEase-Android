package com.example.healthease.LabTest;

public class COVID19AntibodyIgG implements LabTestPackage{
    @Override
    public String getName() {
        return "Package 3: COVID-19 Antibody - IgG";
    }

    @Override
    public String getDetails() {
        return "Details about package 3";
    }

    @Override
    public int getCost() {
        return 420;
    }
}
