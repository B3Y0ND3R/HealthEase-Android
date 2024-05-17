package com.example.healthease.HealthConditionCheck;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactoryTest {
    @Test
    public void testGetConditionObject_BMI() {
        double weight = 70;
        double height = 170;

        ConditionCheck bmiCalculator = Factory.getConditionObject("BMI", weight, height, 0, null);

        assertNotNull(bmiCalculator);
        assertTrue(bmiCalculator instanceof BMI);
    }

    @Test
    public void testGetConditionObject_BMR() {
        double weight = 70;
        double height = 170;
        double age = 30;
        String sex = "Male";

        ConditionCheck bmrCalculator = Factory.getConditionObject("BMR", weight, height, age, sex);

        assertNotNull(bmrCalculator);
        assertTrue(bmrCalculator instanceof BMR);
    }

    @Test
    public void testGetConditionObject_InvalidType() {
        double weight = 70;
        double height = 170;
        double age = 30;
        String sex = "Male";

        ConditionCheck conditionCheck = Factory.getConditionObject("InvalidType", weight, height, age, sex);

        assertNull(conditionCheck);
    }

}