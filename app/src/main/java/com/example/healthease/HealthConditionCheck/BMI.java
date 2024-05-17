package com.example.healthease.HealthConditionCheck;

public class BMI implements ConditionCheck {
    double weight, height, bmiIndex;

    public BMI(double weight, double height) {
        this.weight = weight;
        this.height = height;
        bmiIndex = weight / (height * height);
    }

    @Override
    public String getResult() {
        String result;
        if (bmiIndex > 24) {
            result = "Overweight and BMI index is " + String.format("%.2f", bmiIndex);
        } else if (bmiIndex > 18) {
            result = "Normal weight and BMI index is: " + String.format("%.2f", bmiIndex);
        } else {
            result = "Underweight and BMI index is: " + String.format("%.2f", bmiIndex);
        }
        return result;
    }
}
