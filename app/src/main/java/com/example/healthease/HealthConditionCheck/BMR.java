package com.example.healthease.HealthConditionCheck;
/**
 * The {@code BMR} class calculates the Basal Metabolic Rate (BMR)
 * based on the provided weight, height, age, and sex.
 * It implements the {@code ConditionCheck} interface.
 *
 * <p>The BMR is calculated using the Harris-Benedict equation:</p>
 * <ul>
 *     <li>For males: BMR = (10 * weight) + (6.25 * height) - (5 * age) + 5</li>
 *     <li>For females: BMR = (10 * weight) + (6.25 * height) - (5 * age) - 161</li>
 * </ul>
 *
 * <p>Example usage:</p>
 * <pre>
 *     BMR bmr = new BMR(70, 175, 25, "Male");
 *     String result = bmr.getResult();
 *     System.out.println("BMR is " + result);
 * </pre>
 *
 * @see ConditionCheck
 */
public class BMR implements ConditionCheck {
    private double weight, height, age, bmrIndex;
    private String sex;
    /**
     * Constructs a {@code BMR} instance with the specified weight, height, age, and sex.
     *
     * @param weight the weight in kilograms
     * @param height the height in centimeters
     * @param age the age in years
     * @param sex the sex of the person ("Male" or "Female")
     */
    public BMR(double weight, double height, double age, String sex) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.sex = sex;
        this.bmrIndex = calculateBMR();
    }
    /**
     * Calculates the BMR based on the provided weight, height, age, and sex.
     *
     * @return the calculated BMR
     */
    private double calculateBMR() {
        if (sex.equalsIgnoreCase("Male")) {
            return (10 * weight) + (6.25 * height) - (5 * age) + 5;
        } else if (sex.equalsIgnoreCase("Female")) {
            return (10 * weight) + (6.25 * height) - (5 * age) - 161;
        } else {
            return 0;
        }
    }

    /**
     * Returns the BMR result as a string.
     *
     * @return a string representing the BMR value
     */    @Override
    public String getResult() {
        return String.format("%.2f", bmrIndex);
    }
}
