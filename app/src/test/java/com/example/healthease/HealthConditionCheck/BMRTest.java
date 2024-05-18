package com.example.healthease.HealthConditionCheck;

import static org.junit.Assert.*;

import org.junit.Test;

public class BMRTest {

    @Test
    public void testCalculateBMR_Male() {
        double weight = 70;
        double height = 170;
        double age = 30;
        String sex = "Male";

        BMR bmrCalculator = new BMR(weight, height, age, sex);

        double expectedBMR = (10 * weight) + (6.25 * height) - (5 * age) + 5;

        assertEquals(expectedBMR, Double.parseDouble(bmrCalculator.getResult()), 0.01);
    }

    @Test
    public void testCalculateBMR_Female() {
        double weight = 60;
        double height = 160;
        double age = 25;
        String sex = "Female";

        BMR bmrCalculator = new BMR(weight, height, age, sex);

        double expectedBMR = (10 * weight) + (6.25 * height) - (5 * age) - 161;

        assertEquals(expectedBMR, Double.parseDouble(bmrCalculator.getResult()), 0.01);
    }

    @Test
    public void testCalculateBMR_InvalidSex() {
        double weight = 65;
        double height = 165;
        double age = 35;
        String sex = "InvalidSex";

        BMR bmrCalculator = new BMR(weight, height, age, sex);

        assertEquals(0, Double.parseDouble(bmrCalculator.getResult()), 0.01);
    }

}