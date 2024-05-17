package com.example.healthease.HealthConditionCheck;

public class BMR implements ConditionCheck {
    private double weight, height, age, bmrIndex;
    private String sex;

    public BMR(double weight, double height, double age, String sex) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.sex = sex;
        this.bmrIndex = calculateBMR();
    }

    private double calculateBMR() {
        if (sex.equalsIgnoreCase("Male")) {
            return (10 * weight) + (6.25 * height) - (5 * age) + 5;
        } else if (sex.equalsIgnoreCase("Female")) {
            return (10 * weight) + (6.25 * height) - (5 * age) - 161;
        } else {
            return 0;
        }
    }

    @Override
    public String getResult() {
        return String.format("%.2f", bmrIndex);
    }
}
