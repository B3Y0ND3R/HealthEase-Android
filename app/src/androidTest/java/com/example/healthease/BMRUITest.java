package com.example.healthease;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class BMRUITest {

    @Rule
    public ActivityScenarioRule<BMR> activityActivityScenarioRule = new ActivityScenarioRule<BMR>(BMR.class);


    @Test
    public void test1() {
        onView(ViewMatchers.withId(R.id.edFeet)).perform(typeText("5"), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.edIns)).perform(typeText("6"), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.edKg)).perform(typeText("70"), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.edAge)).perform(typeText("30"), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.male)).perform(ViewActions.click());
        onView(ViewMatchers.withId(R.id.cardBtn)).perform(ViewActions.click());
        onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText("1602.75")));
    }
}
