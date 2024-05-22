package com.example.healthease.HealthConditionCheck;

public class Factory {
    public static ConditionCheck getConditionObject(String type, double weight, double height, double age, String sex) {
        if (type.equalsIgnoreCase("BMI")) {
            return new BMI(weight, height);
        } else if (type.equalsIgnoreCase("BMR")) {
            return new BMR(weight, height, age, sex);
        }
        return null;
    }
}