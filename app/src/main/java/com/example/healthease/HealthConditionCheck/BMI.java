package com.example.healthease.HealthConditionCheck;
/**
 * The {@code BMI} class calculates and evaluates the Body Mass Index (BMI)
 * based on the provided weight and height.
 * It implements the {@code ConditionCheck} interface.
 *
 * <p>The BMI is calculated using the formula:</p>
 * <pre>
 *     BMI = weight / (height * height)
 * </pre>
 *
 * <p>It then categorizes the BMI into one of three categories:</p>
 * <ul>
 *     <li>Overweight: BMI > 24</li>
 *     <li>Normal weight: 18 < BMI <= 24</li>
 *     <li>Underweight: BMI <= 18</li>
 * </ul>
 *
 * <p>Example usage:</p>
 * <pre>
 *     BMI bmi = new BMI(70, 1.75);
 *     String result = bmi.getResult();
 *     System.out.println(result);
 * </pre>
 *
 * @see ConditionCheck
 */
public class BMI implements ConditionCheck {
    double weight, height, bmiIndex;
    /**
     * Constructs a {@code BMI} instance with the specified weight and height.
     *
     * @param weight the weight in kilograms
     * @param height the height in meters
     */
    public BMI(double weight, double height) {
        this.weight = weight;
        this.height = height;
        bmiIndex = weight / (height * height);
    }
    /**
     * Returns the BMI result as a string, indicating the category and the BMI value.
     *
     * @return a string representing the BMI category and value
     */
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
