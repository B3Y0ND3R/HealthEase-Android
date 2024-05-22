package com.example.healthease.Doctor;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.healthease.HomeActivity;
import com.example.healthease.MainActivity;
import com.example.healthease.R;

import org.junit.Rule;
import org.junit.Test;

public class HomeActivityUITest {
    @Rule
    public ActivityScenarioRule<HomeActivity> activityActivityScenarioRule = new ActivityScenarioRule<HomeActivity>(HomeActivity.class);
    @Test
    public void test1()
    {

        onView(withId(R.id.titleHome)).check(matches(ViewMatchers.withText("24x7 HealthCare")));
        Espresso.onView(withId(R.id.cardFindDoctor)).check(matches(isDisplayed())).perform(click());
        Espresso.onView(withId(R.id.finddoctorlayout)).check(matches(isDisplayed()));
        Espresso.pressBack();
        onView(withId(R.id.titleHome)).check(matches(ViewMatchers.withText("24x7 HealthCare")));
        Espresso.onView(withId(R.id.cardFindDoctor)).check(matches(isDisplayed())).perform(click());
        Espresso.onView(withId(R.id.finddoctorlayout)).check(matches(isDisplayed()));

    }
}
