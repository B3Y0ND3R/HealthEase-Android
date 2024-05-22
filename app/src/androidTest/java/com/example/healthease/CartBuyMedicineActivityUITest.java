package com.example.healthease;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class CartBuyMedicineActivityUITest {

    @Rule
    public ActivityScenarioRule<CartBuyMedicineActivity> activityScenarioRule =
            new ActivityScenarioRule<>(CartBuyMedicineActivity.class);

    @Test
    public void verifyTotalCostDisplayed() {
        // Check if the total cost text view displays the correct initial value
        Espresso.onView(ViewMatchers.withId(R.id.textViewBMCartTotalCost))
                .check(matches(withText("Total Cost 498.0")));

        // Perform click on an item in the list view (if available)

        // Perform click on the checkout button
        Espresso.onView(ViewMatchers.withId(R.id.buttonBMCartBack)).perform(ViewActions.click());

//        // Verify if the date button displays the default date (if applicable)
//        Espresso.onView(ViewMatchers.withId(R.id.buttonBMCartDatePicker))
//                .check(matches(withText("Select Date")));
//
//        // Perform click on the date button
//        Espresso.onView(ViewMatchers.withId(R.id.buttonBMCartDatePicker)).perform(ViewActions.click());

        // TODO: Perform additional actions and assertions as needed
    }
}

