package com.example.healthease.HealthConditionCheck;

import static org.junit.Assert.*;

import org.junit.Test;

public class BMITest {

    @Test
    public void testBMI() {
        BMI overweightBMI = new BMI(80, 1.70);
        assertEquals("Overweight and BMI index is 27.68", overweightBMI.getResult());

        BMI normalBMI = new BMI(65, 1.70);
        assertEquals("Normal weight and BMI index is: 22.49", normalBMI.getResult());

        BMI underweightBMI = new BMI(50, 1.70);
        assertEquals("Underweight and BMI index is: 17.30", underweightBMI.getResult());
    }

}