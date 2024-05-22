package com.example.healthease;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class BMIUITest {

    @Rule
    public ActivityScenarioRule<BMI> activityActivityScenarioRule = new ActivityScenarioRule<BMI>(BMI.class);
    @Test
    public void test1() {
        onView(ViewMatchers.withId(R.id.edKg)).perform(typeText("50"), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.edFeet)).perform(typeText("5"), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.edIns)).perform(typeText("7"), closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.cardBtn)).perform(ViewActions.click());
        onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("Underweight and BMI index is: 17.26")));
    }
}
