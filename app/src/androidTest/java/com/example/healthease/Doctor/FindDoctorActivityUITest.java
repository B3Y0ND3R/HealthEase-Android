package com.example.healthease.Doctor;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.healthease.FindDoctorActivity;
import com.example.healthease.HomeActivity;
import com.example.healthease.R;

import org.junit.Rule;
import org.junit.Test;

public class FindDoctorActivityUITest {

    @Rule
    public ActivityScenarioRule<FindDoctorActivity> activityActivityScenarioRule = new ActivityScenarioRule<FindDoctorActivity>(FindDoctorActivity.class);
  @Test
    public void test1()
    {
        onView(ViewMatchers.withId(R.id.titleFindDoctor)).check(ViewAssertions.matches(ViewMatchers.withText("24/7 HEALTHCARE")));
        Espresso.onView(withId(R.id.cardFDFamilyPhysician)).check(matches(isDisplayed())).perform(click());
        Espresso.pressBack();
        Espresso.onView(withId(R.id.finddoctorlayout)).check(matches(isDisplayed()));
    }
    @Test
    public void test2()
    {
        onView(ViewMatchers.withId(R.id.titleFindDoctor)).check(ViewAssertions.matches(ViewMatchers.withText("24/7 HEALTHCARE")));
        Espresso.onView(withId(R.id.cardFDCardioloist)).check(matches(isDisplayed())).perform(click());
        Espresso.pressBack();
        Espresso.onView(withId(R.id.finddoctorlayout)).check(matches(isDisplayed()));
    }
    @Test
    public void test3()
    {
        onView(ViewMatchers.withId(R.id.titleFindDoctor)).check(ViewAssertions.matches(ViewMatchers.withText("24/7 HEALTHCARE")));
        Espresso.onView(withId(R.id.cardFDSurgeon)).check(matches(isDisplayed())).perform(click());
        Espresso.pressBack();
        Espresso.onView(withId(R.id.finddoctorlayout)).check(matches(isDisplayed()));
    }
    @Test
    public void test4()
    {
        onView(ViewMatchers.withId(R.id.titleFindDoctor)).check(ViewAssertions.matches(ViewMatchers.withText("24/7 HEALTHCARE")));
        Espresso.onView(withId(R.id.cardFDDentist)).check(matches(isDisplayed())).perform(click());
        Espresso.pressBack();
        Espresso.onView(withId(R.id.finddoctorlayout)).check(matches(isDisplayed()));
    }
    @Test
    public void test5()
    {
        onView(ViewMatchers.withId(R.id.titleFindDoctor)).check(ViewAssertions.matches(ViewMatchers.withText("24/7 HEALTHCARE")));
        Espresso.onView(withId(R.id.cardFDDietician)).check(matches(isDisplayed())).perform(click());
        Espresso.pressBack();
        Espresso.onView(withId(R.id.finddoctorlayout)).check(matches(isDisplayed()));
    }

}
